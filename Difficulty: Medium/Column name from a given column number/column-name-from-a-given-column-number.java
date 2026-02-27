// User function Template for Java
class Solution {
    String colName(long n) {
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            
            n--;  // adjust for 1-based indexing
            
            long remainder = n % 26;
            
            sb.append((char)('A' + remainder));
            
            n = n / 26;
        }
        
        return sb.reverse().toString();
    }
}
