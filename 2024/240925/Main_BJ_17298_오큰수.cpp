#include<iostream>
#include<stack>

using namespace std;

int n;
stack<int> st;
int nums[1000001];
int ans[1000001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> nums[i];
		ans[i] = -1;
	}

	for (int i = n - 1; i >= 0; i--) {
		if (st.empty()) {
			st.push(nums[i]);
			continue;
		}

		int t = st.top();
		if (nums[i] >= t) {
			while (!st.empty() && st.top() <= nums[i]) st.pop();
			if (!st.empty()) ans[i] = st.top();			
		}
		else 
			ans[i] = t;
		
		st.push(nums[i]);
	}

	for (int i = 0; i < n; i++)
		cout << ans[i] << " ";

	return 0;
}