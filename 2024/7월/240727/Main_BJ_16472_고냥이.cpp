#include<iostream>
#include<string>
#include<map>

using namespace std;

int n;
string str;

int alpa[26];

int s = 0, e = 0;
int ans;

int main() {
	cin >> n;
	cin >> str;

	int temp = 0;
	while(e < str.length()) {
		if (temp <= n) {
			int cur = str[e] - 'a';
			if (alpa[cur] == 0) {
				temp++;
			}
			alpa[cur]++;
			e++;
		}

		else {
			int cur = str[s] - 'a';
			if (alpa[cur] == 1) {
				temp--;
			}
			alpa[cur]--;
			s++;
		}

		if (ans < e - s && temp <= n) ans = e - s;
	}

	cout << ans;
}