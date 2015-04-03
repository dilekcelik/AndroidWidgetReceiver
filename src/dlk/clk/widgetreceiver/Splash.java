package dlk.clk.widgetreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{
	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle DilekLoveProgramming) {
		// TODO Auto-generated method stub
		super.onCreate(DilekLoveProgramming);
		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this, R.raw.splashsound);
		
		//If Preferences Check is checked play music otherwise not!
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		if (music==true)
		ourSong.start();
		
		
		Thread timer = new Thread() {
		public void run() {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				Intent MainActivity = new Intent ("android.intent.action.MENU");
				startActivity(MainActivity);
			}
		}};
		timer.start();
		
		
		
	
	}

	@Override
	protected void onPause() {
		super.onPause();
		ourSong.release();
		finish();
	}
	
}
