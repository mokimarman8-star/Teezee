package com.transsion.postdetail.shorttv.viewmodel;

import android.app.Application;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ShortTVContentViewModel extends androidx.lifecycle.b {
    private final Lazy b;
    private final Lazy c;
    private final b0 d;
    private final b0 e;
    private final b0 f;
    private final b0 g;
    private final b0 h;
    private final b0 i;
    private final Lazy j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVContentViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.viewmodel.a
            public final Object invoke() {
                ao.b m;
                m = ShortTVContentViewModel.m();
                return m;
            }
        });
        this.c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.viewmodel.b
            public final Object invoke() {
                ShortTVPlayDao n;
                n = ShortTVContentViewModel.n();
                return n;
            }
        });
        this.d = new b0();
        this.e = new b0();
        this.f = new b0();
        this.g = new b0();
        this.h = new b0();
        this.i = new b0();
        this.j = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.viewmodel.c
            public final Object invoke() {
                n0 g;
                g = ShortTVContentViewModel.g();
                return g;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 g() {
        return o0.a(y0.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.b k() {
        return (ao.b) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ao.b m() {
        return (ao.b) kg.c.e.a().h(ao.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTVPlayDao n() {
        Application a = Utils.a();
        if (a != null) {
            return AppDatabase.p.b(a).w1();
        }
        return null;
    }

    public final b0 h() {
        return this.f;
    }

    public final b0 i() {
        return this.g;
    }

    public final b0 j() {
        return this.i;
    }

    public final void l(String str, int i, boolean z) {
        Intrinsics.h(str, "nextPage");
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new ShortTVContentViewModel$getShortTVFavoriteList$1(this, str, i, z, null), 3, (Object) null);
    }
}
