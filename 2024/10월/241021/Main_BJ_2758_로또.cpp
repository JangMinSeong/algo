#include<iostream>
#include<cmath>

using namespace std;

int n, m;
long long int dp[11][2001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	for (int i = 1; i <= 2000; i++) {
		dp[1][i] = 1;
		for (int j = 2; j <= 10; j++) {
			if (i < pow(2, j - 1)) break;
			for (int k = 1; k <= i / 2; k++)
				dp[j][i] += dp[j - 1][k];
		}
	}

	int t;
	cin >> t;
	for (int test_case = 0; test_case < t; test_case++) {
		cin >> n >> m;
		long long int sum = 0;
		for (int i = 1; i <= m; i++)
			sum += dp[n][i];
		cout << sum << endl;
	}

	return 0;
}