#include<iostream>
#include <string>

using namespace std;

string str1, str2;
int dp[4001][4001];

int main() {
	cin >> str1 >> str2;

	int ans = 0;
	for (int i = 1; i <= str1.length(); i++) {
		for (int j = 1; j <= str2.length(); j++) {
			if (str1[i - 1] == str2[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
			if (ans < dp[i][j]) ans = dp[i][j];
		}
	}

	cout << ans << endl;
}