package w0802;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		int [][] d = {{0,1},{1,0},{0,-1},{-1,0}};
		
		for(int t=0;t<test_case;t++) {
			int n = sc.nextInt();
			
			int c = 1; //한방향으로 가는 개수
			int length = n;  //한 방향으로 갈 수 있는 길이
			int direction = 0; //방향변수 오,아,왼,위 순
			
			int [][] map = new int [n][n]; 
			int x = 0, y = 0;  
			
			int count = 1;  //2번까지 세면 길이 변화 (처음엔 1)
			
			for(int i=1;i<=n*n;i++, c++) {
				map[x][y] = i;
				
				if(c == length) { 
					direction = (++direction) % 4;
					count++;
					if(count % 2 == 0) {
						length -= 1;
						count = 0;
					}
					c = 0;
				}
				x += d[direction][0];
				y += d[direction][1];
			}
			System.out.println("#" + (t+1));
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
