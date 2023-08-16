package w0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_6987_¿ùµåÄÅ {
	static String ans;
	static int [] teamA = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int [] teamB = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int [] result = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	static int [] win;
	static int [] draw;
	static int [] lose;
	
	static int ch = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0;t<4;t++) {
			String [] str = br.readLine().split(" ");
			ch = 0;
			
			win = new int [6];
			draw = new int [6];
			lose = new int [6];
			
			for(int i=0;i<6;i++) {
				win[i] = Integer.parseInt(str[(i*3) + 0]);
				draw[i] = Integer.parseInt(str[(i*3) + 1]);
				lose[i] = Integer.parseInt(str[(i*3) + 2]);
			}
			
			isPossible(0);
			
			System.out.println(ch);
		}
	}
	public static void isPossible(int cnt) {
		if(ch == 1) return;
		if(cnt == 15) {
			for(int i=0;i<6;i++) {
				if(win[i] != 0 || draw[i] != 0 || lose[i] != 0) {
					ch = 0;
					return;
				}
			}
			ch = 1;
			return;
		}
		else {
			for(int i=1;i<=3;i++) {  //1 ½Â 2 ¹« 3 ÆÐ
				if(i == 1) {
					if(win[teamA[cnt]] >= 0 && lose[teamB[cnt]] >= 0) {
						win[teamA[cnt]]--;
						lose[teamB[cnt]]--;
						
						result[cnt] = 1;
						isPossible(cnt+1);
						
						win[teamA[cnt]]++;
						lose[teamB[cnt]]++;
					}
				}
				else if(i == 2) {
					if(draw[teamA[cnt]] >= 0 && draw[teamB[cnt]] >= 0) {
						draw[teamA[cnt]]--;
						draw[teamB[cnt]]--;
						
						result[cnt] = 2;
						isPossible(cnt+1);
						
						draw[teamA[cnt]]++;
						draw[teamB[cnt]]++;
					}
				}
				else {
					if(lose[teamA[cnt]] >= 0 && win[teamB[cnt]] >= 0) {
						lose[teamA[cnt]]--;
						win[teamB[cnt]]--;
						
						result[cnt] = 3;
						isPossible(cnt+1);
						
						lose[teamA[cnt]]++;
						win[teamB[cnt]]++;
					}
				}
			}
		}
	}
}
