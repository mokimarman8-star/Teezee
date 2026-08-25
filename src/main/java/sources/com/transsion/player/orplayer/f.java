package com.transsion.player.orplayer;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import com.transsion.player.p003enum.ScaleMode;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import on.z;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface f {

    public static final class a {
        private Context a;
        private hn.d b;

        public a(Context context) {
            Intrinsics.h(context, "context");
            this.a = context;
        }

        public final f a() {
            return new q(this.a, this.b);
        }

        public final a b(hn.d dVar) {
            Intrinsics.h(dVar, "config");
            this.b = dVar;
            return this;
        }
    }

    public static final class b {
        public static boolean a(f fVar, gn.e eVar) {
            Intrinsics.h(eVar, "mediaSource");
            return false;
        }

        public static void b(f fVar, e eVar) {
            Intrinsics.h(eVar, "listener");
        }

        public static void c(f fVar, qn.d dVar, int i) {
            Intrinsics.h(dVar, "mediaTrackGroup");
        }

        public static void d(f fVar) {
        }

        public static void e(f fVar) {
        }

        public static gn.e f(f fVar) {
            return null;
        }

        public static long g(f fVar) {
            return 0L;
        }

        public static qn.c h(f fVar) {
            return null;
        }

        public static qn.b i(f fVar) {
            return null;
        }

        public static Object j(f fVar) {
            return null;
        }

        public static int k(f fVar) {
            return 0;
        }

        public static int l(f fVar) {
            return 0;
        }

        public static boolean m(f fVar) {
            return false;
        }

        public static boolean n(f fVar) {
            return false;
        }

        public static void o(f fVar, String str) {
        }

        public static boolean p(f fVar, gn.e eVar) {
            Intrinsics.h(eVar, "mediaSource");
            return false;
        }

        public static void q(f fVar, e eVar) {
            Intrinsics.h(eVar, "listener");
        }

        public static boolean r(f fVar) {
            return false;
        }

        public static void s(f fVar, String str, long j) {
            Intrinsics.h(str, "uuid");
        }

        public static void t(f fVar) {
        }

        public static void u(f fVar, z zVar) {
            Intrinsics.h(zVar, "listener");
        }

        public static void v(f fVar, boolean z) {
        }

        public static void w(f fVar, hn.d dVar) {
            Intrinsics.h(dVar, "vodConfig");
        }

        public static void x(f fVar, ScaleMode scaleMode) {
            Intrinsics.h(scaleMode, "scaleMode");
        }
    }

    boolean addDataSource(gn.e eVar);

    void addPlayerListener(e eVar);

    void changeTrackSelection(qn.d dVar, int i);

    void clearScreen();

    void clearSurfaceOnly();

    gn.e currentMediaSource();

    void enableHardwareDecoder(boolean z);

    Pair getBitrate();

    long getCurrentPosition();

    qn.c getCurrentTracks();

    qn.b getCurrentVideoFormat();

    Object getDownloadBitrate();

    long getDuration();

    int getVideoHeight();

    int getVideoWidth();

    Float getVolume();

    boolean isComplete();

    boolean isLoading();

    boolean isMute();

    boolean isPlaying();

    boolean isPrepared();

    void pause();

    void play();

    void prepare();

    void release();

    void release(String str);

    boolean removeDataSource(gn.e eVar);

    void removePlayerListener(e eVar);

    boolean requestForce();

    void reset();

    void seekTo(long j);

    void seekTo(String str, long j);

    void setAutoPlay(boolean z);

    void setDataSource(gn.e eVar);

    void setLooping(boolean z);

    void setMute(boolean z);

    void setPlayerConfig(hn.d dVar);

    void setPlayerListener(e eVar);

    void setScaleMode(ScaleMode scaleMode);

    void setSpeed(float f);

    void setSurfaceView(SurfaceView surfaceView);

    void setTextureView(TextureView textureView);

    void setVipResolution(boolean z, int i);

    void setVolume(float f);

    void stop();
}
