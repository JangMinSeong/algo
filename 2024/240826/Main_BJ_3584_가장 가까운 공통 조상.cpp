#include<iostream>
#include<set>

using namespace std;

int n;
int parent[10001];
set<int> path;

void clear();

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(); cout.tie();

	int test_case;
	cin >> test_case;
	for (int t = 0; t < test_case; t++) {
		cin >> n;
		clear();
		
		for (int i = 0; i < n - 1; i++) {
			int from, to;
			cin >> from >> to;
			parent[to] = from;
		}

		int num1, num2;
		cin >> num1 >> num2;


		while (1) {
			if (num1 == -1) break;
			path.insert(num1);
			num1 = parent[num1];
		}

		while (1) {
			if (path.find(num2) != path.end()) {
				break;
			}
			num2 = parent[num2];
		}

		cout << num2 << endl;
	}

}
void clear() {
	path.clear();
	for (int i = 0; i <= n; i++) {
		parent[i] = -1;
	}
}