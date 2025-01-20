# Aufgabenblatt 11
Mika Hepper - st193543@stud.uni-stuttgart.de - 3787375

Fabian Kirschenmann - st193208@stud.uni-stuttgart.de - 3787773

---

# Aufgabe 1
```mermaid
classDiagram
    Settler <|-- Soldier
    Resource <|-- Grain
    Settler --> "1..* + consumedResource" Resource : consumes >
    Settler --> "0..* + producedresource" Resource : produces >
    Resource --> "1 + type" ResourceType : complies with >
    
    Settler <|-- Miller
    Resource <|-- Flour

    class Settler{
        +name:String
        +position:Position
        +settle()
    }

    class Soldier{
        + fightEnemy(enemy:Settler)
    }
    
    class Miller{
        
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
```