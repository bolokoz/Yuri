package com.example.yuri;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener{

	EditText sharedData;
	TextView dataResults;
	public static String filename = "MySharedString";
	SharedPreferences someData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupVariables();
		//Cria uma "sharedPreference" com o filename definido acima endereçado como "someData"
		//NOTA: pensar sharedPrefs como uma pasta, e lá dentro voce coloca várias strings para serem armazenadas
		someData = getSharedPreferences(filename, 0);
		
		
	}
	//Tutorial 95
	private void setupVariables() {
		// TODO Auto-generated method stub
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedPrefs);
		dataResults = (TextView) findViewById(R.id.tvLoadSharedPrefs);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.bSave:
			//Cria uma string e pega o conteudo do "sharedData" para guardar
			String stringData = sharedData.getText().toString();
			//Editar a sharedPref
			SharedPreferences.Editor editor = someData.edit();
			//Coloca uma string chamada sharedString dentro da sharedPreference e
			editor.putString("sharedString", stringData);
			editor.commit();
			break;
		case R.id.bLoad:
			//Carrega a sharedPref
			someData = getSharedPreferences(filename, 0);
			//Define uma nova string com o valor dentro de "sharedString", caso não der, mostra a mensagem de erro
			String dataReturned = someData.getString("sharedString", "Couldn't Load Data" );
			dataResults.setText(dataReturned);
			break;
		}
	}

}
