package com.ivory.webview_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
//        webView.setScrollBarStyle(View.SCROLLBARS_INSIDEs_OVERLAY);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.setWebContentsDebuggingEnabled(true);
        }
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("file:///android_asset/index.html");
//        webView.addJavascriptInterface( new Object() {
//            @JavascriptInterface // For API 17+
//            public void performClick (String strl) {
//                Toast. makeText (MainActivity. this, strl , Toast.LENGTH_LONG ).show() ;
//            }
//        } , "ok" ) ;

        webView.addJavascriptInterface( new Object() {
            @JavascriptInterface
            public void jsCallback(String setting) {
                Toast. makeText (MainActivity. this, "success "+setting , Toast.LENGTH_LONG ).show() ;
            }
        } , "Android" ) ;

        webView.addJavascriptInterface( new Object() {
            @JavascriptInterface
            public String jsCallback1() {
                Toast. makeText (MainActivity. this, "success linked js and android 2" , Toast.LENGTH_LONG ).show() ;
                return "starting game.............";
            }
        } , "Android1" ) ;

    }




}