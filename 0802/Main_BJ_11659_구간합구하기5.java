package w0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_11659_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n, m;
		String[] temp = bf.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		long [][] map = new long [n+1][n+1];
		for(int i=1;i<=n;i++) {
			String [] str = bf.readLine().split(" ");			
			for(int j=1;j<=n;j++) {
				map[i][j] = map[i-1][j] + map[i][j-1] + Integer.parseInt(str[j-1]) - map[i-1][j-1];
			}
		}
		
		for(int i = 0; i < m; i++) {
			int x1, y1, x2, y2;
			temp = bf.readLine().split(" ");
			x1 = Integer.parseInt(temp[0]);
			y1 = Integer.parseInt(temp[1]);
			x2 = Integer.parseInt(temp[2]);
			y2 = Integer.parseInt(temp[3]);
			
			long sum = map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1];
			System.out.println(sum);
		}
	}
}
