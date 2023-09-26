package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class pair{
	int x;
	int y;
	
	public pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_BJ_2239_½ºµµÄí {
	public static String [] input;
	public static ArrayList<Integer> [][] list;	
	public static int [][] map;
	public static int cnt;
	public static ArrayList<pair> pos;
	
	public static int [] vert;
	public static int [] hori;
	public static int [] squ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new String [9];
		map = new int [9][9];
		pos = new ArrayList<>();

		vert = new int [9];
		hori = new int [9];
		squ = new int [9];
		
		char [] temp;		
		for(int i=0;i<9;i++) {
			input[i] = br.readLine();
			temp = input[i].toCharArray();
			for(int j=0;j<9;j++) {
				map[i][j] = temp[j] - '0';
				if(map[i][j] == 0) 
					pos.add(new pair(i,j));
			}
		}
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j] != 0) {
					hori[i] += 1 << (map[i][j]-1);
				}
				if(map[j][i] != 0) {
					vert[i] += 1 << (map[j][i]-1);
				}
			}
		}
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j] != 0)
					squ[((i/3)*3)+(j/3)] += (1 << (map[i][j]-1));
			}
		}
		
		list = new ArrayList[9][9];		
		
		while(true) {
			int ch = 0;
			cnt = 0;
			
			int size = pos.size();
			for(int t = 0; t<size;t++) {
				int i = pos.get(t).x;
				int j = pos.get(t).y;
				
				list[i][j] = new ArrayList<>();
				if(map[i][j] == 0) {
					for(int k=1;k<=9;k++) {
						if(!checkLine(i,j,k)) continue;
						if(!checkSqu(i,j,k)) continue;
						
						list[i][j].add(k);
					}
					if(list[i][j].size() == 1) {
						map[i][j] = list[i][j].get(0);
						
						hori[i] += (1 << (map[i][j] - 1));
						vert[j] += (1 << (map[i][j] - 1));
						squ[((i / 3) * 3) + (j/3)] += (1 << map[i][j] -1);
						
						pos.remove(t);
						
						size--;
						t--;
						ch = 1; 
					}
					else cnt++;
				}
			}
			if(ch == 0) break;
		}
		
		dfs(0,0);
		
	}
	
	public static void dfs(int depth, int idx) {
		if(depth == cnt) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		for(int t = idx; t < pos.size();t++) {
			int i = pos.get(t).x;
			int j = pos.get(t).y;
			
			if(map[i][j] == 0) {
				for(int k=0;k<list[i][j].size();k++) {				
					if(!checkLine(i,j,list[i][j].get(k))) continue;
					if(!checkSqu(i,j,list[i][j].get(k))) continue;
					
					map[i][j] = list[i][j].get(k);
					
					hori[i] += (1 << (map[i][j] - 1));
					vert[j] += (1 << (map[i][j] - 1));
					squ[((i / 3) * 3) + (j/3)] += (1 << map[i][j] - 1);
					
					
					dfs(depth + 1,t);
							
					hori[i] -= (1 << (map[i][j] - 1));
					vert[j] -= (1 << (map[i][j] - 1));
					squ[((i / 3) * 3) + (j/3)] -= (1 << map[i][j] - 1);
					map[i][j] = 0;
				}
				return;
			}
		}
	}
	
	public static boolean checkLine(int x, int y, int num) {
		if((hori[x] & (1 << (num-1))) == 0 && (vert[y] & (1 << (num-1))) == 0) return true;
		return false;
	}
	
	public static boolean checkSqu(int x, int y, int num) {
		int idx = ((x / 3) * 3) + (y/3);
		if((squ[idx] & (1 << (num-1))) == 0) return true;
		return false;
	}
}
