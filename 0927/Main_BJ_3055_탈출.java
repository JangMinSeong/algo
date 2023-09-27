package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class pair {
	int x;
	int y;
	public pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_BJ_3055_탈출 {
	static char [][] map;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static int [][] visited;

	static int n,m;
	static pair start;
	static ArrayList<pair> list;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		list = new ArrayList<>();
		result = 0;
		
		map = new char [n][m];
		visited = new int [n][m];

		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					start = new pair(i,j);
					visited[i][j] = 1;
				}
				else if(map[i][j] == '*') {
					list.add(new pair(i,j));
					visited[i][j] = -1;
				}
			}
		}
		
		bfs();
		
		if(result == 0) System.out.println("KAKTUS");
		else System.out.println(result);
	}
	
	public static void bfs() {
		Queue<pair> que = new LinkedList<>();
		
		que.add(start);
		for(int i=0;i<list.size();i++)
			que.add(list.get(i));	
		
		while(!que.isEmpty()) {
			pair temp = que.poll();
			if(visited[temp.x][temp.y] < -100000 ) {
				visited[temp.x][temp.y] += 100000;
				continue;
			}
			for(int i=0;i<4;i++) {
				int newX = temp.x + d[i][0];
				int newY = temp.y + d[i][1];
				
				if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue; //범위 밖
				if(map[newX][newY] == 'X') continue; //벽
				if(map[newX][newY] == 'D') {
					if(visited[temp.x][temp.y] < 0) continue;
					result = visited[temp.x][temp.y];
					return;
				}
				
				if(visited[newX][newY] < 0) continue;
				if(visited[temp.x][temp.y] < 0) {
					if(visited[temp.x][temp.y] - 1 == -visited[newX][newY]) visited[newX][newY] = -100000 - visited[newX][newY];
					else visited[newX][newY] = visited[temp.x][temp.y] - 1;
					que.add(new pair(newX,newY));
				} else {
					if(visited[newX][newY] > 0) continue;
					visited[newX][newY] = visited[temp.x][temp.y] + 1;
					que.add(new pair(newX,newY));
				}
			}
		}
	}
}
