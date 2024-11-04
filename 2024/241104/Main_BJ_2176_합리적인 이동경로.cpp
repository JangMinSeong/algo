#include<iostream>
#include<queue>
#include<vector>

using namespace std;

int n, m;
vector<vector<pair<int,int>>> adj;
int dist[1001];
int dp[1001];
int inf = 999999999;

void solve(int node);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;
	
	adj.resize(n + 1);
	for (int i = 0; i <= n; i++) dist[i] = inf;
	for (int i = 0; i < m; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;

		adj[from].push_back({ to,cost });
		adj[to].push_back({ from,cost });
	}

	solve(2);
	cout << dp[1];

	return 0;
}

void solve(int node) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> que;
	que.push({ 0,node });
	dist[node] = 0;
	dp[node] = 1;

	while (!que.empty()) {
		pair<int, int> cur = que.top();
		que.pop();

		if (cur.first > dist[cur.second]) continue;

		for (auto iter : adj[cur.second]) {
			if (dist[iter.first] > cur.first + iter.second) {
				dist[iter.first] = cur.first + iter.second;
				que.push({ dist[iter.first], iter.first });
			}

			if (cur.first > dist[iter.first])
				dp[cur.second] += dp[iter.first];
		}
	}
}