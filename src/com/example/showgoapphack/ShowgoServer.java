package com.example.showgoapphack;

import java.util.ArrayList;

public class ShowgoServer {

	public static ArrayList<Event> GetEvents(double upBoundLat, double upBoundLong, double lowBoundLat, double lowBoundLong) {
		ArrayList<Event> rv = new ArrayList<Event>();
		
		Event foo = new Event();
		foo.Long = lowBoundLong + ((upBoundLong - lowBoundLong)/2);
		foo.Lat = lowBoundLat + ((upBoundLat - lowBoundLat)/2);
		foo.VenueName = "foo";
		rv.add(foo);
		return rv;
	}
	
	
}
