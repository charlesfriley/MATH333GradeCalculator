public class DisplayResultsResources {
    /*
     * This file should orginize results 
     * found from calculator class and send them over to teh DisplayResults file.
     * 
     * This class should use the calculator class to get a single line of info, then put all the info tegether. 
     * the object[][] would look something like:
     *  {"Final Grade", "Quiz Weight", "Test Weight", "Final Weight", "Resulting Grade"},
     *  {"Final Grade2", "Quiz Weight2", "Test Weight2", "Final Weight2", "Resulting Grade2"},
     *  ...
     * 
     * // basicly this file needs to request a calculation from calculator.java at a certain final, quiz, and test grade. 
     * // then it will request another, and another, and another
     * // it will orginize all this code into a Object[][] that the table in DisplayResults.java can use.
     * 
     * // ALSO THIS FILE SHOULD BE ABLE TO ORGINIZE THIS FOR TERMINAL USE ONLY so that people can use it on online web compilers.
     */

    
    public static Object[][] makeTableObjectArray()
    {
        Object[][] objectArray = new Object[21][5];
        
        int finalGradeIterator = 25; // each itteration, this variable will go from 0% to 5% to 10% and so on by getting multiplied by the row variable below

        int tempNum = DisplayResults.selectionBox.getSelectedIndex() * 5;

        int quizGrade = MainMenu.getMainQuizGrade();
        int testGrade = MainMenu.getMainTestGrade();
        for (int row = 0; row < 21; row++) {

            int finalGrade = finalGradeIterator * row + tempNum;

            Calculator c = new Calculator(quizGrade, testGrade, finalGrade);


            objectArray[row][0] = intToPercent(finalGrade);
            objectArray[row][1] = intToPercent(c.getBestQuizWeight());
            objectArray[row][2] = intToPercent(c.getBestTestWeight());
            objectArray[row][3] = intToPercent(c.getBestFinalWeight());
            objectArray[row][4] = intToPercent(c.getBestClassGrade());
        }


        return objectArray;
    }


    public static String intToPercent(int num)
    {
        String numString = Integer.toString(num);

        while (true) { //add "0" as padding to start of numbers that are not long enough
            if (numString.length() < 4)
            {
                numString = "0" + numString;
            }
            else
            {
                break;
            }
        }

        String numStringBegin = numString.substring(0, numString.length() - 2);
        String numStringEnd = numString.substring(numString.length() - 2, numString.length());

        return numStringBegin + "." + numStringEnd + "%";
    }

}
