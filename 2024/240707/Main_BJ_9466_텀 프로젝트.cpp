#include<iostream>
#include<vector>

using namespace std;

int t;
int n;
int stu[100001];
int visit[100001];
int cnt = 0;

void dfs(int num);
void clear();

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);cout.tie(NULL);

	cin >> t;

	for (int test_case = 0; test_case < t; test_case++) {
		cin >> n;
		clear();

		for (int i = 1; i <= n; i++) {
			cin >> stu[i];
		}

		for (int i = 1; i <= n; i++) {
			if (visit[i] == false) {
				dfs(i);
			}
		}


		cout << n - cnt << endl;
	}
}

void dfs(int num) {
	visit[num] = 1;
	int next = stu[num];

	if (visit[next] == 0) {
		dfs(next);
	}
	else if(visit[next] == 1) {
		cnt++;
		for (int i = next; i != num; i = stu[i]) {
			cnt++;
		}
	}
	visit[num] = 2;
}


void clear() {
	cnt = 0;
	for (int i = 1; i <= n; i++) {
		stu[i] = 0;
		visit[i] = 0;
	}
}