import java.util.*;

class Solution {

    class Job {
        int deadline, profit;

        Job(int d, int p) {
            deadline = d;
            profit = p;
        }
    }

    int find(int parent[], int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent, parent[x]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        // Sort by highest profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find max deadline
        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        // DSU parent array
        int parent[] = new int[maxDeadline + 1];

        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int count = 0;
        int totalProfit = 0;

        for (Job job : jobs) {

            int availableSlot = find(parent, job.deadline);

            if (availableSlot > 0) {

                count++;
                totalProfit += job.profit;

                parent[availableSlot] =
                        find(parent, availableSlot - 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        result.add(count);
        result.add(totalProfit);

        return result;
    }
}
