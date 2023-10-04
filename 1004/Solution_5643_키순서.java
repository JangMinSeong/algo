package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_5643_Å°¼ø¼­ {
	static int n, m;
	static ArrayList<ArrayList<Integer>> [] adj;
	static boolean [] visited;
	static int vCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<=test_case;t++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			
			
			adj = new ArrayList [2];
			adj[0] = new ArrayList<>();
			adj[1] = new ArrayList<>();
			
			for(int i=0;i<=n;i++) {
				ArrayList<Integer> temp = new ArrayList<>();
				adj[0].add(temp);
				ArrayList<Integer> temp2 = new ArrayList<>();
				adj[1].add(temp2);
			}
			
			for(int i=0;i<m;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adj[0].get(a).add(b); //small
				adj[1].get(b).add(a); //big

			}
			
			int cnt = 0;
			for(int i=1;i<=n;i++) {
				vCnt = 0;
				visited = new boolean [n+1];
				dfs(i,0);
				dfs(i,1);
				if(vCnt == n-1) cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
	
	public static void dfs(int node, int option) {	
		for(int i=0;i<adj[option].get(node).size();i++) {
			int t = adj[option].get(node).get(i);
			if(visited[t] == true) continue;
			vCnt++;
			visited[t] = true;
			dfs(t,option);
		}
	}
}
