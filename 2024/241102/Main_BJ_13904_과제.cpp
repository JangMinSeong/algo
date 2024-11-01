#include<iostream>
#include<algorithm>

using namespace std;

int n;
pair<int, int> hw[1001];
int dp[1001][1001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 1; i <= n; i++) {
		int d, w;
		cin >> d >> w;
		hw[i] = { d,w };
	}
	sort(hw + 1, hw + n + 1);

	int ans = 0;
	for (int time = 1; time <= 1000; time++) {
		for(int i = 1; i <= n; i++) {
			if (time > hw[i].first) continue;
			
			for(int j = i; j >= 1; j--)
				dp[time][i] = max(dp[time][i], dp[time - 1][i - j] + hw[i].second);

			if (ans < dp[time][i]) ans = dp[time][i];
		}
		if (time > hw[n].first) break;
	}
	cout << ans;

	return 0;
}