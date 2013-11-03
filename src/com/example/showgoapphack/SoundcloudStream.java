package com.example.showgoapphack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;


public class SoundcloudStream {
	private static Boolean isPlaying = false;
	private static String SC_ACCESS = "4145e2efb28073e23d005b4f392fca73";
	private static MediaPlayer mediaPlayer = new MediaPlayer();
	public static void StartStream(String trackName, Context context) throws ClientProtocolException, IOException, URISyntaxException, InterruptedException, ExecutionException {
				
		String sUri =  trackName + "/stream/?consumer_key=" + SC_ACCESS;
		HttpClient client = new DefaultHttpClient();
		Uri uri = Uri.parse(sUri);
		
		mediaPlayer = new MediaPlayer();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		try {
			mediaPlayer.setDataSource(context, uri);
			mediaPlayer.prepare(); // might take long! (for buffering, etc)
			mediaPlayer.start();
			isPlaying = true;
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void StopStream() {
		mediaPlayer.stop();
		isPlaying = false;
	}
	
	public static Boolean IsPlaying() {
		return isPlaying;
	}
	
}
