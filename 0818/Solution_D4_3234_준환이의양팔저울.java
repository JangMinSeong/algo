package w0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_3234_준환이의양팔저울 {
	static int n;
	static boolean [] isUsed;
	static int [] weight;
	static int count;
	static int sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test_case;t++) {
			n = Integer.parseInt(br.readLine());
			isUsed = new boolean[n];
			weight = new int [n];
			count = 0;
			sum = 0;
			String [] temp = br.readLine().split(" ");
			
			for(int i=0;i<n;i++)  {
				weight[i] = Integer.parseInt(temp[i]);
				sum += weight[i];
			}
			
			for(int i=0;i<n;i++) {
				isUsed[i] = true;
				f(1,weight[i],0);
				isUsed[i] = false;
			}
			
			System.out.println("#" + t + " " + count);
		}
	}
	public static void f(int cnt, int leftWeight, int rightWeight) {
		if(cnt == n - 1)  {
			int rest = sum - leftWeight - rightWeight;
			if(leftWeight >= rightWeight + rest) count++;
			count++;
		}
		else {
			for(int i=0;i<n;i++) {
				if(isUsed[i] == true) continue;
				isUsed[i] = true;
				if(leftWeight >= rightWeight + weight[i])
					f(cnt+1, leftWeight, rightWeight + weight[i]);
				f(cnt+1, leftWeight+weight[i], rightWeight);
				isUsed[i] = false;
			}
		}
	}
}
