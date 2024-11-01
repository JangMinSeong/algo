#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int n, m;
int p[100001];
int ans = 0;
vector<pair<int, pair<int, int>>> vec;

int find_parent(int x);
void u(int x, int y);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;

		vec.push_back({ cost, {from, to} });
	}
	sort(vec.begin(), vec.end());

	for (int i = 0; i <= n; i++) p[i] = i;

	int cnt = 1;
	for (int i = 0; i < m; i++) {
		int node1 = vec[i].second.first;
		int node2 = vec[i].second.second;

		if (find_parent(node1) != find_parent(node2)) {
			cnt++;
			u(node1, node2);
			ans += vec[i].first;
		}
		if (cnt == n) {
			ans -= vec[i].first;
			break;
		}
	}

	cout << ans;
}

int find_parent(int x) {
	if (x == p[x]) return x;
	return (p[x] = find_parent(p[x]));
}

void u(int x, int y) {
	x = find_parent(x);
	y = find_parent(y);
	p[y] = x;
}
