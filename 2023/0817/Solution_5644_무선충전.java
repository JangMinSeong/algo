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
}

public class Solution_5644_무선충전 {
	static int [][] map;
	static int [][] map2;
	static pair p1, p2;
	static int [][] d = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	static int [] power;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test_case;t++) {
			int m,a;
			
			map = new int [11][11];
			map2 = new int [11][11];
			p1 = new pair(1,1);
			p2 = new pair(10,10);
			int max = 0;
			
			String[] temp = br.readLine().split(" ");
			m = Integer.parseInt(temp[0]);
			a = Integer.parseInt(temp[1]);
			String[] move1 = br.readLine().split(" ");
			String[] move2 = br.readLine().split(" ");
			
			power = new int[a+1];
			power[0] = 0;
			for(int i=1;i<=a;i++) {
				String [] str = br.readLine().split(" ");
				int x,y,c,p;
				x = Integer.parseInt(str[0]);
				y = Integer.parseInt(str[1]);
				c = Integer.parseInt(str[2]);
				p = Integer.parseInt(str[3]);
				power[i] = p;
				bc(y,x,c,p,i);
			}
			max += (power[map[1][1]] + power[map[10][10]]);
			for(int i=0;i<m;i++) {
				int d1 = Integer.parseInt(move1[i]);
				int d2 = Integer.parseInt(move2[i]);
				p1.x += d[d1][0];
				p1.y += d[d1][1];
				
				p2.x += d[d2][0];
				p2.y += d[d2][1];
				
				if(map[p1.x][p1.y] == map[p2.x][p2.y]) {
					max += Math.max(power[map[p1.x][p1.y]] + power[map2[p2.x][p2.y]] , power[map2[p1.x][p1.y]] + power[map[p2.x][p2.y]]); 
					//System.out.println("1. " + power[map[p1.x][p1.y]]+ " " + power[map2[p2.x][p2.y]] + " (" + p1.x + ", " + p1.y +")" + "(" + p2.x +", " + p2.y + ")" );
				}
				else {
					max += power[map[p1.x][p1.y]] + power[map[p2.x][p2.y]];
					//System.out.println("2. " + power[map[p1.x][p1.y]]+ " " + power[map[p2.x][p2.y]] + " (" + p1.x + ", " + p1.y +")" + "(" + p2.x +", " + p2.y + ")" );
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static void bc(int x, int y, int c, int p, int idx) {
		for(int i=x-c;i<=x+c;i++) {
			for(int j=y-c;j<=y+c;j++) {
				if(i < 1 || i > 10 || j < 1 || j > 10) continue;
				if(Math.abs(i-x) + Math.abs(j-y) <= c) {
					if(power[map[i][j]] < p) {
						map2[i][j] = map[i][j];
						map[i][j] = idx;
					}
					else if(power[map2[i][j]] < p) {
						map2[i][j] = idx;
					}
				}
			}
		}
	}
}
