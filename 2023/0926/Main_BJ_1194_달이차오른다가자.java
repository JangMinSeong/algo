package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class node{
	int x;
	int y;
	int key;
	
	public node(int x, int y, int key) {
		this.x = x;
		this.y = y;
		this.key = key;
	}
}

public class Main_BJ_1194_달이차오른다가자 {
	static int n;
	static int m;
	static int d[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	
	static char [][] map;
	static int [][][] visited;
	static node start;
	
	static int maxKey = (1 << 6);
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		map = new char [n][m];
		visited = new int [maxKey][n][m];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			char [] t = str.toCharArray();
			for(int j=0;j<m;j++) {
				map[i][j] = t[j];
				if(map[i][j] == '0') {
					start = new node(i,j,0);
				}	
			}
		}
		
		bfs(start);
		
		if(result == 0) System.out.println(-1);
		else System.out.println(result - 1);
	}
	
	public static void bfs(node start) {
		Queue<node> que = new LinkedList<>();
		
		visited[0][start.x][start.y] = 1; 
		que.add(start);
		
		while(!que.isEmpty()) {
			node temp = que.poll();
			for(int i=0;i<4;i++) {
				int newX = temp.x + d[i][0];
				int newY = temp.y + d[i][1];
				int key = temp.key;
				
				if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue; //범위 밖
				
				if(map[newX][newY] == '1') { result = visited[temp.key][temp.x][temp.y] + 1; return; }  //끝
				if(map[newX][newY] == '#') continue; //벽
				
				if(visited[key][newX][newY] != 0) continue; //재방문
				
				if(map[newX][newY] >= 'A' && map[newX][newY] <= 'F') { //벽
					if((key & (1 << (map[newX][newY] - 'A'))) == 0) continue; //열쇠가 없을 때,
				}
				if(map[newX][newY] >= 'a' && map[newX][newY] <= 'f') { //키
					key |= 1 << (map[newX][newY] - 'a');
				}
				
				visited[key][newX][newY] = visited[temp.key][temp.x][temp.y] + 1;
				
				que.add(new node(newX,newY,key));
			}
		}
	}
}
