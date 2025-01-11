# Vorlesung 12 Java Klassen erstellen

## Abstraktion durch Funktionale Dekomposition
Datenabstraktion: Klassen
- Operationen (müssen "klein" sein, bis zu ca. 10 Zeilen -> Vor-/Nachbedingungen bleiben klein und Überschaulich, wenn zu Groß zerlegen in mehrere Operationen)
- Objektvariablen

Algorithmusabstraktion: Routinen -> Methoden
- (Bottom-Up: Erfassen von exist. Algorithmen, womöglich zur Wiederverwendung
Top-Down: Platzhalterroutinen)
- Prozeduren: Liefern kein Ergebnis (=Kommando), Aufrufe sind Instruktionen ```void doSomething(...) ```
- Funktionen: Liefern einen Ergebniswert (=Abfrage), Aufrufe sind Ausdrücke, ```ReturnType f(...) ```

**Klassenelemente**

<img alt="img.png" height="200" src="img.png" width="300"/>

## Konstruktoren
(<=> semantische gesehen auch nur Operationen)

**Deklaration:**
````java
//Konstruktor, Operationsbezeichner muss mit Klassenbezeichner übereinstimmen
public Location (final int row, final int column) {
    
}
//Aufruf eines Konstruktors
Location loc = new Location(0,0);
````
Wdh.: 
- Klasseninvarianten sind Bedingungen, die zwischen beliebigen Operationsausführung auf den Objekten der Klasse gelten müssen. (=Nachbedingung der Konstruktoren)
- Nachbedingung ist eine Bedingung, die einer Operation für eine korrekte Realisierung durch den Anbieter auferlegt ist.

## Prinzip des Gleichförmigen Zugriffs (UAP)
- Für den Aufrufer sollte es keine Rolle spielen, ob ein Ergebnis durch Berechnung oder Speicherzugriff bestimmt wird.
- Technisch ausgedrückt: Abfragen sollen dem Aufrufer immer gleich zur Verfügung gestellt werden: Unabhängig, ob der Wert durch Speicherzugriff oder Berechnung bestimmt wird. (Speicherverbrauch vs. Performance)
- also wenn dann in der Methode direkt ausrechnen oder auf ein Attribut verweisen, welches dauerhaft den Wert bei jeder änderung ausrechnet
````java
Integer getRectangleArea() {
    return area;
}
// vs.
Integer getRectangleArea() {
    return width * height;
}
````

## Zugriffskontrolle
(Sichtbarkeiten)
Wichtig, um kontrollieren zu können, elche Aufrufer was dürfen.

Am meisten zugreifbar bis zu am wenigsten zugreifbar:
- public (Nutzbar von überall)
- protected (Nutzbar innerhalb von Klassen im selben Package und in Unterklassen)
- default (Nutzbar aus Klassen innerhalb desselben Packages)
- private (Nutzbar innerhalb des Klassenrumpfs)

=> Immer so *restriktiv* wie möglich Sichtbarkeiten realisieren

## Defensives und Offensives Programmieren
- Defensives Programmieren:
  - Explizite Prüfung der Bedingungen. Bei Nichterfüllung wird eine Ausnahme geworfen und der Zustand nicht geändert.
  - wird für alle Programmteile benutzt, die durch Dritte zugänglich sind, z.B. public Operationen.
````java 
  public void storeName(final String name) {
    if (name == nul || name.isEmpty()) { // es wird explizit geschaut, ob die Bedingungen erfüllt sind und falls nicht, wird eine Exception geworfen.
        throw new IllegalArgumentException("Employee name must not be null/empty");
    }
    internalStore(name);
}
  ````
- Offensives Programmieren: 
  - Bedingungen werden mittels assert zur Entwicklungszeit und zur Produktionszeit deaktiviert.
  - wird für alle internen Operationen eingesetzt
  - assert-Anweisungen werden normalerweise *nicht* ausgeführt. Um asser-Anweisungen auszuführen, muss die JVN (Java Virtual Machine) mit der Option -ea gestartet werden.
````java
private void internalStore(final String name) {
    assert name != null && !name.isEmpty(); //wird nicht ausgeführt, kann aber durch -ea ausgeführt werden (im Compiler)
    db.storeEmployeeName(name);
    -ea 
}
 ````
## statische Klassenelemente
Problem: In einigen Fällen wollen wir z.B. Variablen mit allen Instanzen der Klasse teilen. (Zähle alle Hamster, die wir bislang instanziiert haben)

**Statische Attribute** liegen in einem Speicherbereich, der bei der Definition der Klasse angelegt wird. 
````java 
static //kann bei Attributen und Operationen hinzugefügt werden 
static int hamsterCount;//existiert genau einmal pro Klassendefinition in der VM(Virtual Machine), geteilt unter allen Instanzen der definierten Klasse, sollte nicht über this zugegriffen werden, sondern hamsterCount
static int getHamsterCount() { //Klassenoperation
    return hamsterCount;
}
static { //statischer Konstruktor, nur 1 mal por Klasse, keine Parameter, kann nur auf andere static Elemente der Klasse zugreifen, keine this-Reference
    hamsterCount = 0;
}
````
Sollen in PSE NICHT benutzt werden (sind nicht thread-sicher, können als globale Variable ausgenutzt werden)


# Vorlesung 14 & 15 Objektorientierte Programmierung (OOP)
## Grundlagen der Vererbung
Vererbung erlaubt es Programmierern, Klassen zu erstellen, die auf existierenden Klassen basieren, eine neue Realisierung zu spezifizieren, während das Verhalten beibehalten wird, um Cod wiederzuverwenden und um die ursprüngliche Software durch öffentliche Klassen und Schnittstellen zu erweitern.
 - In Java durch ``extends``
 - kann auf protected und public Operationen und Attribute zugegriffen werden
 - können protected und public Operationen überschrieben werden
 - möchte man auf Operationen der Elternklasse zugreifen geht dies durch ``super``, bezeichnet immer die nächsthöhere Elternklasse

<img alt="img_1.png" height="200" src="img_1.png" width="300"/>

- Alle Tiere(direkte Nachkommen) sind vom Typ Pet(direkter Vorfahre)
- Racoon und FluffyRacoon sind vom Typ Racoon
- Racoon ist direkter Vorfahre von Fully Racoon

**Nichtvererbbare Bestandteile**
- Konstruktoren
- private Attribute 
können nicht vererbt werden, nur wenn in Elternklasse setter-Operation existiert

## abstract
Problem: Zwei verschiedene "Tiere" z.B. besitzen beide Operation ``makeNoise()``, Operationsname gleich, Effekt jedoch unterschiedlich

Ziel: ``makeNoise()`` extrahieren ohne eine Basisimplementierung zu geben
- Abstrakte Operationen bieten keine Implementierung
- Abstrakte Klassen und Operationen werden durch das Schlüsselwort ``abstract`` gekennzeichnet, Klasse abstrakt, sobald mind. eine abstrakte Operation enthält
- Es kann keine Instanz(Objekt) von abstrakten Klassen erstellt werden

````java
public abstract class Pet { //new Pet() ist nicht erlaubt da Klasse abstract ist(statisch-semantischer Fehler)
    private String name;
    public String getName() {
        return name;
    }
    public abstract void makeNoise(); //darf nicht private sein und besitzt keinen Operationsrumpf
}
````

## Implementieren von abstrakten Operationen
abstract Operationen müssen in Kind klassen implementiert werden.
Dies funktioniert mit @Override (Überschreibe die spezifizierten Methoden)
Bsp:
```java
abstract class Animal {
    public abstract Food likes();
}
abstract class Mammal extends Animal {
    public abstract int pregnantFor();
}
public class Hamster extends Mammal {
    @Override //informiert den Compiler, dass diese Operation eine spezifizierte, geerbte Operation implementiert (@Override bei nicht-überschriebenen Operationen sind statisch-semantische Fehler)
    public int pregnantFor() {  return 30; }
  
    @Override
    public Food likes() {
        return Food.GRAIN;
    }
}
```
## Überschreiben von existierenden Operationen

Wenn eine Implementierung einer Operation der Elternklasse schon existiert, aber in der Kindklasse zweckmäßiger implementiert werden könnte, wird Überschrieben

````java
//Bsp, oben fortgesetzt:
public class Hamster {
   @Override
    public String toString() {
    return "Hamster [pregnantFor()=" + pregnantFor() + ", Likes()=" + likes() + "]";
  }
  //Überschreibt (redefiniert/ersetzt) die Standartimplementierung, die von Object geerbt wird (toString)
}
````
final (unveränderliche) Klassen können nicht überschrieben werden

## Record-Typen erweiterung
- Dürfen keine anderen Klassen erweitern (extends), da jeder Record-Typ von der abstrakten Klasse Record erbt.
- können Methoden überschreiben und überladene Konstruktoren haben

## Polymorphie
- Problem: Wollen Algorithmen anwendbar auf allgemeine Typen von Objekten und spezialisierte Typen miteinbeziehen. (printPreferredFood() Operation, die die bevorzugte Nahrung für jede Art von Tier ausgibt)
- Lösung:
  - Operation muss in "Animal" (Elternklasse) platziert werden
  - Ausführung muss spezifische Nahrungsvorlieben des tatsächlichen "Animal"-Objekts in Betracht ziehen
    -> Führe eine Operation von einem spezifischen "Animal" aus (Dynamische Bindung)

**Definition: Polymorphie**
````
Eine Bindung (auch bei Zuweisung oder Argumentenübergabe) ist polymorph,
wenn Zielvariable und Quelleausdruck von unterschiedlichem Typ sind.

Eine Entität oder ein Ausdruck sind polymorph, wenn sie zur Laufzeit an unterschiedlichen Typs gebunden werden (als Resultat einer polymorphen Bindung)

Polymorphie ist die Existenz dieser Möglichkeit in einer Porgammiersprache
````

(= wenn Elternklasse Animal ist, können wir einem neun Pet(von Animal) auch einen Hamster zuweisen (anderer Typ), da Hamster von Animal erbt(geeigneter Nachkomme, ist auch ein Tier))
Bsp. wäre, z.b. man erstellt ein neues Tier und schaut ob man einen Hund oder eine Katze will, und jenachdem weist man diesem neuen Tier dann eine schon existierende Katze oder Hund zu.
````java
public class AnimalTest extends Animal {
    void Test(boolean wantDog) { // Das Tier soll also ein Hund sein
        final Dog waldi = new Dog();
        final Cat mau = new Cat();
        Animal pet;
        
        if (wantDog) {
            pet = waldi; //Polymorph, da Typen unterschiedlich sind, geht da Dog Nachkommender Typ von Animal ist
        } else pet = mau;
    } //Der dynamische Typ von pet hängt jetzt also von dem boolean ab
}
````

**Definition: Statische und dynamische Typen**
````
Der statische Typ einer Entität ist der Typ, 
der in iherer Deklaration in dem zugehörigen Klassntext steht 
(Animal pet; //pet vom statischen Typ Animal
 Hamster paule; //paule vom statischen typ Hamster)

Der dynamische Typ einer Entität ist der Typ des (Laufzeit-)Objekts, 
Wenn der Wert einer Entität während einer Ausführung an ein Objekt gebunden wird.
Der dynamische Typ einer Entität MUSS immer ohrem statischen Typ konform sein(ein Nachfahre)
(pet = paule; //dynamischer Typ von pet ist Hamster(bis zur nächsten Zuweisung))
````
**Definition: Dynamisches Binden**
````
Dynamisches Binden (Semantikregel:)
Jede Ausführung eines Operationsausfrufs wird die Version der operation verwenden, 
die dem dynamischen Typ des Zielpobjekt am besten angepasst(die Spezialisieteste) ist.
Man muss also nicht durch 1000de if-abfragen schauen, welcher Typ aktuell zugewiesen ist.
````
## Überladen vs. Überschreiben von Operationen
Häufig will man mehrere Operationen (unterschiedliche Argumenttypen und anzahlen),
die alle dasselbe Verhalten realisieren

Überladen von Operationen, Operatoren mit gleichem Namen aber untersch. werden vom Compiler als unterschiedliche Operationen behandelt.

## Vererbung und Verkettung von Konstruktoren
Wenn eine Kindklasse instanziiert wird, müssen Klasseninvarianten auch für die Elternklassen aufgstellet werden (da die Kindklasse die Attribute und das Verhalten der Elternklassen erbt.)

**Konstruktorenverkettung**
Konstruktoren werden grundsätzlich nicht an die Kindklasse vererbt. 
Sie können jedoch (müssen sogar manchmal) aufgerufen werden.
- Eigenschaften:
  - Verwende super(), um einen der Konstruktoren der Elternklasse aufzurufen (muss der erste Ausdruck des Konstruktors sein)
  - Falls kein Standardkonstruktor in der Elternklasse vorhanden ist, muss der Aufruf explizit erfolgen.
  - super-Aufrufe können überladene Aufrufe sein.

````java
public class Hamster {
    public Hamster() {
        super(); //könnte weggelassen werden, da in  diesem Fall Elternklasse Object ist
        this.interanHamsterTerritory.GameHamster; //irgendein BSP:.
    }
    
    public Hamster(final Territory territory, final Location location, final Direction direction, final Graincount graincount) {
        this(); //Aufruf des Konstruktors weiter oben
        init(territory, location, direction, graincount);
    }
}
````
## Super-Zugriff
- Durch "super.method()" können wir den Code von überschriebenen Operationen wiederverwenden
- z.b. irgendeine Unterklasse, die aber auch moven soll, wie die Elternklasse: super.move();

## Korrektheit: Verträge und Vererbung
**Klasseninvarianten:**
Die Invariante einer Klasse beinhaltet automatisch die Invarianten all ihrer Elternklassen, "und"-verknüpft

**Neudeklaration von Zusicherungen**
Wenn eine Operation neu deklariert wird, dürfen wir:
- Die Vorbedingung beibehalten oder abschwächen
- Die Nachbedingung beibehalten oder verstärken

## Mehrfachvererbung
<img alt="img_2.png" height="200" src="img_2.png" width="300"/>

Problem: Mehrfachvererbung verursacht Probleme bzgl. des Modulblickpunkts der Vererbung

Lösung: 
1. Modul Mechanik, Vererbung über extends auf eine Elternklasse beschränkt
2. Typ Mechanik, Vererbung von Interfaces erlaubt 0.. viele Elterninterfaces über das implements Keyword.

## Komposition vor Vererbung
Durch extends kann es ein Problem geben, wenn z.b. 3 versch. Köche von Koch erben.
Dann kann es eben nur einen Souschef geben, außerdem kann der Souschef seine Aufgabe nicht so einfac zu Headchef wechseln.

Also wird implements anstatt extends benutzt:

<img alt="img_3.png" height="200" src="img_3.png" width="300"/>

<img alt="img_4.png" height="200" src="img_4.png" width="300"/>


# Vorlesung 16 & 17 Collection-Datenstrukturen
test