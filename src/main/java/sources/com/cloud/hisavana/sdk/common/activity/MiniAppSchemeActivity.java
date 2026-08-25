package com.cloud.hisavana.sdk.common.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.b4;
import com.cloud.tmc.ad.athena.PostConstant;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class MiniAppSchemeActivity extends AppCompatActivity {
    private boolean a = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void P() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super/*android.app.Activity*/.finish();
        overridePendingTransition(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(R$layout.activity_mini_app_scheme);
        try {
            Window window = getWindow();
            if (window != null) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            }
        } catch (Throwable unused) {
        }
        this.a = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (this.a || getIntent() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra(PostConstant.EVENT_DEEPLINK);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            try {
                Uri parse = Uri.parse(stringExtra);
                Intent intent = new Intent();
                intent.setData(parse);
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                startActivity(intent);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.cloud.hisavana.sdk.common.activity.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppSchemeActivity.this.P();
                    }
                }, 1000L);
            } catch (Exception unused) {
                b4.b().e("MiniApp", "Failed to launch mini app from homescreen.");
            }
        } finally {
            this.a = true;
        }
    }
}
