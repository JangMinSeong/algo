package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_1786_Ã£±â {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String p = br.readLine();
		int [] comp = new int [p.length() + 1];
		
		int idx = 0;
		for(int i=1;i<p.length();i++) {
			if(p.charAt(i) == p.charAt(idx)) 
				comp[i + 1] = ++idx;
			else {
				while(idx != 0) {
					if(p.charAt(idx) == p.charAt(i)) {
						comp[i+1] = ++idx;
						break;
					}
					idx = comp[idx];
				}if(idx == 0 && p.charAt(idx) == p.charAt(i)) {
					comp[i+1] = ++idx;
				}
			}
		}
		
		idx = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		int cnt = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == p.charAt(idx)) {
				idx++;
			}
			else {
				idx = comp[idx];
				while(idx != 0) {
					if(str.charAt(i) == p.charAt(idx)) {
						idx++;
						break;
					}
					idx = comp[idx];
				}
			}
			if(idx == p.length()) {
				cnt++;
				
				ans.add(i - idx + 2);
				idx -= 1;
				
				while(idx != 0) {
					idx = comp[idx];
					if(str.charAt(i) == p.charAt(idx)) {
						idx++;
						break;
					}			
				}
			}
		}
		
		System.out.println(cnt);
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
