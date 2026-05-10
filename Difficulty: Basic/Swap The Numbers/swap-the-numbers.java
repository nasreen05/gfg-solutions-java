class Solution {
    public void swap(int a, int b) {
        // Swapping using temporary variable
        int temp = a;
        a = b;
        b = temp;

        System.out.println(a + " " + b);
    }
}