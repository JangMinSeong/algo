package w0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_3109_»§Áý {
	static int r, c;
	static int map[][];
	static int ans;
	static int [][] d = {{-1,1},{0,1},{1,1}};
	static int ch;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		map = new int [r+2][c+2];
		for(int i=1;i<=r;i++) {
			String temp = br.readLine();
			for(int j=1;j<=c;j++) {
				if(temp.charAt(j-1) == '.') 
					map[i][j] = -1;
				else
					map[i][j] = 1;
			}
		}
		
		for(int i=1;i<=r;i++) {		
			if(map[i][1] == -1) {
				map[i][1] = 2;
				dfs(i,1);
				//print();
			}
		}
		System.out.println(ans);
	}
	
	public static void print() {
		for(int i=1; i<=r;i++) {
			for(int j=1;j<=c;j++) {
				System.out.printf("%3d ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void dfs(int x, int y) {
		ch = 0;
		for(int i=0;i<3;i++) {
			int newX = d[i][0] + x;
			int newY = d[i][1] + y;
			
			if(map[newX][newY] >= 0) continue;
			map[newX][newY] = 2;
			
			if(newY >= c) {ch = 1; ans++; return; }
			dfs(newX,newY);	
			if(ch == 1) { return; }
		}
	}
}
