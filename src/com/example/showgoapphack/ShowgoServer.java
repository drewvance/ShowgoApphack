package com.example.showgoapphack;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowgoServer {
	private static final String SHOWGO_URL = "http://discovershowgo.com";
	
	public static ArrayList<Event> GetEvents(double upBoundLat, double upBoundLong, double lowBoundLat, double lowBoundLong) {
		ArrayList<Event> rv = new ArrayList<Event>();
		
		String url = SHOWGO_URL + "/events?";
		url += "date=2013-11-3&"; // TODO: Remove hard coded date. Use DateTime.Today or take it as a param
		url += "upboundLat=" + Double.toString(upBoundLat) + "&";
		url += "upboundLong=" + Double.toString(upBoundLong) + "&";
		url += "lowboundLat=" + Double.toString(lowBoundLat) + "&";
		url += "lowboundLong=" + Double.toString(lowBoundLong);
		
		GetJsonData getter = new GetJsonData();
		try {
			JSONObject json = getter.execute(url).get();
			
			JSONArray events = json.getJSONArray("results");

			
			for (int i = 0; i < events.length(); i++) {
				JSONObject json_object  = events.getJSONObject(i);
				JSONObject location = json_object.getJSONObject("location");
				
				Event foo = new Event();
				foo.Long = location.getDouble("lng");
				foo.Lat = location.getDouble("lat");
				foo.VenueName = json_object.getString("venue");
				foo.Id = json_object.getInt("id");
				rv.add(foo);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rv;
	}
	
	public static ArrayList<Band> GetBands(int eventId) {
		ArrayList<Band> rv = new ArrayList<Band>();
		
		String url = SHOWGO_URL + "/bands?event=" + Integer.toString(eventId);
		
		GetJsonData getter = new GetJsonData();
		try {
			JSONObject json = getter.execute(url).get();
			
			JSONArray bands = json.getJSONArray("results");

			
			for (int i = 0; i < bands.length(); i++) {
				JSONObject json_object  = bands.getJSONObject(i);
				
				Band band = new Band();
				band.Name = json_object.getString("band_name");
				
				
				JSONArray tracks = json_object.getJSONArray("tracks"); 
				if (tracks.length() > 0) {
					JSONObject track = tracks.getJSONObject(0);
					band.ArtUrl = track.getString("art_url");
					band.TrackStreamURL = track.getString("uri");	
				}
				
				rv.add(band);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rv;
	}
}
