package w0801;

import java.util.Scanner;

public class Main_BJ_1244_스위치켜고끄기 {
	static int n;
	static int[] swit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		swit = new int [n+1];
		
		for(int i=1;i<=n;i++) {
			swit[i] = sc.nextInt();
		}

		int peo = sc.nextInt();
		
		for(int i=0;i<peo;i++) {
			int gender, num;
			gender = sc.nextInt();
			num = sc.nextInt();
			
			switch(gender) {
			case 1: f1(num); break;
			case 2: f2(num); break;
			}
			
//			for(int j=1;j<=n;j++) {
//			System.out.printf("%d ", swit[j]);
//				if(j % 20 == 0)
//					System.out.println();
//			}
		}
//		System.out.println();
		for(int i=1;i<=n;i++) {
			System.out.printf("%d ", swit[i]);
			if(i % 20 == 0)
				System.out.println();
		}
	}
	public static void f1(int num) {
		for(int i=1; i <= n/num; i++) {
			int t = i * num;
			if(swit[t] == 0)
				swit[t] = 1;
			else
				swit[t] = 0;
		}
	}
	
	public static void f2(int num) {
		int t = f3(num,0);
	//	System.out.println("t = " + t);
		for(int i = num - t; i <= num + t;i++) {
			if(swit[i] == 0) swit[i] = 1;
			else swit[i] = 0;
		}
	}
	
	public static int f3(int num, int t) {
		if(num - t < 1 || num + t > n) return t-1;
		if(swit[num-t] != swit[num+t]) return t-1;
		return f3(num,t+1);
	}
}
