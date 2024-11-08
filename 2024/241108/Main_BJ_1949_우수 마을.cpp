#include<iostream>
#include<vector>
#include<cstring>
#include<algorithm>

using namespace std;

int n;
int peo[10001];
int dp[10001][2];
vector<vector<int>> adj;

void dfs(int node, int parent);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    adj.resize(n + 1);
    for (int i = 1; i <= n; i++)
        cin >> peo[i];

    for (int i = 0; i < n - 1; i++) {
        int from, to;
        cin >> from >> to;
        adj[from].push_back(to);
        adj[to].push_back(from);
    }

    memset(dp, -1, sizeof(dp));

    dfs(1, 0); 
    cout << max(dp[1][0], dp[1][1]);

    return 0;
}

void dfs(int node, int parent) {
    dp[node][0] = 0;            
    dp[node][1] = peo[node];     

    for (int next : adj[node]) {
        if (next == parent) continue;

        dfs(next, node);

        dp[node][0] += max(dp[next][0], dp[next][1]); 
        dp[node][1] += dp[next][0];                  
    }
}
