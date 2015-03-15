package com.example.activitieshw;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.BufferType;

public class SearchActivity extends Activity implements OnClickListener{
	
	private EditText enterWord;
	private Button searchBtn;
	private TextView textTV;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		innit();
		
	}
	
	void innit(){
		enterWord = (EditText) findViewById(R.id.et_enter_word);
		searchBtn = (Button) findViewById(R.id.btn_search);
		textTV = (TextView) findViewById(R.id.tv_text);
		
		String text = getIntent().getStringExtra("text");
		
		if(text.equals("default")){
			textTV.setText(R.string.text);
		}
		
		else{
			textTV.setText(text);
		}
		
		searchBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String word  = enterWord.getText().toString();
		String text = textTV.getText().toString();
		
		if(word.length() < 3){
			Toast.makeText(this, "The word must be at least 3 letters", Toast.LENGTH_LONG).show();;
			return;
		}
		
		if(text.contains(word)){			
			Intent i = new Intent(this,DefinitionActivity.class);
			i.putExtra("word",word);
			startActivityForResult(i, 1);
		}
		else{
			Toast.makeText(this, "Word not found", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.activity_search_menu, menu);
	    return super.onCreateOptionsMenu(menu);		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == R.id.action_search){
			LinearLayout search = (LinearLayout) findViewById(R.id.layout_search);
			search.setVisibility(View.VISIBLE);
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == 1 && resultCode == RESULT_OK){
			String word  = enterWord.getText().toString();
			String text = textTV.getText().toString();
			String newWord = "<font color='#EE0000'>" + data.getStringExtra("newWord") + "</font>";
						
			text = text.replace(word, newWord);
			textTV.setText(Html.fromHtml(text));			
		}
	}
	
}
