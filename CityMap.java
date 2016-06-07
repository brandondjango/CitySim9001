import java.util.*;

public class CityMap {
	
	Hashtable<String, ArrayList<String>> neighbors = new Hashtable<String, ArrayList<String>>();
	
	
	public CityMap(){
		//CityMap constructor
		/*
		 Here we have a Hashtable(keys are strings, data is an ArrayList<string>)
		 and a Arraylist of strings.
		 
		 The arraylist is a temporary variable to hold the neighbors of a particular city,
		 
		 The hashtable store a cities neighbors in an arraylist, so if for example the 
		 key is Hotel, the corresponding data is an arraylist of the neighbors ["diner, "library"]
		 */
		
		ArrayList<String> list = new ArrayList<String>();
		
					
		//outside city neighbors
		list.add("college");
		list.add("hotel");
		neighbors.put("oc", list);
		
		//hotel neighbors
		list.clear();
		list.add("library");
		list.add("diner");
		neighbors.put("hotel", list);
		
		//library neighbors
		list.clear();
		list.add("cleveland");
		list.add("hotel");
		neighbors.put("library", list);
		
		//college neighbors
		list.clear();
		list.add("library");
		list.add("diner");
		neighbors.put("college", list);
		
		//diner neighbors
		list.clear();
		list.add("colege");
		list.add("philidelphia");
		neighbors.put("diner", list);
			
	}
	
	public ArrayList<String> getNeighbors(String city) {
		return neighbors.get(city);
	}

}
