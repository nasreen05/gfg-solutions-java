class Solution {
    int binarySubstring(String s) {
        
        int count1 = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count1++;
            }
        }
        
        return (count1 * (count1 - 1)) / 2;
    }
}
