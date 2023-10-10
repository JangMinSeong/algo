package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_7465_창용마을무리의개수 {
	static int ans;
	static int n,m;
	static boolean [] visited;
	static ArrayList<ArrayList<Integer>> adj; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test_case; t++) {
			String [] str= br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			
			visited = new boolean[n + 1];
			adj = new ArrayList<>();
			for(int i = 0;i <= n;i++) {
				adj.add(new ArrayList<>());
			}
			
			for(int i=0;i<m;i++) {
				str = br.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				
				adj.get(a).add(b);
				adj.get(b).add(a);
			}
			ans = 0;
			for(int i=1;i<=n;i++) {
				if(visited[i] == false) { 
					bfs(i);
					ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	public static void bfs(int node) {
		Queue<Integer> que = new LinkedList<>();
		que.add(node);
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int i=0;i<adj.get(temp).size();i++) {
				int t = adj.get(temp).get(i);
				if(visited[t] == true) continue;
				visited[t] = true;
				que.add(t);
			}
		}
	}
}
