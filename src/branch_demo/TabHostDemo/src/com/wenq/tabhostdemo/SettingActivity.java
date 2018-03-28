package com.wenq.tabhostdemo;

import java.util.ArrayList;
import java.util.List;

import com.wenq.model.AppSettings;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class SettingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);

		ImageButton btnBack = (ImageButton) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		ListView lsSetting = (ListView) findViewById(R.id.lsSetting);
		lsSetting.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

				switch (arg2) {
				case 0:
					// App Style：Default，Light,Dark.
					new AlertDialog.Builder(SettingActivity.this)
							.setTitle("Please choose App Style")
							// .setIcon(android.R.drawable.ic_dialog_info)
							.setSingleChoiceItems(
									new String[] { "Default", "Light", "Dark" },
									0, new DialogInterface.OnClickListener() {

										public void onClick(
												DialogInterface dialog,
												int which) {

											// TODO:选中item
											Toast.makeText(
													SettingActivity.this,
													"choose Theme:" + which,
													Toast.LENGTH_SHORT).show();

											dialog.dismiss();
										}
									}).setNegativeButton("Cancel", null).show();

					break;
				case 1:
					// Font Size: Small，Middle，Big，Biggest.
					new AlertDialog.Builder(SettingActivity.this)
							.setTitle("Please choose Font Size")
							// .setIcon(android.R.drawable.ic_dialog_info)
							.setSingleChoiceItems(
									new String[] { "Small", "Middle", "Big",
											"Biggest" }, 0,
									new DialogInterface.OnClickListener() {

										public void onClick(
												DialogInterface dialog,
												int which) {

											// TODO:选中item
											Toast.makeText(
													SettingActivity.this,
													"choose Font Size:"
															+ AppSettings
																	.GetFontSize(which),
													Toast.LENGTH_SHORT).show();

											dialog.dismiss();
										}
									}).setNegativeButton("Cancel", null).show();
					break;
				default:
					Toast.makeText(SettingActivity.this,
							getResources().getString(R.string.UnknownInfo),
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		});

		// app style; font size
		lsSetting.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, getData()));
	}

	private List<String> getData() {

		List<String> data = new ArrayList<String>();
		data.add("App Style");
		data.add("Font Size");

		return data;
	}

}
