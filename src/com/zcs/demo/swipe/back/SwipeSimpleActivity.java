package com.zcs.demo.swipe.back;

import android.os.Bundle;
import android.view.View;

import com.zcs.demo.swipe.back.base.BaseSwipeActivity;

public class SwipeSimpleActivity extends BaseSwipeActivity {
	private static final String CURR_TITLE = "Simple Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple);

		super.init();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			onBackPressed();
			break;
		default:
			break;
		}

	}

	@Override
	protected void initTitlebar() {
		setTitle(CURR_TITLE);
	}

	@Override
	protected void initComponent() {
		findViewById(R.id.button1).setOnClickListener(this);
	}

}
