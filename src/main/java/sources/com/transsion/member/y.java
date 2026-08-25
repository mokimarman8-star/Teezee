package com.transsion.member;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.transsion.member.bean.request.MemberPromoCodeReq;
import com.transsion.member.bean.request.MemberPromoCodeRes;
import fm.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y extends androidx.lifecycle.b {
    private final Lazy b;
    private final androidx.lifecycle.b0 c;

    public static final class a extends dg.a {
        a() {
        }

        public void a(String str, String str2) {
            y.this.c.q(new i0(false, str, str2, null));
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberPromoCodeRes memberPromoCodeRes) {
            super.c(memberPromoCodeRes);
            y.this.c.q(new i0(true, null, null, memberPromoCodeRes));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.member.x
            public final Object invoke() {
                fm.a g;
                g = y.g();
                return g;
            }
        });
        this.c = new androidx.lifecycle.b0();
    }

    private final fm.a f() {
        return (fm.a) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fm.a g() {
        return (fm.a) kg.c.e.a().h(fm.a.class);
    }

    public final LiveData e() {
        return this.c;
    }

    public final void h(String str) {
        Intrinsics.h(str, "code");
        a.C0069a.k(f(), null, new MemberPromoCodeReq(str), 1, null).f(dg.d.a.c()).subscribe(new a());
    }
}
