package com.healthcare.alliedworld.supportingscreensize;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Miko on 08/10/2017.
 */

public class HeadLineFragment extends Fragment {
	private ListView mListView;
	private ArrayAdapter<String> mAdapter;
	private String[] mHeadlines;
	private String[] mContents;

	private OnHeadLineClickListener mOnHeadLineClickListener;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.headline_fragment_layout, container, false);
		mListView = (ListView) view.findViewById(R.id.list_headline);
		mHeadlines = getResources().getStringArray(R.array.news_title);
		mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.headline_list_layout, R.id.row_item, mHeadlines);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
				mOnHeadLineClickListener.headlineSelected(pos);
			}
		});
		return view;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		try {
			mOnHeadLineClickListener = (OnHeadLineClickListener) context;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public interface OnHeadLineClickListener {
		void headlineSelected(int position);
	}
}
