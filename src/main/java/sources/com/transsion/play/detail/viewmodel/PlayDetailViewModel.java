package com.transsion.play.detail.viewmodel;

import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PlayDetailViewModel extends t0 {
    private final Lazy a = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.play.detail.viewmodel.a
        public final Object invoke() {
            cn.a h;
            h = PlayDetailViewModel.h();
            return h;
        }
    });
    private final b0 b = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public final cn.a e() {
        return (cn.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cn.a h() {
        return (cn.a) c.e.a().h(cn.a.class);
    }

    public final void f(String str) {
        Intrinsics.h(str, "subjectId");
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new PlayDetailViewModel$getSubjectPostCount$1(this, str, null), 3, (Object) null);
    }

    public final b0 g() {
        return this.b;
    }
}
