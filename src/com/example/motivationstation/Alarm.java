package com.example.motivationstation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class Alarm extends Activity {

		private Button mbtnSetAlarm1, mbtnSetAlarm2, mbtnStopAlarm;
		private EditText mTxtSeconds;
		private Toast mToast;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		
		mbtnSetAlarm1 = (Button) findViewById(R.id.btnSetAlarm1);
		mbtnSetAlarm2 = (Button) findViewById(R.id.btnSetAlarm2);
		mbtnStopAlarm = (Button) findViewById(R.id.btnStopAlarm);
		mTxtSeconds = (EditText) findViewById(R.id.txtSeconds);
		
		mbtnSetAlarm1.setOnClickListener(new OnClickListener(){
			public void onClick(View view){
				try{
				int i = Integer.parseInt(AlarmManagerActivity.this, 2, intent,)
			}
		};
		
		// Show the Up button in the action bar.
		setupActionBar();
	
	
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

