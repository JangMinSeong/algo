package w0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_1260_DFS¿ÍBFS {
	static int n, m, v;
	static ArrayList<ArrayList<Integer>> adj_mat;
	static boolean [] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		v = Integer.parseInt(str[2]);
		
		adj_mat = new ArrayList<> ();
		for(int i=0;i<=n;i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			adj_mat.add(temp);
		}
		
		for(int i=0;i<m;i++) {
			String [] temp = br.readLine().split(" ");
			int a, b;
			a = Integer.parseInt(temp[0]);
			b = Integer.parseInt(temp[1]);
			
			adj_mat.get(a).add(b);
			adj_mat.get(b).add(a);
		}
		for(int i=1;i<=n;i++) {
			adj_mat.get(i).sort(null);
		}
		isVisited = new boolean [n + 1];
		isVisited[v] = true;
		dfs(v, 0);
		System.out.println();
		isVisited = new boolean [n + 1];
		bfs(v);
		System.out.println();
	}
	
	public static void dfs(int v, int cnt) {
		if(cnt == n) return;
		
		System.out.print(v + " ");
		
		for(int i=0;i<adj_mat.get(v).size();i++) {
			if(isVisited[adj_mat.get(v).get(i)] == true) continue;
			isVisited[adj_mat.get(v).get(i)] = true;
			dfs(adj_mat.get(v).get(i) , cnt+1);
		}
	}
	public static void bfs(int v) {
		Queue<Integer> que = new LinkedList<>();
		que.add(v);
		isVisited[v] = true;
		System.out.print(v + " ");
		while(!que.isEmpty()) {
			int next = que.poll();
			for(int i=0;i<adj_mat.get(next).size();i++) {
				if(isVisited[adj_mat.get(next).get(i)] == true) continue;
				isVisited[adj_mat.get(next).get(i)] = true;
				System.out.print(adj_mat.get(next).get(i) + " ");
				que.add(adj_mat.get(next).get(i));
			}
		}
	}
}
