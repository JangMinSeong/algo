package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_17406_배열돌리기4 {
	static int [][] map = new int [50][50];
	static int [][] tempMap = new int [50][50];
	static int n, m, k;
	static int [][] r = new int [6][3];
	static int [][] d = { {0,-1},{-1,0},{0,1},{1,0} };

	static boolean [] isSelected = new boolean[6];
	static int []  nums = new int [6];
	static int result = 300000;


	static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
	}

	static int getValueOfArray() {
		int min = 300000;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += tempMap[i][j];
			}
			if (min > sum) min = sum;
		}
		return min;
	}

	static void rotate(int r, int c, int s) {
		int temp=0;
		r--;
		c--;
		for (int i = 1; i <= s; i++) {
			int di = 4;
			int x = r - i;
			int y = c - i;
			temp = tempMap[x][y];

			for (int j = i*8; j >= 1; j--) {
				if (j % (i*2) == 0) di--;
				tempMap[x][y] = tempMap[x + d[di][0]][y + d[di][1]];
				x = x + d[di][0];
				y = y + d[di][1];
			}
			tempMap[x - d[di][0]][y - d[di][1]] = temp;
		}
	}

	static void rotateOper() {
		for (int i = 0; i < k; i++) {
			rotate(r[nums[i]][0], r[nums[i]][1], r[nums[i]][2]);
		}
	}

	static void f(int cnt) {
		if (cnt == k) {

			rotateOper();
			int temp = getValueOfArray();
			if (temp < result) result = temp;
			copyMap();
		}
		else {
			for (int i = 0; i < k; i++) {
				if (isSelected[i] == true) continue;
				nums[cnt] = i;
				isSelected[i] = true;
				f(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		k = Integer.parseInt(str[2]);

		for (int i = 0; i < n; i++) {
			String [] temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				tempMap[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < k; i++) {
			String [] temp = br.readLine().split(" ");
			r[i][0] = Integer.parseInt(temp[0]);
			r[i][1] = Integer.parseInt(temp[1]);
			r[i][2] = Integer.parseInt(temp[2]);
		}

		f(0);

		System.out.println(result);
	}
}
