#include<iostream>
#include<vector>

using namespace std;

struct food {
    int mp;
    int mf;
    int ms;
    int mv;
    int cost;
};

int n;
food f[16];
int P, F, S, V;
int ans = 999999999;

vector<int> vec, ansVec;
void dfs(int idx, int mp, int mf, int ms, int mv, int c);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    cin >> P >> F >> S >> V;
    for (int i = 0; i < n; i++) {
        int mp, mf, ms, mv, cost;
        cin >> mp >> mf >> ms >> mv >> cost;
        f[i] = { mp, mf, ms, mv, cost };
    }

    dfs(0, 0, 0, 0, 0, 0);

    if (ans == 999999999) cout << -1;
    else {
        cout << ans << endl;
        for (auto iter : ansVec) cout << iter << " ";
        cout << endl;
    }

    return 0;
}

void dfs(int idx, int mp, int mf, int ms, int mv, int c) {
    if (idx == n) {
        if (mp >= P && mf >= F && ms >= S && mv >= V) {
            if (ans > c || (ans == c && ansVec > vec)) { 
                ans = c;
                ansVec = vec;
            }
        }
        return;
    }

    dfs(idx + 1, mp, mf, ms, mv, c);
    vec.push_back(idx + 1);
    dfs(idx + 1, mp + f[idx].mp, mf + f[idx].mf, ms + f[idx].ms, mv + f[idx].mv, c + f[idx].cost);
    vec.pop_back();
}
