#include<iostream>
#include<string>

using namespace std;

//                      0   1   2    3
string max_dp[101] = { "", "", "1", "7", };
string min_dp[101] = { "", "", "1", "7", "4", "2", "6", "8", };
//                      0   1   2    3    4    5    6    7
int main() {
	int test_case;
	cin >> test_case;

	for (int i = 4; i <= 100; i++) {
		if (i >= 8) {
			//min_dp °è»ê
			min_dp[i] = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
			for (int j = 2; j <= 7; j++) {
				if (i - j <= 1) continue;
				if (j == 6) {
					if (min_dp[i].length() == (min_dp[i - j] + "0").length())
						min_dp[i] = min(min_dp[i], min_dp[i - j] + "0");
					else if (min_dp[i].length() > (min_dp[i - j] + "0").length())
						min_dp[i] = min_dp[i - j] + "0";
				}
				else {
					if (min_dp[i].length() == (min_dp[i - j] + min_dp[j]).length())
						min_dp[i] = min(min_dp[i], min_dp[i - j] + min_dp[j]);
					else if (min_dp[i].length() > (min_dp[i - j] + min_dp[j]).length())
						min_dp[i] = min_dp[i - j] + min_dp[j];
				}
			}
		}

		if (i % 2 == 0)
			max_dp[i] = "1" + max_dp[i - 2];
		else
			max_dp[i] = "7" + max_dp[i - 3];
	}

	for (int t = 0; t < test_case; t++) {
		int n;

		cin >> n;
		cout << min_dp[n] << " " << max_dp[n] << endl;
	}
}