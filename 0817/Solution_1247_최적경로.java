package w0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1247_최적경로 {
	
	static int [] home;
	static int n;
	static int [] comp;
	static int [][] cos;
	static boolean [] isVisited;
	static int [] num;
	static int minDis;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<=test_case;t++) {
			n = Integer.parseInt(br.readLine());
			
			home = new int [2];
			comp = new int [2];
			cos = new int [n][2];
			String [] str = br.readLine().split(" ");
			
			home[0] = Integer.parseInt(str[0]);
			home[1] = Integer.parseInt(str[1]);
			comp[0] = Integer.parseInt(str[2]);
			comp[1] = Integer.parseInt(str[3]);
			for(int i=2;i<n + 2;i++) {
				cos[i-2][0] = Integer.parseInt(str[i*2]);
				cos[i-2][1] = Integer.parseInt(str[i*2+1]);
			}
			
			isVisited = new boolean[n];
			num = new int[n];
			minDis = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				isVisited[i] = true;
				f(1, Math.abs(home[0] - cos[i][0]) + Math.abs(home[1] - cos[i][1]),i);
				isVisited[i] = false;
			}
			System.out.println("#" + t + " " + minDis);
		}
	}
	
	public static void f(int cnt, int dis, int idx) {
		if(dis > minDis) return;
		if(cnt == n) {
			dis += Math.abs(comp[0] - cos[idx][0]) + Math.abs(comp[1] - cos[idx][1]);
			if(minDis > dis) minDis = dis;
		}
		else {
			for(int i=0;i<n;i++) {
				if(isVisited[i] == true) continue;
				isVisited[i] = true;
				f(cnt+1, dis + calDis(idx,i), i);
				isVisited[i] = false;
			}
		}
	}
	
	public static int calDis(int i, int j) {
		return Math.abs(cos[i][0] - cos[j][0]) + Math.abs(cos[i][1] - cos[j][1]);
	}
}	
