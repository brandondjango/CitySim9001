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
		 key is Hotel, the corresponding data is an arraylist of the neighbors ["Diner, "Library"]
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
		oclist.add("College");
		oclist.add("Hotel");
		neighbors.put("oc", oclist);	
		//neighbors and street names
		ocstreet.put("Hotel", "Fourth Avenue");
		ocstreet.put("College","Fifth Ave");
		neighbors2.put("oc", ocstreet);
		
		//Hotel neighbors
		hotellist.add("Library");
		hotellist.add("Diner");
		neighbors.put("Hotel", hotellist);
		//Hotel neighbor and streets
		hotelstreet.put("Diner", "Fourth Avenue"); //fix
		hotelstreet.put("Library","Bill Street"); //fix
		neighbors2.put("Hotel", hotelstreet);
		
		//Library neighbors
		librarylist.add("Cleveland");
		librarylist.add("Hotel");
		neighbors.put("Library", librarylist);
		//Hotel neighbor and streets
		librarystreet.put("Cleveland", "Fifth Avenue"); //fix
		librarystreet.put("Hotel","Bill Street"); //fix
		neighbors2.put("Library", librarystreet);
		
		//College neighbors
		collegelist.add("Library");
		collegelist.add("Diner");
		neighbors.put("College", collegelist);
		//Hotel neighbor and streets
		collegestreet.put("Library", "Fifth Avenue"); //fix
		collegestreet.put("Diner","Phil Street"); //fix
		neighbors2.put("College", collegestreet);
		
		//Diner neighbors
		dinerlist.add("College");
		dinerlist.add("Philidelphia");
		neighbors.put("Diner", dinerlist);
		//Hotel neighbor and streets
		dinerstreet.put("Philidelphia", "Fourth Avenue"); //fix
		dinerstreet.put("College","Phil Street"); //fix
		neighbors2.put("Diner", dinerstreet);
			
	}
	
	public ArrayList<String> getCities() {
		ArrayList<String> arrayList = new ArrayList<String>();
		for (String str : neighbors.keySet())  
		    arrayList.add(str);
		
		return arrayList;
	}
	
	public ArrayList<String> getNeighbors(String city) {
		//System.out.print(neighbors);
		return neighbors.get(city);
	}
	
	public String getStreet(String start, String end){
		
		if (neighbors.get(start).contains(end))
		{
			return neighbors2.get(start).get(end);
		}
		else{
			return null;
		}
	}


}
