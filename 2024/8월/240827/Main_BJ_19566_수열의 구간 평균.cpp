#include<iostream>
#include<vector>
#include<map>

using namespace std;

int n, k;
vector<long long> sums;
map<long long, long long> m;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;

	sums.push_back(0);

	long long ans = 0;
	long long sum = 0;
	m[0] = 1;
	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;

		sum += num;
		sums.push_back(sum);

		long long diff = sums[i] - ((long long)(k)*i);
		
		auto iter = m.find(diff);
		if (iter != m.end()) {
			ans += iter->second;
			iter->second++;
		}
		else {
			m.insert({ diff,1 });
		}

	}

	cout << ans;

	return 0;
}