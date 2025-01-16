# Aufgabe 1

## b)
Klassendiagramme

--- 
## c) 
- Strukturenorientierte Diagramme beziehen sich auf die Verteilung der Software auf die Hardware (Klassen Diagramm)
- Verhaltensorientierte Diagramme beziehen sich nur auf die Funktion der Software und was diese macht (Sequenzen Diagramm)
---
## d)
- Aggregation: Eine Aggregation beschreibt die Zusammensetzung von Objekten zu einem zusammengesetztem Objekt. Also z.B. die Klasse Tisch, welche aus den Klassen Beinen und Platte besteht.
- Komposition: Eine Komposition ist eine bestimmte Aggregation, bei der die Existenz der Teile von der Existenz des Ganzen Abhängt. (z.B. Klasse Haus besteht aus Stockerken und Wänden, diese Existieren aber nur, wenn auch die Klasse Haus existiert)

---
## e) 
```mermaid
classDiagram
    namespace PummelmonFly {
        
    class Researcher {
        +String name
        +int XP
    }
    
    class FlyDex {
    }

    class FighterFlys {
        +String name
        +int speed
    }
    class DickeBrummer {
        
    }

    class SpeedFlys{
        
    }
    
    class MediCopter {
        
    }
    
    class Attack {
        +String name
        +int damage
    }
    
    class Arena {
        +fight() : void
    }
    
    class Reward {
    }
    }

    Researcher "1 -researcher"--"1 -flydex" FlyDex : has>
    Researcher"1 -researcher" --"0..5 -flies{unique}" FighterFlys : has>
    Researcher"1 -attacker" --"1 -arena" Arena : fights in >
    Researcher"1 -defender" --"1 -arena" Arena : fights in >
    Arena"1 -arena" --"1 -prize" Reward : has>
    FighterFlys <|-- DickeBrummer
    FighterFlys <|-- SpeedFlys
    FighterFlys <|-- MediCopter
    FlyDex "X"--"0..* -flies{unique}" FighterFlys : is listed in >
    Attack "1 -attack"--"1 -fly" FighterFlys : has>
    


```