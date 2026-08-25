package com.transsion.fission;

import android.content.Context;
import gk.b;
import kg.c;
import kk.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class FissionProvider implements a {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.fission.m
        public final Object invoke() {
            b m;
            m = FissionProvider.m();
            return m;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final b l() {
        return (b) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b m() {
        return (b) c.e.a().h(b.class);
    }

    @Override // kk.a
    public void a(String str) {
        Intrinsics.h(str, "inviteCode");
        l.a.c(str);
    }

    @Override // kk.a
    public void b(boolean z) {
        c.a.b().putBoolean("kv_task_is_exists", z);
        a.a.g(wf.a.a, "updatePalmPayTask() ---> isExists = " + z, false, 2, (Object) null);
    }

    @Override // kk.a
    public void c(boolean z) {
    }

    @Override // kk.a
    public String d() {
        return k.a.c();
    }

    @Override // kk.a
    public void e(Context context) {
        Intrinsics.h(context, "context");
        new ik.b(context).show();
    }

    @Override // kk.a
    public boolean enable() {
        FissionConfig d = k.a.d();
        String htmlUrl = d != null ? d.getHtmlUrl() : null;
        return !(htmlUrl == null || htmlUrl.length() == 0);
    }

    @Override // kk.a
    public void f(int i) {
        if (c.a.b().getBoolean("kv_task_is_exists", false)) {
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new finishPalmPayTask.1(i, this, (Continuation) null), 3, (Object) null);
        }
    }

    @Override // kk.a
    public boolean g() {
        c cVar = c.a;
        return cVar.b().getBoolean("kv_task_is_exists", false) && !cVar.b().getBoolean("kv_task_is_finished", false);
    }

    @Override // kk.a
    public String h() {
        return l.a.a();
    }

    @Override // kk.a
    public void i(boolean z) {
    }
}
