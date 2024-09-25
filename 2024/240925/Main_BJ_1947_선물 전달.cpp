#include <iostream>

using namespace std;

int n;
long long int dp[1000001];

int main() {
	cin >> n;
	dp[2] = 1;

	for (int i = 3; i <= n; i++) {
		dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % 1000000000;
	}

	cout << dp[n];
}