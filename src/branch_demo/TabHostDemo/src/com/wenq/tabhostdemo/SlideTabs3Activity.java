package com.wenq.tabhostdemo;

import java.util.Random;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabWidget;
import android.widget.TextView;

//使用TabWidget和ViewPager实现可滑动的Tab
public class SlideTabs3Activity extends FragmentActivity {

	private static final String TAG = "AndroidDemos.SlideTabs3";

	private ViewPager mViewPager;
	private PagerAdapter mPagerAdapter;
	private TabWidget mTabWidget;
	private String[] addresses = { "first", "second", "third", "four", "five",
			"six" };
	private Button[] mBtnTabs = new Button[addresses.length];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide_tabs3);

		mTabWidget = (TabWidget) findViewById(R.id.tabWidget1);
		mTabWidget.setStripEnabled(false);

		mBtnTabs[0] = new Button(this);
		mBtnTabs[0].setFocusable(true);
		mBtnTabs[0].setText(addresses[0]);
		// mBtnTabs[0].setTextColor(getResources().getColorStateList(
		// R.color.button_bg_color_selector));
		mBtnTabs[0].setTextColor(getResources().getColorStateList(
				R.color.aliceblue));
		mTabWidget.addView(mBtnTabs[0]);
		/*
		 * Listener必须在mTabWidget.addView()之后再加入，用于覆盖默认的Listener，
		 * mTabWidget.addView()中默认的Listener没有NullPointer检测。
		 */
		mBtnTabs[0].setOnClickListener(mTabClickListener);

		mBtnTabs[1] = new Button(this);
		mBtnTabs[1].setFocusable(true);
		mBtnTabs[1].setText(addresses[1]);
		mBtnTabs[1].setTextColor(getResources().getColorStateList(
				R.color.antiquewhite));
		mTabWidget.addView(mBtnTabs[1]);
		mBtnTabs[1].setOnClickListener(mTabClickListener);

		mBtnTabs[2] = new Button(this);
		mBtnTabs[2].setFocusable(true);
		mBtnTabs[2].setText(addresses[2]);
		mBtnTabs[2]
				.setTextColor(getResources().getColorStateList(R.color.aqua));
		mTabWidget.addView(mBtnTabs[2]);
		mBtnTabs[2].setOnClickListener(mTabClickListener);

		mBtnTabs[3] = new Button(this);
		mBtnTabs[3].setFocusable(true);
		mBtnTabs[3].setText(addresses[3]);
		mBtnTabs[3]
				.setTextColor(getResources().getColorStateList(R.color.aqua));
		mTabWidget.addView(mBtnTabs[3]);
		mBtnTabs[3].setOnClickListener(mTabClickListener);

		mBtnTabs[4] = new Button(this);
		mBtnTabs[4].setFocusable(true);
		mBtnTabs[4].setText(addresses[4]);
		mBtnTabs[4]
				.setTextColor(getResources().getColorStateList(R.color.aqua));
		mTabWidget.addView(mBtnTabs[4]);
		mBtnTabs[4].setOnClickListener(mTabClickListener);

		mBtnTabs[5] = new Button(this);
		mBtnTabs[5].setFocusable(true);
		mBtnTabs[5].setText(addresses[2]);
		mBtnTabs[5]
				.setTextColor(getResources().getColorStateList(R.color.aqua));
		mTabWidget.addView(mBtnTabs[5]);
		mBtnTabs[5].setOnClickListener(mTabClickListener);

		mViewPager = (ViewPager) findViewById(R.id.viewPager1);
		mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setOnPageChangeListener(mPageChangeListener);

		mTabWidget.setCurrentTab(0);
	}

	private OnClickListener mTabClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (v == mBtnTabs[0]) {
				mViewPager.setCurrentItem(0);
			} else if (v == mBtnTabs[1]) {
				mViewPager.setCurrentItem(1);
			} else if (v == mBtnTabs[2]) {
				mViewPager.setCurrentItem(2);
			} else if (v == mBtnTabs[3]) {
				mViewPager.setCurrentItem(3);
			} else if (v == mBtnTabs[4]) {
				mViewPager.setCurrentItem(4);
			} else if (v == mBtnTabs[5]) {
				mViewPager.setCurrentItem(5);
			}
		}
	};

	private OnPageChangeListener mPageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			mTabWidget.setCurrentTab(arg0);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	private class MyPagerAdapter extends FragmentStatePagerAdapter {
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return MyFragment.create(addresses[position]);
		}

		@Override
		public int getCount() {
			return addresses.length;
		}
	}

	public static class MyFragment extends Fragment {
		public static MyFragment create(String address) {
			MyFragment f = new MyFragment();
			Bundle b = new Bundle();
			b.putString("address", address);
			f.setArguments(b);
			return f;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Random r = new Random(System.currentTimeMillis());
			Bundle b = getArguments();
			View v = inflater.inflate(R.layout.fragment_viewpager1_layout1,
					null);
			v.setBackgroundColor(r.nextInt() >> 8 | 0xFF << 24);
			TextView txvAddress = (TextView) v.findViewById(R.id.textView1);
			txvAddress.setTextColor(r.nextInt() >> 8 | 0xFF << 24);
			txvAddress.setBackgroundColor(r.nextInt() >> 8 | 0xFF << 24);
			txvAddress.setText(b.getString("address", ""));
			return v;
		}
	}
}
