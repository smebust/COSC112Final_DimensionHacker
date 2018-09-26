import java.util.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Random;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.util.ArrayList;

public class Player {
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Variables
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    //Player image
    static Image image;
	
    //Checks direction of player movement, changes to true when key is held
    static boolean playerMovingLeft = false;
    static boolean playerMovingRight = false;
    static boolean playerMovingDown = false;
    static boolean playerMovingUp = false;
    
    static boolean jump = false;

    //Height and Width character
    public static int pWidth;
	public static int pHeight;
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Constructor
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public Player(){
		setPlayerImage(1,30,30);
	}
		
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// Methods
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//sets the image used by player class depending on level
	public static void setPlayerImage(int level, int w, int h){
		pWidth=w;
		pHeight=h;
		if (level==1||level==2||level==3){
			try{
				File f = new File("player.png");
				image = ImageIO.read(f);
				image = image.getScaledInstance(pWidth, pHeight, Image.SCALE_DEFAULT);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}

		if (level ==4){
			try{
				File f = new File("morty.png");
				image = ImageIO.read(f);
				image = image.getScaledInstance(pWidth, pHeight, Image.SCALE_DEFAULT);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
    
    //Returns true if player is touching an enemy
    public static boolean checkTouchEnem(Enemy e){
	boolean toReturn=false;
	if(((Game.playerPosX+pWidth)>=(e.enemX)) && ((Game.playerPosX+pWidth)<=(e.enemX+e.enWidth))){
	    if(((Game.playerPosY+pHeight)>=(e.enemY)) && ((Game.playerPosY+pHeight)<=(e.enemY+e.enHeight)))
		toReturn=true;
	}
	if(((Game.playerPosX)>=(e.enemX)) && ((Game.playerPosX)<=(e.enemX+e.enWidth))){
	    if(((Game.playerPosY+pHeight)>=(e.enemY)) && ((Game.playerPosY+pHeight)<=(e.enemY+e.enHeight)))
		toReturn=true;
	}
	if(((Game.playerPosX+pWidth)>=(e.enemX)) && ((Game.playerPosX+pWidth)<=(e.enemX+e.enWidth))){
	    if(((Game.playerPosY)>=(e.enemY)) && ((Game.playerPosY)<=(e.enemY+e.enHeight)))
		toReturn=true;
	}
	if(((Game.playerPosX)>=(e.enemX)) && ((Game.playerPosX)<=(e.enemX+e.enWidth))){
	    if(((Game.playerPosY)>=(e.enemY)) && ((Game.playerPosY)<=(e.enemY+e.enHeight)))
		toReturn=true;
	}
	return toReturn;
    }
    //Returns true if player is touching an item
    public static boolean checkTouchItem(Item p){
	boolean toReturn=false;
	if(((Game.playerPosX+pWidth)>=(p.xPos)) && ((Game.playerPosX+pWidth)<=(p.xPos+p.itWidth))){
	    if(((Game.playerPosY+pHeight)>=(p.yPos)) && ((Game.playerPosY+pHeight)<=(p.yPos+p.itHeight)))
		toReturn=true;
	}
	if(((Game.playerPosX)>=(p.xPos)) && ((Game.playerPosX)<=(p.xPos+p.itWidth))){
	    if(((Game.playerPosY+pHeight)>=(p.yPos)) && ((Game.playerPosY+pHeight)<=(p.yPos+p.itHeight)))
		toReturn=true;
	}
	if(((Game.playerPosX+pWidth)>=(p.xPos)) && ((Game.playerPosX+pWidth)<=(p.xPos+p.itWidth))){
	    if(((Game.playerPosY)>=(p.yPos)) && ((Game.playerPosY)<=(p.yPos+p.itHeight)))
		toReturn=true;
	}
	if(((Game.playerPosX)>=(p.yPos)) && ((Game.playerPosX)<=(p.xPos+p.itWidth))){
	    if(((Game.playerPosY)>=(p.yPos)) && ((Game.playerPosY)<=(p.yPos+p.itHeight)))
		toReturn=true;
	}
	return toReturn;
    }
    
    // Checks to see if player is touching a wall
    public static boolean checkTouchWall(int level){
	boolean toReturn = false;
	if(level == 1){
	
	    if ((Game.playerPosX > 770) && (Game.playerPosY < 280)) {
		toReturn = true;
	    }
	    if ((Game.playerPosX > 770) && (Game.playerPosY > 430)) {
		toReturn = true;
	    }
	    if (((Game.playerPosX > 295) && (Game.playerPosX < 300)) && ((Game.playerPosY > 105) && (Game.playerPosY < 565))){
		toReturn = true;
	    }
	    if (((Game.playerPosX > 120) && (Game.playerPosX < 300)) && ((Game.playerPosY > 105) && (Game.playerPosY < 110))){
		toReturn = true;
	    }
	    if (((Game.playerPosX > 0) && ( Game.playerPosX < 295)) && ((Game.playerPosY < 395) && (Game.playerPosY > 390))){
		toReturn = true;
	    }
	    if (((Game.playerPosX > 0) && (Game.playerPosX < 180)) && ((Game.playerPosY > 225) && (Game.playerPosY < 230))){
		toReturn = true;
	    }

	    if ((Game.playerPosX + pWidth > 770) && (Game.playerPosY + pHeight < 280)) {
                toReturn = true;
            }
            if ((Game.playerPosX + pWidth > 770) && (Game.playerPosY + pHeight > 430)) {
                toReturn = true;
            }
            if (((Game.playerPosX + pWidth > 295) && (Game.playerPosX + pWidth < 300)) && ((Game.playerPosY + pHeight > 105) && (Game.playerPosY + pHeight < 565))){
                toReturn = true;
            }
            if (((Game.playerPosX + pWidth > 120) && (Game.playerPosX + pWidth < 300)) && ((Game.playerPosY + pHeight > 105) && (Game.playerPosY + pHeight < 110))){
                toReturn = true;
            }
            if (((Game.playerPosX + pWidth > 0) && ( Game.playerPosX + pWidth < 295)) && ((Game.playerPosY + pHeight < 395) && (Game.playerPosY + pHeight > 390))){
                toReturn = true;
            }
            if (((Game.playerPosX + pWidth > 0) && (Game.playerPosX + pWidth < 180)) && ((Game.playerPosY + pHeight > 225) && (Game.playerPosY + pHeight < 230))){
                toReturn = true;
            }

	}
	
	if(level == 2){
	    if(Game.playerPosY < 55){
		toReturn = true;
	    }
	    if(Game.playerPosY > 650){
		toReturn = true;
	    }
	    if((Game.playerPosX > 740) && (Game.playerPosY < 280)){
		toReturn = true;
	    } 
	    if((Game.playerPosX > 740) && (Game.playerPosY > 400)){
		toReturn = true;
	    }
	    if((Game.playerPosX < 200) && (Game.playerPosY > 400)){
		toReturn = true;
	    }
	    if((Game.playerPosX < 200) && (Game.playerPosY < 280)){
		toReturn = true;
	    }
	    if(((Game.playerPosX > 260) && (Game.playerPosX < 350)) && ((Game.playerPosY < 280) || (Game.playerPosX > 400))){
		toReturn = true;
	    }
	    if(((Game.playerPosX > 440) && (Game.playerPosX < 650)) && ((Game.playerPosY < 550) && (Game.playerPosY > 165))){
		toReturn = true;
	    }
	    if(((Game.playerPosX < 650) && (Game.playerPosX > 600)) && ((Game.playerPosY > 55) && ( Game.playerPosY < 165))){
		toReturn = true;
	    }

	    if(Game.playerPosY + pHeight < 55){
                toReturn = true;
            }
            if(Game.playerPosY + pHeight > 650){
                toReturn = true;
            }
            if((Game.playerPosX + pWidth > 740) && (Game.playerPosY + pHeight < 280)){
                toReturn = true;
            }
            if((Game.playerPosX + pWidth > 740) && (Game.playerPosY + pHeight > 400)){
                toReturn = true;
            }
            if((Game.playerPosX + pWidth < 200) && (Game.playerPosY + pHeight > 400)){
                toReturn = true;
            }
            if((Game.playerPosX + pWidth < 200) && (Game.playerPosY + pHeight < 280)){
                toReturn = true;
            }
            if(((Game.playerPosX + pWidth > 260) && (Game.playerPosX + pWidth < 350)) && ((Game.playerPosY + pHeight < 280) || (Game.playerPosX + pHeight> 400))){
                toReturn = true;
            }
            if(((Game.playerPosX + pWidth > 440) && (Game.playerPosX + pWidth < 650)) && ((Game.playerPosY + pHeight < 550) && (Game.playerPosY + pHeight > 165))){
                toReturn = true;
            }
            if(((Game.playerPosX + pWidth < 650) && (Game.playerPosX + pWidth > 600)) && ((Game.playerPosY + pHeight > 55) && ( Game.playerPosY + pHeight < 165))){
                toReturn = true;
            }

	}
	    
	if(level == 3){
	    if((Game.playerPosY < 55) || (Game.playerPosY > 645) || ((Game.playerPosX + pWidth < 130) && (Game.playerPosY > 165)) || ((Game.playerPosX + pWidth > 820) && (Game.playerPosY < 510))){
		toReturn = true;
	    }
	}
	if(level == 4){
	    if(Game.playerPosY > 650){
		toReturn = true;
	    }
	}
	if(level == 5){
	    if(Game.playerPosY > 650){
		toReturn = true;
	    }
	}
	return toReturn;

    }

    //Image getter
    public Image getImage(){
	return image;
    }
    
    //Allows player to start moving by changing data vars to true
    public static void startMove(char c){
	if (c == 'd'){
	    playerMovingRight = true;
	}
	if (c == 'a'){
	    playerMovingLeft = true;
	}
	if (c == 's'){
	    playerMovingDown = true;
	}
	if (c == 'w'){
	    playerMovingUp = true;
	}
    }
    
    //Stops moving player by setting data vars to false
    public static void stopMove(char c){
	if (c == 'd'){
	    playerMovingRight = false;
	}
	if (c == 'a'){
	    playerMovingLeft = false;
	}
	if (c == 's'){
	    playerMovingDown = false;
	}
	if (c == 'w'){
	    playerMovingUp = false;
	}
    }
    
    //Changes x and y vars to move the player
    // Also makes sure player cannot go out of bounds
    public static void movePlayer(int level, int gAmt){
	if(level==1||level==2||level==3){
	    if (playerMovingRight){
		if (Game.playerPosX+3<Game.BOX_WIDTH-120)
		    Game.playerPosX += 3;
	    }
	    if (playerMovingLeft){
		if(Game.playerPosX-3>0)
		    Game.playerPosX -= 3;
	    }
	    if (playerMovingDown){
		if(Game.playerPosY+3<Game.BOX_HEIGHT-125)
		    Game.playerPosY += 3;
	    }
	    if (playerMovingUp){
		if(Game.playerPosY-3>0)
		    Game.playerPosY -= 3;
	    }
	} else{
		//Implements change in game physics
		//Adds gravity
	    if (playerMovingRight){
		if (Game.playerPosX+3<Game.BOX_WIDTH-120)
		    Game.playerPosX += 3;
	    }
	    if (playerMovingLeft){
		if(Game.playerPosX-3>0)
		    Game.playerPosX -= 3;
	    }
		if (Game.playerPosX>480 && Game.playerPosX<552 && level==4){
			if((Game.playerPosY+pHeight) + gAmt < 800){
				Game.playerPosY += gAmt;
			} else {Game.gAmt=0;}
		} else {
			if((Game.playerPosY+pHeight) + gAmt < 605){
				Game.playerPosY += gAmt;
			} else {Game.gAmt=0;}
		}
	}
    }  
}