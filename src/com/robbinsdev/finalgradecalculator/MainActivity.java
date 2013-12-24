package com.robbinsdev.finalgradecalculator;

import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener
{
	
	Button calculate;
	EditText grade, wantedGrade, finalValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
	public void reCalc(View view)
	{
		// calculate the grade
		// (Current grade * .8) + (Final grade * .2) = Total grade
		// TotalGrade - (current grade * .8) = finalgrade * .2
		// (TotalGrade - (currentGrade * .8)) / .2) = finalGrade
		double target;
		double current = Double.parseDouble(grade.getText().toString());
		double desired = Double.parseDouble(wantedGrade.getText().toString());
		double finalWeight = Double.parseDouble(finalValue.getText().toString()) / 100;
		double normalWeight = 1.0 - finalWeight;
		
		
		target = (desired - (current * normalWeight)) / finalWeight; 
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
