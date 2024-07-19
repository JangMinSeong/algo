package w0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2961_도영이가만든맛있는음식 {
	static int n;
	static int [][] food = new int [10][2];
	static boolean [] used = new boolean [10];
	static int sour, bitter;
	static int min = 1000000001;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++) {
			String[] str = bf.readLine().split(" ");
			food[i][0] = Integer.parseInt(str[0]);
			food[i][1] = Integer.parseInt(str[1]);
			used[i] = false;
		}
		
		f(0);
		
		System.out.println(min);
	}
	
	public static void f(int cnt) {
		if(cnt == n) {
			sour = 1;
			bitter = 0;
			int c = 0;
			for(int i=0;i<n;i++) {
				if(used[i] == true) {
					sour *= food[i][0];
					bitter += food[i][1];
					c = 1;
				}
			}
			if(Math.abs(sour - bitter) < min && c != 0) {
				min = Math.abs(sour - bitter);
			}
		}
		else {
			used[cnt] = true;
			f(cnt+1);
			used[cnt] = false;
			f(cnt+1);
		}
	}
}
