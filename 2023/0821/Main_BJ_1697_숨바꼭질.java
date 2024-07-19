package w0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_1697_¼û¹Ù²ÀÁú {
	static int n,k;
	static int [] dp;
	static Queue<Integer> que;
	static int [] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		k = Integer.parseInt(str[1]);
		int gap = Math.abs(n-k) + 1;
		
		que = new LinkedList <>();
		isVisited = new int [k + gap];
		
		que.add(n);
		isVisited[n] = 0;
		while(!que.isEmpty()) {
			int t = que.poll();
			if(t == k) break;
			if(t - 1 >= 0 && isVisited[t-1] == 0) {
				isVisited[t-1] = isVisited[t] + 1;
				que.add(t-1);
			}
			if(t + 1 < k + gap && isVisited[t+1] == 0) {
				isVisited[t+1] = isVisited[t] + 1;
				que.add(t+1);
			}
			if(t * 2 < k + gap && isVisited[t*2] == 0) {
				isVisited[t * 2] = isVisited[t] + 1;
				que.add(t*2);
			}
		}
		System.out.println(isVisited[k]);
	}
}
