#include<iostream>
#include<queue>
#include<vector>

using namespace std;

struct compareIn {
	bool operator() (const pair<int, pair<int,int>>& a, const pair<int, pair<int,int>>& b) const {
		if (a.first > b.first)
			return true;
		if (a.first == b.first) {
			if (a.second.first > b.second.first)
				return true;
			return false;
		}
		return false;
	}
};

struct compareOut {
	bool operator() (const pair<int, pair<int,int>>& a, const pair<int, pair<int,int>>& b) const {
		if (a.first > b.first)
			return true;
		if (a.first == b.first) {
			if (a.second.first < b.second.first)
				return true;
			return false;
		}
		return false;
	}
};

int n, k;
priority_queue<pair<int, pair<int,int>>, vector<pair<int,pair<int, int>>>, compareIn> queIn;   // <종료시간, <idx, id>>
priority_queue<pair<int, pair<int,int>>, vector<pair<int,pair<int, int>>>, compareOut> queOut; // <종료시간, <idx, id>>

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;
	int lineCnt = 0;
	for (int i = 0; i < n; i++) {
		int id, amount;
		cin >> id >> amount;

		if (lineCnt < k) {  //시작 k 만큼
			queIn.push(make_pair(amount, make_pair(lineCnt, id)));
			lineCnt++;
			continue;
		}

		auto top = queIn.top();

		queIn.pop();
		queIn.push({ top.first + amount, {top.second.first, id} });
		queOut.push({ top.first, {top.second.first, top.second.second} });
	}

	while (!queIn.empty()) {
		auto top = queIn.top();
		queIn.pop();

		queOut.push({ top.first, {top.second.first, top.second.second} });
	}

	long long ans = 0;
	int cnt = 1;
	while (!queOut.empty()) {
		auto top = queOut.top();
		queOut.pop();

		ans += (long long)(cnt++) * top.second.second;
	}

	cout << ans;

	return 0;
}