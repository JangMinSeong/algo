#include<iostream>
#include<cstring>

using namespace std;

int n;
int stu[201];
int dp[201];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> stu[i];
		dp[i] = 1;
	}

	int maxNum = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = i; j >= 1; j--) {
			if (stu[i] > stu[j]) {
				dp[i] = max(dp[i], dp[j] + 1);
				maxNum = max(maxNum, dp[i]);
			}
		}
	}

	cout << n - maxNum;

	return 0;
}