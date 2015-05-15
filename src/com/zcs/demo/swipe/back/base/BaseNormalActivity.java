package com.zcs.demo.swipe.back.base;

import android.content.Intent;

import com.zcs.demo.swipe.back.R;

public abstract class BaseNormalActivity extends BaseActivity {
	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
	}
}
