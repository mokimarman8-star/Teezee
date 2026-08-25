package com.transsion.ad.test.ad_example;

import android.os.Bundle;
import android.view.View;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import xh.b;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/transsion/ad/test/ad_example/TestAdBannerActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lsh/i;", "a", "Lsh/i;", "binding", "Lcom/transsion/ad/bidding/banner/a;", "b", "Lcom/transsion/ad/bidding/banner/a;", "bannerManager", "com/transsion/ad/test/ad_example/TestAdBannerActivity$bannerListener$1", "c", "Lcom/transsion/ad/test/ad_example/TestAdBannerActivity$bannerListener$1;", "bannerListener", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdBannerActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private sh.i binding;

    /* renamed from: b, reason: from kotlin metadata */
    private com.transsion.ad.bidding.banner.a bannerManager;

    /* renamed from: c, reason: from kotlin metadata */
    private final TestAdBannerActivity$bannerListener$1 bannerListener = new oh.a() { // from class: com.transsion.ad.test.ad_example.TestAdBannerActivity$bannerListener$1
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            b.a.c(TestAdBannerActivity.this, 6, "onBiddingError() --> Banner 广告加载失败 --> errorMessage = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), null, false, 12, null);
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            kotlinx.coroutines.i.d(androidx.lifecycle.v.a(TestAdBannerActivity.this), (CoroutineContext) null, (CoroutineStart) null, new TestAdBannerActivity$bannerListener$1$onBiddingLoad$1(biddingIntermediateMaterialBean, TestAdBannerActivity.this, null), 3, (Object) null);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(TestAdBannerActivity testAdBannerActivity, View view) {
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(testAdBannerActivity), (CoroutineContext) null, (CoroutineStart) null, new TestAdBannerActivity$onCreate$1$1(testAdBannerActivity, null), 3, (Object) null);
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_b";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        sh.i c = sh.i.c(getLayoutInflater());
        this.binding = c;
        sh.i iVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        sh.i iVar2 = this.binding;
        if (iVar2 == null) {
            Intrinsics.y("binding");
        } else {
            iVar = iVar2;
        }
        iVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_example.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdBannerActivity.U(TestAdBannerActivity.this, view);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        com.transsion.ad.bidding.banner.a aVar = this.bannerManager;
        if (aVar != null) {
            aVar.U();
        }
    }
}
