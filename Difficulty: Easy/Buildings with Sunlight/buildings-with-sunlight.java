class Solution {
    public int visibleBuildings(int arr[]) {
        int count = 1; // First building always gets sunlight
        int maxHeight = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] >= maxHeight) {
                count++;
                maxHeight = arr[i];
            }
        }
        
        return count;
    }
}
