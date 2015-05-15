package com.zcs.demo.swipe.back;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.zcs.demo.swipe.back.base.BaseSwipeFragmentActivity;
import com.zcs.demo.swipe.back.fragment.BottomFragment;
import com.zcs.demo.swipe.back.fragment.ContentFragment;

public class SwipeFragmentActivity extends BaseSwipeFragmentActivity {
	/** Constants */
	private static final String CURR_TITLE = "Fragment Test";

	/** Views */
	private ContentFragment mContentFragment;
	private BottomFragment mBottomFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_fragment);
		setTitle(CURR_TITLE);
		
		super.init();
		initFragment();
	}

	private void initFragment() {
		FragmentManager fm = getSupportFragmentManager();

		mContentFragment = (ContentFragment) fm.findFragmentById(R.id.frame_content);
		if (mContentFragment == null) {
			mContentFragment = new ContentFragment();
			fm.beginTransaction().add(R.id.frame_content, mContentFragment).commit();
		}

		mBottomFragment = (BottomFragment) fm.findFragmentById(R.id.frame_bottom);
		if (mBottomFragment == null) {
			mBottomFragment = new BottomFragment();
			fm.beginTransaction().add(R.id.frame_bottom, mBottomFragment).commit();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initTitlebar() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initComponent() {
		// TODO Auto-generated method stub

	}

}
