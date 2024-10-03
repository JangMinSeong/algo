#include<iostream>
#include<stack>
#include<string>
#include<algorithm>

using namespace std;

string input;
string bomb;
stack<char> st;

int main() {
	cin >> input;
	cin >> bomb;
	
	
	for (int i = 0; i < input.length(); i++) {
		st.push(input[i]);

		if (input[i] == bomb.back()) {
			string tmp = "";
			for (int j = bomb.length() - 1; j >= 0; j--) {
				char t = st.top();
				if (t == bomb[j]) tmp += t;
				else break;
				st.pop();
			}

			reverse(tmp.begin(), tmp.end());
			if (tmp != bomb) {
				for (int j = 0; j < tmp.length(); j++) {
					st.push(tmp[j]);
				}
			}
		}
	}

	string ans = "";
	while (!st.empty()) {
		ans += st.top();
		st.pop();
	}
	reverse(ans.begin(), ans.end());
	
	if (!ans.empty())
		cout << ans;
	else
		cout << "FRULA";

	return 0;
}