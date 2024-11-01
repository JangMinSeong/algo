#include<iostream>
#include<set>
#include<cstring>

using namespace std;

int t, w;
int fruit[1001];
int dp[1001][31][3];
set<int> s;

int dfs(int time, int move, int pos);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> t >> w;
	for (int i = 0; i < t; i++) {
		cin >> fruit[i];
	}
	memset(dp, -1, sizeof(dp));

	cout << dfs(0, 0, 1);

	return 0;
}

int dfs(int time, int move, int pos) {
	if (dp[time][move][pos] != -1) return dp[time][move][pos];
	if (move > w || time >= t) return 0;

	if (fruit[time] == pos) {
		dp[time][move][pos] = max(dp[time][move][pos], dfs(time + 1, move, pos) + 1);
	}
	else {
		if(move != w) dp[time][move][pos] = max(dp[time][move][pos], dfs(time + 1, move + 1, fruit[time]) + 1);
		dp[time][move][pos] = max(dp[time][move][pos], dfs(time + 1, move, pos));
	}

	return dp[time][move][pos];
}