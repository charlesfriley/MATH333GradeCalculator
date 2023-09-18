import javax.swing.*;

public class Help extends JPanel{
    
    /* instance variables */
    private JLabel helpppppp;

    /* constructer */
    public Help()
    {
        helpppppp = new JLabel("helpppppp");

        this.add(helpppppp);
    }

    /* methods */


    public static void openHelpWindow()
    {
        JFrame helpframe = new JFrame("Help");
        helpframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpframe.add(new Help());
        helpframe.pack();
        helpframe.setVisible(true);
        //TODO add a way to set the starting position of the window to the center of the screen.
    }
}