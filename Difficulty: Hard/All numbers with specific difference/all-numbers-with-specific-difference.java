class Solution {
    
    public int getCount(int n, int d) {
        
        int low = 1, high = n;
        int firstValid = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid - digitSum(mid) >= d) {
                firstValid = mid;
                high = mid - 1;   // try smaller
            } else {
                low = mid + 1;
            }
        }
        
        if (firstValid == -1) return 0;
        
        return n - firstValid + 1;
    }
    
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
