package com.transsion.web.activity;

import android.content.Intent;
import android.os.Bundle;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.web.R$id;
import com.transsion.web.api.WebConstants;
import com.transsion.web.fragment.WebFragmentV2;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import gj.c;
import ij.k;
import ij.y;
import iw.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import wf.a;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001cR\u0016\u0010&\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001f\u0010/\u001a\n +*\u0004\u0018\u00010\u001a0\u001a8\u0006¢\u0006\f\n\u0004\b,\u0010\u001c\u001a\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/transsion/web/activity/WebActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Liw/a;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onStop", "onDestroy", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "b0", "()Liw/a;", HttpUrl.FRAGMENT_ENCODE_SET, "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", HttpUrl.FRAGMENT_ENCODE_SET, "a", "Ljava/lang/String;", WebConstants.FIELD_URL, "b", WebConstants.FIELD_DEEPLINK, "c", "Z", "loadUrlOnly", "d", "pageFrom", "e", WebConstants.EXTERNAL_BROWSER, HttpUrl.FRAGMENT_ENCODE_SET, "f", "J", "pageStartTime", "kotlin.jvm.PlatformType", "g", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/transsion/web/fragment/WebFragmentV2;", "h", "Lcom/transsion/web/fragment/WebFragmentV2;", "webFragment", "Web_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class WebActivity extends BaseActivity<a> {

    /* renamed from: a, reason: from kotlin metadata */
    public String url;

    /* renamed from: b, reason: from kotlin metadata */
    public String deeplink;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean loadUrlOnly;

    /* renamed from: d, reason: from kotlin metadata */
    public String pageFrom;

    /* renamed from: e, reason: from kotlin metadata */
    public boolean externalBrowser;

    /* renamed from: f, reason: from kotlin metadata */
    private long pageStartTime;

    /* renamed from: g, reason: from kotlin metadata */
    private final String TAG = WebActivity.class.getSimpleName();

    /* renamed from: h, reason: from kotlin metadata */
    private WebFragmentV2 webFragment;

    private final void initView() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a c = a.c(getLayoutInflater());
        Intrinsics.g(c, "inflate(...)");
        return c;
    }

    public boolean isChangeStatusBar() {
        return true;
    }

    public boolean isStatusDark() {
        return !y.a.a();
    }

    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jw.a.a.a();
        TheRouter.l(this);
        a.a aVar = wf.a.a;
        String TAG = this.TAG;
        Intrinsics.g(TAG, "TAG");
        aVar.c(TAG, "externalBrowser:" + this.externalBrowser + " url:" + this.url, true);
        if (this.externalBrowser) {
            String str = this.url;
            if (str != null) {
                k.i(str);
            }
            finish();
        }
        if (savedInstanceState == null) {
            this.webFragment = WebFragmentV2.INSTANCE.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(WebConstants.FIELD_ITEM, getIntent().getParcelableExtra(WebConstants.FIELD_ITEM));
            bundle.putString(WebConstants.FIELD_URL, this.url);
            bundle.putString(WebConstants.FIELD_DEEPLINK, this.deeplink);
            bundle.putBoolean(WebConstants.FIELD_LOAD_URL_ONLY, this.loadUrlOnly);
            bundle.putString(WebConstants.PAGE_FROM, getIntent().getStringExtra(WebConstants.PAGE_FROM));
            WebFragmentV2 webFragmentV2 = this.webFragment;
            if (webFragmentV2 != null) {
                webFragmentV2.setArguments(bundle);
            }
            WebFragmentV2 webFragmentV22 = this.webFragment;
            if (webFragmentV22 != null) {
                getSupportFragmentManager().p().s(R$id.container, webFragmentV22).k();
            }
        }
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        c cVar;
        super.onDestroy();
        jw.a.a.b();
        if (!getIntent().getBooleanExtra("fromTask", false) || (cVar = (c) gj.a.a.a(c.class)) == null) {
            return;
        }
        cVar.c(System.currentTimeMillis() - this.pageStartTime);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onNewIntent(Intent intent) {
        Intrinsics.h(intent, "intent");
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        try {
            setIntent(intent);
            TheRouter.l(this);
        } catch (Exception unused) {
        }
    }

    public void onPause() {
        super.onPause();
        jw.a.a.a();
    }

    public void onResume() {
        super.onResume();
        jw.a.a.a();
        this.pageStartTime = System.currentTimeMillis();
    }

    protected void onStop() {
        super.onStop();
        jw.a.a.a();
    }
}
