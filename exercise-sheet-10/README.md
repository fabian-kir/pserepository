# Exercise Sheet 10

This repository contains the classes needed for solving PSE WS 22/23 excercise sheet 10.

It contains one presence and two homework exercises. Also, there is a part for part for teaching students.

In the presence part, you'll work with the implementation of a UML diagram.
In the homework part, you'll check an implementation of a game fdor style errors and will work with different kinds of data structures.

You should solve the exercises in the classes specified on the excercise sheet.

## Run the project

To install Java, set up your IDE and clone the repository into your workspace, please follow the instructions in exercise sheet `01`, Part `0 - Preparation`.
The Main class for homework excercise 1 will be Game.java, for homework and presence excercise 2 you can either test your code using the availiable tests on Artemis or create your own Main class.
Homework excercise 1 will output to the console.

### Run the project in Eclipse
- First, make sure again to have the correct Java version set in your project: Go to `Eclipse` > `Preferences` > `Java` > `Compiler` and set the `Compiler compliance level` to `17` (or higher).
- Also make sure that you have followed the instructions pertaining the console character limits - under `Window` > `Preferences` `Run/Debug` `Console` either uncheck the box for `Limit console output` or increase the allowed character limit.
- Either, right click on the corresponding main class and select `Run as` > `Java Application`, or if you have started the class previously, click on the green `Play` (run) Button" in the top left corner or in the menu under `Run` > `Run`.

### Run the project in IntelliJ
- First, make sure again to have the correct Java version set in your project: Go to `File` > `Project Structure...` In `Project Settings` > `Project` > `SDK` select `Java 17`.
- Also make sure that you have followed the instructions pertaining the console character limits - under `File` > `Settings` `Editor` `General` `Console` check the box for `Override console cycle buffer size` and increase the allowed character limit.
- In the menu, Go to `Run` > `Edit Configurations...`, click on the plus icon and select `Application`.
- Now, you have to select the Main class, i.e., the starting point for running the application. To do so, under `Build and Run`, click on `Main class` (or the dollar sign to the right) and select the class you want to start. 

### Run the project in VS Code
- Use the instructions presented in [youtu.be/BGJC0pQsQAo](https://youtu.be/BGJC0pQsQAo)

### Run the project via command line with Maven

  ```sh
  mvn clean compile exec:java@Main
  ```
  ```sh
  mvn clean compile exec:java@JustSomeHamsterGameApp
  ```

