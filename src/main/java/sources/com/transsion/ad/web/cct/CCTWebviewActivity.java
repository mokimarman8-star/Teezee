package com.transsion.ad.web.cct;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.ad.R;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0015¨\u0006\b"}, d2 = {"Lcom/transsion/ad/web/cct/CCTWebviewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CCTWebviewActivity extends AppCompatActivity {
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cct_webview_layout);
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("extra.url") : null;
        WebView webView = (WebView) findViewById(R.id.webview);
        if (webView != null) {
            webView.setWebViewClient(new WebViewClient());
        }
        WebSettings settings = webView != null ? webView.getSettings() : null;
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        if (webView != null) {
            if (stringExtra == null) {
                stringExtra = BuildConfig.FLAVOR;
            }
            webView.loadUrl(stringExtra);
        }
    }
}
