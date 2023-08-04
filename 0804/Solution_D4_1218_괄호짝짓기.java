package w0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218_°ýÈ£Â¦Áþ±â {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = 10;
		
		for(int t = 1; t<= test_case; t++) {
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> sta = new Stack<>();
			int isVaild = 1;
			
			for(int i = 0; i < length; i++) {
				char c = str.charAt(i);
				switch(c) {
				case '<':
				case '(':
				case '{':
				case '[': sta.push(str.charAt(i)); break;
				case '>':
				case ')':
				case '}':
				case ']': 
					if(sta.isEmpty()) {
						isVaild = 0;
						break;
					}
					char temp = sta.pop(); 
					if(Math.abs(temp - c) > 2) {
						isVaild = 0;
					}
					break;
				}
				if(isVaild == 0) break;
			}
			System.out.println("#" + t + " " + isVaild);
		}
	}
}
