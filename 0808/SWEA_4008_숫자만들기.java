package w0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4008_숫자만들기 {
	static int [] nums;
	static int [] oper;
	static int [] per;
	static int n;
	static int max;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<=test_case;t++) {
			max = -1000000001;
			min = 1000000001;
			n = Integer.parseInt(br.readLine());
			
			String [] str = br.readLine().split(" ");
			String [] temp = br.readLine().split(" ");
			nums = new int [n];
			oper = new int[4];
			per = new int [n-1];
			
			getOper(str);
			for(int i=0;i<n;i++) {
				nums[i] = Integer.parseInt(temp[i]);
			}
			
			f(0);
			
			System.out.print("#" + t + " ");
			System.out.println(max - min);
		}
	}
	
	public static void getOper(String [] str) {
		for(int i=0;i<4;i++) {
			oper[i] = Integer.parseInt(str[i]);
		}
	}
	
	public static int cal(int a, int b, int op) {
		switch(op) {
		case 0: return a + b; 
		case 1: return a - b;
		case 2: return a * b; 
		case 3: return a / b; 
		}
		return 0;
	}
	
	public static void f(int cnt) {
		if(cnt == n-1) {
			int num = nums[0];
			for(int i=0;i<n-1;i++) {
				num = cal(num, nums[i+1], per[i]);
			}
			if(max < num) max = num;
			if(min > num) min = num;
			return;
		}
		for(int i=0;i<4;i++) {
			if(oper[i] != 0) {
				oper[i]--;
				per[cnt] = i;
				f(cnt+1);
				oper[i]++;
			}
		}
	}
}
