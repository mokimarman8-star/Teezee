package com.transsion.player.longvideo.helper;

import com.transsion.player.longvideo.ui.LongVodUiType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    private final mn.j a;
    private final long b;
    private final int c;
    private final int d;
    private final int e;
    private float f;
    private boolean g;
    private boolean h;
    private LongVodUiType i;

    public c(mn.j jVar) {
        Intrinsics.h(jVar, "viewBinding");
        this.a = jVar;
        this.b = 200L;
        this.c = com.blankj.utilcode.util.a0.a(24.0f);
        this.d = com.blankj.utilcode.util.a0.a(16.0f);
        this.e = com.blankj.utilcode.util.a0.a(20.0f);
        this.f = 1.0f;
        this.h = true;
        this.i = LongVodUiType.MIDDLE;
    }

    public final void a() {
    }

    public final boolean b() {
        return this.g;
    }

    public final void c(LongVodUiType longVodUiType) {
        Intrinsics.h(longVodUiType, "uiType");
    }

    public final void d() {
    }

    public final void e(long j, long j2) {
    }

    public final void f() {
    }
}
