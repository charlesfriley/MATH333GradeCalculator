import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Cursor;


public class DisplayResults extends JPanel{
    
    /* instance variables */ //TODO make this public or private respectuvly

    private String[] columnNames;
    private Object[][] data;

    // center panel
    private JTable table;
    /**
     * scrollPane contanes the table and buttons
     */
    private JScrollPane scrollPane;



    // south panel
    private JPanel southPanel, comboBoxPanel, customValuesPanel;
    private String[] comboArray = {"-", "0%-5%", "5%-10%", "10%-15%", "15%-20%", "20%-25%", 
    "25%-30%", "30%-35%", "35%-40%", "40%-45%", "45%-50%", "50%-55%", "55%,60%","60%-65%", 
    "65%-70%", "70%-75%", "75%-80%", "80%-85%", "85%-90%", "90%-95%", "95%-100%",};
    private JComboBox selectionBox;
    private JButton newTableButton, customButton;
    private JLabel comboLabel, customValuesLabel;
    private JTextField customTextField;


    /* constructer */
    public DisplayResults() 
    {
        this.setLayout(new BorderLayout());

        /* format and create table */
        columnNames = new String[] {"Final Grade", //TODO put teh jtable main display in another file.
                                   "Quiz Weight",
                                   "Test Weight",
                                   "Final Weight",
                                   "Resulting Grade"};

        data = new Object[][] { //TODO change to use the calculator class
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"},
        {"1Test", "two", (Integer) 3, (Integer) 4, "1Grade"},
        {"2Test", "three", (Integer)5, (Integer) 6, "2Grade"},
        {"3Test", "four", (Integer)7, (Integer) 8, "3Grade"}
        };

        table = new JTable(data, columnNames);

        /* create combo box panel */
        comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.X_AXIS));
        
        selectionBox = new JComboBox(comboArray);
        selectionBox.setToolTipText("Select a range of potential final grade values and press the button to the right");
        selectionBox.setMaximumSize(selectionBox.getPreferredSize());
        selectionBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboLabel = new JLabel("Display table in range of:  ");

        newTableButton = new JButton("Display Table"); //TODO add listener, this button should open a new window with a table of values between specified amount in combo cox
        newTableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        comboBoxPanel.add(Box.createHorizontalStrut(15));
        comboBoxPanel.add(comboLabel);
        comboBoxPanel.add(selectionBox);
        comboBoxPanel.add(newTableButton);

        /* create custom value panel */
        customValuesPanel = new JPanel();
        customValuesPanel.setLayout(new BoxLayout(customValuesPanel, BoxLayout.X_AXIS));

        customValuesLabel = new JLabel("Enter a specific final grade (##.##)   ");

        customTextField = new JTextField(5); //TODO add listener for if the user presses enter AND add a check if the user entered good values similar to what was done in teh main menu.
        customTextField.setMaximumSize(customTextField.getPreferredSize()); 
        customTextField.setMinimumSize(customTextField.getPreferredSize());

        customButton = new JButton("Calculate"); //TODO add listener and this button should calculate a certain value and either open it in a new panel OR add it to the south panel and repaint the panel. I like the second idea better. If i do that then the pannel should dissapear if the user types in nothing at all and presses enter.
        customButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        customValuesPanel.add(Box.createHorizontalStrut(15));
        customValuesPanel.add(customValuesLabel);
        customValuesPanel.add(customTextField);
        customValuesPanel.add(customButton);
        customValuesPanel.add(Box.createHorizontalStrut(15));


        /* create South panel */
        southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(comboBoxPanel);
        southPanel.add(customValuesPanel);



        // step 1 make table
        // make buttons in a y box layout
        // add buttons and table to x box
        // add that xbox to the scrollpane FIXME this step didnt work, fix later
        // add scroll pane to center layout

        // manual adding will be done on the bottom layout

        // __________________________
        scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        // this.add(dataAndButtonPanel);


    }

    /* listeners */

    /* methods */


}

