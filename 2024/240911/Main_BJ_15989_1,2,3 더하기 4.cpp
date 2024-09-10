#include<iostream>

using namespace std;

int t, n;
int dp[10001];

int main() {

	for (int i = 0; i <= 10000; i++) dp[i] = 1;
	for (int i = 2; i <= 10000; i++) dp[i] += dp[i - 2];
	for (int i = 3; i <= 10000; i++) dp[i] += dp[i - 3];

	cin >> t;
	for (int test_case = 0; test_case < t; test_case++) {
		cin >> n;
		cout << dp[n] << endl;
	}
}