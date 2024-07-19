#include<iostream>
#include<vector>

using namespace std;

int v;
vector<vector<pair<int, int>>> adj;
int ans;
int maxV;
bool visited[100000];

void dfs(int num, int weight);

int main() {
	cin >> v;

	for (int i = 0; i < v; i++) {
		vector<pair<int, int>> temp;
		adj.push_back(temp);
	} 
	
	for (int i = 0; i < v; i++) {
		int num;
		cin >> num;

		while (1) {
			int to;
			cin >> to;
			if (to == -1) break;

			int weight;
			cin >> weight;

			adj[num - 1].push_back(make_pair(to-1, weight));
		}
	}
	visited[0] = true;
	dfs(0, 0);
	visited[0] = false;

	visited[maxV] = true;
	dfs(maxV, 0);

	cout << ans << endl;
}

void dfs(int num, int weight) {
	if (ans < weight) {
		maxV = num;
		ans = weight;
	}

	for (int i = 0; i < adj[num].size(); i++) {
		if (visited[adj[num][i].first] == true) continue;
		visited[adj[num][i].first] = true;
		dfs(adj[num][i].first, weight + adj[num][i].second);
		visited[adj[num][i].first] = false;
	}
}