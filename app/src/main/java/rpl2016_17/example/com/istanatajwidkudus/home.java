package rpl2016_17.example.com.istanatajwidkudus;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class home extends AppCompatActivity {
    WebView web_view;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        web_view = findViewById(R.id.webview);
        web_view.setVerticalScrollBarEnabled(true);
        web_view.requestFocus();
        web_view.getSettings().setDefaultTextEncodingName("utf-8");
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.loadUrl("http://istanatajwidkudus.blogspot.com");
        web_view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        web_view.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(web_view!= null && web_view.canGoBack())
            web_view.goBack();// if there is previous page open it
        else
            super.onBackPressed();//if there is no previous page, close app
    }
}
