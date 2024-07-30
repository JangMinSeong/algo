#include <iostream>
#include <string>

using namespace std;

string str;
int isPal[2501][2501];
int dp[2501];
int ans = 987654321;

void checkPal(int s, int e);

int main() {
	cin >> str;

	for (int i = 0; i < str.length(); i++) {
		isPal[i][i] = 2;
		dp[i+1] = 987654321;
		for (int j = i + 1; j < str.length(); j++) {
			if (isPal[i][j] == 0) {
				checkPal(i, j);
			}
		}
	}

	for (int i = 1; i <= str.length(); i++) {
		for (int j = 0; j < i; j++) {
			if (isPal[j][i - 1] == 2) {
				dp[i] = min(dp[i], dp[j] + 1);
			}
		}
	}

	cout << dp[str.length()];
}

void checkPal(int s, int e) {
	for (int i = 0; i <= (s + e) / 2 - s; i++) {
		isPal[s + i][e - i] = 1;
		if (str[s + i] != str[e - i]) return;
	}

	for (int i = 0; i <= (s + e) / 2 - s; i++) {
		isPal[s + i][e - i] = 2;
	}
	return;
}