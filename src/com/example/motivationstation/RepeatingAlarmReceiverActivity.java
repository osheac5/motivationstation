package com.example.motivationstation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class RepeatingAlarmReceiverActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_reciever);
		
	    Button stopAlarm = (Button) findViewById(R.id.btnStopAlarm);
	    stopAlarm.setOnClickListener(new View.OnClickListener(){
	    	
	 
	    	public void onClick(View arg0){			//Called once Game/task has been completed
				finish();	
				}


	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.repeating_alarm_receiver, menu);
		return true;
	}

}