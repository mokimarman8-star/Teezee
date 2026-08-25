package pn;

import android.app.Application;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.common.h0;
import androidx.media3.common.i0;
import androidx.media3.common.m;
import androidx.media3.common.m0;
import androidx.media3.common.r;
import androidx.media3.common.t;
import androidx.media3.common.v;
import androidx.media3.common.x;
import androidx.media3.common.y;
import androidx.media3.common.z;
import androidx.media3.datasource.b;
import androidx.media3.datasource.c;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.drm.w;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.source.i;
import com.blankj.utilcode.util.Utils;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.exo.ORExoDecoderType;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.p003enum.PlayMimeType;
import com.transsion.player.p003enum.ScaleMode;
import com.transsion.player.shorttv.preload.g;
import com.transsion.player.ui.render.RenderScaleMode;
import com.transsion.player.ui.render.SurfaceRenderView;
import com.transsion.player.ui.render.TextureRenderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pn.f;
import x1.c;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements f {
    private final com.transsion.player.shorttv.preload.c a;
    private final String b;
    private final Map c;
    private ExoPlayer d;
    private gn.e e;
    private SurfaceRenderView f;
    private TextureRenderView g;
    private Float h;
    private boolean i;
    private boolean j;
    private boolean k;
    private float l;
    private ScaleMode m;
    private int n;
    private int o;
    private String p;
    private ORExoDecoderType q;
    private com.transsion.player.orplayer.c r;
    private final a0.d s;
    private CopyOnWriteArrayList t;
    private final Handler u;
    private final Runnable v;
    private final Lazy w;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ScaleMode.values().length];
            try {
                iArr[ScaleMode.SCALE_TO_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScaleMode.SCALE_ASPECT_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[PlayMimeType.values().length];
            try {
                iArr2[PlayMimeType.DASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PlayMimeType.HLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    public static final class b extends androidx.media3.exoplayer.util.a {
        b(String str) {
            super(str);
        }

        public void Z(c.a aVar, i0 i0Var) {
            Intrinsics.h(aVar, "eventTime");
            Intrinsics.h(i0Var, "tracks");
            super.Z(aVar, i0Var);
            e.this.C(aVar, i0Var);
        }

        public void j0(c.a aVar, String str, long j, long j2) {
            Intrinsics.h(aVar, "eventTime");
            Intrinsics.h(str, "decoderName");
            super.j0(aVar, str, j, j2);
            sn.e.a.h(e.this.b, "onExoVideoDecoderInitialize, decoderName:" + str, true);
        }

        public void x(c.a aVar, String str, long j, long j2) {
            Intrinsics.h(aVar, "eventTime");
            Intrinsics.h(str, "decoderName");
            super.x(aVar, str, j, j2);
            sn.e.a.h(e.this.b, "onExoAudioDecoderInitialize, decoderName:" + str, true);
        }
    }

    public static final class c implements a0.d {
        private int a = 1;

        c() {
        }

        public void onAudioSessionIdChanged(int i) {
        }

        public void onAvailableCommandsChanged(a0.b bVar) {
            Intrinsics.h(bVar, "availableCommands");
        }

        public void onCues(List list) {
            Intrinsics.h(list, "cues");
        }

        public void onCues(u1.b bVar) {
            Intrinsics.h(bVar, "cueGroup");
        }

        public void onDeviceInfoChanged(m mVar) {
            Intrinsics.h(mVar, "deviceInfo");
        }

        public void onDeviceVolumeChanged(int i, boolean z) {
        }

        public void onEvents(a0 a0Var, a0.c cVar) {
            Intrinsics.h(a0Var, "player");
            Intrinsics.h(cVar, "events");
        }

        public void onIsLoadingChanged(boolean z) {
        }

        public void onIsPlayingChanged(boolean z) {
            com.transsion.player.orplayer.c cVar = e.this.r;
            if (cVar != null) {
                cVar.f(z);
            }
            if (z) {
                for (com.transsion.player.orplayer.e eVar : e.this.t) {
                    if (eVar != null) {
                        e.a.J(eVar, null, 1, null);
                    }
                }
                e.this.u.post(e.this.v);
            } else {
                ExoPlayer exoPlayer = e.this.d;
                if (exoPlayer == null || !exoPlayer.getPlayWhenReady()) {
                    for (com.transsion.player.orplayer.e eVar2 : e.this.t) {
                        if (eVar2 != null) {
                            e.a.G(eVar2, null, 1, null);
                        }
                    }
                }
                e.this.u.removeCallbacks(e.this.v);
            }
            sn.e.d(sn.e.a, e.this.b, "onIsPlayingChanged:" + z, false, 4, null);
        }

        public void onLoadingChanged(boolean z) {
        }

        public void onMediaItemTransition(t tVar, int i) {
            t.h hVar;
            sn.e.d(sn.e.a, e.this.b, "onMediaItemTransition  reason:" + i + " ", false, 4, null);
            if (i == 0 || i == 1) {
                for (com.transsion.player.orplayer.e eVar : e.this.t) {
                    if (eVar != null) {
                        eVar.onMediaItemTransition((tVar == null || (hVar = tVar.b) == null) ? null : hVar.e);
                    }
                }
            }
        }

        public void onMediaMetadataChanged(v vVar) {
            Intrinsics.h(vVar, "mediaMetadata");
        }

        public void onMetadata(x xVar) {
            Intrinsics.h(xVar, "metadata");
        }

        public void onPlayWhenReadyChanged(boolean z, int i) {
        }

        public void onPlaybackParametersChanged(z zVar) {
            Intrinsics.h(zVar, "playbackParameters");
        }

        public void onPlaybackStateChanged(int i) {
            sn.e eVar = sn.e.a;
            sn.e.d(eVar, e.this.b, "onPlaybackStateChanged  playbackState:" + i + " ", false, 4, null);
            if (i == 2) {
                sn.e.d(eVar, e.this.b, "onPlaybackStateChanged STATE_BUFFERING", false, 4, null);
                for (com.transsion.player.orplayer.e eVar2 : e.this.t) {
                    if (eVar2 != null) {
                        e.a.j(eVar2, null, 1, null);
                    }
                }
            } else if (i == 3) {
                e.this.D();
                for (com.transsion.player.orplayer.e eVar3 : e.this.t) {
                    if (eVar3 != null) {
                        e.a.x(eVar3, null, 1, null);
                    }
                }
                if (this.a == 2) {
                    for (com.transsion.player.orplayer.e eVar4 : e.this.t) {
                        if (eVar4 != null) {
                            e.a.l(eVar4, null, 1, null);
                        }
                    }
                }
            } else if (i == 4) {
                for (com.transsion.player.orplayer.e eVar5 : e.this.t) {
                    if (eVar5 != null) {
                        e.a.f(eVar5, null, 1, null);
                    }
                }
            }
            this.a = i;
        }

        public void onPlaybackSuppressionReasonChanged(int i) {
        }

        public void onPlayerError(PlaybackException playbackException) {
            Intrinsics.h(playbackException, MediaItem.MUSIC_FLOAT_STATE_ERROR);
            sn.e.d(sn.e.a, e.this.b, "onPlayerError:" + playbackException, false, 4, null);
            for (com.transsion.player.orplayer.e eVar : e.this.t) {
                if (eVar != null) {
                    e.a.r(eVar, new PlayError(Integer.valueOf(playbackException.errorCode), playbackException.getMessage()), null, 2, null);
                }
            }
        }

        public void onPlayerErrorChanged(PlaybackException playbackException) {
        }

        public void onPlayerStateChanged(boolean z, int i) {
        }

        public void onPositionDiscontinuity(int i) {
        }

        public void onPositionDiscontinuity(a0.e eVar, a0.e eVar2, int i) {
            Intrinsics.h(eVar, "oldPosition");
            Intrinsics.h(eVar2, "newPosition");
            int i2 = eVar2.c;
            long j = eVar2.g;
            sn.e.b(sn.e.a, e.this.b, "onPositionDiscontinuity: currentWindowIndex=" + i2 + ", currentPositionMs=" + j + ", reason=" + i, false, 4, null);
            if (i == 1 || i == 2) {
                for (com.transsion.player.orplayer.e eVar3 : e.this.t) {
                    if (eVar3 != null) {
                        eVar3.setOnSeekCompleteListener();
                    }
                }
            }
            for (com.transsion.player.orplayer.e eVar4 : e.this.t) {
                if (eVar4 != null) {
                    e.a.z(eVar4, j, null, 2, null);
                }
            }
            g w = e.this.w();
            if (w != null) {
                w.h(i2);
            }
        }

        public void onRenderedFirstFrame() {
            sn.e.d(sn.e.a, e.this.b, "onRenderedFirstFrame:", false, 4, null);
            for (com.transsion.player.orplayer.e eVar : e.this.t) {
                if (eVar != null) {
                    eVar.onRenderFirstFrame();
                }
            }
        }

        public void onRepeatModeChanged(int i) {
        }

        public void onShuffleModeEnabledChanged(boolean z) {
        }

        public void onSkipSilenceEnabledChanged(boolean z) {
        }

        public void onSurfaceSizeChanged(int i, int i2) {
        }

        public void onTimelineChanged(e0 e0Var, int i) {
            Intrinsics.h(e0Var, "timeline");
        }

        public void onTrackSelectionParametersChanged(h0 h0Var) {
            Intrinsics.h(h0Var, "parameters");
        }

        public void onTracksChanged(i0 i0Var) {
            Intrinsics.h(i0Var, "tracks");
        }

        public void onVideoSizeChanged(m0 m0Var) {
            Intrinsics.h(m0Var, "videoSize");
            SurfaceRenderView surfaceRenderView = e.this.f;
            if (surfaceRenderView != null) {
                surfaceRenderView.setVideoRotation(m0Var.c);
            }
            TextureRenderView textureRenderView = e.this.g;
            if (textureRenderView != null) {
                textureRenderView.setVideoRotation(m0Var.c);
            }
            SurfaceRenderView surfaceRenderView2 = e.this.f;
            if (surfaceRenderView2 != null) {
                surfaceRenderView2.setVideoSize(m0Var.a, m0Var.b);
            }
            TextureRenderView textureRenderView2 = e.this.g;
            if (textureRenderView2 != null) {
                textureRenderView2.setVideoSize(m0Var.a, m0Var.b);
            }
            for (com.transsion.player.orplayer.e eVar : e.this.t) {
                if (eVar != null) {
                    eVar.onVideoSizeChanged(m0Var.a, m0Var.b);
                }
            }
            sn.e.d(sn.e.a, e.this.b, "onVideoSizeChanged width:" + m0Var.a + "  height:" + m0Var.b, false, 4, null);
        }

        public void onVolumeChanged(float f) {
        }
    }

    public static final class d implements com.transsion.player.orplayer.d {
        d() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            ExoPlayer exoPlayer = e.this.d;
            if (exoPlayer != null) {
                return exoPlayer.W();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            ExoPlayer exoPlayer = e.this.d;
            if (exoPlayer != null) {
                exoPlayer.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            ExoPlayer exoPlayer = e.this.d;
            if (exoPlayer != null) {
                exoPlayer.play();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f) {
            ExoPlayer exoPlayer = e.this.d;
            if (exoPlayer != null) {
                exoPlayer.setVolume(f);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e() {
        this(r0, 1, r0);
        com.transsion.player.shorttv.preload.c cVar = null;
    }

    public e(com.transsion.player.shorttv.preload.c cVar) {
        Intrinsics.h(cVar, "config");
        this.a = cVar;
        this.b = "ShortTv-ORExoPlayer";
        this.c = new HashMap();
        this.l = 1.0f;
        this.m = ScaleMode.SCALE_TO_FILL;
        ORExoDecoderType oRExoDecoderType = ORExoDecoderType.HARDWARE;
        this.q = oRExoDecoderType;
        this.s = new c();
        this.t = new CopyOnWriteArrayList();
        x();
        v(oRExoDecoderType);
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        this.u = new Handler(myLooper);
        this.v = new Runnable() { // from class: pn.b
            @Override // java.lang.Runnable
            public final void run() {
                e.E(e.this);
            }
        };
        this.w = LazyKt.b(new Function0() { // from class: pn.c
            public final Object invoke() {
                g F;
                F = e.F(e.this);
                return F;
            }
        });
    }

    public /* synthetic */ e(com.transsion.player.shorttv.preload.c cVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? com.transsion.player.shorttv.preload.d.a() : cVar);
    }

    private final boolean A(gn.e eVar) {
        PlayMimeType i = eVar.i();
        PlayMimeType playMimeType = PlayMimeType.DASH;
        if (i != playMimeType) {
            PlayMimeType i2 = eVar.i();
            PlayMimeType playMimeType2 = PlayMimeType.HLS;
            if (i2 != playMimeType2) {
                if (StringsKt.c0(eVar.j(), ".mpd", false, 2, (Object) null)) {
                    eVar.q(playMimeType);
                    return true;
                }
                if (!StringsKt.c0(eVar.j(), ".m3u8", false, 2, (Object) null)) {
                    return false;
                }
                eVar.q(playMimeType2);
                return true;
            }
        }
        return true;
    }

    private final void B() {
        this.u.removeCallbacks(this.v);
        this.u.postDelayed(this.v, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(c.a aVar, i0 i0Var) {
        int size = i0Var.a().size();
        for (int i = 0; i < size; i++) {
            Object obj = i0Var.a().get(i);
            Intrinsics.g(obj, "get(...)");
            i0.a aVar2 = (i0.a) obj;
            int i2 = aVar2.a;
            for (int i3 = 0; i3 < i2; i3++) {
                r b2 = aVar2.b(i3);
                Intrinsics.g(b2, "getTrackFormat(...)");
                if (y.t(b2.o)) {
                    this.n = b2.j;
                } else if (y.o(b2.o)) {
                    this.o = b2.j;
                }
                sn.e eVar = sn.e.a;
                sn.e.i(eVar, this.b, "onTracksChanged  MimeType:" + b2.o, false, 4, null);
                String str = b2.o;
                if (str != null && StringsKt.c0(str, "video", false, 2, (Object) null)) {
                    String str2 = b2.o;
                    this.p = str2;
                    sn.e.f(eVar, this.b, "--------onTracksChanged  curVideoMimeType:" + str2, false, 4, null);
                }
            }
        }
        if (!Intrinsics.c(this.p, "video/av01") || Build.VERSION.SDK_INT > 29) {
            return;
        }
        sn.e.a.c(this.b, "exo av1，强制切换到软解， MimeType:" + this.p, true);
        gn.e u = u();
        if (u != null) {
            setDataSource(u);
            prepare();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        i0 currentTracks;
        ExoPlayer exoPlayer;
        r R;
        r J;
        ExoPlayer exoPlayer2 = this.d;
        if (exoPlayer2 == null || (currentTracks = exoPlayer2.getCurrentTracks()) == null) {
            return;
        }
        int size = currentTracks.a().size();
        for (int i = 0; i < size; i++) {
            Object obj = currentTracks.a().get(i);
            Intrinsics.g(obj, "get(...)");
            i0.a aVar = (i0.a) obj;
            int i2 = aVar.a;
            for (int i3 = 0; i3 < i2; i3++) {
                r b2 = aVar.b(i3);
                Intrinsics.g(b2, "getTrackFormat(...)");
                if (y.t(b2.o)) {
                    ExoPlayer exoPlayer3 = this.d;
                    if (exoPlayer3 != null && (J = exoPlayer3.J()) != null) {
                        int i4 = J.j;
                        int i5 = b2.j;
                        if (i4 == i5) {
                            this.n = i5;
                            sn.e.b(sn.e.a, this.b, "--onPrepare2GetBitrate  MimeType:" + b2.o + "，videoBitrate：" + i5, false, 4, null);
                            Iterator it = this.t.iterator();
                            while (it.hasNext()) {
                                ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(this.n);
                            }
                        }
                    }
                } else if (y.o(b2.o) && (exoPlayer = this.d) != null && (R = exoPlayer.R()) != null) {
                    int i6 = R.j;
                    int i7 = b2.j;
                    if (i6 == i7) {
                        this.o = i7;
                        sn.e.b(sn.e.a, this.b, "--onPrepare2GetBitrate  MimeType:" + b2.o + "，audioBitrate：" + i7, false, 4, null);
                        Iterator it2 = this.t.iterator();
                        while (it2.hasNext()) {
                            ((com.transsion.player.orplayer.e) it2.next()).onTracksAudioBitrateChange(this.o);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(e eVar) {
        ExoPlayer exoPlayer = eVar.d;
        if (exoPlayer == null || !exoPlayer.isPlaying()) {
            return;
        }
        for (com.transsion.player.orplayer.e eVar2 : eVar.t) {
            ExoPlayer exoPlayer2 = eVar.d;
            if (exoPlayer2 != null) {
                eVar2.onProgress(exoPlayer2.getCurrentPosition(), eVar.currentMediaSource());
            }
        }
        eVar.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g F(e eVar) {
        if (!eVar.a.a()) {
            return null;
        }
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return new g(a2);
    }

    private final t r(gn.e eVar) {
        String g = eVar.g();
        if (g == null) {
            g = eVar.j();
        }
        t.c h = new t.c().j(g).d(String.valueOf(eVar.k())).b(eVar.f()).h(eVar.e());
        Intrinsics.g(h, "setTag(...)");
        if (A(eVar)) {
            int i = a.b[eVar.i().ordinal()];
            String str = i != 1 ? i != 2 ? null : "application/x-mpegURL" : "application/dash+xml";
            if (str != null) {
                h.e(str);
            }
        }
        t a2 = h.a();
        Intrinsics.g(a2, "build(...)");
        return a2;
    }

    private final androidx.media3.exoplayer.source.r s(gn.e eVar) {
        c.b aVar;
        HlsMediaSource.Factory factory;
        if (!A(eVar)) {
            return null;
        }
        Application a2 = Utils.a();
        String g = eVar.g();
        if (g == null) {
            g = eVar.j();
        }
        t a3 = new t.c().j(g).d(String.valueOf(eVar.k())).b(eVar.f()).h(eVar.e()).a();
        Intrinsics.g(a3, "build(...)");
        if (StringsKt.W(g, "http", false, 2, (Object) null)) {
            aVar = new c.b();
            Map d2 = eVar.d();
            if (d2 != null) {
                if (d2.isEmpty()) {
                    d2 = null;
                }
                if (d2 != null) {
                    aVar.b(d2);
                }
            }
        } else {
            aVar = new b.a(a2);
        }
        int i = a.b[eVar.i().ordinal()];
        if (i == 1) {
            factory = new DashMediaSource.Factory(aVar);
        } else {
            if (i != 2) {
                return null;
            }
            factory = new HlsMediaSource.Factory(aVar);
        }
        factory.e(new w() { // from class: pn.a
            public final androidx.media3.exoplayer.drm.t a(t tVar) {
                androidx.media3.exoplayer.drm.t t;
                t = e.t(tVar);
                return t;
            }
        });
        return factory.d(a3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.media3.exoplayer.drm.t t(t tVar) {
        Intrinsics.h(tVar, "it");
        return androidx.media3.exoplayer.drm.t.a;
    }

    private final gn.e u() {
        gn.e eVar = this.e;
        reset();
        release();
        ORExoDecoderType oRExoDecoderType = Intrinsics.c(this.p, "video/av01") ? ORExoDecoderType.AV1 : ORExoDecoderType.FFMPEG;
        this.q = oRExoDecoderType;
        sn.e.a.a(this.b, "重新创建播放器切换编码, DecoderType:" + oRExoDecoderType + ",MimeTyp:" + this.p, true);
        v(this.q);
        z();
        return eVar;
    }

    private final void v(ORExoDecoderType oRExoDecoderType) {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        androidx.media3.exoplayer.m a3 = new m.b().b(5000, 20000, 500, 1000).d(-1).c(true).a();
        Intrinsics.g(a3, "build(...)");
        ExoPlayer h = new ExoPlayer.b(a2).q(new i(a2).q(in.a.d(a2))).r(in.a.b(a2, oRExoDecoderType)).p(a3).h();
        h.setPlayWhenReady(false);
        h.M(this.s);
        h.D(new b(this.b));
        this.d = h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g w() {
        return (g) this.w.getValue();
    }

    private final void x() {
        this.r = new com.transsion.player.orplayer.c(new d(), new Function1() { // from class: pn.d
            public final Object invoke(Object obj) {
                Unit y;
                y = e.y(e.this, ((Boolean) obj).booleanValue());
                return y;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(e eVar, boolean z) {
        Iterator it = eVar.t.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onFocusChange(z);
        }
        return Unit.a;
    }

    private final void z() {
        setMute(this.k);
        Float f = this.h;
        if (f != null) {
            setVolume(f.floatValue());
        }
        setLooping(this.j);
        setAutoPlay(this.i);
        setSpeed(this.l);
        SurfaceRenderView surfaceRenderView = this.f;
        if (surfaceRenderView != null) {
            setSurfaceView(surfaceRenderView);
        }
        TextureRenderView textureRenderView = this.g;
        if (textureRenderView != null) {
            setTextureView(textureRenderView);
        }
        setScaleMode(this.m);
    }

    @Override // pn.f
    public boolean a(gn.e eVar) {
        t.h hVar;
        Intrinsics.h(eVar, "mediaSource");
        ExoPlayer exoPlayer = this.d;
        int G = exoPlayer != null ? exoPlayer.G() : 0;
        for (int i = 0; i < G; i++) {
            ExoPlayer exoPlayer2 = this.d;
            Object obj = null;
            t O = exoPlayer2 != null ? exoPlayer2.O(i) : null;
            if (O != null && (hVar = O.b) != null) {
                obj = hVar.h;
            }
            if (Intrinsics.c(obj, eVar.e())) {
                sn.e.d(sn.e.a, this.b, "updateDataSource 在列表里更新数据 index:" + i + " key:" + eVar.e(), false, 4, null);
                if (A(eVar)) {
                    androidx.media3.exoplayer.source.r s = s(eVar);
                    if (s == null) {
                        return false;
                    }
                    ExoPlayer exoPlayer3 = this.d;
                    if (exoPlayer3 != null) {
                        exoPlayer3.F(i);
                    }
                    ExoPlayer exoPlayer4 = this.d;
                    if (exoPlayer4 != null) {
                        exoPlayer4.T(i, s);
                    }
                } else {
                    ExoPlayer exoPlayer5 = this.d;
                    if (exoPlayer5 != null) {
                        exoPlayer5.P(i, r(eVar));
                    }
                }
                ExoPlayer exoPlayer6 = this.d;
                if (exoPlayer6 != null) {
                    exoPlayer6.prepare();
                }
                Map map = this.c;
                String e = eVar.e();
                if (e == null) {
                    e = BuildConfig.FLAVOR;
                }
                map.put(e, eVar);
                return true;
            }
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(gn.e eVar) {
        ExoPlayer exoPlayer;
        ExoPlayer exoPlayer2;
        t.h hVar;
        String str;
        Integer v;
        Intrinsics.h(eVar, "mediaSource");
        this.e = eVar;
        ExoPlayer exoPlayer3 = this.d;
        int G = exoPlayer3 != null ? exoPlayer3.G() : 0;
        int i = -1;
        for (int i2 = 0; i2 < G; i2++) {
            ExoPlayer exoPlayer4 = this.d;
            Object obj = null;
            t O = exoPlayer4 != null ? exoPlayer4.O(i2) : null;
            int intValue = (O == null || (str = O.a) == null || (v = StringsKt.v(str)) == null) ? 0 : v.intValue();
            if (O != null && (hVar = O.b) != null) {
                obj = hVar.h;
            }
            if (Intrinsics.c(obj, eVar.e())) {
                sn.e.d(sn.e.a, this.b, "addDataSource 已经在列表里 index:" + i2 + " vid:" + eVar.e(), false, 4, null);
                return false;
            }
            if (i < 0 && intValue > eVar.k()) {
                i = i2;
            }
        }
        if (i >= 0) {
            g w = w();
            if (w != null) {
                w.f(i, eVar);
            }
            if (A(eVar)) {
                androidx.media3.exoplayer.source.r s = s(eVar);
                if (s != null && (exoPlayer2 = this.d) != null) {
                    exoPlayer2.T(i, s);
                }
            } else {
                ExoPlayer exoPlayer5 = this.d;
                if (exoPlayer5 != null) {
                    exoPlayer5.N(i, r(eVar));
                }
            }
            sn.e.d(sn.e.a, this.b, "addDataSource  index:" + i + " key:" + eVar.e(), false, 4, null);
        } else {
            sn.e.d(sn.e.a, this.b, "addDataSource  index:" + G + " key:" + eVar.e(), false, 4, null);
            if (A(eVar)) {
                androidx.media3.exoplayer.source.r s2 = s(eVar);
                if (s2 != null && (exoPlayer = this.d) != null) {
                    exoPlayer.X(s2);
                }
            } else {
                ExoPlayer exoPlayer6 = this.d;
                if (exoPlayer6 != null) {
                    exoPlayer6.K(r(eVar));
                }
            }
        }
        g w2 = w();
        if (w2 != null) {
            w2.g(eVar);
        }
        Map map = this.c;
        String e = eVar.e();
        if (e == null) {
            e = BuildConfig.FLAVOR;
        }
        map.put(e, eVar);
        return true;
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        f.a.a(this, eVar);
        sn.e.f(sn.e.a, this.b, "addPlayerListener", false, 4, null);
        if (this.t.contains(eVar)) {
            return;
        }
        this.t.add(eVar);
    }

    @Override // pn.f
    public Map b() {
        return this.c;
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(qn.d dVar, int i) {
        f.a.b(this, dVar, i);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        f.a.c(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        SurfaceTexture surfaceTexture;
        SurfaceHolder holder;
        Surface surface;
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.setVideoSurfaceView((SurfaceView) null);
        }
        ExoPlayer exoPlayer2 = this.d;
        if (exoPlayer2 != null) {
            exoPlayer2.setVideoTextureView((TextureView) null);
        }
        SurfaceRenderView surfaceRenderView = this.f;
        if (surfaceRenderView != null && (holder = surfaceRenderView.getHolder()) != null && (surface = holder.getSurface()) != null) {
            surface.release();
        }
        TextureRenderView textureRenderView = this.g;
        if (textureRenderView == null || (surfaceTexture = textureRenderView.getSurfaceTexture()) == null) {
            return;
        }
        surfaceTexture.release();
    }

    @Override // com.transsion.player.orplayer.f
    public gn.e currentMediaSource() {
        String str;
        t.h hVar;
        Object obj;
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            t O = exoPlayer.O(exoPlayer != null ? exoPlayer.u() : 0);
            if (O != null && (hVar = O.b) != null && (obj = hVar.h) != null) {
                str = obj.toString();
                return (gn.e) this.c.get(str);
            }
        }
        str = null;
        return (gn.e) this.c.get(str);
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z) {
        if (!z && this.q == ORExoDecoderType.HARDWARE) {
            u();
            return;
        }
        if (z) {
            ORExoDecoderType oRExoDecoderType = this.q;
            ORExoDecoderType oRExoDecoderType2 = ORExoDecoderType.HARDWARE;
            if (oRExoDecoderType != oRExoDecoderType2) {
                sn.e.a.a(this.b, "软解切换到硬解，重新创建设置", true);
                this.q = oRExoDecoderType2;
                v(oRExoDecoderType2);
                z();
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public Pair getBitrate() {
        return new Pair(Integer.valueOf(this.n), Integer.valueOf(this.o));
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            return exoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public qn.c getCurrentTracks() {
        return f.a.d(this);
    }

    @Override // com.transsion.player.orplayer.f
    public qn.b getCurrentVideoFormat() {
        return f.a.e(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        return f.a.f(this);
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            return exoPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        return f.a.g(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        return f.a.h(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            return Float.valueOf(exoPlayer.getVolume());
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        ExoPlayer exoPlayer = this.d;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 4;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        return f.a.i(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            return exoPlayer.W();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            return exoPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        ExoPlayer exoPlayer = this.d;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 3;
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        com.transsion.player.orplayer.c cVar = this.r;
        if (cVar != null) {
            cVar.g(true);
        }
        sn.e.d(sn.e.a, this.b, MediaItem.MUSIC_FLOAT_STATE_PAUSE, false, 4, null);
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
        com.transsion.player.orplayer.c cVar2 = this.r;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        ExoPlayer exoPlayer;
        sn.e.d(sn.e.a, this.b, MediaItem.MUSIC_FLOAT_STATE_PLAY, false, 4, null);
        ExoPlayer exoPlayer2 = this.d;
        if ((exoPlayer2 != null ? exoPlayer2.c() : null) != null && (exoPlayer = this.d) != null) {
            exoPlayer.prepare();
        }
        ExoPlayer exoPlayer3 = this.d;
        if (exoPlayer3 != null) {
            exoPlayer3.play();
        }
        com.transsion.player.orplayer.c cVar = this.r;
        if (cVar != null) {
            cVar.g(false);
        }
        com.transsion.player.orplayer.c cVar2 = this.r;
        if (cVar2 != null) {
            cVar2.e();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        sn.e.d(sn.e.a, this.b, "prepare", false, 4, null);
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        sn.e.d(sn.e.a, this.b, "release", false, 4, null);
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        for (com.transsion.player.orplayer.e eVar : this.t) {
            if (eVar != null) {
                e.a.u(eVar, null, 1, null);
            }
        }
        this.t.clear();
        g w = w();
        if (w != null) {
            w.p();
        }
        this.e = null;
        com.transsion.player.orplayer.c cVar = this.r;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void release(String str) {
        f.a.j(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean removeDataSource(gn.e eVar) {
        t.h hVar;
        Intrinsics.h(eVar, "mediaSource");
        ExoPlayer exoPlayer = this.d;
        int G = exoPlayer != null ? exoPlayer.G() : 0;
        int i = 0;
        while (true) {
            if (i >= G) {
                i = -1;
                break;
            }
            ExoPlayer exoPlayer2 = this.d;
            Object obj = null;
            t O = exoPlayer2 != null ? exoPlayer2.O(i) : null;
            if (O != null && (hVar = O.b) != null) {
                obj = hVar.h;
            }
            if (Intrinsics.c(obj, eVar.e())) {
                sn.e.d(sn.e.a, this.b, "removeDataSource 在列表里 index:" + i + " key:" + eVar.e(), false, 4, null);
                break;
            }
            i++;
        }
        if (i < 0) {
            return false;
        }
        g w = w();
        String str = BuildConfig.FLAVOR;
        if (w != null) {
            String e = eVar.e();
            if (e == null) {
                e = BuildConfig.FLAVOR;
            }
            w.q(e);
        }
        ExoPlayer exoPlayer3 = this.d;
        if (exoPlayer3 != null) {
            exoPlayer3.F(i);
        }
        Map map = this.c;
        String e2 = eVar.e();
        if (e2 != null) {
            str = e2;
        }
        map.remove(str);
        return true;
    }

    @Override // com.transsion.player.orplayer.f
    public void removePlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        f.a.k(this, eVar);
        sn.e.f(sn.e.a, this.b, "removePlayerListener", false, 4, null);
        this.t.remove(eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return f.a.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        sn.e.d(sn.e.a, this.b, "reset    ", false, 4, null);
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        for (com.transsion.player.orplayer.e eVar : this.t) {
            if (eVar != null) {
                eVar.onPlayerReset();
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j) {
        ExoPlayer exoPlayer;
        sn.e.d(sn.e.a, this.b, "seekTo    mills:" + j, false, 4, null);
        ExoPlayer exoPlayer2 = this.d;
        if ((exoPlayer2 != null ? exoPlayer2.c() : null) != null && (exoPlayer = this.d) != null) {
            exoPlayer.prepare();
        }
        ExoPlayer exoPlayer3 = this.d;
        if (exoPlayer3 != null) {
            exoPlayer3.seekTo(j);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String str, long j) {
        ExoPlayer exoPlayer;
        t O;
        t.h hVar;
        Intrinsics.h(str, "uuid");
        f.a.m(this, str, j);
        ExoPlayer exoPlayer2 = this.d;
        int G = exoPlayer2 != null ? exoPlayer2.G() : 0;
        for (int i = 0; i < G; i++) {
            ExoPlayer exoPlayer3 = this.d;
            if (Intrinsics.c((exoPlayer3 == null || (O = exoPlayer3.O(i)) == null || (hVar = O.b) == null) ? null : hVar.h, str)) {
                ExoPlayer exoPlayer4 = this.d;
                if ((exoPlayer4 != null ? exoPlayer4.c() : null) != null) {
                    prepare();
                }
                ExoPlayer exoPlayer5 = this.d;
                if (exoPlayer5 == null || exoPlayer5.u() != i) {
                    sn.e.d(sn.e.a, this.b, "seekTo  index:" + i + " uuid:" + str, false, 4, null);
                    ExoPlayer exoPlayer6 = this.d;
                    if (exoPlayer6 != null) {
                        exoPlayer6.seekTo(i, j);
                    }
                } else {
                    if (isComplete() && (exoPlayer = this.d) != null) {
                        exoPlayer.seekTo(j);
                    }
                    sn.e.d(sn.e.a, this.b, "seekTo   uuid:" + str + " mills:" + j + "  是当前视频直接播放", false, 4, null);
                }
                play();
                return;
            }
        }
        sn.e.d(sn.e.a, this.b, "seekTo   uuid:" + str + " mills:" + j + "  没有找到", false, 4, null);
        pause();
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z) {
        this.i = z;
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(gn.e eVar) {
        ExoPlayer exoPlayer;
        Intrinsics.h(eVar, "mediaSource");
        this.e = eVar;
        if (A(eVar)) {
            androidx.media3.exoplayer.source.r s = s(eVar);
            if (s != null && (exoPlayer = this.d) != null) {
                exoPlayer.U(s);
            }
        } else {
            ExoPlayer exoPlayer2 = this.d;
            if (exoPlayer2 != null) {
                exoPlayer2.I(r(eVar));
            }
        }
        for (com.transsion.player.orplayer.e eVar2 : this.t) {
            if (eVar2 != null) {
                eVar2.onSetDataSource();
            }
        }
        sn.e.d(sn.e.a, this.b, "setDataSource", false, 4, null);
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z) {
        this.j = z;
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.setRepeatMode(z ? 1 : 0);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z) {
        this.k = z;
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.B(z, 1);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(hn.d dVar) {
        f.a.n(this, dVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        addPlayerListener(eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        RenderScaleMode renderScaleMode;
        Intrinsics.h(scaleMode, "scaleMode");
        f.a.o(this, scaleMode);
        this.m = scaleMode;
        int i = a.a[scaleMode.ordinal()];
        if (i == 1) {
            renderScaleMode = RenderScaleMode.SCREEN_SCALE_MATCH_PARENT;
        } else if (i == 2) {
            renderScaleMode = RenderScaleMode.SCREEN_SCALE_DEFAULT;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            renderScaleMode = RenderScaleMode.SCREEN_SCALE_CENTER_CROP;
        }
        TextureRenderView textureRenderView = this.g;
        if (textureRenderView != null) {
            textureRenderView.setScaleType(renderScaleMode);
        }
        SurfaceRenderView surfaceRenderView = this.f;
        if (surfaceRenderView != null) {
            surfaceRenderView.setScaleType(renderScaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f) {
        this.l = f;
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.a(f);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
        this.f = surfaceView instanceof SurfaceRenderView ? (SurfaceRenderView) surfaceView : null;
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        this.g = textureView instanceof TextureRenderView ? (TextureRenderView) textureView : null;
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.setVideoTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setVipResolution(boolean z, int i) {
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f) {
        this.h = Float.valueOf(f);
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.setVolume(f);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        com.transsion.player.orplayer.c cVar = this.r;
        if (cVar != null) {
            cVar.g(true);
        }
        sn.e.d(sn.e.a, this.b, "stop    ", false, 4, null);
        ExoPlayer exoPlayer = this.d;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        com.transsion.player.orplayer.c cVar2 = this.r;
        if (cVar2 != null) {
            cVar2.b();
        }
    }
}
