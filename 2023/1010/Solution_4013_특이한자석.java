package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4013_특이한자석 {
	static int [][] gear;
	static int n;
	static int score;
	static int [][] pos;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		gear = new int [4][8];
		pos = new int [4][3];
		for(int t = 1; t <= test_case; t++) {
			n = Integer.parseInt(br.readLine());
			for(int i=0;i<4;i++) {
				String [] str = br.readLine().split(" ");
				for(int j=0;j<8;j++) {
					gear[i][j] = Integer.parseInt(str[j]);
				}
				pos[i][0] = 6;
				pos[i][1] = 0;
				pos[i][2] = 2;
			}
			score = 0;
			for(int i=0;i<n;i++) {
				String [] str = br.readLine().split(" ");
				int num = Integer.parseInt(str[0]);
				int d = Integer.parseInt(str[1]);
				turn(num-1,d);
			}
			for(int i=0;i<4;i++) {
				int mid = pos[i][1];
				score += (gear[i][mid] << i);
			}
			System.out.println("#" + t + " " + score);
		}
	}
	
	public static void turn(int num, int d) {
		boolean [] isRotate = new boolean[4];
		int [] di = new int[4];
		
		isRotate[num] = true;
		di[num] = d;
		
		int cur = num;
		for(int i=num+1;i<4;i++) {
			int right = pos[cur][2];
			int left = pos[i][0];
			
			if(gear[cur][right] != gear[i][left]) {
				isRotate[i] = true;
				di[i] = di[cur]*(-1);
				cur = i;
			} else break;
		}
		cur = num;
		for(int i=num-1;i>=0;i--) {
			int left = pos[cur][0];
			int right = pos[i][2];
				
			if(gear[cur][left] != gear[i][right]) {
				isRotate[i] = true;
				di[i] = di[cur]*(-1);
				cur = i;
			}else break;
		}
		
		for(int i=0;i<4;i++) {
			if(isRotate[i])
				rotate(i,di[i]);
		}
		
	}
	
	public static void rotate(int num, int d) {
		for(int i=0;i<3;i++)
			pos[num][i] = (pos[num][i] - d + 8) % 8;
	}
}
