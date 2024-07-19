package w0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1238_Contact {
	
	static ArrayList<HashSet<Integer>> adj;
	static int [] visited;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = 10;
		for(int t=1;t<=test_case;t++) {
			String [] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int start = Integer.parseInt(str[1]);
			
			adj = new ArrayList<>();
			for(int i=0;i<101;i++) {
				HashSet<Integer> temp = new HashSet<>();
				adj.add(temp);
			}
			visited = new int [101];
			
			str = br.readLine().split(" ");
			for(int i=0;i<a/2;i++) {
				int from = Integer.parseInt(str[(i*2) + 0]);
				int to = Integer.parseInt(str[(i*2) + 1]);
				adj.get(from).add(to);
			}
			
			System.out.println("#" + t + " " + bfs(start));
		}
	}
	public static int bfs(int node) {
		Queue<Integer> que = new LinkedList<>();
		int max = node;
		int maxCnt = 0;
		que.add(node);
		while(!que.isEmpty()) {
			int temp = que.poll();
			Iterator<Integer> it = adj.get(temp).iterator();
			while(it.hasNext()) {
				int t = it.next();
				if(visited[t] != 0) continue;
				visited[t] = visited[temp] + 1;
				que.add(t);
				if(visited[t] > maxCnt) {
					max = t;
					maxCnt = visited[t];
				}
				else if(visited[t] == maxCnt && t > max) {
					max = t;
				}
			}		
		}
		return max;
	}
}
