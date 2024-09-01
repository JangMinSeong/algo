#include<iostream>

using namespace std;

int n;
int before[1001];
int after[1001];
int diff[1001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> before[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> after[i];

		diff[i] = before[i] - after[i];
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		int idx = i;
		int minDiff = abs(diff[i]);
		for (int j = i + 1; j < n; j++) {
			if (diff[i] * diff[j] > 0) {
				if (minDiff > abs(diff[j])) {
					minDiff = abs(diff[j]);
				}
				idx = j;
			}
			else break;
		}
		ans += minDiff;
		for (int j = i; j <= idx; j++) {
			if (diff[j] > 0) diff[j] -= minDiff;
			else diff[j] += minDiff;
		}
		if (diff[i] != 0) i--;
	}

	cout << ans;

	return 0;
}