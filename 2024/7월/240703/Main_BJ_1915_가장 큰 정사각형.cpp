#include<iostream>

using namespace std;

int n, m;
int map[1001][1001];
int dp[1001][1001];

int main() {
	int max = 0;

	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		string tmp;
		cin >> tmp;
		for (int j = 1; j <= m; j++) {
			map[i][j] = tmp[j-1] - '0';
			if (map[i][j] == 1) {
				dp[i][j] = 1;
				max = 1;
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (dp[i][j] != 0) {
				dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
				if (max < dp[i][j]) max = dp[i][j];
			}
		}
	}

	cout << max * max << endl;

	//for (int i = 1; i <= n; i++) {
	//	for (int j = 1; j <= m; j++) {
	//		cout << dp[i][j] << " ";
	//	}
	//	cout << endl;
	//}

}