package com.transsion.player.longvideo.ui.dialog;

import android.app.Application;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.blankj.utilcode.util.Utils;
import com.cloud.hisavana.sdk.common.util.k0;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.noober.background.view.BLTextView;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.longvideo.R$string;
import com.transsion.player.longvideo.constants.LongVodContentType;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.player.longvideo.view.LongVodRewardInterceptView;
import com.transsion.player.ui.longvideo.ORLongVodPlayerView;
import com.transsion.postdetail.ad.AdInterceptTimerView;
import com.transsion.postdetail.ad.BaseVideoAdHelper;
import com.transsion.postdetail.ui.view.AdCountDownView;
import com.transsion.push.PushConstants;
import fh.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.t1;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LongVodPlayerViewAdHelper extends BaseVideoAdHelper {
    private mn.j R;
    private ln.a S;
    private VideoDetailPlayBean T;
    private String U;
    private BiddingVideoManager W;
    private BiddingInterstitialManager X;
    private boolean Y;
    private boolean Z;
    private boolean a0;
    private boolean b0;
    private boolean c0;
    private boolean d0;
    private long e0;
    private long f0;
    private long g0;
    private int h0;
    private Function0 j0;
    private Function1 k0;
    private t1 r0;
    private int s0;
    private LongVodPlayerView u0;
    private final String Q = "streamVideo";
    private final Lazy V = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.e
        public final Object invoke() {
            VideoDetailPlayDao T4;
            T4 = LongVodPlayerViewAdHelper.T4();
            return T4;
        }
    });
    private String i0 = BuildConfig.FLAVOR;
    private final Lazy l0 = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.k
        public final Object invoke() {
            int B4;
            B4 = LongVodPlayerViewAdHelper.B4(LongVodPlayerViewAdHelper.this);
            return Integer.valueOf(B4);
        }
    });
    private final Lazy m0 = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.l
        public final Object invoke() {
            int s4;
            s4 = LongVodPlayerViewAdHelper.s4(LongVodPlayerViewAdHelper.this);
            return Integer.valueOf(s4);
        }
    });
    private final Lazy n0 = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.m
        public final Object invoke() {
            int z4;
            z4 = LongVodPlayerViewAdHelper.z4(LongVodPlayerViewAdHelper.this);
            return Integer.valueOf(z4);
        }
    });
    private final Lazy o0 = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.n
        public final Object invoke() {
            int A4;
            A4 = LongVodPlayerViewAdHelper.A4(LongVodPlayerViewAdHelper.this);
            return Integer.valueOf(A4);
        }
    });
    private final Lazy p0 = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.o
        public final Object invoke() {
            boolean a4;
            a4 = LongVodPlayerViewAdHelper.a4(LongVodPlayerViewAdHelper.this);
            return Boolean.valueOf(a4);
        }
    });
    private final Lazy q0 = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.p
        public final Object invoke() {
            int U4;
            U4 = LongVodPlayerViewAdHelper.U4();
            return Integer.valueOf(U4);
        }
    });
    private final a t0 = new a();

    public static final class a extends oh.a {
        a() {
        }

        public void i(TAdErrorCode tAdErrorCode) {
            a.a.g(wf.a.a, LongVodPlayerViewAdHelper.this.I3() + " --> rewardInterceptListener --> onError() --> 广告加载失败", false, 2, (Object) null);
            LongVodPlayerViewAdHelper.this.h4();
        }

        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            a.a.g(wf.a.a, LongVodPlayerViewAdHelper.this.I3() + " --> rewardInterceptListener --> onLoad() --> 广告加载", false, 2, (Object) null);
            LongVodPlayerViewAdHelper.this.i4(biddingIntermediateMaterialBean);
        }

        public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            a.a.g(wf.a.a, LongVodPlayerViewAdHelper.this.I3() + " --> rewardInterceptListener --> onClosed() --> 广告关闭", false, 2, (Object) null);
            LongVodPlayerViewAdHelper.this.g4();
        }

        public void n(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            a.a.g(wf.a.a, LongVodPlayerViewAdHelper.this.I3() + " --> rewardInterceptListener --> onShow() --> Hi广告展示", false, 2, (Object) null);
            LongVodPlayerViewAdHelper.this.k4();
        }

        public void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            a.a.g(wf.a.a, LongVodPlayerViewAdHelper.this.I3() + " --> rewardInterceptListener --> onRewarded() --> 广告奖励", false, 2, (Object) null);
            LongVodPlayerViewAdHelper.this.j4();
        }

        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            a.a.g(wf.a.a, LongVodPlayerViewAdHelper.this.I3() + " --> rewardInterceptListener --> onError() --> 广告展示失败", false, 2, (Object) null);
            LongVodPlayerViewAdHelper.this.l4();
        }
    }

    private final void A3() {
        LongVodRewardInterceptView longVodRewardInterceptView;
        mn.g bind;
        BLTextView bLTextView;
        View root;
        Context context;
        t1 t1Var = this.r0;
        String str = null;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        this.r0 = null;
        this.s0 = 0;
        mn.j jVar = this.R;
        if (jVar == null || (longVodRewardInterceptView = jVar.v) == null || (bind = longVodRewardInterceptView.getBind()) == null || (bLTextView = bind.h) == null) {
            return;
        }
        mn.j jVar2 = this.R;
        if (jVar2 != null && (root = jVar2.getRoot()) != null && (context = root.getContext()) != null) {
            str = context.getString(R$string.long_vod_reward_intercept_watch_ad);
        }
        bLTextView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper) {
        return longVodPlayerViewAdHelper.P3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int B4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper) {
        return longVodPlayerViewAdHelper.J3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C3(final LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, View view) {
        longVodPlayerViewAdHelper.L(true, new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.j
            public final Object invoke() {
                Unit D3;
                D3 = LongVodPlayerViewAdHelper.D3(LongVodPlayerViewAdHelper.this);
                return D3;
            }
        });
        longVodPlayerViewAdHelper.w4(PushConstants.PUSH_SERVICE_TYPE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D3(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper) {
        longVodPlayerViewAdHelper.G4();
        longVodPlayerViewAdHelper.z3();
        return Unit.a;
    }

    private final void E4() {
        mn.i iVar;
        AdInterceptTimerView adInterceptTimerView;
        wn.d bind;
        TextView textView;
        if (!this.c0 || U0()) {
            F4(false);
            return;
        }
        long O3 = O3() - this.f0;
        if (O3 <= 0) {
            J4();
            return;
        }
        mn.j jVar = this.R;
        if (jVar != null && (iVar = jVar.q) != null && (adInterceptTimerView = iVar.c) != null && (bind = adInterceptTimerView.getBind()) != null && (textView = bind.d) != null) {
            textView.setText(H3(O3));
        }
        F4(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F3() {
        BiddingInterstitialManager biddingInterstitialManager = this.X;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.U();
        }
        this.X = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G3() {
        BiddingVideoManager biddingVideoManager = this.W;
        if (biddingVideoManager != null) {
            biddingVideoManager.U();
        }
        this.W = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G4() {
        ConstraintLayout constraintLayout;
        F1(false);
        this.c0 = false;
        this.Y = true;
        mn.j jVar = this.R;
        if (jVar != null && (constraintLayout = jVar.v) != null) {
            uf.c.g(constraintLayout);
        }
        F4(false);
        A3();
    }

    private final String H3(long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(j);
        long seconds = timeUnit.toSeconds(j) % 60;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H4() {
        String str = this.i0;
        if (Intrinsics.c(str, "StreamVideoInterceptRewarded")) {
            c4();
        } else if (Intrinsics.c(str, "StreamVideoInterceptInterstitial")) {
            b4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String I3() {
        String simpleName = LongVodPlayerViewAdHelper.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I4(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        View root;
        Context context;
        mn.j jVar = this.R;
        if (jVar == null || (root = jVar.getRoot()) == null || (context = root.getContext()) == null) {
            return;
        }
        this.i0 = "StreamVideoInterceptInterstitial";
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$showInterstitialAd$1$1(this, context, biddingIntermediateMaterialBean, null), 3, (Object) null);
        }
    }

    private final int J3() {
        JsonElement jsonElement;
        Subject m;
        ln.a aVar = this.S;
        if (!((aVar == null || (m = aVar.m()) == null) ? false : Intrinsics.c(m.isCam(), Boolean.TRUE))) {
            JsonObject b = com.transsion.ad.scene.d.a.b("StreamVideoInterceptRewarded");
            if (b == null || (jsonElement = b.get("freeTimes")) == null) {
                return 1;
            }
            return jsonElement.getAsInt();
        }
        wj.h.a.a(I3() + " --> getFreeTimesConfig() --> 枪版没有免费费次数");
        return 0;
    }

    private final void J4() {
        LongVodRewardInterceptView longVodRewardInterceptView;
        LongVodRewardInterceptView longVodRewardInterceptView2;
        mn.g bind;
        LinearLayout linearLayout;
        LongVodRewardInterceptView longVodRewardInterceptView3;
        mn.g bind2;
        Group group;
        LongVodRewardInterceptView longVodRewardInterceptView4;
        mn.g bind3;
        Group group2;
        BLTextView bLTextView;
        LongVodRewardInterceptView longVodRewardInterceptView5;
        mn.g bind4;
        Group group3;
        LongVodRewardInterceptView longVodRewardInterceptView6;
        mn.g bind5;
        Group group4;
        BLTextView bLTextView2;
        BLTextView bLTextView3;
        Subject m;
        Subject m2;
        ConstraintLayout constraintLayout;
        if (!this.c0 || this.f0 < O3()) {
            return;
        }
        F1(true);
        Function0 function0 = this.j0;
        if (function0 != null) {
            function0.invoke();
        }
        mn.j jVar = this.R;
        if (jVar != null && (constraintLayout = jVar.v) != null) {
            uf.c.k(constraintLayout);
        }
        F4(false);
        u4();
        mn.j jVar2 = this.R;
        if (jVar2 != null && (longVodRewardInterceptView = jVar2.v) != null) {
            wj.h hVar = wj.h.a;
            String I3 = I3();
            ln.a aVar = this.S;
            hVar.a(I3 + " --> showRewardInterceptView() --> mBean?.subject?.isCam = " + ((aVar == null || (m2 = aVar.m()) == null) ? null : m2.isCam()));
            ln.a aVar2 = this.S;
            if ((aVar2 == null || (m = aVar2.m()) == null) ? false : Intrinsics.c(m.isCam(), Boolean.FALSE)) {
                if (T3() > 0) {
                    mn.g bind6 = longVodRewardInterceptView.getBind();
                    if (bind6 != null && (bLTextView3 = bind6.h) != null) {
                        bLTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.q
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                LongVodPlayerViewAdHelper.K4(LongVodPlayerViewAdHelper.this, view);
                            }
                        });
                    }
                    Q4();
                } else {
                    mn.g bind7 = longVodRewardInterceptView.getBind();
                    if (bind7 != null && (bLTextView = bind7.h) != null) {
                        bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.r
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                LongVodPlayerViewAdHelper.L4(LongVodPlayerViewAdHelper.this, view);
                            }
                        });
                    }
                }
                mn.g bind8 = longVodRewardInterceptView.getBind();
                if (bind8 != null && (bLTextView2 = bind8.d) != null) {
                    bLTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.s
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            LongVodPlayerViewAdHelper.M4(LongVodPlayerViewAdHelper.this, view);
                        }
                    });
                }
                mn.j jVar3 = this.R;
                if (jVar3 != null && (longVodRewardInterceptView6 = jVar3.v) != null && (bind5 = longVodRewardInterceptView6.getBind()) != null && (group4 = bind5.b) != null) {
                    group4.setVisibility(0);
                }
                mn.j jVar4 = this.R;
                if (jVar4 != null && (longVodRewardInterceptView5 = jVar4.v) != null && (bind4 = longVodRewardInterceptView5.getBind()) != null && (group3 = bind4.c) != null) {
                    group3.setVisibility(8);
                }
            } else {
                mn.j jVar5 = this.R;
                if (jVar5 != null && (longVodRewardInterceptView4 = jVar5.v) != null && (bind3 = longVodRewardInterceptView4.getBind()) != null && (group2 = bind3.b) != null) {
                    group2.setVisibility(8);
                }
                mn.j jVar6 = this.R;
                if (jVar6 != null && (longVodRewardInterceptView3 = jVar6.v) != null && (bind2 = longVodRewardInterceptView3.getBind()) != null && (group = bind2.c) != null) {
                    group.setVisibility(0);
                }
                mn.j jVar7 = this.R;
                if (jVar7 != null && (longVodRewardInterceptView2 = jVar7.v) != null && (bind = longVodRewardInterceptView2.getBind()) != null && (linearLayout = bind.i) != null) {
                    linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            LongVodPlayerViewAdHelper.O4(LongVodPlayerViewAdHelper.this, view);
                        }
                    });
                }
            }
        }
        x4("browse", true);
    }

    private final int K3() {
        return ((Number) this.m0.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, View view) {
        longVodPlayerViewAdHelper.A3();
        longVodPlayerViewAdHelper.H4();
        longVodPlayerViewAdHelper.x4(PushConstants.PUSH_SERVICE_TYPE_CLICK, true);
    }

    private final int L3() {
        JsonElement jsonElement;
        JsonObject b = com.transsion.ad.scene.d.a.b("StreamVideoInterceptRewarded");
        if (b == null || (jsonElement = b.get("playedPercent")) == null) {
            return 10;
        }
        return jsonElement.getAsInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, View view) {
        longVodPlayerViewAdHelper.H4();
        longVodPlayerViewAdHelper.x4(PushConstants.PUSH_SERVICE_TYPE_CLICK, true);
    }

    private final int M3() {
        return ((Number) this.n0.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M4(final LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, View view) {
        longVodPlayerViewAdHelper.L(true, new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.g
            public final Object invoke() {
                Unit N4;
                N4 = LongVodPlayerViewAdHelper.N4(LongVodPlayerViewAdHelper.this);
                return N4;
            }
        });
        longVodPlayerViewAdHelper.x4(PushConstants.PUSH_SERVICE_TYPE_CLICK, false);
    }

    private final int N3() {
        JsonElement jsonElement;
        JsonObject b = com.transsion.ad.scene.d.a.b("StreamVideoInterceptRewarded");
        return ((b == null || (jsonElement = b.get("interceptDuration")) == null) ? 10 : jsonElement.getAsInt()) * 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper) {
        longVodPlayerViewAdHelper.G4();
        longVodPlayerViewAdHelper.z3();
        return Unit.a;
    }

    private final int O3() {
        return ((Number) this.o0.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, View view) {
        LifecycleCoroutineScope w0 = longVodPlayerViewAdHelper.w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$showRewardInterceptView$1$4$1(longVodPlayerViewAdHelper, null), 3, (Object) null);
        }
    }

    private final int P3() {
        JsonElement jsonElement;
        JsonObject b = com.transsion.ad.scene.d.a.b("StreamVideoInterceptRewarded");
        return ((b == null || (jsonElement = b.get("interceptProgress")) == null) ? 5 : jsonElement.getAsInt()) * 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P4(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        View root;
        Context context;
        mn.j jVar = this.R;
        if (jVar == null || (root = jVar.getRoot()) == null || (context = root.getContext()) == null) {
            return;
        }
        this.i0 = "StreamVideoInterceptRewarded";
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$showRewardedAd$1$1(this, context, biddingIntermediateMaterialBean, null), 3, (Object) null);
        }
    }

    private final int Q3() {
        return ((Number) this.l0.getValue()).intValue();
    }

    private final void Q4() {
        t1 t1Var = this.r0;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        this.s0 = T3();
        R4();
        LifecycleCoroutineScope w0 = w0();
        this.r0 = w0 != null ? kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$startWatchAdCountdown$1(this, null), 3, (Object) null) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object R3(Continuation continuation) {
        LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1 longVodPlayerViewAdHelper$getVideoDetailPlayBean$1;
        int i;
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper;
        ln.a aVar;
        if (continuation instanceof LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1) {
            longVodPlayerViewAdHelper$getVideoDetailPlayBean$1 = (LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1) continuation;
            int i2 = longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.label = i2 - Integer.MIN_VALUE;
                Object obj = longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.result;
                Object f = IntrinsicsKt.f();
                i = longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    VideoDetailPlayBean videoDetailPlayBean = this.T;
                    if (videoDetailPlayBean != null) {
                        return videoDetailPlayBean;
                    }
                    ln.a aVar2 = this.S;
                    if (aVar2 != null) {
                        VideoDetailPlayDao S3 = S3();
                        String o = aVar2.o();
                        int l = aVar2.l();
                        int e = aVar2.e();
                        longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.L$0 = this;
                        longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.label = 1;
                        obj = S3.l(o, l, e, longVodPlayerViewAdHelper$getVideoDetailPlayBean$1);
                        if (obj == f) {
                            return f;
                        }
                        longVodPlayerViewAdHelper = this;
                    }
                    if (this.T == null && (aVar = this.S) != null) {
                        this.T = new VideoDetailPlayBean(aVar.o(), BuildConfig.FLAVOR, aVar.e(), aVar.l(), 0L, null, null, null, null, 0L, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, null, 134217712, null);
                    }
                    return this.T;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                longVodPlayerViewAdHelper = (LongVodPlayerViewAdHelper) longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.L$0;
                ResultKt.b(obj);
                longVodPlayerViewAdHelper.T = (VideoDetailPlayBean) obj;
                if (this.T == null) {
                    this.T = new VideoDetailPlayBean(aVar.o(), BuildConfig.FLAVOR, aVar.e(), aVar.l(), 0L, null, null, null, null, 0L, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, null, 134217712, null);
                }
                return this.T;
            }
        }
        longVodPlayerViewAdHelper$getVideoDetailPlayBean$1 = new LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1(this, continuation);
        Object obj2 = longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.result;
        Object f2 = IntrinsicsKt.f();
        i = longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.label;
        if (i != 0) {
        }
        longVodPlayerViewAdHelper.T = (VideoDetailPlayBean) obj2;
        if (this.T == null) {
        }
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R4() {
        LongVodRewardInterceptView longVodRewardInterceptView;
        mn.g bind;
        BLTextView bLTextView;
        View root;
        Context context;
        mn.j jVar = this.R;
        if (jVar == null || (longVodRewardInterceptView = jVar.v) == null || (bind = longVodRewardInterceptView.getBind()) == null || (bLTextView = bind.h) == null) {
            return;
        }
        mn.j jVar2 = this.R;
        bLTextView.setText((jVar2 == null || (root = jVar2.getRoot()) == null || (context = root.getContext()) == null) ? null : context.getString(R$string.long_vod_reward_intercept_watch_ad_countdown, Integer.valueOf(this.s0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao S3() {
        return (VideoDetailPlayDao) this.V.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S4() {
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$updateRewardState$1(this, null), 3, (Object) null);
        }
    }

    private final int T3() {
        return ((Number) this.q0.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao T4() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return appDatabase$f1.b(a2).C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int U4() {
        JsonElement jsonElement;
        JsonObject b = com.transsion.ad.scene.d.a.b("StreamVideoInterceptRewarded");
        if (b == null || (jsonElement = b.get("countdown")) == null) {
            return 5;
        }
        return jsonElement.getAsInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W3(ln.a aVar) {
        ConstraintLayout constraintLayout;
        F1(false);
        this.d0 = false;
        mn.j jVar = this.R;
        if (jVar != null && (constraintLayout = jVar.v) != null) {
            uf.c.g(constraintLayout);
        }
        if (Z3()) {
            this.c0 = false;
            return;
        }
        if (ij.o.a.g() || ij.g.a.b()) {
            this.c0 = false;
            return;
        }
        this.e0 = aVar.k();
        this.f0 = aVar.k();
        VideoDetailPlayBean videoDetailPlayBean = this.T;
        this.Y = videoDetailPlayBean != null ? videoDetailPlayBean.getRewardUnlock() : false;
        VideoDetailPlayBean videoDetailPlayBean2 = this.T;
        this.Z = videoDetailPlayBean2 != null ? videoDetailPlayBean2.getRewardPlayed() : false;
        VideoDetailPlayBean videoDetailPlayBean3 = this.T;
        this.a0 = videoDetailPlayBean3 != null ? videoDetailPlayBean3.getRewardFree() : false;
        a.a aVar2 = wf.a.a;
        a.a.f(aVar2, "VideoAdHelper", "---> initRewardInterceptVariables --> startPlayProgress:" + this.e0 + "，isRewardUnlock:" + this.Y + ", rewardUnlockFreeTimes:" + Q3(), false, 4, (Object) null);
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        MMKV b = bVar.b();
        String str = this.Q;
        StringBuilder sb = new StringBuilder();
        sb.append("zero_clock_timestamp_");
        sb.append(str);
        long j = b.getLong(sb.toString(), 0L);
        if (X0(this.Q, false)) {
            this.h0 = 0;
            boolean z = Q3() == 0 && !this.Y;
            this.c0 = z;
            this.Z = z;
            this.a0 = !z;
            a.a.f(aVar2, "VideoAdHelper", "---> FreeTimes Reset", false, 4, (Object) null);
            bVar.b().putInt("video_played_count_per_day", 0);
        } else {
            int i = bVar.b().getInt("video_played_count_per_day", 0);
            this.h0 = i;
            if (i >= Q3()) {
                this.c0 = !this.Y;
            }
            VideoDetailPlayBean videoDetailPlayBean4 = this.T;
            if (Math.abs(k0.c(videoDetailPlayBean4 != null ? videoDetailPlayBean4.getTimeStamp() : 0L) - j) >= 86400000) {
                boolean z2 = this.c0;
                this.Z = z2;
                this.a0 = !z2;
            } else if (this.a0) {
                this.c0 = false;
            }
            a.a.f(aVar2, "VideoAdHelper", "---> videoPlayedTimesPerDay:" + this.h0 + ", isRewardPlayed:" + this.Z + ", isRewardFree:" + this.a0, false, 4, (Object) null);
        }
        VideoDetailPlayBean videoDetailPlayBean5 = this.T;
        if (videoDetailPlayBean5 == null || videoDetailPlayBean5.getRewardFree() != this.a0) {
            S4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X3() {
        View root;
        Context context;
        m4();
        F3();
        b.a aVar = fh.b.a;
        mn.j jVar = this.R;
        aVar.e((jVar == null || (root = jVar.getRoot()) == null || (context = root.getContext()) == null) ? null : context.getString(R$string.long_vod_reward_intercept_skip));
    }

    private final boolean Z3() {
        return ((Boolean) this.p0.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper) {
        return longVodPlayerViewAdHelper.L0("StreamVideoInterceptRewarded").length() > 0 || longVodPlayerViewAdHelper.Y3(BaseVideoAdHelper.P.a(), longVodPlayerViewAdHelper.j0());
    }

    private final void b4() {
        View root;
        Context context;
        mn.j jVar = this.R;
        if (jVar == null || (root = jVar.getRoot()) == null || (context = root.getContext()) == null) {
            return;
        }
        this.i0 = "StreamVideoInterceptInterstitial";
        BiddingInterstitialManager biddingInterstitialManager = this.X;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.U();
        }
        this.X = null;
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$loadInterstitialAd$1(context, this, null), 3, (Object) null);
        }
    }

    private final void c4() {
        mn.j jVar;
        View root;
        Context context;
        if (Z3() || (jVar = this.R) == null || (root = jVar.getRoot()) == null || (context = root.getContext()) == null) {
            return;
        }
        this.i0 = "StreamVideoInterceptRewarded";
        BiddingVideoManager biddingVideoManager = this.W;
        if (biddingVideoManager != null) {
            biddingVideoManager.U();
        }
        this.W = null;
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$loadRewardedAd$1(context, this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper) {
        LifecycleCoroutineScope w0 = longVodPlayerViewAdHelper.w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$onCompletion$1$1(longVodPlayerViewAdHelper, null), 3, (Object) null);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g4() {
        H(false);
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$onRewardInterceptAdClose$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h4() {
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$onRewardInterceptAdError$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i4(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$onRewardInterceptAdLoad$1(this, biddingIntermediateMaterialBean, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j4() {
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$onRewardInterceptAdRewarded$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k4() {
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$onRewardInterceptAdShow$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l4() {
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$onRewardInterceptAdShowError$1(this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m4() {
        G4();
        S4();
        H(false);
        z3();
    }

    private final void r4() {
        t1 t1Var = this.r0;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        this.r0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper) {
        return longVodPlayerViewAdHelper.L3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t4() {
        this.i0 = "StreamVideoInterceptInterstitial";
        BiddingInterstitialManager.t.a("StreamVideoInterceptInterstitial", com.transsion.ad.strategy.c.a.a(j0()));
    }

    private final void u4() {
        if (Z3()) {
            return;
        }
        this.i0 = "StreamVideoInterceptRewarded";
        BiddingVideoManager.t.a("StreamVideoInterceptRewarded", com.transsion.ad.strategy.c.a.a(j0()));
    }

    private final void v4(String str, Map map) {
        if (Intrinsics.c(str, "browse")) {
            qi.h hVar = qi.h.a;
            String str2 = this.U;
            hVar.q(str2 != null ? str2 : "LongVodPlayer", str, map);
        } else if (Intrinsics.c(str, PushConstants.PUSH_SERVICE_TYPE_CLICK)) {
            qi.h hVar2 = qi.h.a;
            String str3 = this.U;
            hVar2.q(str3 != null ? str3 : "LongVodPlayer", str, map);
        }
    }

    private final void w4(String str) {
        if (this.c0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("scene_id", "StreamVideoInterceptRewarded");
            linkedHashMap.put("module_name", "stream_rewarded_countdown_timer");
            if (Intrinsics.c(str, "browse")) {
                linkedHashMap.put("action", "show_view");
            } else if (Intrinsics.c(str, PushConstants.PUSH_SERVICE_TYPE_CLICK)) {
                linkedHashMap.put("action", "click_member");
            }
            v4(str, linkedHashMap);
        }
    }

    private final void x4(String str, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("scene_id", "StreamVideoInterceptRewarded");
        linkedHashMap.put("module_name", "stream_rewarded_intercept_view");
        if (Intrinsics.c(str, "browse")) {
            linkedHashMap.put("action", "show_view");
        } else if (Intrinsics.c(str, PushConstants.PUSH_SERVICE_TYPE_CLICK)) {
            linkedHashMap.put("action", z ? "click_ad" : "click_member");
        }
        v4(str, linkedHashMap);
    }

    private final void y4() {
        if (!U0() || this.s0 <= 0) {
            return;
        }
        t1 t1Var = this.r0;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        LifecycleCoroutineScope w0 = w0();
        this.r0 = w0 != null ? kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$resumeWatchAdCountdown$1(this, null), 3, (Object) null) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z3() {
        Function1 function1 = this.k0;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this.b0));
        }
        if (this.b0) {
            J1(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int z4(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper) {
        return longVodPlayerViewAdHelper.N3();
    }

    public final void B3(long j, Function0 function0, Function0 function02, Function1 function1) {
        mn.i iVar;
        AdInterceptTimerView adInterceptTimerView;
        wn.d bind;
        TextView textView;
        Intrinsics.h(function0, "callback");
        Intrinsics.h(function02, "interceptCallback");
        Intrinsics.h(function1, "unlockCallback");
        if (Z3()) {
            function0.invoke();
            return;
        }
        this.j0 = function02;
        this.k0 = function1;
        this.g0 = (long) ((K3() * j) / 100.0f);
        boolean z = j >= ((long) M3());
        this.c0 = this.c0 && z;
        a.a.f(wf.a.a, "VideoAdHelper", "---> checkShowRewardIntercept --> totalDuration:" + j + ", playedThreshold:" + this.g0 + ", isTotalDurationFit:" + z + ", rewardInterceptProgress:" + O3() + ", isRewardInterceptEnable:" + this.c0, false, 4, (Object) null);
        if (this.Y || j < M3()) {
            J1(System.currentTimeMillis());
            this.d0 = true;
            function0.invoke();
            return;
        }
        if (this.e0 >= O3() && this.c0) {
            this.b0 = true;
            J4();
            return;
        }
        this.b0 = false;
        E4();
        w4("browse");
        mn.j jVar = this.R;
        if (jVar != null && (iVar = jVar.q) != null && (adInterceptTimerView = iVar.c) != null && (bind = adInterceptTimerView.getBind()) != null && (textView = bind.f) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LongVodPlayerViewAdHelper.C3(LongVodPlayerViewAdHelper.this, view);
                }
            });
        }
        this.d0 = true;
        function0.invoke();
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ViewGroup C0() {
        return null;
    }

    public final void C4(LongVodContentType longVodContentType, ln.a aVar) {
        Intrinsics.h(longVodContentType, "contextType");
        Intrinsics.h(aVar, "bean");
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$setLongVdPlayerBean$1(this, aVar, longVodContentType, null), 3, (Object) null);
        }
    }

    public final void D4(LongVodPlayerView longVodPlayerView) {
        Intrinsics.h(longVodPlayerView, "view");
        this.u0 = longVodPlayerView;
    }

    public final void E3() {
        BiddingNativeManager u0 = u0();
        if (u0 != null) {
            u0.U();
        }
        this.R = null;
        BiddingInterstitialManager v0 = v0();
        if (v0 != null) {
            v0.U();
        }
        y1(null);
        BiddingVideoManager biddingVideoManager = this.W;
        if (biddingVideoManager != null) {
            biddingVideoManager.U();
        }
        this.W = null;
        BiddingInterstitialManager biddingInterstitialManager = this.X;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.U();
        }
        this.X = null;
        Q();
        CountDownTimer d0 = d0();
        if (d0 != null) {
            d0.cancel();
        }
        n1(null);
        A3();
    }

    public final void F4(boolean z) {
        mn.i iVar;
        AdInterceptTimerView adInterceptTimerView;
        AdInterceptTimerView e0;
        mn.i iVar2;
        AdInterceptTimerView adInterceptTimerView2;
        if (z && this.c0 && !U0() && (e0 = e0()) != null && e0.getVisibility() == 8) {
            mn.j jVar = this.R;
            if (jVar == null || (iVar2 = jVar.q) == null || (adInterceptTimerView2 = iVar2.c) == null) {
                return;
            }
            uf.c.k(adInterceptTimerView2);
            return;
        }
        mn.j jVar2 = this.R;
        if (jVar2 == null || (iVar = jVar2.q) == null || (adInterceptTimerView = iVar.c) == null) {
            return;
        }
        uf.c.g(adInterceptTimerView);
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    public void H(boolean z) {
        super.H(z);
        if (M0()) {
            F4(false);
        } else {
            F4(this.d0);
        }
    }

    public final void U3(boolean z) {
        D1(x0() + ((System.currentTimeMillis() - B0()) / 1000));
        J1(System.currentTimeMillis());
        if (z) {
            C1(true);
            if (!ij.o.a.g() && !ij.g.a.b()) {
                T1();
            }
            F4(false);
        }
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected NativeWrapperAdView V() {
        mn.j jVar = this.R;
        if (jVar != null) {
            return jVar.c;
        }
        return null;
    }

    public final void V3(String str, mn.j jVar, String str2, Function1 function1) {
        Intrinsics.h(jVar, "viewBinding");
        Intrinsics.h(function1, "adShowCallback");
        this.U = str;
        this.R = jVar;
        E0(jVar, str2, function1);
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected AdCountDownView W() {
        mn.j jVar = this.R;
        if (jVar != null) {
            return jVar.d;
        }
        return null;
    }

    public final boolean Y3(String str, String str2) {
        boolean z = false;
        if (str != null && !StringsKt.q0(str) && str2 != null && !StringsKt.q0(str2)) {
            List S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.v(S0, 10));
            Iterator it = S0.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.n1((String) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            Set W0 = CollectionsKt.W0(arrayList2);
            if (W0.isEmpty()) {
                return false;
            }
            List S02 = StringsKt.S0(str2, new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.v(S02, 10));
            Iterator it2 = S02.iterator();
            while (it2.hasNext()) {
                arrayList3.add(StringsKt.n1((String) it2.next()).toString());
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (((String) obj2).length() > 0) {
                    arrayList4.add(obj2);
                }
            }
            if (!arrayList4.isEmpty()) {
                Iterator it3 = arrayList4.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if (W0.contains((String) it3.next())) {
                        z = true;
                        break;
                    }
                }
            }
            a.a.f(wf.a.a, "VideoAdHelper", I3() + " --> isCtxMatch: " + z + " ---> configStr: " + str + "， targetStr: " + str2, false, 4, (Object) null);
        }
        return z;
    }

    public final void d4(Function0 function0) {
        Intrinsics.h(function0, "callback");
        D1(0L);
        J1(0L);
        j1(function0);
        R();
        d2(new Function0() { // from class: com.transsion.player.longvideo.ui.dialog.h
            public final Object invoke() {
                Unit e4;
                e4 = LongVodPlayerViewAdHelper.e4(LongVodPlayerViewAdHelper.this);
                return e4;
            }
        });
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected AdInterceptTimerView e0() {
        mn.j jVar = this.R;
        if (jVar != null) {
            return jVar.f;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected NativeWrapperAdView f0() {
        mn.j jVar = this.R;
        if (jVar != null) {
            return jVar.g;
        }
        return null;
    }

    public final void f4() {
        j1(null);
        P();
        E1(0);
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ViewGroup g0() {
        mn.j jVar = this.R;
        if (jVar != null) {
            return jVar.h;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ViewGroup h0() {
        mn.j jVar = this.R;
        if (jVar != null) {
            return jVar.i;
        }
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected View k0() {
        return null;
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    public void l2() {
        LifecycleCoroutineScope w0 = w0();
        if (w0 != null) {
            kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1(this, null), 3, (Object) null);
        }
    }

    public final void n4(LongVodUiType longVodUiType) {
        ORLongVodPlayerView oRLongVodPlayerView;
        mn.j jVar;
        ORLongVodPlayerView oRLongVodPlayerView2;
        Intrinsics.h(longVodUiType, "curUiType");
        A1(longVodUiType == LongVodUiType.LAND);
        e1();
        if (P0()) {
            return;
        }
        O();
        mn.j jVar2 = this.R;
        if (jVar2 != null && (oRLongVodPlayerView = jVar2.u) != null && !oRLongVodPlayerView.isPlaying() && (jVar = this.R) != null && (oRLongVodPlayerView2 = jVar.u) != null && !oRLongVodPlayerView2.isComplete() && T0()) {
            T1();
        }
        if (O0()) {
            V0();
            l1(false);
        }
    }

    public final void o4() {
        J1(System.currentTimeMillis());
        E4();
        C1(false);
        O();
    }

    public final void p4() {
        Q();
        R();
        F4(false);
        r4();
    }

    public final void q4() {
        ORLongVodPlayerView oRLongVodPlayerView;
        ORLongVodPlayerView oRLongVodPlayerView2;
        if (O0()) {
            I(b0());
        }
        a.a aVar = wf.a.a;
        mn.j jVar = this.R;
        a.a.f(aVar, "VideoAdHelper", "onViewResume --> isPlaying:" + ((jVar == null || (oRLongVodPlayerView2 = jVar.u) == null) ? null : Boolean.valueOf(oRLongVodPlayerView2.isPlaying())), false, 4, (Object) null);
        mn.j jVar2 = this.R;
        F4(!((jVar2 == null || (oRLongVodPlayerView = jVar2.u) == null) ? false : oRLongVodPlayerView.isPlaying()));
        y4();
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ImageView t0() {
        mn.j jVar = this.R;
        if (jVar != null) {
            return jVar.n;
        }
        return null;
    }

    public final void y3(long j) {
        this.f0 = j;
        if (Z3()) {
            return;
        }
        E4();
        if (U0() || this.c0 || this.Z || Math.abs(j - this.e0) < this.g0) {
            return;
        }
        this.Z = true;
        this.h0++;
        com.transsion.baselib.report.launch.b.a.b().putInt("video_played_count_per_day", this.h0);
        a.a.f(wf.a.a, "VideoAdHelper", "--> calculatePlayedTimes --> videoPlayedTimesPerDay:" + this.h0, false, 4, (Object) null);
        S4();
    }

    @Override // com.transsion.postdetail.ad.BaseVideoAdHelper
    protected ImageView z0() {
        mn.j jVar = this.R;
        if (jVar != null) {
            return jVar.w;
        }
        return null;
    }
}
