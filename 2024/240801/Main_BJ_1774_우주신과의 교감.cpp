#include <iostream>
#include <vector>
#include <cmath>
#include <queue>
#include <tuple>

using namespace std;

int n, m;
pair<int, int> pos[1001];
int parent[1001];
priority_queue<pair<double, pair<int, int>>, vector<pair<double, pair<int, int>>>, greater<>> pq;
double ans;

int find(int a) {
    if (parent[a] == a) return a;
    return parent[a] = find(parent[a]);
}

void u(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
        parent[b] = a;
    }
}

double calDis(int x1, int y1, int x2, int y2) {
    return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> pos[i].first >> pos[i].second;
        parent[i] = i;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            double distance = calDis(pos[i].first, pos[i].second, pos[j].first, pos[j].second);
            pq.push({ distance, {i, j} });
        }
    }

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        u(a, b);
    }
      
    while (!pq.empty()) {
        double distance = pq.top().first;
        int a = pq.top().second.first;
        int b = pq.top().second.second;
        pq.pop();

        if (find(a) != find(b)) {
            u(a, b);
            ans += distance;
        }
    }

    cout << fixed;
    cout.precision(2);
    cout << ans << "\n";

    return 0;
}
