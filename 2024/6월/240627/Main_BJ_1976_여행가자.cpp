#include <iostream>

using namespace std;

int n, m;
int p[201];

int getParent(int x) {
    if (p[x] == x) return x;
    return p[x] = getParent(p[x]);
}

int main() {
    cin >> n;
    cin >> m;

    for (int i = 1; i <= n; i++) p[i] = i;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            int connect;
            cin >> connect;
            if (i == j) continue;
            if (connect == 1) {
                int p1 = getParent(i);
                int p2 = getParent(j);
                if (p1 < p2)
                    p[p2] = p1;
                else
                    p[p1] = p2;
            }
        }
    }
    // for(int i=1;i<=n;i++) 
    //     cout << p[i] << " ";
    // cout << endl;

    int start;
    int ch = 0;
    cin >> start;
    for (int i = 1; i < m; i++) {
        int input;
        cin >> input;
        if (p[start] != p[input]) {
            ch = 1;
        }
    }

    if (ch == 0) cout << "YES";
    else cout << "NO";

    return 0;
}