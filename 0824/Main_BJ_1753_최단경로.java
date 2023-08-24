package w0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int from;
	int to;
	int cost;

	public Node(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return cost - o.cost;
	}

}

public class Main_BJ_1753_최단경로 {
	static int v, e;
	static int start;
	static ArrayList<ArrayList<Node>> adj;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		adj = new ArrayList<>();
		dist = new int[v + 1];
	
		for (int i = 0; i <= v; i++) {
			ArrayList<Node> temp = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
			adj.add(temp);
		}

		start = Integer.parseInt(br.readLine());
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			Node temp = new Node(a, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			adj.get(a).add(temp);
		}
		
		dist[start] = 0;
		d(new Node(0, start, 0));

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
//				System.out.println("INF");
			else
				sb.append(dist[i]).append("\n");
//				System.out.println(dist[i]);

		}
		System.out.println(sb);
	}

	public static void d(Node node) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.add(node);

		while (!que.isEmpty()) {
			Node n = que.poll();

			if (n.cost > dist[n.to])
				continue;

			for (int i = 0; i < adj.get(n.to).size(); i++) {
				Node t = adj.get(n.to).get(i);
				if (dist[t.to] > dist[t.from] + t.cost) {
					dist[t.to] = dist[t.from] + t.cost;
					t.cost = dist[t.to];
					que.add(t);
				}
			}
		}
	}
}
