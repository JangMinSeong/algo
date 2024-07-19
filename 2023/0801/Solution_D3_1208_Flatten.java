package w0801;

import java.util.Scanner;

public class Solution_D3_1208_Flatten {
	public static void main(String[] args) {
		int test_case = 10;
		Scanner sc= new Scanner(System.in);
		
		for(int c = 0; c < test_case; c++) {
			int num = sc.nextInt();
			int [] block = new int [101];
			int max = 0;
			int min = 100;
			for(int i=0;i<100;i++) {
				int h = sc.nextInt();
				if(max < h) max = h;
				if(min > h) min = h;
				block[h]++;
			}
			for(int i=0;i<num;i++) {
				block[max]--;
				block[max-1]++;
				if(block[max] == 0) max--;
				block[min]--;
				block[min+1]++;
				if(block[min] == 0) min++;
			}
			System.out.println("#" + (c+1) + " " + (max - min));
		}
		
	}
}
