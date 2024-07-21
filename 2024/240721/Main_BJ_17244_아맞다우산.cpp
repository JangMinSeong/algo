#include <iostream>
#include <queue>
#include <vector>
#include <tuple>
#include <string>
#include <cstring>

using namespace std;

int n, m;
int sx, sy;

int thingCnt = 0;

char map[51][51];
int visit[51][51][1 << 5];

int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0, 1 };

int bfs() {
    queue<pair<pair<int, int>, pair<int, int>>> q;

    q.push({ {sy, sx}, {0, 0} });
    visit[sy][sx][0] = true;

    while (!q.empty()) {
        int y = q.front().first.first;
        int x = q.front().first.second;
        int cost = q.front().second.first;
        int bitmask = q.front().second.second;

        q.pop();

        if (map[y][x] == 'E') {
            if (bitmask == thingCnt) {
                return cost;
            }
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (map[ny][nx] == '#') continue;

            if (map[ny][nx] >= '0' && map[ny][nx] <= '4') {
                int nBitmask = bitmask | (1 << (map[ny][nx] - '0'));

                if (visit[ny][nx][nBitmask]) continue;

                q.push({ {ny, nx}, {cost + 1, nBitmask} });
                visit[ny][nx][nBitmask] = true;
            }
            else {
                if (visit[ny][nx][bitmask]) continue;

                q.push({ {ny, nx}, {cost + 1, bitmask} });
                visit[ny][nx][bitmask] = true;
            }
        }
    }
    return -1;
}

int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(0); cout.tie(0);

    cin >> m >> n;

    int cnt = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> map[i][j];
            if (map[i][j] == 'S') {
                sy = i;
                sx = j;
                map[i][j] == '.';
            }
            else if (map[i][j] == 'X') {
                map[i][j] = cnt + '0';
                thingCnt = thingCnt | (1 << cnt);
                cnt++;
            }
        }
    }

    cout << bfs();
}
