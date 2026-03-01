class Solution {
    int search(int[] arr, int key) {
        
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            
            int mid = low + (high - low) / 2;
            
            // If key found
            if (arr[mid] == key)
                return mid;
            
            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                
                if (key >= arr[low] && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
