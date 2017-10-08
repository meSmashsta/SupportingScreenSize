package com.healthcare.alliedworld.supportingscreensize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ArticleActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article_layout);

		int pos = getIntent().getIntExtra(getString(R.string.extra_headline), 0);
		ArticleFragment articleFragment =
				(ArticleFragment) getFragmentManager().findFragmentById(R.id.article_frag);
		articleFragment.updateInfo(pos);
	}
}
