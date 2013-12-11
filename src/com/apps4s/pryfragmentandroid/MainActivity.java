package com.apps4s.pryfragmentandroid;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity implements OnItemClickListener {

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
	public void onItemClick(AdapterView<?> adaptador, View view, int posicion, long arg3) {
		// TODO Auto-generated method stub
		String country = (String) adaptador.getItemAtPosition(posicion).toString();
		Intent intension = new Intent(this, CountryDetailActivity.class);
		intension.putExtra(CountryDetailActivity.COUNTRY, country);
		startActivity(intension);
		
		
	}

}
