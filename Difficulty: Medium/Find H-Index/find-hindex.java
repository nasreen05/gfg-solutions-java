class Solution {
    public int hIndex(int[] arr) {
        
        int n = arr.length;
        Arrays.sort(arr);
        
        int h = 0;
        
        for(int i = 0; i < n; i++) {
            int papers = n - i;
            
            if(arr[i] >= papers) {
                h = papers;
                break;
            }
        }
        
        return h;
    }
}
