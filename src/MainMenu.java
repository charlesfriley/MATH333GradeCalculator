import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
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

    // these variables will be set to whatever value the user puts in the text feilds
    private static int mainQuizGrade, mainTestGrade;

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
      welcomePanel.setBackground(Theme.BACKGROUND_GRAY);
        welcomeLabel = new JLabel("Welcome to the Calculator!");
        welcomeLabel.setForeground(Theme.TEXT_WHITE);
      welcomePanel.add(Box.createHorizontalGlue());
      welcomePanel.add(welcomeLabel);
      welcomePanel.add(Box.createHorizontalGlue());


      inputInfoPanel = new JPanel();
      inputInfoPanel.setLayout(new BoxLayout(inputInfoPanel, BoxLayout.X_AXIS));
      inputInfoPanel.setBackground(Theme.BACKGROUND_GRAY);
        inputInfoLabel = new JLabel("Please enter average quiz and test grade");
        inputInfoLabel.setForeground(Theme.TEXT_WHITE);
      inputInfoPanel.add(Box.createHorizontalGlue());
      inputInfoPanel.add(inputInfoLabel);
      inputInfoPanel.add(Box.createHorizontalGlue());


      fieldLabelPanel = new JPanel();
      fieldLabelPanel.setLayout(new BoxLayout(fieldLabelPanel, BoxLayout.X_AXIS));
      fieldLabelPanel.setBackground(Theme.BACKGROUND_GRAY);
        quizLabel = new JLabel("Quiz %");
        quizLabel.setForeground(Theme.TEXT_WHITE);
        quizLabel.setToolTipText("Enter Quiz Grade");
        testLabel = new JLabel("Test %"); //TODO set all the tool tip text
        testLabel.setForeground(Theme.TEXT_WHITE);
      fieldLabelPanel.add(Box.createHorizontalGlue());
      fieldLabelPanel.add(quizLabel);
      fieldLabelPanel.add(Box.createHorizontalStrut(90));
      fieldLabelPanel.add(testLabel);
      fieldLabelPanel.add(Box.createHorizontalGlue());

      fieldsPanel = new JPanel();
      fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.X_AXIS));
      fieldsPanel.setBackground(Theme.BACKGROUND_GRAY);
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
      calculatePanel.setBackground(Theme.BACKGROUND_GRAY);
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(cbl);
      calculatePanel.add(Box.createHorizontalGlue());
      calculatePanel.add(calculateButton);
      calculatePanel.add(Box.createHorizontalGlue());

      helpPanel = new JPanel();
      helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.X_AXIS));
      helpPanel.setBackground(Theme.BACKGROUND_GRAY);
        helpButton = new JButton("Help");
        helpButton.addActionListener(hbl);
      helpPanel.add(Box.createHorizontalGlue());
      helpPanel.add(helpButton);
      helpPanel.add(Box.createHorizontalGlue());

      centerPanel = new JPanel();
      centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
      centerPanel.setBackground(new Color(255,0,0));
      centerPanel.add(welcomePanel);
      centerPanel.add(inputInfoPanel);
      centerPanel.add(fieldLabelPanel);
      centerPanel.add(fieldsPanel);
      centerPanel.add(calculatePanel);
      centerPanel.add(helpPanel);

      setCursorToDefult();
      this.setBackground(Theme.BACKGROUND_GRAY);
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
     * Listener for if the user presses enter while in the text field
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
     * Sends the formated numbers in the text fields to the calculator class //TODO add the calculator class
     */
    private void sendToCalculator()
    {
      String userQuiz = quizField.getText();
      String userTest = testField.getText();

      if (MainMenuResources.isCalculationReady(userQuiz, userTest))
      {
        setCursorToWait();


        int userQuizGrade = MainMenuResources.percentToInt(userQuiz);
        int userTestGrade = MainMenuResources.percentToInt(userTest);


        setMainQuizGrade(userQuizGrade);
        setMainTestGrade(userTestGrade);
        
        JFrame frame = new JFrame("MATH333 Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new DisplayResults());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setCursorToDefult();
      }
      else
      {
        ImageIcon coolBrillIcon = new ImageIcon("src/Images/CoolBrill.jpg");
        Image image = coolBrillIcon.getImage();
        Image newImg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        coolBrillIcon = new ImageIcon(newImg);

        JOptionPane.showMessageDialog(null,
          "Please make sure that you entered your numbers\ncorrectly in this format: ##.## (Example: 98.24).", 
          "PORQUE NO?!", JOptionPane.INFORMATION_MESSAGE, coolBrillIcon);
      }
    }

    /**
     * Sets all the components in the Main Menu to display the waiting cursor animation
     */
    private void setCursorToWait()
    {
      this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      helpButton.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      calculateButton.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      quizField.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      testField.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }

    /**
     * Sets all the components in the Main Menu to use the customized defult values
     */
    private void setCursorToDefult()
    {
      this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      helpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      calculateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      quizField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
      testField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
    }


    private void setMainQuizGrade(int num)
    {
      mainQuizGrade = num;
    }
    private void setMainTestGrade(int num)
    {
      mainTestGrade = num;
    }
    public static int getMainQuizGrade()
    {
      return mainQuizGrade;
    }
    public static int getMainTestGrade()
    {
      return mainTestGrade;
    }



    
}
