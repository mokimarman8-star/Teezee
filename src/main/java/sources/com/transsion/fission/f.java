package com.transsion.fission;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import gk.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends t0 {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.fission.e
        public final Object invoke() {
            gk.a f;
            f = f.f();
            return f;
        }
    });
    private final b0 b = new b0();

    public static final class a extends dg.a {
        a() {
        }

        public void a(String str, String str2) {
            b0 b0Var = f.this.b;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            b0Var.q(new BaseDto(str2, str, (Object) null, BuildConfig.FLAVOR));
        }

        public void d(BaseDto baseDto) {
            Intrinsics.h(baseDto, "baseDto");
            super.d(baseDto);
            f.this.b.q(baseDto);
        }
    }

    private final gk.a d() {
        return (gk.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final gk.a f() {
        return (gk.a) kg.c.e.a().h(gk.a.class);
    }

    public final LiveData e() {
        return this.b;
    }

    public final void g(String str) {
        io.reactivex.rxjava3.core.j a2;
        io.reactivex.rxjava3.core.j f;
        Intrinsics.h(str, "code");
        String str2 = "{\"inviteCode\": \"" + str + "\"}";
        gk.a d = d();
        if (d == null || (a2 = a.C0071a.a(d, null, RequestBody.Companion.create(str2, MediaType.Companion.parse("application/json")), 1, null)) == null || (f = a2.f(dg.d.a.c())) == null) {
            return;
        }
        f.subscribe(new a());
    }
}
