package w0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BJ_11286_Àý´ë°ªÈü {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		PriorityQueue<Integer> pos_pque = new PriorityQueue<>();
		PriorityQueue<Integer> neg_pque = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int t = Integer.parseInt(br.readLine());
			
			if(t == 0) {
				if(pos_pque.isEmpty() && neg_pque.isEmpty()) {
					System.out.println(0);
				}
				else if(pos_pque.isEmpty()) {
					System.out.println(neg_pque.poll() * (-1));
				}
				else if(neg_pque.isEmpty()) {
					System.out.println(pos_pque.poll());
				}
				else {	
					if(pos_pque.peek() >= neg_pque.peek()) {
						System.out.println(neg_pque.poll() * (-1));
					}
					else
						System.out.println(pos_pque.poll());
				}
			}
			else if(t > 0){
				pos_pque.add(t);
			}
			else {
				neg_pque.add(t*(-1));
			}
		}
	}
}
