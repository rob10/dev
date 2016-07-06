import java.awt.Graphics;
import javax.swing.JFrame;

public class DrawLines extends JFrame{
	
	final private int BOARD_SIZE = 960;
	
	
	
	/**
	 * 
	 * This constructor creates the JFrame window sets its boundaries
	 * 
	 * 
	 */
	public DrawLines()
	{
		
		setTitle("Draw Lines");
		setSize(BOARD_SIZE, BOARD_SIZE);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	
	/**
	 * This method draws the lines. It uses a for loop to draw multiple lines.
	 * It gets the width and length of the current size of the window, and it uses
	 * that information to know what the starting and ending point of the line is going
	 * to be. It then creates lines staring from each corner of the window that meet with
	 * eachother diagonally across the window.
	 *  
	 * 
	 */
	public void paint(Graphics g)
	{
		//set these variables to the ending point of the first line
		int y = getContentPane().getHeight();
		int x2 = getContentPane().getWidth();
		int y2 = getContentPane().getHeight();
		
		//for loop ends when the first set of lines starting from the top left corner
		//ends, which would be the same amount of iterations that all the other corners
		//need. For loops increments and decrements variables to simulate moving right 
		//horizontally and up vertically, or left and down depending on the corner.
		for(int i = 0; i<getContentPane().getWidth(); i+=40)
		{
			 
			//start from top left corner
			g.drawLine(0, 0, i, y);
			//start from top right corner
			g.drawLine(getContentPane().getWidth(), 0, x2, y2);
			//start from bottom left corner
			g.drawLine(0, getContentPane().getHeight(), x2, y2);
			//start from bottom right corner
			g.drawLine(getContentPane().getWidth(), getContentPane().getHeight(), i, y);
			
			
			//decrement this variable by 20, which started as the maz size of the window.
			y -= 40;
			x2 -= 40;
			y2 -= 40;
			
		}
		
		
		
	}
	
}
