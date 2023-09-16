package ArcivedCode;
public class TestMe
{

  private static int[][] classGrades = new int[20][2503501];

  private static final int MY_QUIZ_GRADE = 8592;
  private static final int MY_TEST_GRADE = 7245;


  public static void iDunno(int a, int b, int c, int index)
  {
    for(int f = 0; f <= 20; f++) //f is multiplied by 5 to get integrations of 5
    {
      int currrentFinalGrade = f*5;
      // classGrades[f] = currrentFinalGrade;
      int classGradeWithTheseValues = (MY_QUIZ_GRADE * a) + (MY_TEST_GRADE * b) + (currrentFinalGrade * c);
      classGrades[f][index] = classGradeWithTheseValues;
      System.out.println("currrentFinalGrade: " + currrentFinalGrade + " a,b,c: " + a + " " + b + " " + c + "\n" + "Class Grade with these values: " + classGradeWithTheseValues);
    }
    System.out.println("_______________________");
  }




  public static void main(String[] args)
  {
    int a, b, c;

    int counter = 0;
    int counterTwo = 0;

    int testGrade = 80;
    int quizGrade = 85;
    int finalGrade = 90;

      /* the index of all the *Values arrays add to 10000, meant to be read as 100.00% */
    int[] aValues = new int[2503501];
    int[] bValues = new int[2503501];
    int[] cValues = new int[2503501];


    // itterate through all the possible a, b, and c values that add to 100.00% and add them to their arrays
    for(a = 2000; a <= 5000; a++)
    {
      for(b = 3000; b <= 4000; b++)
      {
        c = 10000 - b - a;

        if (c >= 2000) // c has to be in the range of 2000 ≤ c ≤ 50000, but it is impossible to get over 50000 so that does not need to be here
        {
          aValues[counter] = a;
          bValues[counter] = b;
          cValues[counter] = c;

          iDunno(a, b, c, counter);









          counter++;
        }
      }
    }



    /* test prints */
    System.out.println(counter);
    // System.out.println(classGrades[500]);
    System.out.println(aValues[5400]);
    System.out.println(bValues[5400]);
    System.out.println(cValues[5400]);
  }
}

/*
cd /Users/charlesfriley/Desktop/Coding/Java/MyJavaTestFiles/HandyTools/MATH333GradeCalc
javac -s src -d bin src/TestMe.java
time java -cp bin TestMe

*/
