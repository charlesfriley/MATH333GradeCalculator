

/**
 * Class with methods to support the MainMenu class
 * NOTE TO SELF: To use this class, you have to create an instance of this class 
 *  in your other file. So write MainMenuResources m = new MainMenuResources(); and then 
 *  you can call a method like m.myMethod();
 */
public class MainMenuResources {
    
    
    /**
     * Converts a string of the form 12.34% and converts it to a int 1234. The input
     *  can contain a percent sign, but does not have to.
     * @param userString string of the form 12.34%
     * @return int of the form 1234
     */
    public static int percentToInt(String userString)
    {
        userString = userString.trim();
        userString = userString.replaceAll("%","");

        int userInt = (int) (100 * Double.parseDouble(userString));
        
        return userInt;
    }

    /**
     * Recieves two string inputs from the text fields in the main menu, 
     *  then checks if it is ready to be converted to an integer. Returns true
     *  if it is ready.
     * @param userQuiz User string input from the quiz test field
     * @param userTest User string input from the test text field
     * @return a boolean true if ready false if not.
     */
    public static boolean isCalculationReady(String userQuiz, String userTest)
    {
        userQuiz = userQuiz.trim();
        userTest = userTest.trim();

        userQuiz = userQuiz.replaceAll("%","");
        userTest = userTest.replaceAll("%", "");

        try {
            Double.parseDouble(userQuiz);
            Double.parseDouble(userTest);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }
}
