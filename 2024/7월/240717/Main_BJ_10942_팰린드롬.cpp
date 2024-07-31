#include<iostream>
#include<vector>

using namespace std;

int n,m;
int nums[2001];
int isPal[2001][2001];

void checkPal(int s, int e);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> nums[i];
		isPal[i][i] = 2;
	}

	for (int i = 1; i <= n; i++) {
		for (int j = i + 1; j <= n; j++) {
			if(isPal[i][j] == 0)
				checkPal (i, j);
		}
	}

	cin >> m;
	for (int i = 0; i < m; i++) {
		int s, e;
		cin >> s >> e;

		if (isPal[s][e] == 2) cout << "1\n";
		else cout << "0\n";
	}
}

void checkPal(int s, int e) {
	for (int i = 0; i <= (s + e) / 2 - s; i++) {
		isPal[s + i][e - i] = 1;
		if (nums[s + i] != nums[e - i]) return;
	}

	for (int i = 0; i <= (s + e) / 2 - s; i++) {
		isPal[s + i][e - i] = 2;
	}

	return;
}