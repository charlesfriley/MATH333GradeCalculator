package ArcivedCode;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Grade calculator that follows the rules specified in MATH333
 *   taught by Steven Brill at Boise State University
 * @author Charles Friley
 */
public class MATH333GradeCalcDriver extends JPanel{

    /* instance variables */

    JSlider finalSlider, testSlider, quizSlider;

    JPanel finalSliderPanel, testSliderPanel, quizSliderPanel;
    JLabel fLeft, fRight, tLeft, tRight, qLeft, qRight;

    JPanel mustAddPanel;
    JLabel mustAddLabel;

    JPanel quizInputPanel, testInputPanel, finalInputPanel;
    JTextField quizTextField, testTextField, finalTextField;
    JLabel qTFLabel, tTFLabel, fTFLabel;

    JPanel gradePanel;
    JLabel gradeLabel;

    JButton calculateButton;



    /* constructer */
    public MATH333GradeCalcDriver()
    {

        MyChangeListener mcl = new MyChangeListener();
        MyActionListener mal = new MyActionListener();
        /* create final slider panel */
        finalSliderPanel = new JPanel();
         finalSlider = new JSlider(2000, 5000);
         finalSlider.addChangeListener(mcl);
         fLeft = new JLabel("Final Grade Worth (20% - 50%)");
         fRight = new JLabel(formatToDecimal(finalSlider.getValue()));
        finalSliderPanel.add(fLeft);
        finalSliderPanel.add(finalSlider);
        finalSliderPanel.add(fRight);

        /* create test slider panel */
        testSliderPanel = new JPanel();
         testSlider = new JSlider(3000, 5000);
         testSlider.addChangeListener(mcl);
         tLeft = new JLabel("Test Grade Worth (30% - 50%)");
         tRight = new JLabel(formatToDecimal(testSlider.getValue()));
        testSliderPanel.add(tLeft);
        testSliderPanel.add(testSlider);
        testSliderPanel.add(tRight);

        /* create quiz slider panel */
        quizSliderPanel = new JPanel();
         quizSlider = new JSlider(2000, 5000);
         quizSlider.addChangeListener(mcl);
         qLeft = new JLabel("Quiz Grade Worth (20% - 50%)");
         qRight = new JLabel(formatToDecimal(quizSlider.getValue()));
        quizSliderPanel.add(qLeft);
        quizSliderPanel.add(quizSlider);
        quizSliderPanel.add(qRight);

        /* create "Must add to 100%" panel */
        int totalValueOfSliders = quizSlider.getValue() + testSlider.getValue() + finalSlider.getValue();
        mustAddPanel = new JPanel();
        mustAddLabel = new JLabel("Must add to 100% | Your value: " + formatToDecimal(totalValueOfSliders));
        mustAddPanel.setBackground(mustAddColor());
        mustAddPanel.add(mustAddLabel);

        /* Create quiz text field */
        quizInputPanel = new JPanel();
        quizTextField = new JTextField(10);
        qTFLabel = new JLabel("Your Quiz Grade %: ");
        quizInputPanel.add(qTFLabel);
        quizInputPanel.add(quizTextField);

        /* Create test text field */
        testInputPanel = new JPanel();
        testTextField = new JTextField(10);
        tTFLabel = new JLabel("Your Test Grade %: ");
        testInputPanel.add(tTFLabel);
        testInputPanel.add(testTextField);

        /* Create final text field */
        finalInputPanel = new JPanel();
        finalTextField = new JTextField("50", 10); //TODO either make all textfields start with a value or handle this in getGrade method
        fTFLabel = new JLabel("Your Final Grade %: ");
        finalInputPanel.add(fTFLabel);
        finalInputPanel.add(finalTextField);

        /* create grade in class panel*/
        gradePanel = new JPanel();
        gradeLabel = new JLabel("Your Grade: " + formatToDecimal(getGrade()));
        gradePanel.add(gradeLabel);

        /* create calculate button */
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(mal);


        /* master panel */
        this.add(finalSliderPanel);
        this.add(testSliderPanel);
        this.add(quizSliderPanel);
        this.add(mustAddPanel);
        this.add(quizInputPanel);
        this.add(testInputPanel);
        this.add(finalInputPanel);
        this.add(calculateButton);
        this.add(gradePanel);

    }

    /* methods */

    /**
     * Calculates the grade you have in the class by checking the slide label values
     * and taking in the text field values then taking a weighted average
     * @return int | weighted average grade
     */
    private int getGrade()
    {
        int finalSlideValue = this.finalSlider.getValue();
        int testSlideValue = this.testSlider.getValue();
        int quizSlideValue = this.quizSlider.getValue();

        int fTFValue = Integer.parseInt(this.finalTextField.getText());

        return fTFValue;
    }

    /**
     * update the slider labels
     */
    private void updateSliderLabels()
    {

        int finalSlideValue = this.finalSlider.getValue();
        int testSlideValue = this.testSlider.getValue();
        int quizSlideValue = this.quizSlider.getValue();


        this.fRight.setText(formatToDecimal(finalSlideValue));
        this.tRight.setText(formatToDecimal(testSlideValue));
        this.qRight.setText(formatToDecimal(quizSlideValue));
    }

    /**
     * update the label in MustAddPanel
     */
    private void updateMustAddLabels()
    {
        int totalValueOfSliders = quizSlider.getValue() + testSlider.getValue() + finalSlider.getValue();
        mustAddLabel.setText("Must add to 100% | Your value: " + formatToDecimal(totalValueOfSliders));
    }

    /**
     * Formats a ####  number into ##.##%
     * @param value #### int number
     * @return ##.##% formated number string
     */
    private String formatToDecimal(int value)
    {
        int leftOfDecimal = value / 100;
        int rightOfDecimal = value % 100;
        String output = leftOfDecimal + "." + rightOfDecimal + "%";
        return output;
    }

    /**
     * Checks to see if the MustAdd panel should be green
     * @return Color object green or red
     */
    private Color mustAddColor()
    {
        Color c = Color.RED;
        if (finalSlider.getValue() + testSlider.getValue() + quizSlider.getValue() == 10000)
        {
            c = Color.GREEN;
        }
        return c;
    }


    /* listeners */
    public class MyChangeListener implements ChangeListener
    {

        @Override
        public void stateChanged(ChangeEvent e)
        {
            updateSliderLabels();
            updateMustAddLabels();
            mustAddPanel.setBackground(mustAddColor());

        }

    }

    public class MyActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO make this its own method called updateGradeLabel()
            gradeLabel.setText("Your Grade: " + formatToDecimal(getGrade()));
        }
    }



    public static void main(String[] args)
    {
        JFrame frame = new JFrame("MATH333 Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new MATH333GradeCalcDriver());
        frame.pack();
        frame.setVisible(true);
    }
}
