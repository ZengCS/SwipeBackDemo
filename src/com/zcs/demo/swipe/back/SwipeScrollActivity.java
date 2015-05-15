package com.zcs.demo.swipe.back;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zcs.demo.swipe.back.base.BaseSwipeActivity;

public class SwipeScrollActivity extends BaseSwipeActivity {
	/** Constants */
	private static final String CURR_TITLE = "ScrollView Test";

	/** Variables */

	/** Views */
	private LinearLayout innerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scroll);
		super.init();
	}

	@Override
	public void onClick(View v) {
	}

	@Override
	protected void initTitlebar() {
		setTitle(CURR_TITLE);
	}

	@Override
	protected void initComponent() {
		innerLayout = (LinearLayout) findViewById(R.id.scroll_inner_layout);
		initScrollData();
	}

	private void initScrollData() {
		for (int i = 1; i <= 20; i++) {
			View child = LayoutInflater.from(this).inflate(R.layout.item_scroll, null);
			TextView tv = (TextView) child.findViewById(R.id.tv_scroll_name);
			tv.setText("Scroll Item " + i);
			innerLayout.addView(child);
		}
	}

}
