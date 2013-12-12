package com.apps4s.pryfragmentandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class CountryDetailActivity extends FragmentActivity {

	private String country = "";
	public static final String COUNTRY = "country";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_country_detail);
		
		Intent intent = getIntent();
		country = intent.getStringExtra(COUNTRY);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
	switch (item.getItemId()) {
		case R.id.action_compartir:
			if (!country.equals("")) {
				String url = "http://es.m.wikipedia.org/org/wiki/"+country;
				String msg = getString(R.string.msg_share, country, url);
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SEND);
				intent.putExtra(Intent.EXTRA_TEXT, msg);
				intent.setType("text/plain");
				startActivity(Intent.createChooser(intent, getString(R.string.mnu_compartir)));
			}
			return true;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
