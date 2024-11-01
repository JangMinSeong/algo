#include<iostream>
#include<algorithm>
#include<cstring>

using namespace std;

int n;
int dp[3001][2];
int nums[3001];
int inf = 1000000000;

int play(int t, int turn);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int tc = 0; tc < 3; tc++) {
		dp[0][0] = dp[0][1] = inf;

		for (int i = 1; i <= n; i++) {
			cin >> nums[i];
			dp[i][0] = inf;
			dp[i][1] = inf;
		}

		int result = play(n , 1);

		if (result > 0) cout << "B" << endl;
		else if (result < 0) cout << "A" << endl;
		else cout << "D" << endl;
	}

	return 0;
}


int play(int pos, int turn) {
	if (dp[pos][turn] != inf) return dp[pos][turn];
	if (pos == 0) return 0;

	if (turn == 1) {
		dp[pos][turn] = inf;
		dp[pos][turn] = min(dp[pos][turn], nums[pos] + play(pos - 1, 1 - turn));
		dp[pos][turn] = min(dp[pos][turn], nums[pos] + play(pos - 1, turn)); //¿¬¼Ó »Ì±â
	}
	else {
		dp[pos][turn] = -inf;
		dp[pos][turn] = max(dp[pos][turn], -nums[pos] + play(pos - 1, 1 - turn));
		dp[pos][turn] = max(dp[pos][turn], -nums[pos] + play(pos - 1, turn)); //¿¬¼Ó »Ì±â
	}

	return dp[pos][turn];
}