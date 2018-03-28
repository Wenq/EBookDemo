package com.wenq.floatingadsdemo;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// // 初始化接口，应用启动的时候调用
		// // 参数：appId, appSecret, 调试模式
		// AdManager.getInstance(this).init("85aa56a59eac8b3d",
		// "a14006f66f58d5d7", false);
		//
		// // 如果仅仅使用开屏，需要取消注释以下注释，如果使用了开屏和插屏，则不需要。
		// SpotManager.getInstance(this).loadSplashSpotAds();
		//
		// // 开屏的两种调用方式：请根据使用情况选择其中一种调用方式。
		// // 1.可自定义化调用：
		// // 此方式能够将开屏适应一些应用的特殊场景进行使用。
		// // 传入需要跳转的activity
		// SplashView splashView = new SplashView(this, MainActivity.class);

		setContentView(R.layout.activity_main);
		
		

	}

}
