#include<iostream>
#include<algorithm>

using namespace std;

int n, m, l;
int pos[51];

bool check(int distance);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m >> l;
	for (int i = 0; i < n; i++) {
		cin >> pos[i];
	}
	sort(pos, pos + n);

	int left = 1, right = l;
	int ans = 0;
	while (left <= right) {
		int mid = (left + right) / 2;

		if (check(mid)) {
			left = mid + 1;
		}
		else {
			right = mid - 1;	
		}
	}

	cout << left;

	return 0;
}

bool check(int distance) {
	int cnt = 0;
	int prev = 0;
	for (int i = 0; i < n; i++) {
		int gap = pos[i] - prev;
		cnt += gap / distance;
		if (gap % distance == 0) cnt--;
		prev = pos[i];
	}

	int gap = l - prev;
	if (gap >= distance) {
		cnt += (gap / distance);
		if (gap % distance == 0) cnt--;
	}

	return cnt > m;
}