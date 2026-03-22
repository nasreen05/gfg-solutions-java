class Solution {
    public String convert(String s) {
        
        StringBuilder result = new StringBuilder();
        
        // Convert first character to uppercase
        result.append(Character.toUpperCase(s.charAt(0)));
        
        // Traverse remaining string
        for(int i = 1; i < s.length(); i++){
            
            if(s.charAt(i - 1) == ' '){
                result.append(Character.toUpperCase(s.charAt(i)));
            }
            else{
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}
