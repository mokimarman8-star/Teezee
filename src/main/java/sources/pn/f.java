package pn;

import com.transsion.player.orplayer.f;
import com.transsion.player.p003enum.ScaleMode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface f extends com.transsion.player.orplayer.f {

    public static final class a {
        public static void a(f fVar, com.transsion.player.orplayer.e eVar) {
            Intrinsics.h(eVar, "listener");
            f.b.b(fVar, eVar);
        }

        public static void b(f fVar, qn.d dVar, int i) {
            Intrinsics.h(dVar, "mediaTrackGroup");
            f.b.c(fVar, dVar, i);
        }

        public static void c(f fVar) {
            f.b.d(fVar);
        }

        public static qn.c d(f fVar) {
            return f.b.h(fVar);
        }

        public static qn.b e(f fVar) {
            return f.b.i(fVar);
        }

        public static Object f(f fVar) {
            return f.b.j(fVar);
        }

        public static int g(f fVar) {
            return f.b.k(fVar);
        }

        public static int h(f fVar) {
            return f.b.l(fVar);
        }

        public static boolean i(f fVar) {
            return f.b.m(fVar);
        }

        public static void j(f fVar, String str) {
            f.b.o(fVar, str);
        }

        public static void k(f fVar, com.transsion.player.orplayer.e eVar) {
            Intrinsics.h(eVar, "listener");
            f.b.q(fVar, eVar);
        }

        public static boolean l(f fVar) {
            return f.b.r(fVar);
        }

        public static void m(f fVar, String str, long j) {
            Intrinsics.h(str, "uuid");
            f.b.s(fVar, str, j);
        }

        public static void n(f fVar, hn.d dVar) {
            Intrinsics.h(dVar, "vodConfig");
            f.b.w(fVar, dVar);
        }

        public static void o(f fVar, ScaleMode scaleMode) {
            Intrinsics.h(scaleMode, "scaleMode");
            f.b.x(fVar, scaleMode);
        }
    }

    boolean a(gn.e eVar);

    Map b();
}
