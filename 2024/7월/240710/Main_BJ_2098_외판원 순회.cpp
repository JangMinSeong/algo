#include<iostream>

using namespace std;

int n;
int w[16][16];
int dp[16][65536];

int dfs(int node, int visit);

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> w[i][j];
		}
	}
	memset(dp, -1, sizeof(dp));

	int ans = dfs(0, 1);
	cout << ans;

}

int dfs(int node, int visit) {
	if (visit == (1<<n) - 1) {
		if (w[node][0] == 0)
			return 999999999;
		return w[node][0];
	}

	if (dp[node][visit] != -1) return dp[node][visit];

	dp[node][visit] = 999999999;
	for (int i = 0; i < n; i++) {
		if (w[node][i] == 0) continue;
		if ((visit & (1 << i)) != 0) continue;
		dp[node][visit] = min(dp[node][visit], w[node][i] + dfs(i,visit | (1 << i)));
	}

	return dp[node][visit];
}