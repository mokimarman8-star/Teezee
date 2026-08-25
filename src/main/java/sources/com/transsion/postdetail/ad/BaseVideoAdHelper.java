package com.transsion.postdetail.ad;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.blankj.utilcode.util.a0;
import com.cloud.hisavana.sdk.common.util.k0;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.mediation.ad.TAdChoicesView;
import com.hisavana.mediation.ad.TMediaView;
import com.therouter.TheRouter;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.GslbSdk;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.memberapi.MemberSource;
import com.transsion.postdetail.ui.view.AdCountDownView;
import com.transsion.wrapperad.R;
import im.b$a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import wn.l0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseVideoAdHelper {
    public static final a P = new a(null);
    private BubbleTextView B;
    private AnimatorSet C;
    private int D;
    private int E;
    private int K;
    private f4.a M;
    private VideoFloatingView N;
    private LifecycleCoroutineScope a;
    private String b;
    private Function1 c;
    private Function0 d;
    private BiddingNativeManager e;
    private BiddingInterstitialManager f;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private long l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private CountDownTimer t;
    private CountDownTimer u;
    private long v;
    private long w;
    private long x;
    private String g = BuildConfig.FLAVOR;
    private final String y = "bubble_tip_video_start";
    private final String z = "bubble_tip_interpolate";
    private final String A = "floating_show_time";
    private final Lazy F = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.q
        public final Object invoke() {
            int K;
            K = BaseVideoAdHelper.K(BaseVideoAdHelper.this);
            return Integer.valueOf(K);
        }
    });
    private final Lazy G = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.r
        public final Object invoke() {
            int J;
            J = BaseVideoAdHelper.J(BaseVideoAdHelper.this);
            return Integer.valueOf(J);
        }
    });
    private final Lazy H = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.s
        public final Object invoke() {
            int K0;
            K0 = BaseVideoAdHelper.K0(BaseVideoAdHelper.this);
            return Integer.valueOf(K0);
        }
    });
    private final Lazy I = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.t
        public final Object invoke() {
            int I0;
            I0 = BaseVideoAdHelper.I0(BaseVideoAdHelper.this);
            return Integer.valueOf(I0);
        }
    });
    private final Lazy J = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.u
        public final Object invoke() {
            int J0;
            J0 = BaseVideoAdHelper.J0(BaseVideoAdHelper.this);
            return Integer.valueOf(J0);
        }
    });
    private final Lazy L = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.v
        public final Object invoke() {
            int S;
            S = BaseVideoAdHelper.S();
            return Integer.valueOf(S);
        }
    });
    private String O = BuildConfig.FLAVOR;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            String value;
            ConfigBean c = cm.f.c.a().c("stream_reward_intercept", true);
            return (c == null || (value = c.getValue()) == null) ? BuildConfig.FLAVOR : value;
        }
    }

    public static final class b extends CountDownTimer {
        final /* synthetic */ Ref.IntRef b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.IntRef intRef, String str, long j) {
            super(j, 1000L);
            this.b = intRef;
            this.c = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (Intrinsics.c(this.c, "VideoStartBidScene")) {
                BaseVideoAdHelper.this.l2();
            }
            BaseVideoAdHelper.this.E1(0);
            BaseVideoAdHelper.this.P();
            BaseVideoAdHelper.this.Q();
            BaseVideoAdHelper.this.f2(this.c);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            BaseVideoAdHelper baseVideoAdHelper = BaseVideoAdHelper.this;
            Ref.IntRef intRef = this.b;
            int i = intRef.element;
            intRef.element = i - 1;
            baseVideoAdHelper.E1(i);
            AdCountDownView W = BaseVideoAdHelper.this.W();
            if (W != null) {
                W.refreshCountDown(BaseVideoAdHelper.this.y0());
            }
        }
    }

    public static final class c implements im.c {
        final /* synthetic */ Function0 b;

        c(Function0 function0) {
            this.b = function0;
        }

        @Override // im.c
        public void a() {
        }

        @Override // im.c
        public void onSuccess() {
            BaseVideoAdHelper.this.P();
            Function0 function0 = this.b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final class d extends CountDownTimer {
        final /* synthetic */ BaseVideoAdHelper a;
        final /* synthetic */ Ref.LongRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, BaseVideoAdHelper baseVideoAdHelper, Ref.LongRef longRef) {
            super(j, 1000L);
            this.a = baseVideoAdHelper;
            this.b = longRef;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.a.R();
            if (this.a.U0()) {
                return;
            }
            this.a.t1(this.a.s0() + 1);
            BaseVideoAdHelper baseVideoAdHelper = this.a;
            BiddingNativeManager u0 = baseVideoAdHelper.u0();
            baseVideoAdHelper.S1("VideoInterpolateBidScene", u0 != null ? u0.k0() : null);
            this.a.L1("VideoInterpolateBidScene");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            wn.d bind;
            TextView textView;
            AdInterceptTimerView e0 = this.a.e0();
            if (e0 == null || (bind = e0.getBind()) == null || (textView = bind.d) == null) {
                return;
            }
            BaseVideoAdHelper baseVideoAdHelper = this.a;
            Ref.LongRef longRef = this.b;
            long j2 = longRef.element;
            longRef.element = (-1) + j2;
            textView.setText(baseVideoAdHelper.a0(j2));
        }
    }

    private final int A0() {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("VideoStartBidScene");
        return ((b2 == null || (jsonElement = b2.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    private final void B1() {
        ViewGroup h0 = h0();
        if (h0 != null) {
            ViewGroup.LayoutParams layoutParams = h0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = a0.a(this.h ? 426.0f : 219.0f);
                layoutParams.height = a0.a(this.h ? 240.0f : 123.0f);
            }
            AppCompatTextView findViewById = h0.findViewById(R.id.native_ad_action);
            if (findViewById != null) {
                ConstraintLayout.b layoutParams2 = findViewById.getLayoutParams();
                ConstraintLayout.b bVar = layoutParams2 instanceof ConstraintLayout.b ? layoutParams2 : null;
                if (bVar != null) {
                    ((ViewGroup.MarginLayoutParams) bVar).height = a0.a(this.h ? 32.0f : 20.0f);
                    int a2 = a0.a(8.0f);
                    ((ViewGroup.MarginLayoutParams) bVar).rightMargin = a2;
                    ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = a2;
                }
                findViewById.setTextSize(this.h ? 14.0f : 12.0f);
            }
        }
    }

    private final void G0() {
        AdCountDownView W = W();
        if (W != null) {
            W.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ad.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseVideoAdHelper.H0(BaseVideoAdHelper.this, view);
                }
            });
        }
    }

    private final void G1() {
        ImageView z0 = z0();
        if (z0 != null) {
            ViewGroup.LayoutParams layoutParams = z0.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                int a2 = a0.a(this.h ? 44.0f : 28.0f);
                layoutParams2.width = a2;
                layoutParams2.height = a2;
                layoutParams2.rightMargin = a0.a(this.h ? 16.0f : 12.0f);
                layoutParams2.bottomMargin = a0.a(this.h ? 16.0f : 10.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(BaseVideoAdHelper baseVideoAdHelper, View view) {
        M(baseVideoAdHelper, false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int I0(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int J(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.X("VideoInterpolateBidScene");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int J0(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int K(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.X("VideoStartBidScene");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int K0(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.n0();
    }

    private final void K1(ViewGroup viewGroup, boolean z) {
        ImageView imageView = viewGroup != null ? (ImageView) viewGroup.findViewWithTag("adVolumeImage") : null;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.gravity = 8388691;
                if (!z) {
                    layoutParams2.leftMargin = a0.a(this.h ? 16.0f : 12.0f);
                    layoutParams2.bottomMargin = a0.a(this.h ? 16.0f : 10.0f);
                    int a2 = a0.a(this.h ? 44.0f : 28.0f);
                    layoutParams2.width = a2;
                    layoutParams2.height = a2;
                    return;
                }
                int a3 = a0.a(8.0f);
                layoutParams2.leftMargin = a3;
                layoutParams2.bottomMargin = a3;
                int a4 = a0.a(20.0f);
                layoutParams2.width = a4;
                layoutParams2.height = a4;
            }
        }
    }

    public static /* synthetic */ void M(BaseVideoAdHelper baseVideoAdHelper, boolean z, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkMember");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        baseVideoAdHelper.L(z, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.h2();
        baseVideoAdHelper.D++;
        com.transsion.baselib.report.launch.b.a.b().putInt(baseVideoAdHelper.y, baseVideoAdHelper.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.h2();
        baseVideoAdHelper.E++;
        com.transsion.baselib.report.launch.b.a.b().putInt(baseVideoAdHelper.z, baseVideoAdHelper.E);
    }

    private final void O1() {
        if (this.o || this.s || !S0()) {
            return;
        }
        this.o = true;
        Y0(new Function0() { // from class: com.transsion.postdetail.ad.g
            public final Object invoke() {
                Unit P1;
                P1 = BaseVideoAdHelper.P1(BaseVideoAdHelper.this);
                return P1;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ad.h
            public final Object invoke() {
                Unit Q1;
                Q1 = BaseVideoAdHelper.Q1(BaseVideoAdHelper.this);
                return Q1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.i2();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.o = false;
        baseVideoAdHelper.v = 0L;
        baseVideoAdHelper.w = System.currentTimeMillis();
        return Unit.a;
    }

    private final boolean R0(int i, long j) {
        return Math.abs(System.currentTimeMillis() - j) > ((long) i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AppCompatActivity context;
        BiddingInterstitialManager biddingInterstitialManager;
        if (!this.h || this.q) {
            return;
        }
        H(true);
        this.k = true;
        this.r = true;
        ViewGroup g0 = g0();
        if (g0 != null && (context = g0.getContext()) != null && (biddingInterstitialManager = this.f) != null) {
            AbsAdBidding.O0(biddingInterstitialManager, context, biddingIntermediateMaterialBean, false, 4, (Object) null);
        }
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int S() {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("VideoFloatingNativeScene");
        if (b2 == null || (jsonElement = b2.get("showMax")) == null) {
            return 10;
        }
        return jsonElement.getAsInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(String str, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        Context context;
        this.O = str;
        H(true);
        this.m = true;
        this.l = System.currentTimeMillis();
        ViewGroup g0 = g0();
        if (g0 != null && (context = g0.getContext()) != null) {
            ow.b bVar = ow.b.a;
            BiddingNativeManager biddingNativeManager = this.e;
            com.transsion.ad.bidding.base.r a2 = bVar.a(context, biddingNativeManager != null ? biddingNativeManager.getSceneId() : null);
            NativeWrapperAdView f0 = f0();
            if (f0 != null) {
                f0.bindNativeView(this.e, a2, biddingIntermediateMaterialBean);
            }
        }
        l1(false);
        ViewGroup g02 = g0();
        if (g02 != null) {
            g02.setVisibility(0);
        }
        I(str);
        V0();
    }

    private final int T(String str) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        int hashCode = str.hashCode();
        if (hashCode != -172473003) {
            if (hashCode != -73588874) {
                if (hashCode == 2049503279 && str.equals("VideoEndBidScene")) {
                    JsonObject b2 = com.transsion.ad.scene.d.a.b("VideoEndBidScene");
                    if (b2 == null || (jsonElement3 = b2.get("videoEndAdCountdownTime")) == null) {
                        return 10;
                    }
                    return jsonElement3.getAsInt();
                }
            } else if (str.equals("VideoStartBidScene")) {
                JsonObject b3 = com.transsion.ad.scene.d.a.b("VideoStartBidScene");
                if (b3 == null || (jsonElement2 = b3.get("videoStartAdCountdownTime")) == null) {
                    return 10;
                }
                return jsonElement2.getAsInt();
            }
        } else if (str.equals("VideoInterpolateBidScene")) {
            JsonObject b4 = com.transsion.ad.scene.d.a.b("VideoInterpolateBidScene");
            if (b4 == null || (jsonElement = b4.get("videoInterpolateAdCountdownTime")) == null) {
                return 10;
            }
            return jsonElement.getAsInt();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.H(false);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.H(false);
        return Unit.a;
    }

    private final boolean W0() {
        return this.n < q0();
    }

    private final void W1(String str, Function0 function0, Function0 function02) {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.i.d(lifecycleCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseVideoAdHelper$showSceneAd$1(str, this, function0, function02, null), 3, (Object) null);
        }
    }

    private final int X(String str) {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b(str);
        if (b2 == null || (jsonElement = b2.get("bubbleFrequency")) == null) {
            return 3;
        }
        return jsonElement.getAsInt();
    }

    static /* synthetic */ void X1(BaseVideoAdHelper baseVideoAdHelper, String str, Function0 function0, Function0 function02, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSceneAd");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        baseVideoAdHelper.W1(str, function0, function02);
    }

    private final void Y0(final Function0 function0, final Function0 function02) {
        W1("VideoInterpolateBidScene", new Function0() { // from class: com.transsion.postdetail.ad.m
            public final Object invoke() {
                Unit Z0;
                Z0 = BaseVideoAdHelper.Z0(function0);
                return Z0;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ad.n
            public final Object invoke() {
                Unit a1;
                a1 = BaseVideoAdHelper.a1(BaseVideoAdHelper.this, function02);
                return a1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Function0 function0) {
        function0.invoke();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z1() {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a0(long j) {
        return j + "s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(BaseVideoAdHelper baseVideoAdHelper, Function0 function0) {
        baseVideoAdHelper.H(false);
        function0.invoke();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a2(BaseVideoAdHelper baseVideoAdHelper) {
        Function1 function1 = baseVideoAdHelper.c;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        baseVideoAdHelper.f1();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        Context context;
        if (this.h) {
            return;
        }
        H(true);
        this.k = true;
        NativeWrapperAdView f0 = f0();
        if (f0 != null && (context = f0.getContext()) != null) {
            ow.b bVar = ow.b.a;
            BiddingNativeManager biddingNativeManager = this.e;
            com.transsion.ad.bidding.base.r a2 = bVar.a(context, biddingNativeManager != null ? biddingNativeManager.getSceneId() : null);
            NativeWrapperAdView V = V();
            if (V != null) {
                V.bindNativeView(this.e, a2, biddingIntermediateMaterialBean);
            }
        }
        l1(true);
        ViewGroup h0 = h0();
        if (h0 != null) {
            h0.setVisibility(0);
        }
        ImageView t0 = t0();
        if (t0 != null) {
            t0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ad.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseVideoAdHelper.c2(BaseVideoAdHelper.this, view);
                }
            });
        }
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(BaseVideoAdHelper baseVideoAdHelper, View view) {
        baseVideoAdHelper.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(String str, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        this.g = str;
        LifecycleCoroutineScope lifecycleCoroutineScope = this.a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.i.d(lifecycleCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseVideoAdHelper$onAdLoad$1(str, this, biddingIntermediateMaterialBean, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e2(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.H(false);
        baseVideoAdHelper.f1();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1() {
        Function0 function0 = this.d;
        if (function0 != null) {
            function0.invoke();
        }
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(String str) {
        Object obj;
        if (str == null || !this.h) {
            return;
        }
        if ((Intrinsics.c(str, "VideoStartBidScene") || Intrinsics.c(str, "VideoInterpolateBidScene")) && this.K < i0()) {
            try {
                Result.Companion companion = Result.Companion;
                f4.a aVar = this.M;
                Unit unit = null;
                if (aVar != null) {
                    ConstraintLayout root = aVar.getRoot();
                    ConstraintLayout constraintLayout = root instanceof ConstraintLayout ? root : null;
                    if (constraintLayout == null) {
                        return;
                    }
                    Context context = GslbSdk.context;
                    Intrinsics.g(context, "context");
                    VideoFloatingView videoFloatingView = new VideoFloatingView(context, null, 2, null);
                    this.N = videoFloatingView;
                    videoFloatingView.show(this.a, constraintLayout, new Function0() { // from class: com.transsion.postdetail.ad.p
                        public final Object invoke() {
                            Unit g2;
                            g2 = BaseVideoAdHelper.g2(BaseVideoAdHelper.this);
                            return g2;
                        }
                    });
                    unit = Unit.a;
                }
                obj = Result.constructor-impl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            Result.box-impl(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1() {
        this.v = 0L;
        this.w = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g2(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.K++;
        com.transsion.baselib.report.launch.b.a.b().putInt(baseVideoAdHelper.A, baseVideoAdHelper.K);
        return Unit.a;
    }

    private final void h2() {
        NativeWrapperAdView f0 = f0();
        BubbleTextView bubbleTextView = f0 != null ? (BubbleTextView) f0.findViewById(R.id.bubble_tip) : null;
        this.B = bubbleTextView;
        if (bubbleTextView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bubbleTextView, "translationY", -35.0f, 15.0f, -35.0f);
            ofFloat.setDuration(900L);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat);
            animatorSet.start();
            uf.c.k(bubbleTextView);
            this.C = animatorSet;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private final void i1() {
        NativeWrapperAdView f0 = f0();
        CardView findViewById = f0 != null ? f0.findViewById(R.id.adChoicesViewCard) : null;
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar != null) {
                int a2 = a0.a(this.h ? 16.0f : 12.0f);
                ((ViewGroup.MarginLayoutParams) bVar).leftMargin = a2;
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = a2;
            }
            View childAt = findViewById.getChildAt(0);
            TAdChoicesView tAdChoicesView = childAt instanceof TAdChoicesView ? (TAdChoicesView) childAt : null;
            ImageView childAt2 = tAdChoicesView != null ? tAdChoicesView.getChildAt(0) : null;
            if (childAt2 == null) {
                k1();
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
            int a3 = a0.a(this.h ? 26.0f : 22.0f);
            layoutParams2.width = a3;
            layoutParams2.height = a3;
            ImageView imageView = childAt2 instanceof ImageView ? childAt2 : null;
            if (imageView != null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            k1();
        }
    }

    private final void i2() {
        wn.d bind;
        TextView textView;
        wn.d bind2;
        TextView textView2;
        if (this.s) {
            this.o = false;
            return;
        }
        R();
        long p0 = p0();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = p0 / 1000;
        AdInterceptTimerView e0 = e0();
        if (e0 != null) {
            uf.c.k(e0);
        }
        AdInterceptTimerView e02 = e0();
        if (e02 != null && (bind2 = e02.getBind()) != null && (textView2 = bind2.d) != null) {
            textView2.setText(a0(longRef.element));
        }
        AdInterceptTimerView e03 = e0();
        if (e03 != null && (bind = e03.getBind()) != null && (textView = bind.f) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ad.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseVideoAdHelper.j2(BaseVideoAdHelper.this, view);
                }
            });
        }
        d dVar = new d(p0, this, longRef);
        this.u = dVar;
        dVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(BaseVideoAdHelper baseVideoAdHelper, View view) {
        M(baseVideoAdHelper, false, null, 2, null);
    }

    private final void k1() {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        AdCountDownView W = W();
        if (W != null) {
            ViewGroup.LayoutParams layoutParams = W.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                int a2 = a0.a(this.h ? 16.0f : 12.0f);
                layoutParams2.topMargin = a2;
                layoutParams2.rightMargin = a2;
            }
            float f = this.h ? 14.0f : 12.0f;
            l0 bind = W.getBind();
            if (bind != null && (textView2 = bind.d) != null) {
                textView2.getLayoutParams().height = a0.a(this.h ? 28.0f : 24.0f);
                textView2.setTextSize(f);
            }
            l0 bind2 = W.getBind();
            if (bind2 != null && (textView = bind2.e) != null) {
                textView.setTextSize(f);
            }
            l0 bind3 = W.getBind();
            if (bind3 == null || (imageView = bind3.b) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            int a3 = a0.a(this.h ? 18.0f : 15.0f);
            layoutParams3.width = a3;
            layoutParams3.height = a3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2() {
        AnimatorSet animatorSet = this.C;
        if (animatorSet != null && animatorSet.isRunning()) {
            animatorSet.cancel();
        }
        BubbleTextView bubbleTextView = this.B;
        if (bubbleTextView != null) {
            uf.c.g(bubbleTextView);
        }
        this.C = null;
    }

    private final void m1() {
        NativeWrapperAdView f0 = f0();
        BubbleTextView bubbleTextView = f0 != null ? (BubbleTextView) f0.findViewById(R.id.bubble_tip) : null;
        this.B = bubbleTextView;
        if (bubbleTextView != null) {
            bubbleTextView.setTextSize(this.h ? 16.0f : 12.0f);
            bubbleTextView.setArrowPosition(a0.a(this.h ? 110.0f : 90.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.transsion.postdetail.ad.BaseVideoAdHelper$wrapperAdListener$1] */
    public final BaseVideoAdHelper$wrapperAdListener$1 m2(final String str, final Function0 function0, final Function0 function02) {
        return new oh.a() { // from class: com.transsion.postdetail.ad.BaseVideoAdHelper$wrapperAdListener$1
            public void i(TAdErrorCode tAdErrorCode) {
                LifecycleCoroutineScope w0 = BaseVideoAdHelper.this.w0();
                if (w0 != null) {
                    kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new BaseVideoAdHelper$wrapperAdListener$1$onBiddingError$1(function02, null), 3, (Object) null);
                }
            }

            public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                LifecycleCoroutineScope w0 = BaseVideoAdHelper.this.w0();
                if (w0 != null) {
                    kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new BaseVideoAdHelper$wrapperAdListener$1$onBiddingLoad$1(function0, BaseVideoAdHelper.this, str, biddingIntermediateMaterialBean, null), 3, (Object) null);
                }
            }

            public void l(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                String str2;
                super.l(biddingIntermediateMaterialBean);
                BaseVideoAdHelper.this.P();
                BaseVideoAdHelper baseVideoAdHelper = BaseVideoAdHelper.this;
                str2 = baseVideoAdHelper.O;
                baseVideoAdHelper.f2(str2);
            }

            public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                LifecycleCoroutineScope w0 = BaseVideoAdHelper.this.w0();
                if (w0 != null) {
                    kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new BaseVideoAdHelper$wrapperAdListener$1$onBiddingWrapperAdClose$1(BaseVideoAdHelper.this, null), 3, (Object) null);
                }
            }

            public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                super.p(biddingIntermediateMaterialBean);
                LifecycleCoroutineScope w0 = BaseVideoAdHelper.this.w0();
                if (w0 != null) {
                    kotlinx.coroutines.i.d(w0, (CoroutineContext) null, (CoroutineStart) null, new BaseVideoAdHelper$wrapperAdListener$1$onBiddingWrapperAdShowError$1(function02, null), 3, (Object) null);
                }
            }
        };
    }

    private final void p1() {
        AdInterceptTimerView e0 = e0();
        if (e0 != null) {
            ConstraintLayout.b layoutParams = e0.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? layoutParams : null;
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = a0.a(this.h ? 16.0f : 12.0f);
            }
            int childCount = e0.getChildCount();
            for (int i = 0; i < childCount; i++) {
                AppCompatTextView childAt = e0.getChildAt(i);
                if (childAt instanceof AppCompatTextView) {
                    childAt.setTextSize(this.h ? 14.0f : 12.0f);
                }
            }
        }
    }

    private final void q1() {
        View k0 = k0();
        if (k0 != null) {
            ConstraintLayout.b layoutParams = k0.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? layoutParams : null;
            if (bVar != null) {
                int i = -1;
                ((ViewGroup.MarginLayoutParams) bVar).width = -1;
                if (!this.h) {
                    ViewGroup C0 = C0();
                    i = C0 != null ? C0.getHeight() : (int) ((((ViewGroup.MarginLayoutParams) bVar).width * 9.0d) / 16);
                }
                ((ViewGroup.MarginLayoutParams) bVar).height = i;
            }
        }
    }

    private final void r1() {
        BiddingNativeManager biddingNativeManager = this.e;
        if (biddingNativeManager == null || biddingNativeManager.R0()) {
            NativeWrapperAdView f0 = f0();
            final TMediaView findViewById = f0 != null ? f0.findViewById(R.id.native_ad_media) : null;
            if (findViewById != null) {
                findViewById.post(new Runnable() { // from class: com.transsion.postdetail.ad.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseVideoAdHelper.s1(findViewById, this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(TMediaView tMediaView, BaseVideoAdHelper baseVideoAdHelper) {
        ViewGroup.LayoutParams layoutParams;
        ConstraintLayout.b layoutParams2 = tMediaView.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams2 instanceof ConstraintLayout.b ? layoutParams2 : null;
        if (bVar != null) {
            if (baseVideoAdHelper.h) {
                ((ViewGroup.MarginLayoutParams) bVar).height = -1;
                bVar.I = null;
            } else {
                ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                bVar.I = "H,16:9";
            }
        }
        View mediaView = tMediaView.getMediaView();
        if (mediaView != null) {
            mediaView.getLayoutParams().height = -1;
            mediaView.requestLayout();
            if (mediaView instanceof ViewGroup) {
                View childAt = ((ViewGroup) mediaView).getChildAt(0);
                if (childAt != null && (layoutParams = childAt.getLayoutParams()) != null) {
                    layoutParams.height = -1;
                }
                if (childAt != null) {
                    childAt.requestLayout();
                }
            }
        }
    }

    private final void w1() {
        ViewGroup g0 = g0();
        if (g0 != null) {
            ViewGroup.LayoutParams layoutParams = g0.getLayoutParams();
            int i = -1;
            layoutParams.width = -1;
            if (!this.h) {
                ViewGroup C0 = C0();
                i = C0 != null ? C0.getHeight() : (int) ((layoutParams.width * 9.0d) / 16);
            }
            layoutParams.height = i;
        }
    }

    private final void x1() {
        NativeWrapperAdView f0 = f0();
        AppCompatTextView findViewById = f0 != null ? f0.findViewById(R.id.native_ad_action) : null;
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).height = a0.a(this.h ? 44.0f : 28.0f);
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = a0.a(this.h ? 73.0f : 52.0f);
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = a0.a(this.h ? 16.0f : 10.0f);
            }
            findViewById.setTextSize(this.h ? 16.0f : 12.0f);
            int a2 = a0.a(this.h ? 16.0f : 6.0f);
            findViewById.setPadding(a2, 3, a2, 4);
        }
    }

    protected final void A1(boolean z) {
        this.h = z;
    }

    protected final long B0() {
        return this.w;
    }

    protected abstract ViewGroup C0();

    protected final void C1(boolean z) {
        this.k = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D0(long j, long j2) {
        this.i = R0(A0(), j);
        this.j = R0(c0(), j2);
    }

    protected final void D1(long j) {
        this.v = j;
    }

    protected final void E0(f4.a aVar, String str, Function1 function1) {
        View root;
        this.M = aVar;
        Context context = (aVar == null || (root = aVar.getRoot()) == null) ? null : root.getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        this.a = appCompatActivity != null ? androidx.lifecycle.v.a(appCompatActivity) : null;
        this.b = str;
        this.c = function1;
        G0();
    }

    protected final void E1(int i) {
        this.p = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F0(String str) {
        Intrinsics.h(str, "scene");
        if (!X0(str, true)) {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
            this.E = bVar.b().getInt(this.z, 0);
            this.D = bVar.b().getInt(this.y, 0);
            this.K = bVar.b().getInt(this.A, 0);
            return;
        }
        this.E = 0;
        com.transsion.baselib.report.launch.b bVar2 = com.transsion.baselib.report.launch.b.a;
        bVar2.b().putInt(this.z, 0);
        this.D = 0;
        bVar2.b().putInt(this.y, 0);
        this.K = 0;
        bVar2.b().putInt(this.A, 0);
    }

    protected final void F1(boolean z) {
        this.s = z;
    }

    public void H(boolean z) {
        Function1 function1 = this.c;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        this.q = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void H1(boolean z) {
        this.j = z;
    }

    protected final void I(String str) {
        Intrinsics.h(str, "sceneId");
        Ref.IntRef intRef = new Ref.IntRef();
        int i = this.p;
        if (i == 0) {
            i = T(str);
        }
        intRef.element = i;
        AdCountDownView W = W();
        if (W != null) {
            W.refreshCountDown(intRef.element);
        }
        Q();
        b bVar = new b(intRef, str, intRef.element * 1000);
        this.t = bVar;
        bVar.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I1(boolean z) {
        this.i = z;
    }

    protected final void J1(long j) {
        this.w = j;
    }

    protected final void L(boolean z, Function0 function0) {
        wj.d dVar;
        if (!z && (dVar = (wj.d) TheRouter.d(wj.d.class, new Object[0])) != null) {
            dVar.h();
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            b$a.c(bVar, com.blankj.utilcode.util.a.b(), MemberSource.SOURCE_LANDSCAPE_PLAY, new c(function0), false, null, 24, null);
        }
    }

    public final String L0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "sceneId is empty";
        }
        com.transsion.ad.scene.c cVar = com.transsion.ad.scene.c.a;
        return cVar.d(str) ? "当前是会员,不展示广告" : !com.transsion.ad.scene.b.a.k() ? "全局场景关闭" : cVar.c(str) ? "场景关闭" : com.transsion.ad.scene.d.a.b(str) == null ? "场景配置为空" : BuildConfig.FLAVOR;
    }

    protected final void L1(String str) {
        NativeWrapperAdView f0;
        NativeWrapperAdView f02;
        if (Intrinsics.c(str, "VideoStartBidScene")) {
            if (this.D < Z() && (f02 = f0()) != null) {
                f02.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ad.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseVideoAdHelper.M1(BaseVideoAdHelper.this);
                    }
                }, 2000L);
                return;
            }
            return;
        }
        if (!Intrinsics.c(str, "VideoInterpolateBidScene") || this.E >= Y() || (f0 = f0()) == null) {
            return;
        }
        f0.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ad.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseVideoAdHelper.N1(BaseVideoAdHelper.this);
            }
        }, 2000L);
    }

    protected final boolean M0() {
        return this.q;
    }

    public final void N(long j, Function0 function0) {
        Intrinsics.h(function0, "callback");
        if (this.x == 0) {
            this.x = j;
            return;
        }
        if (this.s || this.q || !W0()) {
            return;
        }
        if (Math.abs(j - this.x) > 5000) {
            this.x = j;
            this.v += System.currentTimeMillis() - this.w;
            this.w = System.currentTimeMillis();
        }
        if (this.v >= o0()) {
            this.d = function0;
            O1();
        }
    }

    protected final boolean N0() {
        return this.o;
    }

    protected final void O() {
        if (TextUtils.equals(this.g, "LandscapePauseSceneNew") || TextUtils.equals(this.g, "VerticalPauseScene")) {
            P();
        }
    }

    protected final boolean O0() {
        return this.m;
    }

    protected final void P() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.i.d(lifecycleCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseVideoAdHelper$closeSceneAd$1(this, null), 3, (Object) null);
        }
    }

    protected final boolean P0() {
        return this.r;
    }

    protected final void Q() {
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.t = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Q0() {
        return this.h;
    }

    protected final void R() {
        CountDownTimer countDownTimer = this.u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.u = null;
        AdInterceptTimerView e0 = e0();
        if (e0 != null) {
            uf.c.g(e0);
        }
    }

    public final boolean S0() {
        return !cw.e.a.b().k();
    }

    protected final boolean T0() {
        return this.k;
    }

    protected final void T1() {
        if (this.h) {
            X1(this, "LandscapePauseSceneNew", null, new Function0() { // from class: com.transsion.postdetail.ad.a
                public final Object invoke() {
                    Unit V1;
                    V1 = BaseVideoAdHelper.V1(BaseVideoAdHelper.this);
                    return V1;
                }
            }, 2, null);
        } else {
            X1(this, "VerticalPauseScene", null, new Function0() { // from class: com.transsion.postdetail.ad.l
                public final Object invoke() {
                    Unit U1;
                    U1 = BaseVideoAdHelper.U1(BaseVideoAdHelper.this);
                    return U1;
                }
            }, 2, null);
        }
    }

    protected final int U() {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("VideoEndBidScene");
        return ((b2 == null || (jsonElement = b2.get("threshold")) == null) ? 5 : jsonElement.getAsInt()) * 60000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean U0() {
        return this.s;
    }

    protected abstract NativeWrapperAdView V();

    protected final void V0() {
        if (this.h) {
            ImageView z0 = z0();
            if (z0 != null) {
                z0.setImageResource(com.transsion.baseui.R.mipmap.ad_rotate);
                return;
            }
            return;
        }
        ImageView z02 = z0();
        if (z02 != null) {
            z02.setImageResource(com.transsion.baseui.R.mipmap.ad_fullscreen);
        }
    }

    protected abstract AdCountDownView W();

    public final boolean X0(String str, boolean z) {
        Intrinsics.h(str, "scene");
        String str2 = "zero_clock_timestamp_" + str;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        long j = bVar.b().getLong(str2, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = currentTimeMillis - j >= 86400000;
        if (z && z2) {
            bVar.b().putLong(str2, k0.c(currentTimeMillis));
        }
        return z2;
    }

    protected final int Y() {
        return ((Number) this.G.getValue()).intValue();
    }

    public final void Y1(Function0 function0) {
        Intrinsics.h(function0, "callback");
        this.d = function0;
        if (this.i && S0()) {
            W1("VideoStartBidScene", new Function0() { // from class: com.transsion.postdetail.ad.i
                public final Object invoke() {
                    Unit Z1;
                    Z1 = BaseVideoAdHelper.Z1();
                    return Z1;
                }
            }, new Function0() { // from class: com.transsion.postdetail.ad.j
                public final Object invoke() {
                    Unit a2;
                    a2 = BaseVideoAdHelper.a2(BaseVideoAdHelper.this);
                    return a2;
                }
            });
        } else {
            f1();
        }
    }

    protected final int Z() {
        return ((Number) this.F.getValue()).intValue();
    }

    protected final String b0() {
        return this.g;
    }

    protected final void b1(String str, Function0 function0, Function0 function02) {
        Context context;
        Intrinsics.h(str, "sceneId");
        ViewGroup h0 = h0();
        if (h0 == null || (context = h0.getContext()) == null) {
            return;
        }
        BiddingInterstitialManager biddingInterstitialManager = this.f;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.U();
        }
        this.f = null;
        LifecycleCoroutineScope lifecycleCoroutineScope = this.a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.i.d(lifecycleCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseVideoAdHelper$loadLandPauseAd$1(context, this, str, function0, function02, null), 3, (Object) null);
        }
    }

    protected final int c0() {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("VideoEndBidScene");
        return ((b2 == null || (jsonElement = b2.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    protected final void c1(String str, Function0 function0, Function0 function02) {
        Context context;
        Intrinsics.h(str, "sceneId");
        ViewGroup g0 = g0();
        if (g0 == null || (context = g0.getContext()) == null) {
            return;
        }
        BiddingNativeManager biddingNativeManager = this.e;
        if (biddingNativeManager != null) {
            biddingNativeManager.U();
        }
        this.e = null;
        LifecycleCoroutineScope lifecycleCoroutineScope = this.a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.i.d(lifecycleCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseVideoAdHelper$loadNativeAd$1(context, this, str, function0, function02, null), 3, (Object) null);
        }
    }

    protected final CountDownTimer d0() {
        return this.u;
    }

    protected final void d2(Function0 function0) {
        Intrinsics.h(function0, "callback");
        boolean z = System.currentTimeMillis() - this.l > ((long) U());
        if (this.j && z && S0()) {
            W1("VideoEndBidScene", function0, new Function0() { // from class: com.transsion.postdetail.ad.f
                public final Object invoke() {
                    Unit e2;
                    e2 = BaseVideoAdHelper.e2(BaseVideoAdHelper.this);
                    return e2;
                }
            });
        } else {
            f1();
        }
    }

    protected abstract AdInterceptTimerView e0();

    public final void e1() {
        if (this.h) {
            BiddingInterstitialManager.t.a("LandscapePauseSceneNew", com.transsion.ad.strategy.c.a.a(this.b));
            return;
        }
        VideoFloatingView videoFloatingView = this.N;
        if (videoFloatingView != null) {
            videoFloatingView.hide();
        }
    }

    protected abstract NativeWrapperAdView f0();

    protected abstract ViewGroup g0();

    protected abstract ViewGroup h0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h1() {
        this.x = 0L;
        this.l = 0L;
        this.v = 0L;
        this.n = 0;
    }

    protected final int i0() {
        return ((Number) this.L.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String j0() {
        return this.b;
    }

    protected final void j1(Function0 function0) {
        this.d = function0;
    }

    protected abstract View k0();

    protected final int l0() {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("VideoInterpolateBidScene");
        return ((b2 == null || (jsonElement = b2.get("enterCountdown")) == null) ? 10 : jsonElement.getAsInt()) * 1000;
    }

    protected final void l1(boolean z) {
        try {
            Result.Companion companion = Result.Companion;
            if (z) {
                q1();
                B1();
                K1(V(), true);
            } else {
                w1();
                r1();
                p1();
                x1();
                G1();
                K1(f0(), false);
                i1();
                m1();
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public abstract void l2();

    protected final int m0() {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("VideoInterpolateBidScene");
        if (b2 == null || (jsonElement = b2.get("frequency")) == null) {
            return 2;
        }
        return jsonElement.getAsInt();
    }

    protected final int n0() {
        JsonElement jsonElement;
        JsonObject b2 = com.transsion.ad.scene.d.a.b("VideoInterpolateBidScene");
        return ((b2 == null || (jsonElement = b2.get("interval")) == null) ? 15 : jsonElement.getAsInt()) * 60000;
    }

    protected final void n1(CountDownTimer countDownTimer) {
        this.u = countDownTimer;
    }

    public final int o0() {
        return r0() - p0();
    }

    protected final void o1(boolean z) {
        this.o = z;
    }

    protected final int p0() {
        return ((Number) this.I.getValue()).intValue();
    }

    protected final int q0() {
        return ((Number) this.J.getValue()).intValue();
    }

    protected final int r0() {
        return ((Number) this.H.getValue()).intValue();
    }

    protected final int s0() {
        return this.n;
    }

    protected abstract ImageView t0();

    protected final void t1(int i) {
        this.n = i;
    }

    protected final BiddingNativeManager u0() {
        return this.e;
    }

    protected final void u1(BiddingNativeManager biddingNativeManager) {
        this.e = biddingNativeManager;
    }

    protected final BiddingInterstitialManager v0() {
        return this.f;
    }

    protected final void v1(boolean z) {
        this.m = z;
    }

    protected final LifecycleCoroutineScope w0() {
        return this.a;
    }

    protected final long x0() {
        return this.v;
    }

    protected final int y0() {
        return this.p;
    }

    protected final void y1(BiddingInterstitialManager biddingInterstitialManager) {
        this.f = biddingInterstitialManager;
    }

    protected abstract ImageView z0();

    protected final void z1(boolean z) {
        this.r = z;
    }
}
