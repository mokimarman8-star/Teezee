package com.transsion.player.ui.longvideo;

import android.view.MotionEvent;
import com.transsion.player.orplayer.f;
import com.transsion.player.p003enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import gn.e;
import hn.d;
import kotlin.jvm.internal.Intrinsics;
import on.z;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a extends f {

    /* renamed from: com.transsion.player.ui.longvideo.a$a, reason: collision with other inner class name */
    public static final class C0047a {
        public static boolean a(a aVar, e eVar) {
            Intrinsics.h(eVar, "mediaSource");
            return f.b.a(aVar, eVar);
        }

        public static void b(a aVar) {
            f.b.d(aVar);
        }

        public static e c(a aVar) {
            return f.b.f(aVar);
        }

        public static int d(a aVar) {
            return f.b.k(aVar);
        }

        public static int e(a aVar) {
            return f.b.l(aVar);
        }

        public static boolean f(a aVar) {
            return f.b.m(aVar);
        }

        public static boolean g(a aVar) {
            return f.b.n(aVar);
        }

        public static void h(a aVar, String str) {
            f.b.o(aVar, str);
        }

        public static boolean i(a aVar, e eVar) {
            Intrinsics.h(eVar, "mediaSource");
            return f.b.p(aVar, eVar);
        }

        public static void j(a aVar, String str, long j) {
            Intrinsics.h(str, "uuid");
            f.b.s(aVar, str, j);
        }

        public static void k(a aVar) {
            f.b.t(aVar);
        }

        public static void l(a aVar, z zVar) {
            Intrinsics.h(zVar, "listener");
            f.b.u(aVar, zVar);
        }

        public static void m(a aVar, boolean z) {
            f.b.v(aVar, z);
        }

        public static void n(a aVar, d dVar) {
            Intrinsics.h(dVar, "vodConfig");
            f.b.w(aVar, dVar);
        }

        public static void o(a aVar, ScaleMode scaleMode) {
            Intrinsics.h(scaleMode, "scaleMode");
            f.b.x(aVar, scaleMode);
        }
    }

    public interface b {
        void a();

        void b(float f, float f2);

        void c();

        void onDoubleTap(MotionEvent motionEvent);

        void onLongPress(MotionEvent motionEvent);
    }

    void enableGesture(boolean z);

    f getOrPlayer();

    void initLongVodPlayer(hn.a aVar, ORPlayerView oRPlayerView);

    void setExistPlayer(hn.a aVar, f fVar, ORPlayerView oRPlayerView);

    void setGestureListener(b bVar);
}
