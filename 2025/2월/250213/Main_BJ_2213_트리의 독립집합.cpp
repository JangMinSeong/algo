#include<iostream>
#include<vector>

using namespace std;

int n, m;
bool visited[100001] = { false, };  //�湮 �����
bool selected[100001] = { false, };  //���� �����
vector<vector<int>> adj;
int value[10001];
int ans = 0;

int dfs(int idx, bool isSelected);

int main() {
	cin >> n >> m;

	adj.resize(n + 1);
	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;
		value[i] = num;
	}
	for (int i = 1; i < n; i++) {
		int from, to;
		cin >> from >> to;

		adj[from].push_back(to);
		adj[to].push_back(from);
	}

	ans += dfs(1, false);  // �湮

	cout << ans;
}

int dfs(int idx, bool isSelected) {

	int result1 = 0;  //idx�� �����ϰ� �Ѿ ���
	int result2 = 0;  //idx�� ���þ��ϰ� �Ѿ ���
	visited[idx] = true;

	bool isLast = true;  //������ ���� �Ǵܿ� (�ѹ��̶� �ݺ����� ���� => �� �� �ִ� ��尡 �ִ�)
	for (int next : adj[idx]) {
		if (visited[next] == true) continue;

		isLast = false;
		if (isSelected == false) {   //idx�� ���õ� �� �ִ� ���
			bool ch = true;
			for (int t : adj[idx]) {   //���� �� ���� ��� Ȯ��
				if (selected[t] == true) {
					ch = false;
					break;
				}
			}
			if (ch == true) {
				selected[idx] = true;
				result1 += dfs(next, true) + value[idx];  //idx �����ϰ� �Ѿ����
				selected[idx] = false;
			}
		}

		result2 += dfs(next, false);  //idx ���� ���ϱ�
	}

	if (isLast == true) {
		bool ch = true;
		for (int t : adj[idx]) {
			if (selected[t] == true) return 0;  //������ ��尡 ���õǾ��� => ������ ��忡�� ���� ����
		}
		return value[idx];  //������ ��尡 ���õȰ� ���� => ������ ��忡�� ���� ����
	}

	return max(result1, result2);  //�� �� ū��
}