#include<iostream>
#include<queue>
#include<tuple>
#include<string>

using namespace std;

int n, m, k;
int map[1001][1001];
int visit[1001][1001][11];
int d[4][2] = { {1,0},{0,1},{-1,0},{0,-1} };
int ans = 999999999;

void bfs();

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m >> k;

	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++) {
			map[i][j] = str[j] - '0';
		}
	}

	bfs();

	for (int i = 0; i <= k; i++) {
		if (ans > visit[n - 1][m - 1][i] && visit[n - 1][m - 1][i] != 0) ans = visit[n - 1][m - 1][i];
	}

	if (ans == 999999999) cout << -1;
	else cout << ans;
}

void bfs() {
	queue<tuple<int, int, int>> que;

	visit[0][0][0] = 1;
	que.push(make_tuple( 0,0,0 ));

	while (!que.empty()) {
		int x, y, h;
		tie(x, y, h) = que.front();
		que.pop();
		for (int i = 0; i < 4; i++) {
			int newX = x + d[i][0];
			int newY = y + d[i][1];

			if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
			if (visit[newX][newY][h] != 0) continue;
			if (map[newX][newY] == 1) {
				if (h >= k || visit[newX][newY][h+1] != 0) continue;
				visit[newX][newY][h + 1] = visit[x][y][h] + 1;
				que.push(make_tuple(newX, newY, h + 1));
			}
			
			else {
				visit[newX][newY][h] = visit[x][y][h] + 1;
				que.push(make_tuple(newX, newY, h));
			}

			if (newX == n - 1 && newY == m - 1) return;
		}
	}
}