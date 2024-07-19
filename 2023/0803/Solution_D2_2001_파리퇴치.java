package w0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_2001_ÆÄ¸®ÅðÄ¡ {
	static int n,m;
	static int [][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(bf.readLine());
		
		for(int t=1;t<=test_case;t++) {
			String[] temp = bf.readLine().split(" ");
			n = Integer.parseInt(temp[0]);
			m = Integer.parseInt(temp[1]);
			map = new int [n][n];
			for(int i=0;i<n;i++) {
				String[] str = bf.readLine().split(" ");
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			int max = 0;
			for(int i=0;i<=n-m;i++) {
				for(int j=0;j<=n-m;j++) {
					int fly = getFly(i,j);
					if(fly > max) max = fly;
				}
			}
			System.out.println("#" + t + " " + max);		
		}		
	}
	public static int getFly(int x, int y) {
		int sum = 0;
		for(int i = x; i <x+m; i++) {
			for(int j = y;j<y+m;j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}
}
