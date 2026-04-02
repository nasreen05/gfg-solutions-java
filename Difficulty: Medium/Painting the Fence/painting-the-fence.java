class Solution {
    int countWays(int n, int k) {
        
        if(n == 1) return k;
        if(n == 2) return k * k;
        
        int same = k;          // same for 2nd post
        int diff = k * (k - 1); // different for 2nd post
        
        int total = same + diff;
        
        for(int i = 3; i <= n; i++) {
            
            same = diff;
            diff = total * (k - 1);
            
            total = same + diff;
        }
        
        return total;
    }
}
