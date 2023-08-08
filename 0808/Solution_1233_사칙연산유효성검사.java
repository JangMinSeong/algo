package w0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = 10;
		
		for(int t=1;t<=test_case;t++) {
			int n = Integer.parseInt(br.readLine());
			int ch = 1;
			for(int i=0;i<n;i++) {
				String [] str = br.readLine().split(" ");
				if(str.length > 3 && (str[1].charAt(0) >= '0' && str[1].charAt(0) <= '9'))
					ch = 0;		
				if(str.length < 3 && (str[1].charAt(0) < '0' && str[1].charAt(0) > '9')) 
					ch = 0;
			}
			System.out.println("#" + t + " " + ch);
		}
	}
}
