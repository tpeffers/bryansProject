
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Details {

	public static void main(String args[]) {

		/* This is how to declare HashMap */
		HashMap<String, Double> hmap = new HashMap<String, Double>();
		ValueComparator bvc = new ValueComparator(hmap);
		TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);
		

		/* Adding elements to HashMap */
		hmap.put("Andy", 8.0);
		hmap.put("Peter", 29.0);
		hmap.put("Amanda", 23.0);
		hmap.put("Sarah", 45.0);
		hmap.put("David", 75.0);
		
		System.out.println("unsorted map: " + hmap);
        sorted_map.putAll(hmap);
        System.out.println("results: " + sorted_map);
        
        
        /* Find average */
		int count = 0;
		int total = 0;
		Set set3 = hmap.entrySet();
		Iterator iterator3 = set3.iterator();
		while (iterator3.hasNext()) {
			Map.Entry mentry3 = (Map.Entry) iterator3.next();
			count++;
			total = total;
			System.out.println(mentry3.getValue());
		}
		System.out.println(count);
		
		

		
	
		/* Display content using Iterator */
		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print(mentry.getKey() + " scored ");
			System.out.println(mentry.getValue() + " on the latest math exam.");
		}
		


		/* Get values based on key */
		double var = hmap.get("David");
		System.out.println("Score for the student you've selected is: " + var);

		/* Remove values based on key */
		hmap.remove("David");
		System.out.println("Students left after removing the student you've selected:");
		Set set2 = hmap.entrySet();
		Iterator iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry mentry2 = (Map.Entry) iterator2.next();
			System.out.print(mentry2.getKey() + " with a score of ");
			System.out.println(mentry2.getValue());
		}

	}
}

class ValueComparator implements Comparator<String> {
    Map<String, Double> base;

    public ValueComparator(Map<String, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}