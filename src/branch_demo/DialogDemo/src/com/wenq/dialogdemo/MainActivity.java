package com.wenq.dialogdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 单选对话框
		Button btnSingle = (Button) findViewById(R.id.btnSingle);
		btnSingle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				new AlertDialog.Builder(MainActivity.this)
						.setTitle("Please choose Font Size")
						// .setIcon(android.R.drawable.ic_dialog_info)
						.setSingleChoiceItems(
								new String[] { "Small", "Middle", "Big",
										"Biggest" }, 0,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {

										// TODO:选中item
										Toast.makeText(MainActivity.this,
												"choose item index:" + which,
												Toast.LENGTH_SHORT).show();

										dialog.dismiss();
									}
								}).setNegativeButton("Cancel", null).show();
			}
		});
	}
}
