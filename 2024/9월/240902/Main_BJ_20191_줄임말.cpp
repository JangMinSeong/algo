#include<iostream>
#include<string>
#include<vector>
#include<algorithm>

using namespace std;

string s, t;
vector<int> alpha[26];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> s >> t;

	for (int i = 0; i < t.length(); i++) {
		alpha[t[i] - 'a'].push_back(i);
	}

	int prev = -1;
	int ans = 1;
	for (int i = 0; i < s.length(); i++) {
		int pos = s[i] - 'a';

		if (alpha[pos].empty() == true) {
			cout << -1;
			return 0;
		}

		auto it = upper_bound(alpha[pos].begin(), alpha[pos].end(), prev);
		if (it == alpha[pos].end()) {
			ans++;
			prev = alpha[pos].front();
		}
		else {
			prev = *it;
		}
	}

	cout << ans;

	return 0;
}