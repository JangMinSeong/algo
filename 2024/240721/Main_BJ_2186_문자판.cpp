#include<iostream>
#include<vector>
#include<string>
#include<cstring>

using namespace std;

int n, m, k;
char map[100][100];
int visit[100][100][81];
int d[4][2] = { {1,0},{0,1},{-1,0},{0,-1} };
string str;
int ans = 0;

int dfs(int x, int y, int depth);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m >> k;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}
	cin >> str;
	memset(visit, -1, sizeof(visit));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == str[0]) {
				ans += dfs(i, j, 1);
			}
		}
	}


	cout << ans;
}

int dfs(int x, int y, int depth) {
	if (visit[x][y][depth] != -1) return visit[x][y][depth];
	if (depth == str.length()) return 1;

	visit[x][y][depth] = 0;

	for (int i = 1; i <= k; i++) {
		for (int j = 0; j < 4; j++) {
			int newX = x + (d[j][0] * i);
			int newY = y + (d[j][1] * i);
			
			if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;

			if (map[newX][newY] == str[depth]) {
				visit[x][y][depth] += dfs(newX, newY, depth + 1) ;
			}
		}
	}
	return visit[x][y][depth];
}