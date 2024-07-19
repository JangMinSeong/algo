package w0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1992_ÄõµåÆ®¸® {
	static int n;
	static int[][] image;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		image = new int [n][n];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				image[i][j] = str.charAt(j) - '0';
			}
		}
		
		int temp = image[0][0];
		int ch = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(temp != image[i][j])
					ch = 1;
			}
		}
		if(ch == 1) 
			System.out.println(f(n,0,0));
		else
			System.out.println(temp);
	}
	
	public static boolean compCh(int size, int x, int y) {
		int temp = image[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(temp != image[i][j]) return false;
			}
		}
		return true;
	}
	
	public static String f(int size, int x, int y) {
		String ans = "(";
		if(size == 2) {
			int temp = image[x][y];
			int ch = 1;
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					ans += String.format("%d", image[x+i][y+j]);
					if(temp != image[x+i][y+j]) ch = 0; 
				}
			}
			if(ch == 0) return ans+")";
			else return String.format("%d", temp);
		}
		else {
			size = size / 2;
			String [] temp = new String[4];
			if(compCh(size,x,y)) temp[0] = String.format("%d", image[x][y]); 
			else temp[0] = f(size,x,y);
			if(compCh(size,x,y+size)) temp[1] = String.format("%d", image[x][y+size]);
			else temp[1] = f(size,x,y+size);
			if(compCh(size,x+size,y)) temp[2] = String.format("%d", image[x+size][y]);
			else temp[2] = f(size,x+size,y);
			if(compCh(size,x+size,y+size)) temp[3] = String.format("%d", image[x+size][y+size]);
			else temp[3] = f(size,x+size,y+size);
			
			ans = ans + temp[0] + temp[1] + temp[2] + temp[3] + ")";
			return ans;
		}
	}
	
}
