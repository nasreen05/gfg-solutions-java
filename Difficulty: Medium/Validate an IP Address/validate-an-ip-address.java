class Solution {
    public boolean isValid(String s) {
        
        // Split by dot
        String[] parts = s.split("\\.");
        
        // Must contain exactly 4 parts
        if (parts.length != 4) return false;
        
        for (String part : parts) {
            
            // Empty part not allowed
            if (part.length() == 0) return false;
            
            // Leading zero not allowed (except single digit 0)
            if (part.length() > 1 && part.charAt(0) == '0')
                return false;
            
            // Check if all characters are digits
            for (char ch : part.toCharArray()) {
                if (!Character.isDigit(ch))
                    return false;
            }
            
            // Convert to integer
            int num = Integer.parseInt(part);
            
            // Check range
            if (num < 0 || num > 255)
                return false;
        }
        
        return true;
    }
}
