#include<iostream>
#include<vector>

using namespace std;

int n;
vector<int> childCnt;
vector<pair<int, int>> e;

int dCnt = 0;
int gCnt = 0;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	for (int i = 0; i <= n; i++) {
		vector<int> tmp;
		childCnt.push_back(0);
	}  //init

	for (int i = 0; i < n - 1; i++) {
		int from, to;
		cin >> from >> to;
		e.push_back(make_pair(from, to));
		childCnt[from]++;
		childCnt[to]++;
	}


	for (int i = 1; i <= n; i++) {
		if (childCnt[i] >= 3) {
			gCnt += (childCnt[i] * (childCnt[i] - 1) * (childCnt[i] - 2)) / 6;
		}
	}
	for (int i = 0; i < e.size(); i++) {
		int from, to;
		from = e[i].first;
		to = e[i].second;

		dCnt += (childCnt[from] - 1) * (childCnt[to] - 1);
	}

	if (gCnt * 3 == dCnt) cout << "DUDUDUNGA";
	else if (gCnt * 3 > dCnt) cout << "G";
	else cout << "D";
}