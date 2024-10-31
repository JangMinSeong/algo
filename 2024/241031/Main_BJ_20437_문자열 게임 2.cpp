#include<iostream>
#include<string>
#include<cstring>
#include<vector>

using namespace std;

vector<int> pos[27];

int main() {
	int t;
	cin >> t;
	for (int test_case = 0; test_case < t; test_case++) {
		string str;
		int k;
		cin >> str;
		cin >> k;

		for (int i = 0; i < 27; i++)
			pos[i].clear();

		int max = -1;
		int min = 10000000;

		for (int i = 0; i < str.length(); i++) {
			int idx = str[i] - 'a';
			pos[idx].push_back(i);

			int s = pos[idx].size();
			if (s >= k) {
				int dis = i - pos[idx][s - k];
				if (dis < min) min = dis;
				if (dis > max) max = dis;
			}
		}
		if (max == -1) cout << -1 << endl;
		else cout << min + 1 << " " << max + 1 << endl;
	}
}