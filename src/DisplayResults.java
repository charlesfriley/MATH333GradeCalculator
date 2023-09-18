import javax.swing.*;

public class DisplayResults extends JPanel{
    
    /* instance variables */
    String[] columnNames;
    Object[][] data;
    JTable table;
    JScrollPane scrollPane;

    /* constructer */
    public DisplayResults() 
    {
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
        };

        table = new JTable(data, columnNames);


        scrollPane = new JScrollPane(table);

        this.add(scrollPane);

    }

    /* listeners */

    /* methods */


}
