package com.transsion.ad.test.ad_example;

import android.os.Bundle;
import android.view.View;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.test.TestBaseActivity;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import xh.b;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/transsion/ad/test/ad_example/TestAdNativeMultipleActivity;", "Lcom/transsion/ad/test/TestBaseActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", BuildConfig.FLAVOR, "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", BuildConfig.FLAVOR, "getLogTag", "()Ljava/lang/String;", "Lsh/n;", "a", "Lsh/n;", "binding", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "b", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "nativeManager", "com/transsion/ad/test/ad_example/TestAdNativeMultipleActivity$a", "c", "Lcom/transsion/ad/test/ad_example/TestAdNativeMultipleActivity$a;", "nativeListener", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class TestAdNativeMultipleActivity extends TestBaseActivity {

    /* renamed from: a, reason: from kotlin metadata */
    private sh.n binding;

    /* renamed from: b, reason: from kotlin metadata */
    private BiddingNativeManager nativeManager;

    /* renamed from: c, reason: from kotlin metadata */
    private final a nativeListener = new a();

    public static final class a extends oh.a {
        a() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            b.a.c(TestAdNativeMultipleActivity.this, 6, "onBiddingError() --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), null, false, 12, null);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, com.transsion.ad.test.ad_example.TestAdNativeMultipleActivity] */
        public void k(List list) {
            super.k(list);
            if (list != null) {
                ?? r0 = TestAdNativeMultipleActivity.this;
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.u();
                    }
                    BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) obj;
                    BiddingNativeManager biddingNativeManager = null;
                    if (i == 0) {
                        sh.n nVar = ((TestAdNativeMultipleActivity) r0).binding;
                        if (nVar == null) {
                            Intrinsics.y("binding");
                            nVar = null;
                        }
                        NativeWrapperAdView nativeWrapperAdView = nVar.c;
                        BiddingNativeManager biddingNativeManager2 = ((TestAdNativeMultipleActivity) r0).nativeManager;
                        if (biddingNativeManager2 == null) {
                            Intrinsics.y("nativeManager");
                        } else {
                            biddingNativeManager = biddingNativeManager2;
                        }
                        nativeWrapperAdView.bindNativeView(biddingNativeManager, new s(r0), biddingIntermediateMaterialBean);
                    } else if (i == 1) {
                        sh.n nVar2 = ((TestAdNativeMultipleActivity) r0).binding;
                        if (nVar2 == null) {
                            Intrinsics.y("binding");
                            nVar2 = null;
                        }
                        NativeWrapperAdView nativeWrapperAdView2 = nVar2.d;
                        BiddingNativeManager biddingNativeManager3 = ((TestAdNativeMultipleActivity) r0).nativeManager;
                        if (biddingNativeManager3 == null) {
                            Intrinsics.y("nativeManager");
                        } else {
                            biddingNativeManager = biddingNativeManager3;
                        }
                        nativeWrapperAdView2.bindNativeView(biddingNativeManager, new s(r0), biddingIntermediateMaterialBean);
                    } else if (i == 2) {
                        sh.n nVar3 = ((TestAdNativeMultipleActivity) r0).binding;
                        if (nVar3 == null) {
                            Intrinsics.y("binding");
                            nVar3 = null;
                        }
                        NativeWrapperAdView nativeWrapperAdView3 = nVar3.e;
                        BiddingNativeManager biddingNativeManager4 = ((TestAdNativeMultipleActivity) r0).nativeManager;
                        if (biddingNativeManager4 == null) {
                            Intrinsics.y("nativeManager");
                        } else {
                            biddingNativeManager = biddingNativeManager4;
                        }
                        nativeWrapperAdView3.bindNativeView(biddingNativeManager, new s(r0), biddingIntermediateMaterialBean);
                    }
                    i = i2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(TestAdNativeMultipleActivity testAdNativeMultipleActivity, View view) {
        kotlinx.coroutines.i.d(androidx.lifecycle.v.a(testAdNativeMultipleActivity), (CoroutineContext) null, (CoroutineStart) null, new TestAdNativeMultipleActivity$onCreate$1$1(testAdNativeMultipleActivity, null), 3, (Object) null);
    }

    @Override // xh.b
    public String getLogTag() {
        return "ad_n";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(savedInstanceState);
        sh.n c = sh.n.c(getLayoutInflater());
        this.binding = c;
        sh.n nVar = null;
        if (c == null) {
            Intrinsics.y("binding");
            c = null;
        }
        setContentView(c.b());
        this.nativeManager = new BiddingNativeManager();
        sh.n nVar2 = this.binding;
        if (nVar2 == null) {
            Intrinsics.y("binding");
        } else {
            nVar = nVar2;
        }
        nVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.test.ad_example.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestAdNativeMultipleActivity.S(TestAdNativeMultipleActivity.this, view);
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
