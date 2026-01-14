class Solution {
    public int catchThieves(char[] arr, int k) {

        List<Integer> police = new ArrayList<>();
        List<Integer> thief = new ArrayList<>();

        // Store indices of police and thieves
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else {
                thief.add(i);
            }
        }

        int i = 0, j = 0, count = 0;

        // Two pointer technique
        while (i < police.size() && j < thief.size()) {
            if (Math.abs(police.get(i) - thief.get(j)) <= k) {
                count++;   // one thief caught
                i++;
                j++;
            } 
            else if (police.get(i) < thief.get(j)) {
                i++;   // policeman too far left
            } 
            else {
                j++;   // thief too far left
            }
        }

        return count;
    }
}
