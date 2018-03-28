package com.wenq.tabhostdemo;

import net.youmi.android.AdManager;
import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;
import net.youmi.android.banner.AdViewListener;

import com.wenq.model.AppSettings;
import com.wenq.model.BookItem;
import com.wenq.model.BookLoader;
import com.wenq.model.PageItem;
import com.wenq.utils.PreferenceUtils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TabHost tabHost;
	private ImageButton btnSetting;
	private ImageButton btnAbout;

	private int currentPageNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnSetting = (ImageButton) findViewById(R.id.btnSetting);
		btnAbout = (ImageButton) findViewById(R.id.btnAbout);

		btnSetting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent setting = new Intent();
				setting.setClass(MainActivity.this, SettingActivity.class);
				startActivity(setting);

			}
		});
		btnAbout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent about = new Intent();
				about.setClass(MainActivity.this, AboutActivity.class);
				startActivity(about);
			}
		});

		tabHost = (TabHost) findViewById(R.id.tabHost);
		tabHost.setup();

		tabHost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub

				// TODO:��¼��ǰ�Ķ�page
				currentPageNum = Integer.valueOf(tabId);
			}
		});

		// // TODO���򿪼��ؽ���������
		// ProgressDialog dialog = new ProgressDialog(MainActivity.this);
		// // ���ý�������񣬷��ΪԲ�Σ���ת��
		// dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		// // ����ProgressDialog ����
		// dialog.setTitle("Tips");
		// // ����ProgressDialog ��ʾ��Ϣ
		// dialog.setMessage("Loading");
		// // ����ProgressDialog ����ͼ��
		// dialog.setIcon(android.R.drawable.ic_dialog_map);
		// // ����ProgressDialog �Ľ������Ƿ���ȷ
		// dialog.setIndeterminate(false);
		// // ����ProgressDialog �Ƿ���԰��˻ذ���ȡ��
		// dialog.setCancelable(false);
		// // ��ʾ
		// dialog.show();

		InitData();

		// // TODO���رս���������
		// dialog.dismiss();
		// dialog = null;

		// ////////////////////////youmi////////////////////////////

		AdManager.getInstance(this).init("4a5676747c2030de",
				"2784a95747e11f4c", false);

		// ʵ���������
		AdView adView = new AdView(this, AdSize.FIT_SCREEN);

		// ��ȡҪǶ�������Ĳ���
		LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);

		// ����������뵽������
		adLayout.addView(adView);

		adView.setAdListener(new AdViewListener() {

			@Override
			public void onSwitchedAd(AdView adView) {
				// �л���沢չʾ
			}

			@Override
			public void onReceivedAd(AdView adView) {
				// ������ɹ�
			}

			@Override
			public void onFailedToReceivedAd(AdView adView) {
				// ������ʧ��
			}
		});

		// //////////////////////////////////////////////////////////
	}

	// ��ʼ����ʾ����
	private void InitData() {

		BookLoader bookloader = new BookLoader();
		BookItem bookitem = bookloader.LoadBook(MainActivity.this);

		// ���
		AddTab(bookitem.getPageLst().get(0), "INTRODUCE", 0, -1);
		// Ŀ¼
		AddTab(bookitem.getPageLst().get(1), "DIRECTORY", 1, -1);
		// ǰ��
		AddTab(bookitem.getPageLst().get(2), "FOREWORD", 2, -1);
		// ��һ
		AddTab(bookitem.getPageLst().get(3), "PREFACE һ", 3, -1);
		// ���
		AddTab(bookitem.getPageLst().get(4), "PREFACE ��", 4, -1);
		// ����
		AddTab(bookitem.getPageLst().get(5), "AUTHOR'S PREFACE", 5, -1);

		int countPages = bookitem.getPageLst().size();
		// �½�����
		if (countPages > 5) {
			int index = 1;
			for (int i = 6; i < countPages; i++, index++) {
				AddTab(bookitem.getPageLst().get(i), "CHAPTER " + index, i, -1);
			}
		}

		TabWidget tabWidget = tabHost.getTabWidget();
		// ��ǩ�ĸ���
		int count = tabWidget.getChildCount();
		// ��ȡ�ֻ���Ļ�Ŀ��
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int screenWidth = displayMetrics.widthPixels;
		if (count > 3) {
			for (int i = 0; i < count; i++) {
				// ����ÿ����ǩ�Ŀ�ȣ�Ϊ��Ļ��1/3
				tabWidget.getChildTabViewAt(i).setMinimumWidth(
						(screenWidth) / 3);
			}
		}

		// �ָ��ϴ��Ķ�����
		int pagenum = PreferenceUtils.getPrefInt(MainActivity.this,
				AppSettings.KeyPageNumber, 0);
		if (pagenum < count) {
			tabHost.setCurrentTab(pagenum);

			// ����ѡ�е�tabbutton�ɼ�
			View view = tabHost.getCurrentTabView();
			view.setFocusable(true);// ������xml������
			view.setFocusableInTouchMode(true);// ������xml������
			view.requestFocus();
			view.setFocusable(false); // ��app��ͨ��Focusʹ��ѡ�е�tabbutton�ɼ���֮��ȡ��������

			// HorizontalScrollView hv = (HorizontalScrollView)
			// findViewById(R.id.hstabwidget);
			// hv.scrollTo(1280, 0);
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub

		// ��������Ķ�ҳ��
		PreferenceUtils.setPrefInt(MainActivity.this,
				AppSettings.KeyPageNumber, Integer.valueOf(currentPageNum));

		super.onDestroy();
	}

	// ��̬����½�Tabҳ
	private void AddTab(String tab, int resId) {

		TabHost.TabSpec spec = tabHost.newTabSpec("tag1");
		spec.setContent(new TabHost.TabContentFactory() {

			public View createTabContent(String tag) {
				// return new AnalogClock(MainActivity.this);
				return LayoutInflater.from(MainActivity.this).inflate(
						R.layout.tabitem, null);
			}

		});
		spec.setIndicator(tab);
		tabHost.addTab(spec);

	}

	// �½�Tabҳ
	private void AddTab(PageItem page, String tab, int tabid, int resId) {

		TabHost.TabSpec spec = tabHost.newTabSpec(String.valueOf(tabid)); // ����tabid
		final String content = page.getPageContent();
		spec.setContent(new TabHost.TabContentFactory() {

			public View createTabContent(String tag) {

				View view = LayoutInflater.from(MainActivity.this).inflate(
						R.layout.tabitem, null);
				TextView txt = ((TextView) view.findViewById(R.id.txtContent));
				txt.setText(content);

				return view;
			}

		});
		spec.setIndicator(tab); // ����tabbutton����ʾ���ı�
		tabHost.addTab(spec);
	}

	// ��飬Ŀ¼Tabҳ
	private void AddTab(BookItem book, String tab, int resId) {

		TabHost.TabSpec spec = tabHost.newTabSpec("tag1");
		final String content = book.getBookIntroduce();
		spec.setContent(new TabHost.TabContentFactory() {

			public View createTabContent(String tag) {

				View view = LayoutInflater.from(MainActivity.this).inflate(
						R.layout.tabitem, null);
				TextView txt = ((TextView) view.findViewById(R.id.txtContent));
				txt.setText(content);

				return view;
			}

		});
		spec.setIndicator(tab);
		tabHost.addTab(spec);
	}

}
