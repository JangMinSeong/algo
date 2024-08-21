#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int n, k;
vector<int> gap;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> k;
	int prev;
	cin >> prev;
	for (int i = 1; i < n; i++) {
		int num;
		cin >> num;
		gap.push_back(num - prev);
		prev = num;
	}
	sort(gap.begin(), gap.end(), greater<>());

	int sum = 0;
	for (int i = k - 1; i < gap.size(); i++)
		sum += gap[i];

	cout << sum << endl;
}