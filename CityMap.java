/*
 Hard coded city map. This map determines where our drivers can travel.
 
 CityMap can show a list of all the cities, the neighbors of a particular city, and 
 can tell which street is between two cities.
 
 
 */

import java.util.*;

public class CityMap {
	
	Hashtable<String, ArrayList<String>> neighbors = new Hashtable<String, ArrayList<String>>();
	Hashtable<String, Hashtable<String, String>> neighbors2 = new Hashtable<String, Hashtable<String, String>>();
	
	public CityMap(){
		//CityMap constructor
		/*
		 Here we have a Hashtable(keys are strings, data is an ArrayList<string>)
		 and a Arraylist of strings.
		 
		 The arraylist is a temporary variable to hold the neighbors of a particular city,
		 
		 The hashtable store a cities neighbors in an arraylist, so if for example the 
		 key is Hotel, the corresponding data is an arraylist of the neighbors ["diner, "library"]
		 */
	
		Hashtable<String, String> ocstreet = new Hashtable<String, String>();
		Hashtable<String, String> hotelstreet = new Hashtable<String, String>();
		Hashtable<String, String> librarystreet = new Hashtable<String, String>();
		Hashtable<String, String> collegestreet = new Hashtable<String, String>();
		Hashtable<String, String> dinerstreet = new Hashtable<String, String>();
		
		ArrayList<String> oclist = new ArrayList<String>();
		ArrayList<String> hotellist = new ArrayList<String>();
		ArrayList<String> librarylist = new ArrayList<String>();
		ArrayList<String> collegelist = new ArrayList<String>();
		ArrayList<String> dinerlist = new ArrayList<String>();
				
		//outside city neighbors
		oclist.add("college");
		oclist.add("hotel");
		neighbors.put("oc", oclist);	
		//neighbors and street names
		ocstreet.put("hotel", "Fourth Avenue");
		ocstreet.put("college","Fifth Avenue");
		neighbors2.put("oc", ocstreet);
		
		//hotel neighbors
		hotellist.add("library");
		hotellist.add("diner");
		neighbors.put("hotel", hotellist);
		//hotel neighbor and streets
		hotelstreet.put("diner", "Fourth Avenue"); //fix
		hotelstreet.put("library","Bill Street"); //fix
		neighbors2.put("hotel", hotelstreet);
		
		//library neighbors
		librarylist.add("cleveland");
		librarylist.add("hotel");
		neighbors.put("library", librarylist);
		//hotel neighbor and streets
		librarystreet.put("cleveland", "Fifth Avenue"); //fix
		librarystreet.put("hotel","Bill Street"); //fix
		neighbors2.put("library", librarystreet);
		
		//college neighbors
		collegelist.add("library");
		collegelist.add("diner");
		neighbors.put("college", collegelist);
		//hotel neighbor and streets
		collegestreet.put("library", "Fifth Avenue"); //fix
		collegestreet.put("diner","Phil Street"); //fix
		neighbors2.put("college", collegestreet);
		
		//diner neighbors
		dinerlist.add("college");
		dinerlist.add("philidelphia");
		neighbors.put("diner", dinerlist);
		//hotel neighbor and streets
		dinerstreet.put("philidelphia", "Fourth Avenue"); //fix
		dinerstreet.put("college","Phil Street"); //fix
		neighbors2.put("diner", dinerstreet);
			
	}
	
	public ArrayList<String> getCities() {
		ArrayList<String> arrayList = new ArrayList<String>();
		for (String str : neighbors.keySet())  
		    arrayList.add(str);
		
		return arrayList;
	}
	
	public ArrayList<String> getNeighbors(String city) {
		return neighbors.get(city);
	}
	
	public String getStreet(String start, String end){
		
		return neighbors2.get(start).get(end);
	}
	
	
}
