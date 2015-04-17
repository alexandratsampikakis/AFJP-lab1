package com.example.afjp;

import com.example.afjp.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment.SavedState;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * This activity shows the color the user gives as input.
 * @author Alexandra
 *
 */
public class ColorDisplay extends Activity {
	private EditText red;
	private EditText green;
	private EditText blue;
	int r,g,b;
	String rC, gC, bC;
	View mlayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_color_display);
        red = (EditText) findViewById(R.id.editTextRed);
        green = (EditText) findViewById(R.id.editTextGreen);
        blue = (EditText) findViewById(R.id.editTextBlue);
        mlayout = (RelativeLayout)findViewById(R.id.laidout);
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.color_display, menu);
		return true;
	}
	
	/**
	 * Saves the input from user if screen is rotated.
	 */
	public void onSaveInstanceState(Bundle savedInstanceState) {
	  savedInstanceState.putInt("rC", r);
	  savedInstanceState.putInt("gC", g);
	  savedInstanceState.putInt("bC", b);
	  super.onSaveInstanceState(savedInstanceState);
	}
	
	/**
	 * Restores the saved input from user if screen has been rotated.
	 */
	public void onRestoreInstanceState(Bundle savedInstanceState) {		  
	  r = savedInstanceState.getInt("rC");
	  g = savedInstanceState.getInt("gC");
	  b = savedInstanceState.getInt("bC");
	  mlayout.setBackgroundColor(Color.rgb(r, g, b));
	  super.onRestoreInstanceState(savedInstanceState);
	}
	
	/**
     * When clicking one of the buttons.
     * @param view
     */
    public void onClick(View view) {
    	switch (view.getId()) {
        case R.id.buttonDisplayColor:
        	showColor();
            return;
		}
    }
    
    /**
     * Displays the color from user input. RGB, values between 0 and 255.
     */
    public void showColor() {
    	if (red.length() != 0) {
    		float reds = Float.parseFloat(red.getText().toString());
    		r = (int) reds;
    	} else {
    		r = 0;
    	}
    	if (green.length() != 0) {
	    	float greens = Float.parseFloat(green.getText().toString());
	    	g = (int) greens;
    	} else {
    		g = 0;
    	}
    	if (blue.length() != 0) {
	    	float blues = Float.parseFloat(blue.getText().toString());
	    	b = (int) blues;
    	} else {
    		b = 0;
    	}
    	if (r<256 && g<256 && b<256) {
    		mlayout.setBackgroundColor(Color.rgb(r, g, b));
    	} else {
    		openDialog("False input values", "Max is 255, you need to change the value(s).");
    		r=0;
    		g=0;
    		b=0;
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
