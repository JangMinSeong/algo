package w0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_15961_»∏¿¸√ π‰ {
	static int [] num;
	static int [] cnt;
	static Queue<Integer> window;
	static int n,d,k,c;
	static int isC;
	static int maxCount;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		cnt = new int [d+1];
		num = new int [k];
		window = new LinkedList<>();
		for(int i=0;i<n + k;i++) {
			int temp;	
			if(i < n) {
				st = new StringTokenizer(br.readLine());
				temp = Integer.parseInt(st.nextToken());
			}
			else {
				temp = num[i-n];
			}
			if(i < k) num[i] = temp;
			window.add(temp);
			if(cnt[temp]++ == 0) count++;
			
			if(window.size() > k) {
				int front = window.poll();
				cnt[front]--;
				if(cnt[front] == 0) count--;
			}
			int coup = cnt[c] == 0 ? 1 : 0;
			if(maxCount < count + coup) maxCount = count + coup;
		}

		System.out.println(maxCount);
	}
}
