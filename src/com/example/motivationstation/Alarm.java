package com.example.motivationstation;

import android.R.string;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlarmManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import 	android.app.PendingIntent;
import 	java.lang.System;
import 	android.widget.Toast;
import 	android.content.Context;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;


public class Alarm extends Activity {
	
		
		
		private Button mbtnSetAlarm1, mbtnSetAlarm2, mbtnStopAlarm;
		private EditText mTxtSeconds;
		private Toast mToast;

		//Toast toast = Toast.makeText( getApplicationContext(), harry , Toast.LENGTH_LONG);

		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		long Time = (System.currentTimeMillis()/10000);
		Context context = getApplicationContext();

		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		
		mbtnSetAlarm1 = (Button) findViewById(R.id.btnSetAlarm1);
		mbtnSetAlarm2 = (Button) findViewById(R.id.btnSetAlarm2);
		mbtnStopAlarm = (Button) findViewById(R.id.btnStopAlarm);
		mTxtSeconds = (EditText) findViewById(R.id.txtSeconds);

		
		mbtnSetAlarm1.setOnClickListener(new OnClickListener(){
			
			
		
			public void onClick(View view){
				try{		
					//long epoch = new java.text.SimpleDateFormat("02/01/1970 01:00:00").parse("02/02/1970 01:00:00").getTime() / 1000;
					////////////////////////////////////////////////////////
			        String str = "2013-04-26 08:34:55";
			        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        Date formateDate = (Date) df.parse(str);
			        long epoch = formateDate.getTime();
			        
					////////////////////////////////////////////////////////
					//try called incase  invalid field or empty field entered into seconds
					int i = Integer.parseInt(mTxtSeconds.getText().toString());
					Intent intent = new Intent(Alarm.this, AlarmRecieverActivity.class);	//Intent passed from THIS class onto AlarmRecieverActivity.class
					
					PendingIntent pendingIntent = PendingIntent.getActivity(Alarm.this, 2, intent, PendingIntent.FLAG_CANCEL_CURRENT);//Future alarm
		
		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent); //2nd parameter decides when in the future the alarm will go off.
				
		if (mToast != null){
				mToast.cancel();	
				}
		mToast = Toast.makeText(getApplicationContext(),"Alarm for the Activity is set in " + i + "seconds", Toast.LENGTH_LONG);
		mToast.show();
		} 
				catch(NumberFormatException e){
				if(mToast != null){
					mToast.cancel();
				}
				mToast = Toast.makeText(Alarm.this, "Please enter some number in the text field and try again!", Toast.LENGTH_LONG);
				mToast.show();
				Log.i("Alarm" ,"Number format exception");
			} 
			/*catch (ParseException e) {
				mToast = Toast.makeText(Alarm.this, "unable to convert to epoch time", Toast.LENGTH_LONG);
				mToast.show();
				// TODO Auto-generated catch block
					e.printStackTrace();
				}*/ catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			});
	
		mbtnStopAlarm.setOnClickListener(new OnClickListener(){
			
			
			public void onClick(View view){
					//try called incase  invalid field or empty field entered into seconds
				
					Intent intent = new Intent(Alarm.this, AlarmRecieverActivity.class);	//Intent passed from THIS class onto AlarmRecieverActivity.class
					
					PendingIntent pendingIntent = PendingIntent.getActivity(Alarm.this, 3, intent, 0);//Future alarm
		
		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		am.cancel(pendingIntent);
				
		if (mToast != null){
				mToast.cancel();	
				}
		mToast = Toast.makeText(getApplicationContext(),"Alarm for the Activity hasbeen canceled", Toast.LENGTH_LONG);
		mToast.show();
		

				
			}
			
			});
	
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
		getMenuInflater().inflate(R.menu.alarm, menu);
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
	



}
	


