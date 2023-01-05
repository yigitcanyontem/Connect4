import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class Graph extends JPanel implements MouseListener {
    static Graphics2D g2;
    static int position;
    static int defCol;
    static int col1 = 805;
    static int col2 = 805;
    static int col3 = 805;
    static int col4 = 805;
    static int col5 = 805;
    static int col6 = 805;
    static int col7 = 805;
    static Map<Integer,ArrayList<Integer>> yellowMap = new HashMap<>();
    static Map<Integer,ArrayList<Integer>> orangeMap = new HashMap<>();
    static Color orange = new Color(214,71,0);
    static Color yellow = new Color(235,235,0);
    static Color color = yellow;
    static ArrayList<Integer> arrayList;

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
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.getMousePosition().x < 165){
            position = 5;
            defCol = col1;
            col1 -= 160;
        }else if(this.getMousePosition().x < 325){
            position = 165;
            defCol = col2;
            col2 -= 160;
        }else if(this.getMousePosition().x < 485){
            position = 325;
            defCol = col3;
            col3 -= 160;
        }else if(this.getMousePosition().x < 645){
            position = 485;
            defCol = col4;
            col4 -= 160;
        }else if(this.getMousePosition().x < 805){
            position = 645;
            defCol = col5;
            col5 -= 160;
        }else if(this.getMousePosition().x < 965){
            position = 805;
            defCol = col6;
            col6 -= 160;
        }else{
            position = 965;
            defCol = col7;
            col7 -= 160;
        }

        if(yellowMap.get(position) == null || orangeMap.get(position) == null){
            updater(position,defCol);
            adder();
        }else {
            if (yellowMap.get(position).size() + orangeMap.get(position).size() < 6){
                updater(position,defCol);
                adder();
            }
        }
        winCheck();
        if(color == yellow){
            color = orange;
        }else {
            color = yellow;
        }
    }

    public void updater(int positionx, int positiony){
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(positionx,positiony,121,121);


    }

    public void winPaint(int positionx, int positiony){
        Graphics g = getGraphics();
        g.setColor(new Color(254,155,0));
        g.fillOval(positionx-5,positiony-5,131,131);

        g.setColor(color);
        g.fillOval(positionx,positiony,120,120);
    }

    public void winCheck(){
        /*
            [5, 5]   [5, 165]   [5, 325]   [5, 485]   [5, 645]   [5, 805]
            [165, 5] [165, 165] [165, 325] [165, 485] [165, 645] [165, 805]
            [325, 5] [325, 165] [325, 325] [325, 485] [325, 645] [325, 805]
            [485, 5] [485, 165] [485, 325] [485, 485] [485, 645] [485, 805]
            [645, 5] [645, 165] [645, 325] [645, 485] [645, 645] [645, 805]
            [805, 5] [805, 165] [805, 325] [805, 485] [805, 645] [805, 805]
            [965, 5] [965, 165] [965, 325] [965, 485] [965, 645] [965, 805]
         */

        for (int i = 0; i < 7; i++){
            for(int j = 0; j < 4; j++){
                checkWin(yellowMap,i,j);
                checkWin(orangeMap,i,j);
            }

        }
    }

    public void checkWin(Map<Integer,ArrayList<Integer>> map, int i, int j){
        int[] rows = {5,165,325,485,645,805};
        int[] columns = {5,165,325,485,645,805,965};
        try {
            if ((map.get(columns[i]).get(j) - map.get(columns[i]).get(j+1) == 160)
                    && (map.get(columns[i]).get(j+1) - map.get(columns[i]).get(j+2) == 160)
                    && (map.get(columns[i]).get(j+2) - map.get(columns[i]).get(j+3) == 160)){

                removeMouseListener(this);
                winPaint(columns[i],map.get(columns[i]).get(j));
                winPaint(columns[i],map.get(columns[i]).get(j+1));
                winPaint(columns[i],map.get(columns[i]).get(j+2));
                winPaint(columns[i],map.get(columns[i]).get(j+3));
            }
        }catch (Exception e){
            //
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        try {
            for (int var:rows){
                if (    map.get(list.get(i)).contains(var) &&
                        map.get(list.get(i+1)).contains(var) &&
                        map.get(list.get(i+2)).contains(var) &&
                        map.get(list.get(i+3)).contains(var)){

                    removeMouseListener(this);
                    winPaint(list.get(i),var);
                    winPaint(list.get(i+1),var);
                    winPaint(list.get(i+2),var);
                    winPaint(list.get(i+3),var);
                }
            }
        }catch (Exception e){
            //
        }


    }

    public void adder(){
        if(color == yellow){
            if(orangeMap.get(position) != null){
                arrayList = new ArrayList<>(orangeMap.get(position));
            }else{
                arrayList = new ArrayList<>();
            }
            arrayList.add(defCol);
            orangeMap.put(position,arrayList);
        }else if (color == orange){
            if(yellowMap.get(position) != null){
                arrayList = new ArrayList<>(yellowMap.get(position));
            }else{
                arrayList = new ArrayList<>();
            }
            arrayList.add(defCol);
            yellowMap.put(position,arrayList);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
