package com.transsion.moviedetail.preload;

import androidx.lifecycle.b0;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends am.b {
    private String f;
    private Integer g;
    private boolean h;
    private final Lazy i;

    public static final class a extends dg.a {
        a() {
        }

        public void a(String str, String str2) {
            b.this.c(new Pair(str, (Object) null));
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(Subject subject) {
            if (subject != null) {
                subject.setRefreshViewOnly(b.this.m());
            }
            b.this.d(new Pair("0", subject));
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            Intrinsics.h(cVar, "d");
            super.onSubscribe(cVar);
            b.this.i(cVar);
        }
    }

    public b(String str, Integer num, boolean z) {
        Intrinsics.h(str, "subjectId");
        this.f = str;
        this.g = num;
        this.h = z;
        this.i = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.moviedetail.preload.a
            public final Object invoke() {
                om.a n;
                n = b.n();
                return n;
            }
        });
    }

    public /* synthetic */ b(String str, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z);
    }

    private final om.a l() {
        return (om.a) this.i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final om.a n() {
        return (om.a) kg.c.e.a().h(om.a.class);
    }

    @Override // am.b
    public void h(b0 b0Var) {
        l().g(gg.a.a.a(), this.f, this.g).f(dg.d.a.c()).subscribe(new a());
    }

    public final boolean m() {
        return this.h;
    }

    public final void o(boolean z) {
        this.h = z;
    }

    public final void p(Integer num) {
        this.g = num;
    }

    public final void q(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f = str;
    }
}
