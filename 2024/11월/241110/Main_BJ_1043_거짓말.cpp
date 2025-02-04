#include<iostream>
#include<vector>

using namespace std;

int n, m;
int ans = 0;
vector<int> vec;
vector<vector<int>> party;
int parent[51];

int findP(int a);
void u(int a, int b);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i <= n; i++) parent[i] = i;
	party.resize(m);

	int num;
	cin >> num;
	for (int i = 0; i < num; i++) {
		int p;
		cin >> p;
		vec.push_back(p);
	}

	for (int i = 0; i < m; i++) {
		cin >> num;

		int ch = 0;
		for (int j = 0; j < num; j++) {
			int p;
			cin >> p;
			party[i].push_back(p);
		}
	}

	for (int i = 0; i < m; i++) {
		for (int j = 1; j < party[i].size(); j++) {
			u(party[i][j - 1], party[i][j]);
		}
	}


	for (int i = 0; i < m; i++) {
		int ch = 0;
		for (int j = 0; j < vec.size(); j++) {
			if (findP(vec[j]) == findP(party[i][0])) {
				ch = 1;
				break;
			}
		}
		if (ch == 0) ans++;
	}

	cout << ans;

	return 0;
}

int findP(int a) {
	if (a == parent[a]) return a;
	return parent[a] = findP(parent[a]);
}

void u(int a, int b) {
	a = findP(a);
	b = findP(b);

	if (a == b) return;

	if (a < b) parent[b] = a;
	else parent[a] = b;
}