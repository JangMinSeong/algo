#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;

    vector<pair<int, int>> stations(n);
    for (int i = 0; i < n; i++) {
        int distance, fuel;
        cin >> distance >> fuel;
        stations[i] = { distance, fuel };
    }

    int l, p;
    cin >> l >> p;

    sort(stations.begin(), stations.end());

    priority_queue<int> maxHeap;
    int result = 0;
    int currentPosition = 0;
    int stationIndex = 0;

    while (p < l) {
        while (stationIndex < n && stations[stationIndex].first <= p) {
            maxHeap.push(stations[stationIndex].second);
            stationIndex++;
        }

        if (maxHeap.empty()) {
            result = -1;
            break;
        }

        p += maxHeap.top();
        maxHeap.pop();
        result++;
    }

    cout << result << '\n';
    return 0;
}
