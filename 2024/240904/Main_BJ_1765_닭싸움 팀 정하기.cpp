#include<iostream>
#include<algorithm>
#include<vector>
#include<set>

using namespace std;

int n, m;
int p[1001];
vector<vector<int>> adj;
set<int> team;

int find(int u);
void merge(int u, int v);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	cin >> m;
	adj.resize(n + 1);
	for (int i = 1; i <= n; i++) {
		p[i] = i;
	}
	for (int i = 0; i < m; i++) {
		char r;
		int stu1, stu2;
		cin >> r >> stu1 >> stu2;

		if(r == 'F')
			merge(stu1, stu2);
		else {
			adj[stu1].push_back(stu2);
			adj[stu2].push_back(stu1);
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < adj[i].size(); j++) {
			int e = adj[i][j];
			if (adj[e].size() >= 2) {
				for (int k = 1; k < adj[e].size(); k++) {
					merge(adj[e][0], adj[e][k]);
				}
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		team.insert(find(p[i]));
	}
	cout << team.size();

	return 0;
}

int find(int u) {
	if (u == p[u]) return u;
	return p[u] = find(p[u]);
}

void merge(int u, int v) {
	u = find(u);
	v = find(v);

	if (u == v) return;
	if (u < v) p[v] = u;
	else p[u] = v;

}