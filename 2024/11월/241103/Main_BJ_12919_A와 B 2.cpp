#include<iostream>
#include<algorithm>
#include<string>

using namespace std;

string str1, str2;

bool solve(string str);

int main() {
	cin >> str1;
	cin >> str2;

	if (solve(str2) == true) cout << 1;
	else cout << 0;

	return 0;
}

bool solve(string str) {
	if (str == str1) return true;
	if (str.length() <= str1.length()) return false;

	bool ch = false;
	if (str.front() == 'B') {
		string re = str.substr(1, str.length());
		reverse(re.begin(), re.end());
		ch |= solve(re);
	}
	if (str.back() == 'A') {
		ch |= solve(str.substr(0, str.length() - 1));
	}

	return ch;
}