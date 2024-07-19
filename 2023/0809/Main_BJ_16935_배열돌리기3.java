package w0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_16935_배열돌리기3 {
	public static int [][] map;
	public static int n,m;
	
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
		
		String [] command = br.readLine().split(" ");
		for(int i=0;i<r;i++) {		
			switch(Integer.parseInt(command[i])) {
			case 1: command1(); break;
			case 2: command2(); break;
			case 3: command3(); break;
			case 4: command4(); break;
			case 5: command5(); break;
			case 6: command6(); break;
			}
		}
		
		print();
	}
	public static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void command1() {
		int temp;
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m;j++) {
				temp = map[i][j];
				map[i][j] = map[n-i-1][j];
				map[n-i-1][j] = temp;
			}
		}
	}
	public static void command2() {
		int temp;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m/2;j++) {
				temp = map[i][j];
				map[i][j] = map[i][m-j-1];
				map[i][m-j-1] = temp;
			}
		}
	}
	public static void command3() {
		int max = Math.max(n, m);
		int [][] temp = new int [max][max];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				temp[j][n-i-1] = map[i][j];
			}
		}
		map = new int [m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = temp[i][j];
			}
		}
		int t = n;
		n = m;
		m = t;
	}
	public static void command4() {
		int max = Math.max(n, m);
		int [][] temp = new int [max][max];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				temp[m-j-1][i] = map[i][j];
			}
		}
		map = new int [m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = temp[i][j];
			}
		}
		int t = n;
		n = m;
		m = t;
	}
	public static void command5() {
		int [][] temp = new int [n/2][m/2];
		for(int i=0;i<n/2;i++)
			for(int j=0;j<m/2;j++) 
				temp[i][j] = map[i][j];
		
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m/2;j++) {
				map[i][j] = map[i + n/2][j];
				map[i+n/2][j] = map[i+n/2][j+m/2];
				map[i+n/2][j+m/2] = map[i][j+m/2];
				map[i][j+m/2] = temp[i][j];
			}
		}
	}
	public static void command6() {
		int [][] temp = new int [n/2][m/2];
		for(int i=0;i<n/2;i++)
			for(int j=0;j<m/2;j++) 
				temp[i][j] = map[i][j];
		
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m/2;j++) {
				map[i][j] = map[i][j + m/2];
				map[i][j + m/2] = map[i+n/2][j+m/2];
				map[i+n/2][j+m/2] = map[i+n/2][j];
				map[i+n/2][j] = temp[i][j];
			}
		}
	}
}
