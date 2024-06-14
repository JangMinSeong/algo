#include<iostream>
#include<string>
#include<vector>

using namespace std;

string str1, str2;
int ans;
int tb[1001][1001];

int main() {
	cin >> str1 >> str2;

	for (int i = 1; i <= str1.length(); i++) {
		for (int j = 1; j <= str2.length(); j++) {
			if (str1[i-1] == str2[j-1]) {
				tb[i][j] = tb[i - 1][j - 1] + 1;
			}
			else {
				tb[i][j] = max(tb[i - 1][j], tb[i][j - 1]);
			}
			if (ans < tb[i][j]) ans = tb[i][j];
		}
	}

	cout << ans << endl;
}