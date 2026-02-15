import java.util.*;

class Solution {
    public static String electionWinner(String arr[]) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // Count votes
        for (String name : arr) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        String winner = "";
        int maxVotes = 0;
        
        // Find candidate with maximum votes
        for (String name : map.keySet()) {
            int votes = map.get(name);
            
            if (votes > maxVotes) {
                maxVotes = votes;
                winner = name;
            }
            else if (votes == maxVotes) {
                // If tie, choose lexicographically smaller name
                if (name.compareTo(winner) < 0) {
                    winner = name;
                }
            }
        }
        
        return winner;
    }
}
