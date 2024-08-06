#include<iostream>
#include<vector>
#include<algorithm>
#include<string>

using namespace std;

int n, m, k;
vector<int> pos;
string ans = "";

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m >> k;
	
	for (int i = 0; i < k; i++) {
		int num;
		cin >> num;
		pos.push_back(num);
		ans += "0";
	}
	int start = 0, end = n;
	int maxGap = 1;
	while (start <= end) {
		int mid = (start + end) / 2;

		int prev = pos[0];
		int cnt = 1;
		for (int i = 1; i < k; i++) {
			if (pos[i] - prev >= mid) {
				prev = pos[i];
				cnt++;
			}
		}

		if (cnt >= m) {
			start = mid + 1;
			maxGap = mid;
		}
		else end = mid - 1;
	}

	ans[0] = '1';
	int prev = pos[0];
	int cnt = 1;
	for (int i = 1; i < k; i++) {
		if (cnt >= m) break;
		if (pos[i] - prev >= maxGap) {
			ans[i] = '1';
			cnt++;
			prev = pos[i];
		}
	}

    cout << ans;
    return 0;
}