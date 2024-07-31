#include<iostream>
#include<algorithm>

using namespace std;

int n;
pair<int, int> emo[100001];

struct {
    bool operator() (pair<int, int> a, pair<int, int> b) const { return a.second < b.second; }
}compare;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        emo[i].first = num; 
    }
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        emo[i].second = num;
    }

    sort(emo, emo + n, compare);

    long long answer = 0;
    int a = emo[0].first;
    int b = emo[0].second;
    for (int i = 0; i < n; i++) {
        if (b > emo[i].first) {
            int temp = ((b - emo[i].first) + 29) / 30;
            answer += temp;
            emo[i].first += temp * 30;
        }

        a = max(a, emo[i].first);

        if (i + 1 < n && emo[i].second != emo[i + 1].second)
            b = max(a, emo[i + 1].second);
    }

    cout << answer << '\n';

    return 0;
}
