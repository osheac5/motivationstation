package com.example.motivationstation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AnnoyingWordGame extends Activity {

	String s, j;
	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.wordgame);

		TextView tv = (TextView)findViewById(R.id.textView1);
		
		s = Long.toHexString(Double.doubleToLongBits(Math.random()));
	
		tv.setText(s);
	
		j = reverseNL("s");
	
		
}

	public static String reverseNL (String s){
		
	    return new StringBuffer(s).reverse().toString();
	    
	}
	
}
