package com.example.afjp;

import com.example.afjp.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**
 * This activity is started from activity: MyCountries. Let the user give input,
 * country and year to present in the list from previous activity.
 * @author Alexandra
 *
 */
public class AddCountry extends Activity {
	String[] list;
	private EditText name, year;
	String nameS;
	int yearS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_country);		
		name = (EditText) findViewById(R.id.editTextCountry);
        year = (EditText) findViewById(R.id.editTextYear);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_country, menu);
		return true;
	}
	
	/**
     * When clicking one of the buttons.
     * @param view
     */
    public void onClick(View view) {
    	Intent addNewCountryIntent = new Intent();
    	switch (view.getId()) {
        case R.id.buttonCountryFinish:
    		nameS = name.getText().toString();
    		yearS = Integer.parseInt(year.getText().toString());
    		if(checkInput()) {
    			list = new String[] {yearS+"   "+nameS};
            	addNewCountryIntent.putExtra("MESSAGE", list);
        		setResult(RESULT_OK, addNewCountryIntent);
        		finish();
    		} else {
    			openDialog("Invalid input", "Change year to: 1900 < year < 2013 or name of country cannot be empty.");
    		}
    		
            return;
	    case R.id.buttonCountryCancel:
	    	setResult(RESULT_CANCELED, addNewCountryIntent);
			finish();
	        return;
		}
    }
    
    /**
     * Check if name of country is not empty and if year is valid.
     * @return
     */
    public boolean checkInput() {
    	if(nameS.equals("") || yearS < 1900 || yearS > 2013 ) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    /**
     * Opens a dialog with information.
     */
    public void openDialog(String title, String message) {
    	new AlertDialog.Builder(this)
    	    .setTitle(title)
    	    .setMessage(message)
    	    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dialog, int which) { 
    	            dialog.cancel();	        }
    	    })
    	    .show();
    }

}
