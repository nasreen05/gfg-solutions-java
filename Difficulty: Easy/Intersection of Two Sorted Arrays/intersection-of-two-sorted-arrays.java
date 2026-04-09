import java.util.ArrayList;

class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0;
        int n = a.length, m = b.length;
        
        while(i < n && j < m) {
            
            if(a[i] == b[j]) {
                
                // add only distinct element
                if(result.size() == 0 || result.get(result.size()-1) != a[i]) {
                    result.add(a[i]);
                }
                
                i++;
                j++;
            }
            else if(a[i] < b[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        return result;
    }
}
