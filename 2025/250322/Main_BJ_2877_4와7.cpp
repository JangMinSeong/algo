#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int n;
string str1 = "";
string str2 = "";
string ans = "";

void cal(int num);

int main() {
	cin >> n;

	int t = 1;
	int sum = 0;
	int prev_sum = 0;
	while (1) {
		sum += 1 << t;
		t++;
		if (sum >= n) break;
		prev_sum = sum;
	}	
	t = t - 1;
	int r = n - prev_sum - 1;

	for (int i = 0; i < t; i++)
		str2 = str2 + '0';

	cal(r);
	for (int i = str1.size(); i < t; i++) str1.push_back('0');
	reverse(str1.begin(), str1.end());

	for (int i = 0; i < t; i++) {
		int num = (str1[i] - '0') + (str2[i] - '0');

		if (num == 1) ans.push_back('7');
		else ans.push_back('4');
	}
	cout << ans;
}

void cal(int num) {
	if (num == 0) return;

	if (num % 2 == 0) str1.push_back('0');
	else str1.push_back('1');

	cal(num / 2);
}