package w0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_D3_1228_¾ÏÈ£¹®1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = 10;
		
		for(int t=1;t<=test_case;t++) {
			int init_length = Integer.parseInt(br.readLine());
			
			LinkedList<String> link = new LinkedList<>();		
			String [] str = br.readLine().split(" ");
			
			for(int i=0;i<init_length;i++) {
				link.add(str[i]);
			}
			
			int command_num = Integer.parseInt(br.readLine());
			String [] temp = br.readLine().split(" ");
			for(int i=0;i<temp.length;i++) {
				
				int start = Integer.parseInt(temp[i+1]);
				int num = Integer.parseInt(temp[i+2]);
				
				i += 3;
				for(int j = num-1;j >= 0;j--) {
						link.add(start,temp[i+j]);
				}
				i += num - 1;
			}
			
			System.out.print("#" + t + " ");
			for(int i=0;i<10;i++) {
				System.out.print(link.poll() + " ");
			}
			System.out.println();
		}
	}	
}
