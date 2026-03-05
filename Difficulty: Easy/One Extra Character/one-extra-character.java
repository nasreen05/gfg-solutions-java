class Solution {
    public static Character oneExtraCharacter(String s1, String s2) {
        
        int xor = 0;
        
        // XOR all characters of s1
        for (int i = 0; i < s1.length(); i++) {
            xor ^= s1.charAt(i);
        }
        
        // XOR all characters of s2
        for (int i = 0; i < s2.length(); i++) {
            xor ^= s2.charAt(i);
        }
        
        return (char) xor;
    }
}
