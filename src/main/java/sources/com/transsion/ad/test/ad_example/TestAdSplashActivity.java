package com.transsion.ad.test.ad_example;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import xh.b;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/transsion/ad/test/ad_example/TestAdSplashActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lcom/transsion/ad/bidding/splash/b;", "a", "Lcom/transsion/ad/bidding/splash/b;", "splashManager", "Lsh/w;", "b", "Lsh/w;", "binding", "com/transsion/ad/test/ad_example/TestAdSplashActivity$a", "c", "Lcom/transsion/ad/test/ad_example/TestAdSplashActivity$a;", "splashListener", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CustomSplashScreen"})
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdSplashActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private com.transsion.ad.bidding.splash.b splashManager;

    /* renamed from: b, reason: from kotlin metadata */
    private sh.w binding;

    /* renamed from: c, reason: from kotlin metadata */
    private final a splashListener = new a();

    public static final class a extends oh.a {
        a() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            b.a.c(TestAdSplashActivity.this, 6, "onBiddingError() --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), null, false, 12, null);
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            com.transsion.ad.bidding.splash.b bVar = TestAdSplashActivity.this.splashManager;
            if (bVar == null) {
                Intrinsics.y("splashManager");
                bVar = null;
            }
            AbsAdBidding.O0(bVar, TestAdSplashActivity.this, biddingIntermediateMaterialBean, false, 4, (Object) null);
        }

        public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.m(biddingIntermediateMaterialBean);
            TestAdSplashActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(TestAdSplashActivity testAdSplashActivity, View view) {
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(testAdSplashActivity), (CoroutineContext) null, (CoroutineStart) null, new TestAdSplashActivity$onCreate$1$1(testAdSplashActivity, null), 3, (Object) null);
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_s";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        sh.w c = sh.w.c(getLayoutInflater());
        this.binding = c;
        sh.w wVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        this.splashManager = new com.transsion.ad.bidding.splash.b();
        sh.w wVar2 = this.binding;
        if (wVar2 == null) {
            Intrinsics.y("binding");
        } else {
            wVar = wVar2;
        }
        wVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_example.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdSplashActivity.R(TestAdSplashActivity.this, view);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
