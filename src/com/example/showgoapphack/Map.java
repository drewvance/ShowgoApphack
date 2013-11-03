package com.example.showgoapphack;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;

public class Map extends Activity {
    GoogleMap googleMap;

    LatLng myPosition;
    
	public final static String EVENT_ID = "EVENT_ID";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		// TODO: replace with map;
		Intent intent = new Intent(this, Lineup.class);
    	intent.putExtra(EVENT_ID, "1");
    	startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}
