package w0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_2493_ž {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String [] str = br.readLine().split(" ");
		int [] result = new int [n];
		Stack <Integer> sta = new Stack<>();
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(str[i]);
			if(sta.isEmpty()) sta.push(i + 1);
			else {
				while(Integer.parseInt(str[sta.peek() - 1]) < num) {
					sta.pop();
					if(sta.isEmpty()) { break; }
				}
				if(!sta.isEmpty())
					result[i] = sta.peek();
				sta.push(i + 1);
			}
			System.out.print(result[i] + " ");
		}
	}	
}
