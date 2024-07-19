#include<iostream>
#include<string>
#include<stack>

using namespace std;

int n;
string str;

char op[10];
pair<int, int> dp[10][10];  // i��° �� ~ j��° �� �� �� <�ִ�, �ּ�>

pair<int, int> calMaxMin(char op, pair<int, int> from, pair<int, int> to);

int main() {
	cin >> n;
	cin >> str;

	int idx = 0;
	for (int i = 0; i < n; i++) {
		if (str[i] >= '0' && str[i] <= '9') dp[i/2][i/2] = make_pair(str[i] - '0', str[i] - '0');   //�ʱⰪ
		else op[idx++] = str[i];
	}

	for(int i = 0;i <= n / 2;i++) {
		for (int j = i + 1; j <= n / 2; j++) {
			int maxNum = -2147483647;   //�ʱⰪ
			int minNum = 2147483647;

			for (int k = j - i - 1; k < j; k++) {  //��ĭ�� ���� ��
				pair<int,int> result = calMaxMin(op[k], dp[j - i - 1][k], dp[k + 1][j]); 
				if (result.first > maxNum) maxNum = result.first;
				if (result.second < minNum) minNum = result.second;
			}
			dp[j-i-1][j] = make_pair(maxNum, minNum);
		}
	}

	cout << dp[0][n / 2].first;
}

pair<int, int> calMaxMin(char op, pair<int, int> from, pair<int, int> to) {
	int maxNum;
	int minNum;

	if (op == '+') {  // + �� ���, �ִ� = �ִ� + �ִ�, �ּ� = �ּ� + �ּ�
		maxNum = from.first + to.first;
		minNum = from.second + to.second;
	}
	else if (op == '-') {  // - �� ���, �ִ� = �ִ� - �ּ�, �ּ� = �ּ� - �ִ�
		maxNum = from.first - to.second;
		minNum = from.second - to.first;
	}

	else { // * �� ���, �ִ� = 4���� ��� �� ���� ū ��, �ּ� = 4���� ��� �� ���� ���� ��  
		maxNum = max(max(from.first * to.first, from.first * to.second),max( from.second * to.first, from.second * to.second));
		minNum = min(min(from.first * to.first, from.first * to.second), min(from.second * to.first, from.second * to.second));
	}

	return make_pair(maxNum, minNum);
}