#include<iostream>
#include<string>
#include<set>

using namespace std;

int n, m;
int k;
string str[51];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> str[i];
	}
	cin >> k;

	int ans = 0;
	set<int> skip;
	for (int i = 0; i < n; i++) {
		if (skip.find(i) != skip.end()) continue; 
		
		int cnt = 0;
		for (int j = 0; j < m; j++) {
			if (str[i][j] == '0') cnt++;
		}
		if (cnt <= k && (k - cnt) % 2 == 0) {
			int cntL = 0;
			for (int j = 0; j < n; j++) {
				if (str[i] == str[j]) {
					cntL++;
					skip.insert(j);
				}
			}
			if (ans < cntL) ans = cntL;
		}
	}

	cout << ans;
}