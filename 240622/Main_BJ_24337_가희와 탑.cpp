#include<iostream>
#include<vector>

using namespace std;

int n, a, b;
vector<int> building;
int main() {
	cin >> n >> a >> b;


	if (a + b >= n + 2) {    //������
		cout << -1;
		return 0;
	}

	if ((a <= b || a + b <= n) && a != 1) {  //�տ� 1�� ä�� �� �ִ� ���. ����� �ܺ� �� �� �ִ� �ǹ��� ��ü �ǹ����� ������ �տ� 1�� ä�� �� ���� ex) 1 1 1 1 1 1 ( ���⼭���� ���� ���� )
		for (int i = 0; i < n - a - b + 1; i++)
			building.push_back(1);
	}

	for (int i = 1; i <= a-1; i++) {  //���� �� �� �ִ� �ǹ� (�ְ��� ����)
		building.push_back(i);
	}

	for (int i = 0; i < n - a - b + 2; i++) {  //�ְ���, ������ 1
		if((a > b && i == n - a - b + 1) || (a <= b && i == 0))
			building.push_back(max(a, b));    //�ְ��� ����
		else if (a==1) building.push_back(1);  //�տ� 1�� ä�� �� ���°�� �ְ��� ���� 1�� ä���
	}

	for (int i = b - 1; i >= 1; i--) {  //�ܺ� �� �� �ִ� �ǹ� (�ְ��� ����)
		building.push_back(i);
	}


	for (int i = 0; i < n; i++)
		cout << building[i] << " ";

	return 0;
}