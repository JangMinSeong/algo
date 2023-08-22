package w0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_13023_친구관계파악하기 {
	static ArrayList<ArrayList<Integer>> adj;
	static int n,m;
	static boolean [] visited;
	static boolean done;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		adj = new ArrayList<>();
		for(int i=0;i<n;i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			adj.add(temp);
		}
		
		for(int i=0;i<m;i++) {
			String [] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		visited = new boolean [n];
		for(int i=0;i<n;i++) {
			if(done == true) break; 
			dfs(i,0);
		}
		System.out.println(done?1:0);
	}
	
	public static void dfs(int node, int depth) {
		if(done == true) return;
		if(depth == 4) { done = true; return; }	
		
		visited[node] = true;
		for(int i=0;i<adj.get(node).size();i++) {
			int t = adj.get(node).get(i);
			if(visited[t] == true) continue;
			visited[t] = true;
			dfs(t,depth + 1);	
			visited[t] = false;
		}			
		visited[node] = false;
	}
}
