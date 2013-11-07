package com.example.showgoapphack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;

public class Map extends Activity {
    private GoogleMap googleMap;

    private HashMap<Marker, Event> eventMarkerMap = new HashMap<Marker, Event>();    
    
	public final static String EVENT_ID = "EVENT_ID";
	public final static String VENUE_NAME = "VENUE_NAME";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
        MapFragment fm = (MapFragment)getFragmentManager().findFragmentById(R.id.map);

        // Getting GoogleMap object from the fragment
        googleMap = fm.getMap();

        // Enabling MyLocation Layer of Google Map
        googleMap.setMyLocationEnabled(true);

        // Getting LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Getting Current Location
        Location location = locationManager.getLastKnownLocation(provider);

        if(location!=null){
                // Getting latitude of the current location
                double latitude = location.getLatitude();
        
                // Getting longitude of the current location
                double longitude = location.getLongitude();
        
                // Creating a LatLng object for the current location
                LatLng latLng = new LatLng(latitude, longitude);
                
                CameraUpdate center =
                    CameraUpdateFactory.newLatLng(latLng);
                    CameraUpdate zoom = CameraUpdateFactory.zoomTo(10);

                googleMap.moveCamera(center);
                googleMap.animateCamera(zoom);
                
                googleMap.setOnCameraChangeListener(new OnCameraChangeListener() {
					
					@Override
					public void onCameraChange(CameraPosition position) {
						// TODO Broader map boundaries needed
		                //LatLngBounds mapBoundary = googleMap.getProjection().getVisibleRegion().latLngBounds;
		                //ArrayList<Event> events =  ShowgoServer.GetEvents(mapBoundary.northeast.latitude, mapBoundary.southwest.longitude, mapBoundary.southwest.latitude, mapBoundary.northeast.longitude);
		                
						//Temporary Seattle boundaries for demo
		                ArrayList<Event> events =  ShowgoServer.GetEvents(48.00, -121.00, 46.00, -123);
		                
		                ListIterator eventsItr  = events.listIterator();
		                    
		                //googleMap.clear();
		                   
		                while(eventsItr.hasNext()){
		                	Event event = (Event)eventsItr.next();
		                 	Marker marker = googleMap.addMarker(new MarkerOptions().position(new LatLng(event.Lat, event.Long)).title(event.VenueName + event.Id));
		                 	eventMarkerMap.put(marker, event);
		                 	//Intent intent = new Intent(this, Lineup.class);
		                	//intent.putExtra(EVENT_ID, "1");
		                	//startActivity(intent);
		                }
					}
                });
                
                googleMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
					
					@Override
					public void onInfoWindowClick(Marker marker) {
						Event event = eventMarkerMap.get(marker);	
						Intent intent = new Intent(Map.this, Lineup.class);
						intent.putExtra(EVENT_ID, event.Id);
						intent.putExtra(VENUE_NAME, event.VenueName);
						startActivity(intent);
					}
				});
        }
		
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}

