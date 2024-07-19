package w0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1074_Z {
	static int n,r,c;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		r = Integer.parseInt(str[1]);
		c = Integer.parseInt(str[2]);
		
		f((int)Math.pow(2, n), 0 , 0);
	}
	
	public static void f(int size, int x, int y) {
		if(size == 2) {
			if(x == r && y== c) {
				System.out.println(count);
				System.exit(0);
			}
			else if(x == r && y + 1 == c) {
				System.out.println(count+1);
				System.exit(0);
			}
			else if(x + 1 == r && y == c) {
				System.out.println(count+2);
				System.exit(0);
			}
			else if(x + 1 == r && y + 1 == c) {
				System.out.println(count+3);
				System.exit(0);
			}
			else count += 4;
		}
		else {
			if(x + (size/2) > r && y + (size /2) > c) {
				f(size/2, x, y);
			}
			else if(x + (size/2) > r && y + (size/2) <= c) {
				count += (size/2) * (size/2);
				f(size/2, x, y + (size/2));
			}
			else if(x + (size/2) <= r && y + (size/2) > c) {
				count += (size/2) * (size/2) * 2;
				f(size/2, x + (size/2), y);
			}
			else {
				count += (size/2) * (size/2) * 3;
				f(size/2, x + (size/2), y + (size/2));
			}
		}
	}
}
