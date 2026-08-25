package com.transsion.ad.test.ad_example;

import android.os.Bundle;
import android.view.View;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/transsion/ad/test/ad_example/TestAdNativeActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", BuildConfig.FLAVOR, "onDestroy", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "a", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "nativeManager", "Lsh/o;", "b", "Lsh/o;", "binding", "com/transsion/ad/test/ad_example/TestAdNativeActivity$nativeListener$1", "c", "Lcom/transsion/ad/test/ad_example/TestAdNativeActivity$nativeListener$1;", "nativeListener", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdNativeActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private BiddingNativeManager nativeManager;

    /* renamed from: b, reason: from kotlin metadata */
    private sh.o binding;

    /* renamed from: c, reason: from kotlin metadata */
    private final TestAdNativeActivity$nativeListener$1 nativeListener = new oh.a() { // from class: com.transsion.ad.test.ad_example.TestAdNativeActivity$nativeListener$1
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            kotlinx.coroutines.i.d(androidx.lifecycle.v.a(TestAdNativeActivity.this), (CoroutineContext) null, (CoroutineStart) null, new TestAdNativeActivity$nativeListener$1$onBiddingLoad$1(TestAdNativeActivity.this, biddingIntermediateMaterialBean, null), 3, (Object) null);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(TestAdNativeActivity testAdNativeActivity, View view) {
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(testAdNativeActivity), (CoroutineContext) null, (CoroutineStart) null, new TestAdNativeActivity$onCreate$1$1(testAdNativeActivity, null), 3, (Object) null);
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_n";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        sh.o c = sh.o.c(getLayoutInflater());
        this.binding = c;
        sh.o oVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        this.nativeManager = new BiddingNativeManager();
        sh.o oVar2 = this.binding;
        if (oVar2 == null) {
            Intrinsics.y("binding");
        } else {
            oVar = oVar2;
        }
        oVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_example.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdNativeActivity.S(TestAdNativeActivity.this, view);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        BiddingNativeManager biddingNativeManager = this.nativeManager;
        if (biddingNativeManager == null) {
            Intrinsics.y("nativeManager");
            biddingNativeManager = null;
        }
        biddingNativeManager.U();
    }
}
