#include<iostream>
#include<vector>

using namespace std;

int n, m;
bool visited[100001] = { false, };  //방문 저장용
bool selected[100001] = { false, };  //선택 저장용
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

	ans += dfs(1, false);  // 방문

	cout << ans;
}

int dfs(int idx, bool isSelected) {

	int result1 = 0;  //idx를 선택하고 넘어갈 경우
	int result2 = 0;  //idx를 선택안하고 넘어갈 경우
	visited[idx] = true;

	bool isLast = true;  //마지막 깊이 판단용 (한번이라도 반복에서 실행 => 갈 수 있는 노드가 있다)
	for (int next : adj[idx]) {
		if (visited[next] == true) continue;

		isLast = false;
		if (isSelected == false) {   //idx가 선택될 수 있는 경우
			bool ch = true;
			for (int t : adj[idx]) {   //연결 된 노드들 모두 확인
				if (selected[t] == true) {
					ch = false;
					break;
				}
			}
			if (ch == true) {
				selected[idx] = true;
				result1 += dfs(next, true) + value[idx];  //idx 선택하고 넘어가보기
				selected[idx] = false;
			}
		}

		result2 += dfs(next, false);  //idx 선택 안하기
	}

	if (isLast == true) {
		bool ch = true;
		for (int t : adj[idx]) {
			if (selected[t] == true) return 0;  //인접한 노드가 선택되었음 => 마지막 노드에서 선택 못함
		}
		return value[idx];  //인접한 노드가 선택된게 없음 => 마지막 노드에서 선택 가능
	}

	return max(result1, result2);  //둘 중 큰거
}