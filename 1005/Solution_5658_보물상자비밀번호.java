package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_5658_보물상자비밀번호 {
	static int n, k;
	static Set<Integer> set;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test_case; t++) {
			String [] input = br.readLine().split(" ");
			String str = br.readLine();
			
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			
			set = new HashSet<>();
			
			f(str);
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()) {
				pq.add(it.next());
			}
			
			int ans = 0;
			for(int i=0;i<k;i++) {
				ans = pq.poll();
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	public static void f(String str) {
		for(int round = 0; round < n/4; round++) {
			for(int i=0;i<4;i++) {
				int num = 0;
				
				for(int j=0;j<n/4;j++) {
					int idx = (i*(n/4)) + j + round;
					if(idx >= n) idx = idx - n;
					num = (num * 16) + toInt(str.charAt(idx));
				}
				set.add(num);
			}
		}
	}
	
	public static int toInt(char a) {
		if(a >= '0' && a <= '9') return a - '0';
		switch(a) {
		case 'A': return 10;
		case 'B': return 11;
		case 'C': return 12;
		case 'D': return 13;
		case 'E': return 14;
		default : return 15;
		}
	}
}
