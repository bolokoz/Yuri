package com.example.yuri;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SQLiteExample extends Activity implements OnClickListener {

	Button sqlUpdate, sqlView;
	EditText sqlName, sqlHotness;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliteexample);
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlName = (EditText) findViewById(R.id.etSQLName);
		sqlHotness = (EditText) findViewById(R.id.etSQLHotness);

		sqlView = (Button) findViewById(R.id.bSQLOpenView);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.bSQLOpenView:
			
			String name = sqlName.getText().toString();
			String hotness = sqlHotness.getText().toString();
			
			HotOrNot entry = new HotOrNot(SQLiteExample.this);
			entry.open();
			entry.createEntry(name, hotness);
			entry.close();
			break;
		case R.id.bSQLUpdate:
			
			break;
		}
	}
}
