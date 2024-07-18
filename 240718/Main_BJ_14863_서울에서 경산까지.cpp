#include<iostream>

using namespace std;

int n, k;
pair<int, int> w[101];
pair<int, int> b[101];
int dp[101][100001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= k; j++) {
			dp[i][j] = -1;
		}
	}

	for (int i = 1; i <= n; i++) {
		int walk, w_value, bike, b_value;
		cin >> walk >> w_value >> bike >> b_value;

		w[i] = make_pair(walk, w_value);
		b[i] = make_pair(bike, b_value);
	}

	dp[1][w[1].first] = w[1].second;
	dp[1][b[1].first] = max(dp[1][b[1].first], b[1].second);
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= k; j++) {
			if (j >= w[i].first && dp[i - 1][j - w[i].first] != -1) {
				dp[i][j] = max(dp[i][j], dp[i - 1][j - w[i].first] + w[i].second);
			}
			if (j >= b[i].first && dp[i - 1][j - b[i].first] != -1) {
				dp[i][j] = max(dp[i][j], dp[i - 1][j - b[i].first] + b[i].second);
			}
		}
	}

	int ans = 0;
	for (int i = 0; i <= k; i++) {
		ans = max(ans, dp[n][i]);
	}
	cout << ans;
}