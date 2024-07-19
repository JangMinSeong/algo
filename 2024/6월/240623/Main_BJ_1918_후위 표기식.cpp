#include<iostream>
#include<string>
#include<stack>

using namespace std;

string str;
stack<char> op;

int main() {
	cin >> str;

	for (int i = 0; i < str.length(); i++) {
		if (str[i] >= 'A' && str[i] <= 'Z') {  //문자일경우
			cout << str[i];
			continue;
		}
		else {   //연산자일경우
			if (str[i] == '(') {  
				op.push(str[i]);
			}
			else if (str[i] == ')') {
				while (op.top() != '(') {
					cout << op.top();
					op.pop();
				}
				op.pop();
			}

			else if (str[i] == '*' || str[i] == '/') {   //우선순위 *,/ > +,-,(
				while (!op.empty() && (op.top() == '*' || op.top() == '/')) {
					cout << op.top();
					op.pop();
				}
				op.push(str[i]);
			}

			else if (str[i] == '+' || str[i] == '-') {  //우선순위 +,- > (
				while (!op.empty() && op.top() != '(') {
					cout << op.top();
					op.pop();
				}
				op.push(str[i]);
			}
		}
	}

	while (!op.empty()) {
		cout << op.top();
		op.pop();
	}


}