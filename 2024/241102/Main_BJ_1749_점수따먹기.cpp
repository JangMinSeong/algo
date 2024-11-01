#include<iostream>

using namespace std;

int n, m;
int mat[201][201];
int dp[201][201];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> mat[i][j];
			dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + mat[i][j];
		}
	}
	
	int ans = -999999999;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			for (int k = i; k <= n; k++) {
				for (int l = j; l <= m; l++) {
					int sum = dp[k][l] - dp[k][j - 1] - dp[i - 1][l] + dp[i - 1][j - 1];
					if (ans < sum) ans = sum;
				}
			}
		}
	}

	cout << ans;

	return 0;
}