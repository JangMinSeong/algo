#include<iostream>
#include<vector>
#include<set>

using namespace std;

int Lx, Ly, n;
int map[1001][1001];

struct box {
	int lx;
	int ly;
	int lz;
	int px;
	int py;

	bool operator < (const struct box &a) const {
		return this->lz > a.lz;
	}
};

multiset<struct box> mset;

void overlap(struct box input);
bool isOverlap(struct box a, struct box b);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> Lx >> Ly >> n;
	mset.insert({ Lx,Ly,0,0,0 });
	for (int i = 0; i < n; i++) {
		int lx, ly, lz, px, py;
		cin >> lx >> ly >> lz >> px >> py;
		
		overlap({ lx,ly,lz,px,py });
	}

	cout << mset.begin()->lz;
}

void overlap(struct box input) { 
	for (auto i : mset) {
		if (isOverlap(i, input)) {
			input.lz += i.lz;
			mset.insert(input);
			return;
		}
	}
}

bool isOverlap(struct box a, struct box b) {
	int a_left = a.px;
	int a_right = a.px + a.lx;
	int a_bottom = a.py;
	int a_top = a.py + a.ly;

	int b_left = b.px;
	int b_right = b.px + b.lx;
	int b_bottom = b.py;
	int b_top = b.py + b.ly;

	if (a_left >= b_right || b_left >= a_right || a_bottom >= b_top || b_bottom >= a_top) {
		return false;
	}
	return true;
}