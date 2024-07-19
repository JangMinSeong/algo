package w0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class node {
	int x;
	int y;
	int k;
	public node(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}
}

public class Main_BJ_1600_¸»ÀÌµÇ°íÇÂ¿ø¼þÀÌ {
	static int k;
	static int [][] map;
	static int [][][] travel;
	static int w,h;
	static int [][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	static int [][] h_d = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		String [] str = br.readLine().split(" ");
		w = Integer.parseInt(str[0]);
		h = Integer.parseInt(str[1]);
		
		map = new int [h+2][w+2];
		travel = new int [k+1][h+2][w+2];
		
		for(int i=1;i<=h;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=w;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					for(int l=0;l<=k;l++) 
						travel[l][i][j] = -1;
				}
			}
		}
		for(int i=0;i<h+2;i++) {
			for(int j=0;j<w+2;j++) {
				map[0][j] = -1;
				map[h+1][j] = -1;
				for(int l=0;l<=k;l++) {
					travel[l][0][j] = -1;
					travel[l][h+1][j] = -1;
				}
			}
			map[i][0] = -1;
			map[i][w+1] = -1;
			for(int l=0;l<=k;l++) {
				travel[l][i][0] = -1;
				travel[l][i][w+1] = -1;
				travel[l][h][w] = Integer.MAX_VALUE;
				travel[l][1][1] = 1;
			}
		}
		
		bfs(1,1);
		
		int min = travel[0][h][w];
		for(int i=0;i<=k;i++) {
			if(travel[i][h][w] < min) min = travel[i][h][w];
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min-1);
	}
	
	public static void bfs(int x, int y) {
		node temp = new node(x,y,0);
		Queue <node> que = new LinkedList<>();
		que.add(temp);
		
		while(!que.isEmpty()) {
			temp = que.poll();
		
			for(int i=0;i<4;i++) {
				int newX = temp.x + d[i][0];
				int newY = temp.y + d[i][1];
				int height = temp.k;
				if(travel[height][newX][newY] == -1) continue;
				if(travel[height][newX][newY] > 0 && travel[height][newX][newY] != Integer.MAX_VALUE) continue;			
				
				travel[height][newX][newY] = travel[height][temp.x][temp.y] + 1;
				
				if(newX == h && newY == w) return;
				
				que.add(new node(newX,newY,temp.k));
			}
			if(temp.k < k) {
				for(int i=0;i<8;i++) {
					int newX = temp.x + h_d[i][0];
					int newY = temp.y + h_d[i][1];
					int height = temp.k + 1;
					
					if(newX < 1 || newX > h || newY < 1 || newY > w) continue;
					if(travel[height][newX][newY] == -1) continue;
					if(travel[height][newX][newY] > 0 && travel[height][newX][newY] != Integer.MAX_VALUE) continue;
					
					travel[height][newX][newY] = travel[height-1][temp.x][temp.y] + 1;

					if(newX == h && newY == w) return;
					
					que.add(new node(newX,newY,height));
				}
			}
		}
	}	
}
