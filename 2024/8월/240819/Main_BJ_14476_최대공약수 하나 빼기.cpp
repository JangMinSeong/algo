#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n;
vector<int> nums;
vector<int> Llist, Rlist;

int gcd(int a, int b);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		nums.push_back(num);
	}
	sort(nums.begin(), nums.end());
	Llist.push_back(nums.front());
	Rlist.push_back(nums.back());

	int leftGcd = Llist[0], rightGcd = Rlist[0];
	for (int i = 0; i < n - 1; i++) {
		int left = gcd(leftGcd, nums[i + 1]);
		int right = gcd(rightGcd, nums[n - 2 - i]);

		if (leftGcd > left) leftGcd = left;
		if (rightGcd > right) rightGcd = right;

		Llist.push_back(leftGcd);
		Rlist.push_back(rightGcd);
	}
	reverse(Rlist.begin(), Rlist.end());
	
	int ans1 = 0, ans2 = 0;
	if (nums[0] % Rlist[1] != 0) {
		ans1 = nums[0];
		ans2 = Rlist[1];
	}
	for (int i = 1; i < n - 1; i++) {
		int left = Llist[i - 1];
		int right = Rlist[i + 1];

		int g = gcd(left, right);
		if (nums[i] % left != 0 && nums[i] % right != 0 && g > ans2) {
			ans1 = nums[i];
			ans2 = g;
		}
	}
	if (nums[n - 1] % Llist[n - 2] != 0) {
		if (ans2 < Llist[n - 2]) {
			ans1 = nums[n - 1];
			ans2 = Llist[n - 2];
		}
	}

	if (ans1 == 0) cout << -1;
	else cout << ans2 << " " << ans1;

	return 0;
}

int gcd(int a, int b) {
	if (a < b) swap(a, b);

	return b ? gcd(b, a % b) : a;
}