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

		// // ��ʼ���ӿڣ�Ӧ��������ʱ�����
		// // ������appId, appSecret, ����ģʽ
		// AdManager.getInstance(this).init("85aa56a59eac8b3d",
		// "a14006f66f58d5d7", false);
		//
		// // �������ʹ�ÿ�������Ҫȡ��ע������ע�ͣ����ʹ���˿����Ͳ���������Ҫ��
		// SpotManager.getInstance(this).loadSplashSpotAds();
		//
		// // ���������ֵ��÷�ʽ�������ʹ�����ѡ������һ�ֵ��÷�ʽ��
		// // 1.���Զ��廯���ã�
		// // �˷�ʽ�ܹ���������ӦһЩӦ�õ����ⳡ������ʹ�á�
		// // ������Ҫ��ת��activity
		// SplashView splashView = new SplashView(this, MainActivity.class);

		setContentView(R.layout.activity_main);
		
		

	}

}
