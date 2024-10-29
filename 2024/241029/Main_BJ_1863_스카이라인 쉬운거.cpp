#include <iostream>
#include <cstring>
#include <vector>
#include <stack>

using namespace std;

int n, ans = 0;
stack <int> st;

int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y; 

        while (!st.empty() && st.top() >= y) {
            if (st.top() != y) ans++;
            st.pop();
        }
        st.push(y);
    }

    while (!st.empty() && st.top() >= 0) {
        if (st.top() != 0) ans++;
        st.pop();
    }

    cout << ans;
    return 0;
}