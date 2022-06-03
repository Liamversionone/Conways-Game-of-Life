package mod;

import javax.swing.JOptionPane;

public class Sizer {
	String row, col;
	int r, c;
	boolean complete;
	boolean[][] lights;
	
	//Getters
	public int getRow() {return r;}
	public int getCol() {return c;}
	public boolean[][] getArray() {return lights;}
	
	//This constructor is used to create a 2D boolean array that holds the values that are used to determine if a cell is alive or dead. It asks the user what
	//dimensions they would like to use.
	public Sizer() {
		complete = false;
		while(!complete) {
			row = JOptionPane.showInputDialog(null, "What size do you want?");
			r = Integer.parseInt(row);
			if(r < 5 || r > 50) {
				if(r < 5)
					JOptionPane.showMessageDialog(null, "The minimum size you can have is 5.");
				else
					JOptionPane.showMessageDialog(null, "The maximum size you can have is 50.");
			}
			else {
				complete = true;
			}
		}
		lights = new boolean[r][r];
	}
}
