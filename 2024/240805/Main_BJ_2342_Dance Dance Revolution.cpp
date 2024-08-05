#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

const int INF = 999999999;
int score_board[5][5] = {
    {0, 2, 2, 2, 2},
    {0, 1, 3, 4, 3},
    {0, 3, 1, 3, 4},
    {0, 4, 3, 1, 3},
    {0, 3, 4, 3, 1}
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    vector<int> moves;
    int num;
    while (cin >> num && num != 0) {
        moves.push_back(num);
    }

    int n = moves.size();
    vector<vector<vector<int>>> dp(n + 1, vector<vector<int>>(5, vector<int>(5, INF)));
    dp[0][0][0] = 0;

    for (int i = 0; i < n; i++) {
        int step = moves[i];
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                if (dp[i][l][r] == INF) continue;
                dp[i + 1][step][r] = min(dp[i + 1][step][r], dp[i][l][r] + score_board[l][step]);
                dp[i + 1][l][step] = min(dp[i + 1][l][step], dp[i][l][r] + score_board[r][step]);
            }
        }
    }

    int answer = INF;
    for (int l = 0; l < 5; l++) {
        for (int r = 0; r < 5; r++) {
            answer = min(answer, dp[n][l][r]);
        }
    }

    cout << answer;
    return 0;
}
