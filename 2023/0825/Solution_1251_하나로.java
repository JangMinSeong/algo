package w0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int to;
	long length;
	
	public Edge(int to, long length) {
		this.to = to;
		this.length = length;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return Long.compare(length, o.length);
	}
}

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_1251_ÇÏ³ª·Î {
	static int n;
	static double e;
	static ArrayList<Node> island;
	static boolean [] visited;
	static ArrayList<PriorityQueue<Edge>> adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test_case = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t <= test_case; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			visited = new boolean [n];
			island = new ArrayList<>();
			adj = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				PriorityQueue<Edge> temp = new PriorityQueue<>();
				adj.add(temp);
			}
			
			st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {	
				int x,y;
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st2.nextToken());
				island.add(new Node(x,y));
			}
			
			st = new StringTokenizer(br.readLine());
			e = Double.parseDouble(st.nextToken());
			makeAdj();
			
			System.out.println("#" + t + " " + (long)Math.round((f()*e)));
		}
	}
	
	public static long f() {
		long sum = 0;
		ArrayList<Integer> t = new ArrayList<>();
		
		t.add(0);
		visited[0] = true;
		while(t.size() != n) {
			long min = Long.MAX_VALUE;
			int idx = 0;
			for(int i=0;i<t.size();i++) {
				int node = t.get(i);
				while(visited[adj.get(node).peek().to] == true)
					adj.get(node).poll();
				if(min >= adj.get(node).peek().length) {
					min = adj.get(node).peek().length;
					idx = node;
				}
			}
			t.add(adj.get(idx).peek().to);
			visited[adj.get(idx).peek().to] = true; 
			sum += min;
			adj.get(idx).poll();
		}
		return sum;
	}
	
	public static void makeAdj() {
		for(int i=0;i<n;i++) {
			Node a = island.get(i);
			for(int j=0;j<n;j++) {
				if(i == j) continue;
				Node b = island.get(j);
				adj.get(i).add(new Edge(j, calDis(a,b)));
			}
		}
	}
	public static long calDis(Node a, Node b) {
		return (long)Math.pow(Math.abs(a.x - b.x),2) + (long)Math.pow(Math.abs(a.y - b.y),2);
	}
}
