class Solution {
    int [] cards;
    int coin;
    int n;
    int round = 1;
    int [] hands;
    int [] keep;

    public int solution(int coin, int[] cards) {
        int answer = 0;
        this.cards = cards;
        this.coin = coin;

        n = cards.length;
        hands = new int [n+1];
        keep = new int [n+1];

        solve();

        return round;
    }

    public void solve() {
        for(int i=0;i<n/3;i++) {
            hands[cards[i]] = 1;
            if(hands[n+1 - cards[i]] == 1) round++;
        }
        int idx = n/3;

        for(int i=0; i < round; i++, idx += 2) {
            keep[cards[idx]] = round;
            keep[cards[idx+1]] = round;
        }  //손에 있는 패만으로 볼 수 있는 카드

        for(int i=n/3;i<n;i++) {
            int ch = 0;
            for(int j=0;j<n/3;j++) {
                if(keep[n+1 - cards[j]] != 0 && coin > 0) {
                    keep[n+1 - cards[j]] = 0;
                    round++;
                    if(idx<n) {
                        keep[cards[idx]] = round;
                        keep[cards[idx+1]] = round;
                    }
                    idx+=2;
                    coin -= 1;
                    i = n/3;
                    ch = 1;
                }
            } //손 + 킵 -> 코인 1개 소비
            if (ch == 1) continue;
            if(keep[cards[i]] != 0){
                if(keep[n+1 - cards[i]] != 0 && coin > 1) {
                    keep[cards[i]] = 0;
                    round++;
                    if(idx<n){
                        keep[cards[idx]] = round;
                        keep[cards[idx+1]] = round;
                        idx+=2;
                    }
                    coin -= 2;
                    i=n/3;
                }
            }
        } //킵에서 2개 -> 코인 2개 소비

        if(round >= (n/3) + 1) round = n/3 + 1;
    }
}