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
    Settler --> "0..* + producedresource" Resource : produces >
    Resource --> "1 + type" ResourceType : complies with >

    Miller --> "1..1 + home" Mill : livesIn >
    Soldier --> "1..1 + home" Barracks : livesIn >
    
    Mill --> "1..1 + inhabitant" Miller : isInhabitedBy >
    Barracks --> "1..n + inhabitant" Soldier : isInhabitedBy >

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
        +label:String
    }
    
    class Building{
        
    }
    
    class Mill{
        
    }
    
    class Barracks {
        
    }
```