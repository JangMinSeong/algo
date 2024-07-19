package w0801;

import java.util.Scanner;

public class Main_BJ_15469_N��M {
	static int [] nums = new int [9];
	static boolean [] isSelected = new boolean [9];
	static int n,m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			isSelected[i] = false;
		}
		
		f(0);
	}
	
	public static void f(int t) {
		if(t == m) {
			for(int i=0;i<m;i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i=1;i<=n;i++) {
				if(isSelected[i] == true) continue;
				nums[t] = i;
				isSelected[i] = true;
				f(t+1);
				isSelected[i] = false;
			}
		}
	}
}
