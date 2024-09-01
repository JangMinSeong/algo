#include <iostream>
#include <queue>

using namespace std;

int n;
priority_queue<int, vector<int>, greater<>> back;
priority_queue<int> front;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	
	for(int i=0;i< n;i++) {
		int num;
		cin >> num;

		if (front.empty() || front.top() >= num) {
			front.push(num);
		}
		else {
			back.push(num);
		}

		if (front.size() > back.size() + 1) {
			back.push(front.top());
			front.pop();
		}
		else if(back.size() > front.size()){
			front.push(back.top());
			back.pop();
		}

		cout << front.top() << "\n";
	}

	return 0;
}