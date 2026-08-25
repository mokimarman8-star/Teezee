package com.transsion.player.longvideo.helper;

import kn.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class d {
    private mn.j a;
    private String b;
    private a.b c;

    protected final a.b a() {
        return this.c;
    }

    protected final mn.j b() {
        return this.a;
    }

    public void c(String str, mn.j jVar) {
        Intrinsics.h(jVar, "viewBinding");
        this.b = str;
        this.a = jVar;
    }

    public final void d(a.b bVar) {
        this.c = bVar;
    }
}
