package com.example.afjp;

import java.text.DecimalFormat;

import com.example.afjp.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity calculates the users Body Mass Index. User give input, length and weight.
 * @author Alexandra
 *
 */
public class BMI extends Activity {
	private TextView showNumber;
	private EditText length;
	private EditText weigth;
	private float fLength = (float) 0.0;
	private float fWeigth = (float) 0.0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmi);
		showNumber = (TextView) findViewById(R.id.TextViewAnswer);
        showNumber.setText(String.valueOf(0.0));
        length = (EditText) findViewById(R.id.editTextLength);
        weigth = (EditText) findViewById(R.id.editTextWeigth);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmi, menu);
		return true;
	}
	
	/**
     * When clicking one of the buttons.
     * @param view
     */
    public void onClick(View view) {
    	switch (view.getId()) {
        case R.id.buttonCompute:
        	showNumber.setText(String.valueOf(getBMI()));
            return;
	    case R.id.buttonReset:
	    	length.setText("");
	    	weigth.setText("");
	    	showNumber.setText(String.valueOf(0.0));
	        return;
		}
    }
    
    /**
     * Calculates the BMI. Check if input is proper.
     * @return
     */
    public String getBMI() {
    	DecimalFormat fmt = new DecimalFormat("0.0");
    	if (length.length() == 0) {
    		openDialog("False input values", "Enter a length."); 
    	} else {
    		fLength = Float.parseFloat(length.getText().toString());
    		if (fLength > 2.6) {
    			openDialog("False input values", "Enter a proper length.");
    			fLength = (float) 0.0;
    		}
    	}
    	
    	if (weigth.length() == 0) {
    		openDialog("False input values", "Enter a weigth.");            		
    	} else {
    		fWeigth = Float.parseFloat(weigth.getText().toString());
    		if (fWeigth > 300) {
    			openDialog("False input values", "Enter a proper weigth.");
    			fWeigth = (float) 0.0;
    		}
    	}
    	if (fLength!=0 && fWeigth!=0) {
    		return fmt.format(fWeigth/(fLength*fLength));
    	}
    	return "0.0";
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
