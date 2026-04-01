class Solution {
    int countStrings(int n) {
        // Base cases
        if(n == 1) return 2;
        if(n == 2) return 3;
        
        int a = 2; // f(1)
        int b = 3; // f(2)
        int c = 0;
        
        // Fibonacci-style DP
        for(int i = 3; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        
        return b;
    }
}
