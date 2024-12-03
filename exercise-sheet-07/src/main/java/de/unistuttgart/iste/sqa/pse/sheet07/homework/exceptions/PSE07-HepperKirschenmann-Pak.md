# Aufgabenblatt 07
Mika Hepper - st193543@stud.uni-stuttgart.de - 3787375

Fabian Kirschenmann - st193208@stud.uni-stuttgart.de - 3787773

---

# Aufgabe 1
## a)
primitive Variablen benötigen keinen Heap-Speicherplatz, da die Daten im Stack existieren.
Dadurch müssen auch keine Referenzen auf Heap-Speicherorte gespeichert werden. Das macht primitive Variablen 
schneller und effizienter. Primitive Datentypen sind Wertetypen. Der Laufzeitwert ist also direkt beispielsweise die entsprechende Zahl.

Referenzvariablen hingegen speichern die entpsrechende Referenz, die den Speicherort im Heap beschreibt.

Manchen Bibliotheken können nur mit Objekten, aber nicht mit primitven Werten umgehen,
daher verwendet man Wrapper Klassen. Der Kompiler konvertiert implizit in den entsprechenden Datentyp, je nachdem was das Programm verlangt. (auto boxing, auto unboxing)

Wrapper Objekte sind dabei unveränderlich und alle primitiven Datentypen haben passende Wrapper-Klassen.

---

## b)

```java
paule // Objekt vom Typ Hamster, Hamster paule = new Hamster(game.getTerritory, new Location(1,1), Direction.EAST, 0);
Long.valueOf(24756) // Wrapper des primitiven long mit dem Wert 24756
paule.frontIsClear() | | paule.grainAvaiable() // boolean, true
5 − 3.5f // float, 1.5f 
false != !false // boolean, true
"The size of the territory is " + 3 + 'x' + 3 + '!' // String (Objektvariable), "The size of the territory is 3x3!"
paule.getLocation() // Objekt vom Typ Location, mit this.row==1, this.column==1
paule.getLocation().getColumn() + paule.getLocation().getRow() // primitiverInteger mit dem Wert 2
Integer.MAX_VALUE // Wrapper des primitiven int also Typ Integer, Größtmöglicher Wert der in einem int gespeichert werden kann - 2147483647
```

---

## c)
 // TODO: in der Übung Fragen
 

---

# Aufage 2
## a)
Ein Programm kann sich nicht wie erwartet verhalten. Beispielsweise könnten Vor- oder Nachbedingungen oder Invarianten nicht erfüllt sein.
Diese Fehler sind Erwartbar und können dem Aufrufer mitteilen, dass er Beispielsweise vor dem Aufruf nicht die Vorbedingungen erfüllt hat (Defensives Programmieren).
Solche Fehler werden in der Operationsdeklaration angegeben und müssen vom Aufrufer entsprechend weitergeworfen oder verarbeitet werden.
Es gibt außerdem noch Fehler, die niemals erwartet werden können, sog. Error. Ein Beispiel ist der OutOfMemoryError bei dem das Programm mehr Speicherplatz benötigt, als es die Hardware oder Systembeschränkungen zulassen.
Solche Fehler werden in aller Regel nicht weitergeworfen, da ein korrigieren des Systemzustands und eine Rückkehr zu einem gewünschten Zustand unmöglich wird.
Als letztes gibt es sog. RuntimeExceptions. Diese sind unchecked, also werden nicht im Operationskopf deklariert und treten somit dynamisch auf.
Es ist i.d.R. schwer diese korrekt zu verarbeiten und sie weisen oft auf logische Fehler hin, wie das Teilen durch 0 oder der Versuch einen immutable-Typ zu modifizieren.
RuntimeExceptions treten in einem korrekten Programm nicht auf.

- try
- throw
- catch
- finally 

---

## b)
Checked Exceptions sind Exceptions die während der Kompilierung geprüft werden. Die checked Exception **muss** in der jeweiligen Methode
selbst mit try and catch behandelt werden oder die Exception muss mit einems bestimmten Namen geworfen werden.

Checked Exceptions entstehen in aller Regel durch Fehler außerhalb der Kontrolle des Programms, also durch beispielsweise den Speicherort, andere Bibliotheken oder Interfaces die beispielsweise Daten aus dem Internet abrufen.
Wenn eine Operation eine Exception deklariert, so müssen alle Aufrufer diese Exception durch try-catch handlen oder durch throw weiterwerfen.
Diese Exceptions können während der CompileTime ermittelt werden (aber nicht immer).

Unchecked Exceptions sind Exceptions welche nicht während der Kompilierung geprüft werden, sondern während der Runtime. Somit müssen 
diese Exceptions nicht notwendigerweise gecatched oder geworfen werden, es steht dem Programmierer frei dies zu tun.
In der Regel ist es auch schwer diese zu catchen, da diese oft tief im Programm entstehen und die Möglichkeit, dass diese geworfen werden können nicht explizit erwähnt werden.
Außerdem verwendet man RuntimeExceptions in der Regel um auf beispielsweise logische Fehler hinzuweisen, sie deuten also auf ein unkorrektes Programm hin.
In Java besitzt die Klasse der Unchecked Exceptions nur die Typen Error und RuntimeExceptions.

Error können nicht gecatcht werden. Nach einem Error ist eine korrekte Fortsetzung des Programms nicht mehr möglich. Es kann nicht zu einem korrekten Programmzustand zurückgekehrt werden.
Errors sorgen daher immer für den Absturz des Programms und ein vorzeitiges Programmende.

---

# Aufgabe 3
## a)
- FrontBlockedExceptions
- MouthEmptyException
## b) 
