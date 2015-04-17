package com.example.afjp;


import com.example.afjp.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/**
 * This activity generates ranodm numbers between 1 and 100 when pressing the button New Random.
 * @author Alexandra
 *
 */
public class Random extends Activity {
	private TextView showNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_random);
		showNumber = (TextView) findViewById(R.id.TextView1);
        showNumber.setText(String.valueOf(100));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.random, menu);
		return true;
	}
	
	/**
     * When the user click the button New Random.
     * @param view
     */
    public void onClick(View view) {
    	switch (view.getId()) {
        case R.id.buttonNewRandom:
        	showNumber.setText(String.valueOf(randomInt()));
            return;
    	}
    }
    
    
    /**
     * Generate a random number between 1 and 100 and returns it.
     * @return
     */
    public int randomInt() {
    	java.util.Random numberGen = new java.util.Random();
    	int number = numberGen.nextInt(100)+1;
    	return number;
    }

}
