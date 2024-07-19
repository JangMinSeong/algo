package w0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2630_»öÁ¾ÀÌ {
	static int n;
	static int [][] map;
	static int white = 0, blue = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		for(int i=0;i<n;i++) {
			String [] str = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		f(n,0,0);
		
		System.out.println(white);
		System.out.println(blue);
	}
	public static boolean chMap(int size, int x, int y) {
		int temp = map[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(temp != map[i][j]) return false;
			}
		}
		return true;
	}
	public static void f(int size, int x, int y) {
		if(size == 1 || chMap(size, x, y)) {
			if(map[x][y] == 0) white++;
			else blue++;
			return;
		}
		else {
			size = size/2;
			f(size, x, y);
			f(size, x, y + size);
			f(size, x+size, y);
			f(size, x+size, y+size);
		}
	}
}
