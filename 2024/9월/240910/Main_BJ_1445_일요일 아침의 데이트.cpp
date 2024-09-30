#include<iostream>
#include<queue>

using namespace std;

int n, m;
char map[51][51];
int d[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };
bool visit[51][51];
int value[51][51];
int value2[51][51];
pair<int, int> goal, start;

void bfs();

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];

			value2[i][j] = 100000000;

			if (map[i][j] == 'F') goal = { i,j };
			else if (map[i][j] == 'S') start = { i,j };
			else if (map[i][j] == 'g') {
				value[i][j] = 10000;
				for (int k = 0; k < 4; k++) {
					int newX = i + d[k][0];
					int newY = j + d[k][1];

					if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
					if(value[newX][newY] != 10000) value[newX][newY] = 1;
				}
			}
		}
	}
	value[goal.first][goal.second] = 0;

	bfs();

	cout << value2[goal.first][goal.second] / (10000) << " " << value2[goal.first][goal.second] % (10000) << endl;

	return 0;
}

void bfs() {
	queue<pair<int, int>> que;
	que.push(start);
	value2[start.first][start.second] = 0;

	while (!que.empty()) {
		pair<int, int> node = que.front();
		que.pop();
		visit[node.first][node.second] = true;

		for (int i = 0; i < 4; i++) {
			int newX = node.first + d[i][0];
			int newY = node.second + d[i][1];

			if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
			int newCost = value2[node.first][node.second] + value[newX][newY];

			if (newCost < value2[newX][newY]) {
				value2[newX][newY] = newCost;
				que.push({ newX, newY });
			}
		}
	}
}