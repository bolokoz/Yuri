package com.example.yuri;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener{
	//Criar fora do onCreate para ser usado por tudo
	TabHost th;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);

		// Criar tabhost e endereçar ele para o xml
		th = (TabHost) findViewById(R.id.tabhost);
		//Criar botoes
		Button newTab = (Button)findViewById(R.id.bAddTab);
		Button bStart = (Button)findViewById(R.id.bStartWatch);
		Button bStop = (Button)findViewById(R.id.bStopWatch);
		//Configurar "ouvidor" de toque na tela
		newTab.setOnClickListener(this);
		// Configurar tabhost
		th.setup();
		// Configurar o que é para ser mostrado
		TabSpec specs = th.newTabSpec("tag1");
		
		
		// Criar tab1 - definido no xml
		specs.setContent(R.id.tab1);
		// Incluir dentro da tab1
		specs.setIndicator("StopWatch");
		// Mostrar
		th.addTab(specs);

		
		// Criar tab2 - definido no xml
		specs.setContent(R.id.tab2);
		// Incluir dentro da tab2
		specs.setIndicator("Tab 2");
		// Mostrar
		th.addTab(specs);

		
		// Criar tab3 - definido no xml
		specs.setContent(R.id.tab3);
		// Incluir dentro da tab3
		specs.setIndicator("Add a Tab");
		// Mostrar
		th.addTab(specs);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bAddTab:
			//Ao se clicar no botao "bAddTab" uma nova aba é criada
			TabSpec ourSpec = th.newTabSpec("tag1");
			ourSpec.setContent(new TabHost.TabContentFactory() {
				//Conteudo da nova aba é:
				@Override
				public View createTabContent(String tag) {
					// TODO Auto-generated method stub
					//Criar um texto
					TextView text = new TextView(Tabs.this);
					text.setText("You've created a new tab");
					
					return (text);
				}
			});
			//Fazer a nova aba "ourSpec" aparecer
			ourSpec.setIndicator("New");
			th.addTab(ourSpec);
			
			break;
		case R.id.bStartWatch:
			
			break;
		case R.id.bStopWatch:
			
			break;
		}
		
	}

}
