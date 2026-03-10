import java.util.*;

class Solution{
    
    static void solve(Stack<Integer> st, int k){
        
        if(k == 0){
            st.pop(); // delete middle
            return;
        }
        
        int temp = st.pop();
        solve(st, k-1);
        st.push(temp);
    }
    
    static Stack<Integer> deleteMid(int n, Stack<Integer> st)
    {
        int k = n/2;
        solve(st, k);
        return st;
    }
}
