package com.example.yuri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	EditText sharedData;
	TextView dataResults;
	// Variavel para escrever arquivos
	FileOutputStream fos;
	String FILENAME = "InternalString";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupVariables();
	}

	private void setupVariables() {
		// TODO Auto-generated method stub
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedPrefs);
		dataResults = (TextView) findViewById(R.id.tvLoadSharedPrefs);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		try {
			// Abrir "escritor" de arquivos com o nome FILENAME no modo
			// privado(?) Tutorial 98
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSave:
			String data = sharedData.getText().toString();
			// Saving data via File
			/*
			 * File f = new File(FILENAME); try { fos = new FileOutputStream(f);
			 * fos.close(); } catch (FileNotFoundException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } catch
			 * (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
			// M�todo normal, usado anteriormente
			try {
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.close();
				fos.write(data.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.bLoad:
			// Cria um execute method
			new loadSomeStuff().execute(FILENAME);
			break;
		}
	}
	//Tutorial 100
	// Extends Async
	// Est� sendo passado um FILENAME
	// Primeiro par�metro � uma String
	// O terceiro � o que ser� retornado; uma string
	public class loadSomeStuff extends AsyncTask<String, Integer, String> {
		//Tutorial 102
		protected void onPreExecute(String f) {
			// Example of setting up something
			f = "whatever";

		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			// Input � para ler
			// Output � para salvar
			String collected = null;
			FileInputStream fis = null;
			try {
				fis = openFileInput(FILENAME);
				// Cria um byte array, do mesmo tamanho available do fis
				byte[] dataArray = new byte[fis.available()];
				// Vai lendo fis e quando atingir -1, significa que acabou
				while (fis.read(dataArray) != -1) {
					collected = new String(dataArray);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					// Muda o textView
					return collected;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
		//Tutorial 102
		protected void onProgressUpdated(Integer... progress) {

		}
		//Tutorial 101
			protected void onPostExecute(String result){
				dataResults.setText(result);
			}
	}

}
