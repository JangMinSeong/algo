package w0818;

import java.util.*;

public class Main_BJ_17135_Ä³½½µðÆæ½º {
    static int n, m, d;
    static int[][] map;
    static int[][] copyMap;
    static int[] archer;
    static int[] min_d = { 100, 100, 100 };
    static Pair<Integer, Integer>[] min_pos = new Pair[3];
    static int c;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        map = new int[15][15];
        copyMap = new int[15][15];
        archer = new int[15];
        for (int i = 0; i < 3; i++) {
            min_pos[i] = new Pair<>(0, 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        solve(0, new boolean[m], 0);
        System.out.println(result);
    }

    static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    static int cal_dis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(copyMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void next_turn() {
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = copyMap[i - 1][j];
            }
        }
        for (int i = 0; i < m; i++) {
            copyMap[0][i] = 0;
        }
    }

    static void init_min() {
        for (int i = 0; i < 3; i++) {
            min_d[i] = 100;
            min_pos[i] = new Pair<>(0, 0);
        }
    }

    static void attack() {
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (copyMap[j][i] == 1) {
                    for (int k = 0; k < 3; k++) {
                        int dis = cal_dis(j, i, n, archer[k]);
                        if (min_d[k] > dis) {
                            min_d[k] = dis;
                            min_pos[k] = new Pair<>(j, i);
                        }
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (min_d[i] <= d && copyMap[min_pos[i].first][min_pos[i].second] == 1) {
                c++;
                copyMap[min_pos[i].first][min_pos[i].second] = 0;
            }
        }
        init_min();
    }

    static void solve(int count, boolean[] isUsed, int next) {
        if (count == 3) {
            copy();
            c = 0;
            while (true) {
                attack();
                next_turn();
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (copyMap[i][j] == 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            result = Math.max(result, c);
            return;
        }
        for (int i = next; i < m; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                archer[count] = i;
                solve(count + 1, isUsed, i + 1);
                isUsed[i] = false;
            }
        }
    }

    static class Pair<T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }
}