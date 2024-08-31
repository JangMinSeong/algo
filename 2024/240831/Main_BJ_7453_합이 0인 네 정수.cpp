#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int n;
int nums[4][4001];
vector<int> ab, cd;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 4; j++) {
			cin >> nums[j][i];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			ab.push_back(nums[0][i] + nums[1][j]);
			cd.push_back(nums[2][i] + nums[3][j]);
		}
	}

	sort(ab.begin(), ab.end());
	sort(cd.begin(), cd.end());

	int front = 0, rear = cd.size() - 1;

	long long ans = 0;
	while(front < ab.size() && rear >= 0) {
		int sum = ab[front] + cd[rear];
		if (sum == 0) {
			int cntF = 0, cntR = 0;
			while (front < ab.size() && ab[front] == ab[front + cntF]) cntF++;
			while (rear >= 0 && cd[rear] == cd[rear - cntR]) cntR++;

			ans += (long long) cntF * cntR;
			front += cntF;
			rear -= cntR;
		}
		else if (sum < 0) {
			front++;
		}
		else {
			rear--;
		}
	}

	cout << ans << endl;

	return 0;
}