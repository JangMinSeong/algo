#include<iostream>
#include<string>
#include<algorithm>
#include<stack>

using namespace std;

int n, k;
string str;
stack<char> st;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;
	cin >> str;

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		while (!st.empty() && cnt < k) {
			if (st.top() < str[i]) {
				cnt++;
				st.pop();
			}
			else {
				break;
			}
		}
		st.push(str[i]);
	}

	while (cnt < k) {
		cnt++;
		st.pop();
	}
	string ans = "";
	while (!st.empty()) {
		ans += st.top();
		st.pop();
	}
	reverse(ans.begin(), ans.end());
	
	cout << ans;

	return 0;
}