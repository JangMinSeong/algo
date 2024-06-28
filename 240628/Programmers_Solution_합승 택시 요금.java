import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> adj;
    public boolean[] visit;
    public int[][] cost;
    public int ans = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ArrayList tmp = new ArrayList<>();
            adj.add(tmp);
        }

        visit = new boolean[n + 1];
        cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) cost[i][j] = 0;
                else cost[i][j] = 55555555;
            }
        }

        for (int i = 0; i < fares.length; i++) {
            adj.get(fares[i][0]).add(fares[i][1]);
            adj.get(fares[i][1]).add(fares[i][0]);
            cost[fares[i][0]][fares[i][1]] = fares[i][2];
            cost[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        makeCostTable(n);

        findAns(s, s, a, b);

        return ans;
    }

    public void makeCostTable(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
                }
            }
        }
    }

    public void findAns(int node, int s, int a, int b) {
        int result = cost[s][node] + cost[node][a] + cost[node][b];
        if (ans > result) ans = result;

        visit[node] = true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int tmp = adj.get(node).get(i);
            if (visit[tmp] == true) continue;
            findAns(tmp, s, a, b);
        }
    }
}