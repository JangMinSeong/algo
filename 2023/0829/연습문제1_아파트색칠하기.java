package w0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ��������1_����Ʈ��ĥ�ϱ� {
	public static void main(String[] args) {
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(fibo(8));
	}
	
	public static int fibo(int n) {
		if(n == 1) return 2;
		if(n == 2) return 3;
		return fibo(n-1) + fibo(n-2);
	}
}
