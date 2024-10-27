#include<iostream>
#include<queue>

using namespace std;

int n, m;
int map[301][301];
int afterMelt[301][301];
bool visit[301][301];
int d[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };
int cnt = 0;

void clear();
void copy();
void melt();
void bfs(int x, int y);
bool isConnect();

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) 
		for (int j = 0; j < m; j++) 
			cin >> map[i][j];

	int ans = 0;
	while (1) {
		ans++;
		clear();
		melt();
		copy();
		
		int ch = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					bfs(i, j);
					ch = 1;
					break;
				}
			}
			if (ch == 1) break;
		}

		if (cnt == 0 || isConnect() == false) break;
	}

	if (cnt == 0) cout << 0;
	else cout << ans;

	return 0;
}

void clear() {
	cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			visit[i][j] = false;
			afterMelt[i][j] = 0;
		}
	}
}

void copy() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			map[i][j] = afterMelt[i][j];
		}
	}
}

void melt() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] != 0) {
				afterMelt[i][j] = map[i][j];
				for (int k = 0; k < 4; k++) {
					int newX = i + d[k][0];
					int newY = j + d[k][1];
					if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
					if (map[newX][newY] == 0 && afterMelt[i][j] != 0) afterMelt[i][j]--;
				}
			}
		}
	}
}

void bfs(int x, int y) {
	queue<pair<int, int>> que;
	que.push({ x,y });
	visit[x][y] = true;

	while (!que.empty()) {
		pair<int, int> cur = que.front();
		que.pop();
		cnt++;

		for (int i = 0; i < 4; i++) {
			int newX = cur.first + d[i][0];
			int newY = cur.second + d[i][1];

			if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
			if (visit[newX][newY] == true) continue;
			if (map[newX][newY] == 0) continue;

			visit[newX][newY] = true;
			que.push({ newX,newY });
		}
	}
}

bool isConnect() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (visit[i][j] == false && map[i][j] != 0) return false;
		}
	}
	return true;
}