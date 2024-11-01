#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

string str;

int main() {
	cin >> str;

	string s = "";
	s += str[0];

	for (int i = 1; i < str.length(); i++) {
		if (s[i - 1] < str[i]) s = str[i] + s;
		else s = s + str[i];
	}

	reverse(s.begin(), s.end());
	cout << s;
}