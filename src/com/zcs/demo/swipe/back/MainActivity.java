package com.zcs.demo.swipe.back;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.zcs.demo.swipe.back.base.BaseNormalActivity;

public class MainActivity extends BaseNormalActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		super.init();
	}

	@Override
	public void onClick(View v) {
		Intent mIntent = null;
		switch (v.getId()) {
		case R.id.simple_activity:
			mIntent = new Intent(MainActivity.this, SwipeSimpleActivity.class);
			break;
		case R.id.absListview_activity:
			mIntent = new Intent(MainActivity.this, SwipeListViewActivity.class);
			break;
		case R.id.scrollview_activity:
			mIntent = new Intent(MainActivity.this, SwipeScrollActivity.class);
			break;
		case R.id.viewpager_activity:
			mIntent = new Intent(MainActivity.this, SwipeViewPagerActivity.class);
			break;
		case R.id.fragment_activity:
			mIntent = new Intent(MainActivity.this, SwipeFragmentActivity.class);
			break;
		}
		startActivity(mIntent);
	}

	@Override
	protected void initTitlebar() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void initComponent() {
		findViewById(R.id.simple_activity).setOnClickListener(this);
		findViewById(R.id.absListview_activity).setOnClickListener(this);
		findViewById(R.id.scrollview_activity).setOnClickListener(this);
		findViewById(R.id.viewpager_activity).setOnClickListener(this);
		findViewById(R.id.fragment_activity).setOnClickListener(this);
	}

}
