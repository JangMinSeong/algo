package w0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D3_1225_암호생성기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = 10;
		
		for(int t=1;t<=test_case;t++) {
			int case_num = Integer.parseInt(br.readLine());
			String [] str = br.readLine().split(" ");	
			Queue<Integer> que = new LinkedList<>();
			
			for(int i=0;i<8;i++) {
				que.add(Integer.parseInt(str[i]));
			}
			
			int decrease = 1;
			while(true) {	
				int num = que.poll();
				num -= decrease;
				if(num <= 0) break;
				que.add(num);
				decrease = (decrease % 5) + 1;
			}
			
			System.out.print("#" + t + " ");
			for(int i=0;i<7;i++) {
				System.out.print(que.poll() + " ");
			}
			System.out.println(0);
		}
	}
}
