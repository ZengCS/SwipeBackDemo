package com.zcs.demo.swipe.back.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public abstract class BaseActivity extends Activity implements OnClickListener {
	/** 屏幕尺寸 */
	private int screenWidth;
	private int screenHeight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setBackgroundDrawable(null);
		DisplayMetrics mDisplayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
		screenWidth = mDisplayMetrics.widthPixels;
		screenHeight = mDisplayMetrics.heightPixels;
	}

	protected void init() {
		initTitlebar();
		initComponent();
	}

	/**
	 * 初始化Titlebar，在super.init()中自动调用此方法
	 */
	protected abstract void initTitlebar();

	/**
	 * 初始化组件，在super.init()中自动调用此方法
	 */
	protected abstract void initComponent();

	protected static Toast mToast;
	private static Context context;

	protected void showToast(String text) {
		if (context == null) {
			context = this;
		}
		if (mToast == null) {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	/**
	 * 获取版本名
	 * 
	 * @return 当前应用的版本名
	 */
	public String getVersionName() {
		try {
			PackageManager manager = this.getPackageManager();
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			return info.versionName;
		} catch (Exception e) {
			e.printStackTrace();
			return "0.0.0";
		}
	}

	/**
	 * 隐藏软键盘
	 * 
	 * @param view
	 */
	protected void hideSoftInputFromWindow(View view) {
		try {
			InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示软键盘
	 * 
	 * @param view
	 */
	protected void showSoftInput(View view) {
		try {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
