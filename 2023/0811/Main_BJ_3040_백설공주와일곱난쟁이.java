package w0811;

import java.util.Scanner;

public class Main_BJ_3040_归汲傍林客老蚌抄里捞 {
	static int [] nums = new int [9];
	static int [] number = new int [9];
	static boolean [] isSelected = new boolean [9];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<9;i++) {
			nums[i] = sc.nextInt();
			isSelected[i] = false;
		}
		f(0,0);
	}
	
	public static void f(int t, int start) {
		if(t == 7) {
			int sum = 0;
			for(int i=0;i<7;i++) {
				sum += nums[number[i]];
			}
			if(sum == 100) {
				for(int i=0;i<7;i++) {
					System.out.println(nums[number[i]]);
				}
			}
			return;
		}
		else {
			for(int i=start;i<9;i++) {
				if(isSelected[i] == true) continue;
				number[t] = i;
				isSelected[i] = true;
				f(t+1, i);
				isSelected[i] = false;
			}
		}
	}
}
