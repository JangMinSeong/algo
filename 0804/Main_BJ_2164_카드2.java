package w0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_2164_Ä«µå2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> que = new LinkedList<>(); 
		for(int i=1;i<=n;i++) 
			que.add(i);
		if(n == 1) { System.out.println(1); return;}
		while(true) {
			que.poll();
			if(que.size() == 1) break;
			int num = que.poll();
			que.add(num);
		}
		System.out.println(que.poll());
	}	
}
