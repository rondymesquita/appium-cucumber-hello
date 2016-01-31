package br.com.async.apptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText etName;
	private EditText etMusic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etName = (EditText)findViewById(R.id.etName);
		etMusic = (EditText)findViewById(R.id.etMusic);
		
		Button btnSend = (Button) findViewById(R.id.btnSend);
		btnSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openResultActivity();
			}
		});
	}
	
	
	private void openResultActivity(){
		Intent intent = new Intent(this, ResultActivity.class);
		
		String name = etName.getText().toString();
		String music = etMusic.getText().toString();
		
		Bundle bundle = new Bundle();
		bundle.putString(Constants.NAME, name);
		bundle.putString(Constants.MUSIC, music);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
