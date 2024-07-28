#include <iostream>
#include <string>
#include <queue>

using namespace std;

string str;
queue<int> a,b;
int ans;

int main() {
    cin >> str;

    for(int i=0;i<str.length();i++) {
        if(str[i] == 'A') a.push(i);
        else if(str[i] == 'B') b.push(i);
        if(str[i] == 'C' && !b.empty()) {
            str[i] = 'X';
            str[b.front()] = 'X';
            b.pop();
            ans++;
        }
    }

    while(!a.empty() && !b.empty()) {
        int idxA = a.front();
        int idxB = b.front();

        if(idxA < idxB) {
            ans++;
            a.pop();
            b.pop();
        }
        else
            b.pop();
    }

    cout << ans;
    
    return 0;
}
