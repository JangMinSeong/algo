#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, h;
vector<int> top, bottom;
int block[500001];
int ans1 = 2147483647, ans2 = 0;

int main() {
    cin >> n >> h;

    for (int i = 0; i < n; i++) {
        int input;
        cin >> input;
        if (i % 2 == 0) bottom.push_back(input);
        else top.push_back(input);
    }

    sort(bottom.begin(), bottom.end());
    sort(top.begin(), top.end());

    for (int i = 1; i <= h; i++) {
        int cnt1 = lower_bound(top.begin(), top.end(), i) - top.begin();
        int cnt2 = lower_bound(bottom.begin(), bottom.end(), h - i + 1) - bottom.begin();
        //  cout << i << " " << cnt1 << " " << bottom.size() - cnt2 << endl;
        block[i] = (top.size() - cnt1) + (bottom.size() - cnt2);
        if (ans1 > block[i]) ans1 = block[i];
    }

    for (int i = 1; i <= h; i++) {
        if (ans1 == block[i]) {
            ans2++;
        }
    }

    cout << ans1 << " " << ans2;
    return 0;
}