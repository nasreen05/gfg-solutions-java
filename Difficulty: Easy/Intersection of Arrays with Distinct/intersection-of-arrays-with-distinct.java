class Solution {
    public static int intersectSize(int a[], int b[]) {
        // Always store the smaller array in the HashSet
        if (a.length > b.length) {
            return intersectSize(b, a);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }

        int count = 0;
        for (int x : b) {
            if (set.contains(x)) {
                count++;
            }
        }

        return count;
    }
}
