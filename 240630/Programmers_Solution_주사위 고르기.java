import java.util.Arrays;
import java.util.HashMap;

class Solution {
    int [] diceA;
    int [] diceB;
    int [] numA;
    int [] numB;

    int [][] dices;
    boolean [] used;

    int n;
    int win, lose, draw;
    int tWin, tLose, tDraw;
    int max = 0;
    int [] ans;

    HashMap<Integer,int[]> mapA;

    public int[] solution(int[][] dice) {
        n = dice.length;
        dices = dice;
        init();

        pickDice(0,0);

        Arrays.sort(ans);

        return ans;
    }

    public void init() {
        win = lose = draw = 0;

        diceA = new int [n/2];
        diceB = new int [n/2];
        used = new boolean [n];

        numA = new int [n/2];
        numB = new int [n/2];

        ans = new int [n/2];
        mapA = new HashMap<>();
    }

    public void pickDice(int idx, int cnt) {
        if(cnt == n / 2) {
            // for(int i=0;i<n;i++) {
            //     System.out.print(used[i] + " ");
            // }
            // System.out.println();

            int idx1 = 0;
            int idx2 = 0;
            for(int i=0;i<n;i++) {
                if(used[i]) diceA[idx1++] = i;
                else diceB[idx2++] = i;
            }
            if(used[0] == true)
                calResult();
        }
        else {
            for(int i = idx; i < n; i++) {
                if(used[i] == true) continue;
                used[i] = true;
                pickDice(i, cnt+1);
                used[i] = false;
            }
        }
    }

    public void makeNumA(int cnt) {
        if(cnt == n/2) {
            int resultA = 0;
            for(int i=0;i<n/2;i++) {
                resultA += dices[diceA[i]][numA[i]];
            }

            int [] value = mapA.get(resultA);

            if(value == null) {
                tWin = 0;
                tLose = 0;
                tDraw = 0;

                makeNumB(0,resultA);

                int [] tmp = new int[2];
                tmp[0] = tWin;
                tmp[1] = tLose;
                win += tWin;
                lose += tLose;
                mapA.put(resultA,tmp);
            } else {
                win += value[0];
                lose += value[1];
            }

        }
        else {
            for(int i=0;i<6;i++) {
                numA[cnt] = i;
                makeNumA(cnt+1);
            }
        }
    }

    public void makeNumB(int cnt, int resultA) {
        if(cnt == n/2) {
            int resultB = 0;
            for(int i=0;i<n/2;i++) {
                resultB += dices[diceB[i]][numB[i]];
            }
            if(resultA > resultB) tWin++;
            else if(resultA == resultB) tDraw++;
            else tLose++;
        }
        else {
            for(int i=0;i<6;i++) {
                numB[cnt] = i;
                makeNumB(cnt+1, resultA);
            }
        }
    }

    public void calResult() {
        makeNumA(0);

        if(max < win) {
            max = win;
            for(int i=0;i<n/2;i++)
                ans[i] = diceA[i] + 1;
        }
        if(max < lose) {
            max = lose;
            for(int i=0;i<n/2;i++)
                ans[i] = diceB[i] + 1;
        }
        win = 0;
        draw = 0;
        lose = 0;
        mapA.clear();
    }
}