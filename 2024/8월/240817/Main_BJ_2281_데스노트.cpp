#include<iostream>

using namespace std;

int n, m;
int name[1001];
int dp[1001][1001];

int solve(int idx, int len);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> name[i];
	}

	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= m; j++) {
			dp[i][j] = -1;
		}
	}

	cout << solve(0, 0);
}

int solve(int idx, int len) {  //len 만큼 쓰고, idx 써야할 때
	if (idx == n) return 0;  
	if (dp[idx][len] != -1) return dp[idx][len]; 

	dp[idx][len] = (m - len) * (m - len) + solve(idx + 1, name[idx]);  //다음 줄

	if (idx == 0) { //첫 이름은 +1 없음
		dp[idx][len] = min(dp[idx][len], solve(idx + 1, len + name[idx])); 
	}
	else if (len + name[idx] + 1 <= m)  //옆으로 작성 가능할 때
		dp[idx][len] = min(dp[idx][len], solve(idx + 1, len + name[idx] + 1)); //옆으로

	return dp[idx][len];
}