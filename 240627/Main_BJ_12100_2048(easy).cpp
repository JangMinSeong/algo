#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int direction[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
int result;
int n;

int getMax(vector<vector<int>> map) {
	int m = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			m = max(m, map[i][j]);
		}
	}
	return m;
}

void print(vector<vector<int>> t) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << t[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
}

vector<vector<int>> input() {
	cin >> n;
	vector<vector<int>> map(n, vector<int>(n));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int t;
			cin >> t;
			map[i][j] = t;
		}
	}
	return map;
}

vector<vector<int>> moveUp(vector<vector<int>> map) {
	for (int j = 0; j < n; j++) {
		for (int i = 0; i < n - 1; i++) {
			int count = 0;
			while (map[i][j] == 0 && count++ < n) {
				for (int k = i; k < n - 1; k++)
					map[k][j] = map[k + 1][j];
				map[n - 1][j] = 0;
			}
			count = 0;
			while (map[i + 1][j] == 0 && count++ < n) {
				for (int k = i + 1; k < n - 1; k++)
					map[k][j] = map[k + 1][j];
				map[n - 1][j] = 0;
			}
			if (map[i][j] == map[i + 1][j]) {
				map[i][j] = map[i][j] + map[i + 1][j];
				for (int k = i + 1; k < n - 1; k++)
					map[k][j] = map[k + 1][j];
				map[n - 1][j] = 0;
			}
		}
	}
	return map;
}
vector<vector<int>> moveDown(vector<vector<int>> map) {
	for (int j = 0; j < n; j++) {
		for (int i = n - 1; i >= 1; i--) {
			int count = 0;
			while (map[i][j] == 0 && count++ < n) {
				for (int k = i; k >= 1; k--)
					map[k][j] = map[k - 1][j];
				map[0][j] = 0;
			}
			count = 0;
			while (map[i - 1][j] == 0 && count++ < n) {
				for (int k = i - 1; k >= 1; k--)
					map[k][j] = map[k - 1][j];
				map[0][j] = 0;
			}

			if (map[i][j] == map[i - 1][j]) {
				map[i][j] = map[i][j] + map[i - 1][j];
				for (int k = i - 1; k >= 1; k--)
					map[k][j] = map[k - 1][j];
				map[0][j] = 0;
			}
		}
	}
	return map;
}
vector<vector<int>> moveLeft(vector<vector<int>> map) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n - 1; j++) {
			int count = 0;
			while (map[i][j] == 0 && count++ < n) {
				for (int k = j; k < n - 1; k++)
					map[i][k] = map[i][k + 1];
				map[i][n - 1] = 0;
			}
			count = 0;
			while (map[i][j + 1] == 0 && count++ < n) {
				for (int k = j + 1; k < n - 1; k++)
					map[i][k] = map[i][k + 1];
				map[i][n - 1] = 0;
			}
			if (map[i][j] == map[i][j + 1]) {
				map[i][j] = map[i][j] + map[i][j + 1];
				for (int k = j + 1; k < n - 1; k++)
					map[i][k] = map[i][k + 1];
				map[i][n - 1] = 0;
			}
		}
	}
	return map;
}
vector<vector<int>> moveRight(vector<vector<int>> map) {
	for (int i = 0; i < n; i++) {
		for (int j = n - 1; j >= 1; j--) {
			int count = 0;
			while (map[i][j] == 0 && count++ < n) {
				for (int k = j; k >= 1; k--)
					map[i][k] = map[i][k - 1];
				map[i][0] = 0;
			}
			count = 0;
			while (map[i][j - 1] == 0 && count++ < n) {
				for (int k = j - 1; k >= 1; k--)
					map[i][k] = map[i][k - 1];
				map[i][0] = 0;
			}
			if (map[i][j] == map[i][j - 1]) {
				map[i][j] = map[i][j] + map[i][j - 1];
				for (int k = j - 1; k >= 1; k--)
					map[i][k] = map[i][k - 1];
				map[i][0] = 0;
			}
		}
	}
	return map;
}

bool checkChange(vector<vector<int>> before, vector<vector<int>> after) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (before[i][j] != after[i][j]) return true;
		}
	}
	return false;
}

void search(int count, vector<vector<int>> map) {
	result = max(result, getMax(map));
	if (count == 5) return;

	vector<vector<int>> afterMove;
	afterMove = moveUp(map);
	if (checkChange(map, afterMove)) search(count + 1, afterMove);

	afterMove = moveDown(map);
	if (checkChange(map, afterMove)) search(count + 1, afterMove);

	afterMove = moveLeft(map);
	if (checkChange(map, afterMove)) search(count + 1, afterMove);

	afterMove = moveRight(map);
	if (checkChange(map, afterMove)) search(count + 1, afterMove);
}

int solve(vector<vector<int>> map) {
	search(0, map);
	return result;
}

int main() {
	vector<vector<int>> map;
	map = input();

	cout << solve(map);
}