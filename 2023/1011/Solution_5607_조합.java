package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5607_а╤гу {
	static int n, c;
	static long [] fact = new long [1000001];
	static int mod = 1234567891;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<= test_case;t++) {
			String str [] = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			c = Integer.parseInt(str[1]);
			
			init();
			
			long num1 = fact[n];
			long num2 = ( fact[n-c] * fact[c] ) % mod;
			long num3 = p(num2, mod - 2);
			
			System.out.println("#" + t + " " + ((num1 * num3) % mod));
		}
	}
	public static long p(long a, int b) {
		if(b == 0) return 1;
		else if(b == 1) return a;
		else {
			long t = p(a, b / 2) % mod;
			if(b % 2 == 0) return (t * t) % mod;
			else return (a * ((t * t) % mod)) % mod;
		}
	}
	
	public static void init() {
		fact[0] = 1;
		for(int i=1;i<=n;i++) {
			fact[i] = (fact[i-1] * i) % mod;
		}
	}
}
