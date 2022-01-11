import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GraphGUI graphCanvas = new GraphGUI();
        graphCanvas.draw();
        graphCanvas.display();
    }
}
