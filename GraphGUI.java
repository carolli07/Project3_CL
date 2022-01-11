import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class GraphGUI extends JFrame {
    ////set frame 500*500 height (getheight())
////find max/min la(y)+lo(x)
////drawline x1, y1/ x2, y2
//    // loop through from the min and max
////y1 = 500-(la1-minla)/(maxlat-minlat)*height
////x = (lo-minlo)/(maxlo-minlo)*length
//
    static double minla, minlo, maxla, maxlo;
    int length = 600;
    int height = 600;
    int x1, x2, y1, y2;

    public GraphGUI() {
        setSize(600,600);// set the frame size
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close the frame and stop the program
    }

    //(this.height-25)
    public void display() throws FileNotFoundException {
        Graph g = new Graph();
        g.readFromfile();

        minla = g.minla;
        minlo = g.minlo;
        maxla = g.maxla;
        maxlo = g.maxlo;
        String s = "r";

//        g.distance(minla,minlo, maxla, maxlo);
    }

    public void paint(Graphics m) {
        super.paint(m);
        String s = "r";
        m.setColor(Color.BLUE);
        Graph g = new Graph();
        try {
            g.readFromfile();
        } catch (Exception e) {

        }
        for(String i: g.road.keySet()){
            double xone = g.getE(i).getStart().getIlatitude();
            double yone = g.getE(i).getStart().getIlongitude();
            double xtwo = g.getE(i).getEnd().getIlatitude();
            double ytwo = g.getE(i).getEnd().getIlongitude();
            int x1 = (int) (length-50-(xone - minla) / (maxla - minla) * length-50)+100;
            int y1 = (int) (height - (yone - minlo) / (maxlo - minlo) * height);
            int x2 = (int) (length-50-(xtwo - minla) / (maxla - minla) * length-50)+100;
            int y2 = (int) (height -  (ytwo - minlo) / (maxlo - minlo) * height);
            m.drawLine(height-y1, x1, height-y2, x2);
        }
    }

    public void draw() {
        setTitle("iMap Pro");
        setVisible(true);
    }

}