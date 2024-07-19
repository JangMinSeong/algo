package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_6808_규영이와인영이의카드게임 {
	static int [] card;
	static int [] inCard;
	static int [] gyuCard;
	static int [] nums;
	static boolean [] isUsed;
	static int win_count;
	static int lose_count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		for(int t=1;t<=test_case;t++) {
			
			nums = new int [9];
			card = new int [19];
			isUsed = new boolean [9];
			inCard = new int [9];
			gyuCard = new int [9];
			win_count = 0;
			lose_count =0;
			
			String [] str = br.readLine().split(" ");
			for(int i=0;i<9;i++) {
				card[Integer.parseInt(str[i])]++;
				gyuCard[i] = Integer.parseInt(str[i]);
			}
			for(int i=1,idx=0;i<=18;i++) {
				if(card[i] == 0)
					inCard[idx++] = i;
			}
			
			f(0);
			System.out.println("#" + t + " " + win_count + " " + lose_count);
		}
	}
	
	public static int isWin() {
		int inScore =0;
		int gyuScore = 0;
		
		for(int i=0;i<9;i++) {
			if(inCard[nums[i]] > gyuCard[i]) {
				inScore += inCard[nums[i]] + gyuCard[i];
			}
			else
				gyuScore += inCard[nums[i]] + gyuCard[i];
		}
		
		if(inScore > gyuScore) return 1;
		else if (inScore < gyuScore) return 2;
		else return 0;
		
	}
	
	public static void f(int cnt) {
		if(cnt == 9) {		
			if(isWin() == 2) win_count++;
			else lose_count++;
		}
		else {
			for(int i=0;i<9;i++) {
				if(isUsed[i] == true) continue;
				isUsed[i] = true;
				nums[cnt] = i;
				f(cnt+1);
				isUsed[i] = false;
			}
		}
	}
}
