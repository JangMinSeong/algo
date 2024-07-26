#include <iostream>

using namespace std;

int n;
int cards[1000];
int dp[1000][1000];

int dfs(int left, int right, int turn);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int test_case;
	cin >> test_case;
	for (int tc = 0; tc < test_case; tc++) {
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> cards[i];
		}	

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}

		dfs(0, n - 1, 0);
		cout << dp[0][n - 1] << endl;
	}
}

int dfs(int left, int right, int turn) {
	if (left > right) return 0;
	if (dp[left][right] != -1) return dp[left][right];

	if (turn == 0) dp[left][right] = max(cards[left] + dfs(left + 1, right , 1), cards[right] + dfs(left, right - 1, 1));
	else dp[left][right] = min(dfs(left+1, right, 0), dfs(left, right-1, 0));

	return dp[left][right];
}