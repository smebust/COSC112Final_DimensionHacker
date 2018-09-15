import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Random;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.util.ArrayList;


// Class World is used to print out level landscapes
// The polyX/Y methods return an int[] to be used by fillPolygon(int [], int[], int) in class Game
// numPoints method returns number of points to be used in fillPolygon


public class World{

    public World(){
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Called for any level with one or more obstacle
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // Returns array of x-coordinates
    public static int[] polyX1(int level){
	// The array
	int[] x = new int[1];

	// Depending on the level, these if statements fill the arrays with x-coordinates of the first polygon to be drawn

	if(level == 1){
	    x = new int[] {770, 1024, 1024, 770};
	    return x;
	}

	if(level == 2){
	    x = new int[] {0, 1024, 1024, 740, 740, 650, 650, 440, 440, 600, 600, 350, 350, 260, 260, 200, 200, 0};
	    return x;
	}

	if(level == 3){
	    x = new int[] {0, 1024, 1024, 850, 850, 0};
	    return x;    
	}         

	if(level == 4){
	    x = new int[] {0, 500, 500, 0};
	    return x;
	}

	if(level == 5){
	    x = new int[] {0, 300, 300, 0};
	    return x;
	}

 	else if(level == 6){
	    x = new int[] {90, 125, 125, 160, 160, 195, 195, 230, 230, 265, 265, 300, 300, 350, 350, 90};
	    return x;
	}

	return x;
    }
    
    // Returns array of y-coordinates
    public static int[] polyY1(int level){
	
	int[] y = new int[1];

	// Depending on the level, these if statements fill the arrays with y-coordinates of the first polygon to be drawn 

	if(level == 1){
	    y = new int[] {0, 0, 280, 280};
	    return y;
        }
        if(level == 2){
	    y = new int[] {0, 0, 280, 280, 55, 55, 550, 550, 165, 165, 55, 55, 280, 280, 110, 110, 280, 280};
	    return y;
        }
        if(level == 3){
	    y = new int[] {0, 0, 510, 510, 55, 55};
	    return y;
        }
        if(level == 4){
	    y = new int[] {600, 600, 768, 768};
	    return y;
        }
        if(level == 5){
	    y = new int[] {650, 650, 768, 768};
	    return y;
        }
        else if(level == 6){
	    y = new int[] {495, 495, 440, 440, 385, 385, 330, 330, 275, 275, 220, 220, 165, 165, 550, 550};
	    return y;
        }
	
	return y;

    }

    // Returns number of points in polygon
    public static int numPoints1(int level){

	int n = 0;

	if(level == 1){
	    n = 4;
	    return n;
        }

        if(level == 2){
	    n = 18;
	    return n;
        }

        if(level == 3){
	    n = 6;
	    return n;
        }

        if(level == 4){
	    n = 4;
	    return n;
        }

        if(level == 5){
	    n = 4;
	    return n;
        }

        else if(level == 6){
	    n = 16;
	    return n;
        }

	return n;

    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Called for any level with two or more obstacles 
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~       
    public static int[] polyX2(int level){
	
	int[] x2 = new int[1];
	
	if(level == 1){
	    x2 = new int[] {770, 1024, 1024, 770};
	    return x2;
        }
        if(level == 2){
	    x2 = new int[] {0, 200, 200, 260, 260, 350, 350, 740, 740, 1024, 1024, 0};
	    return x2;
        }
        if(level == 3){
	    x2 = new int[] {0, 130, 130, 1024, 1024, 0};
	    return x2;
        }
        if(level == 4){
	    x2 = new int[] {600, 1024, 1024, 600};
	    return x2;
        }
        else if(level == 5){
	    x2 = new int[] {700, 1024, 1024, 700};
	    return x2;
        }

	return x2;

    }

    public static int[] polyY2(int level){

	int[] y2 = new int[1];
	
	if(level == 1){
	    y2 = new int[] {430, 430, 770, 770};
	    return y2;
        }
        if(level == 2){
	    y2 = new int[] {400, 400, 650, 650, 400, 400, 650, 650, 400, 400, 768, 768};
	    return y2;
        }
        if(level == 3){
	    y2 = new int[] {165, 165, 645, 645, 768, 768};
	    return y2;
        }
        if(level == 4){
	    y2 = new int[] {600, 600, 768, 768};
	    return y2;
        }
        else if(level == 5){
	    y2 = new int[] {650, 650, 768, 768};
	    return y2;
        }

	return y2;

    }

    public static int numPoints2(int level){
	
	int n2 = 0;
	
	if(level == 1){
	    n2 = 4;
	    return n2;
	}
	if(level == 2){
	    n2 = 12;
	    return n2;
	}
	if(level == 3){
	    n2 = 6;
	    return n2;
	}
	if(level == 4){
	    n2 = 4;
	    return n2;
	}
	else if(level == 5){
	    n2 = 4;
	    return n2;
	}

	return n2;
	
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Called for levels with three or more obstacles
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public static int[] polyX3(int level){
	
	int[] x3 = new int[1];

	if(level == 1){
	    x3 = new int[] {120, 300, 300, 120, 120, 295, 295, 0, 0, 295, 295, 120};
	    return x3;
	}
	
	else if(level == 5){
	    x3 = new int[] {200, 375, 375, 200};
	    return x3;
	}
	
	return x3;

    }
    
    public static int[] polyY3(int level){
	
	int[] y3 = new int[1];
	
	if(level == 1){
	    y3 = new int[] {105, 105, 565, 565, 560, 560, 395, 395, 390, 390, 110, 110};
	    return y3;
	}
	if(level == 5){
	    y3 = new int[] {560, 560, 565, 565};
	    return y3;
	}
	return y3;
    }

    public static int numPoints3(int level){
	
	int n3 = 0;
	
	if(level == 1){
	    n3 = 12;
	    return n3;
	}
	else if(level == 5){
	    n3 = 4;
	    return n3;
	}

	return n3;

    }
	
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Called for levels with four or more obstacles
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static int[] polyX4(int level){
	int[] x4 = new int[1];
	
	if(level == 1){
	    x4 = new int[] {0, 180, 180, 0};
	    return x4;
	}
	else if(level == 5){
	    x4 = new int[] {650, 800, 800, 650};
	    return x4;
	}

	return x4;

    }

    public static int[] polyY4(int level){
	int[] y4 = new int[1];
	
	if(level == 1){
	    y4 = new int[] {225, 225, 230, 230};
	    return y4;
	}
	else if(level == 5){
	    y4 = new int[] {560, 560, 565, 565};
	    return y4;
	}

	return y4;

    }
    
    public static int numPoints4(int level){
	int n4 = 0;
	if(level == 1){
	    n4 = 4;
	    return n4;
	}
	else if(level == 5){
	    n4 = 4;
	    return n4;
	}

	return n4;

    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Called for levels with 5 or more obstacles
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static int[] polyX5(int level){
	int[] x5 = new int[] {425, 575, 575, 425};
	return x5;
       
    }
    
    public static int[] polyY5(int level){
	int[] y5 = new int[] {430, 430, 435, 435};
	return y5;
	
    }
    
    public static int numPoints5(int level){
	int n5 = 4;
	return n5;
    }
}