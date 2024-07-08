#include<iostream>

using namespace std;

int n, m;
int c[101];
int m_i[101];
int dp[101][10001];
int totalC;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 1; i <= n; i++)
		cin >> m_i[i];
	for (int i = 1; i <= n; i++) {
		cin >> c[i];
		totalC += c[i];
	}
	

	for (int i = 1; i <=n; i++) {
		for (int j = 0; j <= totalC; j++) {
			if (c[i] > j) dp[i][j] = dp[i - 1][j];
			else
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - c[i]] + m_i[i]);
		}
	}

	int ans = totalC + 1;
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= totalC; j++) {
			if (dp[i][j] >= m && ans > j) {
				ans = j;
			}
		}
	}

	cout << ans;
}