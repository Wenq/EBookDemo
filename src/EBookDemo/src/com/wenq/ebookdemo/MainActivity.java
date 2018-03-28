package com.wenq.ebookdemo;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity implements OnTabChangeListener {

	private TabHost tabPages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		tabPages = (TabHost) findViewById(R.id.tabPages);

		TabSpec tab1 = tabPages.newTabSpec("chapter 1");
		tabPages.addTab(tab1);
		TabSpec tab2 = tabPages.newTabSpec("chapter 2");
		tabPages.addTab(tab2);
		TabSpec tab3 = tabPages.newTabSpec("chapter 3");
		tabPages.addTab(tab3);
		TabSpec tab4 = tabPages.newTabSpec("chapter 4");
		tabPages.addTab(tab4);
		TabSpec tab5 = tabPages.newTabSpec("chapter 5");
		tabPages.addTab(tab5);
	}

	// tabҳ�л�֪ͨ
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub

	}

}
