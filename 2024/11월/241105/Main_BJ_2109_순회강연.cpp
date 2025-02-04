#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std;

int n;
vector<pair<int, int>> vec;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;


	for (int i = 0; i < n; i++) {
		int p, d;
		cin >> p >> d;
		vec.push_back({ d,p });
	}
	sort(vec.begin(), vec.end());

	int money = 0;

	for (int i = 0; i < n; i++) {
		pq.push(vec[i].second);
		money += vec[i].second;

		if (pq.size() > vec[i].first) {
			money -= pq.top();
			pq.pop();
		}
	}


	cout << money;

	return 0;
}