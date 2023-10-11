package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_8458_원점으로집합 {
	static int [] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			String [] str;
			int max = 0;
			boolean flag = true;
			
			System.out.print("#" + t + " ");
			
			for(int i=0;i<n;i++) {
				str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				int dis = Math.abs(x) + Math.abs(y);
				if(max < dis) max = dis;
				if(dis % 2 != max % 2) flag = false; 
			}
			
			
			if(flag == false) { System.out.println(-1); continue; }
			if(max == 0) {System.out.println(0); continue;}
			int sum = 0;
			int cnt = 0;
			while(true) {
				sum += ++cnt;
				if(sum >= max) break;
			}
			while((sum - max)%2 != 0) {
				sum += ++cnt;
			}
			System.out.println(cnt);
		}
	}
}
