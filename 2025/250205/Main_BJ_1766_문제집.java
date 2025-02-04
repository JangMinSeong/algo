package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Node implements Comparable<Node>{

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class Main_BJ_1766_문제집 {
	static int n,m;
	static ArrayList <Integer> [] adj;
	static int [] cnt;
	static PriorityQueue<Integer> ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		adj = new ArrayList[n+1];
		cnt = new int [n+1];
		ans = new PriorityQueue<>();
		
		for(int i=0;i<=n;i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj[from].add(to);
			cnt[to]++;
		}
		
		for(int i=1;i<=n;i++)
			if(cnt[i] == 0) ans.add(i);
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			int cur = ans.poll();
			sb.append(cur).append(" ");			
			for(int j : adj[cur]) {
				if((--cnt[j]) == 0) 
					ans.add(j);
			}
		}
		System.out.println(sb);
	}
}

