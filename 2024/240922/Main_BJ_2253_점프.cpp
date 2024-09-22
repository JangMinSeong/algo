#include<iostream>
#include<vector>
#include<cstring>

using namespace std;

int n, m;
int dp[10001][501]; 
bool isSmall[10001] = { false, };

int jump(int idx, int dis);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	memset(dp, -1, sizeof(dp));

	for (int i = 0; i < m; i++) {
		int num;
		cin >> num;
		isSmall[num] = true;
	}

	int ans = jump(2, 1) + 1;

	if (ans >= 1000000) cout << -1;
	else cout << ans;
}

int jump(int idx, int dis) {
	if (idx == n) return 0;
	if (idx > n || isSmall[idx] == true) return 1000000;
	if (dp[idx][dis] != -1) return dp[idx][dis];
	
	dp[idx][dis] = 1000000;
	if(dis - 1 > 0) dp[idx][dis] = min(dp[idx][dis], jump(idx + dis - 1, dis - 1) + 1);
	if(dis > 0) dp[idx][dis] = min(dp[idx][dis], jump(idx + dis, dis) + 1);
	dp[idx][dis] = min(dp[idx][dis], jump(idx + dis + 1, dis + 1) + 1);

	return dp[idx][dis];
}