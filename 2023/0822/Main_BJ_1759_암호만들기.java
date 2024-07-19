package w0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main_BJ_1759_암호만들기 {
	static int l, c;
	static ArrayList<Character> cons;
	static ArrayList<Character> vow;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		l = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		
		String [] temp = br.readLine().split(" ");
		cons = new ArrayList<>(); 
		vow = new ArrayList<>();
		for(int i=0;i<c;i++) {
			char t = temp[i].charAt(0);
			if(t == 'a' || t=='e' || t=='i' || t=='o' || t=='u') vow.add(t);
			else cons.add(t);
		}
		cons.sort(null);
		vow.sort(null);
		cons.add((char)('z'+1));
		vow.add((char)('z'+1));
		if(!cons.isEmpty() && !vow.isEmpty())
			f(0,0,0,0,0,"");
	}
	
	public static void f(int cnt, int consIdx, int vowIdx, int consCnt, int vowCnt, String str) {
		if(cnt == l) {
			if(consCnt < 2 || vowCnt < 1) return;
			System.out.println(str);
			return;
		}	
		if(consIdx >= cons.size() || vowIdx >= vow.size()) return;

		if(vowIdx == vow.size() - 1 || cons.get(consIdx) < vow.get(vowIdx)) {
			if(consIdx != cons.size() - 1)
				f(cnt+1,consIdx+1,vowIdx,consCnt+1,vowCnt,str + cons.get(consIdx));
			f(cnt,consIdx+1,vowIdx,consCnt,vowCnt,str);
		}
		else if(consIdx == cons.size() - 1 || cons.get(consIdx) > vow.get(vowIdx)){
			if(vowIdx != vow.size() - 1)
				f(cnt+1,consIdx,vowIdx+1,consCnt,vowCnt+1,str + vow.get(vowIdx));
			f(cnt,consIdx,vowIdx+1,consCnt,vowCnt,str);
		}
	}
}
