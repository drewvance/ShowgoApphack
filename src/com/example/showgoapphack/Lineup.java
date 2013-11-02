package com.example.showgoapphack;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class Lineup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lineup);
		
		Intent intent = getIntent();
        String message = intent.getStringExtra("EVENTID");
        
        ArrayList<Band> bands = ShowgoServer.GetBands(1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lineup, menu);
		return true;
	}

}
