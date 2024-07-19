#include<iostream>
#include<vector>

using namespace std;

int h, w;
vector<int> height;
vector<vector<int>> map;

int main() {
	cin >> h >> w;
	
	for (int i = 0; i < h; i++) {
		vector<int> tmp;
		for (int j = 0; j < w; j++) {
			tmp.push_back(0);
		}
		map.push_back(tmp);
	}

	for (int i = 0; i < w; i++) {
		int tmp;
		cin >> tmp;
		height.push_back(tmp);
	}

	int ans = 0;

	for (int i = h-1; i >= 0; i--) {
		int cnt = 0;
		vector<int> idx;
		for (int j = 0; j < w; j++) {
			if (height[j] >= i + 1) { 
				idx.push_back(j);
			}
		}
		if (idx.size() >= 2) {
			int init = idx[0];
			for (int j = 1; j < idx.size(); j++) {
				cnt += idx[j] - init - 1;
				init = idx[j];
			}
		}
		ans += cnt;
	}

	cout << ans;

	return 0;
}