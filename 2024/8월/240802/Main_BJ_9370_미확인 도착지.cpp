#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

#define INF 2000001

using namespace std;

int n, m, t;
vector<vector<pair<int,int>>> adj;
int d[3][2001];
int ts[101];
vector<int> ans;
void calDis(int start, int option);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int test_case;
	cin >> test_case;
	for (int tc = 0; tc < test_case; tc++) {
		cin >> n >> m >> t;

		int s, g, h;
		cin >> s >> g >> h;

		adj.clear();
		int value = 0;
		for (int i = 0; i <= n; i++) {
			d[0][i] = d[1][i] = d[2][i] = INF;
			vector<pair<int,int>> tmp;
			adj.push_back(tmp);
		}
		for (int i = 0; i < m; i++) {
			int a, b, d;
			cin >> a >> b >> d;

			adj[a].push_back({ b,d });
			adj[b].push_back({ a,d });
			if ((a == g && b == h) || (a == h && b == g)) value = d;
		}
		calDis(s, 0);
		calDis(g, 1);
		calDis(h, 2);
		
		ans.clear();
		for (int i = 0; i < t; i++) {
			cin >> ts[i];
			int dis = min(d[0][g] + d[2][ts[i]] + value, d[0][h] + d[1][ts[i]] + value);

			if (dis == d[0][ts[i]]) ans.push_back(ts[i]);
		}

		sort(ans.begin(), ans.end());
		for (int i = 0; i < ans.size(); i++) {
			cout << ans[i] << " ";
		}
		cout << endl;
	}
}

void calDis(int start, int option) {
	priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int,int>>> que;

	d[option][start] = 0;
	que.push({ 0,start });

	while (!que.empty()) {
		pair<int,int> front;
		front = que.top();
		que.pop();

		if (d[option][front.second] < front.first) continue;

		for (int i = 0; i < adj[front.second].size(); i++) {
			int nextDis = front.first + adj[front.second][i].second;

			if (nextDis < d[option][adj[front.second][i].first]) {
				d[option][adj[front.second][i].first] = nextDis;
				que.push({ nextDis, adj[front.second][i].first });
			}
		}
	}
}