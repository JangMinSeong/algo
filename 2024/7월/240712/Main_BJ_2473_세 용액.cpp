#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<long long> ph;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		long long t;
		cin >> t;
		ph.push_back(t);
	}

	sort(ph.begin(), ph.end());

	long long ans = 10000000000;
	int ans_arr[3] = { 0, };

	for (int i = 0; i < n-2; i++) {
		for (int idx1 = i + 1, idx2 = n - 1; idx1 < idx2;) {
			long long value = ph[i] + ph[idx1] + ph[idx2];

			if (ans > abs(value)) {
				ans = abs(value);
				ans_arr[0] = ph[i];
				ans_arr[1] = ph[idx1];
				ans_arr[2] = ph[idx2];
			}

			if (value < 0) idx1++;
			else idx2--;
		}
		if (ph[i] + ph[i+1] + ph[i+2] > ans) break;
	}

	cout << ans_arr[0] << " " << ans_arr[1] << " " << ans_arr[2] << endl;
	
	return 0;
}