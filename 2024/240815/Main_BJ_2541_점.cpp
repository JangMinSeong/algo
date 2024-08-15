#include<iostream>

using namespace std;

int a, b;
int gap;
bool check(int x, int y);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> a >> b;

	gap = abs(a - b);
	if(gap != 0)
		while (gap % 2 == 0) gap /= 2;

	for (int i = 0; i < 5; i++) {
		int x, y;
		cin >> x >> y;

		if (check(x, y)) cout << "Y\n";
		else cout << "N\n";
	}
}

bool check(int x, int y) {
	int gap2 = abs(x - y);

	if ((a <= b && x > y) || (a > b && x <= y)) return false;
	if (gap2 * gap == 0) {
		if (gap == 0 && gap2 == 0) return true;
		else return false;
	}
	if (gap2 % gap == 0) return true;
	return false;
}