#include<iostream>

using namespace std;

int n;
int weight[31];
bool isPossible[40001] = { false, };

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	int sum = 0;
	for (int i = 0; i < n; i++) {
		cin >> weight[i];
		sum += weight[i];
	}
	
	isPossible[0] = true;
	for (int i = 0; i < n; i++) {
		for (int j = sum; j >= 0; j--) 
			if (isPossible[j]) isPossible[j + weight[i]] = true;
		for (int j = 0; j <= sum; j++)
			if (isPossible[j]) isPossible[abs(j - weight[i])] = true;
	}


	int m;
	cin >> m;
	for (int i = 0; i < m; i++) {
		int num;
		cin >> num;

		if (isPossible[num] == true) cout << "Y ";
		else cout << "N ";
	}
	cout << endl;

	return 0;
}