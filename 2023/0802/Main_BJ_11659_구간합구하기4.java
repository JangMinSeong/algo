package w0802;

import java.util.Scanner;

public class Main_BJ_11659_구간합구하기4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] nums = new int [n];
		long [] sum = new long [n + 1];
		long temp = 0;
		sum[0] = 0;
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
			temp += nums[i];
			sum[i+1] = temp;
		}
		
		for(int i=0;i<m;i++) {
			int start, end;
			start = sc.nextInt() - 1;
			end = sc.nextInt() - 1;
			System.out.println(sum[end+1] - sum[start]);
		}
	}
}
