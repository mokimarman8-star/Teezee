package com.transsion.player.orplayer;

import com.transsion.player.orplayer.global.TnPlayerType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface e {

    public static final class a {
        public static void A(e eVar) {
        }

        public static void B(e eVar) {
        }

        public static void C(e eVar, int i) {
        }

        public static void D(e eVar, qn.c cVar) {
            Intrinsics.h(cVar, "tracks");
        }

        public static void E(e eVar, int i) {
        }

        public static void F(e eVar, gn.e eVar2) {
        }

        public static /* synthetic */ void G(e eVar, gn.e eVar2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoPause");
            }
            if ((i & 1) != 0) {
                eVar2 = null;
            }
            eVar.onVideoPause(eVar2);
        }

        public static void H(e eVar, int i, int i2) {
        }

        public static void I(e eVar, gn.e eVar2) {
        }

        public static /* synthetic */ void J(e eVar, gn.e eVar2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVideoStart");
            }
            if ((i & 1) != 0) {
                eVar2 = null;
            }
            eVar.onVideoStart(eVar2);
        }

        public static void K(e eVar) {
        }

        public static void a(e eVar, boolean z, int i, int i2, qn.d dVar) {
            Intrinsics.h(dVar, "dashVideoTracksGroup");
        }

        public static void b(e eVar) {
        }

        public static void c(e eVar, gn.e eVar2) {
        }

        public static void d(e eVar, long j, gn.e eVar2) {
        }

        public static void e(e eVar, gn.e eVar2) {
        }

        public static /* synthetic */ void f(e eVar, gn.e eVar2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCompletion");
            }
            if ((i & 1) != 0) {
                eVar2 = null;
            }
            eVar.onCompletion(eVar2);
        }

        public static void g(e eVar, boolean z) {
        }

        public static void h(e eVar, boolean z) {
        }

        public static void i(e eVar, gn.e eVar2) {
        }

        public static /* synthetic */ void j(e eVar, gn.e eVar2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadingBegin");
            }
            if ((i & 1) != 0) {
                eVar2 = null;
            }
            eVar.onLoadingBegin(eVar2);
        }

        public static void k(e eVar, gn.e eVar2) {
        }

        public static /* synthetic */ void l(e eVar, gn.e eVar2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadingEnd");
            }
            if ((i & 1) != 0) {
                eVar2 = null;
            }
            eVar.onLoadingEnd(eVar2);
        }

        public static void m(e eVar, int i, float f, gn.e eVar2) {
        }

        public static /* synthetic */ void n(e eVar, int i, float f, gn.e eVar2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadingProgress");
            }
            if ((i2 & 4) != 0) {
                eVar2 = null;
            }
            eVar.onLoadingProgress(i, f, eVar2);
        }

        public static void o(e eVar) {
        }

        public static void p(e eVar, String str) {
        }

        public static void q(e eVar, PlayError playError, gn.e eVar2) {
            Intrinsics.h(playError, "errorInfo");
        }

        public static /* synthetic */ void r(e eVar, PlayError playError, gn.e eVar2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPlayError");
            }
            if ((i & 2) != 0) {
                eVar2 = null;
            }
            eVar.onPlayError(playError, eVar2);
        }

        public static void s(e eVar, TnPlayerType tnPlayerType, gn.e eVar2) {
            Intrinsics.h(tnPlayerType, "errorType");
        }

        public static void t(e eVar, gn.e eVar2) {
        }

        public static /* synthetic */ void u(e eVar, gn.e eVar2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPlayerRelease");
            }
            if ((i & 1) != 0) {
                eVar2 = null;
            }
            eVar.onPlayerRelease(eVar2);
        }

        public static void v(e eVar) {
        }

        public static void w(e eVar, gn.e eVar2) {
        }

        public static /* synthetic */ void x(e eVar, gn.e eVar2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPrepare");
            }
            if ((i & 1) != 0) {
                eVar2 = null;
            }
            eVar.onPrepare(eVar2);
        }

        public static void y(e eVar, long j, gn.e eVar2) {
        }

        public static /* synthetic */ void z(e eVar, long j, gn.e eVar2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onProgress");
            }
            if ((i & 2) != 0) {
                eVar2 = null;
            }
            eVar.onProgress(j, eVar2);
        }
    }

    void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar);

    void initPlayer();

    void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar);

    void onBufferedPosition(long j, gn.e eVar);

    void onCompletion(gn.e eVar);

    void onFocusChange(boolean z);

    void onIsPlayingChanged(boolean z);

    void onLoadingBegin(gn.e eVar);

    void onLoadingEnd(gn.e eVar);

    void onLoadingProgress(int i, float f, gn.e eVar);

    void onLoopingStart();

    void onMediaItemTransition(String str);

    void onPlayError(PlayError playError, gn.e eVar);

    void onPlayerRelease(gn.e eVar);

    void onPlayerReset();

    void onPrepare(gn.e eVar);

    void onProgress(long j, gn.e eVar);

    void onRenderFirstFrame();

    void onSetDataSource();

    void onTracksAudioBitrateChange(int i);

    void onTracksChange(qn.c cVar);

    void onTracksVideoBitrateChange(int i);

    void onVideoPause(gn.e eVar);

    void onVideoSizeChanged(int i, int i2);

    void onVideoStart(gn.e eVar);

    void setOnSeekCompleteListener();
}
