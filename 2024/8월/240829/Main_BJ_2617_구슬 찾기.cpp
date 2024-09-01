#include<iostream>
#include<vector>

using namespace std;

int n, m;
vector<vector<int>> upperAdj;
vector<vector<int>> lowerAdj;
vector<bool> uVisit, lVisit;
int uCnt, lCnt;

void clear();
void upperDfs(int node);
void lowerDfs(int node);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i <= n; i++) {
		vector<int> tmp;
		upperAdj.push_back(tmp);
		lowerAdj.push_back(tmp);
		uVisit.push_back(false);
		lVisit.push_back(false);
	}

	for (int i = 0; i < m; i++) {
		int num1, num2;
		cin >> num1 >> num2;

		upperAdj[num1].push_back(num2);
		lowerAdj[num2].push_back(num1);
	}

	int middle = (n + 1) / 2;

	int ans = 0;
	for (int i = 1; i <= n; i++) {
		clear();
		upperDfs(i);
		lowerDfs(i);

		if (middle <= uCnt || middle <= lCnt) ans++;
	}

	cout << ans;

	return 0;
}

void clear() {
	uCnt = lCnt = 0;
	for (int i = 1; i <= n; i++) {
		uVisit[i] = false;
		lVisit[i] = false;
	}
}

void upperDfs(int node) {
	uVisit[node] = true;
	for (int i = 0; i < upperAdj[node].size(); i++) {
		if (uVisit[upperAdj[node][i]] == true) continue;
		uCnt++;
		upperDfs(upperAdj[node][i]);
	}
}

void lowerDfs(int node) {
	lVisit[node] = true;
	for (int i = 0; i < lowerAdj[node].size(); i++) {
		if (lVisit[lowerAdj[node][i]] == true) continue;
		lCnt++;
		lowerDfs(lowerAdj[node][i]);
	}
}

