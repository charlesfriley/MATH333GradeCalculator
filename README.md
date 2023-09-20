# MATH333GradeCalculator
A grade calculator for Prof. Brill's MATH333 class to calculate the best weighted values for your grades, following his guidelines on how grades are calculated.

Just a reminder on how Prof. Brill will be grading us: 
  We get to pick how much our quiz grade, test grade, and final grades are worth within the specified ranges:
    quiz: 20% - 50%
    test: 30% - 50%
    final: 20% - 50%
    (these values must equal 100%)
  The fun part about this project is that we have to make this decision **before we take our final.**
  So plan to have the calculations done for all possible grades you might get on the final, however that will be way too much computation power. As of right now, I think that it would be best to only calculate for every possible final grade in increments of 5%. Then the user can enter in values manually to see the best weights.
  

## What each file is for
-Driver.java has the main method that opens the main menu.

-MainMenu.java is the constructer for the main menu window. 

-MainMenuResources.java contains the logic happening in the main menu

-Help.java is the help window

-Calculator.java is where the backend calculations happen

-DisplayResults is the GUI to see the calculated results

## Important Info
All the math in this project will be done with ints, not doubles. So instead of working with a percentage like 89.56%, we will be working with an int like 8956. This makes the math easier for the computer to do since it will be iterating through milions of possiblities to find the best grades.

## Goals
- code the logic behind the calculator
- display the info from the calculator
- make everything look better
- fill out help window (only when done with everything else)

## Layout idea for calculation page
![image](Images/IdeaForCalculationPage.jpg)


### info for next time
I left off on line 154 in MainMenu.java. Need to create a class to recieve the information and compute it.
