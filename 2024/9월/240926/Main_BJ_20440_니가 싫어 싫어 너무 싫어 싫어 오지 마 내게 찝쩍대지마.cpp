#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int n;
vector<pair<int, int>> input;
vector<int> vec;
int pos[2000002];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int start, end;
		cin >> start >> end;

		input.push_back({ start,end });

		vec.push_back(start);
		vec.push_back(end);
	}
	sort(vec.begin(), vec.end());
	vec.erase(unique(vec.begin(), vec.end()), vec.end());

	for (int i = 0; i < n; i++) {
		pos[lower_bound(vec.begin(), vec.end(), input[i].first) - vec.begin()]++;
		pos[lower_bound(vec.begin(), vec.end(), input[i].second) - vec.begin()]--;
	}

	int cnt = 0;
	int now = 0;
	for (int i = 0; i < 2000001; i++) {
		now += pos[i];
		pos[i] = now;
		if (cnt < now) {
			cnt = now;
		}
	}

	int s = -1, e = -1;
	for (int i = 0; i < 2000001; i++) {
		if (pos[i] == cnt && s == -1) {
			s = i;
			int idx = i;
			while (pos[idx] == cnt) idx++;
			e = idx;
			break;
		} 
	}

	cout << cnt << endl;
	cout << vec[s] << " " << vec[e];

	return 0;
}