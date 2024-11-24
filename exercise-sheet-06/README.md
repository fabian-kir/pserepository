# Exercise Sheet 06

This repo contains the classes for exercise sheet 06.

In the presence part, you'll work with classes, primitives, and exceptions.  
In the homework part, you'll create your first larger algorithms.

You should solve the exercises in the specific classes and you can run the classes using the corresponding `-App` class.

## Run the project

To install Java, set up your IDE and clone the repository into your workspace, please follow the instructions in exercise sheet `01`, Part `0 - Preparation`.
This sheet contains multiple main classes, depending on the task. Available main classes are

- CagedHamsterGameApp
- LazyHamsterGameApp
- AmazingPauleHamsterGameApp

### Run the project in Eclipse
- First, make sure again to have the correct Java version set in your project: Go to `Eclipse` > `Preferences` > `Java` > `Compiler` and set the `Compiler compliance level` to `21` (or higher).
- Either, right click on the corresponding main class and select `Run as` > `Java Application`, or if you have started the class previously, click on the green `Play` (run) Button" in the top left corner or in the menu under `Run` > `Run`.

### Run the project in IntelliJ
- First, make sure again to have the correct Java version set in your project: Go to `File` > `Project Structure...` In `Project Settings` > `Project` > `SDK` select `Java 21`.
- In the menu, Go to `Run` > `Edit Configurations...`, click on the plus icon and select `Application`.
- Give it a name, e.g., "HamsterSimulator"
- Now, you have to select the Main class, i.e., the starting point for running the application. To do so, under `Build and Run`, click on `Main class` (or the dollar sign to the right) and select the class you want to start.
- Start the Hamster Simulator by hitting the "Play Button" in the top right corner or in the menu under `Run` > `Run 'HamsterSimulator'`.

### Run the project in VS Code
- Use the instructions presented in [youtu.be/BGJC0pQsQAo](https://youtu.be/BGJC0pQsQAo)

### Run the project via command line with Maven

  ```sh
  mvn clean compile exec:java@$MAIN_CLASS
  ```
   
  so, for example:
  ```sh
  mvn clean compile exec:java@AmazingPauleHamsterGameApp
  ```
  ```sh
  mvn clean compile exec:java@PainterPauleCrossHamsterGameApp
  ```
  ```sh
  mvn clean compile exec:java@PainterPauleSpiralHamsterGameApp
  ```
  ```sh
  mvn clean compile exec:java@EqualityHamsterGameApp
  ```
  ```sh
  mvn clean compile exec:java@StairsPauleHamsterGameApp
  ```
