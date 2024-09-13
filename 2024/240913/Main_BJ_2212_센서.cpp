#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n, k;
vector<int> sensors;
vector<int> gap;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;
	sensors.resize(n);
	for (int i = 0; i < n; i++) {
		cin >> sensors[i];
	}
	sort(sensors.begin(), sensors.end());

	for (int i = 1; i < n; i++) {
		gap.push_back(sensors[i] - sensors[i - 1]);
	}
	sort(gap.begin(), gap.end());

	int ans = 0;
	for (int i = 0; i < n - k; i++) {
		ans += gap[i];
	}
	cout << ans;
}