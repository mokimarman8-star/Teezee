package com.transsion.player.longvideo.helper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.transsion.mb.config.manager.ConfigBean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u {
    public static final a l = new a(null);
    private final mn.j a;
    private final Function0 b;
    private b c;
    private mn.e d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final Handler h;
    private final Handler i;
    private final Handler j;
    private final Lazy k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u(mn.j jVar, Function0 function0) {
        String value;
        Object obj;
        Intrinsics.h(jVar, "viewBinding");
        Intrinsics.h(function0, "continuePlaCallback");
        this.a = jVar;
        this.b = function0;
        this.h = new Handler(Looper.getMainLooper());
        this.i = new Handler(Looper.getMainLooper());
        this.j = new Handler(Looper.getMainLooper());
        this.k = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.helper.o
            public final Object invoke() {
                long A;
                A = u.A();
                return Long.valueOf(A);
            }
        });
        ConfigBean d = cm.f.d(cm.f.c.a(), "sa_data_operator_config", false, 2, (Object) null);
        if (d != null && (value = d.getValue()) != null) {
            try {
                Result.Companion companion = Result.Companion;
                this.c = (b) com.blankj.utilcode.util.o.d(value, b.class);
                obj = Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.a(th2));
            }
            Result.box-impl(obj);
        }
        b bVar = this.c;
        if (bVar != null) {
            mn.f fVar = this.a.o.s;
            fVar.e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.y(u.this, view);
                }
            });
            fVar.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.z(u.this, view);
                }
            });
            String l2 = bVar.l();
            if (l2 != null) {
                fVar.g.setText(l2);
            }
            String k = bVar.k();
            if (k != null) {
                fVar.f.setText(k);
            }
            CharSequence a2 = bVar.a();
            if (a2 != null) {
                fVar.d.setText(a2);
            }
            String b = bVar.b();
            if (b != null) {
                f.a aVar = ni.f.a;
                Context context = fVar.b.getContext();
                Intrinsics.g(context, "getContext(...)");
                f.b c = aVar.m(context).g(b).m(lj.a.b(16)).c(lj.a.b(16));
                AppCompatImageView appCompatImageView = fVar.b;
                Intrinsics.g(appCompatImageView, "ivMore");
                c.d(appCompatImageView);
            }
            mn.f fVar2 = this.a.p.m;
            fVar2.e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.w(u.this, view);
                }
            });
            fVar2.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.x(u.this, view);
                }
            });
            String l3 = bVar.l();
            if (l3 != null) {
                fVar2.g.setText(l3);
            }
            String k2 = bVar.k();
            if (k2 != null) {
                fVar2.f.setText(k2);
            }
            CharSequence a3 = bVar.a();
            if (a3 != null) {
                fVar2.d.setText(a3);
            }
            String b2 = bVar.b();
            if (b2 != null) {
                f.a aVar2 = ni.f.a;
                Context context2 = fVar2.b.getContext();
                Intrinsics.g(context2, "getContext(...)");
                f.b c2 = aVar2.m(context2).g(b2).m(lj.a.b(16)).c(lj.a.b(16));
                AppCompatImageView appCompatImageView2 = fVar2.b;
                Intrinsics.g(appCompatImageView2, "ivMore");
                c2.d(appCompatImageView2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A() {
        String value;
        Long x;
        ConfigBean d = cm.f.d(cm.f.c.a(), "sa_data_switch", false, 2, (Object) null);
        if (d == null || (value = d.getValue()) == null || (x = StringsKt.x(value)) == null) {
            return 720L;
        }
        return x.longValue();
    }

    private final void B() {
        String h;
        t();
        a.a aVar = wf.a.a;
        b bVar = this.c;
        a.a.f(aVar, "LongVodMobileData", "onOperatorClick link:" + (bVar != null ? bVar.h() : null), false, 4, (Object) null);
        b bVar2 = this.c;
        if (bVar2 != null && (h = bVar2.h()) != null) {
            ij.k.h(h, null, 1, null);
        }
        com.transsion.baselib.report.launch.b.a.b().putLong("key_video_operator_last_open_time", System.currentTimeMillis());
    }

    private final void F(boolean z) {
        try {
            Result.Companion companion = Result.Companion;
            a.a.f(wf.a.a, "LongVodMobileData", "showOperatorLayout", false, 4, (Object) null);
            if (z) {
                BLLinearLayout root = this.a.o.s.getRoot();
                Intrinsics.g(root, "getRoot(...)");
                uf.c.k(root);
            } else {
                BLLinearLayout root2 = this.a.p.m.getRoot();
                Intrinsics.g(root2, "getRoot(...)");
                uf.c.k(root2);
            }
            b bVar = this.c;
            int j = bVar != null ? bVar.j() : 10;
            this.j.removeCallbacksAndMessages(null);
            Result.constructor-impl(Boolean.valueOf(this.j.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.t
                @Override // java.lang.Runnable
                public final void run() {
                    u.G(u.this);
                }
            }, j * 1000)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(u uVar) {
        try {
            Result.Companion companion = Result.Companion;
            uVar.t();
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    private final void k() {
        ConstraintLayout root;
        mn.e eVar = this.d;
        if (eVar != null && (root = eVar.getRoot()) != null && root.getVisibility() == 0) {
            a.a.v(wf.a.a, "LongVodMobileData", "checkFullscreenPageShowOperator, mobile ui show~~", false, 4, (Object) null);
            return;
        }
        if (this.f) {
            a.a.v(wf.a.a, "LongVodMobileData", "checkFullscreenPageShowOperator shown return", false, 4, (Object) null);
            return;
        }
        if (!u()) {
            a.a.v(wf.a.a, "LongVodMobileData", "checkFullscreenPageShowOperator intercept--", false, 4, (Object) null);
            return;
        }
        this.f = true;
        b bVar = this.c;
        int d = bVar != null ? bVar.d() : 3;
        a.a.v(wf.a.a, "LongVodMobileData", "checkFullscreenPageShowOperator delay show:" + d + "s", false, 4, (Object) null);
        this.h.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.l
            @Override // java.lang.Runnable
            public final void run() {
                u.l(u.this);
            }
        }, ((long) d) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(u uVar) {
        uVar.F(true);
    }

    private final void m() {
        if (this.g) {
            return;
        }
        if (this.e) {
            a.a.v(wf.a.a, "LongVodMobileData", "checkMiddlePageShowOperator shown return", false, 4, (Object) null);
            return;
        }
        if (!u()) {
            a.a.v(wf.a.a, "LongVodMobileData", "checkMiddlePageShowOperator config--", false, 4, (Object) null);
            return;
        }
        this.e = true;
        b bVar = this.c;
        int i = bVar != null ? bVar.i() : 3;
        a.a.v(wf.a.a, "LongVodMobileData", "checkMiddlePageShowOperator delay show:" + i + "s", false, 4, (Object) null);
        this.i.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.k
            @Override // java.lang.Runnable
            public final void run() {
                u.n(u.this);
            }
        }, ((long) i) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(u uVar) {
        uVar.F(false);
    }

    private final void o() {
        if (this.g) {
            k();
        } else {
            m();
        }
    }

    private final long p() {
        return ((Number) this.k.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(u uVar, View view) {
        a.a.f(wf.a.a, "LongVodMobileData", "click-- play with mobile data", false, 4, (Object) null);
        nn.a.a.c(true);
        uVar.b.invoke();
        uVar.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(u uVar, View view) {
        a.a.f(wf.a.a, "LongVodMobileData", "click-- page openDeeplink", false, 4, (Object) null);
        uVar.B();
    }

    private final void t() {
        a.a.f(wf.a.a, "LongVodMobileData", "hideOperatorLayout", false, 4, (Object) null);
        BLLinearLayout root = this.a.o.s.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        uf.c.g(root);
        BLLinearLayout root2 = this.a.p.m.getRoot();
        Intrinsics.g(root2, "getRoot(...)");
        uf.c.g(root2);
    }

    private final boolean u() {
        b bVar = this.c;
        if (bVar != null) {
            String h = bVar != null ? bVar.h() : null;
            if (h != null && h.length() != 0) {
                long currentTimeMillis = System.currentTimeMillis() - com.transsion.baselib.report.launch.b.a.b().getLong("key_video_operator_last_open_time", 0L);
                b bVar2 = this.c;
                boolean z = currentTimeMillis >= ((long) ((bVar2 != null ? bVar2.c() : 0) * 3600000));
                wf.a.a.c("LongVodMobileData", "isShowDataOperator time :" + z, true);
                return z;
            }
        }
        a.a.f(wf.a.a, "LongVodMobileData", "isShowDataOperator config is null", false, 4, (Object) null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(u uVar, View view) {
        uVar.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(u uVar, View view) {
        a.a.f(wf.a.a, "LongVodMobileData", "click-- float openDeeplink", false, 4, (Object) null);
        uVar.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(u uVar, View view) {
        uVar.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(u uVar, View view) {
        a.a.f(wf.a.a, "LongVodMobileData", "click-- float openDeeplink", false, 4, (Object) null);
        uVar.B();
    }

    public final void C(boolean z) {
        this.g = z;
        t();
        if (z) {
            this.i.removeCallbacksAndMessages(null);
            a.a.v(wf.a.a, "LongVodMobileData", "onScreenChange enter full", false, 4, (Object) null);
            k();
        } else {
            this.h.removeCallbacksAndMessages(null);
            a.a.v(wf.a.a, "LongVodMobileData", "onScreenChange exit full to middle page", false, 4, (Object) null);
            m();
        }
    }

    public final void D() {
        a.a.f(wf.a.a, "LongVodMobileData", "onVideoStart", false, 4, (Object) null);
        o();
    }

    public final void E() {
        ConstraintLayout root;
        mn.e eVar = this.d;
        if (eVar == null || (root = eVar.getRoot()) == null) {
            return;
        }
        uf.c.g(root);
    }

    public final void q() {
        BLTextView bLTextView;
        BLTextView bLTextView2;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        mn.e eVar;
        AppCompatTextView appCompatTextView3;
        BLTextView bLTextView3;
        AppCompatTextView appCompatTextView4;
        ConstraintLayout root;
        a.a aVar = wf.a.a;
        aVar.c("LongVodMobileData", "onPrepare2PlayVideo, is mobile , pause video. show layout", true);
        if (this.d == null) {
            this.d = mn.e.a(this.a.D.inflate());
        }
        com.transsion.baselib.report.launch.b.a.b().putLong("key_mobile_data_switch_time", System.currentTimeMillis());
        mn.e eVar2 = this.d;
        if (eVar2 != null && (root = eVar2.getRoot()) != null) {
            uf.c.k(root);
        }
        mn.e eVar3 = this.d;
        if (eVar3 != null) {
            if (eVar3 != null && (appCompatTextView4 = eVar3.d) != null) {
                uf.c.g(appCompatTextView4);
            }
            mn.e eVar4 = this.d;
            if (eVar4 != null && (bLTextView3 = eVar4.b) != null) {
                uf.c.g(bLTextView3);
            }
            if (u()) {
                a.a.f(aVar, "LongVodMobileData", "mobile data layout, show operator ui--------", false, 4, (Object) null);
                b bVar = this.c;
                if (bVar != null) {
                    String g = bVar.g();
                    if (g != null && (eVar = this.d) != null && (appCompatTextView3 = eVar.e) != null) {
                        appCompatTextView3.setText(g);
                    }
                    String f = bVar.f();
                    if (f != null) {
                        mn.e eVar5 = this.d;
                        if (eVar5 != null && (appCompatTextView2 = eVar5.d) != null) {
                            appCompatTextView2.setText(f);
                        }
                        mn.e eVar6 = this.d;
                        if (eVar6 != null && (appCompatTextView = eVar6.d) != null) {
                            uf.c.k(appCompatTextView);
                        }
                    }
                    String e = bVar.e();
                    if (e != null) {
                        mn.e eVar7 = this.d;
                        if (eVar7 != null && (bLTextView2 = eVar7.b) != null) {
                            bLTextView2.setText(e);
                        }
                        mn.e eVar8 = this.d;
                        if (eVar8 != null && (bLTextView = eVar8.b) != null) {
                            uf.c.k(bLTextView);
                        }
                    }
                }
            }
            eVar3.c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.r(u.this, view);
                }
            });
            BLTextView bLTextView4 = eVar3.b;
            Intrinsics.g(bLTextView4, "longVdTvOperator");
            bLTextView4.setVisibility(u() ? 0 : 8);
            eVar3.b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.s(u.this, view);
                }
            });
        }
    }

    public final boolean v() {
        long j = 60;
        return System.currentTimeMillis() - com.transsion.baselib.report.launch.b.a.b().getLong("key_mobile_data_switch_time", 0L) >= ((p() * j) * j) * ((long) 1000);
    }
}
