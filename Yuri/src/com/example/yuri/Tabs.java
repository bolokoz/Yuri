package com.example.yuri;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tabs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);

		// Criar tabhost e endereçar ele para o xml
		TabHost th = (TabHost) findViewById(R.id.tabhost);
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

}
