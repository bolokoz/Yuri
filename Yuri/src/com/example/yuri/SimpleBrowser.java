package com.example.yuri;

import java.net.URI;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener {

	EditText url;
	WebView ourBrow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);

		// Estabelece conexao com Webview do layout xml
		ourBrow = (WebView) findViewById(R.id.wvBrowser);
		//Permitir JavaScript
		ourBrow.getSettings().setJavaScriptEnabled(true);
		//Permitir zoom
		ourBrow.getSettings().setBuiltInZoomControls(true);
		//Fazer janela totalmente visivel quando carregar
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		//Vizualizar sites igual um desktop
		ourBrow.getSettings().setUseWideViewPort(true);
		// Define URL
		try{
		ourBrow.loadUrl("http://www.uol.com.br");
		}catch (Exception e){
			e.printStackTrace();
		}
		// Faz com que o conteudo seja mostrado no webview ourBrow e não em um
		// browser do android
		ourBrow.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return super.shouldOverrideUrlLoading(view, url);
			}
		});

		// Define botoes criados no layout simplebrowser.xml
		Button go = (Button) findViewById(R.id.bGo);
		Button back = (Button) findViewById(R.id.bBack);
		Button refresh = (Button) findViewById(R.id.bRefresh);
		Button forward = (Button) findViewById(R.id.bForward);
		Button clearHistory = (Button) findViewById(R.id.bHistory);
		
		
		url = (EditText) findViewById(R.id.etURL);
		url.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		refresh.setOnClickListener(this);
		forward.setOnClickListener(this);
		clearHistory.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bGo:
			//Muda url
			String theWebsite = url.getText().toString();
			ourBrow.loadUrl(theWebsite);
			//Para esconder o teclado quando clicar ok
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.bBack:
			//Se voce estiver na primeira página visualizada
			if (ourBrow.canGoBack()) {
				ourBrow.goBack();
			}
			break;
		case R.id.bRefresh:
			ourBrow.reload();
			break;
		case R.id.bForward:
			if(ourBrow.canGoForward()){
				ourBrow.goForward();
			}
			break;
		case R.id.bHistory:
			ourBrow.clearHistory();
			break;
		}
	}

}
