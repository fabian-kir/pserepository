# Aufgabenblatt 06
Mika Hepper - - 
Fabian Kirschenmann - st193208@stud.uni-stuttgart.de - 3787773

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

