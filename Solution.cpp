
//easy demon problem - finding when matrix sum is given x.
#include <iostream>
#include <vector>
#include <unordered_set>
#include <cmath>
using namespace std;

// Function to check if x and y exist in the sets
bool have(int x, int y, unordered_set<int> &sa, unordered_set<int> &sb) {
    return (sa.find(x) != sa.end() && sb.find(y) != sb.end());
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, m, q;
    cin >> n >> m >> q;

    long long asum = 0, bsum = 0;  // Change to long long for larger sum values

    // Arrays and sets
    vector<int> a(n);
    vector<int> b(m);
    unordered_set<int> sa, sb;

    // Read array 'a' and compute its sum
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        asum += a[i];  // Summing elements of array a
    }

    // Read array 'b' and compute its sum
    for (int i = 0; i < m; i++) {
        cin >> b[i];
        bsum += b[i];  // Summing elements of array b
    }

    // Populate sets with adjusted values
    for (int i = 0; i < n; i++) sa.insert(asum - a[i]);
    for (int i = 0; i < m; i++) sb.insert(bsum - b[i]);

    // Process each query
    while (q--) {
        int x;
        cin >> x;
        bool flag = false;

        bool sign = x >= 0;
        x = abs(x);

        // Check all divisors of x
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                int y = i, z = x / i;

                // Check combinations with positive/negative signs
                if (sign) {
                    if (have(y, z, sa, sb) || have(-y, -z, sa, sb)) {
                        flag = true;
                        break;
                    }
                } else {
                    if (have(-y, z, sa, sb) || have(y, -z, sa, sb)) {
                        flag = true;
                        break;
                    }
                }

                // Swap y and z to check the reverse pair
                swap(y, z);

                if (sign) {
                    if (have(y, z, sa, sb) || have(-y, -z, sa, sb)) {
                        flag = true;
                        break;
                    }
                } else {
                    if (have(-y, z, sa, sb) || have(y, -z, sa, sb)) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        // Print the result for the current query
        cout << (flag ? "Yes" : "NO") << "\n";
    }

    return 0;
}
