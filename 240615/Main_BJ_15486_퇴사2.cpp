#include<iostream>
#include<vector>

using namespace std;

int n;
vector<pair<int, int>> counsel;
int dp[1500052];

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);

	cin >> n;
	
	for (int i = 0; i < n; i++) {
		int t, p;
		cin >> t >> p;

		counsel.push_back(make_pair(t, p));
	}
	counsel.push_back(make_pair(0, 0));

	for (int i = 1; i <= n+1; i++) {
		dp[i] = max(dp[i], dp[i - 1]);
		dp[i + (counsel[i - 1].first)] = max(dp[i + (counsel[i - 1].first)], dp[i] + counsel[i - 1].second);
	}


	cout << dp[n+1] << endl;
}