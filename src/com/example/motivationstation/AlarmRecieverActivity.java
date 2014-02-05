package com.example.motivationstation;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class AlarmRecieverActivity extends Activity {
	private MediaPlayer mMediaPlayer;
	private	PowerManager.WakeLock mWakeLock;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE); //Using PowerManager
		mWakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Keep Screen On");//to make sure screen doesn't turn
		mWakeLock.acquire();													//off while alarm is playing	
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN |
			WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
			WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON ,
			WindowManager.LayoutParams.FLAG_FULLSCREEN|
			WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
			WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		setContentView(R.layout.activity_alarm_reciever);
		
	    Button stopAlarm = (Button) findViewById(R.id.btnStopAlarm);
	    stopAlarm.setOnClickListener(new View.OnClickListener(){
	    	
	 
	    	public void onClick(View arg0){			//Called once Game/task has been completed
				mMediaPlayer.stop();				//in this case only refers to clickng the button
				finish();	}


	    });
		// Show the Up button in the action bar.
		playSound(this, getAlarmUri());
	}
//Gets alarm sound. Could adjust so it in previous activity displays all sounds and user get chose to choice
	private Uri getAlarmUri() {
			//Self explanatory method 
		Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
		if( alert == null)
	{
			alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			if( alert == null){
			alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
				}
	}
		return alert;	
	}

	private void playSound(Context context, Uri alert){
		
		mMediaPlayer = new MediaPlayer();
		try{
			
			mMediaPlayer.setDataSource(context, alert); //Check if audiofiles are available
			final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
			
			int max = audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM);
			audioManager.setStreamVolume(AudioManager.STREAM_ALARM, max, 0);
			

			
			mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
			mMediaPlayer.prepare();
			mMediaPlayer.start();
			
		} catch (IOException e){
			Log.i("AlarmReciever","No audio files are found"); //Debugging Mechanism
		}
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm_reciever, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	protected void onStop(){
		
		super.onStop();
		mWakeLock.release();
	}

}
