package com.example.swipedismisswithundo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.capricorn.ArcMenu;
import com.haarman.listviewanimations.ArrayAdapter;
import com.haarman.listviewanimations.itemmanipulation.contextualundo.ContextualUndoAdapter;
import com.haarman.listviewanimations.itemmanipulation.contextualundo.ContextualUndoAdapter.DeleteItemCallback;

public class MainActivity extends MyListActivity {

	private final ArrayAdapter<String> mAdapter = createListAdapter();
	private static final int[] ITEM_DRAWABLES = { R.drawable.composer_camera,
			R.drawable.composer_music, R.drawable.composer_place,
			R.drawable.composer_sleep, R.drawable.composer_thought,
			R.drawable.composer_with };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ContextualUndoAdapter contextualUndoAdapter = new ContextualUndoAdapter(
				mAdapter, R.layout.undo_row, R.id.undo_row_undobutton);
		contextualUndoAdapter.setAbsListView(getListView());
		getListView().setAdapter(contextualUndoAdapter);
		contextualUndoAdapter.setDeleteItemCallback(new MyDeleteItemCallback());

		// ArcMenu arcMenu = (ArcMenu) findViewById(R.id.arc_menu);

		// initArcMenu(arcMenu, ITEM_DRAWABLES);

	}

	private void initArcMenu(ArcMenu menu, int[] itemDrawables) {
		for (int i = 0; i < 1; i++) {
			ImageView item = new ImageView(this);
			item.setImageResource(itemDrawables[i]);
			Toast.makeText(MainActivity.this, "position就会快快健康",
					Toast.LENGTH_SHORT).show();

			final int position = i;
			menu.addItem(item, new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(MainActivity.this, "position:" + position,
							Toast.LENGTH_SHORT).show();
				}
			});
		}
	}

	private class MyDeleteItemCallback implements DeleteItemCallback {

		@Override
		public void deleteItem(int position) {
			mAdapter.remove(position);
			mAdapter.notifyDataSetChanged();
		}
	}

	public void testButton(View view) {
		findViewById(R.id.button1);
		Toast.makeText(MainActivity.this, "HHHHHHH", Toast.LENGTH_LONG).show();
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

}
