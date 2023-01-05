import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {

    public GameBoard() throws HeadlessException {
        super("Connect 4");
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        getContentPane().setBackground(new Color(0,102,153));


        gc.weightx = 0;
        gc.weighty = 0;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0,0,0,0);
        add(new Graph(),gc);

        setSize(1150,1050);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
