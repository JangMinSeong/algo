package w0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_9229_ÇöºóÀÌ¿ÍSpotMart {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			String [] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			
			String [] temp = br.readLine().split(" ");
			int max = 0;
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					int num1 = Integer.parseInt(temp[i]);
					int num2 = Integer.parseInt(temp[j]);
					
					if(num1 + num2 <= m && num1 + num2 > max) {
						max = num1 + num2;
					}
				}
			}
			System.out.print("#" + t + " ");
			if(max == 0) System.out.println(-1);
			else System.out.println(max);
		}
	}
}
