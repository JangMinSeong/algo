package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4012_요리사 {
	static int [][] food;
	static boolean [] isUsed;
	static int n;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<=test_case;t++) {
			n = Integer.parseInt(br.readLine());
			food = new int [n][n];
			isUsed = new boolean[n];
			min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				String [] str = br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					food[i][j] = Integer.parseInt(str[j]);
				}
			}		
			f(0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	public static void f(int cnt) {
		if(cnt == n) {
			int c = 0;
			for(int i=0;i<n;i++) {
				if(isUsed[i] == true) c++;
			}
			if(c < 2 || c > n - 2) return;
			
			int foodA = 0;
			int foodB = 0;
			
			for(int i=0;i<n;i++) {
				if(isUsed[i] == true) {
					for(int j=0;j<n;j++) {
						if(i == j) continue;
						if(isUsed[j] == true)
							foodA += food[i][j];
					}
				}
				if(isUsed[i] == false) {
					for(int j=0;j<n;j++) {
						if(i == j) continue;
						if(isUsed[j] == false)
							foodB += food[i][j];
					}
				}
			}
			if(min > Math.abs(foodA - foodB))
				min = Math.abs(foodA - foodB);
			return;
		}
		else {
			isUsed[cnt] = true;
			f(cnt+1);
			isUsed[cnt] = false;
			f(cnt+1);
		}
	}
}
