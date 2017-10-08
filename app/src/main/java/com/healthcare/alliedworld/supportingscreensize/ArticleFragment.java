package com.healthcare.alliedworld.supportingscreensize;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Miko on 08/10/2017.
 */

public class ArticleFragment extends Fragment {

	private TextView mHeadline, mContent;
	String[] mHeadlines, mArticles;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.article_fragment_layout, container, false);
		mHeadline = (TextView) view.findViewById(R.id.heading_text_id);
		mContent = (TextView) view.findViewById(R.id.desc_id);
		mHeadlines = getResources().getStringArray(R.array.news_title);
		mArticles = getResources().getStringArray(R.array.news_content);
		return view;
	}

	public void updateInfo(int position) {
		String headline = mHeadlines[position];
		String article = mArticles[position];
		mHeadline.setText(headline);
		mContent.setText(article);
	}
}
