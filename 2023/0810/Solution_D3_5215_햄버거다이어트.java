package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_5215_햄버거다이어트 {
	static int [][] food;
	static int n, l;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test_case;t++) {
			String [] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			l = Integer.parseInt(str[1]);
			max = 0;
			food = new int [n][2];
			
			for(int i=0;i<n;i++) {
				String [] temp = br.readLine().split(" ");
				food[i][0] = Integer.parseInt(temp[0]);
				food[i][1] = Integer.parseInt(temp[1]);
			}
			
			f(0,0, 0);
			System.out.println("#" + t + " " + max);
		}
	}
	public static void f(int cnt, int sum, int cal) {
		if(cal > l) return;
		if(cnt == n) {
			if(max < sum) max = sum;
			return;
		}
		else {
			f(cnt+1 , sum + food[cnt][0], cal + food[cnt][1]);
			f(cnt+1 , sum, cal);
		}
	}
}
