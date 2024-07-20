#include<iostream>
#include<cmath>

using namespace std;

int n;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	long long sx, sy;
	cin >> sx >> sy;

	long long value1 = 0, value2 = 0;
	pair<long long, long long> prev;
	prev = make_pair(sx, sy);;
	for (int i = 1; i < n; i++) {
		long long x, y;
		cin >> x >> y;

		value1 += prev.first * y;
		value2 += prev.second * x;

		prev = make_pair(x, y);
	}

	value1 += prev.first * sy;
	value2 += prev.second * sx;

	double area = abs(value1 - value2) / 2.0;

	double ans = floor(area * 10 + 0.5) / 10;

	cout << fixed;
	cout.precision(1);
	cout << ans;
}