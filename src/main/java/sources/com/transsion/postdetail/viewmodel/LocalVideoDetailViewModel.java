package com.transsion.postdetail.viewmodel;

import android.util.Log;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class LocalVideoDetailViewModel extends t0 {
    private final String a = "LocalVideoViewModel";
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.b
        public final Object invoke() {
            cx.a k;
            k = LocalVideoDetailViewModel.k();
            return k;
        }
    });
    private b0 c = new b0();
    private b0 d = new b0();
    private b0 e = new b0();
    private final b0 f = new b0();

    private final cx.a j() {
        return (cx.a) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cx.a k() {
        return (cx.a) kg.c.e.a().h(cx.a.class);
    }

    public final void d(String str) {
        if (str == null || str.length() == 0) {
            this.f.n((Object) null);
        } else if (yg.l.a.e()) {
            j().h(gg.a.a.a(), str).f(dg.d.a.c()).subscribe(new dg.a() { // from class: com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel$fetchMovieData$1
                public void a(String str2, String str3) {
                    String str4;
                    LocalVideoDetailViewModel.this.g().n((Object) null);
                    str4 = LocalVideoDetailViewModel.this.a;
                    Log.e(str4, "message:" + str3);
                }

                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public void c(Subject subject) {
                    kotlinx.coroutines.i.d(u0.a(LocalVideoDetailViewModel.this), (CoroutineContext) null, (CoroutineStart) null, new LocalVideoDetailViewModel$fetchMovieData$1$onSuccess$1(LocalVideoDetailViewModel.this, subject, null), 3, (Object) null);
                }

                public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
                    Intrinsics.h(cVar, "d");
                    super.onSubscribe(cVar);
                }
            });
        } else {
            this.f.n((Object) null);
        }
    }

    public final b0 e() {
        return this.d;
    }

    public final b0 f() {
        return this.e;
    }

    public final b0 g() {
        return this.f;
    }

    public final void h(DownloadBean downloadBean) {
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new LocalVideoDetailViewModel$getSeriesFromLocal$1(downloadBean, this, null), 2, (Object) null);
    }

    public final b0 i() {
        return this.c;
    }
}
