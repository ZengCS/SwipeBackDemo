package com.zcs.demo.swipe.back;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zcs.demo.swipe.back.base.BaseSwipeActivity;

public class SwipeListViewActivity extends BaseSwipeActivity {
	/** Constants */
	private static final String CURR_TITLE = "ListView Test";

	/** Variables */
	private List<String> list = new ArrayList<String>();

	/** Views */
	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abslistview);

		super.init();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initTitlebar() {
		setTitle(CURR_TITLE);
	}

	@Override
	protected void initComponent() {
		mListView = (ListView) findViewById(R.id.listView);

		initListView();
	}

	private void initListView() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(SwipeListViewActivity.this, android.R.layout.simple_list_item_1, list) {
			@Override
			public int getCount() {
				return super.getCount();
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				System.out.println("getView");
				return super.getView(position, convertView, parent);
			}

		};
		mListView.setAdapter(adapter);

		for (int i = 1; i <= 30; i++) {
			list.add("ListView Item " + i);
		}

		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				startActivity(new Intent(SwipeListViewActivity.this, SwipeSimpleActivity.class));
			}
		});
	}

}
