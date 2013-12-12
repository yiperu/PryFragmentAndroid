package com.apps4s.pryfragmentandroid;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//import android.support.v4.app.*;

public class MainActivity extends FragmentActivity implements OnItemClickListener {

	String country = " ";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] arrayCountries = new String[]{"Peru","Brasil","Chile","Argentina","Ecuador","Bolivia","Venezuela","Colombia","Uruguay","Paraguay"};
		
		ArrayList<String> arrayListCountries = new ArrayList<String>(Arrays.asList(arrayCountries));
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), 
				android.R.layout.simple_list_item_1, arrayListCountries);
		
		ListView miListView = (ListView)findViewById(R.id.lstvPaises);
		miListView.setAdapter(arrayAdapter);
		miListView.setOnItemClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		boolean landScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
		MenuItem share = menu.getItem(menu.size() - 1);
		share.setVisible(landScape);
		
		return super.onPrepareOptionsMenu(menu);

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
	
	
	@Override
	public void onItemClick(AdapterView<?> adaptador, View view, int posicion, long arg3) {
		// TODO Auto-generated method stub
		
		country = (String) adaptador.getItemAtPosition(posicion).toString();
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			//FragmentManager manager = getSupportFragmentManager();
			android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
			CountryInfoFragment fragment = (CountryInfoFragment)manager.findFragmentById(R.id.fragmentCountryInfo);
			fragment.loadWebViewContent(country);
			
		} else {
			Intent intension = new Intent(this, CountryDetailActivity.class);
			intension.putExtra(CountryDetailActivity.COUNTRY, country);
			startActivity(intension);	
		}
				
	}

}
