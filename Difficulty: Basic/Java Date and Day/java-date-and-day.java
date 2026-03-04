import java.util.*;

class Solution {
    static String findDay(int Day, int Month, int Year) {
        
        Calendar cal = Calendar.getInstance();
        cal.set(Year, Month - 1, Day);  // Month is 0-based in Calendar
        
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        
        String[] days = {
            "SUNDAY", "MONDAY", "TUESDAY", 
            "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"
        };
        
        return days[dayOfWeek - 1];
    }
}
