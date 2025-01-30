# Aufgabe 1
## a)


| x | y | Ausgabe |
| 1 | 1 |       2 |
| 0 | 0 |       0 |
| 1 | -1 |       0 |
| -1 | 2 |       1 |
| Integer.MAX_VALUE | 1 |       Exception |

---

## c)

- b == 0 -> DivisionByZeroError
- a == 0 -> 0
- b == 1 -> a 
- a * b < 0 -> int < 0
- a * b > 0 -> int > 0 
- a || b > Integer.MAX_VALUE oder a || b < Integer.MIN_VALUE -> OutOfBoundException

---

## d)

---

# 2)
## a)
- 6: '?' wird als IfElse-OneLiner Interpretiert, also Fehler beim Syntax-Baum-Bau
- 12: 'constructor' wird als Bezeichner anerkannt, dann kann der Parser nichts mehr mit PandaZoo anfangen.
- 25: Programm ist unkorrekt: Hier soll Panda hinzugefügt werden, eine IllegalArgumentException macht hier keinen Sinn. dynamisch semantisch eventuell, da unerwartetes Verhalten.
- 28: Gibt immer true zurück, sollte false zurück geben falls etwas schiefging bzw. sollte eigentlich gar nichts zurückgegeben weil es schlechter Stil ist, und stattdessen Exceptions werfen.
- 34: lexikalischer Fehler: Bezeichner beginnt mit einer Zahl
- 36: Stilfehler 'element' is schlechter Bezeichner
- 38: Stilfehler: Leerzeichen nach .
- 39: statisch Semantischer Fehler: Methode gibt ein Set zurück erwartet wird aber eine Liste
- 46: Syntaxfehler: Java erhält einen Moduloperator statt einem Bezeichner, wodurch kein Syntaxbaum gebaut werden kann.
- 49: Statisch Semantisch: .get kann nicht auf einem Set verwendet werden.
- 49: Syntaxfehler: Java erwartet hier ein Argument vom Typ Bamboo.
- 59: Stilfehler: sum sollte auf Standardwert 0 gesetzt werden.
- 60: Syntaxfehler: es fehlt eine geschweifte Klammer hinter der for-Schleife
- 60: die Zweite Klammer-Instruktion ist leer: Syntaxfehler
- 61: statisch Semantisch: .get auf einem set
- 62: Stilfehler: getWeight() returned immer einen double, hier wird auf int gecastet, obwohl dieser cast hier keinen Sinn macht, da man weiterhin das genaue Gesamtgewicht wissen wollen würde
-