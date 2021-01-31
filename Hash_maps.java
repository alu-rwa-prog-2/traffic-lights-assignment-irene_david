import java.util.HashMap;
import java.util.*;
public class Hash_maps {

	public static void main(String[] args) {
		//creating hashmaps
		HashMap <Integer, String> hash_map1 = new HashMap <Integer, String>();
		HashMap <Integer, String> hash_map2 = new HashMap <Integer, String>();
		HashMap <Integer, String> hash_map3 = new HashMap <Integer, String> ();
		//Insert data
		hash_map1.put(1, "Discrete Maths");
	    hash_map1.put(2, "MFC");
	    hash_map1.put(3, "Python");
	    System.out.println("\nAttributes in the First :" + hash_map1);
	    hash_map2.put(4, "Java");
	    hash_map2.put(5, "Web Dev");
	    hash_map2.put(6, "DSA");
	    System.out.println("\nAttributes in the second :" + hash_map2);
	    hash_map3.put(7, "Software Engineer");
	    hash_map3.put(8, "Javascript");
	    hash_map3.put(9, "Cuber Security");
	    System.out.println("\nAttributes in third :" + hash_map3);
	    //put into map 3
	    hash_map3.putAll(hash_map1);
	    hash_map3.putAll(hash_map2);
	    System.out.println("\nNow Let's see all values in the Third map:" + hash_map3);

	}

}
