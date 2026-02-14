class Solution {
    
    public int minTime(int[] arr, int k) {
        
        int max = 0;
        long sum = 0;
        
        for (int board : arr) {
            max = Math.max(max, board);
            sum += board;
        }
        
        long low = max;
        long high = sum;
        long ans = sum;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canPaint(arr, k, mid)) {
                ans = mid;
                high = mid - 1;  // try smaller time
            } else {
                low = mid + 1;
            }
        }
        
        return (int) ans;
    }
    
    private boolean canPaint(int[] arr, int k, long maxTime) {
        
        int painters = 1;
        long currSum = 0;
        
        for (int board : arr) {
            
            if (currSum + board <= maxTime) {
                currSum += board;
            } else {
                painters++;
                currSum = board;
                
                if (painters > k) return false;
            }
        }
        
        return true;
    }
}
