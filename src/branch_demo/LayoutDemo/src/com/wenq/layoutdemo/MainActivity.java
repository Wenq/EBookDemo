package com.wenq.layoutdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button btn1, btn2, btn3, btn4, btn5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.btn1:
			setContentView(R.layout.linearlayoutdemo);
			break;
		case R.id.btn2:
			setContentView(R.layout.framelayoutdemo);
			break;
		case R.id.btn3:
			setContentView(R.layout.absolutelayout);
			break;
		case R.id.btn4:
			setContentView(R.layout.relativelayoutdemo);
			break;
		case R.id.btn5:
			setContentView(R.layout.tablelayout);
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			setContentView(R.layout.activity_main);
		}

		return true;
		// return super.onKeyDown(keyCode, event);
	}

}
