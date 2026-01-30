class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        if (n <= 1) return;

        Queue<Integer> firstHalf = new LinkedList<>();

        // Step 1: Move first half elements into firstHalf queue
        for (int i = 0; i < n / 2; i++) {
            firstHalf.add(q.poll());
        }

        // Step 2: Interleave first half and second half
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.poll()); // from first half
            q.add(q.poll());         // from second half
        }
    }
}
