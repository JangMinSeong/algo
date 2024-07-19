package w0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2839_º≥≈¡πË¥ﬁ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] dp = new int [5001];

		for(int i=0;i<=n;i++) dp[i] = 10000;
		dp[3] = dp[5] = 1;
		
		for(int i=6;i<=n;i++) {
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
		}
		
		if(dp[n] >= 10000) System.out.println(-1);
		else System.out.println(dp[n]);
		
	}
}
