#include<iostream>
#include<vector>
#include<cstdio>

using namespace std;

vector<pair<int, int>> player;
int dp[1001][16][16];

int solve(int idx, int cntW, int cntB);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (1) {
		int w, b;
		cin >> w >> b;
		if (cin.eof()) break;
		player.push_back({ w,b });
	}
	memset(dp, -1, sizeof(dp));
	solve(0, 0, 0);

	cout << dp[0][0][0] << endl;
}

int solve(int idx, int cntW, int cntB) {
	if (idx >= player.size()) return 0;
	if (dp[idx][cntW][cntB] != -1) return dp[idx][cntW][cntB];

	if(cntW < 15) dp[idx][cntW][cntB] = max(dp[idx][cntW][cntB], player[idx].first  + solve(idx + 1, cntW + 1, cntB));  //¹é
	if(cntB < 15) dp[idx][cntW][cntB] = max(dp[idx][cntW][cntB], player[idx].second + solve(idx + 1, cntW, cntB + 1));  //Èæ
	dp[idx][cntW][cntB] = max(dp[idx][cntW][cntB], solve(idx + 1, cntW, cntB));                                         //Á¦¿Ü

	return dp[idx][cntW][cntB];
}