#include<iostream>
#include<vector>

using namespace std;

int n, a, b;
vector<int> building;
int main() {
	cin >> n >> a >> b;


	if (a + b >= n + 2) {    //못만듬
		cout << -1;
		return 0;
	}

	if ((a <= b || a + b <= n) && a != 1) {  //앞에 1로 채울 수 있는 경우. 가희와 단비가 볼 수 있는 건물이 전체 건물보다 적으면 앞에 1로 채울 수 있음 ex) 1 1 1 1 1 1 ( 여기서부터 증가 감소 )
		for (int i = 0; i < n - a - b + 1; i++)
			building.push_back(1);
	}

	for (int i = 1; i <= a-1; i++) {  //가희가 볼 수 있는 건물 (최고점 제외)
		building.push_back(i);
	}

	for (int i = 0; i < n - a - b + 2; i++) {  //최고점, 나머지 1
		if((a > b && i == n - a - b + 1) || (a <= b && i == 0))
			building.push_back(max(a, b));    //최고점 삽입
		else if (a==1) building.push_back(1);  //앞에 1로 채울 수 없는경우 최고점 이후 1로 채우기
	}

	for (int i = b - 1; i >= 1; i--) {  //단비가 볼 수 있는 건물 (최고점 제외)
		building.push_back(i);
	}


	for (int i = 0; i < n; i++)
		cout << building[i] << " ";

	return 0;
}