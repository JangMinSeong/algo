package w0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2563_»öÁ¾ÀÌ {
	
	static int [][] map = new int [100][100];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String [] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			for(int j=0;j<10;j++) {
				for(int k=0;k<10;k++) {
					map[x + j - 1][y + k -1] = 1;
				}
			}
		}
		int sum = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}
}
