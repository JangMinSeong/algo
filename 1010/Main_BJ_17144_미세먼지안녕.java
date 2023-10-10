package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_17144_미세먼지안녕 {
	
	static int r,c,t;
	static int [][][] map;
	static int [][] d = {{1,0},{-1,0},{0,-1},{0,1}};
	static int upper,lower;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		t = Integer.parseInt(str[2]);
		
		map = new int [2][r][c];
		upper = -1;
		for(int i=0;i<r;i++) {
			str = br.readLine().split(" ");
			for(int j=0;j<c;j++) {
				map[0][i][j] = Integer.parseInt(str[j]);
				if(map[0][i][j] == -1) {
					if(upper == -1) upper = i;
					else lower = i;
				}
			}
		}
		
		for(int i=0;i<t;i++) {
			spread();
			rotate();
		}
		
		System.out.println(calResult());
	}
	
	public static int calResult() {
		int sum = 0;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[0][i][j] > 0)
					sum += map[0][i][j];
			}
		}
		
		return sum;
	}
	
	public static void spread() {
		int from = 0;
		int to = 1;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[from][i][j] >= 5) {
					int cnt = 0;
					int q = map[from][i][j] / 5;
					for(int k=0;k<4;k++) {
						int newX = i + d[k][0];
						int newY = j + d[k][1];
						
						if(newX < 0 || newX >= r || newY < 0 || newY >= c) continue;
						if(map[from][newX][newY] == -1) continue;
						cnt++;
						map[to][newX][newY] += q; 
					}
					map[to][i][j] += map[from][i][j] - (q * cnt);
					map[from][i][j] = 0;
				}else if(map[from][i][j] > 0) {
					map[to][i][j] += map[from][i][j];
					map[from][i][j] = 0;
				}
			}
		}
	}
	
	public static void rotate() {
		int from = 1;
		int to = 0;
		
		for(int i=upper-1;i>0;i--) {
			map[to][i][0] = map[from][i-1][0];
			map[from][i-1][0] = 0;
		}
		for(int i=0;i<c-1;i++) {
			map[to][0][i] = map[from][0][i+1];
			map[from][0][i+1] = 0;
		}
		for(int i=0;i<upper;i++) {
			map[to][i][c-1] = map[from][i+1][c-1];
			map[from][i+1][c-1] = 0;
		}
		for(int i=c-1;i>=2;i--) {
			map[to][upper][i] = map[from][upper][i-1];
			map[from][upper][i-1] = 0;
		}
		map[to][upper][1] = 0;
		map[from][upper-1][0] = 0;
		for(int i=1;i<upper;i++) {
			for(int j=1;j<c-1;j++) {
				map[to][i][j] = map[from][i][j];
				map[from][i][j] = 0;
			}
		}
		
		
		for(int i=lower+1;i<r-1;i++) {
			map[to][i][0] = map[from][i+1][0];
			map[from][i+1][0] = 0;
		}
		for(int i=0;i<c-1;i++) {
			map[to][r-1][i] = map[from][r-1][i+1];
			map[from][r-1][i+1] = 0;
		}
		for(int i=r-1;i>=lower+1;i--) {
			map[to][i][c-1] = map[from][i-1][c-1];
			map[from][i-1][c-1] = 0;
		}
		for(int i=c-1;i>=2;i--) {
			map[to][lower][i] = map[from][lower][i-1];
			map[from][lower][i-1] = 0;
		}
		map[to][lower][1] = 0;
		map[from][lower+1][0] = 0;
		for(int i=lower+1;i<r-1;i++) {
			for(int j=1;j<c-1;j++) {
				map[to][i][j] = map[from][i][j];
				map[from][i][j] = 0;
			}
		}
	}
}
