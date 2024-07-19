#include<iostream>
#include<string>
#include<queue>
#include<set>

using namespace std;

int k;
string num;

void bfs();
int atoi(string str);

int main() {
	cin >> num >> k;

	if (num.length() == 1 || (num.length() == 2 && num[1] == '0')) {
		cout << "-1" << endl;
		return 0;
	}

	bfs();


	return 0;
}

void bfs() {
	queue<string> que;
	que.push(num);

	set<string> used;
	for (int round = 0; round < k; round++) {
		if (que.empty()) {
			cout << "-1" << endl;
			return;
		}

		int que_size = que.size();
		used.clear();

		for (int i = 0; i < que_size; i++) {
			string front = que.front();
			que.pop();

			for (int j = 0; j < front.length() - 1; j++) {
				for (int k = j + 1; k < front.length(); k++) {
					if (j == 0 && front[k] == '0') continue;

					string tmp = front;
					char t = tmp[j];
					tmp[j] = tmp[k];
					tmp[k] = t;

					if (used.find(tmp) == used.end()) {
						used.insert(tmp);
						que.push(tmp);
					}
				}
			}
		}
	}

	int max = 0;
	for (auto iter = used.begin(); iter != used.end(); iter++) {
		int value = atoi(*iter);
		if (max < value) {
			max = value;
		}
	}

	cout << max << endl;
}

int atoi(string str) {
	int num = 0;

	for (int i = 0; i < str.length(); i++) {
		num = (num * 10) + (str[i] - '0');
	}
	
	return num;
}