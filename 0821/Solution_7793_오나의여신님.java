package w0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//class pair{
//	int x;
//	int y;
//	public pair(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}

public class Solution_7793_오나의여신님 {
	static char [][] map;
	static int [][] visited;
	static int n,m;
	static pair start, goal;
	static ArrayList<pair> devil;
	
	static int count;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test_case;t++) {
			String [] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			
			map = new char [n+2][m+2];
			visited = new int [n+2][m+2];
			devil = new ArrayList<>();
			count = 0;
			
			for(int i=1;i<=n;i++) {
				String temp = br.readLine();
				for(int j=1;j<=m;j++) {
					map[i][j] = temp.charAt(j-1);
					if(map[i][j] == 'D') {
						visited[i][j] = 10000;
						goal = new pair(i,j);
					}
					else if(map[i][j] == 'S') {
						visited[i][j] = 1;
						start = new pair(i,j);
					}
					else if(map[i][j] == '*') {
						devil.add(new pair(i,j));
						visited[i][j] = -1;
					}
					else if(map[i][j] == 'X') {
						visited[i][j] = -2;
					}
				}
			}
			bfs(start);
			if(visited[goal.x][goal.y] == 10000) 
				System.out.println("#" + t + " " + "GAME OVER");
			else
				System.out.println("#" + t + " " + (visited[goal.x][goal.y]));
		}
	}
	public static void bfs(pair start) {
		Queue<pair> que = new LinkedList<>();
		
		for(int i=0;i<devil.size();i++)
			que.add(devil.get(i));
		que.add(start);
		while(!que.isEmpty()) {
			pair pos = que.poll();
			for(int i=0;i<4;i++) {
				int newX = pos.x + d[i][0];
				int newY = pos.y + d[i][1];
				
				if(map[newX][newY] == 0) continue;
				if(visited[pos.x][pos.y] > 0 && visited[newX][newY] == 10000) {
					visited[newX][newY] = visited[pos.x][pos.y]; 
					return;
				}
				if(visited[newX][newY] != 0) continue;
				
				if(visited[pos.x][pos.y] > 0) {
					visited[newX][newY] = visited[pos.x][pos.y] + 1; 
					que.add(new pair(newX,newY));
				}
				else if(visited[pos.x][pos.y] < 0) {
					visited[newX][newY] = visited[pos.x][pos.y];
					que.add(new pair(newX,newY));
				}
			}
		}	
	}
}
