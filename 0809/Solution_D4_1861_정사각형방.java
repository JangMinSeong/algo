package w0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_1861_정사각형방 {
	static int [][] map;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	
	static int max;
	static int min_num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test_case;t++) {
			int n = Integer.parseInt(br.readLine());
			map = new int [n+2][n+2];
			max = 0;
			min_num = 0;
			
			for(int i=1;i<=n;i++) {
				String [] str = br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					map[i][j+1] = Integer.parseInt(str[j]);
				}
			}
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					dfs(i,j,1,map[i][j]);
				}
			}
			System.out.println("#" + t + " " + min_num + " " + max);
		}
	}
	
	public static void dfs(int x, int y, int depth, int num) {
		if(max < depth) {
			max = depth;
			min_num = num;
		}
		else if(max == depth && min_num > num) {
			min_num = num;
		}
		for(int i=0;i<4;i++) {
			int newX = x + d[i][0];
			int newY = y + d[i][1];
			
			if(map[newX][newY] - 1 == map[x][y])
				dfs(newX,newY,depth+1, num);
		}
	}
}
