package com.tn.tranpay.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tn.lib.tranpay.R;
import com.tn.tranpay.fragment.TranPayWebFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rg.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u000e\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/tn/tranpay/activity/TranPayWebActivity;", "Lcom/tn/tranpay/activity/BaseActivity;", "Lrg/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onStop", "onDestroy", "onBackPressed", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "U", "()Lrg/a;", "", "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "", "d", "Ljava/lang/String;", "url", "e", "cpFrontPage", "f", "Z", "shouldOpenCpFrontPage", "Lcom/tn/tranpay/fragment/TranPayWebFragment;", "g", "Lcom/tn/tranpay/fragment/TranPayWebFragment;", "webFragment", "h", "a", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TranPayWebActivity extends BaseActivity<a> {

    /* renamed from: d, reason: from kotlin metadata */
    public String url;

    /* renamed from: e, reason: from kotlin metadata */
    public String cpFrontPage;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean shouldOpenCpFrontPage = true;

    /* renamed from: g, reason: from kotlin metadata */
    private TranPayWebFragment webFragment;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tn.tranpay.activity.BaseActivity
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a c = a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(layoutInflater)");
        return c;
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return true;
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    public void onBackPressed() {
        TranPayWebFragment tranPayWebFragment = this.webFragment;
        if (tranPayWebFragment == null || !tranPayWebFragment.u0()) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tn.tranpay.activity.BaseActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tran_activity_web_pay);
        this.url = getIntent().getStringExtra("url");
        this.cpFrontPage = getIntent().getStringExtra("cpFrontPage");
        boolean booleanExtra = getIntent().getBooleanExtra("shouldOpenCpFrontPage", true);
        this.shouldOpenCpFrontPage = booleanExtra;
        lh.a.g(lh.a.a, "The url is " + this.url + " and cpFrontPage is " + this.cpFrontPage + " and shouldOpenCpFrontPage is " + booleanExtra, null, 2, null);
        if (savedInstanceState == null) {
            this.webFragment = TranPayWebFragment.INSTANCE.a();
            Bundle bundle = new Bundle();
            bundle.putString("url", this.url);
            bundle.putString("cpFrontPage", this.cpFrontPage);
            bundle.putBoolean("shouldOpenCpFrontPage", this.shouldOpenCpFrontPage);
            TranPayWebFragment tranPayWebFragment = this.webFragment;
            if (tranPayWebFragment != null) {
                tranPayWebFragment.setArguments(bundle);
            }
            TranPayWebFragment tranPayWebFragment2 = this.webFragment;
            if (tranPayWebFragment2 != null) {
                getSupportFragmentManager().p().s(R.id.container, tranPayWebFragment2).k();
            }
        }
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onNewIntent(Intent intent) {
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        try {
            setIntent(intent);
            TranPayWebFragment tranPayWebFragment = this.webFragment;
            if (tranPayWebFragment != null) {
                tranPayWebFragment.newIntent(intent);
            }
        } catch (Exception e) {
            lh.a.e(lh.a.a, e.toString(), null, 2, null);
        }
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    public void onPause() {
        super.onPause();
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    protected void onStop() {
        super.onStop();
    }
}
