class Solution {
    public String longest(List<String> arr) {
        
        String longestName = "";
        
        for (String name : arr) {
            if (name.length() > longestName.length()) {
                longestName = name;
            }
        }
        
        return longestName;
    }
}
