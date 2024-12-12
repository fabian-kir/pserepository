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
![img.png](img.png)

## Konstruktoren
(<=> semantische gesehen auch nur Operationen)

**Deklaration:**
````java
//Konstruktor, Operationsbezeichner muss mit Klassenbezeichner übereinstimmen
public Location (final int row, final int column) {
    ...
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
static //kann vei Attributen und Operationen hinzugefügt werden 
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

![img_1.png](img_1.png)
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
Dies funktioniert mit @Override
Bsp:
````java
abstract class Animal {
    publc abstract Food likes();
}
abstract class Mammal extends Animal
````

