# Aufgabenblatt 06
Mika Hepper - st193543@stud.uni-stuttgart.de - 3787375

Fabian Kirschenmann - st193208@stud.uni-stuttgart.de - 3787773
# Aufgabe 1
## a)
**i**: 
> Paule hat alle Felder, über die er gelaufen ist, außer das direkt vor der Wand, leer gefuttert.

- Ist eine sinnvolle Nachbedingung 

**ii**: 
> Paule hat Körner im Mund.

- Ist keine richtige Nachbedingung da möglicherweise kein einziges Korn auf dem gesamten Pfad liegt.
- In diesem Fall würde Paule keine Körner im Anschluss im Mund haben.


**iii**:
> Alle Felder sind leer.

- Ist auch keine sinnvolle Nachbedingung, denn schließlich könnte wie in i) das Endfeld immernoch ein Korn enthalten.
- Außerdem ist es zu ungenau denn schließlich sind Felder außerhalb des Pfads überhaupt nicht betroffen.

---

## b)
**i**:
> anzahl_Koerner + anzahl_Felder, wenn anzahl_Koerner die Anzahl der bereits aufgehobenen
Körner und anzahl_Felder die Anzahl der bereits betretenen Felder ist.

- Die Schleifeninvariante ist fast richtig.
- Sie gibt an wie oft die Schleife bisher ausgeführt wurde, das sollte man noch dazu schreiben.

**ii**:
> Die Summe aus der Anzahl an Feldern zwischen Paule und der in Paules Blickrichtung
nächsten Wand und der Anzahl aller Körner, die auf diesen Feldern und Paules aktuellem
Feld liegen.

- Der Satz gibt an wie oft die Schleife noch ausführen wird, enthält aber keine Informationen über den konkreten Programmzustand.

**iii**:
> Die Anzahl an Felder**n** zwischen Paule und der in Paules Blickrichtung nächsten Wand.

- Enthält keinerlei konkrete Aussagen über die Schleife, da berücksichtigt werden muss, wie viele Körner auf diesem Pfad liegen.

---

## c)
**i**:
> Die Summe aus der Anzahl der von Paule zurückgelegten Schritte und der Anzahl der von Paule aufgehobenen Körner entspricht der Anzahl der schon ausgeführten Schleifendurchläufe

- Richtig formulierte Invariante. Gibt sehr genau Aufschlüss über den Zusammenhang zwischen den verschiedenen Daten.

**ii**:
> Auf den Feldern von Paules Startposition bis zum Feld direkt hinter Paules aktueller Position befinden sich keine Körner.

- Das ist eine Aussage deren Wahrheitswert von den gegebenen Daten des Programms abhängt und keinen Aufschluss über den Zustand der Schleife gibt.

**iii**:
> Angenommen, i sei die Anzahl der schon ausgeführten Schleifendurchläufe, dann hat sich Paule schon i Felder bewegt und i Körner aufgehoben.

- Doppeldeutig, da nicht klar ist, ob die Schleife dann schon 2i-oft ausgeführt wurde, und Paule somit angeblich i Körner aufgehoben und noch dazu i Schritte gelaufen wäre oder nicht.
- Schlecht formuliert, ggf. falsch, aber auf jeden Fall nicht hilfreich.

---

# Aufgabe 2
## a)
**i**:
0. Es wird eine Funktion definiert 'walkDiagonalAndPutGrain':
    0.1. Eine Durchlaufschleife mit anschließender Prüfung ob Paule vor einer Wand steht
   - Paule dreht sich zu seiner Rechten (3x turnLeft();)
   - Paule macht einen Schritt
   - Paule dreht sich zu seiner Linken (turnLeft();)
   - Paule macht einen Schritt
   - Paule legt ein Korn ab

0. Es wird eine Funktion definiert 'turnToDirection' mit dem Parameter 'direction' vom Typ Direction
    0.2 Eine Abweisschleife um Paule in vorgegeben Richtung (Direction direction) zu drehen
   - Paule dreht sich zu seiner Linken (turnLeft();)

1. Paule legt ein Korn auf seinem Startfeld ab
2. Die Funktion `turnToDirection` mit dem Argument `Direction.NORTH` wird ausgeführt, wodurch Paule nach Norden schaut
3. Die Funktion `walkDiagonalAndPutGrain` wird ausgeführt, wodurch Paule in Nord-Östliche-Richtung Diagonal über das Spielfeld läuft und auf jedem Feld ein Korn ablegt, bis er in der gegenüberliegenden Ecke angekommen ist
4. Die Funktion `turnToDirection` mit dem Argument `Direction.WEST` wird ausgeführt, wodurch Paule nach Westen schaut
5. Durch eine Abweisschleife wird sichergestellt, dass Paule bis zur nächsten Wand läuft
6. Paule legt ein Korn auf dem Eckfeld des Territoriums ab
6. Die Funktion `turnToDirection` mit dem Argument `Direction.EAST` wird ausgeführt, wodurch Paule nach Osten schaut
7. Die Funktion `walkDiagonalAndPutGrain` wird ausgeführt, wodurch Paule in Süd-Westliche-Richtung Diagonal über das Spielfeld läuft und auf jedem Feld ein Korn ablegt, bis er in der gegenüberliegenden Ecke angekommen ist
8. Paule ist in der letzten Ecke des Spielfelds angekommen, ist fertig und sagt `DONE`


## b)
**i**:
0. Es wird eine Funktion definiert 'turnRight' durch die Paule sich 3x nach links dreht.
0. Es wird eine Funktion definiert 'walkCornerAndPutGrains' mit dem Parameter pathLength
    2x:
        Paule läuft eine gerade Linie gemäß pathLength, legt auf jedem Tile ein Grain ab.
        Paule dreht sich nach rechts.

1. Paule läuft nach Norden bis zur Wand, legt auf jedem Tile ein Grain ab und
        _zählt die Anzahl der Tiles, über die er läuft, um die pathLength zu ermitteln_

2. solange die pathLength > 0 bleibt, passiert folgendes (Abweisschleife)
    - walkCornerAndPutGrains(pathLength); wird ausgeführt.
    - pathLength -= 2;
3. Paule legt auf dem Endfeld ein letztes Grain ab, SCHREIT `LETS GOOOOOOOOO` und ist fertig

> Korrekturanmerkung: Es wäre natürlich besser, turnRight als eine Hamster-Methode zu definieren, so wie es auch bei turnLeft ist. 

---

## Aufgabe 3

Paule dreht sich ständig um zu prüfen wo genau sich Wände befinden. Er folgt stets der rechten Wand um ans Ende des Maze zu gelangen.
Falls ein Grain Available ist, pickt Paule dieses. Die Do-While-Schleife (Durchlaufschleife) endet, wenn paule eine Grain im Mund hat.