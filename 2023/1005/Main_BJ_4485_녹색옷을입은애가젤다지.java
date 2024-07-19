package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class pair{
	int x;
	int y;
	public pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_BJ_4485_≥Ïªˆø ¿ª¿‘¿∫æ÷∞°¡©¥Ÿ¡ˆ {
	static int n;
	static int [][] map;
	static int [][] visited;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int round = 1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			map = new int [n][n];
			visited = new int [n][n];
			
			for(int i=0;i<n;i++) {
				String [] input = br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(input[j]);
					visited[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs();
			
			System.out.println("Problem " + round + ": " + visited[n-1][n-1]);
			round++;
		}
	}
	
	public static void bfs() {
		Queue<pair> que = new LinkedList<>();
		que.add(new pair(0,0));
		visited[0][0] = map[0][0];
		
		while(!que.isEmpty()) {
			pair temp = que.poll();
			
			for(int i=0;i<4;i++) {
				int newX = temp.x + d[i][0];
				int newY = temp.y + d[i][1];
				
				if(newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
				if(visited[newX][newY] <= visited[temp.x][temp.y] + map[newX][newY]) continue;
				visited[newX][newY] = visited[temp.x][temp.y] + map[newX][newY];
				que.add(new pair(newX,newY));
			}
		}
	}
}
