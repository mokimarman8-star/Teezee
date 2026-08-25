package com.transsion.shorttv.ad.playeroverlayad;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.shorttv.ad.common.STCommonNativeAdHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private final String a;
    private final n0 b;
    private final STCommonNativeAdHelper c;
    private ShortTvPlayerOverlayAdContainer d;
    private g7.e e;
    private Long f;
    private long g;

    public static final class a extends g7.e {
        final /* synthetic */ ShortTvPlayerOverlayAdContainer g;
        final /* synthetic */ Function0 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer, Function0 function0, long j) {
            super(j, 1000L);
            this.g = shortTvPlayerOverlayAdContainer;
            this.h = function0;
        }

        public void e() {
            e.this.o(this.h);
        }

        public void f(long j) {
            long ceil = (long) Math.ceil(j / 1000.0f);
            e.this.f = Long.valueOf(ceil);
            TextView countdownView = this.g.getCountdownView();
            if (countdownView != null) {
                countdownView.setText(ceil + "s");
            }
        }
    }

    public e(String str, n0 n0Var) {
        Intrinsics.h(str, "sceneId");
        Intrinsics.h(n0Var, "lifecycleScope");
        this.a = str;
        this.b = n0Var;
        STCommonNativeAdHelper sTCommonNativeAdHelper = new STCommonNativeAdHelper(str, n0Var);
        sTCommonNativeAdHelper.r("overlay");
        this.c = sTCommonNativeAdHelper;
    }

    private final void g() {
        g7.e eVar = this.e;
        if (eVar != null) {
            eVar.d();
        }
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e eVar, Function0 function0, View view) {
        eVar.o(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer, final e eVar) {
        NativeWrapperAdView nativeAdView = shortTvPlayerOverlayAdContainer.getNativeAdView();
        if (nativeAdView != null) {
            STCommonNativeAdHelper sTCommonNativeAdHelper = eVar.c;
            Context a2 = com.cloud.sdk.commonutil.util.e.a();
            Intrinsics.g(a2, "getContext(...)");
            sTCommonNativeAdHelper.s(new f(a2), nativeAdView, new Function1() { // from class: com.transsion.shorttv.ad.playeroverlayad.d
                public final Object invoke(Object obj) {
                    Unit n;
                    n = e.n(e.this, ((Boolean) obj).booleanValue());
                    return n;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(e eVar, boolean z) {
        if (z) {
            eVar.g = System.currentTimeMillis();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(Function0 function0) {
        f();
        function0.invoke();
    }

    public final void f() {
        STCommonNativeAdHelper.n(this.c, 0, 1, null);
        g();
        this.f = null;
        ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer = this.d;
        if (shortTvPlayerOverlayAdContainer != null) {
            shortTvPlayerOverlayAdContainer.removeAdView();
        }
        ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer2 = this.d;
        if (shortTvPlayerOverlayAdContainer2 != null) {
            shortTvPlayerOverlayAdContainer2.setVisibility(8);
        }
        this.d = null;
        this.g = 0L;
    }

    public final long h() {
        return this.g;
    }

    public final void i(Function1 function1) {
        Intrinsics.h(function1, "callback");
        this.c.q(function1);
    }

    public final void j() {
        g();
        ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer = this.d;
        if (shortTvPlayerOverlayAdContainer != null) {
            shortTvPlayerOverlayAdContainer.removeAdView();
        }
        ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer2 = this.d;
        if (shortTvPlayerOverlayAdContainer2 != null) {
            shortTvPlayerOverlayAdContainer2.setVisibility(8);
        }
    }

    public final void k(final ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer, final Function0 function0) {
        Intrinsics.h(shortTvPlayerOverlayAdContainer, "adContainerView");
        Intrinsics.h(function0, "timerEndCallback");
        shortTvPlayerOverlayAdContainer.setVisibility(0);
        shortTvPlayerOverlayAdContainer.bringToFront();
        ImageView closeView = shortTvPlayerOverlayAdContainer.getCloseView();
        if (closeView != null) {
            closeView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ad.playeroverlayad.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.l(e.this, function0, view);
                }
            });
        }
        shortTvPlayerOverlayAdContainer.addAdView();
        shortTvPlayerOverlayAdContainer.post(new Runnable() { // from class: com.transsion.shorttv.ad.playeroverlayad.c
            @Override // java.lang.Runnable
            public final void run() {
                e.m(ShortTvPlayerOverlayAdContainer.this, this);
            }
        });
        this.d = shortTvPlayerOverlayAdContainer;
        g();
        Long l = this.f;
        if (l == null) {
            l = Long.valueOf(com.transsion.ad.scene.a.a.e("ShortTvPlayerOverlayScene"));
            if (l.longValue() <= 0) {
                l = null;
            }
            if (l == null) {
                TextView countdownView = shortTvPlayerOverlayAdContainer.getCountdownView();
                if (countdownView != null) {
                    countdownView.setVisibility(8);
                    return;
                }
                return;
            }
        }
        long longValue = l.longValue();
        TextView countdownView2 = shortTvPlayerOverlayAdContainer.getCountdownView();
        if (countdownView2 != null) {
            countdownView2.setVisibility(0);
        }
        a aVar = new a(shortTvPlayerOverlayAdContainer, function0, longValue * 1000);
        this.e = aVar;
        aVar.g();
    }
}
