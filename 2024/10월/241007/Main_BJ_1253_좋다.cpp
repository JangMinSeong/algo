#include<iostream>
#include<algorithm>

using namespace std;

int n;
int nums[2001];


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> nums[i];
	}
	sort(nums, nums + n);

	int cnt = 0;
	for (int i = 0; i < n;i++){
		int num = nums[i];
		int left = 0, right = n - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == num){
				if (left != i && right != i) {
					cnt++;
					break;
				}
			}
			else if (sum < num) left++;
			else right--;

			if (left == i) left++;
			else if (right == i) right--;
		
		}
	}

	cout << cnt;
}