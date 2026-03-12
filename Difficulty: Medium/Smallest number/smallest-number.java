class Solution {
    public String smallestNumber(int s, int d) {
        
        if (s > 9 * d) return "-1";
        
        int[] res = new int[d];
        
        s = s - 1; // reserve 1 for first digit
        
        for (int i = d - 1; i > 0; i--) {
            if (s > 9) {
                res[i] = 9;
                s -= 9;
            } else {
                res[i] = s;
                s = 0;
            }
        }
        
        res[0] = s + 1;
        
        String ans = "";
        for (int i = 0; i < d; i++) {
            ans += res[i];
        }
        
        return ans;
    }
}
