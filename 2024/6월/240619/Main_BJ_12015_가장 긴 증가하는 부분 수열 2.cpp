#include<iostream>
#include<vector>

using namespace std;

int n;
vector<int> nums;

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);

	cin >> n;
	
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		

		if (nums.empty()) nums.push_back(num);
		else {
			if (nums.back() < num) nums.push_back(num);
			else {
				auto iter = lower_bound(nums.begin(), nums.end(), num);
				int idx = iter - nums.begin();
				nums[idx] = num;
			}
		}
	}

	cout << nums.size() << endl;
}