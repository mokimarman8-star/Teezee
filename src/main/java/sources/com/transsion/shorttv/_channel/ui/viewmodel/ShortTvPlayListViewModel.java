package com.transsion.shorttv._channel.ui.viewmodel;

import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTvPlayListViewModel extends t0 {
    private final rq.a a = (rq.a) kg.c.e.a().h(rq.a.class);
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.viewmodel.f
        public final Object invoke() {
            b0 h;
            h = ShortTvPlayListViewModel.h();
            return h;
        }
    });
    private int c = 1;
    private int d = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 h() {
        return new b0();
    }

    public final int e() {
        return this.c;
    }

    public final void f(String str, String str2, String str3, String str4, int i) {
        Intrinsics.h(str, "label");
        Intrinsics.h(str2, "category");
        Intrinsics.h(str3, "recType");
        Intrinsics.h(str4, "topIds");
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new ShortTvPlayListViewModel$getPlayList$1(this, str, str2, str3, str4, i, null), 2, (Object) null);
    }

    public final b0 g() {
        return (b0) this.b.getValue();
    }

    public final void i(int i) {
        this.c = i;
    }
}
