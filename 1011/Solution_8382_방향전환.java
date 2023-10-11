package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_8382_방향전환 {
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			String [] str = br.readLine().split(" ");
			
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			
			ans = 0;
			int wid = Math.abs(x1-x2);
			int hei = Math.abs(y1-y2);
			
			ans += Math.min(wid,hei) * 2;
			int rest = Math.abs(wid - hei);
			ans += (rest/2) * 4 + (rest%2);
			System.out.println("#" + t + " " + ans);	
		}			
	}
}
