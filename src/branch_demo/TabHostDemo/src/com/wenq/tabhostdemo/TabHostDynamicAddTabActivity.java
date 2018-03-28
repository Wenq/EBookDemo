package com.wenq.tabhostdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TabHostDynamicAddTabActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_host_dynamic_add_tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab_host_dynamic_add_tab, menu);
		return true;
	}

}
