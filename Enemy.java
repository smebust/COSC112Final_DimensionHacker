import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Random;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.util.ArrayList;

public class Enemy{

    //~~~~~~~~~~~~~~~~~~~~~~~~
    // Data Members
    //~~~~~~~~~~~~~~~~~~~~~~~~	
	
		// What kind of minion is it?
		int type;
	
		// (x,y)
		public int enemX;
		public int enemY;
		
		//what image to use
		Image i;
		Toolkit t;

		//changes direction of movement u/d/l/r depending on enemy type
		boolean dir=true;

		// rough enemy dimentions for hitboxes
		public int enHeight;
		public int enWidth;
		

    public Enemy(int t, int x, int y, int w, int h){
		enemX=x;
		enemY=y; 
		enWidth=w;
		enHeight=h;
		if(t == 1){
		    this.type=1;
		    try{
			File f = new File("gui.png");
			i = ImageIO.read(f);
			i = i.getScaledInstance(enWidth,enHeight, Image.SCALE_DEFAULT);
		    }
		    catch(Exception e){
			System.out.println(e);
		    }
		}
		if(t == 2){
		    this.type=2;
		    try{
			File f = new File("virus.png");
			i = ImageIO.read(f);
			i = i.getScaledInstance(enWidth,enHeight, Image.SCALE_DEFAULT);
		    }
		    catch(Exception e){
			System.out.println(e);
		    }
		}
		if(t == 3){
		    this.type=3;
		    try{
			File f = new File("rainbowheel1.png");
			i = ImageIO.read(f);
			i = i.getScaledInstance(enWidth,enHeight, Image.SCALE_DEFAULT);
		    }
		    catch(Exception e){
			System.out.println(e);
		    }
		}
		if(t == 4){
		    this.type=4;
		    try{
			File f = new File("error.png");
			i = ImageIO.read(f);
			i = i.getScaledInstance(enWidth,enHeight, Image.SCALE_DEFAULT);
		    }
		    catch(Exception e){
			System.out.println(e);
		    }
		}  
		if(t == 5){
		    this.type=5;
		    try{
			File f = new File("You-Did-It-Congratulations.png");
			i = ImageIO.read(f);
			i = i.getScaledInstance(enWidth,enHeight, Image.SCALE_DEFAULT);
		    }
		    catch(Exception e){
			System.out.println(e);
		    }
		}
    }
    
    public void changeDirec(){
	if(dir){
	    dir=false;
	} else{
	    dir=true;
	}
    }
    public void updatePos(){
	if(dir){
	    if(type==1){
		enemX++;
		enemX++;
	    }
	    if(type==2){
		enemY++;
		enemY++;
	    }
	    if(type==3){
		enemX--;
		enemX--;
	    }
	    if(type==4){
		enemY--;
		enemY--;
	    }
	}else{
	    if(type==1){
		enemX--;
		enemX--;
	    }
	    if(type==2){
		enemY--;
		enemY--;
	    }
	    if(type==3){
		enemX++;
		enemX++;
	    }
	    if(type==4){
		enemY++;
		enemY++;
	    }
	}
    }
}