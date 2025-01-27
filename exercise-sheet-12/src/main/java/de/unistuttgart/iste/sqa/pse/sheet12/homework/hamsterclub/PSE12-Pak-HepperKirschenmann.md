# Aufgabenblatt 12
Mika Hepper - st193543@stud.uni-stuttgart.de - 3787375

Fabian Kirschenmann - st193208@stud.uni-stuttgart.de - 3787773

---

# Aufgabe 1
## a)

1. Standardfall:
Alle Parameter sind gültig und liegen im erwarteten Bereich.
- territory: ein gültiges, leeres Territorium
- location: (1, 1) innerhalb des Territoriums
- direction: NORTH
- newGrainCount: 0

2. Location liegt außerhalb des Territoriums:
Die Koordinaten sind größer oder kleiner als das Territory erlaubt

- territory: ein gültiges, leeres Territorium, Größe (a, b)
- location: (x, y), wobei x > a und y > b
- direction: NORTH
- newGrainCount: 0

3. GrainCount ist negativ:
Der Grain Count ist kleiner aus 0
- territory: ein gültiges, leeres Territorium
- location: (1, 1) innerhalb des Territoriums
- direction: NORTH
- newGrainCount: -1

4. Direction ist null:
Die Direction des Hamsters invalid.
- territory: ein gültiges, leeres Territorium
- location: (1, 1) innerhalb des Territoriums
- direction: new Location(0, 0);
- newGrainCount: 0

5. Größe des Territory ist falsch:
Das Territory wurde mit einer negativen Größe initialisiert.
- territory: ein ungültiges Territory, wurde mit der größe (x, y) initialisiert, wobei aber x < 0 || y < 0
- location: (1, 1) innerhalb des Territoriums
- direction: NORTH
- newGrainCount: 0

6. Grenzfälle:
Ein Parameter oder mehrere Parameter befinden sich in einem grenzwertigen Zustand.
- territory: ein unendlich großes, leeres Territorium
- location: (MAX_Integer, MAX_Integer) innerhalb des Territoriums
- direction: NORTH
- newGrainCount: MAX_Integer

---

## b)
1. internalHamster.getGrainInMouth() == 0 //Die Operation kann nicht ausgeführt werden, somit wird eine Exception geworden und das Spiel stoppt
2. internalHamster.getGrainInMouth() == 2 //Die Operation kann ausgeführt werden und ein Grain wir abgelegt.
Somit werden die beiden möglichen Fälle der Operation `putGrain` durch diese beiden Testfälle abgedeckt.

---

## d)
i) 
Fall 1 `move()` - Standardfall:
Ausgangszustand: paule ist bei der Location (0,0) und er schaut in Direction East.
nach der Ausführung der Operation move() auf paule sollte paule bei der Location (0,1) stehen.

Fall 2 `move()` - Fehlerfall:
Ausgangszustand von paule ist bei der Location (0,0) und er schaut in Direction East.
Auf dem territory gibt es eine Wand an der Position (0, 1).
Es sollte eine FrontIsBlockedException geworfen werden.



Fall 1 `pickGrain()` - Standardfall:
Ausgangszustand: Der GrainCount ist 0.
nach der Ausführung der Operation pickGrain() sollte der GrainCount 1 betragen.

Fall 2 `pickGrain()` - Fehlerfall:
Ausgangszustand: Der GrainCount ist -1.
Es sollte eine IllegalArgumentException geworfen werden.

# Aufgabe 3
```java
final Zipper zipper1 = new Jumper(); 
final Clothing clothing = new Pants();
final Pants pants = new Shorts();
final Shorts shorts1 = new Shorts();
final Jumper jumper = new Jumper();


final Zipper zipper2 = shorts1; //fehler da shorts kein subtyp von Zipper ist
final Zipper zipper3 = jumper;  //zipper3 = jumper
final Shorts shorts2 = pants;   //shorts2 = shorts

zipper1.close();
clothing.wash();
pants.mend(zipper1); 

shorts1.mend(jumper);
shorts1.mend(shorts1); //fehler, shorts1 ist vom Typ Shorts aber Zipper erwartet
jumper.equals(zipper3);
```