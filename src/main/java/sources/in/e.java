package in;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.common.g0;
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
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.a;
import androidx.media3.datasource.b;
import androidx.media3.datasource.c;
import androidx.media3.datasource.rtmp.RtmpDataSource;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.b4;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.drm.w;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.source.b0;
import androidx.media3.exoplayer.u2;
import com.transsion.player.exo.ORExoDecoderType;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.p003enum.PlayMimeType;
import com.transsion.player.p003enum.ScaleMode;
import com.transsion.player.ui.render.RenderScaleMode;
import com.transsion.player.ui.render.SurfaceRenderView;
import com.transsion.player.ui.render.TextureRenderView;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import on.f0;
import x1.c;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements com.transsion.player.orplayer.f {
    public static final a C = new a(null);
    private final Runnable A;
    private ScaleMode B;
    private final Context a;
    private final j b;
    private boolean c;
    private boolean d;
    private SurfaceRenderView e;
    private TextureRenderView f;
    private com.transsion.player.orplayer.c g;
    private gn.e h;
    private Float i;
    private boolean j;
    private boolean k;
    private boolean l;
    private float m;
    private int n;
    private int o;
    private boolean p;
    private ExoPlayer q;
    private Boolean r;
    private int s;
    private String t;
    private ORExoDecoderType u;
    private final a0.d v;
    private b4 w;
    private CopyOnWriteArrayList x;
    private u2 y;
    private final Handler z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[PlayMimeType.values().length];
            try {
                iArr[PlayMimeType.DASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayMimeType.HLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[ScaleMode.values().length];
            try {
                iArr2[ScaleMode.SCALE_TO_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    public static final class c extends androidx.media3.exoplayer.util.a {
        c() {
            super("ORExoPlayer");
        }

        public void Z(c.a aVar, i0 i0Var) {
            Intrinsics.h(aVar, "eventTime");
            Intrinsics.h(i0Var, "tracks");
            super.Z(aVar, i0Var);
            e.this.N(aVar, i0Var);
        }

        public void j0(c.a aVar, String str, long j, long j2) {
            Intrinsics.h(aVar, "eventTime");
            Intrinsics.h(str, "decoderName");
            super.j0(aVar, str, j, j2);
            sn.e.a.h("ORExoPlayer", "onExoVideoDecoderInitialize, decoderName:" + str, true);
        }

        public void x(c.a aVar, String str, long j, long j2) {
            Intrinsics.h(aVar, "eventTime");
            Intrinsics.h(str, "decoderName");
            super.x(aVar, str, j, j2);
            sn.e.a.h("ORExoPlayer", "onExoAudioDecoderInitialize, decoderName:" + str, true);
        }
    }

    public static final class d implements a0.d {
        private int a = 1;

        d() {
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
            com.transsion.player.orplayer.c cVar = e.this.g;
            if (cVar != null) {
                cVar.f(z);
            }
            for (com.transsion.player.orplayer.e eVar : e.this.x) {
                if (eVar != null) {
                    eVar.onIsPlayingChanged(z);
                }
            }
            if (z) {
                CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList = e.this.x;
                e eVar2 = e.this;
                for (com.transsion.player.orplayer.e eVar3 : copyOnWriteArrayList) {
                    if (eVar3 != null) {
                        eVar3.onVideoStart(eVar2.h);
                    }
                }
                e.this.z.post(e.this.A);
            } else {
                ExoPlayer exoPlayer = e.this.q;
                if (exoPlayer == null || !exoPlayer.getPlayWhenReady()) {
                    CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList2 = e.this.x;
                    e eVar4 = e.this;
                    for (com.transsion.player.orplayer.e eVar5 : copyOnWriteArrayList2) {
                        if (eVar5 != null) {
                            eVar5.onVideoPause(eVar4.h);
                        }
                    }
                }
                e.this.z.removeCallbacks(e.this.A);
                ExoPlayer exoPlayer2 = e.this.q;
                long duration = exoPlayer2 != null ? exoPlayer2.getDuration() : 0L;
                ExoPlayer exoPlayer3 = e.this.q;
                if (Math.abs(duration - (exoPlayer3 != null ? exoPlayer3.getCurrentPosition() : 0L)) < 2000) {
                    Log.e("ORExoPlayer", "onIsPlayingChanged onCompletion");
                    if (!e.this.p) {
                        e.this.p = true;
                        CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList3 = e.this.x;
                        e eVar6 = e.this;
                        for (com.transsion.player.orplayer.e eVar7 : copyOnWriteArrayList3) {
                            if (eVar7 != null) {
                                eVar7.onCompletion(eVar6.h);
                            }
                        }
                    }
                }
            }
            Log.e("ORExoPlayer", "onIsPlayingChanged:" + z);
        }

        public void onLoadingChanged(boolean z) {
        }

        public void onMediaItemTransition(t tVar, int i) {
            t.h hVar;
            Log.e("ORExoPlayer", "onMediaItemTransition  reason:" + i + " ");
            if (i == 0 || i == 1) {
                for (com.transsion.player.orplayer.e eVar : e.this.x) {
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
            Log.e("ORExoPlayer", "onPlaybackStateChanged  playbackState:" + i + " ");
            if (i == 2) {
                Log.e("ORExoPlayer", "onPlaybackStateChanged STATE_BUFFERING");
                CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList = e.this.x;
                e eVar = e.this;
                for (com.transsion.player.orplayer.e eVar2 : copyOnWriteArrayList) {
                    if (eVar2 != null) {
                        eVar2.onLoadingBegin(eVar.h);
                    }
                }
            } else if (i == 3) {
                if (!e.this.c) {
                    e.this.c = true;
                    e.i(e.this);
                    CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList2 = e.this.x;
                    e eVar3 = e.this;
                    for (com.transsion.player.orplayer.e eVar4 : copyOnWriteArrayList2) {
                        if (eVar4 != null) {
                            eVar4.onPrepare(eVar3.h);
                        }
                    }
                    e.this.O();
                }
                if (this.a == 2) {
                    for (com.transsion.player.orplayer.e eVar5 : e.this.x) {
                        if (eVar5 != null) {
                            e.a.l(eVar5, null, 1, null);
                        }
                    }
                }
            } else if (i == 4 && !e.this.p) {
                e.this.p = true;
                CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList3 = e.this.x;
                e eVar6 = e.this;
                for (com.transsion.player.orplayer.e eVar7 : copyOnWriteArrayList3) {
                    if (eVar7 != null) {
                        eVar7.onCompletion(eVar6.h);
                    }
                }
            }
            this.a = i;
        }

        public void onPlaybackSuppressionReasonChanged(int i) {
        }

        public void onPlayerError(PlaybackException playbackException) {
            gn.e eVar;
            HttpDataSource.InvalidResponseCodeException cause;
            Intrinsics.h(playbackException, MediaItem.MUSIC_FLOAT_STATE_ERROR);
            e.this.c = false;
            if ((playbackException instanceof ExoPlaybackException) && (cause = playbackException.getCause()) != null) {
                e eVar2 = e.this;
                if ((cause instanceof HttpDataSource.InvalidResponseCodeException) && cause.responseCode == 404) {
                    long duration = eVar2.getDuration();
                    long currentPosition = eVar2.getCurrentPosition();
                    if (currentPosition > 0 && duration > 0 && (currentPosition * 1.0f) / duration > 0.99f) {
                        if (eVar2.p) {
                            return;
                        }
                        eVar2.p = true;
                        for (com.transsion.player.orplayer.e eVar3 : eVar2.x) {
                            if (eVar3 != null) {
                                eVar3.onCompletion(eVar2.h);
                            }
                        }
                        return;
                    }
                }
            }
            sn.e eVar4 = sn.e.a;
            eVar4.c("ORExoPlayer", "exo onPlayerError，MimeType:" + e.this.t + ", code:" + playbackException.errorCode + ",msg:" + playbackException.getMessage() + ", cause:" + playbackException.getCause(), true);
            if (e.this.u != ORExoDecoderType.HARDWARE || (eVar = e.this.h) == null || eVar.l() || (playbackException.getCause() instanceof HttpDataSource.InvalidResponseCodeException)) {
                PlayError playError = new PlayError(Integer.valueOf(playbackException.errorCode), playbackException.getMessage() + "|" + playbackException.getCause());
                playError.setExoCause(playbackException.getCause());
                e.i(e.this);
                for (com.transsion.player.orplayer.e eVar5 : e.this.x) {
                    if (eVar5 != null) {
                        e.a.r(eVar5, playError, null, 2, null);
                    }
                }
                return;
            }
            eVar4.c("ORExoPlayer", "exo 硬解失败，切换到软解，MimeType:" + e.this.t + ", code:" + playbackException.errorCode + ",msg:" + playbackException.getMessage(), true);
            gn.e E = e.this.E();
            if (E != null) {
                e eVar6 = e.this;
                eVar6.setDataSource(E);
                eVar6.prepare();
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
            StringBuilder sb = new StringBuilder();
            sb.append("onPositionDiscontinuity: currentWindowIndex=");
            sb.append(i2);
            sb.append(", currentPositionMs=");
            sb.append(j);
            sb.append(", reason=");
            sb.append(i);
            if (i == 1 || i == 2) {
                for (com.transsion.player.orplayer.e eVar3 : e.this.x) {
                    if (eVar3 != null) {
                        eVar3.setOnSeekCompleteListener();
                    }
                }
            }
            CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList = e.this.x;
            e eVar4 = e.this;
            for (com.transsion.player.orplayer.e eVar5 : copyOnWriteArrayList) {
                if (eVar5 != null) {
                    eVar5.onProgress(j, eVar4.h);
                }
            }
        }

        public void onRenderedFirstFrame() {
            if (e.this.d) {
                return;
            }
            e.this.d = true;
            Log.e("ORExoPlayer", "onRenderedFirstFrame:");
            for (com.transsion.player.orplayer.e eVar : e.this.x) {
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
            int c;
            Intrinsics.h(i0Var, "tracks");
            CopyOnWriteArrayList<com.transsion.player.orplayer.e> copyOnWriteArrayList = e.this.x;
            e eVar = e.this;
            for (com.transsion.player.orplayer.e eVar2 : copyOnWriteArrayList) {
                if (eVar2 != null) {
                    eVar2.onTracksChange(qn.a.c(i0Var));
                }
                qn.c c2 = qn.a.c(i0Var);
                StringBuilder sb = new StringBuilder();
                sb.append("changeTrackSelection 所有的分辨率为：");
                sb.append(c2);
                qn.d dVar = null;
                int i = -1;
                boolean z = false;
                int i2 = 0;
                for (qn.d dVar2 : c2.a()) {
                    if (dVar2.e() == 2) {
                        qn.b[] b = dVar2.b();
                        int length = b.length;
                        int i3 = 0;
                        int i4 = 0;
                        while (i3 < length) {
                            qn.b bVar = b[i3];
                            int i5 = i4 + 1;
                            if (!Intrinsics.c(eVar.r, Boolean.FALSE)) {
                                if (bVar.c() >= eVar.s && bVar.c() > i2) {
                                    c = bVar.c();
                                    i2 = c;
                                    i = i4;
                                }
                                z = true;
                            } else if (bVar.c() < eVar.s) {
                                if (bVar.c() > i2) {
                                    c = bVar.c();
                                    i2 = c;
                                    i = i4;
                                }
                                z = true;
                            }
                            i3++;
                            i4 = i5;
                        }
                        dVar = dVar2;
                    }
                }
                if (Intrinsics.c(eVar.r, Boolean.FALSE)) {
                    if (z) {
                        if (dVar != null && eVar2 != null) {
                            eVar2.canNonSubscriberPlay(true, i2, i, dVar);
                        }
                    } else if (dVar != null && eVar2 != null) {
                        eVar2.canNonSubscriberPlay(false, 0, i, dVar);
                    }
                } else if (dVar != null && eVar2 != null) {
                    eVar2.canNonSubscriberPlay(true, i2, i, dVar);
                }
            }
        }

        public void onVideoSizeChanged(m0 m0Var) {
            Intrinsics.h(m0Var, "videoSize");
            SurfaceRenderView surfaceRenderView = e.this.e;
            if (surfaceRenderView != null) {
                surfaceRenderView.setVideoRotation(m0Var.c);
            }
            TextureRenderView textureRenderView = e.this.f;
            if (textureRenderView != null) {
                textureRenderView.setVideoRotation(m0Var.c);
            }
            SurfaceRenderView surfaceRenderView2 = e.this.e;
            if (surfaceRenderView2 != null) {
                surfaceRenderView2.setVideoSize(m0Var.a, m0Var.b);
            }
            TextureRenderView textureRenderView2 = e.this.f;
            if (textureRenderView2 != null) {
                textureRenderView2.setVideoSize(m0Var.a, m0Var.b);
            }
            for (com.transsion.player.orplayer.e eVar : e.this.x) {
                if (eVar != null) {
                    eVar.onVideoSizeChanged(m0Var.a, m0Var.b);
                }
            }
            Log.e("ORExoPlayer", "onVideoSizeChanged width:" + m0Var.a + "  height:" + m0Var.b);
        }

        public void onVolumeChanged(float f) {
        }
    }

    /* renamed from: in.e$e, reason: collision with other inner class name */
    public static final class C0076e implements com.transsion.player.orplayer.d {
        C0076e() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            ExoPlayer exoPlayer = e.this.q;
            if (exoPlayer != null) {
                return exoPlayer.W();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            ExoPlayer exoPlayer = e.this.q;
            if (exoPlayer != null) {
                exoPlayer.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            ExoPlayer exoPlayer = e.this.q;
            if (exoPlayer != null) {
                exoPlayer.play();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f) {
            ExoPlayer exoPlayer = e.this.q;
            if (exoPlayer != null) {
                exoPlayer.setVolume(f);
            }
        }
    }

    public e(Context context, j jVar, boolean z) {
        Intrinsics.h(context, "context");
        Intrinsics.h(jVar, "config");
        this.a = context;
        this.b = jVar;
        this.m = 1.0f;
        this.r = Boolean.FALSE;
        this.s = 720;
        ORExoDecoderType oRExoDecoderType = ORExoDecoderType.HARDWARE;
        this.u = oRExoDecoderType;
        this.v = new d();
        if (z) {
            G();
        }
        F(oRExoDecoderType);
        this.x = new CopyOnWriteArrayList();
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        this.z = new Handler(myLooper);
        this.A = new Runnable() { // from class: in.b
            @Override // java.lang.Runnable
            public final void run() {
                e.P(e.this);
            }
        };
        this.B = ScaleMode.SCALE_TO_FILL;
    }

    public /* synthetic */ e(Context context, j jVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? k.a() : jVar, (i & 4) != 0 ? true : z);
    }

    private final void B(gn.e eVar) {
        a.a factory = new RtmpDataSource.Factory();
        sn.e.a.a("ORExoPlayer", "addRtmpDataSource ", true);
        b0 h = new b0.b(factory).h(t.b(eVar.j()));
        Intrinsics.g(h, "createMediaSource(...)");
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.U(h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.media3.exoplayer.drm.t D(t tVar) {
        return androidx.media3.exoplayer.drm.t.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gn.e E() {
        gn.e eVar = this.h;
        String str = this.t;
        J();
        ORExoDecoderType oRExoDecoderType = Intrinsics.c(str, "video/av01") ? ORExoDecoderType.AV1 : ORExoDecoderType.FFMPEG;
        this.u = oRExoDecoderType;
        sn.e.a.a("ORExoPlayer", "重新创建播放器切换编码, DecoderType:" + oRExoDecoderType + ",MimeTyp:" + str, true);
        F(this.u);
        I();
        return eVar;
    }

    private final void F(ORExoDecoderType oRExoDecoderType) {
        sn.e.a.a("ORExoPlayer", "createPlayer, DecoderType:" + oRExoDecoderType, true);
        this.y = new m.b().b(5000, 20000, 500, 1000).d(-1).c(true).a();
        this.w = in.a.b(this.a, oRExoDecoderType);
        ExoPlayer.b q = new ExoPlayer.b(this.a).q(new androidx.media3.exoplayer.source.i(this.a).q(in.a.d(this.a)));
        b4 b4Var = this.w;
        Intrinsics.e(b4Var);
        ExoPlayer.b r = q.r(b4Var);
        u2 u2Var = this.y;
        Intrinsics.e(u2Var);
        ExoPlayer h = r.p(u2Var).h();
        h.setPlayWhenReady(false);
        h.M(this.v);
        h.D(new c());
        this.q = h;
    }

    private final void G() {
        this.g = new com.transsion.player.orplayer.c(new C0076e(), new Function1() { // from class: in.c
            public final Object invoke(Object obj) {
                Unit H;
                H = e.H(e.this, ((Boolean) obj).booleanValue());
                return H;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(e eVar, boolean z) {
        Iterator it = eVar.x.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onFocusChange(z);
        }
        return Unit.a;
    }

    private final void I() {
        setMute(this.l);
        Float f = this.i;
        if (f != null) {
            setVolume(f.floatValue());
        }
        setLooping(this.k);
        setAutoPlay(this.j);
        setSpeed(this.m);
        SurfaceRenderView surfaceRenderView = this.e;
        if (surfaceRenderView != null) {
            setSurfaceView(surfaceRenderView);
        }
        TextureRenderView textureRenderView = this.f;
        if (textureRenderView != null) {
            setTextureView(textureRenderView);
        }
        setScaleMode(this.B);
    }

    private final void J() {
        this.c = false;
        this.p = false;
        this.d = false;
        Log.e("ORExoPlayer", "innerRelease");
        if (f0.a.a(this)) {
            ExoPlayer exoPlayer = this.q;
            if (exoPlayer != null) {
                exoPlayer.release();
                return;
            }
            return;
        }
        ExoPlayer exoPlayer2 = this.q;
        if (exoPlayer2 != null) {
            exoPlayer2.stop();
        }
        ExoPlayer exoPlayer3 = this.q;
        if (exoPlayer3 != null) {
            exoPlayer3.C();
        }
        ExoPlayer exoPlayer4 = this.q;
        if (exoPlayer4 != null) {
            exoPlayer4.clearVideoSurface();
        }
    }

    private final boolean K(gn.e eVar) {
        PlayMimeType i = eVar.i();
        PlayMimeType playMimeType = PlayMimeType.RTMP;
        if (i == playMimeType) {
            return true;
        }
        String lowerCase = eVar.j().toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (!StringsKt.W(lowerCase, "rtmp://", false, 2, (Object) null)) {
            return false;
        }
        eVar.q(playMimeType);
        return true;
    }

    private final boolean L(gn.e eVar) {
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

    private final void M() {
        this.z.removeCallbacks(this.A);
        this.z.postDelayed(this.A, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(c.a aVar, i0 i0Var) {
        int size = i0Var.a().size();
        for (int i = 0; i < size; i++) {
            Object obj = i0Var.a().get(i);
            Intrinsics.g(obj, "get(...)");
            i0.a aVar2 = (i0.a) obj;
            int i2 = aVar2.a;
            for (int i3 = 0; i3 < i2; i3++) {
                r b2 = aVar2.b(i3);
                Intrinsics.g(b2, "getTrackFormat(...)");
                sn.e eVar = sn.e.a;
                sn.e.i(eVar, "ORExoPlayer", "onGetTracksInfo  MimeType:" + b2.o + "， bitrate：" + b2.j, false, 4, null);
                String str = b2.o;
                if (str != null && StringsKt.c0(str, "video", false, 2, (Object) null)) {
                    String str2 = b2.o;
                    this.t = str2;
                    sn.e.f(eVar, "ORExoPlayer", "--------onGetTracksInfo curVideoMimeType:" + str2, false, 4, null);
                }
            }
        }
        if (this.u == ORExoDecoderType.AV1 || !Intrinsics.c(this.t, "video/av01") || Build.VERSION.SDK_INT > 29) {
            return;
        }
        sn.e.a.c("ORExoPlayer", "exo av1，强制切换到软解， MimeType:" + this.t, true);
        gn.e E = E();
        if (E != null) {
            setDataSource(E);
            prepare();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        i0 currentTracks;
        ExoPlayer exoPlayer;
        r R;
        r J;
        ExoPlayer exoPlayer2 = this.q;
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
                    ExoPlayer exoPlayer3 = this.q;
                    if (exoPlayer3 != null && (J = exoPlayer3.J()) != null) {
                        int i4 = J.j;
                        int i5 = b2.j;
                        if (i4 == i5) {
                            this.n = i5;
                            sn.e.b(sn.e.a, "ORExoPlayer", "--onPrepare2GetBitrate  MimeType:" + b2.o + "，videoBitrate：" + i5, false, 4, null);
                            Iterator it = this.x.iterator();
                            while (it.hasNext()) {
                                ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(this.n);
                            }
                        }
                    }
                } else if (y.o(b2.o) && (exoPlayer = this.q) != null && (R = exoPlayer.R()) != null) {
                    int i6 = R.j;
                    int i7 = b2.j;
                    if (i6 == i7) {
                        this.o = i7;
                        sn.e.b(sn.e.a, "ORExoPlayer", "--onPrepare2GetBitrate  MimeType:" + b2.o + "，audioBitrate：" + i7, false, 4, null);
                        Iterator it2 = this.x.iterator();
                        while (it2.hasNext()) {
                            ((com.transsion.player.orplayer.e) it2.next()).onTracksAudioBitrateChange(this.o);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(e eVar) {
        ExoPlayer exoPlayer = eVar.q;
        if (exoPlayer == null || exoPlayer.isPlaying()) {
            ExoPlayer exoPlayer2 = eVar.q;
            long currentPosition = exoPlayer2 != null ? exoPlayer2.getCurrentPosition() : 0L;
            Iterator it = eVar.x.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onProgress(currentPosition, eVar.h);
            }
            eVar.M();
        }
    }

    public static final /* synthetic */ on.z i(e eVar) {
        eVar.getClass();
        return null;
    }

    public final boolean C(gn.e eVar) {
        c.b aVar;
        HlsMediaSource.Factory factory;
        Intrinsics.h(eVar, "mediaSource");
        String g = eVar.g();
        if (g == null) {
            g = eVar.j();
        }
        t a2 = new t.c().j(g).d(String.valueOf(eVar.k())).b(eVar.f()).h(eVar.e()).a();
        Intrinsics.g(a2, "build(...)");
        if (StringsKt.W(g, "http", false, 2, (Object) null)) {
            aVar = new c.b();
            Map d2 = eVar.d();
            if (d2 != null) {
                aVar.b(d2);
            }
        } else {
            aVar = new b.a(this.a);
        }
        PlayMimeType i = eVar.i();
        StringBuilder sb = new StringBuilder();
        sb.append("dash addStreamDataSource, mimeType:");
        sb.append(i);
        int i2 = b.a[eVar.i().ordinal()];
        if (i2 == 1) {
            factory = new DashMediaSource.Factory(aVar);
        } else {
            if (i2 != 2) {
                return false;
            }
            factory = new HlsMediaSource.Factory(aVar);
        }
        androidx.media3.exoplayer.source.r d3 = factory.e(new w() { // from class: in.d
            public final androidx.media3.exoplayer.drm.t a(t tVar) {
                androidx.media3.exoplayer.drm.t D;
                D = e.D(tVar);
                return D;
            }
        }).d(a2);
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.U(d3);
        }
        this.h = eVar;
        return true;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(gn.e eVar) {
        return f.b.a(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        f.b.b(this, eVar);
        if (this.x.contains(eVar)) {
            return;
        }
        this.x.add(eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(qn.d dVar, int i) {
        i0 currentTracks;
        androidx.media3.common.f0 a2;
        Intrinsics.h(dVar, "mediaTrackGroup");
        int length = dVar.b().length;
        if (i < 0 || i >= length) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            this.n = dVar.b()[i].a();
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(this.n);
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        int i2 = this.n;
        StringBuilder sb = new StringBuilder();
        sb.append("changeTrackSelection  mediaTrackGroup:");
        sb.append(dVar);
        sb.append("  index:");
        sb.append(i);
        sb.append(", videoBitrate:");
        sb.append(i2);
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer == null || (currentTracks = exoPlayer.getCurrentTracks()) == null || (a2 = qn.a.a(currentTracks, dVar)) == null) {
            return;
        }
        ExoPlayer exoPlayer2 = this.q;
        Intrinsics.e(exoPlayer2);
        ExoPlayer exoPlayer3 = this.q;
        Intrinsics.e(exoPlayer3);
        exoPlayer2.V(exoPlayer3.m().a().L(new g0(a2, i)).F());
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        SurfaceTexture surfaceTexture;
        SurfaceHolder holder;
        Surface surface;
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.setVideoSurfaceView((SurfaceView) null);
        }
        ExoPlayer exoPlayer2 = this.q;
        if (exoPlayer2 != null) {
            exoPlayer2.setVideoTextureView((TextureView) null);
        }
        SurfaceRenderView surfaceRenderView = this.e;
        if (surfaceRenderView != null && (holder = surfaceRenderView.getHolder()) != null && (surface = holder.getSurface()) != null) {
            surface.release();
        }
        TextureRenderView textureRenderView = this.f;
        if (textureRenderView == null || (surfaceTexture = textureRenderView.getSurfaceTexture()) == null) {
            return;
        }
        surfaceTexture.release();
    }

    @Override // com.transsion.player.orplayer.f
    public gn.e currentMediaSource() {
        return this.h;
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z) {
        if (!z && this.u == ORExoDecoderType.HARDWARE) {
            sn.e.a.a("ORExoPlayer", "1-硬解切到软解，重新创建设置", true);
            E();
        } else if (z) {
            ORExoDecoderType oRExoDecoderType = this.u;
            ORExoDecoderType oRExoDecoderType2 = ORExoDecoderType.HARDWARE;
            if (oRExoDecoderType != oRExoDecoderType2) {
                this.u = oRExoDecoderType2;
                sn.e.a.a("ORExoPlayer", "2-软解切换到硬解，重新创建设置", true);
                F(this.u);
                I();
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public Pair getBitrate() {
        return new Pair(Integer.valueOf(this.n), Integer.valueOf(this.o));
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            return exoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public qn.c getCurrentTracks() {
        i0 currentTracks;
        qn.c c2;
        ExoPlayer exoPlayer = this.q;
        return (exoPlayer == null || (currentTracks = exoPlayer.getCurrentTracks()) == null || (c2 = qn.a.c(currentTracks)) == null) ? new qn.c(null, 1, null) : c2;
    }

    @Override // com.transsion.player.orplayer.f
    public qn.b getCurrentVideoFormat() {
        r J;
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer == null || (J = exoPlayer.J()) == null) {
            return null;
        }
        return qn.a.b(J);
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        return f.b.j(this);
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            return exoPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        return f.b.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        return f.b.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        return this.i;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        ExoPlayer exoPlayer = this.q;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 4;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        return f.b.m(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            return exoPlayer.W();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            return exoPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        ExoPlayer exoPlayer = this.q;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 3;
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        com.transsion.player.orplayer.c cVar = this.g;
        if (cVar != null) {
            cVar.g(true);
        }
        Log.e("ORExoPlayer", MediaItem.MUSIC_FLOAT_STATE_PAUSE);
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
        ExoPlayer exoPlayer2 = this.q;
        if (exoPlayer2 != null) {
            exoPlayer2.getPlayWhenReady();
        }
        com.transsion.player.orplayer.c cVar2 = this.g;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        ExoPlayer exoPlayer;
        Log.e("ORExoPlayer", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        ExoPlayer exoPlayer2 = this.q;
        if ((exoPlayer2 != null ? exoPlayer2.c() : null) != null && (exoPlayer = this.q) != null) {
            exoPlayer.prepare();
        }
        ExoPlayer exoPlayer3 = this.q;
        if (exoPlayer3 != null) {
            exoPlayer3.play();
        }
        com.transsion.player.orplayer.c cVar = this.g;
        if (cVar != null) {
            cVar.g(false);
        }
        com.transsion.player.orplayer.c cVar2 = this.g;
        if (cVar2 != null) {
            cVar2.e();
        }
        this.p = false;
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        Log.e("ORExoPlayer", "prepare");
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.prepare();
        }
        this.p = false;
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        this.c = false;
        this.p = false;
        this.d = false;
        Log.e("ORExoPlayer", "release");
        if (f0.a.a(this)) {
            ExoPlayer exoPlayer = this.q;
            if (exoPlayer != null) {
                exoPlayer.release();
            }
        } else {
            ExoPlayer exoPlayer2 = this.q;
            if (exoPlayer2 != null) {
                exoPlayer2.stop();
            }
            ExoPlayer exoPlayer3 = this.q;
            if (exoPlayer3 != null) {
                exoPlayer3.C();
            }
            ExoPlayer exoPlayer4 = this.q;
            if (exoPlayer4 != null) {
                exoPlayer4.clearVideoSurface();
            }
        }
        for (com.transsion.player.orplayer.e eVar : this.x) {
            if (eVar != null) {
                eVar.onPlayerRelease(this.h);
            }
        }
        com.transsion.player.orplayer.c cVar = this.g;
        if (cVar != null) {
            cVar.b();
        }
        this.t = null;
        this.u = ORExoDecoderType.HARDWARE;
        this.h = null;
    }

    @Override // com.transsion.player.orplayer.f
    public void release(String str) {
        f.b.o(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean removeDataSource(gn.e eVar) {
        return f.b.p(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void removePlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        f.b.q(this, eVar);
        this.x.remove(eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return f.b.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        Log.e("ORExoPlayer", "reset    ");
        this.c = false;
        this.p = false;
        this.d = false;
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        ExoPlayer exoPlayer2 = this.q;
        if (exoPlayer2 != null) {
            exoPlayer2.C();
        }
        this.u = ORExoDecoderType.HARDWARE;
        this.h = null;
        for (com.transsion.player.orplayer.e eVar : this.x) {
            if (eVar != null) {
                eVar.onPlayerReset();
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j) {
        ExoPlayer exoPlayer;
        Log.e("ORExoPlayer", "seekTo    mills:" + j);
        this.p = false;
        ExoPlayer exoPlayer2 = this.q;
        if ((exoPlayer2 != null ? exoPlayer2.c() : null) != null && (exoPlayer = this.q) != null) {
            exoPlayer.prepare();
        }
        ExoPlayer exoPlayer3 = this.q;
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
        f.b.s(this, str, j);
        this.p = false;
        ExoPlayer exoPlayer2 = this.q;
        int G = exoPlayer2 != null ? exoPlayer2.G() : 0;
        for (int i = 0; i < G; i++) {
            ExoPlayer exoPlayer3 = this.q;
            if (Intrinsics.c((exoPlayer3 == null || (O = exoPlayer3.O(i)) == null || (hVar = O.b) == null) ? null : hVar.e, str)) {
                ExoPlayer exoPlayer4 = this.q;
                if ((exoPlayer4 != null ? exoPlayer4.c() : null) != null) {
                    prepare();
                }
                ExoPlayer exoPlayer5 = this.q;
                if (exoPlayer5 == null || exoPlayer5.u() != i) {
                    Log.e("ORExoPlayer", "seekTo  index:" + i + " uuid:" + str);
                    ExoPlayer exoPlayer6 = this.q;
                    if (exoPlayer6 != null) {
                        exoPlayer6.seekTo(i, j);
                    }
                } else {
                    if (isComplete() && (exoPlayer = this.q) != null) {
                        exoPlayer.seekTo(j);
                    }
                    Log.e("ORExoPlayer", "seekTo   uuid:" + str + " mills:" + j + "  是当前视频直接播放");
                }
                play();
                return;
            }
        }
        Log.e("ORExoPlayer", "seekTo   uuid:" + str + " mills:" + j + "  没有找到");
        pause();
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z) {
        this.j = z;
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(gn.e eVar) {
        Intrinsics.h(eVar, "mediaSource");
        sn.e.a.a("ORExoPlayer", "setDataSource url:" + eVar.j(), true);
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onSetDataSource();
        }
        if (L(eVar)) {
            C(eVar);
            return;
        }
        if (K(eVar)) {
            B(eVar);
            return;
        }
        t a2 = new t.c().j(eVar.j()).d(String.valueOf(eVar.k())).b(eVar.f()).a();
        Intrinsics.g(a2, "build(...)");
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.I(a2);
        }
        this.h = eVar;
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z) {
        this.k = z;
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.setRepeatMode(z ? 1 : 0);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z) {
        this.l = z;
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.B(z, 1);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(hn.d dVar) {
        f.b.w(this, dVar);
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
        f.b.x(this, scaleMode);
        this.B = scaleMode;
        int i = b.b[scaleMode.ordinal()];
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
        TextureRenderView textureRenderView = this.f;
        if (textureRenderView != null) {
            textureRenderView.setScaleType(renderScaleMode);
        }
        SurfaceRenderView surfaceRenderView = this.e;
        if (surfaceRenderView != null) {
            surfaceRenderView.setScaleType(renderScaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f) {
        this.m = f;
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.a(f);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
        this.e = surfaceView instanceof SurfaceRenderView ? (SurfaceRenderView) surfaceView : null;
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        this.f = textureView instanceof TextureRenderView ? (TextureRenderView) textureView : null;
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.setVideoTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setVipResolution(boolean z, int i) {
        this.r = Boolean.valueOf(z);
        this.s = i;
        StringBuilder sb = new StringBuilder();
        sb.append("LongVideoView 非会员可以播放 vipResolution :");
        sb.append(i);
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f) {
        float k = RangesKt.k(f, 0.0f, 2.0f);
        g gVar = this.w;
        g gVar2 = gVar instanceof g ? gVar : null;
        if (gVar2 != null) {
            gVar2.s(k);
        }
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.setVolume(k);
        }
        this.i = Float.valueOf(k);
        StringBuilder sb = new StringBuilder();
        sb.append("setVolume  volume:");
        sb.append(f);
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        Log.e("ORExoPlayer", "stop    ");
        com.transsion.player.orplayer.c cVar = this.g;
        if (cVar != null) {
            cVar.g(true);
        }
        ExoPlayer exoPlayer = this.q;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        this.c = false;
        this.p = false;
        this.d = false;
        com.transsion.player.orplayer.c cVar2 = this.g;
        if (cVar2 != null) {
            cVar2.b();
        }
    }
}
