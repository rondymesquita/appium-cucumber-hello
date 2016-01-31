package br.com.async.apptest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		Bundle extras = getIntent().getExtras();
		String name = extras.getString(Constants.NAME);
		String music = extras.getString(Constants.MUSIC);
		
		TextView tvResult = (TextView)findViewById(R.id.tvResult);
		String resultText = name+" likes "+music;
		tvResult.setText(resultText);
	}

}
