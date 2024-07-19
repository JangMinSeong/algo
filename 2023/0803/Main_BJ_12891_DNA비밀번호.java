package w0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_12891_DNA비밀번호 {
	static int s,p;
	static int [] DNA_count = new int[4];
	static String s_dna;
	static int result = 0;
	static int [] min_num = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String [] str = bf.readLine().split(" ");
		s = Integer.parseInt(str[0]);
		p = Integer.parseInt(str[1]);
		
		s_dna = bf.readLine();
		
		String [] temp = bf.readLine().split(" ");
		for(int i=0;i<4;i++) {
			min_num[i] = Integer.parseInt(temp[i]);
		}
		
		solve();
		
		System.out.println(result);
	}
	
	public static boolean isPossible() {
		for(int i=0;i<4;i++) {
			if(DNA_count[i] < min_num[i]) return false; 
		}
		return true;
	}
	
	public static void solve() {
		for(int i=0;i<p;i++) {
			DNA_count[toInt(s_dna.charAt(i))]++;
		}
		
		for(int i = p; i < s; i++) {
			if(isPossible()) result++;
			DNA_count[toInt(s_dna.charAt(i-p))]--;
			DNA_count[toInt(s_dna.charAt(i))]++;
		}
		if(isPossible()) result++;
	}
	
	public static int toInt(char dna) {
		switch(dna) {
		case 'A': return 0;
		case 'C': return 1;
		case 'G': return 2;
		case 'T': return 3;
		}
		return 4;
	}
}
