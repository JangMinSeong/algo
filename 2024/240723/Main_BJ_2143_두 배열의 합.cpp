#include <iostream>
#include <map>

using namespace std;

int t;
int n,m;
int numsA[1000], numsB[1000];
map<long long, long long> sumA;

int main() {
    cin >> t;

    cin >> n;
    for(int i=0;i<n;i++) {
        cin >> numsA[i];
    }
    cin >> m;
    for(int i=0;i<m;i++) {
        cin >> numsB[i];
    }

    for(int i=0;i<n;i++) {
        long long sum = 0;
        for(int j=i;j<n;j++) {
            sum += numsA[j];
            auto iter = sumA.find(sum);

            if(iter == sumA.end()) {
                sumA.insert({sum,1});
            }
            else {
                iter->second++;
            }
        } 
    }

    long long ans = 0;
    for(int i=0;i<m;i++) {
        long long sum = 0;
        for(int j=i;j<m;j++) {
            sum += numsB[j];
            auto iter = sumA.find(t - sum);

            if(iter != sumA.end()) {
                ans += iter->second;
            }
        } 
    }
    
    cout << ans;
    
    return 0;
}
