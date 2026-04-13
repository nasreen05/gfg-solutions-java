class Solution {
    static int[] nextPalindrome(int[] num) {
        
        int n = num.length;
        
        // Step 1: check if all digits are 9
        boolean all9 = true;
        
        for(int i = 0; i < n; i++) {
            if(num[i] != 9) {
                all9 = false;
                break;
            }
        }
        
        // If all digits are 9
        if(all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }
        
        
        // Step 2: mirror left to right
        int[] result = num.clone();
        
        int i = n/2 - 1;
        int j = (n%2 == 0) ? n/2 : n/2 + 1;
        
        while(i >= 0) {
            result[j] = result[i];
            i--;
            j++;
        }
        
        
        // Step 3: check if mirrored number > original
        boolean greater = false;
        
        for(int k = 0; k < n; k++) {
            if(result[k] > num[k]) {
                greater = true;
                break;
            }
            else if(result[k] < num[k]) {
                break;
            }
        }
        
        if(greater) return result;
        
        
        // Step 4: increment middle and propagate carry
        int carry = 1;
        
        i = n/2 - 1;
        
        if(n % 2 == 1) {
            result[n/2] += carry;
            carry = result[n/2] / 10;
            result[n/2] %= 10;
            j = n/2 + 1;
        }
        else {
            j = n/2;
        }
        
        
        while(i >= 0 && carry > 0) {
            
            result[i] += carry;
            carry = result[i] / 10;
            result[i] %= 10;
            
            result[j] = result[i];
            
            i--;
            j++;
        }
        
        return result;
    }
}
