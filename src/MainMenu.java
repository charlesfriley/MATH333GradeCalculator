import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main menu of the calculator. Contains the constructer 
 *  for the window and the listeners for the buttons and text feilds.
 *  See MainMenuResources.java for other methods.
 *  See Driver.java for the driver.
 */
public class MainMenu extends JPanel {

    /* Instance Variables */
    private JLabel welcomeLabel, inputInfoLabel, quizLabel, testLabel;
    private JTextField quizField, testField;
    private JButton calculateButton, helpButton;

    private JPanel welcomePanel, inputInfoPanel, fieldLabelPanel, fieldsPanel, calculatePanel, helpPanel, centerPanel;


    /* constructer */
    /**
     * Constructer for the Main Menu window.
     */
    public MainMenu()
    {
      /* Set up listeners for buttons and text feild */
      CalculateButtonListener cbl = new CalculateButtonListener();
      HelpButtonListener hbl = new HelpButtonListener();
      TextFieldListener tfl = new TextFieldListener();

      welcomePanel = new JPanel();
      welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.X_AXIS));
        welcomeLabel = new JLabel("Welcome to the Calculator!");
      welcomePanel.add(Box.createHorizontalGlue());
      welcomePanel.add(welcomeLabel);
      welcomePanel.add(Box.createHorizontalGlue());


      inputInfoPanel = new JPanel();
      inputInfoPanel.setLayout(new BoxLayout(inputInfoPanel, BoxLayout.X_AXIS));
        inputInfoLabel = new JLabel("Please enter your quiz and test grade");
      inputInfoPanel.add(Box.createHorizontalGlue());
      inputInfoPanel.add(inputInfoLabel);
      inputInfoPanel.add(Box.createHorizontalGlue());


      fieldLabelPanel = new JPanel();
      fieldLabelPanel.setLayout(new BoxLayout(fieldLabelPanel, BoxLayout.X_AXIS));
        quizLabel = new JLabel("Quiz %");
        quizLabel.setToolTipText("Enter Quiz Grade");
        testLabel = new JLabel("Test %"); //TODO set all the tool tip text
      fieldLabelPanel.add(Box.createHorizontalGlue());
      fieldLabelPanel.add(quizLabel);
      fieldLabelPanel.add(Box.createHorizontalStrut(75));
      fieldLabelPanel.add(testLabel);
      fieldLabelPanel.add(Box.createHorizontalGlue());

      fieldsPanel = new JPanel();
      fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.X_AXIS));
        quizField = new JTextField();
        quizField.addActionListener(tfl);
        testField = new JTextField();
        testField.addActionListener(tfl);
      fieldsPanel.add(Box.createHorizontalGlue());
      fieldsPanel.add(quizField);
      fieldsPanel.add(Box.createHorizontalStrut(5));
      fieldsPanel.add(testField);
      fieldsPanel.add(Box.createHorizontalGlue());

      calculatePanel = new JPanel();
      calculatePanel.setLayout(new BoxLayout(calculatePanel, BoxLayout.X_AXIS));
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(cbl);
      calculatePanel.add(Box.createHorizontalGlue());
      calculatePanel.add(calculateButton);
      calculatePanel.add(Box.createHorizontalGlue());

      helpPanel = new JPanel();
      helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.X_AXIS));
        helpButton = new JButton("Help");
        helpButton.addActionListener(hbl);
      helpPanel.add(Box.createHorizontalGlue());
      helpPanel.add(helpButton);
      helpPanel.add(Box.createHorizontalGlue());

      centerPanel = new JPanel();
      centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
      centerPanel.add(welcomePanel);
      centerPanel.add(inputInfoPanel);
      centerPanel.add(fieldLabelPanel);
      centerPanel.add(fieldsPanel);
      centerPanel.add(calculatePanel);
      centerPanel.add(helpPanel);

      this.add(centerPanel);
    }

    /* listeners */

    /**
     * Listener for if the user presses the calculate button
     */
    public class CalculateButtonListener implements ActionListener
    {
      @Override
      public void actionPerformed(ActionEvent e) 
      {
        sendToCalculator();
      }
    }

    /**
     * Listener for if the user presses the help button
     */
    public class HelpButtonListener implements ActionListener
    {
      @Override
      public void actionPerformed(ActionEvent e) 
      {
        Help.openHelpWindow();
      }
    }

    /**
     * Listener for if the user presses enter in the text field
     */
    public class TextFieldListener implements ActionListener
    {

      @Override
      public void actionPerformed(ActionEvent e) {
        sendToCalculator();
      }

    }


    /* methods */

    /**
     * Sends the formated numbers in the text fields to the calculator class
     */
    private void sendToCalculator()
    {
      String userQuiz = quizField.getText();
        String userTest = testField.getText();

        if (MainMenuResources.isCalculationReady(userQuiz, userTest))
        {
          System.out.println("READY");
          int userQuizGrade = MainMenuResources.percentToInt(userQuiz);
          int userTestGrade = MainMenuResources.percentToInt(userTest);
          //TODO sent this userQuizGrade and userTestGrade info to the calculator class
        }
        else
        {
          JOptionPane.showMessageDialog(null,
           "Please make sure that you entered your numbers\ncorrectly in this format: ##.## (Example: 98.24).", 
           "Something went wrong...", JOptionPane.INFORMATION_MESSAGE);
        }
    }



    
}
