package cw;

import com.transsion.player.orplayer.f;
import cw.b;
import cw.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final void a() {
        b.C0053b.a(b.a.c(), false, 1, null);
        e.b.a(e.a.b(), false, 1, null);
    }

    public final boolean b(String tag) {
        Intrinsics.h(tag, "tag");
        return b.a.c().b(tag) || e.a.b().b(tag);
    }

    public final boolean c(f fVar) {
        return b.a.c().c(fVar) || e.a.b().g(fVar);
    }

    public final boolean d() {
        return b.a.c().isPlaying() || e.a.b().isPlaying();
    }
}
