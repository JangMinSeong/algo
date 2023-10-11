package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_14510_나무높이 {
	static int [] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1; t <= test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			String [] str = br.readLine().split(" ");
			tree = new int [n];
			int max = 0;
				
			for(int i=0;i<n;i++) {
				tree[i] = Integer.parseInt(str[i]);
				if(max < tree[i]) max = tree[i];
			}
			
			int cnt1 = 0;
			int cnt2 = 0;
			int ans = 0;
			for(int i=0;i<n;i++) {
				int gap = max - tree[i];
				cnt1 += gap % 2;
				cnt2 += gap / 2;
			}
			while(cnt1 < cnt2 - 1) {
				cnt1 += 2;
				cnt2--;
			}
			if(cnt1 > cnt2) ans--;
			ans += Math.max(cnt1, cnt2) * 2;
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
