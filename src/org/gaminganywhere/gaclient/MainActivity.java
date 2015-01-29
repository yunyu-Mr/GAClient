package org.gaminganywhere.gaclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btn_login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log);
		
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/**
				 * 点击按钮后的处理逻辑卸载这
				 */
				
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				/**
				 * 如果需要传递数据到下一个activity则通过intent携带bundle传递，百度一下
				 */
				
				startActivity(intent);
			}
		});
	}
	}
	


