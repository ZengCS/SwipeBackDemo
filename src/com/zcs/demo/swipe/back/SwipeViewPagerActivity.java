package com.zcs.demo.swipe.back;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zcs.demo.swipe.back.base.BaseSwipeActivity;

public class SwipeViewPagerActivity extends BaseSwipeActivity {
	/** Constants */
	private static final String CURR_TITLE = "ViewPager Test";

	/** Variables */
	private List<View> pageList = new ArrayList<View>();

	/** Views */
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager);
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
		mViewPager = (ViewPager) findViewById(R.id.frame_main_viewpage);
		initViewPager();
	}

	private void initViewPager() {
		View page1 = LayoutInflater.from(this).inflate(R.layout.page_1, null);
		View page2 = LayoutInflater.from(this).inflate(R.layout.page_2, null);
		View page3 = LayoutInflater.from(this).inflate(R.layout.page_3, null);
		View page4 = LayoutInflater.from(this).inflate(R.layout.page_4, null);

		pageList.add(page1);
		pageList.add(page2);
		pageList.add(page3);
		pageList.add(page4);

		mViewPager.setAdapter(new CustomPagerAdapter(this, pageList));
	}

	public class CustomPagerAdapter extends PagerAdapter {
		private List<View> list;

		public CustomPagerAdapter(Context context, List<View> list) {
			this.list = list;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView(list.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View v = list.get(position);
			((ViewPager) container).addView(v);
			return v;
		}
	}

}
