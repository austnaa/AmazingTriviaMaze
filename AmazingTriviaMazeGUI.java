import java.awt.GridLayout;
import javax.swing.JFrame;

import player.PlayerActions;

public class AmazingTriviaMazeGUI extends JFrame
{
    public AmazingTriviaMazeGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Player Movement");
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        initialize();
    }

    public void initialize()
    {
        setLayout(new GridLayout(1, 1, 0, 0));

        PlayerActions screen = new PlayerActions();

        add(screen);

        setVisible(true);
    }


    public static void main(final String[] theArgs)
    {
        AmazingTriviaMazeGUI frame = new AmazingTriviaMazeGUI();
    }
}