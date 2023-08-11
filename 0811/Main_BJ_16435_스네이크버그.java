package w0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main_BJ_16435_스네이크버그 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int l = Integer.parseInt(str[1]);
		
		String [] temp = br.readLine().split(" ");
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(temp[i]));
		}
		arr.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});
		
		for(int i=0;i<n;i++) {
			if(l >= arr.get(i)) l++;
		}
		System.out.println(l);
	}
}
