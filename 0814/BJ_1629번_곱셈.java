package w0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1629¹ø_°ö¼À {
	static long a;
	static long c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		
		a = Integer.parseInt(str[0]);
		long b = Integer.parseInt(str[1]);
		c = Integer.parseInt(str[2]);
		if(b == 0) System.out.println(0);
		else if( b== 1) System.out.println(a%c);
		else System.out.println(f(b));
	}
	public static long f(long num) {
		if(num == 1) return a;
		
		long temp = f(num/2) % c;
		
		if(num % 2 == 0)
			return (temp * temp) % c;
		else
			return (((temp * temp) % c) * (a%c)) % c;
	}
}
