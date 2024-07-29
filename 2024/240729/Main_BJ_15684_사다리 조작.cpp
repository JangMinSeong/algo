#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n, m, h;
bool ladder[31][12];
int ans = 4; 

void dfs(int cnt, int x, int y);
bool check();

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m >> h;

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        ladder[a][b] = true;
    }

    dfs(0, 1, 1);

    if (ans == 4) cout << -1;
    else cout << ans;
}

void dfs(int cnt, int x, int y) {
    if (cnt >= ans) return;
    if (check()) {
        ans = cnt;
        return;
    }

    for (int i = x; i <= h; i++) {
        for (int j = (i == x ? y : 1); j < n; j++) {
            if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1]) continue;
            ladder[i][j] = true;
            dfs(cnt + 1, i, j);
            ladder[i][j] = false;
        }
    }
}

bool check() {
    for (int i = 1; i <= n; i++) {
        int pos = i;
        for (int j = 1; j <= h; j++) {
            if (ladder[j][pos]) pos++;
            else if (pos > 1 && ladder[j][pos - 1]) pos--;
        }
        if (pos != i) return false;
    }
    return true;
}
