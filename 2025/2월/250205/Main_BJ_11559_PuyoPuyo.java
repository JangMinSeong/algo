package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main_BJ_11559_PuyoPuyo {
	static char[][] map;
	static int [][] visit;
	static int [][] d = {{1,0}, {0,1},{-1,0},{0,-1}};
	static boolean [][] isDel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char [12][6];
		visit = new int [12][6];
		isDel = new boolean [12][6];
		
		for(int i=0;i<12;i++) {
			String line = br.readLine();
			for(int j=0;j<6;j++) {
				map[i][j] = line.charAt(j);
				visit[i][j] = -1;
				isDel[i][j] = false;
			}
		}
		int cnt = 0;
		while(true) {
			int ch = 0;
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(map[i][j] != '.' && visit[i][j] == -1) {
						int t = dfs(i,j,map[i][j]) + 1;
						//print();
						//System.out.println(t);
						if(t >= 4) {
							maskDel(i,j,map[i][j]);
							ch= 1;
						}
					}
				}
			}
			
			if(ch == 0) break;
			
			cnt++;
			del();
			dropDown();
			clear();
		}
		System.out.println(cnt);
	}
	public static void print() {
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int dfs(int x,int y, char color) {
		visit[x][y] = 0;
		for(int i=0;i<4;i++) {
			int newX = x + d[i][0];
			int newY = y + d[i][1];
			
			if(newX < 0 || newX >= 12 || newY < 0 || newY >= 6) continue;
			if(visit[newX][newY] != -1) continue;
			if(map[newX][newY] != color) continue;
			
			visit[x][y] += dfs(newX,newY,color) + 1;
		}
		return visit[x][y];
	}
	
	public static void maskDel(int x, int y, char color) {
		isDel[x][y] = true;
		for(int i=0;i<4;i++) {
			int newX = x + d[i][0];
			int newY = y + d[i][1];
			
			if(newX < 0 || newX >= 12 || newY < 0 || newY >= 6) continue;
			if(isDel[newX][newY] != false) continue;
			if(map[newX][newY] != color) continue;
			
			maskDel(newX,newY,color);
		}
	}
	
	public static void del() {
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(isDel[i][j] == true)
					map[i][j] = '.';
			}
		}
	}
	
	public static void clear() {
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				visit[i][j] = -1;
				isDel[i][j] = false;
			}
		}
	}
	
	public static void dropDown() {
		for(int i=11;i>=1;i--) {
			for(int j=0;j<6;j++) {
				if(map[i][j] == '.') {
					int cnt = 0;
					while(map[i][j] == '.' && cnt < 12) {
						for(int k=0;k<i;k++)
							map[i - k][j] = map[i - k - 1][j];
						map[0][j] = '.';
						cnt++;
					}
				}
			}
		}
	}
}
