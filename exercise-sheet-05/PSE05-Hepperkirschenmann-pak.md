# Aufgabe 1
## a)
- Wenn Paule den Sonnenaufgang beobachtet, schaut er nach Osten und steht vor keiner Wand
- Entweder Paule blickt nach Osten und steht nicht vor einer Wand oder Paule kann den Sonnenaufgang nicht beobachten
---

## b)
![img.png](img.png)

## c)
```java 
    if (paule.canViewSunrise()) {
        paule.direction = DIRECTION.East;
        paule.frontIsClear = True;
    }
```

# Aufgabe 2
## a)
strikte Boolesche Operatoren überprüfen immer beide Bedingungen, selbst wenn es 'gar nicht nötig' wäre.
Im und-Fall kann der Vergleich gar nicht mehr einen wahr-Wert annehmen, falls der 1. Ausdruck falsch ist, da beide Seiten wahr sein müssten. 
Es ist somit also unnötig die 2. Seite noch zu prüfen. 
Somit kann man 1. Fehler vermeiden (Vorlesungsbeispiel 1/x), aber auch effizienteren Code schreiben.
Die Semistrikten Operationen in Java prüfen also nur dann die 2. Seite, falls nötig, was Ressourcen schonen kann.
und: 2. Seite wird nur geprüft, falls 1. Seite wahr
oder: 2. Seite wird nur geprüft, falls 1. Seite falsch
```java
/*
        ...
 */
    void moveNorthIfPossible() {
        if (this.getDirection() == Direction.NORTH && this.frontIsClear() ) {
            this.move();
        }
    }
    // Wenn && ein strikter Boolescher Operant wäre und die Direction nicht North wäre, dann würde trotzdem geprüft werden,
    // ob frontIsClear. Da wäre überflüssig, da die Operation eh nicht ausgeführt werden könnte. Somit brauchen wie einen semistrikten Operant.
```
## b)
i. 
- E1 kann ausgewertet werden und gibt den Wahrheitswert false zurück.
- E2 Fehler, kann nicht ausgwertet werden.
- E3 Fehler, da (ham.grainAvailable() && ham.frontIsClear()) einen Fehler gibt (NullReference)
ii. 
- E1 kann ausgewertet werden und gibt den Wahrheitswert false zurück.
- E2 Fehler, kann nicht ausgwertet werden.
- E3 kann ausgwertet werden. Wird zu ``True == False``, al**a**o wird False ausgegeben als Wahrheitswert.

# c)
In E3 
```java
    ham == null || (ham.grainAvailable() && ham.frontIsClear()) == false
        // -->
    !(ham == null || ham.grainAvailable()) && ( (ham == null || ham.frontIsClear()) 
```

# Aufgabe 3)

## a)

i. Invarianten:
- Das Objekt ist initialisiert
- Der Grain Count ist nicht kleiner als (- maximumOverdraft)







https://www.jetbrains.com/remote-development/gateway/