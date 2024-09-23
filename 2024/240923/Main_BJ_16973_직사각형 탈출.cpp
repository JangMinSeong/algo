#include<iostream>
#include<queue>
using namespace std;

int n, m;
int map[1001][1001];
int dp[1001][1001];
int reduceMap[1001][1001];
int visit[1001][1001];
int d[4][2] = { {1,0},{0,1},{-1,0},{0,-1} };

int h, w, sx, sy, fx, fy;

void bfs();

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> map[i][j];
			dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + map[i][j] - dp[i - 1][j - 1];
		}
	}
	cin >> h >> w >> sx >> sy >> fx >> fy;

	for (int i = 1; i <= n - h + 1; i++) {
		for (int j = 1; j <= m - w + 1; j++) {
			reduceMap[i][j] = dp[i + h - 1][j + w - 1] - dp[i - 1][j + w - 1] - dp[i + h - 1][j - 1] + dp[i - 1][j - 1];
		}
	}

	bfs();

	cout << visit[fx][fy] - 1 << endl;
	return 0;
}

void bfs() {
	queue<pair<int, int>> que;
	que.push({ sx,sy });
	visit[sx][sy] = 1;
	while (!que.empty()) {
		pair<int, int> cur = que.front();
		que.pop();

		for (int i = 0; i < 4; i++) {
			int newX = cur.first + d[i][0];
			int newY = cur.second + d[i][1];

			if (newX < 1 || newX > n - h + 1 || newY < 1 || newY > m - w + 1) continue;
			if (reduceMap[newX][newY] != 0) continue;
			if (visit[newX][newY] != 0) continue;

			visit[newX][newY] = visit[cur.first][cur.second] + 1;
			que.push({ newX, newY });
		}
	}
}