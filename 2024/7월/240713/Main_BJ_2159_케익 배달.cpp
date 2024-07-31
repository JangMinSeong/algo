#include <iostream>
#include <cstring>

using namespace std;

int n;
int d[5][2] = { {1,0},{0,1},{-1,0},{0,-1},{0,0} };
pair<int,int> pos[100001];
int dp[100001][5];

int calDis(pair<int, int> a, pair<int, int> b);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	int start_x, start_y;
	cin >> start_x >> start_y;
	pos[0] = make_pair(start_x, start_y);

	for (int i = 1; i <= n; i++) {
		int x, y;
		cin >> x >> y;
		pos[i] = make_pair(x, y);

		for (int j = 0; j < 5; j++) {
			dp[i][j] = 1000000000;
		}
	}
	
	for (int i = 0; i < 5; i++) {
		int x = pos[1].first + d[i][0];
		int y = pos[1].second + d[i][1];

		dp[1][i] = calDis(make_pair(x, y), pos[0]);
		dp[0][i] = 0;
	}

	for (int i = 2; i <= n; i++) {
		for (int j = 0; j < 5; j++) {
			int newX1 = pos[i].first + d[j][0];
			int newY1 = pos[i].second + d[j][1];

			for (int k = 0; k < 5; k++) {
				int newX2 = pos[i-1].first + d[k][0];
				int newY2 = pos[i-1].second + d[k][1];

				dp[i][j] = min(dp[i][j], dp[i - 1][k] + calDis(make_pair(newX1, newY1), make_pair(newX2, newY2)));
			}
		}
	}

	/*for (int i = 0; i < 5; i++) {
		for (int j = 0; j <= n; j++) {
			cout << dp[j][i] << " ";
		}
		cout << endl;
	}*/

	int ans = dp[n][0];
	for (int i = 1; i < 5; i++) {
		ans = min(ans, dp[n][i]);
	}
	cout << ans << endl;
}

int calDis(pair<int, int> a, pair<int, int> b) {
	return abs(a.first - b.first) + abs(a.second - b.second);
}