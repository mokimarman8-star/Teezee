package com.transsion.usercenter.profile;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.therouter.TheRouter;
import com.transsion.usercenter.profile.b;
import dg.d;
import io.reactivex.rxjava3.disposables.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import qx.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ProfileViewModel extends b {
    private final Lazy b;
    private final Lazy c;
    private final b0 d;
    private final b0 e;
    private final b0 f;
    private c g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new m0());
        this.c = LazyKt.b(new n0());
        this.d = new b0();
        this.e = new b0();
        this.f = new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a n() {
        return (a) this.b.getValue();
    }

    private final b o() {
        return (b) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a q() {
        return (a) TheRouter.d(a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b r() {
        return (b) kg.c.e.a().h(b.class);
    }

    public final void i() {
        b.a.g(o(), (String) null, 1, (Object) null).v(ey.a.c()).f(d.a.c()).subscribe(new a(this));
    }

    public final void j() {
        i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new fetchLatestDownloadList.1(this, (Continuation) null), 3, (Object) null);
    }

    public final void k(String str) {
        c cVar;
        c cVar2 = this.g;
        if (cVar2 != null && !cVar2.isDisposed() && (cVar = this.g) != null) {
            cVar.dispose();
        }
        b.a.h(o(), str == null ? "" : str, (String) null, 2, (Object) null).v(ey.a.c()).x(new b(str, this)).h(c.a).f(d.a.c()).subscribe(new d(this));
    }

    public final b0 l() {
        return this.f;
    }

    public final LiveData m() {
        return this.e;
    }

    public final LiveData p() {
        return this.d;
    }
}
