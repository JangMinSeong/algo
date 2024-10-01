#include<iostream>

using namespace std;

unsigned long long int n, m;
unsigned long long int t[100001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> t[i];
	}

	unsigned long long int left = 0, right = m * t[0];
	unsigned long long int ans = right + 1;
	while (left <= right) {
		unsigned long long int cnt = 0;
		unsigned long long int mid = (left + right) / 2;

		for (int i = 0; i < n; i++) 
			cnt += mid / t[i];
		
		if (cnt >= m) {
			if (ans > mid) ans = mid;
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}
	}


	cout << ans;
	return 0;
}