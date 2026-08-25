package com.transsion.transfer.wifi.create.adapter;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class b {
    private du.a a;
    private com.transsion.transfer.wifi.create.a b;
    private n0 c;

    public abstract Object a(Continuation continuation);

    public final String b() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final n0 c() {
        return this.c;
    }

    public final com.transsion.transfer.wifi.create.a d() {
        return this.b;
    }

    public final du.a e() {
        return this.a;
    }

    public abstract void f();

    public final void g(n0 n0Var) {
        this.c = n0Var;
    }

    public final void h(com.transsion.transfer.wifi.create.a aVar) {
        this.b = aVar;
    }

    public final Object i(du.a aVar, com.transsion.transfer.wifi.create.a aVar2, n0 n0Var, Continuation continuation) {
        this.a = aVar;
        this.b = aVar2;
        this.c = n0Var;
        Object a = a(continuation);
        return a == IntrinsicsKt.f() ? a : Unit.a;
    }
}
