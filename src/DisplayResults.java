import javax.swing.*;

public class DisplayResults extends JPanel{
    
    /* instance variables */

    String[] columnNames;
    Object[][] data;
    JTable table;
    /**
     * scrollPane contanes the table and buttons
     */
    JScrollPane scrollPane;
    JPanel buttonsPanel, dataAndButtonPanel;

    JButton testButton;

    /* constructer */
    public DisplayResults() 
    {
        testButton = new JButton("Test Button");


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

        /* create buttons panel */
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.add(testButton);

        /* create buttons + data tabel panel */
        dataAndButtonPanel = new JPanel();
        dataAndButtonPanel.setLayout(new BoxLayout(dataAndButtonPanel, BoxLayout.X_AXIS));
        dataAndButtonPanel.add(buttonsPanel);
        dataAndButtonPanel.add(table);



        // step 1 make table
        // make buttons in a y box layout
        // add buttons and table to x box
        // add that xbox to the scrollpane
        // add scroll pane to center layout

        // manual adding will be done on the bottom layout

        scrollPane = new JScrollPane(dataAndButtonPanel);

        this.add(scrollPane);

    }

    /* listeners */

    /* methods */


}

