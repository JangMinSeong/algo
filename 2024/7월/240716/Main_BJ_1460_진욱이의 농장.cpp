#include<iostream>
#include<queue>

using namespace std;

int n, m;
int map[1001][1001];
int dp[1001][1001];

void sow(int x, int y, int l, int f);
void init(int seed1, int seed2);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;

	for (int i = 1; i <= m; i++) {
		int x, y, l, f;
		cin >> x >> y >> l >> f;
		sow(x+1, y+1, l, f);
	}

	int ans = 0;

	for (int seed1 = 1; seed1 <= 7; seed1++) {
		for (int seed2 = seed1 + 1; seed2 <= 7; seed2++) {
			init(seed1, seed2);

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dp[i][j] != 0) {
						dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
						ans = max(ans, dp[i][j]);
					}
				}
			}
		}
	}

	cout << ans * ans;
}

void sow(int x, int y, int l, int f) {
	for (int i = 0; i < l; i++) {
		for (int j = 0; j < l; j++) {
			map[x + i][y + j] = f;
		}
	}
}

void init(int seed1, int seed2) {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <=n; j++) {
			if (map[i][j] == seed1 || map[i][j] == seed2)
				dp[i][j] = 1;
			else
				dp[i][j] = 0;
		}
	}
}
