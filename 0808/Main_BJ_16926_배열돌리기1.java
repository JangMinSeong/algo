package w0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_16926_배열돌리기1 {
	static int n, m;
	static int [][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		int r = Integer.parseInt(str[2]);
		map = new int [n][m];
		for(int i=0;i<n;i++) {
			String [] temp = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i=0;i<r;i++) {
			rotate();
		}
		print();
	}
	
	public static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j] +  " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void rotate() {
		int temp;
		int x, y;
		for(int i=0;i<Math.min(n, m)/2;i++) {
			x = i;
			y = i;
			temp = map[x][y];
			for(y = i; y < m-i-1; y++) { //오
				map[x][y] = map[x][y+1];
			}
			for(x = i; x < n-i-1; x++) { //아
				map[x][y] = map[x+1][y];
			}
			for(y = m-i-1; y >= i+1; y--) { //왼
				map[x][y] = map[x][y-1];
			}
			for(x = n-i-1; x >= i+1; x--) {  //위
				map[x][y] = map[x-1][y];
			}
			
			map[x+1][y] = temp;
		}
	}
}
