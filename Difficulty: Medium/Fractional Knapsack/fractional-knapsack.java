import java.util.*;

class Solution {

    static class Item {
        int value, weight;
        double ratio;

        Item(int v, int w) {
            value = v;
            weight = w;
            ratio = (double) v / w;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        // Sort by value/weight ratio descending
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity == 0) break;

            if (item.weight <= remainingCapacity) {
                // Take full item
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Take fractional part
                totalValue += item.ratio * remainingCapacity;
                remainingCapacity = 0;
            }
        }

        // Round to 6 decimal places
        return Math.round(totalValue * 1e6) / 1e6;
    }
}
