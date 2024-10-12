#include<iostream>
#include<map>

using namespace std;

int n, k;
long long int sums[200001];
map<long long int, long long int> m;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;

	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;
		
		sums[i] = sums[i - 1] + num;
	}

	long long int cnt = 0;
	m[0] = 1;
	for (int i = 1; i <= n; i++) {
		cnt += m[sums[i] - k];
		m[sums[i]]++;
	}

	cout << cnt;

	return 0;
}