package w0801;

import java.util.Scanner;

public class Solution_D4_1210_Ladder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = 10;
		
		for(int c = 0; c < test_case; c++) {
			int [][] map = new int [102][102];
			int test = sc.nextInt();
			
			int posX= 100, posY = 0;
			
			for(int i=1;i<=100;i++) {
				for(int j=1;j<=100;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 1; i <= 100;i++) {
				if(map[100][i] == 2) {
					posY = i;
					break;
				}
			}

			while(posX != 1) {

				if(map[posX][posY-1] == 1) {
					while(map[posX][posY-1] == 1) posY--;
				}
				else if(map[posX][posY+1] == 1) {
					while(map[posX][posY+1] == 1) posY++;
				}			
				posX--;
			}
			
			System.out.println("#" + test + " " + (posY-1));
		}
	}
}
