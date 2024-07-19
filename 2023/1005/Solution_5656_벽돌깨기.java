package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int x;
	int y;
	int num;
	
	public Node(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class Solution_5656_º®µ¹±ú±â {
	static int n,w,h;
	static int [][] map;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static int max;
	static int blockCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			String [] input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			w = Integer.parseInt(input[1]);
			h = Integer.parseInt(input[2]);
			
			map = new int [h][w];
			
			max = 0;
			blockCnt = 0;
			
			for(int i=0;i<h;i++) {
				input = br.readLine().split(" ");
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(input[j]);
					if(map[i][j] != 0) blockCnt++;
				}
			}
			
			dfs(0,0);
			
			System.out.println("#" + t + " " + (blockCnt - max));
		}
	}
	public static void dfs(int depth, int cnt) {
		if(depth == n) {
			if(cnt > max) 
				max = cnt;
			return;
		}
		else if(blockCnt == cnt) { max = blockCnt; return; }
		else {
			for(int i=0;i<w;i++) {
				for(int j=0;j<h;j++) {
					if(map[j][i] != 0) {
						ArrayList<Node> temp = boom(j,i);
						int [][] copyMap = new int [h][w];
						if(temp.size() > 1) {
							copy(copyMap,map);
							down();
						}
						dfs(depth + 1, cnt + temp.size());
						if(temp.size() > 1) {
							copy(map,copyMap);
						}
						rollBack(temp);
						break;
					}
				}
			}
		}
	}
	
	public static void copy(int [][] a, int [][] b) {
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				a[i][j] = b[i][j];
			}
		}
	}
	
	public static void down() {
		for(int i=0;i<w;i++) {
			for(int j=h-1; j>=0;j--) {
				if(map[j][i] == 0) {
					for(int k=0;k<=j;k++) {
						if(map[j-k][i] != 0) {
							map[j][i] = map[j-k][i];
							map[j-k][i] = 0;
							break;
						}
					}
				}
			}
		}
	}
	
	public static ArrayList<Node> boom(int x, int y) {
		ArrayList<Node> temp = new ArrayList<>();
		Queue<Node> que = new LinkedList<>();
		
		que.add(new Node(x,y,map[x][y]));
		while(!que.isEmpty()) {
			Node t = que.poll();
			
			temp.add(t);
			map[t.x][t.y] = 0;
			for(int i=0;i<4;i++) {
				int newX = t.x;
				int newY = t.y;
				
				for(int j=0;j<t.num-1;j++) {
					newX += d[i][0];
					newY += d[i][1];
					
					if(newX < 0 || newX >= h || newY < 0 || newY >= w) continue;				
					if(map[newX][newY] == 0) continue;
					if(map[newX][newY] == 1) {
						map[newX][newY] = 0;
						temp.add(new Node(newX,newY,1));
						continue;
					}
					que.add(new Node(newX,newY,map[newX][newY]));
					map[newX][newY] = 0;
				}
			}
		}
		
		return temp;
	}
	
	public static void rollBack (ArrayList<Node> temp) {
		for(int i=0;i<temp.size();i++) {
			map[temp.get(i).x][temp.get(i).y] = temp.get(i).num; 
		}
	}
}
