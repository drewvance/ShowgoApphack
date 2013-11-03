package com.example.showgoapphack;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lineup extends Activity {
	private ArrayList<Band> bands;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lineup);
		
		Intent intent = getIntent();
        String message = intent.getStringExtra(Map.EVENT_ID);
        int id = Integer.parseInt(message);
        bands = ShowgoServer.GetBands(id);
        
        
        TextView bandname0 = (TextView)findViewById(R.id.band0);
        Button button0 = (Button)findViewById(R.id.play0);  
        if (bands.size() > 0) {
        	Band band0 = bands.get(0);
        	bandname0.setText(band0.Name);
        	if (band0.TrackStreamURL == null || band0.TrackStreamURL == "") {
        		button0.setVisibility(View.GONE);
        	}
        } else {
        	bandname0.setVisibility(View.GONE);
        	button0.setVisibility(View.GONE);
        }
        
        
        TextView bandname1 = (TextView)findViewById(R.id.band1);
        Button button1 = (Button)findViewById(R.id.play1);  
        if (bands.size() > 1) {
        	Band band1 = bands.get(1);
        	bandname1.setText(band1.Name);
        	if (band1.TrackStreamURL == null || band1.TrackStreamURL == "") {
        		button1.setVisibility(View.GONE);
        	}
        } else {
        	bandname1.setVisibility(View.GONE);
        	button1.setVisibility(View.GONE);
        }

        
        TextView bandname2 = (TextView)findViewById(R.id.band2);
        Button button2 = (Button)findViewById(R.id.play2);  
        if (bands.size() > 2) {
        	Band band2 = bands.get(2);
        	bandname2.setText(band2.Name);
        	if (band2.TrackStreamURL == null || band2.TrackStreamURL == "") {
        		button2.setVisibility(View.GONE);
        	}
        } else {
        	bandname2.setVisibility(View.GONE);
        	button2.setVisibility(View.GONE);
        }

        
        TextView bandname3 = (TextView)findViewById(R.id.band3);
        Button button3 = (Button)findViewById(R.id.play3);  
        if (bands.size() > 3) {
        	Band band3 = bands.get(3);
        	bandname3.setText(band3.Name);
        	if (band3.TrackStreamURL == null || band3.TrackStreamURL == "") {
        		button3.setVisibility(View.GONE);
        	}
        } else {
        	bandname3.setVisibility(View.GONE);
        	button3.setVisibility(View.GONE);
        }

        
        TextView bandname4 = (TextView)findViewById(R.id.band4);
        Button button4 = (Button)findViewById(R.id.play4);  
        if (bands.size() > 4) {
        	Band band4 = bands.get(4);
        	bandname4.setText(band4.Name);
        	if (band4.TrackStreamURL == null || band4.TrackStreamURL == "") {
        		button4.setVisibility(View.GONE);
        	}
        } else {
        	bandname4.setVisibility(View.GONE);
        	button4.setVisibility(View.GONE);
        }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lineup, menu);
		return true;
	}

	public void onPlay0(View view) {
		try {
			Button button = (Button)findViewById(R.id.play0);
			if (SoundcloudStream.IsPlaying()) {
				SoundcloudStream.StopStream();
				button.setText("Play");
			} else {
				SoundcloudStream.StartStream(bands.get(0).TrackStreamURL, this);
				button.setText("Stop");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void onPlay1(View view) {
		try {
			Button button = (Button)findViewById(R.id.play1);
			if (SoundcloudStream.IsPlaying()) {
				SoundcloudStream.StopStream();
				button.setText("Play");
			} else {
				SoundcloudStream.StartStream(bands.get(1).TrackStreamURL, this);
				button.setText("Stop");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onPlay2(View view) {
		
		try {
			Button button = (Button)findViewById(R.id.play2);
			if (SoundcloudStream.IsPlaying()) {
				SoundcloudStream.StopStream();
				button.setText("Play");
			} else {
				SoundcloudStream.StartStream(bands.get(2).TrackStreamURL, this);
				button.setText("Stop");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onPlay3(View view) {
		
		try {
			Button button = (Button)findViewById(R.id.play3);
			if (SoundcloudStream.IsPlaying()) {
				SoundcloudStream.StopStream();
				button.setText("Play");
			} else {
				SoundcloudStream.StartStream(bands.get(3).TrackStreamURL, this);
				button.setText("Stop");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onPlay4(View view) {
		try {
			Button button = (Button)findViewById(R.id.play4);
			if (SoundcloudStream.IsPlaying()) {
				SoundcloudStream.StopStream();
				button.setText("Play");
			} else {
				SoundcloudStream.StartStream(bands.get(4).TrackStreamURL, this);
				button.setText("Stop");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
