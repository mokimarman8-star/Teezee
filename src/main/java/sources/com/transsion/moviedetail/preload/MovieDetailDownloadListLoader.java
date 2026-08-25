package com.transsion.moviedetail.preload;

import androidx.lifecycle.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MovieDetailDownloadListLoader extends am.b {
    private String f;
    private final Lazy g;

    public MovieDetailDownloadListLoader(String str) {
        Intrinsics.h(str, "subjectId");
        this.f = str;
        this.g = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.preload.c
            public final Object invoke() {
                cx.a o;
                o = MovieDetailDownloadListLoader.o();
                return o;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cx.a m() {
        return (cx.a) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cx.a o() {
        return (cx.a) kg.c.e.a().h(cx.a.class);
    }

    @Override // am.b
    public void h(b0 b0Var) {
        j(i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new MovieDetailDownloadListLoader$loadDataFromService$1(this, null), 3, (Object) null));
    }

    public final String n() {
        return this.f;
    }

    public final void p(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f = str;
    }
}
