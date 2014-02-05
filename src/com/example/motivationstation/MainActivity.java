package com.example.motivationstation;

import com.example.motivationstation.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

//Conor who Branch!!
//John's branch

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
    
    
    Button B1 = (Button) findViewById(R.id.AlarmButton);
    B1.setOnClickListener(new View.OnClickListener(){
    	
 
    	public void onClick(View v){
			Intent Alarm = new Intent("android.intent.action.Alarm");
			startActivity(Alarm); 
    		
    	}


    });
    
    }
}    

