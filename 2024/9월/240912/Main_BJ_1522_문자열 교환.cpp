#include<iostream>
#include<string>

using namespace std;

string str;

int main() {
	cin >> str;
	
	int cntA = 0;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] == 'a') cntA++;
	}

	int ans = 10000;
	for (int i = 0; i < str.length(); i++) {
		int cntB = 0;
		for (int j = 0; j < cntA; j++) {
			int idx = (i + j) % str.length();

			if (str[idx] == 'b') cntB++;
		}
		if (cntB < ans) ans = cntB;
	}

	cout << ans;

	return 0;
}