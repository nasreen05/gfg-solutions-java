class Solution {
    boolean kPangram(String str, int k) {

        boolean[] present = new boolean[26];
        int count = 0;
        int total = 0;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch != ' '){
                total++;
                if(!present[ch - 'a']){
                    present[ch - 'a'] = true;
                    count++;
                }
            }
        }

        if(total < 26) return false;

        int missing = 26 - count;

        return missing <= k;
    }
}
