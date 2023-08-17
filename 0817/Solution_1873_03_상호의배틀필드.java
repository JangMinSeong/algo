package w0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class pair {
	int x;
	int y;
	public pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

public class Solution_1873_03_상호의배틀필드 {
	static pair tank;
	static char [][] map;
	static int direction;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static int h,w;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1; t<= test_case;t++) {
			String [] str = br.readLine().split(" ");
			h = Integer.parseInt(str[0]);
			w = Integer.parseInt(str[1]);
			map = new char [h+2][w+2];
			for(int i=1;i<=h;i++) {
				String temp = br.readLine();
				for(int j=1;j<=w;j++) {
					map[i][j] = temp.charAt(j-1);
					switch(map[i][j]) {
					case '>': direction = 1; tank = new pair(i,j); break;
					case 'v': direction = 0; tank = new pair(i,j); break;
					case '<': direction = 3; tank = new pair(i,j); break;
					case '^': direction = 2; tank = new pair(i,j); break;
					default : break;
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			String temp2 = br.readLine();
			for(int i=0;i<n;i++) {
				switch(temp2.charAt(i)) {
				case 'U': moveUp(); break;
				case 'D': moveDown(); break;
				case 'L': moveLeft(); break;
				case 'R': moveRight(); break;
				case 'S': shoot(); break;
				default : break;
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i=1;i<=h;i++) {
				for(int j=1;j<=w;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	public static void moveUp() {
		if(map[tank.getX() - 1][tank.getY()] == '.') {
			map[tank.getX()][tank.getY()] = '.';
			tank.x--;
		}
		direction = 2;			
		map[tank.getX()][tank.getY()] = '^';
	}
	public static void moveDown() {
		if(map[tank.getX() + 1][tank.getY()] == '.') {
			map[tank.getX()][tank.getY()] = '.';
			tank.x++;
		}
		direction = 0;
		map[tank.getX()][tank.getY()] = 'v';
	}
	public static void moveLeft() {
		if(map[tank.getX()][tank.getY() - 1] == '.') {
			map[tank.getX()][tank.getY()] = '.';
			tank.y--;
		}
		direction = 3;
		map[tank.getX()][tank.getY()] = '<';
	}
	public static void moveRight() {
		if(map[tank.getX()][tank.getY() + 1] == '.') {
			map[tank.getX()][tank.getY()] = '.';
			tank.y++;
		}
		direction = 1;
		map[tank.getX()][tank.getY()] = '>';
	}
	public static void shoot() {
		int x = tank.getX();
		int y = tank.getY();
		int newX = x;
		int newY = y;
		while(true) {
			newX = newX + d[direction][0];
			newY = newY + d[direction][1];
			
			if(newX > h || newX < 1 || newY > w || newY < 1) break;
			if(map[newX][newY] == '#') break;
			if(map[newX][newY] == '*') {
				map[newX][newY] = '.';
				break;
			}
		}
	}
}
