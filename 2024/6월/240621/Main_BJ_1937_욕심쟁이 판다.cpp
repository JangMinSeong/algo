#include<iostream>

using namespace std;

int n;
int map[500][500];
int visit[500][500];
int d[4][2] = { {1,0},{0,1},{-1,0},{0,-1} };

int dfs(int x, int y);

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			visit[i][j] = -1;
		}
	}

	int ans = 0;
	int max = 0;
	for (int i = 0; i < n; i++) {   
		for (int j = 0; j < n; j++) {
			if (visit[i][j] != -1) continue;
			max = dfs(i, j); 
			if (max > ans) ans = max;
		}
	}
	cout << ans << endl;
}

int dfs(int x, int y) {
	if (visit[x][y] != -1) return visit[x][y];

	visit[x][y] = 1;

	for (int i = 0; i < 4; i++) {
		int newX = x + d[i][0];
		int newY = y + d[i][1];

		if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;  //범위 밖
		if (map[x][y] >= map[newX][newY]) continue;   //못감

		visit[x][y] = max(dfs(newX, newY) + 1, visit[x][y]); //갈수있는곳 한칸씩
	}

	return visit[x][y];
}