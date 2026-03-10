#include <algorithm>
#include <vector>
using namespace std;

int minDiff(vector<int> &arr, int k) {
    
    int n = arr.size();
    
    if (k == 0 || n == 0)
        return 0;
        
    if (n < k)
        return -1;
        
    sort(arr.begin(), arr.end());
    
    int ans = INT_MAX;
    
    for (int i = 0; i <= n - k; i++) {
        int diff = arr[i + k - 1] - arr[i];
        ans = min(ans, diff);
    }
    
    return ans;
}
