package w0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_17471_°Ô¸®¸à´õ¸µ {
	static int n;
	static boolean [] isUsed;
	static int [] p;
	static ArrayList<ArrayList<Integer>> adj;
	static int min = Integer.MAX_VALUE;
	static boolean [] isVisited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		isUsed = new boolean[n + 1];
		p = new int [n + 1];
		
		String [] str = br.readLine().split(" ");
		for(int i=0;i<n;i++)
			p[i] = Integer.parseInt(str[i]);
		
		adj = new ArrayList<>();
		for(int i=0;i<n;i++) {
			str = br.readLine().split(" ");
			int k = Integer.parseInt(str[0]);
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j=1;j<=k;j++) 
				temp.add(Integer.parseInt(str[j]) - 1);
			adj.add(temp);
		}
		
		for(int i=1;i<=n/2;i++) {
			comp(0,0,i);
		}
		System.out.println(min == Integer.MAX_VALUE?-1:min);
	}
	public static void comp(int cnt, int idx, int num) {
		if(cnt == num) {
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			int sumA = 0;
			int sumB = 0;
			for(int i=0;i<n;i++) {
				if(isUsed[i]) { A.add(i); sumA += p[i]; }
				else { B.add(i); sumB += p[i]; }
			}
			
			isVisited = new boolean[n];
			if(dfs(A.get(0),A) == true && dfs(B.get(0),B) == true) {		
				if(min > Math.abs(sumA - sumB)) min = Math.abs(sumA - sumB);
			}
		}
		else {
			for(int i=idx;i<n;i++) {
				if(isUsed[i] == true) continue;
				isUsed[i] = true;
				comp(cnt+1, i, num);
				isUsed[i] = false;
			}
		}
	}
	public static boolean dfs(int node, ArrayList<Integer> t) {
		int count = 0;
		isVisited[node] = true;
		for(int i=0;i<t.size();i++) 
			if(isVisited[t.get(i)] == true) count++;
		if(count == t.size()) return true;
		
		boolean done = false;
		for(int i=0;i<adj.get(node).size();i++) {
			int temp = adj.get(node).get(i);
			for(int j=0;j<t.size();j++) {
				if(temp == t.get(j) && isVisited[temp] == false) {
					isVisited[temp] = true;
					done = dfs(temp, t);
					if(done == true) return done;
				}
			}
		}
		
		return false;
	}
}
