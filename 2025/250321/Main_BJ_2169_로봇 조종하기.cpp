#include<iostream>

using namespace std;

int n, m;
int map[1001][1001];
int dp[1001][1001][3];
int d[3][2] = { {1,0},{0,1},{0,-1} };

int dfs(int x, int y, int di);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < 1001; i++) {
		for (int j = 0; j < 1001; j++) {
			for(int k=0;k<3;k++)
				dp[i][j][k] = -100000000;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}

	cout << max(dfs(0, 0, 0), dfs(0,0,1)) << endl;
}

int dfs(int x, int y, int di) {
	if (x == n - 1 && y == m - 1) return map[x][y];
	if (dp[x][y][di] != -100000000) return dp[x][y][di];

	for (int i = 0; i < 3; i++) {
		int newX = x + d[i][0];
		int newY = y + d[i][1];

		if (di == 1 && i == 2) continue;
		if (di == 2 && i == 1) continue;
		if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;

		dp[x][y][di] = max(dp[x][y][di], dfs(newX, newY,i) + map[x][y]);
	}

	return dp[x][y][di];
}