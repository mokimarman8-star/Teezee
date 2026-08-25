package com.transsion.postdetail.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.postdetail.ad.AdInterceptTimerView;
import com.transsion.postdetail.ad.BaseVideoAdHelper;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.postdetail.ui.view.AdCountDownView;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import wn.w;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocalVideoAdHelper extends BaseVideoAdHelper {
    private wn.j Q;
    private DownloadBean R;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v2(LocalVideoAdHelper localVideoAdHelper) {
        LifecycleCoroutineScope w0 = localVideoAdHelper.w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LocalVideoAdHelper$onCompletion$1$1(localVideoAdHelper, null), 3, (Object) null);
        }
        return Unit.a;
    }

    public final void A2() {
        if (O0()) {
            I(b0());
        }
    }

    public final void B2(DownloadBean downloadBean) {
        Long lastAdEndTimeStamp;
        Long lastAdStartTimeStamp;
        this.R = downloadBean;
        long j = 0;
        long longValue = (downloadBean == null || (lastAdStartTimeStamp = downloadBean.getLastAdStartTimeStamp()) == null) ? 0L : lastAdStartTimeStamp.longValue();
        if (downloadBean != null && (lastAdEndTimeStamp = downloadBean.getLastAdEndTimeStamp()) != null) {
            j = lastAdEndTimeStamp.longValue();
        }
        D0(longValue, j);
        F0("localVideo");
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ViewGroup C0() {
        w wVar;
        wn.j jVar = this.Q;
        if (jVar == null || (wVar = jVar.l) == null) {
            return null;
        }
        return wVar.R;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected NativeWrapperAdView V() {
        wn.j jVar = this.Q;
        if (jVar != null) {
            return jVar.c;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected AdCountDownView W() {
        wn.j jVar = this.Q;
        if (jVar != null) {
            return jVar.d;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected AdInterceptTimerView e0() {
        wn.j jVar = this.Q;
        if (jVar != null) {
            return jVar.e;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected NativeWrapperAdView f0() {
        wn.j jVar = this.Q;
        if (jVar != null) {
            return jVar.f;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ViewGroup g0() {
        wn.j jVar = this.Q;
        if (jVar != null) {
            return jVar.g;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ViewGroup h0() {
        wn.j jVar = this.Q;
        if (jVar != null) {
            return jVar.h;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected View k0() {
        wn.j jVar = this.Q;
        if (jVar != null) {
            return jVar.i;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    public void l2() {
        ConstraintLayout root;
        wn.j jVar = this.Q;
        Context context = (jVar == null || (root = jVar.getRoot()) == null) ? null : root.getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            kotlinx.coroutines.i.d(v.a(appCompatActivity), (CoroutineContext) null, (CoroutineStart) null, new LocalVideoAdHelper$updateAdStartLastShowTime$1$1(this, null), 3, (Object) null);
        }
    }

    public final void r2() {
        BiddingNativeManager u0 = u0();
        if (u0 != null) {
            u0.U();
        }
        u1(null);
        BiddingInterstitialManager v0 = v0();
        if (v0 != null) {
            v0.U();
        }
        y1(null);
        this.Q = null;
        Q();
        R();
    }

    public final void s2() {
        D1(x0() + ((System.currentTimeMillis() - B0()) / 1000));
        J1(System.currentTimeMillis());
        C1(true);
        T1();
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ImageView t0() {
        wn.j jVar = this.Q;
        if (jVar != null) {
            return jVar.j;
        }
        return null;
    }

    public final void t2(wn.j jVar, String str, Function1 function1) {
        Intrinsics.h(function1, "adShowCallback");
        E0(jVar, str, function1);
        this.Q = jVar;
    }

    public final void u2() {
        D1(0L);
        J1(0L);
        R();
        d2(new Function0() { // from class: com.transsion.postdetail.util.b
            public final Object invoke() {
                Unit v2;
                v2 = LocalVideoAdHelper.v2(LocalVideoAdHelper.this);
                return v2;
            }
        });
    }

    public final void w2() {
        j1(null);
        P();
        E1(0);
    }

    public final void x2(LocalUiType localUiType, com.transsion.player.orplayer.f fVar) {
        Intrinsics.h(localUiType, "uiType");
        A1(localUiType == LocalUiType.LAND);
        e1();
        if (P0()) {
            return;
        }
        O();
        if (fVar != null && !fVar.isPlaying() && !fVar.isComplete() && T0()) {
            T1();
        }
        if (O0()) {
            V0();
            l1(false);
        }
    }

    public final void y2() {
        J1(System.currentTimeMillis());
        C1(false);
        O();
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ImageView z0() {
        wn.j jVar = this.Q;
        if (jVar != null) {
            return jVar.n;
        }
        return null;
    }

    public final void z2() {
        Q();
        R();
    }
}
