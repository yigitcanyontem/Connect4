import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Graph extends JPanel implements MouseListener {
    static Graphics2D g2;
    static int position;
    static int col1 = 805;
    static int col2 = 805;
    static int col3 = 805;
    static int col4 = 805;
    static int col5 = 805;
    static int col6 = 805;
    static int col7 = 805;
    static int[] coordinates;
    static Map<int[],Color> map = new HashMap<>();
    static Color orange = new Color(214,71,0);
    static Color yellow = new Color(235,235,0);
    static Color color = yellow;

    Graph() {
        setPreferredSize(new Dimension(1100,950));
        addMouseListener(this);
    }

    public void paintComponent(Graphics g ) {
        g2 = (Graphics2D) g;
        g2.setColor(new Color(0,102,153));
        g2.fillRect(0,0,1100,950);

        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 6; j++){
                g2.setColor(new Color(0,40,96));
                g2.fillOval(i*160,j*160,130,130);

                g2.setColor(new Color(224,224,224));
                g2.fillOval(i*160+5,j*160+5,120,120);
            }
        }

        /*
            [5, 5]
            [5, 165]
            [5, 325]
            [5, 485]
            [5, 645]
            [5, 805]

            [165, 5]
            [165, 165]
            [165, 325]
            [165, 485]
            [165, 645]
            [165, 805]

            [325, 5]
            [325, 165]
            [325, 325]
            [325, 485]
            [325, 645]
            [325, 805]

            [485, 5]
            [485, 165]
            [485, 325]
            [485, 485]
            [485, 645]
            [485, 805]

            [645, 5]
            [645, 165]
            [645, 325]
            [645, 485]
            [645, 645]
            [645, 805]

            [805, 5]
            [805, 165]
            [805, 325]
            [805, 485]
            [805, 645]
            [805, 805]

            [965, 5]
            [965, 165]
            [965, 325]
            [965, 485]
            [965, 645]
            [965, 805]
         */
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.getMousePosition().x < 165){
            coordinates = new int[]{5, col1};
            map.put(coordinates,color);
            updater(5,col1);
            col1 -= 160;
        }else if(this.getMousePosition().x < 325){
            coordinates = new int[]{165, col2};
            map.put(coordinates,color);
            updater(165,col2);
            col2 -= 160;
        }else if(this.getMousePosition().x < 485){
            coordinates = new int[]{325, col3};
            map.put(coordinates,color);
            updater(325,col3);
            col3 -= 160;
        }else if(this.getMousePosition().x < 645){
            coordinates = new int[]{485, col4};
            map.put(coordinates,color);
            updater(485,col4);
            col4 -= 160;
        }else if(this.getMousePosition().x < 805){
            coordinates = new int[]{645, col5};
            map.put(coordinates,color);
            updater(645,col5);
            col5 -= 160;
        }else if(this.getMousePosition().x < 965){
            coordinates = new int[]{805, col6};
            map.put(coordinates,color);
            updater(805, col6);
            col6 -= 160;
        }else{
            coordinates = new int[]{965, col7};
            map.put(coordinates,color);
            updater(965,col7);
            col7 -= 160;
        }
    }

    public void updater(int positionx, int positiony){
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(positionx,positiony,121,121);

        for(int[] i:map.keySet()){
            System.out.println(i[0] +" "+ i[1]+ " " +map.get(i));
        }


        if(color == yellow){
            color = orange;
        }else {
            color = yellow;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }


}
