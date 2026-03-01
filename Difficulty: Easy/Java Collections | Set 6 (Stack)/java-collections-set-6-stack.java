import java.util.*;

class Solution {
    
    public Stack<Integer> deleteMid(int n, Stack<Integer> st) {
        
        if (n == 0) return st;
        
        int mid = n / 2;
        deleteHelper(st, mid);
        
        return st;
    }
    
    private void deleteHelper(Stack<Integer> st, int k) {
        
        if (k == 0) {
            st.pop();
            return;
        }
        
        int temp = st.pop();
        deleteHelper(st, k - 1);
        st.push(temp);
    }
}
