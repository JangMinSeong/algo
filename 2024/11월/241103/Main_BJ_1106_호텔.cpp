#include<iostream>
#include<algorithm>

using namespace std;

int c, n;
pair<int, int> pro[21];
int dp[100001];
const int inf = 999999999;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> c >> n;
    for (int i = 1; i <= n; i++) {
        int cost, peo;
        cin >> cost >> peo;
        pro[i] = { cost, peo };
    }

    for (int i = 0; i < 100001; i++) dp[i] = inf;
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
        int cost = pro[i].first;
        int people = pro[i].second;
        for (int j = people; j < 100001; j++) {
            dp[j] = min(dp[j], dp[j - people] + cost);
        }
    }

    int ans = inf;
    for (int i = c; i < 100001; i++) {
        ans = min(ans, dp[i]);
    }

    cout << ans;
    return 0;
}
