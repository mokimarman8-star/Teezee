package com.transsion.shorttv.ad.playeroverlayad;

import com.transsion.shorttv.ad.AdLoadState;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    private AdLoadState a = AdLoadState.IDLE;
    private e b;
    private boolean c;
    private boolean d;

    public final void a() {
        this.a = AdLoadState.DESTROYED;
        e eVar = this.b;
        if (eVar != null) {
            eVar.f();
        }
        this.b = null;
        this.c = false;
    }

    public final e b() {
        return this.b;
    }

    public final AdLoadState c() {
        return this.a;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        return this.c;
    }

    public final void f(e eVar) {
        this.b = eVar;
    }

    public final void g(AdLoadState adLoadState) {
        Intrinsics.h(adLoadState, "<set-?>");
        this.a = adLoadState;
    }

    public final void h(boolean z) {
        this.d = z;
    }

    public final void i(boolean z) {
        this.c = z;
    }
}
