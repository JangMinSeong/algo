package w0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1952_¼ö¿µÀå {
	static int [] price;
	static int [] plan;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= test_case;t++) {		
			String [] str = br.readLine().split(" ");
			price = new int [4];
			min = 1000000;
			
			for(int i=0;i<4;i++) 
				price[i] = Integer.parseInt(str[i]);
			
			String [] temp = br.readLine().split(" ");
			plan = new int [12];
			
			for(int i=0;i<12;i++) 
				plan[i] = Integer.parseInt(temp[i]);
			
			f(0,0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void f(int cnt, int sum) {
		if(sum > min) return;
		if(cnt >= 12) {
			if(sum < min) min = sum;
			return;
		}
		else {
			f(cnt+1, sum + (plan[cnt] * price[0]));
			f(cnt+1, sum + price[1]);
			f(cnt+3, sum + price[2]);
			f(cnt+12,sum + price[3]);
		}
	}
}
