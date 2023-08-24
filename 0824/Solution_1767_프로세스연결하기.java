package w0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Core implements Comparable<Core>{
	int x;
	int y;
	int direction;
	int length;
	
	public Core(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	public void rotate() {
		direction = (direction+1) % 4;
	}
	@Override
	public int compareTo(Core o) {
		
		return Integer.compare(length, o.length);
	}
}

class Ans {
	int min;
	int max;
	public Ans(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

public class Solution_1767_프로세스연결하기 {
	static int n;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static int [][] map;

	static ArrayList<Core> core;
	static int min;
	static int max;
	static int count;
	static int ch;
	
	static Ans ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<=test_case;t++) {
			n = Integer.parseInt(br.readLine());
			map = new int [n+2][n+2];

			core = new ArrayList<>();
			ans = new Ans(Integer.MAX_VALUE,0);
			
			for(int i=0;i<n+2;i++) {
				map[i][0] = -1;
				map[0][i] = -1;
				map[n+1][i] = -1;
				map[i][n+1] = -1;
			}
			
			for(int i=1;i<=n;i++) {
				String [] str = br.readLine().split(" ");
				for(int j=1;j<=n;j++) {
					map[i][j] = Integer.parseInt(str[j-1]);

				}
			}	
			for(int i=2;i<n;i++) {
				for(int j=2;j<n;j++) {
					if(map[i][j] == 1) {		
						core.add(new Core(i,j,0));
					}
				}
			}	
			count = 0;
			f(0, 0);
			
			System.out.println("#" + t + " " + ans.min);
		}
	}
	
	public static void f(int idx, int cnt) {	
		if(idx < core.size()) {
			for(int i=0;i<4;i++) {
				if(fill(idx)) {
					f(idx+1, cnt+1);
					ch = 1;
				}
				back(idx);
				core.get(idx).rotate();
			}
			f(idx+1, cnt);
		}
		
		if(ans.max < cnt) {
			ans.min = count;
			ans.max = cnt;
		}
		else if(ans.max == cnt && ans.min > count) {
			ans.min = count;
		}
	}
	
	public static void back(int idx) {
		Core a = core.get(idx);
		int newX = a.x + d[a.direction][0];
		int newY = a.y + d[a.direction][1];
		
		while(map[newX][newY] == -10 + ((-1) * idx)) {
			map[newX][newY] = 0;
			count--;
			
			newX += d[a.direction][0];
			newY += d[a.direction][1];		
		}
	}
	
	public static boolean fill(int idx) {
		Core a = core.get(idx);
		int newX = a.x + d[a.direction][0];
		int newY = a.y + d[a.direction][1];
		
		while(map[newX][newY] == 0) {
			map[newX][newY] = -10 + ((-1) * idx);
			count++;
			
			newX += d[a.direction][0];
			newY += d[a.direction][1];		
		}
		
		if(map[newX][newY] == -1) return true;
		return false;
	}
}
