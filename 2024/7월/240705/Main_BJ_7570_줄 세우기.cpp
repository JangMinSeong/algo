#include<iostream>

using namespace std;

int n;
int dp[1000001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	int maxNum = 0;
	for (int i = 1; i <= n; i++) {
		int student;
		cin >> student;
		dp[student] = dp[student-1] + 1;
		
		maxNum = max(maxNum, dp[student]);
	}

	//for (int i = 1; i <= n; i++)
	//	cout << dp[i] << " ";
	//cout << endl;

	cout << n - maxNum;

	return 0;
}