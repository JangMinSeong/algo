#include<iostream>
#include<cstring>
#include<set>

using namespace std;

int n, m;
int map[1001][1001];
int mem[1001][1001];
int group[250001];
int d[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };

int dfs(int x, int y, int depth, int g);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}
	memset(mem, -1, sizeof(mem));

	int cnt = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 1 && mem[i][j] == -1) {
				group[cnt] = dfs(i, j, 1, cnt);
				cnt++;
			}
		}
	}
	
	int ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) {
				set<int> s;
				int sum = 1;
				for (int k = 0; k < 4; k++) {
					int newX = i + d[k][0];
					int newY = j + d[k][1];

					if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
					if (map[newX][newY] == 0) continue;
					if (!s.empty() && s.find(mem[newX][newY]) != s.end()) continue;

					sum += group[mem[newX][newY]];
					s.insert(mem[newX][newY]);
				}
				if (ans < sum) ans = sum;
			}
		}
	}
	
	cout << ans;

	return 0;
}

int dfs(int x, int y, int depth, int g) {
	int cnt = 1;
	mem[x][y] = g;
	for (int i = 0; i < 4; i++) {
		int newX = x + d[i][0];
		int newY = y + d[i][1];

		if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
		if (mem[newX][newY] != -1) continue;
		if (map[newX][newY] == 0) continue;
		
		cnt += dfs(newX, newY, depth + 1,g);
	}
	
	return cnt;
}