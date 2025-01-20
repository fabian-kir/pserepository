# Aufgabenblatt 11
Mika Hepper - st193543@stud.uni-stuttgart.de - 3787375

Fabian Kirschenmann - st193208@stud.uni-stuttgart.de - 3787773

---

# Aufgabe 1
```mermaid
classDiagram
    Settler <|-- Soldier
    Settler <|-- Miller
    
    Resource <|-- Grain
    Resource <|-- Flour   
    
    Building <|-- Mill
    Building <|-- Barracks
        
    Settler --> "1..* + consumedResource" Resource : consumes >
    Settler --> "0..* + producedResource" Resource : produces >
    Resource --> "1 + type" ResourceType : complies with >

    Miller --> "0..1 + home" Mill : livesIn >
    Soldier --> "0..1 + home" Barracks: livesIn >
    
    
    Mill --> "1 - inhabitant" Miller : isInhabitedBy >
    Barracks --> "1..* - inhabitants \n {unique}" Soldier : isInhabitedBy >
    
    Building " X " --> "1..5 + storedResources" Resource : stores >
    
    Settlement --* "2..n + buildings \n {unique}" Building : consistsOf >
    %% In Siedler ist eine Siedlung direkt an ihre Gebäude gebunden. Wenn eine Siedlung nicht mehr weiter besteht, können die Gebäude auch nicht mehr weiter bestehen.
    %% D.h. Es ist eine Komposition, d.h. Existenz der Gebäuden ist an die Existenz des Settlments gebunden.

    class Settler{
        +name:String
        +position:Position
        +settle()
    }

    class Soldier{
        + fightEnemy(enemy:Settler)
    }
    
    class Miller{
        + grind(grain:Grain):Flour
    }
    
    class Flour{
        
    }

    class Grain{
    }

    class Resource{
        +name:String
        +position:Position
    }

    class ResourceType{
        -label:String
    }
    
    class Building{
        
    }
    
    class Mill{
        
    }
    
    class Barracks {
        
    }
    
    class Settlement {
        
    }
```