package mod;

import javax.swing.JOptionPane;

public class Map {
	boolean[][] map;
	Sizer s;
	double intput;
	
	public Sizer getSizer() {return s;}
	
	public Map() {
		s = new Sizer();
		map = s.getArray();
		String input = JOptionPane.showInputDialog(null, "What percent of cells do you want to be alive at the start?\nMin: 1\nMax: 80");
		intput = Integer.parseInt(input);
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				double rnd = Math.random();
				map[i][j] = rnd < (intput/100);
			}
		}
	}
	
	public String makeMap() {
		String ret = "";
		String t = "\u25A1";
		String f = "\u25A0";
		String space = "  ";
		
		for(boolean[] x : map) {
			for(boolean y : x) {
				if(y) {
					ret += t + space;
				}
				else {
					ret += f + space;
				}
			}
			ret += "\n";
		}
		return ret;
	}
	
	public boolean[][] nextGeneration(){
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				int cnt = 0;
				if(i != 0 && j != 0 && i != map.length - 1 && j != map[i].length - 1) {
					if(map[i-1][j-1] == true)
						cnt++;
					if(map[i-1][j] == true)
						cnt++;
					if(map[i-1][j+1] == true)
						cnt++;
					if(map[i+1][j-1] == true)
						cnt++;
					if(map[i+1][j] == true)
						cnt++;
					if(map[i+1][j+1] == true)
						cnt++;
					if(map[i][j-1] == true)
						cnt++;
					if(map[i][j+1] == true)
						cnt++;
				}
				if(i == 0 && j == 0) {
					if(map[i+1][j] == true)
						cnt++;
					if(map[i+1][j+1] == true)
						cnt++;
					if(map[i][j+1] == true)
						cnt++;
				}
				if(i == 0 && j == map[i].length - 1) {
					if(map[i+1][j] == true)
						cnt++;
					if(map[i+1][j-1] == true)
						cnt++;
					if(map[i][j-1] == true)
						cnt++;
				}
				if(i == map.length - 1 && j == 0) {
					if(map[i-1][j] == true)
						cnt++;
					if(map[i-1][j+1] == true)
						cnt++;
					if(map[i][j+1] == true)
						cnt++;
				}
				if(i == map.length - 1 && j == map[i].length - 1) {
					if(map[i-1][j] == true)
						cnt++;
					if(map[i-1][j-1] == true)
						cnt++;
					if(map[i][j-1] == true)
						cnt++;
				}
				if(i == 0 && j != 0 && j != map[i].length - 1) {
					if(map[i+1][j] == true)
						cnt++;
					if(map[i+1][j-1] == true)
						cnt++;
					if(map[i+1][j+1] == true)
						cnt++;
					if(map[i][j+1] == true)
						cnt++;
					if(map[i][j-1] == true)
						cnt++;
				}
				if(i == map.length - 1 && j != map[i].length - 1 && j != 0) {
					if(map[i-1][j] == true)
						cnt++;
					if(map[i-1][j-1] == true)
						cnt++;
					if(map[i-1][j+1] == true)
						cnt++;
					if(map[i][j+1] == true)
						cnt++;
					if(map[i][j-1] == true)
						cnt++;
				}
				if(j == 0 && i != map.length - 1 && i != 0) {
					if(map[i+1][j] == true)
						cnt++;
					if(map[i+1][j+1] == true)
						cnt++;
					if(map[i][j+1] == true)
						cnt++;
					if(map[i-1][j+1] == true)
						cnt++;
					if(map[i-1][j] == true)
						cnt++;
				}
				if(j == map[i].length - 1 && i != map.length - 1 && i != 0) {
					if(map[i+1][j] == true)
						cnt++;
					if(map[i+1][j-1] == true)
						cnt++;
					if(map[i][j-1] == true)
						cnt++;
					if(map[i-1][j-1] == true)
						cnt++;
					if(map[i-1][j] == true)
						cnt++;
				}
				if((cnt < 2 || cnt > 3) && map[i][j] == true)
					map[i][j] = false;
				if(cnt == 3 && map[i][j] == false)
					map[i][j] = true;
			}
		}
		return map;
	}
}
