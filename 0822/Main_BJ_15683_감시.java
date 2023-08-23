package w0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Cam{
	int x;
	int y;
	ArrayList<Integer> direction;
	public Cam(int x, int y, ArrayList direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	public void rotate() {
		for(int i=0;i<direction.size();i++) {
			int d = direction.get(i);
			direction.set(i,(d+1)%4);
		}
	}
}

public class Main_BJ_15683_°¨½Ã {
	static int n,m;
	static int [][] map;
	static int [][] copyMap;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static ArrayList<Cam> camera;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		map = new int [n+2][m+2];
		copyMap = new int [n+2][m+2];
		camera = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			String [] temp = br.readLine().split(" ");
			for(int j=1;j<=m;j++) {
				map[i][j] = Integer.parseInt(temp[j-1]);
				if(map[i][j] > 0 && map[i][j] < 6)
					camera.add(makeCamera(i,j,map[i][j]));
			}
		}
		for(int i=0;i<=n+1;i++) {
			map[i][0] = -1;
			map[i][m+1] = -1;
		}
		for(int i=0;i<=m+1;i++) {
			map[0][i] = -1;
			map[n+1][i] = -1;
		}
		
		f(0);
		
		System.out.println(min);
	}
	
	public static void f(int cnt) {
		if(cnt == camera.size()) {
			copy();
			for(int i=0;i<cnt;i++)
				fillSight(i);
			int c = countZero();
			if(c < min) min = c;
		}
		else {
			for(int i=0;i<4;i++) {
				f(cnt+1);
				camera.get(cnt).rotate();
			}
		}
	}
	
	public static void copy() {
		for(int i=0;i<=n+1;i++) {
			for(int j=0;j<=m+1;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
	
	public static Cam makeCamera(int x, int y, int num) {
		ArrayList<Integer> t = new ArrayList<>();
		switch(num) {
		case 1: t.add(0); break;
		case 2: t.add(0); t.add(2); break;
		case 3: t.add(0); t.add(1); break;
		case 4: t.add(0); t.add(1); t.add(2); break;
		case 5: t.add(0); t.add(1); t.add(2); t.add(3); break;
		}
		return new Cam(x,y,t);
	}
	
	public static void fillSight(int idx) {
		Cam temp = camera.get(idx);
		for(int i=0;i < temp.direction.size();i++) {
			int t = temp.direction.get(i);
			int newX = temp.x + d[t][0];
			int newY = temp.y + d[t][1];
			while(map[newX][newY] != -1 && map[newX][newY] != 6) {
				if(map[newX][newY] == 0) {
					copyMap[newX][newY] = -1;
				}
				newX += d[t][0];
				newY += d[t][1];
			}
		}
	}
	
	public static int countZero() {
		int count = 0;
		for(int i=1;i<=n;i++) 
			for(int j=1;j<=m;j++) 
				if(copyMap[i][j] == 0) count++;
		return count;
	}
}	
