#include<iostream>
#include<string>
#include<stack>

using namespace std;

string str;

int main() {
    cin >> str;

    stack<char> st;

    for (int i = 0; i < str.length(); i++) {
        st.push(str[i]);

        if (st.size() >= 4) {
            char fourth = st.top(); st.pop();
            char third = st.top(); st.pop();
            char second = st.top(); st.pop();
            char first = st.top(); st.pop();

            if (first == 'P' && second == 'P' && third == 'A' && fourth == 'P') {
                st.push('P');
            }
            else {
                st.push(first);
                st.push(second);
                st.push(third);
                st.push(fourth);
            }
        }
    }

    if (st.size() == 1 && st.top() == 'P') {
        cout << "PPAP" << endl;
    }
    else {
        cout << "NP" << endl;
    }

    return 0;
}
