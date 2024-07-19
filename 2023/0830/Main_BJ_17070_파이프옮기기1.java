package w0830;

import java.util.Scanner;

class Pair {
	int first;
	int second;
	
	public Pair(int first,int second) {
		this.first = first;
		this.second = second;
	}
}

public class Main_BJ_17070_파이프옮기기1 {
    static int[][] map;
    static int[][] m = { {0,1,0,1},{1,0,1,0},{0,1,1,1},{1,0,1,1} };
    static int n;
    static int c = 0;

    public static void solve(Pair a, Pair b, int d) {
        if (b.first >= n || b.second >= n) return;
        if (map[b.first][b.second] != 0 || map[a.first][a.second] != 0) return;
        if (d == 2 && (map[b.first][b.second - 1] != 0 || map[a.first][a.second + 1] != 0)) return;
        if (b.first == n - 1 && b.second == n - 1) {
            c++;
            return;
        }
        switch (d) {
            case 0: a.second += 1;
                    b.second += 1;
                    solve(new Pair(a.first,a.second), new Pair(b.first,b.second), 0);
                    b.first += 1;
                    solve(new Pair(a.first,a.second), new Pair(b.first,b.second), 2);
                    break;
            case 1: a.first += 1;
                    b.first += 1;
                    solve(new Pair(a.first,a.second), new Pair(b.first,b.second), 1);
                    b.second += 1;
                    solve(new Pair(a.first,a.second), new Pair(b.first,b.second), 2);
                    break;
            case 2: a.first += 1;
                    a.second += 1;
                    b.second += 1;
                    solve(new Pair(a.first,a.second), new Pair(b.first,b.second), 0);
                    b.first += 1;
                    solve(new Pair(a.first,a.second), new Pair(b.first,b.second), 2);
                    b.second -= 1;
                    solve(new Pair(a.first,a.second), new Pair(b.first,b.second), 1);
                    break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        solve(new Pair(0,0), new Pair(0,1), 0);
        System.out.println(c);
    }
}
