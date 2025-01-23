# Aufgabe 1
## a)
i) Consumer<Territory>
ii) BiFunction<int, int, int>
iii) Predicate<Hamster>
iv) Supplier<Territory>
v) Supplier<>
vi) BiFunction<Hamster, List, List>

# Aufgabe 3
## e)
Wir können 
```java
Consumer<Hamster> consumer = (Hamster paule) -> {
paule.move();
this.paule.move();
};
```
nicht hinter 
```java
final Hamster paule = paules.get(0); //paule == gelb
```
Deklarieren, da zu dem Zeitpunkt zwei "paule" existieren und der Compiler nicht weiß welchen er nehmen soll?!