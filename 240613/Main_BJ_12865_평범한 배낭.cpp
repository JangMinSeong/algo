#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n, k;
int ans = 0;
vector<pair<int, int>> things;

int dp[101][100001];


int main() {
	cin >> n >> k;

	for (int i = 0; i < n; i++) {
		int w, v;
		cin >> w >> v;

		things.push_back(make_pair(w, v));
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= k; j++) {
			if (things[i-1].first > j) {
				dp[i][j] = dp[i - 1][j];
				continue;
			}

			dp[i][j] = max(dp[i - 1][j], dp[i-1][j - things[i - 1].first] + things[i - 1].second);
		}
	}

	cout << dp[n][k] << endl;
}