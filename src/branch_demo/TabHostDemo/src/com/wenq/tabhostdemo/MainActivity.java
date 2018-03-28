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

				// TODO:记录当前阅读page
				currentPageNum = Integer.valueOf(tabId);
			}
		});

		// // TODO：打开加载进度条窗口
		// ProgressDialog dialog = new ProgressDialog(MainActivity.this);
		// // 设置进度条风格，风格为圆形，旋转的
		// dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		// // 设置ProgressDialog 标题
		// dialog.setTitle("Tips");
		// // 设置ProgressDialog 提示信息
		// dialog.setMessage("Loading");
		// // 设置ProgressDialog 标题图标
		// dialog.setIcon(android.R.drawable.ic_dialog_map);
		// // 设置ProgressDialog 的进度条是否不明确
		// dialog.setIndeterminate(false);
		// // 设置ProgressDialog 是否可以按退回按键取消
		// dialog.setCancelable(false);
		// // 显示
		// dialog.show();

		InitData();

		// // TODO：关闭进度条窗口
		// dialog.dismiss();
		// dialog = null;

		// ////////////////////////youmi////////////////////////////

		AdManager.getInstance(this).init("4a5676747c2030de",
				"2784a95747e11f4c", false);

		// 实例化广告条
		AdView adView = new AdView(this, AdSize.FIT_SCREEN);

		// 获取要嵌入广告条的布局
		LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);

		// 将广告条加入到布局中
		adLayout.addView(adView);

		adView.setAdListener(new AdViewListener() {

			@Override
			public void onSwitchedAd(AdView adView) {
				// 切换广告并展示
			}

			@Override
			public void onReceivedAd(AdView adView) {
				// 请求广告成功
			}

			@Override
			public void onFailedToReceivedAd(AdView adView) {
				// 请求广告失败
			}
		});

		// //////////////////////////////////////////////////////////
	}

	// 初始化显示数据
	private void InitData() {

		BookLoader bookloader = new BookLoader();
		BookItem bookitem = bookloader.LoadBook(MainActivity.this);

		// 简介
		AddTab(bookitem.getPageLst().get(0), "INTRODUCE", 0, -1);
		// 目录
		AddTab(bookitem.getPageLst().get(1), "DIRECTORY", 1, -1);
		// 前言
		AddTab(bookitem.getPageLst().get(2), "FOREWORD", 2, -1);
		// 序一
		AddTab(bookitem.getPageLst().get(3), "PREFACE 一", 3, -1);
		// 序二
		AddTab(bookitem.getPageLst().get(4), "PREFACE 二", 4, -1);
		// 自序
		AddTab(bookitem.getPageLst().get(5), "AUTHOR'S PREFACE", 5, -1);

		int countPages = bookitem.getPageLst().size();
		// 章节内容
		if (countPages > 5) {
			int index = 1;
			for (int i = 6; i < countPages; i++, index++) {
				AddTab(bookitem.getPageLst().get(i), "CHAPTER " + index, i, -1);
			}
		}

		TabWidget tabWidget = tabHost.getTabWidget();
		// 标签的个数
		int count = tabWidget.getChildCount();
		// 获取手机屏幕的宽高
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int screenWidth = displayMetrics.widthPixels;
		if (count > 3) {
			for (int i = 0; i < count; i++) {
				// 设置每个标签的宽度，为屏幕的1/3
				tabWidget.getChildTabViewAt(i).setMinimumWidth(
						(screenWidth) / 3);
			}
		}

		// 恢复上次阅读进度
		int pagenum = PreferenceUtils.getPrefInt(MainActivity.this,
				AppSettings.KeyPageNumber, 0);
		if (pagenum < count) {
			tabHost.setCurrentTab(pagenum);

			// 设置选中的tabbutton可见
			View view = tabHost.getCurrentTabView();
			view.setFocusable(true);// 可以在xml中配置
			view.setFocusableInTouchMode(true);// 可以在xml中配置
			view.requestFocus();
			view.setFocusable(false); // 打开app，通过Focus使得选中的tabbutton可见，之后取消高亮。

			// HorizontalScrollView hv = (HorizontalScrollView)
			// findViewById(R.id.hstabwidget);
			// hv.scrollTo(1280, 0);
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub

		// 保存最后阅读页数
		PreferenceUtils.setPrefInt(MainActivity.this,
				AppSettings.KeyPageNumber, Integer.valueOf(currentPageNum));

		super.onDestroy();
	}

	// 动态添加章节Tab页
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

	// 章节Tab页
	private void AddTab(PageItem page, String tab, int tabid, int resId) {

		TabHost.TabSpec spec = tabHost.newTabSpec(String.valueOf(tabid)); // 设置tabid
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
		spec.setIndicator(tab); // 设置tabbutton上显示的文本
		tabHost.addTab(spec);
	}

	// 简介，目录Tab页
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
