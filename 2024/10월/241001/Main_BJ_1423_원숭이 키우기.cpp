#include<iostream>
#include<cstring>

using namespace std;

int n;
int c[51];
int st[51];
int day;
long long int dp[51][101][101];

long long int solve(int level, int cnt, int remain);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);


	long long int initSt = 0;
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> c[i];
	for (int i = 0; i < n; i++) 
		cin >> st[i];
	cin >> day;

	memset(dp, -1, sizeof(dp));

	cout << solve(0, 0, day);

	return 0;
}

long long int solve(int level, int cnt, int remain) {  //현재 level, cnt만큼 레벨업, remain 만큼 남은 기간
	if (remain < 0 || level >= n) return 0;
	if (dp[level][cnt][remain] != -1) return dp[level][cnt][remain];

	dp[level][cnt][remain] = 0;

	for (int i = 0; i <= c[level] + cnt; i++) {
		if (remain - i < 0) break;
		dp[level][cnt][remain] = max(dp[level][cnt][remain], solve(level + 1, i, remain - i) + ((long long int)(st[level]) * (c[level] + cnt - i)));
	}

	return dp[level][cnt][remain];
}