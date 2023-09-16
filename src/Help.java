import javax.swing.JFrame;
import javax.swing.JPanel;

public class Help extends JPanel{
    
    /* instance variables */

    /* constructer */

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