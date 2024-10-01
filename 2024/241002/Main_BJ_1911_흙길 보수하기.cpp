#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, l;
vector<pair<int, int>> hole;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> l;

    for (int i = 0; i < n; i++) {
        int start, end;
        cin >> start >> end;
        hole.push_back({ start, end });
    }
    sort(hole.begin(), hole.end());

    int cnt = 0;
    int e = 0; 

    for (int i = 0; i < n; i++) {
        int start = hole[i].first;
        int end = hole[i].second;

        if (e < start) {
            e = start;
        }

        while (e < end) {
            cnt++;
            e += l;
        }
    }

    cout << cnt;

    return 0;
}
