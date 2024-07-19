package w0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class pair {
	private int x;
	private int y;
	public pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

public class Solution_1953_Żֹ˰ {
	static int [][][] d = { 
							{{1,0},{0,1},{-1,0},{0,-1}},  //1
							{{1,0},{-1,0}},  //2
							{{0,1},{0,-1}},  //3
							{{-1,0},{0,1}},  //4
							{{0,1},{1,0}},   //5
							{{0,-1},{1,0}},  //6
							{{0,-1,},{-1,0}} //7
						};
	static int n,m,r,c,time;
	static int [][] map;
	static int [][] visited;
	static Queue<pair> que;
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<=test_case;t++) {
			String [] str = br.readLine().split(" ");
			 n = Integer.parseInt(str[0]);
			 m = Integer.parseInt(str[1]);
			 r = Integer.parseInt(str[2]);
			 c = Integer.parseInt(str[3]);
			 time = Integer.parseInt(str[4]);
			 
			 count = 0;
			 map = new int [n][m];
			 visited = new int [n][m];
			 
			 for(int i=0;i<n;i++) {
				 String[] temp = br.readLine().split(" ");
				 for(int j=0;j<m;j++) {
					 map[i][j] = Integer.parseInt(temp[j]);
				 }
			 }
			 bfs();
			 System.out.println("#" + t + " " + count);
		}
	}
	
	public static boolean isConnect(pair a, pair b) {
		int temp2 = map[b.getX()][b.getY()] - 1;
		
		for(int j=0; j <d[temp2].length;j++) {
			if(a.getX() == d[temp2][j][0] * (-1) && a.getY() == d[temp2][j][1] * (-1)) {
				return true;
			}
		}
		return false;
	}
	
	public static void bfs() {
		que = new LinkedList<>();
		visited[r][c] = 1;
		que.add(new pair(r,c));
		//System.out.println("¥~~~~");
		if(time == 1) {
			que.poll();
			count = 1;
			return;
		}
		while(!que.isEmpty()) {
			pair pos = que.poll();
			int direction = map[pos.getX()][pos.getY()] - 1;
			for(int i=0;i<d[direction].length; i++) {
				int newX = pos.getX() + d[direction][i][0];
				int newY = pos.getY() + d[direction][i][1];
				int ch = 0;
				
				if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
				if(map[newX][newY] == 0) continue;
				if(visited[newX][newY] != 0) continue;
				if(!isConnect(new pair(d[direction][i][0], d[direction][i][1]), new pair(newX, newY))) continue;

				visited[newX][newY] = visited[pos.getX()][pos.getY()] + 1;
				if(visited[newX][newY] < time) {
					que.add(new pair(newX,newY));
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//System.out.print(visited[i][j] + " ");
				if(visited[i][j] != 0) count++;
			}
			//System.out.println();
		}
	}
}
