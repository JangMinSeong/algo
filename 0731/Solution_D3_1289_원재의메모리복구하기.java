package w0731;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int test_case = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<test_case;i++) {
			String line = sc.nextLine();
			int count = 0;
			char cur = '0';
			for(int j=0;j<line.length();j++) {
				if(cur != line.charAt(j)) {
					count++;
					cur = line.charAt(j);
				}
			}
			System.out.println("#" + (i+1) + " " + count);
		}
	}
}
