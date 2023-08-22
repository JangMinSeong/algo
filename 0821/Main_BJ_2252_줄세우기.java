package w0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_2252_줄세우기 {
	static ArrayList<ArrayList<Integer>> adj;
	static int n,m;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		adj = new ArrayList<>();
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			ArrayList <Integer> temp = new ArrayList<>();
			adj.add(temp);
		}
		for(int i=0;i<m;i++) {
			String [] temp = br.readLine().split(" ");
			int a, b;
			a = Integer.parseInt(temp[0]) - 1;
			b = Integer.parseInt(temp[1]) - 1;
			adj.get(b).add(a);
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i] == true) continue;
			dfs(i);			
		}
		System.out.println();
	}
	public static void dfs(int node) {
		if(visited[node] == true) return;
		if(adj.get(node).size() == 0) {
			visited[node] = true;
			System.out.print((node+1) + " ");
			return;
		}
		for(int i=0;i<adj.get(node).size();i++) {
			if(visited[node] == true) continue;
			dfs(adj.get(node).get(i));		
		}			
		visited[node] = true;
		System.out.print((node+1) + " ");
	}
}
