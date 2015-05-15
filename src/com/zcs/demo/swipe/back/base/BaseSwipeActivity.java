package com.zcs.demo.swipe.back.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.zcs.demo.swipe.back.R;
import com.zcs.demo.swipe.back.view.SwipeBackLayout;

public abstract class BaseSwipeActivity extends BaseActivity {
	protected SwipeBackLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(R.layout.swipe_base, null);
		layout.attachToActivity(this);
	}

	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0, R.anim.base_slide_right_out);
	}

}
