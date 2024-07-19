package w0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		Queue<Integer> list = new LinkedList<>();
		for(int i=1;i<=n;i++) 
			list.add(i);
		
		int t = 0;
		System.out.print("<");
		while(true) {
			int num = list.poll();
			t++;
			if(list.isEmpty()) {
				System.out.print(num);
				break;
			}
			if(t%k == 0) System.out.print(num + ", ");
			else list.add(num);
		}
		System.out.println(">");
	}
}
