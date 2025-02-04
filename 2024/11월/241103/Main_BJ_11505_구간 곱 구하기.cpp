#include<iostream>
#include<vector>

using namespace std;

int n, m, k;
int mod = 1000000007;
vector<long long> nums;
vector<long long> tree;

long long init(int start, int end, int node);
long long multi(int start, int end, int node, int left, int right);
void update(int start, int end, int node, int idx, long long value);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m >> k;
    nums.resize(n);
    tree.resize(n * 4);

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    init(0, n - 1, 1);

    for (int i = 0; i < m + k; i++) {
        int op, num1;
        long long num2;
        cin >> op >> num1 >> num2;
        num1--; 

        if (op == 1) {
            update(0, n - 1, 1, num1, num2);
        }
        else {
            num2--; 
            cout << multi(0, n - 1, 1, num1, num2) << '\n';
        }
    }

    return 0;
}

long long init(int start, int end, int node) {
    if (start == end) {
        return tree[node] = nums[start] % mod;
    }
    int mid = (start + end) / 2;
    return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % mod;
}

long long multi(int start, int end, int node, int left, int right) {
    if (left > end || right < start) return 1;
    if (left <= start && end <= right) return tree[node];
    int mid = (start + end) / 2;
    return (multi(start, mid, node * 2, left, right) * multi(mid + 1, end, node * 2 + 1, left, right)) % mod;
}

void update(int start, int end, int node, int idx, long long value) {
    if (idx < start || idx > end) return;
    if (start == end) {
        tree[node] = value % mod;
        return;
    }
    int mid = (start + end) / 2;
    update(start, mid, node * 2, idx, value);
    update(mid + 1, end, node * 2 + 1, idx, value);
    tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % mod;
}
