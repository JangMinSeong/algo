package w0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1463_1�θ���� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] dp = new int [n+1];
		dp[1] = 0;
		for(int i=1;i<=n;i++) {
			if(i * 2 <= n)
				dp[i*2] = dp[i*2] == 0 ? dp[i]+1 : Math.min(dp[i*2],dp[i] + 1);
			if(i*3 <= n)
				dp[i*3] = dp[i*3] == 0 ? dp[i]+1 : Math.min(dp[i*3], dp[i] + 1);
			if(i+1 <= n)
				dp[i+1] = dp[i+1] == 0 ? dp[i]+1 : Math.min(dp[i+1], dp[i] + 1);
		}
		
		System.out.println(dp[n]);
	}
}
