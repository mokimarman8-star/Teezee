package com.transsion.ad.test.ad_example;

import android.os.Bundle;
import android.view.View;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/transsion/ad/test/ad_example/TestAdInterstitialActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lsh/k;", "a", "Lsh/k;", "binding", "Lcom/transsion/ad/bidding/interstitial/BiddingInterstitialManager;", "b", "Lcom/transsion/ad/bidding/interstitial/BiddingInterstitialManager;", "interstitialManager", "com/transsion/ad/test/ad_example/TestAdInterstitialActivity$a", "c", "Lcom/transsion/ad/test/ad_example/TestAdInterstitialActivity$a;", "interstitialListener", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdInterstitialActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private sh.k binding;

    /* renamed from: b, reason: from kotlin metadata */
    private BiddingInterstitialManager interstitialManager;

    /* renamed from: c, reason: from kotlin metadata */
    private final a interstitialListener = new a();

    public static final class a extends oh.a {
        a() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            BiddingInterstitialManager biddingInterstitialManager = TestAdInterstitialActivity.this.interstitialManager;
            if (biddingInterstitialManager == null) {
                Intrinsics.y("interstitialManager");
                biddingInterstitialManager = null;
            }
            AbsAdBidding.O0(biddingInterstitialManager, TestAdInterstitialActivity.this, biddingIntermediateMaterialBean, false, 4, (Object) null);
        }

        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(TestAdInterstitialActivity testAdInterstitialActivity, View view) {
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(testAdInterstitialActivity), (CoroutineContext) null, (CoroutineStart) null, new TestAdInterstitialActivity$onCreate$1$1(testAdInterstitialActivity, null), 3, (Object) null);
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_int";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        sh.k c = sh.k.c(getLayoutInflater());
        this.binding = c;
        sh.k kVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        this.interstitialManager = new BiddingInterstitialManager();
        sh.k kVar2 = this.binding;
        if (kVar2 == null) {
            Intrinsics.y("binding");
        } else {
            kVar = kVar2;
        }
        kVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_example.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdInterstitialActivity.R(TestAdInterstitialActivity.this, view);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        AbsAdBidding absAdBidding = this.interstitialManager;
        if (absAdBidding == null) {
            Intrinsics.y("interstitialManager");
            absAdBidding = null;
        }
        absAdBidding.U();
    }
}
