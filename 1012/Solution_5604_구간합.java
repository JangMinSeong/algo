package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5604_구간합 {
	static int [] rest = {0,1,3,6,10,15,21,28,36,45};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test_case; t++) {
			long ans = 0;
			
			String [] str = br.readLine().split(" ");
			
			long a = f(Long.parseLong(str[1]));
			long b = f(Long.parseLong(str[0]));
			
			ans = a - b;
		//	System.out.println(a + " " + b);
			for(int i=0;i<str[0].length();i++) {
				ans += str[0].charAt(i) - '0';
			}
		
			System.out.println("#" + t + " " + ans);
		}
	}
	
	public static long f(long num) {
		long result = 0;
		long num2 = num;
		
		int cnt = 0;
		while(num != 0) {
			long temp = 45 * (num / 10);
			temp *= Math.pow(10, cnt);
			
			result += temp; //45가득채움
			if(num%10 > 0)
				result += rest[(int) (num%10) - 1] * Math.pow(10, cnt);  
			result += (num % 10) * ((num2 % Math.pow(10, cnt)) + 1); 
			
			cnt++;
			num = num / 10;
		}
		
		
		return result;
	}
}
