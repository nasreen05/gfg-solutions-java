import java.util.*;

class Sorting {
    public ArrayList<ArrItem> sortedWithIndices(int arr[]) {
        
        ArrayList<ArrItem> list = new ArrayList<>();
        
        // create objects
        for(int i = 0; i < arr.length; i++){
            list.add(new ArrItem(arr[i], i));
        }
        
        // sort by item then index
        Collections.sort(list, (a, b) -> {
            if(a.item == b.item)
                return a.index - b.index;
            return a.item - b.item;
        });
        
        return list;
    }
}
