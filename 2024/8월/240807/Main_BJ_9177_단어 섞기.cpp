#include<iostream>
#include<string>
#include<tuple>
#include<queue>

using namespace std;

int n;

bool check(string str1, string str2, string str3);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		string str1, str2, str3;
		bool isDone = false;
		cin >> str1 >> str2 >> str3;

		isDone = check(str1 + "0", str2 + "0", str3);

		if (isDone) cout << "Data set " << i + 1 << ": yes" << endl;
		else  cout << "Data set " << i + 1 << ": no" << endl;
	}
}

bool check(string str1, string str2, string str3) {
	queue<tuple<int,int,int>> que;
	int visit[201][201] = { 0, };
	int d[2][2] = { {1,0},{0,1} };

	que.push(make_tuple( 0,0,0 ));

	while (!que.empty()) {
		int x, y, idx;
		tie(x, y, idx) = que.front();
		que.pop();

		if (x >= str1.length() || y >= str2.length()) continue;
		if (visit[x][y] != 0) continue;

		if (str1[x] != str3[idx] && str2[y] != str3[idx]) continue;

		visit[x][y] = 1;
		if (str1[x] == str3[idx])
			que.push(make_tuple(x + 1, y, idx + 1));
		if (str2[y] == str3[idx])
			que.push(make_tuple(x, y + 1, idx + 1));
	}

	return visit[str1.length() - 2][str2.length() - 1] || visit[str1.length() - 1][str2.length() -2];
}