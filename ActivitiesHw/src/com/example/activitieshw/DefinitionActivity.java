package com.example.activitieshw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DefinitionActivity extends Activity implements OnClickListener {
	Button changeWordButton;
	Button cancelButton;
	EditText newWordEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_definition);
		
		TextView wordTextView = (TextView) findViewById(R.id.tv_searched_word);
		String word = getIntent().getStringExtra("word");
		wordTextView.setText(word);
		TextView definition = (TextView) findViewById(R.id.tv_word_definition);
		
		changeWordButton = (Button) findViewById(R.id.btn_change_word);
		changeWordButton.setOnClickListener(this);
		newWordEditText = (EditText) findViewById(R.id.et_change_word);
		cancelButton = (Button) findViewById(R.id.btn_cancel_changing_word);
		cancelButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String newWord = newWordEditText.getText().toString();
		
		
		Intent result = new Intent();
		
		if(v.getId() == R.id.btn_change_word){
			
			if(newWord.length() < 3){
				Toast.makeText(this, "The word must be at least 3 letters", Toast.LENGTH_LONG).show();
				return;
			}
						
			result.putExtra("newWord", newWord);
		}
		
		else{			
			result.putExtra("newWord", "");
		}
		
		this.setResult(RESULT_OK,result);
		finish();
	}
}
