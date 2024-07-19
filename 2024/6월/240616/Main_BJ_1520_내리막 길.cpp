#include<iostream>
#include<vector>

using namespace std;

int n, m;
int d[4][2] = { {1,0},{0,1},{-1,0},{0,-1} };

int map[500][500];
int visit[500][500];

void printVisit();
int dfs(int x, int y);

int main() {
	cin >> n >> m;
		
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			visit[i][j] = -1;
		}
	}
	visit[n - 1][m - 1] = 1;

	cout << dfs(0, 0) << endl;
	printVisit();
}

void printVisit() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << visit[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
}

int dfs(int x, int y) {
	if (visit[x][y] != -1) {
		return visit[x][y];
	}
	visit[x][y] = 0;
	for (int i = 0; i < 4; i++) {
		int newX = x + d[i][0];
		int newY = y + d[i][1];

		if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
		if (map[x][y] <= map[newX][newY]) continue;

		visit[x][y] += dfs(newX,newY);
	}
	return visit[x][y];
}