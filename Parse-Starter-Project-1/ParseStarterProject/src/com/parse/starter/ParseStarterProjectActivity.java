package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parse.ParseAnalytics;

public class ParseStarterProjectActivity extends Activity {
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpenedInBackground(getIntent());
	}
	public void goToDropbox(View v)
	{
		Intent w = new Intent(this, DropboxActivity.class);
		startActivity(w);
	}
}
