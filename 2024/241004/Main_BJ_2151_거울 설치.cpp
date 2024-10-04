#include<iostream>
#include<queue>

using namespace std;

int inf = 1000000000;
int n;
int map[51][51];
int visit[51][51][2];
int d[4][2] = { {1,0},{-1,0},{0,1},{0,-1} }; //0, 1 세로 , 2, 3 가로
pair<int, int> s, e;

void bfs();

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	s = { -1,-1 };
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			char t;
			cin >> t;

			switch (t) {
			case '*': map[i][j] = -1; break;
			case '#': if (s.first == -1) s = { i,j };
					else e = { i,j };
					map[i][j] = 2; break;
					break;
			case '.': map[i][j] = 0; break;
			case '!': map[i][j] = 1; break;
			}

			visit[i][j][0] = visit[i][j][1] = inf;
		}
	}

	bfs();

	cout << min(visit[e.first][e.second][0], visit[e.first][e.second][1]);

	return 0;
}

void bfs() {
	queue<pair<pair<int, int>, int>> que; //(좌표, 방향)
	que.push({ s,0 });
	que.push({ s,2 });

	visit[s.first][s.second][0] = visit[s.first][s.second][1] = 0;

	while (!que.empty()) {
		pair<int, int> cur = que.front().first;
		int di = que.front().second;
		que.pop();

		for (int i = 0; i < 2; i++) {
			int newX = cur.first + d[di + i][0];
			int newY = cur.second + d[di + i][1];

			if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
			if (map[newX][newY] == -1) continue;

			if (visit[newX][newY][di / 2] > visit[cur.first][cur.second][di / 2]) {
				visit[newX][newY][di / 2] = visit[cur.first][cur.second][di / 2];
				que.push({ {newX,newY }, di });
			}

			if (map[newX][newY] == 1 && visit[newX][newY][(2 - di) / 2] > visit[cur.first][cur.second][di / 2] + 1) {  //! 일 때, 방향 전환
				visit[newX][newY][(2-di)/2] = min(visit[newX][newY][(2-di)/2], visit[cur.first][cur.second][di/2] + 1);
				que.push({ {newX,newY}, 2 - di });
				que.push({ {newX,newY }, di });
			}


		}
	}
}