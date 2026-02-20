import java.util.*;

class Solution {

    ArrayList<Integer> rotate(int n, int d) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        d = d % 16;   // because only 16 bits
        
        // Left Rotation
        int left = ((n << d) | (n >> (16 - d))) & 0xFFFF;
        
        // Right Rotation
        int right = ((n >> d) | (n << (16 - d))) & 0xFFFF;
        
        result.add(left);
        result.add(right);
        
        return result;
    }
}
