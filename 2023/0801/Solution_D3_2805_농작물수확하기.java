package w0801;

import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		
		for(int c = 0; c < test_case; c++) {
			int num = Integer.parseInt(sc.nextLine());
			String str;
			int [][] nums = new int [49][49];
			for(int i=0;i<num;i++) {
				str = sc.nextLine();
				for(int j=0;j<num;j++) {
					nums[i][j] = str.charAt(j) - '0';
				}
			}
			
			int sum = 0;
			int width = 1;
			for(int i=0;i<num/2;i++) {
				for(int j =(num/2 - i); j < (num/2) - i + width; j++) {
					sum += nums[i][j];
				}
				width += 2;
			}
			for(int i=0;i<num;i++) {
				sum += nums[num/2][i];
			}
			for(int i=num/2+1;i <num;i++) {
				width -= 2;
				for(int j=(i - num/2); j < (i - num/2) + width; j++)
				{
					sum += nums[i][j];
				}
			}
			System.out.println("#"+(c+1)+" " + sum);
		}
	}
}
