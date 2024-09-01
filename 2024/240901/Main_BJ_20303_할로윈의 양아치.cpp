#include<iostream>
#include<vector>

using namespace std;

int n, m, k;
int candy[30001];

int v,w;
bool visit[30001] = { false, };
vector<vector<int>> adj;
vector<int> value;
vector<int> weight;

int dp[30001][3001];

void dfs(int node);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m >> k;
	adj.resize(n + 1);

	for (int i = 1; i <= n; i++) {
		cin >> candy[i];
	}
	for (int i = 0; i < m; i++) {
		int num1, num2;
		cin >> num1 >> num2;
		adj[num1].push_back(num2);
		adj[num2].push_back(num1);
	}
	
	weight.push_back(0);
	value.push_back(0);
	for (int i = 1; i <= n; i++) {
		if (visit[i] == true) continue;
		v = w = 0;
		dfs(i);
		value.push_back(v);
		weight.push_back(w);
	}

	for (int i = 1; i < weight.size(); i++) {
		for (int j = 0; j < k; j++) {
			if (j < weight[i]) {
				dp[i][j] = max(dp[i][j], dp[i - 1][j]);
			}
			else dp[i][j] = max(dp[i][j], max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]));
		}
	}

	cout << dp[weight.size() - 1][k - 1];

	return 0;
}

void dfs(int node) {
	visit[node] = true;
	v += candy[node];
	w += 1;
	for (int i = 0; i < adj[node].size(); i++) {
		int next = adj[node][i];
		if (visit[next] == true) continue;
		dfs(next);
	}
}