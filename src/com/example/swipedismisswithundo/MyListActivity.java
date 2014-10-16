package com.example.swipedismisswithundo;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haarman.listviewanimations.ArrayAdapter;

public class MyListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getListView().setDivider(null);
	}

	protected ArrayAdapter<String> createListAdapter() {
		return new MyListAdapter(this, getItems());
	}

	public static ArrayList<String> getItems() {
		ArrayList<String> items = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			items.add(String.valueOf(i));
		}
		return items;
	}

	private static class MyListAdapter extends ArrayAdapter<String> {

		private final Context mContext;

		public MyListAdapter(Context context, ArrayList<String> items) {
			super(items);
			mContext = context;
		}

		@Override
		public long getItemId(int position) {
			return getItem(position).hashCode();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = (TextView) convertView;
			if (tv == null) {
				tv = (TextView) LayoutInflater.from(mContext).inflate(
						R.layout.list_row, parent, false);
			}
			tv.setText("This is telephone number,我明天中午想吃冒菜！！！ "
					+ getItem(position));
			tv.setHeight(50);
			return tv;
		}
	}
}
