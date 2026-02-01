class Solution {
    boolean sameFreq(String s) {
        int[] freq = new int[26];

        // Count character frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Map frequency → count of characters having that frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int f : freq) {
            if (f > 0) {
                map.put(f, map.getOrDefault(f, 0) + 1);
            }
        }

        // If all frequencies are already equal
        if (map.size() == 1) return true;

        // If more than 2 frequencies exist → impossible
        if (map.size() > 2) return false;

        // Exactly two frequencies
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        int f1 = keys[0], f2 = keys[1];
        int c1 = map.get(f1), c2 = map.get(f2);

        // Case 1: one character appears once
        if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) {
            return true;
        }

        // Case 2: higher frequency exceeds lower by exactly 1
        if (Math.abs(f1 - f2) == 1) {
            if ((f1 > f2 && c1 == 1) || (f2 > f1 && c2 == 1)) {
                return true;
            }
        }

        return false;
    }
}
