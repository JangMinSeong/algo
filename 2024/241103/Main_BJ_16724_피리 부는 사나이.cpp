#include<iostream>

using namespace std;

int n, m;
int map[1001][1001];
int visit[1001][1001];  
int d[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };
int ans = 0;

void dfs(int x, int y);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            char dir;
            cin >> dir;

            switch (dir) {
            case 'U': map[i][j] = 0; break;
            case 'L': map[i][j] = 1; break;
            case 'D': map[i][j] = 2; break;
            case 'R': map[i][j] = 3; break;
            }
        }
    }

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (visit[i][j] == 0)
                dfs(i, j);

    cout << ans;

    return 0;
}

void dfs(int x, int y) {
    visit[x][y] = 1;  
    int dir = map[x][y];
    int newX = x + d[dir][0];
    int newY = y + d[dir][1];


    if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
        visit[x][y] = 2;
        ans++;
        return;
    }

    if (visit[newX][newY] == 2) {
        visit[x][y] = 2;
        return;
    }

    if (visit[newX][newY] == 1) {
        visit[x][y] = 2;
        ans++;
        return;
    }

    if (visit[newX][newY] == 0)
        dfs(newX, newY);

    if (visit[newX][newY] == 2)
        visit[x][y] = 2;
}
