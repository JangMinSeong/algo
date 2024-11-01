#include<iostream>
#include<queue>
#include<algorithm>

using namespace std;

int dp[501][501][501];

int dfs(int a, int b, int c);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int a, b, c;
	cin >> a >> b >> c;

	if ((a + b + c) % 3 != 0) {
		cout << 0;
		return 0;
	}

	int result = dfs(a, b, c);
	cout << ((result == 2) ? 1 : 0);

	return 0;
}

int dfs(int a, int b, int c) {
	if (dp[a][b][c] != 0) return dp[a][b][c];
	if (a == b && b == c) return 2;

	dp[a][b][c] = 1;

	//a , b
	if (a != b) {
		int nums[3];
		int x = a > b ? b + b : a + a;
		int y = a > b ? a - b : b - a;
		nums[0] = x;
		nums[1] = y;
		nums[2] = c;
		sort(nums, nums + 3);
		dp[a][b][c] = max(dp[a][b][c], dfs(nums[0], nums[1], nums[2]));
	}
	if (b != c && dp[a][b][c] == 1) {
		int nums[3];
		int x = b > c ? c + c : b + b;
		int y = b > c ? b - c : c - b;
		nums[0] = a;
		nums[1] = x;
		nums[2] = y;
		sort(nums, nums + 3);
		dp[a][b][c] = max(dp[a][b][c], dfs(nums[0], nums[1], nums[2]));
	}
	if (c != a && dp[a][b][c] == 1) {
		int nums[3];
		int x = c > a ? a + a : c + c;
		int y = c > a ? c - a : a - c;
		nums[0] = x;
		nums[1] = b;
		nums[2] = y;
		sort(nums, nums + 3);
		dp[a][b][c] = max(dp[a][b][c], dfs(nums[0], nums[1], nums[2]));
	}

	return dp[a][b][c];
}