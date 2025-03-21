#include<iostream>
#include<vector>

using namespace std;

int n, m;
bool visited[100001] = { false, };  //�湮 �����
bool selected[100001] = { false, };  //���� �����
vector<vector<int>> adj;
int ans = 0;

int dfs(int idx, bool isSelected);

int main() {
	cin >> n >> m;
	
	adj.resize(n + 1);
	for (int i = 1; i <= m; i++) {
		int from, to;
		cin >> from >> to;

		adj[from].push_back(to);
		adj[to].push_back(from);
	}

	for (int i = 1; i <= n; i++) {
		if (visited[i] == true) continue; //�ѹ� �湮�� �� ��ŵ
		if (adj[i].size() == 0) {   //����� ���� ���� ���
			ans++;
			continue;
		}
		ans += dfs(i, false);  // �湮
	}

	cout << ans;
}

int dfs(int idx, bool isSelected) {
	
	int result1 = 0;  //idx�� �����ϰ� �Ѿ ���
	int result2 = 0;  //idx�� ���þ��ϰ� �Ѿ ���
	visited[idx] = true;

	bool isLast = true;  //������ ���� �Ǵܿ� (�ѹ��̶� �ݺ����� ���� => �� �� �ִ� ��尡 �ִ�)

	bool ch = true;
	if (isSelected == false) {   //idx�� ���õ� �� �ִ� ���
		for (int t : adj[idx]) {   //���� �� ���� ��� Ȯ��
			if (selected[t] == true) {
				ch = false;
				break;
			}
		}
	}
	else ch = false;

	for (int next : adj[idx]) {
		if (visited[next] == true) continue;
		isLast = false;

		if (ch == true) {
			selected[idx] = true;
			result1 += dfs(next, true) + 1;  //idx �����ϱ�
			selected[idx] = false;
		}

		result2 += dfs(next, false);  //idx ���� ���ϱ�
	}

	if (isLast == true) {
		if (ch == false) return 0;  //������ ��尡 ���õǾ��� => ������ ��忡�� ���� ����
		return 1;  //������ ��尡 ���õȰ� ���� => ������ ��忡�� ���� ����
	}

	return max(result1, result2);  //�� �� ū��
}