import java.util.Arrays;

class Solution {
    public static int getMaxVal(int arr[], int k) {
        
        Arrays.sort(arr);  // sort array
        
        int n = arr.length;
        int sum = 0;
        
        // pick k largest elements
        for(int i = n-1; i >= n-k; i--){
            sum += arr[i];
        }
        
        return sum;
    }
}
