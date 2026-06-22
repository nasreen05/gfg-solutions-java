class Solution {
    public int maxArea(List<Integer> height) {
        int n = height.size();
        if (n < 2) return 0;

        int left = 0, right = n - 1;
        int ans = 0;

        while (left < right) {
            int width = right - left - 1; // bars between them
            int area = Math.min(height.get(left), height.get(right)) * width;

            ans = Math.max(ans, area);

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}