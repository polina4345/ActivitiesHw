package com.example.activitieshw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	private Button defaultTextBtn;
	private Button enterTextButton;
	private EditText enterText;
	private Button okButton;
	private int flag = 0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		innit();
		
		defaultTextBtn.setOnClickListener(this);
		enterTextButton.setOnClickListener(this);
		okButton.setOnClickListener(this);
	}
	
	void innit(){
		defaultTextBtn = (Button) findViewById(R.id.btn_default_txt);
		enterTextButton = (Button) findViewById(R.id.btn_enter_txt);
		enterText = (EditText) findViewById(R.id.et_enter_text);
		okButton = (Button) findViewById(R.id.btn_ok);		
	}

	@Override
	public void onClick(View v) {
		int thisID = v.getId();
		
		if(thisID == R.id.btn_default_txt){
			Intent i = new Intent(this, SearchActivity.class);
			i.putExtra("text", "default");
			startActivity(i);
			
		}
		
		if(thisID == R.id.btn_enter_txt){
			if(flag == 0){
				enterText.setVisibility(View.VISIBLE);
				okButton.setVisibility(View.VISIBLE);
				flag = 1;
			}
			
			else{
				enterText.setVisibility(View.GONE);
				okButton.setVisibility(View.GONE);
				flag = 0;
			}
		}
		
		if(thisID == R.id.btn_ok){
			Intent i = new Intent(this, SearchActivity.class);
			String userText = enterText.getText().toString();
			i.putExtra("text", userText);
			startActivity(i);
		}
		
	}

}
