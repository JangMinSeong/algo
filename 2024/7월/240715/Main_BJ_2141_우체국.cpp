#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int n;
vector<pair<int, int>> xa;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	
	long long totalP = 0;
	for (int i = 0; i < n; i++) {
		int x, a;
		cin >> x >> a;
		xa.push_back(make_pair(x, a));
		totalP += a;
	}

	sort(xa.begin(), xa.end());

	long long sumP = 0;
	for (int i = 0; i < xa.size(); i++) {
		sumP += xa[i].second;
		if (sumP >= (totalP + 1) / 2) {
			cout << xa[i].first << endl;
			break;
		}
	}
}