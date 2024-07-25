#include <iostream>
#include <vector>

using namespace std;

vector<pair<int, int>> coins;
bool dp[101][100001];

void clear(int n, int totalCoin);

int main() {
    for (int test_case = 0; test_case < 3; test_case++) {
        int n;
        cin >> n;
        int totalCoin = 0;

        coins.clear();
        for (int i = 0; i < n; i++) {
            int coin, cnt;
            cin >> coin >> cnt;
            coins.push_back({ coin, cnt });
            totalCoin += coin * cnt;
        }

        if (totalCoin % 2 == 1) {
            cout << 0 << endl;
            continue;
        }

        clear(n, totalCoin / 2);

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1].first;
            int cnt = coins[i - 1].second;
            for (int j = 0; j <= totalCoin / 2; j++) {
                if (dp[i - 1][j]) {
                    for (int k = 0; k <= cnt; k++) {
                        if (j + coin * k > totalCoin / 2) break;
                        dp[i][j + coin * k] = true;
                    }
                }
            }
        }

        if (dp[n][totalCoin / 2]) {
            cout << 1 << endl;
        }
        else {
            cout << 0 << endl;
        }
    }
}

void clear(int n, int totalCoin) {
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= totalCoin; j++) {
            dp[i][j] = false;
        }
    }
}
