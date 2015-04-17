package com.example.afjp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.afjp.R;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * This activity shows a list of visited countries and what year the countries was visited.
 * @author Alexandra
 *
 */
public class MyCountries extends Activity {
	ArrayList<String> list;
	ListView listview;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_countries);

		listview = (ListView) findViewById(R.id.listViewCountries);

		list = new ArrayList<String>();
		list.clear();

		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_countries, menu);
		return true;
	}

	/**
	 * When clicking the Add country button.
	 * @param view
	 */
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.buttonAddCountry:
			Intent addNewCountryIntent = new Intent(this, AddCountry.class);
			startActivityForResult(addNewCountryIntent, 1);
			return;
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		outState.putStringArrayList("countries", list);
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		list = savedInstanceState.getStringArrayList("countries");
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);
		super.onRestoreInstanceState(savedInstanceState);
	}

	
	@Override
	/**
	 * Call Back method to get the Message form other Activity - override the method
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub    
		if(requestCode == 1) {

			if(resultCode == RESULT_OK) {
				String[] message = data.getStringArrayExtra("MESSAGE");
				for(int i=0; i<message.length; i++) {
					list.add(i,message[i]);
				}
				adapter.notifyDataSetChanged();

			} else if(resultCode == RESULT_CANCELED) {

			}
		}	       
	}


}
