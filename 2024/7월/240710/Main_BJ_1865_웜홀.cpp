#include <iostream>
#include <cstring>

#define INF 999999999

using namespace std;

int n, m, w;
int matrix[501][501];
int dist[501][501];

bool findCycle();

int main() {
	int t;
	cin >> t;

	for (int tc = 0; tc < t; tc++) {
		cin >> n >> m >> w;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				matrix[i][j] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			int from, to, cost;
			cin >> from >> to >> cost;
			matrix[from][to] = min(matrix[from][to], cost);
			matrix[to][from] = min(matrix[to][from], cost);
		}

		for (int i = 0; i < w; i++) {
			int from, to, cost;
			cin >> from >> to >> cost;
			matrix[from][to] = min(matrix[from][to], -cost);
		}


		if (findCycle() == true) cout << "YES" << endl;
		else cout << "NO" << endl;
	}
}

bool findCycle() {
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			if (k == i) continue;

			for (int j = 1; j <= n; j++) {
				if (k == j) continue;

				matrix[i][j] = min(matrix[i][j], matrix[i][k] + matrix[k][j]);
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		if (matrix[i][i] < 0) return true;
	}
	return false;
}