package com.song.ebuy;

import com.song.util.HttpUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private  Button  jsonbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		jsonbtn = (Button) findViewById(R.id.button1);
		jsonbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String url ="http://10.0.2.2/ebuy/data.php";
				String msg = HttpUtil.getRequest(url);
				Toast.makeText(MainActivity.this, msg, 0);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
