#include<iostream>

using namespace std;

int n;
int dp[31];

int main() {
	cin >> n;
	if (n % 2 == 1) {
		cout << 0;
		return 0;
	}

	dp[0] = 1;
	dp[2] = 3;
	
	for (int i = 4; i <= n; i += 2) {
		dp[i] = 3 * dp[i - 2];
		for (int j = 4; j <= i; j += 2) {
			dp[i] += 2 * dp[i - j];
		}
	}

	cout << dp[n];
}