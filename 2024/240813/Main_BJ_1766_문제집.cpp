#include<iostream>
#include<queue>
#include<vector>

using namespace std;

int n, m;
int cnt[32001];
vector<vector<int>> adj;
priority_queue<int, vector<int>, greater<>> nextNode;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i <= n; i++) {
		vector<int> tmp;
		adj.push_back(tmp);
	}

	for (int i = 0; i < m; i++) {
		int from, to;
		cin >> from >> to;

		adj[from].push_back(to);
		cnt[to]++;
	}
	for (int i = 1; i <= n; i++) {
		if (cnt[i] == 0) nextNode.push(i);
	}

	for (int i = 1; i <= n; i++) {
		int cur = nextNode.top();
		nextNode.pop();
		cout << cur << " ";
		for (int j = 0; j < adj[cur].size(); j++) {
			if ((--cnt[adj[cur][j]]) == 0) {
				nextNode.push(adj[cur][j]);
			}
		}
	}

	cout << endl;

	return 0;
}
