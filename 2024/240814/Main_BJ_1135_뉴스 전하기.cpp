#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n;
vector<int> tree[51];

int dfs(int node);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;

    int top;
    cin >> top;
    for (int i = 1; i < n; i++) {
        int parent;
        cin >> parent;
        tree[parent].push_back(i);
    }

    cout << dfs(0) << endl;

    return 0;
}

int dfs(int node) {
    vector<int> req;

    for (int i = 0; i < tree[node].size();i++) {
        req.push_back(dfs(tree[node][i]));
    }

    if (req.empty()) return 0;

    sort(req.rbegin(), req.rend());

    int maxTime = 0;
    for (int i = 0; i < req.size(); i++) {
        maxTime = max(maxTime, req[i] + i + 1);
    }

    return maxTime;
}