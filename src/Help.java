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
        JFrame frame = new JFrame("Help");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Help());
        frame.pack();
        frame.setVisible(true);
        //TODO add a way to set the starting position of the window to the center of the screen.
    }
}