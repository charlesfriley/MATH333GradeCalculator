import java.util.Arrays;

/**
 * Class for calculating
 */
public class Calculator {
    
/*
 * TODO
 * must calculate the stuff
 * 
 * Here is how i think this file will work: You will request a single line of information for the chart 
 *  so this file needs 3 inputs, your final grade, quiz grade, and test grade
 *  it will return the best grade possible
 */

    int accuarcyFactor, bestQuizWeight, bestTestWeight, bestFinalWeight, bestClassGrade;

    //TODO javadoc
    public Calculator()
    {
        accuarcyFactor = 100; // when set to 1, then percents are read up to the ones place of accuacy, if set to 10, accuracy is read up to the tenths place, if set to 100, accuacy is up to the hundreths place
        bestQuizWeight = -1;
        bestFinalWeight = -1;
        bestTestWeight = -1;
        bestClassGrade = -1;
    }
    //TODO javadoc
    public Calculator(int quizGrade, int testGrade, int finalGrade)
    {
        accuarcyFactor = 100; // when set to 1, then percents are read up to the ones place of accuacy, if set to 10, accuracy is read up to the tenths place, if set to 100, accuacy is up to the hundreths place
        bestQuizWeight = -1;
        bestFinalWeight = -1;
        bestTestWeight = -1;
        bestClassGrade = -1;

        calculate(quizGrade,testGrade,finalGrade);
    }
    /**
     * Recieves the user's test, quiz, and final grade then calculates how much each catagory should be 
     *  weighted at in order to recieve the greatest class grade. Use getBest*() to get the results of this
     *  calculation
     * @param quizGrade 
     * @param testGrade
     * @param finalGrade
     */
    public void calculate(int quizGrade, int testGrade, int finalGrade)
    {
        int iteratedClassGrade;
        int counter = 0;


        for (int Q = 20 * accuarcyFactor; Q <= 50 * accuarcyFactor; Q++)
        {
            for (int F = 30 * accuarcyFactor; F <= 50 * accuarcyFactor; F++)
            {
                int T = (100 * accuarcyFactor) - Q - F;
                if (T >= (20 * accuarcyFactor)) // T has to be in the range of 20% ≤ T ≤ 50%, but it is impossible to get over 50% so that does not need to be here
                {
                    iteratedClassGrade = ((quizGrade * Q) + (testGrade * T) + (finalGrade * F)) / (100 * accuarcyFactor);
                    if (iteratedClassGrade > bestClassGrade)
                    {
                        bestClassGrade = iteratedClassGrade;
                        bestQuizWeight = Q;
                        bestTestWeight = T;
                        bestFinalWeight = F;
                        // System.out.println("Max Class Grade so far = " + bestClassGrade + " with Q = " + bestQuizWeight + ", T = " + bestTestWeight + ", and F = " + bestFinalWeight);
                        // System.out.println(counter);
                    }
                    // System.out.println(iteratedClassGrade);
                    counter++;
                }
            }
        }
        

    }

    /* other methods */

    /**
     * Get the Max class grade for this itteration. Return best class grade or -1 if calculation has not been run yet.
     * @return best class grade or -1 if calculation has not been run yet. use calculate()
     */
    public int getBestClassGrade()
    {
        return bestClassGrade;
    }
    //TODO add javadoc to these
    public int getBestQuizWeight()
    {
        return bestQuizWeight;
    }

    public int getBestTestWeight()
    {
        return bestTestWeight;
    }
    
    public int getBestFinalWeight()
    {
        return bestFinalWeight;
    }


    public static void main(String[] args)
    {
        Calculator c = new Calculator(9708, 8850, 10000);
        System.out.println("Max Class Grade = " + c.getBestClassGrade() + " with Q = " + c.getBestQuizWeight() + ", T = " + c.getBestTestWeight() + ", and F = " + c.getBestFinalWeight());
    }

}
