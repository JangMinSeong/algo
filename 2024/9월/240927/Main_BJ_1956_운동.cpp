#include<iostream>
#include<cstring>

#define INF 1000000000

using namespace std;

int v,e;
int dis[401][401];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> v >> e;
	for (int i = 1; i <= v; i++) {
		for (int j = 1; j <= v; j++) {
			if (i == j) dis[i][j] = 0;
			else dis[i][j] = INF;
		}
	}

	for (int i = 0; i < e; i++) {
		int s, e, w;
		cin >> s >> e >> w;
		dis[s][e] = w;
	}


	for (int i = 1; i <= v; i++) {
		for (int j = 1; j <= v; j++) {
			for (int k = 1; k <= v; k++) {
				dis[j][k] = min(dis[j][k], dis[j][i] + dis[i][k]);
			}
		}
	}
	int ans = INF;
	for (int i = 1; i <= v ; i++) {
		for (int j = i+1; j <= v; j++) {
			int value = dis[i][j] + dis[j][i];
			if (ans > value) ans = value;
		}
	}

	if (ans == INF) cout << -1;
	else cout << ans;
	
	return 0;
}