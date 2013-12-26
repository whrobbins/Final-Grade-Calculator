package com.robbinsdev.finalgradecalculator;

import com.robbinsdev.finalgradecalculator.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener
{

	// declares the button and text fields in main layout
	Button calculate;
	EditText grade, wantedGrade, finalValue;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// when main activity is setup, initialize the objects in layout
		calculate = (Button) findViewById(R.id.button1);
		grade = (EditText) findViewById(R.id.editText1);
		wantedGrade = (EditText) findViewById(R.id.editText2);
		finalValue = (EditText) findViewById(R.id.editText3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** calculates the grade and alerts the result */
	public void reCalc(View view)  {
		// calculate the grade
		// (TotalGrade - (currentGrade * .8)) / .2) = finalGrade
		// where .8 and .2 are the values of the normal semester 
		// weight and final weight, respectively
		double target;
		double current = Double.parseDouble(grade.getText().toString());
		double desired = Double.parseDouble(wantedGrade.getText().toString());
		double finalWeight = Double.parseDouble(finalValue.getText().toString()) / 100;
		double normalWeight = 1.0 - finalWeight;
		
		target = (desired - (current * normalWeight)) / finalWeight; 
		target = round(target, 3);
		
		// Shows alert box with results
		AlertDialog gradeMessenger = new AlertDialog.Builder(this).create();     
		gradeMessenger.setMessage("You need  " + target + " percent on the final to get " + desired + " in the class.");
		gradeMessenger.setCancelable(true);
		gradeMessenger.setCanceledOnTouchOutside(true);
		gradeMessenger.show();
	}
	
	// rounds a number to n decimal places
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	// not sure if necessary, left blank for now
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
