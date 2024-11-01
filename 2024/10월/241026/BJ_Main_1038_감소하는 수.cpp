#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n;
vector<long long int> nums;

void dfs(long long int num);

int main() {
	nums.push_back(0);

	for (int i = 1; i <= 9; i++) {
		dfs(i);
	}
	sort(nums.begin(), nums.end());

	cin >> n;
	if (nums.size() <= n)  cout << -1;
	else cout << nums[n];
	return 0;
}

void dfs(long long int num) {
	nums.push_back(num);

	int last = num % 10;
	for (int i = last - 1; i >= 0; i--) {
		dfs(num * 10 + i);
	}
}