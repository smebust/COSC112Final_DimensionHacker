import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Random;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel{
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // GUI window dimensions
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static final int BOX_WIDTH = 1024;
    public static final int BOX_HEIGHT = 768; 
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Data Members
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	
    static int level = 1;

    static Player player;

    static Color bkgrnd;
    static Color door;
    static Color door1;
    
    // Track Player Position
    static double playerPosX=0;
    static double playerPosY=0;

    //Store enemies and positions to print out
    static ArrayList<Enemy> enemies = new ArrayList<Enemy>();


    // Are we in haxorLand?
    static boolean haxorLand;

    // From Scott
    static Image i;
    Toolkit t;

    static Item part;
    static int haxItemCount = 0;
	
	//Gravity component
	public static int gAmt=0;

	//Ends game
	public static boolean endGame = false;
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Main Method  
    // Draws Frame, KeyListeners
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
    public static void main(String[] args){
	
	player = new Player();
	
	JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(BOX_WIDTH,BOX_HEIGHT);
	Game mainInstance = new Game();
	frame.setContentPane(mainInstance);
	
	frame.setVisible(true);
	
	frame.addKeyListener(new KeyListener(){
		
		public void keyPressed(KeyEvent e){
		    char c = e.getKeyChar();
		    Player.startMove(c);
		}
		
		public void keyTyped(KeyEvent e){
		}
		
		public void keyReleased(KeyEvent e){
		    char c = e.getKeyChar();
		    Player.stopMove(c);
		}
	    });
    }
    //~~~~~~~~~~~~~~~~~~~~~~
    // Constructor
    //~~~~~~~~~~~~~~~~~~~~~~
    public Game(){                                                                                              
	
        haxorLand = false;                                                                                                                                            
	
	// Load level
	if (level == 1){
	    loadLevel1();
	} else if (level == 2){
	    loadLevel2();
	} else if (level == 3){
	    loadLevel3();
	} else if (level == 4){
	    loadLevel4();
	}
	
	Thread mainThread = new Thread(new Runner());
	mainThread.start();

    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // These methods load the different levels
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void loadLevel1(){
		// Clears enemy array to make room for new enemies
		enemies.clear();
	
		// Set colors
		bkgrnd = Color.BLACK;
		door = Color.GREEN;
	
		// Used for returning to previous level or spawning Player in correct spot
		if(level==2){
		    playerPosX += 880;
		    level =1;
		} else {
		    playerPosX = 30;
		    playerPosY = 300;
		}
		// HaxorItem
		if(haxItemCount==0){
		    part = new Item(1, 200, 420, 75, 75);
		}

		// Fills enemy array with new enemies
		Enemy en1 = new Enemy(2, 300, 290, 50, 50);
		Enemy en2 = new Enemy(4, 300, 400, 50, 50);
		Enemy en3 = new Enemy(1, 730, 350, 50, 50);
		enemies.add(en1);
		enemies.add(en2);
		enemies.add(en3);

		//Determines which file to use as character image
		Player.setPlayerImage(level, 30, 30);
    }
    
    public static void loadLevel2(){
		if (level==3){
		    playerPosX += 880;
		} else {
		    playerPosX = 30;
		    playerPosY = 300;
		}
		if(haxItemCount==1){
		    part = new Item(2, 500, 85, 75, 75);
		}
	
		level = 2;
		enemies.clear();
		bkgrnd = Color.GREEN;
		door = Color.WHITE;
		door1 = Color.BLACK;
	
		Enemy en1 = new Enemy(2, 200, 275, 50, 50);
		Enemy en2 = new Enemy(2, 360, 275, 50, 50);
		Enemy en3 = new Enemy(2, 660, 275, 50, 50);
		enemies.add(en1);
		enemies.add(en2);
		enemies.add(en3);
		Player.setPlayerImage(level, 30,30);
    }
    
    public static void loadLevel3(){
		if (level==4){
			playerPosY = 450;
			playerPosX = 700;
			
		} else{
		    playerPosX = 30;
		    playerPosY = 55;
		}
		if(haxItemCount==2){
		    part = new Item(3, 440, 350, 75, 75);
		}
	
		level = 3;
		enemies.clear();
		bkgrnd = Color.WHITE;
		door1 = Color.GREEN;
		door = Color.BLUE;
	
		Enemy en1 = new Enemy(1, 500, 500, 50, 50);
		Enemy en2 = new Enemy(2, 300, 400, 50, 50);
		Enemy en3 = new Enemy(3, 400, 200, 50, 50);
		Enemy en4 = new Enemy(4, 600, 300, 50, 50);
		enemies.add(en1);
		enemies.add(en2);
		enemies.add(en3);
		enemies.add(en4);
		Player.setPlayerImage(level, 30,30);
    }
    
    public static void loadLevel4(){
		playerPosX = 30;
		playerPosY = 450;
		level = 4;
		enemies.clear();
		bkgrnd = Color.BLUE;
		door1 =Color.WHITE;
		door = Color.RED;
	
		Enemy en1 = new Enemy(1, 300, 550, 50, 50);
		Enemy en2 = new Enemy(3, 725, 550, 50, 50);
	
		enemies.add(en1);
		enemies.add(en2);
		Player.setPlayerImage(level, 60, 100);
	}
	public static void loadEndScreen(){
		enemies.clear();
	
		Enemy en1 = new Enemy(5, 150, 100, 350, 120);
	
		enemies.add(en1);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Checks to see if all 3 haxItems have been collected
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void loadHaxorLand(){
	if(haxItemCount == 3){
	    haxorLand = true;
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // paintComponent
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	World world = new World();

	g.setColor(bkgrnd);
	g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

	//Ends Game
	if(endGame){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);
	}
	
	// Draws enemies
	for (int j = 0; j < enemies.size(); j++){
	    Enemy toDraw = enemies.get(j);
	    g.drawImage(toDraw.i, toDraw.enemX, toDraw.enemY, null);
	}
	
	g.drawImage(player.getImage(), (int)playerPosX, (int)playerPosY, null);
	
	if(level == 1){
		// Draws Door
	    g.setColor(door);
	    g.fillRect(900, 280, 250, 150);

	    // Draws Level                                                                                                                                                                                                               

            g.setColor(Color.RED);
            g.fillPolygon(World.polyX1(level), World.polyY1(level), World.numPoints1(level));
	    g.fillPolygon(World.polyX2(level), World.polyY2(level), World.numPoints2(level));
	    g.fillPolygon(World.polyX3(level), World.polyY3(level), World.numPoints3(level));
	    g.fillPolygon(World.polyX4(level), World.polyY4(level), World.numPoints4(level));

		if(haxItemCount==0){
			g.drawImage(part.i, part.xPos, part.yPos, null);
		}

	}
	if(level == 2){
		// Draws Doors
	    g.setColor(door);
	    g.fillRect(900, 280, 250, 150);
	    g.setColor(door1);
	    g.fillRect(-150, 280, 250, 150);
	    
	    // Draws Level
	    g.setColor(Color.RED);
	    g.fillPolygon(World.polyX1(level), World.polyY1(level), World.numPoints1(level));
	    g.fillPolygon(World.polyX2(level), World.polyY2(level), World.numPoints2(level));

		if(haxItemCount==1){
			g.drawImage(part.i, part.xPos, part.yPos, null);
			System.out.println(part.xPos + " " + part.yPos + " ");
		}
	}
	if(level == 3){
		// Draws Doors
	    g.setColor(door);
	    g.fillRect(900, 500, 250, 150);
	    g.setColor(door1);
	    g.fillRect(-150, 55, 250, 150);

	    // Draws Level                                                                                                                                                                                                                    
            g.setColor(Color.BLACK);
            g.fillPolygon(World.polyX1(level), World.polyY1(level), World.numPoints1(level));
            g.fillPolygon(World.polyX2(level), World.polyY2(level), World.numPoints2(level));
	    
	    if(haxItemCount==2){
		g.drawImage(part.i, part.xPos, part.yPos, null);
	    }
	}
	if(level == 4){
		// Draws Doors
	    g.setColor(door);
	    g.fillRect(1000, 400, 250, 200);
	    g.setColor(door1);
	    g.fillRect(-220, 450, 250, 150);

	    // Draws Level
            g.setColor(Color.BLACK);
            g.fillPolygon(World.polyX1(level), World.polyY1(level), World.numPoints1(level));
            g.fillPolygon(World.polyX2(level), World.polyY2(level), World.numPoints2(level));

	}
    }
    
    
    class Runner implements Runnable{
	
	public void run(){
		int count=0;
		int jHeight=-20;
	    while(true){
		// Change V this to adjust how far enemies travel
		if(count%150 == 0){
		    for(int i=0; i<enemies.size(); i++){
			enemies.get(i).changeDirec();
		    }
		}
		// Updates enemy position
		for(int i=0; i<enemies.size(); i++){
		    enemies.get(i).updatePos();
		}

		//Updates player position
		Player.movePlayer(level, gAmt);
		if(Player.playerMovingUp&&gAmt==0){
			gAmt=jHeight;
		}
		gAmt++;

		// Reloads level if player is touching enemy
		for(int i=0; i<enemies.size(); i++){
		    if(Player.checkTouchEnem(enemies.get(i))){
			if(level==1) loadLevel1();
			if(level==2) loadLevel2();
			if(level==3) loadLevel3();
			if(level==4) loadLevel4();
		    }
		}
		
		// Registers that player has collected an item (one per level)
		if(Player.checkTouchItem(part)){
			if (level == 1){ 
				haxItemCount=1;
				System.out.println("You need " + (3-haxItemCount) + " more items!");
			}
			if (level == 2){
				haxItemCount=2;
				System.out.println("You need " + (3-haxItemCount) + " more items!");
			}
			if (level == 3){
				haxItemCount=3;
				System.out.println("You need " + (3-haxItemCount) + " more items!");
			}
		}

		// Reloads level if player is touching wall
		if(Player.checkTouchWall(level)){
		    if(level==1) loadLevel1();
		    if(level==2) loadLevel2();
		    if(level==3) loadLevel3();
		    if(level==4) loadLevel4();
		}
		    

		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Level changes
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		
		if (level == 1 && playerPosY<420 && playerPosY>280){
		    if(playerPosX>900){
		    	System.out.println("Level 2");
			loadLevel2();
		    }
		}
		if (level == 2 && playerPosY<430 && playerPosY>280){
		    if(playerPosX>900){
		    	System.out.println("Level 3");
			loadLevel3();
		    }
		    if(playerPosX<10){
			System.out.println("Level 1");
			loadLevel1();
		    }
		}
		//Only allows player to progress if they have all computer parts
		if (level == 3){
		    if(playerPosX>900){
				if((playerPosY > 500) && (playerPosY < 650)){
					if(haxItemCount==3){
						System.out.println("You hacked the Game! Welcome to level 4");
						loadLevel4();
					}
					if(haxItemCount!=3){
						System.out.println("You need " + (3-haxItemCount) + " more items!");
					}
				}
		    }
		    if(playerPosX<10){
				if((playerPosY<205) && (playerPosY>55)){
			    	System.out.println("Level 2");
			    	loadLevel2();
				}
		    }
		}

		//Ends Game

		if (level == 4 && playerPosY<650 && playerPosY>500){
		    if(playerPosX<10){
			System.out.println("Level 3");
			loadLevel3();
		    }
		    if(playerPosX>800){
				System.out.println("You've Won the Game!!");
				loadEndScreen();
				endGame = true;
		    }
		}
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		try{
		    Thread.sleep((int)(1000.0/60.0));
		}
		catch(InterruptedException e){}
		repaint();
		count++;
		if(count>100000) count=0;
		if(gAmt>10000) gAmt=0;
		if(endGame) break;
		}
	}
    }
}