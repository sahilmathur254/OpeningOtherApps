package com.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button b1, b2, b3, b4;
	int request_code = 1;
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //---- Fetching Buttons ----//
        //===== Web Browser Button =====
        b1 = (Button) findViewById(R.id.btn_webbrowser);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.co.in"));
				startActivity(i);
			}
		});
        
      //===== Make Calls Button =====
        b2 = (Button) findViewById(R.id.btn_makecalls);
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +919314669334"));
				startActivity(i);
			}
		});
        
      //===== Show Map Button =====
        b3 = (Button) findViewById(R.id.btn_showMap);
        b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.827500,-122.481670"));
				startActivity(i);
			}
		});
        
      //===== Choose Contact Button =====
        b4 = (Button) findViewById(R.id.btn_chooseContact);
        b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_PICK);
				i.setType(ContactsContract.Contacts.CONTENT_TYPE);
				startActivityForResult(i, request_code);
			}
		});
      
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
    	if(requestCode == request_code){
    		if(resultCode == RESULT_OK){
    			Toast.makeText(this, data.getData().toString(), Toast.LENGTH_LONG).show();
    			Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getData().toString()));
    			startActivity(i);
    		}
    	}
    }
}