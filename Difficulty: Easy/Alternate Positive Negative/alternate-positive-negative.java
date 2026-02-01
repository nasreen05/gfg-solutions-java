class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Separate positives and negatives
        for (int x : arr) {
            if (x >= 0) pos.add(x);
            else neg.add(x);
        }

        int i = 0, p = 0, n = 0;
        boolean takePositive = true;

        // Merge alternately
        while (p < pos.size() && n < neg.size()) {
            if (takePositive) {
                arr.set(i++, pos.get(p++));
            } else {
                arr.set(i++, neg.get(n++));
            }
            takePositive = !takePositive;
        }

        // Add remaining positives
        while (p < pos.size()) {
            arr.set(i++, pos.get(p++));
        }

        // Add remaining negatives
        while (n < neg.size()) {
            arr.set(i++, neg.get(n++));
        }
    }
}
