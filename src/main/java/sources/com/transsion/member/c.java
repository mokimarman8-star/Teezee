package com.transsion.member;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import fm.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends androidx.lifecycle.b {
    private final Lazy b;
    private final androidx.lifecycle.b0 c;

    public static final class a extends dg.a {
        a() {
        }

        public void a(String str, String str2) {
            c.this.c.q((Object) null);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes) {
            super.c(memberTaskSubmitCheckInRes);
            c.this.c.q(memberTaskSubmitCheckInRes);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.member.b
            public final Object invoke() {
                fm.a h;
                h = c.h();
                return h;
            }
        });
        this.c = new androidx.lifecycle.b0();
    }

    private final fm.a g() {
        return (fm.a) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fm.a h() {
        return (fm.a) kg.c.e.a().h(fm.a.class);
    }

    public final void e() {
        a.C0069a.l(g(), null, null, 3, null).f(dg.d.a.c()).subscribe(new a());
    }

    public final LiveData f() {
        return this.c;
    }
}
