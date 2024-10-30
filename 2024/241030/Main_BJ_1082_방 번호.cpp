#include<iostream>
#include<string>
#include<algorithm>
#include<vector>

using namespace std;

int n;
vector<pair<int,int>> cost;
int money;
vector<int> ans;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		cost.push_back({ num,i });
	}
	sort(cost.begin(), cost.end());
	cin >> money;

	if (n == 1) {
		cout << 0;
		return 0;
	}

	if (cost[0].second == 0) {
		if (cost[1].first <= money) {
			money -= cost[1].first;
			ans.push_back(1);
		}
		else {
			cout << 0;
			return 0;
		}
	}
	while (money >= cost[0].first) {
		ans.push_back(0);
		money -= cost[0].first;
	}

	int idx = 0;
	while (idx < ans.size()) {
		int maxNum = 0;
		int changeCost = 0;
		bool ch = false;
		for (int i = 0; i < n; i++) {
			if (money >= cost[i].first - cost[ans[idx]].first && cost[i].first >= cost[ans[idx]].first) {
				if (cost[maxNum].second < cost[i].second) {
					maxNum = i;
					changeCost = cost[i].first - cost[ans[idx]].first;
					ch = true;
				}
			}
		}
		if (ch == false) break;

		money -= changeCost;
		ans[idx] = maxNum;
		idx++;
	}

	for(int i=0;i<ans.size();i++)
		cout << cost[ans[i]].second;

	return 0;
}