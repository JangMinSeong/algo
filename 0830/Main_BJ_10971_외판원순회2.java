package w0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_10971_외판원순회2 {
	static int n;
	static int [][] adj;
	static boolean [] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		adj = new int [n][n];
		visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			String [] str = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				adj[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i=0;i<n;i++) {
			visited[i] = true;
			dfs(0,0,i,i);
			visited[i] = false;
		}
		System.out.println(min);
	}
	
	public static void dfs(int depth, int cost, int node, int start) {
		if(cost > min) return;
		if(depth == n - 1) {
			if(adj[node][start] == 0) return;
			cost += adj[node][start];
			if(cost < min) min = cost;
		}
		else {
			for(int i=0; i<n;i++) {
				if(visited[i] == true || adj[node][i] == 0) continue;
				visited[i] = true;
				dfs(depth+1, cost + adj[node][i], i,start);
				visited[i] = false;
			}
		}
	}
}
