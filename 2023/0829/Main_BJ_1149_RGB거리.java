package w0829;

import java.util.Scanner;

public class Main_BJ_1149_RGB°Å¸® {
    public static int min(int a, int b) {
        if (a > b) return b;
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r, g, b;
        int i;
        int[] cost = new int[3];
        int[] temp = new int[3];
        for (i = 0; i < n; i++) {
            r = scanner.nextInt();
            g = scanner.nextInt();
            b = scanner.nextInt();
            temp[0] = min(cost[1], cost[2]) + r;
            temp[1] = min(cost[0], cost[2]) + g;
            temp[2] = min(cost[0], cost[1]) + b;
            cost[0] = temp[0];
            cost[1] = temp[1];
            cost[2] = temp[2];
        }
        System.out.println(min(cost[0], min(cost[1], cost[2])));
    }
}
