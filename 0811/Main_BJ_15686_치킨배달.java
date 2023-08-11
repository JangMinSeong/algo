package w0811;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_BJ_15686_치킨배달 {
    static int n, m;
    static List<List<Integer>> map = new ArrayList<>();
    static List<Pair<Integer, Integer>> chick = new ArrayList<>();
    static List<Pair<Integer, Integer>> house = new ArrayList<>();
    static int minDis = 1000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int t = scanner.nextInt();
                row.add(t);
                if (t == 1) house.add(new Pair<>(i, j));
                else if (t == 2) chick.add(new Pair<>(i, j));
            }
            map.add(row);
        }
        List<Integer> vec = new ArrayList<>();
        dfs(vec, 0);
        System.out.println(minDis);
    }

    static void dfs(List<Integer> vec, int depth) {
        if (vec.size() == m) {
            int length = calDistance(vec);
            if (length < minDis)
                minDis = length;
            return;
        }
        if (depth == chick.size()) return;
        vec.add(depth);
        dfs(vec, depth + 1);
        vec.remove(vec.size() - 1);
        dfs(vec, depth + 1);
    }

    static int calDistance(List<Integer> vec) {
        int result = 0;
        for (int i = 0; i < house.size(); i++) {
            int min = 1000;
            for (int j = 0; j < vec.size(); j++) {
                int dis = distance(house.get(i), chick.get(vec.get(j)));
                if (dis < min) {
                    min = dis;
                }
            }
            result += min;
        }
        return result;
    }

    static int distance(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        return Math.abs(a.getKey() - b.getKey()) + Math.abs(a.getValue() - b.getValue());
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
