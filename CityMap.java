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
		ocstreet.put("Hotel", "Fourth Avenue");
		ocstreet.put("College","Fifth Ave");
		neighbors2.put("oc", ocstreet);

		
		//hotel neighbors
		hotellist.add("library");
		hotellist.add("diner");
		neighbors.put("hotel", hotellist);
		//hotel neighbor and streets
		hotelstreet.put("Diner", "Fourth Avenue"); //fix
		hotelstreet.put("Library","Bill Street"); //fix
		neighbors2.put("oc", hotelstreet);
		
		//library neighbors
		librarylist.add("cleveland");
		librarylist.add("hotel");
		neighbors.put("library", librarylist);
		//hotel neighbor and streets
		librarystreet.put("Cleveland", "Fifth Avenue"); //fix
		librarystreet.put("Hotel","Bill Street"); //fix
		neighbors2.put("oc", librarystreet);
		
		//college neighbors
		collegelist.add("library");
		collegelist.add("diner");
		neighbors.put("college", collegelist);
		//hotel neighbor and streets
		collegestreet.put("Library", "Fifth Avenue"); //fix
		collegestreet.put("Diner","Phil Street"); //fix
		neighbors2.put("oc", collegestreet);
		
		//diner neighbors
		dinerlist.add("college");
		dinerlist.add("philidelphia");
		neighbors.put("diner", dinerlist);
		//hotel neighbor and streets
		dinerstreet.put("Philidelphia", "Fourth Avenue"); //fix
		dinerstreet.put("College","Phil Street"); //fix
		neighbors2.put("oc", dinerstreet);
			
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
	
	public static String getStreet(String start, String end){
		
		return neighbors2.get(start).get(end);
	}


}
