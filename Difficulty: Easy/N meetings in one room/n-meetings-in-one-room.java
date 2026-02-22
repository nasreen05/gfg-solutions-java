import java.util.*;

class Solution {
    
    static class Meeting {
        int start, end;
        
        Meeting(int s, int e) {
            start = s;
            end = e;
        }
    }
    
    public int maxMeetings(int start[], int end[]) {
        
        int n = start.length;
        
        // Store meetings
        Meeting[] meetings = new Meeting[n];
        
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }
        
        // Sort by end time
        Arrays.sort(meetings, (a, b) -> a.end - b.end);
        
        int count = 1;  // First meeting selected
        int lastEnd = meetings[0].end;
        
        for (int i = 1; i < n; i++) {
            
            if (meetings[i].start > lastEnd) {
                count++;
                lastEnd = meetings[i].end;
            }
        }
        
        return count;
    }
}
