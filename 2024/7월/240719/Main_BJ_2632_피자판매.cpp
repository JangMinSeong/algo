#include<iostream>
#include<vector>
#include<map>

using namespace std;

int n, m;
int order_size;

int totalSize1, totalSize2;
vector<int> pizza1, pizza2;
map<int, int> case1, case2;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> order_size;
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		int t;
		cin >> t;
		pizza1.push_back(t);
		totalSize1 += t;
	}
	for (int i = 0; i < m; i++) {
		int t;
		cin >> t;
		pizza2.push_back(t);
		totalSize2 += t;
	}

	int ans = 0;
	case1.insert({ totalSize1,1 });
	case2.insert({ totalSize2,1 });

	for (int i = 0; i < pizza1.size(); i++) {  //i 에서부터 j개 까지 합 계산
		int sum = 0;

		for (int j = 0; j < pizza1.size() - 1; j++) {
			sum += pizza1[(j + i) % pizza1.size()];
			if (sum > order_size) 
				break;

			auto iter = case1.find(sum);
			if (iter == case1.end()) {
				case1.insert({ sum,1 });
			}
			else iter->second++;
		}
	}

	for (int i = 0; i < pizza2.size(); i++) {  //i 에서부터 j개 까지 합 계산
		int sum = 0;

		for (int j = 0; j < pizza2.size() - 1; j++) {
			sum += pizza2[(j + i) % pizza2.size()];
			if (sum > order_size)
				break;

			auto iter = case2.find(sum);
			if (iter == case2.end()) {
				case2.insert({ sum,1 });
			}
			else iter->second++;
		}
	}

	auto iter1 = case1.find(order_size);
	auto iter2 = case2.find(order_size);
	if (iter1 != case1.end()) ans += iter1->second;
	if (iter2 != case2.end()) ans += iter2->second;

	for (auto iter = case1.begin(); iter != case1.end(); iter++) {
		int sum = iter->first;
		auto iter2 = case2.find(order_size - sum);
		if (iter2 != case2.end()) {
			ans += iter->second * iter2->second;
		}
	}

	cout << ans;
}