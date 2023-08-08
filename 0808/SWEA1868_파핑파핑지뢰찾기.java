package w0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
	private int x;
	private int y;
	public Pair(int x, int y) {
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

public class SWEA1868_파핑파핑지뢰찾기 {
	static char [][] map;
	static int [][] mine;
	static int [][] travel;
	static int ans;
	static int n;
	static int[][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test_case;t++) {
			ans = 0;
			n = Integer.parseInt(br.readLine());
			
			map = new char [n+2][n+2];
			mine = new int [n+2][n+2];
			travel = new int [n+2][n+2];
			
			for(int i=1;i<=n;i++) {
				String str = br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j+1] = str.charAt(j);
					if(map[i][j+1] == '*') {
						for(int k=0;k<8;k++) {
							int x = i + d[k][0];
							int y = j + 1 + d[k][1];
							
							mine[x][y]++;
						}
						mine[i][j + 1] = -100;
					}
				}
			}
			for(int i=0;i<n+2;i++) {
				mine[i][0] = -100;
				mine[0][i] = -100;
				mine[n+1][i] = -100;
				mine[i][n+1] = -100;
			}
			
			int c = 0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(mine[i][j] == 0 && travel[i][j] == 0) { bfs(i,j); }
				}
			}
			

			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(mine[i][j] > 0 && travel[i][j] == 0) ans++;
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Pair> que = new LinkedList<>();
		que.add(new Pair(x,y));
		
		while(!que.isEmpty()) {
			int curX = que.peek().getX();
			int curY = que.peek().getY();
			travel[curX][curY] = 1;
			que.poll();
			for(int i=0;i<8;i++) {
				int newX = curX + d[i][0];
				int newY = curY + d[i][1];
				if(mine[newX][newY] > 0 && travel[newX][newY] == 0) {
					travel[newX][newY] = 1;
				}
				else if(mine[newX][newY] == 0 && travel[newX][newY] == 0) {
					que.add(new Pair(newX,newY));
					travel[newX][newY] = 1;
				}
			}
		}
		ans++;
	}
	
	public static void print() {
		for(int i=0;i<=n+1;i++) {
			for(int j=0;j<=n+1;j++) {
				System.out.printf("%5d ",mine[i][j]);
			}
			System.out.println();
		}
	}
}
