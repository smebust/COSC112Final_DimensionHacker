import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Random;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.util.ArrayList;
public class Item{   

    //~~~~~~~~~~~~~~~~~~~~
    //Data Members
    //~~~~~~~~~~~~~~~~~~~~
    
    //Type of item
    public int type;

    //Position
    public int xPos;
    public int yPos;

    //height and width of character
    public int itHeight;
    public int itWidth;

    //what image to use
    Image i;
    Toolkit t;


    //~~~~~~~~~~~~~~~~~~~~
    //Constructor
    //~~~~~~~~~~~~~~~~~~~~
        public Item(int t, int x, int y, int w, int h){
            xPos = x;
            yPos = y;
            itWidth = w;
            itHeight = h;
            type = t;
            if(t == 1){
                type=1;
                try{
                    File f = new File("keyboard.png");
                    i = ImageIO.read(f);
                    i = i.getScaledInstance(itWidth,itHeight, Image.SCALE_DEFAULT);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            if(t == 2){
                type=2;
                try{
                    File f = new File("monitor.png");
                    i = ImageIO.read(f);
                    i = i.getScaledInstance(itWidth,itHeight, Image.SCALE_DEFAULT);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            if(t == 3){
                type=3;
                try{
                    File f = new File("desktop.png");
                    i = ImageIO.read(f);
                    i = i.getScaledInstance(itWidth,itHeight, Image.SCALE_DEFAULT);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        } 
    }