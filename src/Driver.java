import javax.swing.JFrame;

/**
 * Driver class for MATH333GradeCalculator, launches MainMenu
 */
public class Driver {
    
    /**
     * Create a MainMenu object and open it in a window.
     * @param args unused
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("MATH333 Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainMenu());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);





    }
}
