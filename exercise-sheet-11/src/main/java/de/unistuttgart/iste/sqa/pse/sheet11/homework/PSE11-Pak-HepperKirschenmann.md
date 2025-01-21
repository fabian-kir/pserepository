# Aufgabenblatt 11
Mika Hepper - st193543@stud.uni-stuttgart.de - 3787375

Fabian Kirschenmann - st193208@stud.uni-stuttgart.de - 3787773

---

# Aufgabe 1
```mermaid
classDiagram
    Settler <|-- Soldier
    Settler <|-- Miller
    
    Resource <|-- Grain
    Resource <|-- Flour   
    
    Building <|-- Mill
    Building <|-- Barracks
        
    Settler --> "1..* + consumedResource" Resource : consumes >
    Settler --> "0..* + producedResource" Resource : produces >
    Resource --> "1 + type" ResourceType : complies with >

    Miller --> "0..1 + home" Mill : livesIn >
    Soldier --> "0..1 + home" Barracks: livesIn >
    
    Mill --> "1 - inhabitant" Miller : isInhabitedBy >
    Barracks --> "1..* - inhabitants \n {unique}" Soldier : isInhabitedBy >
    
    Building " X " --> "1..5 + storedResources" Resource : stores >
    
    Settlement --* "2..n + buildings \n {unique}" Building : consistsOf >
    %% In Siedler ist eine Siedlung direkt an ihre Gebäude gebunden. Wenn eine Siedlung nicht mehr weiter besteht, können die Gebäude auch nicht mehr weiter bestehen.
    %% D.h. Es ist eine Komposition, d.h. Existenz der Gebäuden ist an die Existenz des Settlments gebunden.

    class Settler{
        +name:String
        +position:Position
        +settle()
    }

    class Soldier{
        + fightEnemy(enemy:Settler)
    }
    
    class Miller{
        + grind(grain:Grain):Flour
    }
    
    class Flour{
        
    }

    class Grain{
    }

    class Resource{
        +name:String
        +position:Position
    }

    class ResourceType{
        -label:String
    }
    
    class Building{
        
    }
    
    class Mill{
        
    }
    
    class Barracks {
        
    }
    
    class Settlement {
        
    }
```

---

# Aufgabe 2
## a)
Das Programm erwartet einen Input über die Konsole.
Der Input soll ein Datum sein der Reihenfolge "Jahr", "Monat", "Tag" 
Das Programm unterscheidet zwischen verschiedenen Formaten, die Zahlen können getrennt werden durch:
    - '-'
    - '/'
    - '.'
Das Programm nutzt dann die Calendar-API, um den Wochentag dieses Datums zu ermitteln, und gibt diesen in die Konsole aus.

Beispieleingaben:
```Commandline
 > 2005-04-16 
 // -> Saturday
 > 2025/01/01 
 // -> Wednesday 
```

---

## b)

```Commandline
 > 2005.04.16
 // -> Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
	at exercise/de.unistuttgart.iste.sqa.pse.sheet11.homework.cleancode.SomethingWithCalendars.main(SomethingWithCalendars.java:30)
```

Die Split-Funktion erwartet einen Regex-Ausdruck. Dieser ist falsch, denn
in RegEx wird der Punkt als Spezialsymbol angesehen, dadurch funktioniert der split nicht wie erwartet.
Deshalb ist die übergebene Liste auch falsch und dadurch kann am Ende die Kalender API die Liste nicht in ein korrektes Datum umwandeln.

---

## c)
 - Man sollte eine neue Methode erstellen `getWeekdayFromString()` und damit den langen Code in Einzelaufgaben zerteilen.
 - Die if-elif-else Verzweigung hat keine `else`-Klausel, die falsche User-Eingaben verarbeiten sollte.
 - Die Variablen wurden schlecht benannt. `'fs'` ist kaum Aussagekräftig, genauso wie `'cal'`, `'wd'`

---

# Aufgabe 3)

```mermaid
classDiagram
    Bar <|.. Foo
    Foo <|-- Quaz

    class Bix{
    
    }

    class Foo ["Foo"] {
    
    }   
    <<abstract>> Foo

    class Quaz {
    
    }

    class Bar ["Bar"] {
    
    }
    <<interface>> Bar
```