package com.example.yuri;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{

	MediaPlayer splashSound;
	@Override
	protected void onCreate(Bundle YuriBecker) {
		// TODO Auto-generated method stub
		super.onCreate(YuriBecker);
		setContentView(R.layout.splash);
		splashSound = MediaPlayer.create(Splash.this, R.raw.yuri);
		
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		if(music == true){
		splashSound.start();
		}
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.example.yuri.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		splashSound.release(); 
		finish();
	}
	
	
	

}
