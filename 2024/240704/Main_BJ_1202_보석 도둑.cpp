#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;

int n, k;
vector<pair<int, int>> jewel;
vector<int> bag;

priority_queue<int, vector<int>, less<int>> pq;

long long ans;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;

	for (int i = 0; i < n; i++) {
		int m, v;
		cin >> m >> v;
		jewel.push_back(make_pair(m, v));
	}
	for (int i = 0; i < k; i++) {
		int m;
		cin >> m;
		bag.push_back(m);
	}

	sort(jewel.begin(), jewel.end());
	sort(bag.begin(), bag.end());

	int idx = 0;
	for (int i = 0; i < k; i++) {
		while (1) {
			if (idx < n && jewel[idx].first <= bag[i]) {
				pq.push(jewel[idx].second);
				idx++;
			}
			else
				break;
		}
		ans += pq.top();
		pq.pop();
	}

	cout << ans << endl;

	return 0;
}