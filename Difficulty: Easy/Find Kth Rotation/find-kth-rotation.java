class Solution {
    public int findKRotation(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low < high) {
            // If subarray is already sorted
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;

            // Minimum lies in right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } 
            // Minimum lies in left half (including mid)
            else {
                high = mid;
            }
        }

        return low;
    }
}
