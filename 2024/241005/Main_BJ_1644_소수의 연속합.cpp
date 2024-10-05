#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

int n;
bool isPrime[4000001] = { false, };
vector<int> prime;

int main() {

	cin >> n;
	for (int i = 2; i <= sqrt(n); i++) {
		int num = i;
		int cnt = 2;
		while (num * cnt <= n) {
			isPrime[num * cnt] = true;
			cnt++;
		}
	}
	for (int i = 2; i <= n; i++)
		if (isPrime[i] == false) prime.push_back(i);

	int ans = 0;

	for(int i=0;i<prime.size();i++){
		if (prime[i] > n) break;
		int sum = 0;
		for (int j = i; j < prime.size(); j++) {
			sum += prime[j];
			if (sum > n) break;
			else if (sum == n) {
				ans++;
				break;
			}
		}
	}

	cout << ans;
	return 0;
}