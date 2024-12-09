# Aufgabe 1
## a)
```java
public final class Vehicle {
    private final int numberOfWheels;
    private final int numberOfSeats;

    // public Vehicle(final int numberOfWheels) {
    // Korrekt:
    public Vehicle(final int numberOfWheels, final int numberOfSeats) {
        this.numberOfWheels = numberOfWheels;
        
        // this.numberOfSeats wurde noch nicht gesetzt. 
        // eine final - Variable kann 1 mal gesetzt werden.
        // this.numberOfSeats ist also nicht unverändlich
        // Korrekt:
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats; // Funktioniert, aber this.numberOfSeats wäre besser
    }

    public int getNumberOfWheels() {
        return numberOfWheels; // Funktioniert, aber this.numberOfWheels wäre besser
    }
}

```

> Eine Klasse oder ein Programm ist semantisch unkorrekt, wenn ihre Implementierung nicht der beabsichtigten Bedeutung, Funktionalität oder den üblichen Erwartungen an das Verhalten entspricht.

Die Klasse ist semantisch unkorrekt, da zwar numberOfSeats deklariert wurde, aber nie im Konstruktor gesetzt wurde.
Das bedeutet zum einen: Die Klasse ist nicht unveränderlich, aber die final-Keywords bei der Attributdeklaration würden dies vermuten lassen.
Außerdem:
die getter-Funktion ruft den Wert einer nicht gesetzten Variable ab ``numberOfSeats``. 
Dies würde zu unerwartetem Verhalten führen: Wahrscheinlich ist numberOfSeats = 0 nicht sinnvoll, in jedem Fall ist dieser Wert nicht das, was der User erwartet oder für diesen sinnvoll ist.

## b)
(i) & (ii) -> Siehe Kommentare in ``Person.java``
- alte (falsche) Zeilen wurden "outcommented", unveränderliche / fehlerfreie Versionen wurden darunter eingefügt.
- Begründungen wurden direkt als Kommentar angegeben.

---

# Aufgabe 2
## a)
- Offensives Programmieren, dabei geht man davon aus, dass die Entwickler des Codes keine Fehler gemacht haben weshalb Vor-/Nachbedingungen und mögliche Fehler 
    nicht aktiv im Code überprüft werden. Diese werden wenn nur als Kommentar erwähnt, spielen jedoch keine Rolle im Programm. Dadurch ist der Code Performanter, aber 
    nur dann korrekt, falls externe Quellen keine Fehler verursachen können (oder es keine gibt) UND der Entwickler ein korrektes Programm geschrieben hat.


- defensives Programmieren bedeutet, dass man aktiv und während der nicht-Debug-Runtime prüft, ob Vor (evtl. auch Nach-) bedingungen erfüllt wurden.
  - ist dann nötig, falls externe Anwender im Programm vorkommen, deren Inputs nicht durch das Programm bzw. vom Programmierer geprüft werden können,
  - also falls Vorverträge möglicherweise nicht erfüllt sein können, obwohl das Programm korrekt ist.
  - Beispiele sind Web-APIs, GUI (Input Felder), Sensormesswerte, etc.
  - Man verwendet if()-Statements um die Vorverträge zu prüfen und wirft einen Fehler, falls eine Vorbedingung nicht erfüllt ist.
  - Nachteile sind Performence-Einbußen

## b)

House: mind eine Hauswand(Housewall)
Housewall:
- kann optonoal eine Türe besitzen, Türe muss zwischen start und end liegen, aber nicht direkt auf start/end
- Position wird über erste(start) und letzte(end) Position des Feldes beschrieben (Tupel) 
- start muss nher am Ursprung sein als end
- mind zwei Felder land, start =/ end

Vorbedingungen immer selber prüfen
Walls 
- Wall Teritory
- HouseWall baitat.house




---


House
- mind. eine HouseWall


HouseWall
- kann aber muss nicht Door enthalten
- beschrieben durch. erste Pos ``start`` und letzte Pos ``end``
- ``start``  liegt näher am Ursprung als ``end``
- mind. zwei Felder lang: start != end
- Door darf nicht auf ersten und nicht auf letztem Feld liegen.

!- HouseWall  != Wall


