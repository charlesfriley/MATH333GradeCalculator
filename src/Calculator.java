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

    public Calculator()
    {
        accuarcyFactor = 100; // when set to 1, then percents are read up to the ones place of accuacy, if set to 10, accuracy is read up to the tenths place, if set to 100, accuacy is up to the hundreths place
        bestQuizWeight = -1;
        bestFinalWeight = -1;
        bestTestWeight = -1;
        bestClassGrade = -1;
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
        int maxClassGrade = 0;
        int maxQ = 0, maxT = 0, maxF = 0;
        int counter = 0;


        for (int Q = 20 * accuarcyFactor; Q <= 50 * accuarcyFactor; Q++)
        {
            for (int F = 30 * accuarcyFactor; F <= 50 * accuarcyFactor; F++)
            {
                int T = (100 * accuarcyFactor) - Q - F;
                if (T >= (20 * accuarcyFactor)) // T has to be in the range of 20% ≤ T ≤ 50%, but it is impossible to get over 50% so that does not need to be here
                {
                    iteratedClassGrade = ((quizGrade * Q) + (testGrade * T) + (finalGrade * F)) / (100 * accuarcyFactor);
                    if (iteratedClassGrade > maxClassGrade)
                    {
                        maxClassGrade = iteratedClassGrade;
                        maxQ = Q;
                        maxT = T;
                        maxF = F;
                        // System.out.println(maxClassGrade);
                    }
                    counter++;
                }
            }
        }


        System.out.println("Count: " + counter);
        System.out.println("Max Class Grade = " + maxClassGrade + " with Q = " + maxQ + ", T = " + maxT + ", and F = " + maxF);
        

    }

//counting for accuarcy
// 20181
// 18210801
// 841138817
    public static void main(String[] args)
    {
        Calculator c = new Calculator();
        c.calculate(9000, 9110, 9100);
    }

}
