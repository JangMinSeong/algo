package w0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1010_다리놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String [] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			int num = 1;
			for(int j = 0; j < a; j++) {
				num *= (b - j);
				num /= (j + 1);
			}
			System.out.println(num);
		}
	}
}
