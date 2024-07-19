package w0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class pair{
	int x;
	int y;
	public pair(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_BJ_10026_적록색약 {
	static int [][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static char [][] map;
	static int [][][] isVisited;
	static int cnt1, cnt2;
	static int n;
	static Queue<pair> que;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new char [n+2][n+2];
		isVisited = new int [2][n+2][n+2];
		
		for(int i=1; i<=n;i++) {
			String temp = br.readLine();
			for(int j=1;j<=n;j++) {
				map[i][j] = temp.charAt(j-1);
			}
		}
			
		for(int i = 1;i <= n;i++) {
			for(int j = 1;j <= n;j++) {
				if(isVisited[0][i][j] == 0) {
					que = new LinkedList<>();
					bfs(i,j,++cnt1, 0);
				}
				if(isVisited[1][i][j] == 0) {
					que = new LinkedList<>();
					bfs(i,j,++cnt2, 1);
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}
	public static void bfs(int x, int y, int cnt, int option) {
		char t = map[x][y];
		int gap = 0;
		if(option == 1) {
			gap = Math.abs('R' - 'G');
		}
		que.add(new pair(x,y));
		isVisited[option][x][y] = cnt;
		while(!que.isEmpty()) {
			pair temp = que.poll();
			for(int i=0;i<4;i++) {
				int newX = temp.x + d[i][0];
				int newY = temp.y + d[i][1];
				char ch = map[newX][newY];
				
				if(map[newX][newY] == 0) continue;
				if(isVisited[option][newX][newY] != 0) continue;
				if(Math.abs(map[newX][newY] - t) == gap && option == 1) { ch = t; }
				if(ch != t) continue;
				
				isVisited[option][newX][newY] = cnt;
				que.add(new pair(newX,newY));
			}
		}
	}
}
