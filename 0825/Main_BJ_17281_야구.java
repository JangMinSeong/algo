package w0825;

import java.util.Scanner;

public class Main_BJ_17281_¾ß±¸ {
    static int n;
    static int[][] batter = new int[50][9];
    static int max_score;
    static int[] order = new int[9];
    static boolean[] isSelected = new boolean[9];

    static int move(int[] base, int hit) {
        int score = 0;
        int ch = 0;
        if (hit == 4) {
            score += 1;
            hit--;
            ch = 1;
        }
        for (int i = 2; i >= 3 - hit; i--) {
            if (base[i] == 1) {
                score++;
                base[i] = 0;
            }
        }
        for (int i = 3 - hit; i >= 0; i--) {
            if (i + hit < 3) {
                base[i + hit] = base[i];
                base[i] = 0;
            }
        }
        if (ch != 1)
            base[hit - 1] = 1;
        return score;
    }

    static void start() {
        int at = 0;
        int score = 0;
        for (int i = 0; i < n; i++) {
            int out = 0;
            int sub_score = 0;
            int[] base = new int[3];
            while (out != 3) {
                if (batter[i][order[at]] == 0) out++;
                else sub_score += move(base, batter[i][order[at]]);
                at++;
                at = at % 9;
            }
            score += sub_score;
        }
        if (max_score < score) max_score = score;
    }

    static void solve(int num) {
        if (num == 3) num += 1;
        if (num == 9) {
            start();
        } else {
            for (int i = 0; i < 9; i++) {
                if (isSelected[i] == true) continue;
                isSelected[i] = true;
                order[num] = i;
                solve(num + 1);
                isSelected[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 9; j++) {
                batter[i][j] = sc.nextInt();
            }
        }
        order[3] = 0;
        isSelected[0] = true;
        solve(0);
        System.out.println(max_score);
    }
}
