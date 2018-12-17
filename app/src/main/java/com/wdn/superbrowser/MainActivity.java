package com.wdn.superbrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private EditText et_path;
    private ImageView iv_go;
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_path = findViewById(R.id.et_path);
        iv_go = findViewById(R.id.iv_go);
        wv = findViewById(R.id.wv);

        Intent intent = getIntent();
        if (intent!=null){
            if (intent.getData()!=null){
                String path = intent.getData().toString();
                wv.loadUrl(path);
                et_path.setText(path);
            }
        }
        iv_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = et_path.getText().toString().trim();
                wv.loadUrl(path);
                wv.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        return false;
                    }
                });
            }
        });
    }

}
