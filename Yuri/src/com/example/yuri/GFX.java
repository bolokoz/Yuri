package com.example.yuri;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class GFX extends Activity {

	MyBringBack ourView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//TEST TEST COMMIT
		//WAKE LOCK
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		ourView = new MyBringBack(this);
		setContentView(ourView);
	}

}
