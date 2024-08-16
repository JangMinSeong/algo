#include<iostream>
#include<algorithm>

using namespace std;

int n;
pair<int, int> line[101];
int dp[101];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		line[i] = make_pair(a, b);
	}
	sort(line, line + n);

	int maxValue = 0;
	for (int i = 0; i < n; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (line[j].second < line[i].second) {
				dp[i] = max(dp[i], dp[j] + 1);
				if (dp[i] > maxValue) maxValue = dp[i];
			}
		}
	}

	cout << n - maxValue;

}