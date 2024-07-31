#include<iostream>

using namespace std;

int n;
int matrix[501][2];
int dp[501][501][3];

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> matrix[i][0] >> matrix[i][1];
		dp[i][i][0] = matrix[i][0];
		dp[i][i][1] = matrix[i][1];
		dp[i][i][2] = 0;
	}

	for (int i = 1; i < n; i++) {
		for (int j = i; j < n; j++) {
			int x = j - i;
			int y = j;
			cout << x << ", " << y << endl;
			int min[3] = { 0,0, 2147483647 };
			for (int k = 0; k < y-x; k++) {
				int value = dp[x][x+k][2] + dp[x + k + 1][y][2] + (dp[x][x+k][0] * dp[x][x+k][1] * dp[x + k + 1][y][1]);
				if (min[2] > value) {
					min[0] = dp[x][x+k][0];
					min[1] = dp[x + k + 1][y][1];
					min[2] = value;
				}
			}

			dp[x][y][0] = min[0];
			dp[x][y][1] = min[1];
			dp[x][y][2] = min[2];
		}
	}

	cout << dp[0][n - 1][2] << endl;

	return 0;
}