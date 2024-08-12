#include<iostream>
#include<vector>

using namespace std;

int n, m;
int stu[100001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m;

	for (int i = 0; i <= n; i++) stu[i] = i;
	for (int i = 0; i < m; i++) {
		int first, second;
		cin >> first >> second;

		stu[first]++;
		stu[second]--;
	}

	bool isPos[100001] = { false, };
	for (int i = 1; i <= n; i++) {
		if (stu[i] <= 0 || stu[i] > n || isPos[stu[i]] == true) {
			cout << -1 << endl;
			return 0;
		}
		isPos[stu[i]] = true;
	}

	for (int i = 1; i <= n; i++) {
		cout << stu[i] << " ";
	}
	cout << endl;

	return 0;
}