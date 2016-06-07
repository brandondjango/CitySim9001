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
		
		ArrayList<String> oclist = new ArrayList<String>();
		ArrayList<String> hotellist = new ArrayList<String>();
		ArrayList<String> librarylist = new ArrayList<String>();
		ArrayList<String> collegelist = new ArrayList<String>();
		ArrayList<String> dinerlist = new ArrayList<String>();
		
		
					
		//outside city neighbors
		oclist.add("college");
		oclist.add("hotel");
		neighbors.put("oc", oclist);
		
		//hotel neighbors
		
		hotellist.add("library");
		hotellist.add("diner");
		neighbors.put("hotel", hotellist);
		
		//library neighbors
		
		librarylist.add("cleveland");
		librarylist.add("hotel");
		neighbors.put("library", librarylist);
		
		//college neighbors
		
		collegelist.add("library");
		collegelist.add("diner");
		neighbors.put("college", collegelist);
		
		//diner neighbors
		
		dinerlist.add("college");
		dinerlist.add("philidelphia");
		neighbors.put("diner", dinerlist);
			
	}
	
	public ArrayList<String> getNeighbors(String city) {
		System.out.print(neighbors);
		return neighbors.get(city);
	}

}
