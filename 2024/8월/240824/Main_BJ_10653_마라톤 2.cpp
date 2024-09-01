#include<iostream>
#include<vector>

#define INF 999999999

using namespace std;

int n, k;
vector<pair<int,int>> pos;
int dp[501][501];

int dfs(int idx, int cnt);
int calDis(pair<int, int> a, pair<int, int> b);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(); cout.tie();

	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int x, y;
		cin >> x >> y;
		
		pos.push_back({ x,y });
	}
	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= k; j++) {
			dp[i][j] = INF;
		}
	}

	cout << dfs(0, 0);

	return 0;
}

int calDis(pair<int, int> a, pair<int, int> b) {
	return abs(a.first - b.first) + abs(a.second - b.second);
}

int dfs(int idx, int cnt) {
	if (idx == n - 1) return 0;
	if (dp[idx][cnt] != INF) return dp[idx][cnt];

	for (int i = cnt; i <= k; i++) {
		if(idx + i - cnt + 1 < n) dp[idx][cnt] = min(dp[idx][cnt], dfs(idx + i - cnt + 1, i) + calDis(pos[idx], pos[idx + i - cnt + 1]));
	}

	return dp[idx][cnt];
}