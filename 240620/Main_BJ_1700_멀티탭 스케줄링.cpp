#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int n, k;
int ans;
int nums[101];
vector<int> plug[101];
vector<int> multitap;

int main() {
	cin >> n >> k;

	for (int i = 0; i < k; i++) {
		cin >> nums[i];
		plug[nums[i]].push_back(i);
	}

	for (int i = 0; i < k; i++) {
		int ch = 0;
		for (int j = 0; j < multitap.size(); j++) {
			if (multitap[j] == nums[i]) {
				ch = 1;
				break;
			}
		}
		if (ch == 1) continue;

		if (multitap.size() < n) {
			multitap.push_back(nums[i]);
			continue;
		}

		int maxDay = 0;
		int maxIdx = 0;
		for (int j = 0; j < n; j++) {
			int idx = -1;
			for (int k = 0; k < plug[multitap[j]].size(); k++) {
				if (plug[multitap[j]][k] >= i) {
					idx = k;
					break;
				}
			}

			if (idx != -1 && maxDay < plug[multitap[j]][idx]) {
				maxIdx = j;
				maxDay = plug[multitap[j]][idx];
			}
			else if (idx == -1) {
				maxIdx = j;
				break;
			}
		}

		if (ch == 0) {
			multitap[maxIdx] = nums[i];
			ans++;
		}
	}

	cout << ans << endl;
}