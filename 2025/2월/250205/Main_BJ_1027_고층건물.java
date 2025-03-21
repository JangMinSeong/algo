package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_BJ_1027_고층건물 {
	static int [] b;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		b = new int [n];
		String [] str = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			b[i] = Integer.parseInt(str[i]);
		}
		
		int ans = 0;
		for(int i=0;i<n;i++) {
			int cnt = 0;
			
			double min = Double.POSITIVE_INFINITY;
			for(int j=i-1;j>=0;j--) {
				double lean = calLean(i,b[i], j,b[j]);
				if(lean < min) {
					cnt++;
					min = lean;
				}
			}
			double max = Double.NEGATIVE_INFINITY;
			for(int j=i+1; j<n;j++) {
				double lean = calLean(i,b[i], j,b[j]);
				if(lean > max) {
					cnt++;
					max = lean;
				}
			}
			if(ans < cnt) {
				ans = cnt;
			}
		}
		
		System.out.println(ans);
	}
	
	public static double calLean(int x1, int y1, int x2, int y2) {
		return (double)(y1 - y2) / (x1 - x2);
	}
}
