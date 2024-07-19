#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n;
vector<pair<pair<int, int>, pair<int, int>>> flower;
int ans = 0;

pair<int, int> curDay;
pair<int, int> maxEnd;

int main() {
	cin >> n;

	curDay = make_pair(3, 1);

	for (int i = 0; i < n; i++) {
		int startMon, startDay;
		cin >> startMon >> startDay;
		int endMon, endDay;
		cin >> endMon >> endDay;

		if (endMon <= 2) {
			continue;
		}
		if (startMon >= 12) {
			continue;
		}
		flower.push_back(make_pair(make_pair(startMon, startDay), make_pair(endMon, endDay)));
	}
	sort(flower.begin(), flower.end());
	
	int idx = 0;
	while (1) {
		int i;
		maxEnd = make_pair(0, 0);
		for (i = idx; i < flower.size(); i++) {
			if (curDay > flower[i].second) {
				idx = i;
				continue;
			}

			if (curDay >= flower[i].first) {
				if (maxEnd < flower[i].second) {
					maxEnd = flower[i].second;
				}
			}
			else break;
		}
		if (maxEnd == make_pair(0, 0) || maxEnd == curDay) {
			ans = 0;
			break;
		}
		curDay = maxEnd;
		ans++;

		if (curDay >= make_pair(12, 1)) break;
	}

	cout << ans << endl;
}