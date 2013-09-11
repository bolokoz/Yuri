package com.example.yuri;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
		WebView ourBrow = (WebView) findViewById(R.id.wvBrowser);
		// Define URL
		ourBrow.loadUrl("http://www.uol.com.br");
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
