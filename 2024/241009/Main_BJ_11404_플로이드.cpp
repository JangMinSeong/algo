#include<iostream>

using namespace std;

int n, m;
long long int inf = 2000000000000;
long long int adj[101][101];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= n; j++) {
			adj[i][j] = inf;
			if (i == j) adj[i][j] = 0;
		}
	}

	for (int i = 0; i < m; i++) {
		int from, to, weight;
		cin >> from >> to >> weight;
		adj[from][to] = min(adj[from][to], weight);
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			for (int k = 1; k <= n; k++) {
				adj[j][k] = min(adj[j][k], adj[j][i] + adj[i][k]);
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (adj[i][j] >= inf) adj[i][j] = 0;
			cout << adj[i][j] << " ";
		}
		cout << endl;
	}

	return 0;
}