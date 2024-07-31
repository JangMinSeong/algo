#include<iostream>

using namespace std;

int n;
long long dp[1516][3];

int main() {
	cin >> n;

	dp[1][1] = 1;

	for (int i = 2; i <= n; i++) {
		dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1000000007;
		dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 1000000007;
		dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 1000000007;
	}

	cout << dp[n][0] << endl;
}