package mod;

import javax.swing.JOptionPane;

public class Overseer {
	Map map;
	boolean exited;
	int cnt, cnt2, cnt3, numDeadCells;
	String[] options = {"Next Gen", "Exit Game"};
	
	//This constructor is used to inform the user of the rules of the simulation. Until the program is exited, the simulation will continue to run infinitely.
	public Overseer() {
		exited = false;
		cnt = 1;
		JOptionPane.showMessageDialog(null, "Welcome to Liam's version of Conway's Game of Life!");
		JOptionPane.showMessageDialog(null, "The rules are simple:\n1) If a cell that is alive has less than 2 or more than 3 live neighbors, it dies.\n2) If a cell that is dead has exactly 3 live neighbors, it becomes alive.\n(Black cells are dead and white cells are alive)");
		map = new Map();
		while(!exited) {
			cnt2 = 0;
			cnt3 = 0;
			for(int i = 0; i < map.getSizer().getArray().length; i++) {
				for(int j = 0; j < map.getSizer().getArray()[i].length; j++) {
					if(map.getSizer().getArray()[i][j] == true)
						cnt2++;
					else
						cnt3++;
				}
			}
			int result = JOptionPane.showOptionDialog(null, "Generation: " + cnt + "\n\n" + map.makeMap() + "\nNum Alive Cells: " + cnt2 + "\nNum Dead Cells: " + cnt3 + "\n\n Would you like to continue?", null, 0, 1, null, options, null);
			if(result == 0) {
				map.nextGeneration();
				cnt++;
			}
			else
				exited = true;
		}
		JOptionPane.showMessageDialog(null, map.makeMap() + "\n\nThank you for playing Liam's version of Conway's Game of Life.\nThis is your final board.");
	}
}
