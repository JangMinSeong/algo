#include<iostream>
#include<string>

using namespace std;

string s0 = "moo";

void moo(int n, int k, int len);

int main() {
	int n;
	cin >> n;

	moo(n, 1, 3);
}

void moo(int n, int k, int len) {
	if (n <= 3) {
		cout << s0[n - 1];
		return;
	}

	int length = len * 2 + k + 3;
	if (length < n) moo(n, k + 1, length);  //�� ���������
	else {
		if (len < n && n <= len + k + 3) { //�߾�
			if (n == len + 1) {
				cout << "m";
				return;
			}
			else {
				cout << "o";
				return;
			}
		}
		else if (n > len + k + 3) { // ������
			moo(n - (len + k + 3), 1, 3);
		}
		else { //����
			moo(n, 1, 3); //��ǻ� ��� ���� ��
		}
	}
}