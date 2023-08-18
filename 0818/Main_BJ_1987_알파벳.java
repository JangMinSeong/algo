package w0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1987_¾ËÆÄºª {
	static int r,c;
	static boolean [] isVisited = new boolean [26];
	static char [][] map;
	static int [][] travel;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		map = new char [r][c];
		travel = new int [r][c];
		
		for(int i=0;i<r;i++) {
			String temp = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		travel[0][0] = 1;
		isVisited[map[0][0] - 'A'] = true;
		dfs(0,0,1);
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int depth) {	
		int newX = x;
		int newY = y;
		
		if(max < depth) { 
			max = depth; 

		}
		
		for(int i=0;i<4;i++) {
			newX = x + d[i][0];
			newY = y + d[i][1];
			
			if(newX < 0 || newX >= r || newY < 0 || newY >=c) continue;
			if(isVisited[map[newX][newY] - 'A'] == true) continue;
			if(travel[newX][newY] == 1) continue;
			
			travel[newX][newY] = 1;
			isVisited[map[newX][newY] - 'A'] = true;
			dfs(newX,newY,depth + 1);
			travel[newX][newY] = 0;
			isVisited[map[newX][newY] - 'A'] = false;
		}
	}
}
