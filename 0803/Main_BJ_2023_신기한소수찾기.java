package w0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2023_신기한소수찾기 {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		int temp;
		if(n == 1) {System.out.println(2); temp = (int) (Math.pow(10,n-1)); }
		else temp = (int) (Math.pow(10,n-1) + 1);
		for(int i = temp; i < Math.pow(10, n); i += 2) {
			if(find(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean find(int number) {
		int t = number;
		int num = 0;
		for(int j=n-1;j>=0;j--) {
			num = (num*10) + (t / (int)Math.pow(10, j));
		//	System.out.println(num);
			t = t % (int)Math.pow(10, j);
			if(!isPrime(num)) return false; 
		}
		return true;
	}
	
	public static boolean isPrime(int num) {
		if(num == 1) return false;
		if(num % 2 == 0 && num != 2) return false;
		for(int i = 3; i <= Math.sqrt(num);i += 2) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
