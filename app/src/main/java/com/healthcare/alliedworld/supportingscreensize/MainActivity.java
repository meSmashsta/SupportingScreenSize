package com.healthcare.alliedworld.supportingscreensize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HeadLineFragment.OnHeadLineClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public void headlineSelected(int position) {
		ArticleFragment articleFragment = (ArticleFragment) getFragmentManager().findFragmentById(R.id.article_frag);
		if (articleFragment == null) {
			Intent intent = new Intent(this, ArticleActivity.class);
			intent.putExtra(getString(R.string.extra_headline), position);
			startActivity(intent);
		} else {
			articleFragment.updateInfo(position);
		}
	}
}
