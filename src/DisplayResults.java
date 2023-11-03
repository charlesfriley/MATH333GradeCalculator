import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.event.*;


import java.awt.*;


public class DisplayResults extends JPanel {
    
    /* instance variables */ //TODO make this public or private respectuvly

    private String[] columnNames;
    private Object[][] data;

    // center panel
    private JTable table;
    /**
     * scrollPane contanes the table and buttons
     */
    private JScrollPane scrollPane; //unused because of bug i cannot figure out how to fix

    // south panel
    private JPanel southPanel, comboBoxPanel, calculateValuesPanel;
    private String[] comboArray = {"-", "0%-5%", "5%-10%", "10%-15%", "15%-20%", "20%-25%", 
    "25%-30%", "30%-35%", "35%-40%", "40%-45%", "45%-50%", "50%-55%", "55%,60%","60%-65%", 
    "65%-70%", "70%-75%", "75%-80%", "80%-85%", "85%-90%", "90%-95%", "95%-100%",};
    private JComboBox selectionBox;
    private JButton newTableButton, calculateButton;
    private JLabel comboLabel, calculateValuesLabel;
    private JTextField calculateTextField;


    /* constructer */
    public DisplayResults() 
    {
        CalculateListener cl = new CalculateListener();
        NewTableListener ntl = new NewTableListener();

        this.setLayout(new BorderLayout());
        this.setBackground(Theme.BACKGROUND_GRAY);

        /* format and create table */
        columnNames = new String[] {"Final Grade", //TODO put teh jtable main display in another file.
                                   "Quiz Weight",
                                   "Test Weight",
                                   "Final Weight",
                                   "Resulting Grade"};

        data = DisplayResultsResources.makeTableObjectArray();
        // data = new Object[][] { //TODO change to use the calculator class
        // {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        // {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        // {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        // {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        // {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        // {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        // {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        // {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        // {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        // {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        // {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        // {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        // {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        // {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        // {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        // {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        // {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        // {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        // {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        // {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        // {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        // };

        table = new JTable(data, columnNames);
        table.setBackground(Theme.TABLE_BACKGROUND);
        table.setForeground(Theme.TABLE_TEXT);
        table.setGridColor(Theme.GRID);
        table.getTableHeader().setBackground(Theme.TABLE_HEADER_BACKGROUND);
        table.getTableHeader().setForeground(Theme.TABLE_TEXT);

        /* create combo box panel */
        comboBoxPanel = new JPanel();
        comboBoxPanel.setBackground(Theme.BACKGROUND_GRAY);
        comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.X_AXIS));
        
        selectionBox = new JComboBox(comboArray);
        selectionBox.setToolTipText("Select a range of potential final grade values and press the button to the right");
        selectionBox.setMaximumSize(selectionBox.getPreferredSize());
        selectionBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboLabel = new JLabel("Display table in range of:  ");
        comboLabel.setForeground(Theme.TEXT_WHITE);

        newTableButton = new JButton("Display Table"); 
        newTableButton.addActionListener(ntl);
        newTableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        comboBoxPanel.add(Box.createHorizontalStrut(15));
        comboBoxPanel.add(comboLabel);
        comboBoxPanel.add(selectionBox);
        comboBoxPanel.add(newTableButton);

        /* create calculate value panel */
        calculateValuesPanel = new JPanel();
        calculateValuesPanel.setBackground(Theme.BACKGROUND_GRAY);
        calculateValuesPanel.setLayout(new BoxLayout(calculateValuesPanel, BoxLayout.X_AXIS));

        calculateValuesLabel = new JLabel("Enter a specific final grade (##.##)   ");
        calculateValuesLabel.setForeground(Theme.TEXT_WHITE);

        calculateTextField = new JTextField(5); 
        calculateTextField.addActionListener(cl);
        calculateTextField.setMaximumSize(calculateTextField.getPreferredSize()); 
        calculateTextField.setMinimumSize(calculateTextField.getPreferredSize());

        calculateButton = new JButton("Calculate"); 
        calculateButton.addActionListener(cl);
        calculateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        calculateValuesPanel.add(Box.createHorizontalStrut(15));
        calculateValuesPanel.add(calculateValuesLabel);
        calculateValuesPanel.add(calculateTextField);
        calculateValuesPanel.add(calculateButton);
        calculateValuesPanel.add(Box.createHorizontalStrut(15));


        /* create South panel */
        southPanel = new JPanel();
        southPanel.setBackground(Theme.BACKGROUND_GRAY);
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(comboBoxPanel);
        southPanel.add(calculateValuesPanel);



        // step 1 make table
        // make buttons in a y box layout
        // add buttons and table to x box
        // add that xbox to the scrollpane FIXME this step didnt work, fix later
        // add scroll pane to center layout

        // manual adding will be done on the bottom layout

        // __________________________

        // This section was removed because of bug where background is white
        // scrollPane = new JScrollPane(table);
        // scrollPane.setBackground(Theme.TABLE_HEADER_BACKGROUND); //this does not seem to be working as I thought it would
        // scrollPane.getVerticalScrollBar().setUI(new CustomScrollbarUI());


        this.add(table.getTableHeader(), BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        // this.add(dataAndButtonPanel);


    }

    /* listeners */

    /**
     * Listener for if the user presses the Display Table button
     */
    public class NewTableListener implements ActionListener //TODO this  should open a new window with a table of values between specified amount in combo box
    {
      @Override
      public void actionPerformed(ActionEvent e) 
      {
        int s = selectionBox.getSelectedIndex();
        System.out.println(s);
      }
    }

    /**
     * Listener for if the user presses the calculate button or if the user presses enter while in the text field
     */
    public class CalculateListener implements ActionListener //TODO  this button should calculate a certain value and either open it in a new panel OR add it to the south panel and repaint the panel. I like the second idea better. If i do that then the pannel should dissapear if the user types in nothing at all and presses enter.
    {                                                        //TODO  add a check if the user entered good values similar to what was done in teh main menu.
      @Override
      public void actionPerformed(ActionEvent e) 
      {
        sendToCalculator();
      }
    }


    /* methods */

    private void sendToCalculator()
    {
        String userFinal = calculateTextField.getText();

        if (MainMenuResources.isCalculationReady(userFinal, userFinal))
        {
            System.out.println("Custom calculation Ready");

            //TODO set cursor to wait animation

            int userFinalGrade = MainMenuResources.percentToInt(userFinal);

            System.out.println(userFinalGrade);

            //TODO actually send to the calculator and get results

            //TODO set cursor to defult
        }
        else 
        {
        ImageIcon coolBrillIcon = new ImageIcon("src/Images/CoolBrill.jpg");
        Image image = coolBrillIcon.getImage();
        Image newImg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        coolBrillIcon = new ImageIcon(newImg);

        JOptionPane.showMessageDialog(null,
            "Please make sure that you entered your numbers\ncorrectly in this format: ##.## (Example: 98.24).", 
            "Something went wrong...", JOptionPane.INFORMATION_MESSAGE, coolBrillIcon);
        }

    }


    // Custom scrollbar UI class
    class CustomScrollbarUI extends BasicScrollBarUI {

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            // Change the background color of the scrollbar track here
            g.setColor(Theme.TABLE_BACKGROUND);
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            // Change the background color of the scrollbar thumb here
            g.setColor(Theme.TABLE_HEADER_BACKGROUND);
            g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
        }

        @Override
        protected void paintDecreaseHighlight(Graphics g) {
            // Do nothing to remove the up arrow
        }
    
        @Override
        protected void paintIncreaseHighlight(Graphics g) {
            // Do nothing to remove the down arrow
        }
    
    }

}

