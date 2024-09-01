#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>

using namespace std;

int n;
pair<int, int> problem[200000];

bool comp(pair<int, int> a, pair<int, int> b) {
    if (a.first != b.first) {
        return a.first < b.first;
    }
    return a.second > b.second;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        int deadline, cup;
        cin >> deadline >> cup;
        problem[i] = make_pair(deadline, cup);
    }

    sort(problem, problem + n, comp);

    priority_queue<int, vector<int>, greater<int>> pq;
    int ans = 0;

    for (int i = 0; i < n; i++) {
        if (pq.size() < problem[i].first) {
            pq.push(problem[i].second);
            ans += problem[i].second;
        }
        else if (!pq.empty() && pq.top() < problem[i].second) {
            ans += problem[i].second - pq.top();
            pq.pop();
            pq.push(problem[i].second);
        }
    }

    cout << ans << endl;

    return 0;
}
