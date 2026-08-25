package com.transsion.audio.player;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorCode;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.nativeclass.CacheConfig;
import com.aliyun.player.nativeclass.TrackInfo;
import com.aliyun.player.source.UrlSource;
import com.blankj.utilcode.util.Utils;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.p003enum.ScaleMode;
import java.io.File;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l implements com.transsion.player.orplayer.f {
    private final String a = "OrAudioPlayer";
    private AliPlayer b;
    private com.transsion.player.orplayer.c c;
    private com.transsion.player.orplayer.e d;
    private boolean e;
    private boolean f;

    public static final class a implements com.transsion.player.orplayer.d {
        a() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            AliPlayer aliPlayer = l.this.b;
            if (aliPlayer != null) {
                return aliPlayer.isMute();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            AliPlayer aliPlayer = l.this.b;
            if (aliPlayer != null) {
                aliPlayer.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            AliPlayer aliPlayer = l.this.b;
            if (aliPlayer != null) {
                aliPlayer.start();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f) {
            AliPlayer aliPlayer = l.this.b;
            if (aliPlayer != null) {
                aliPlayer.setVolume(f);
            }
        }
    }

    public static final class b implements IPlayer.OnLoadingStatusListener {
        b() {
        }

        public void onLoadingBegin() {
            a.a.f(wf.a.a, l.this.a, "onLoadingBegin--->", false, 4, (Object) null);
            com.transsion.player.orplayer.e eVar = l.this.d;
            if (eVar != null) {
                e.a.j(eVar, null, 1, null);
            }
        }

        public void onLoadingEnd() {
            a.a.f(wf.a.a, l.this.a, "onLoadingEnd----->", false, 4, (Object) null);
            com.transsion.player.orplayer.e eVar = l.this.d;
            if (eVar != null) {
                e.a.l(eVar, null, 1, null);
            }
        }

        public void onLoadingProgress(int i, float f) {
            a.a.f(wf.a.a, l.this.a, "onLoadingProgress percent:" + i + ",netSpeed:" + f, false, 4, (Object) null);
            com.transsion.player.orplayer.e eVar = l.this.d;
            if (eVar != null) {
                e.a.n(eVar, i, f, null, 4, null);
            }
        }
    }

    public static final class c implements IPlayer.OnTrackChangedListener {
        c() {
        }

        public void onChangedFail(TrackInfo trackInfo, ErrorInfo errorInfo) {
        }

        public void onChangedSuccess(TrackInfo trackInfo) {
        }
    }

    public l(Context context) {
        o(context);
    }

    private final void A() {
        if (hn.b.a.c()) {
            CacheConfig cacheConfig = new CacheConfig();
            cacheConfig.mEnable = true;
            cacheConfig.mMaxDurationS = 1200L;
            File externalCacheDir = Utils.a().getExternalCacheDir();
            String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
            cacheConfig.mDir = absolutePath + File.separator + "video_cache";
            cacheConfig.mMaxSizeMB = 50;
            AliPlayer aliPlayer = this.b;
            if (aliPlayer != null) {
                aliPlayer.setCacheConfig(cacheConfig);
            }
        }
    }

    private final void o(Context context) {
        if (this.b == null) {
            AliPlayer createAliPlayer = AliPlayerFactory.createAliPlayer(context);
            createAliPlayer.setTraceId(tg.b.a.h());
            this.b = createAliPlayer;
            p();
            A();
            r();
        }
    }

    private final void p() {
        this.c = new com.transsion.player.orplayer.c(new a(), new Function1() { // from class: com.transsion.audio.player.c
            public final Object invoke(Object obj) {
                Unit q;
                q = l.q(l.this, ((Boolean) obj).booleanValue());
                return q;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(l lVar, boolean z) {
        com.transsion.player.orplayer.e eVar = lVar.d;
        if (eVar != null) {
            eVar.onFocusChange(z);
        }
        return Unit.a;
    }

    private final void r() {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setOnCompletionListener(new IPlayer.OnCompletionListener() { // from class: com.transsion.audio.player.d
                public final void onCompletion() {
                    l.s();
                }
            });
        }
        AliPlayer aliPlayer2 = this.b;
        if (aliPlayer2 != null) {
            aliPlayer2.setOnErrorListener(new IPlayer.OnErrorListener() { // from class: com.transsion.audio.player.e
                public final void onError(ErrorInfo errorInfo) {
                    l.t(l.this, errorInfo);
                }
            });
        }
        AliPlayer aliPlayer3 = this.b;
        if (aliPlayer3 != null) {
            aliPlayer3.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.transsion.audio.player.f
                public final void onPrepared() {
                    l.u(l.this);
                }
            });
        }
        AliPlayer aliPlayer4 = this.b;
        if (aliPlayer4 != null) {
            aliPlayer4.setOnVideoSizeChangedListener(new IPlayer.OnVideoSizeChangedListener() { // from class: com.transsion.audio.player.g
                public final void onVideoSizeChanged(int i, int i2) {
                    l.v(l.this, i, i2);
                }
            });
        }
        AliPlayer aliPlayer5 = this.b;
        if (aliPlayer5 != null) {
            aliPlayer5.setOnRenderingStartListener(new IPlayer.OnRenderingStartListener() { // from class: com.transsion.audio.player.h
                public final void onRenderingStart() {
                    l.w(l.this);
                }
            });
        }
        AliPlayer aliPlayer6 = this.b;
        if (aliPlayer6 != null) {
            aliPlayer6.setOnInfoListener(new IPlayer.OnInfoListener() { // from class: com.transsion.audio.player.i
                public final void onInfo(InfoBean infoBean) {
                    l.x(l.this, infoBean);
                }
            });
        }
        AliPlayer aliPlayer7 = this.b;
        if (aliPlayer7 != null) {
            aliPlayer7.setOnLoadingStatusListener(new b());
        }
        AliPlayer aliPlayer8 = this.b;
        if (aliPlayer8 != null) {
            aliPlayer8.setOnSeekCompleteListener(new IPlayer.OnSeekCompleteListener() { // from class: com.transsion.audio.player.j
                public final void onSeekComplete() {
                    l.y();
                }
            });
        }
        AliPlayer aliPlayer9 = this.b;
        if (aliPlayer9 != null) {
            aliPlayer9.setOnTrackChangedListener(new c());
        }
        AliPlayer aliPlayer10 = this.b;
        if (aliPlayer10 != null) {
            aliPlayer10.setOnStateChangedListener(new IPlayer.OnStateChangedListener() { // from class: com.transsion.audio.player.k
                public final void onStateChanged(int i) {
                    l.z(l.this, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(l lVar, ErrorInfo errorInfo) {
        a.a.f(wf.a.a, lVar.a, "onError code:" + errorInfo.getCode() + ",msg:" + errorInfo.getMsg(), false, 4, (Object) null);
        PlayError playError = new PlayError(Integer.valueOf(errorInfo.getCode().getValue()), errorInfo.getMsg());
        com.transsion.player.orplayer.e eVar = lVar.d;
        if (eVar != null) {
            e.a.r(eVar, playError, null, 2, null);
        }
        if (errorInfo.getCode() == ErrorCode.ERROR_DECODE_AUDIO) {
            lVar.prepare();
            lVar.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(l lVar) {
        com.transsion.player.orplayer.e eVar = lVar.d;
        if (eVar != null) {
            e.a.x(eVar, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(l lVar, int i, int i2) {
        com.transsion.player.orplayer.e eVar = lVar.d;
        if (eVar != null) {
            eVar.onVideoSizeChanged(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(l lVar) {
        com.transsion.player.orplayer.e eVar = lVar.d;
        if (eVar != null) {
            eVar.onRenderFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(l lVar, InfoBean infoBean) {
        if (infoBean.getCode() == InfoCode.CurrentPosition) {
            long extraValue = infoBean.getExtraValue();
            com.transsion.player.orplayer.e eVar = lVar.d;
            if (eVar != null) {
                e.a.z(eVar, extraValue, null, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(l lVar, int i) {
        com.transsion.player.orplayer.e eVar;
        a.a.f(wf.a.a, lVar.a, "setOnStateChangedListener status:" + i, false, 4, (Object) null);
        boolean z = i == 3;
        lVar.e = z;
        com.transsion.player.orplayer.e eVar2 = lVar.d;
        if (eVar2 != null) {
            eVar2.onIsPlayingChanged(z);
        }
        lVar.f = i == 6;
        com.transsion.player.orplayer.c cVar = lVar.c;
        if (cVar != null) {
            cVar.f(lVar.e);
        }
        if (i == 3) {
            com.transsion.player.orplayer.e eVar3 = lVar.d;
            if (eVar3 != null) {
                e.a.J(eVar3, null, 1, null);
                return;
            }
            return;
        }
        if (i == 4 || i == 5) {
            com.transsion.player.orplayer.e eVar4 = lVar.d;
            if (eVar4 != null) {
                e.a.G(eVar4, null, 1, null);
                return;
            }
            return;
        }
        if (i == 6 && (eVar = lVar.d) != null) {
            e.a.f(eVar, null, 1, null);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(gn.e eVar) {
        return f.b.a(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(com.transsion.player.orplayer.e eVar) {
        f.b.b(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(qn.d dVar, int i) {
        f.b.c(this, dVar, i);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        f.b.d(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        f.b.e(this);
    }

    @Override // com.transsion.player.orplayer.f
    public gn.e currentMediaSource() {
        return f.b.f(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z) {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.enableHardwareDecoder(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public Pair getBitrate() {
        return new Pair(0, 0);
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        return f.b.g(this);
    }

    @Override // com.transsion.player.orplayer.f
    public qn.c getCurrentTracks() {
        return f.b.h(this);
    }

    @Override // com.transsion.player.orplayer.f
    public qn.b getCurrentVideoFormat() {
        return f.b.i(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        return f.b.j(this);
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            return aliPlayer.getDuration();
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
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            return Float.valueOf(aliPlayer.getVolume());
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        return this.f;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        return f.b.m(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            return aliPlayer.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        return this.e;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        return f.b.n(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.pause();
        }
        com.transsion.player.orplayer.c cVar = this.c;
        if (cVar != null) {
            cVar.g(true);
        }
        com.transsion.player.orplayer.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        com.transsion.player.orplayer.c cVar;
        com.transsion.player.orplayer.e eVar = this.d;
        if (eVar != null) {
            eVar.initPlayer();
        }
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
        com.transsion.player.orplayer.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.g(false);
        }
        if (isMute() || (cVar = this.c) == null) {
            return;
        }
        cVar.e();
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        com.transsion.player.orplayer.e eVar = this.d;
        if (eVar != null) {
            e.a.u(eVar, null, 1, null);
        }
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.release();
        }
        this.b = null;
        com.transsion.player.orplayer.c cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
        this.c = null;
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
        f.b.q(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return f.b.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        com.transsion.player.orplayer.e eVar = this.d;
        if (eVar != null) {
            eVar.onPlayerReset();
        }
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.reset();
        }
        com.transsion.player.orplayer.c cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j) {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setMaxAccurateSeekDelta(150000);
        }
        AliPlayer aliPlayer2 = this.b;
        if (aliPlayer2 != null) {
            aliPlayer2.seekTo(j, IPlayer.SeekMode.Accurate);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String str, long j) {
        f.b.s(this, str, j);
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z) {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setAutoPlay(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(gn.e eVar) {
        Intrinsics.h(eVar, "mediaSource");
        UrlSource urlSource = new UrlSource();
        urlSource.setUri(eVar.j());
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setDataSource(urlSource);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z) {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setLoop(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z) {
        f.b.v(this, z);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(hn.d dVar) {
        f.b.w(this, dVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        this.d = eVar;
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        f.b.x(this, scaleMode);
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f) {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setSpeed(f);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
    }

    @Override // com.transsion.player.orplayer.f
    public void setVipResolution(boolean z, int i) {
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f) {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setVolume(f);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        com.transsion.player.orplayer.c cVar;
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
        com.transsion.player.orplayer.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.g(true);
        }
        if (isMute() || (cVar = this.c) == null) {
            return;
        }
        cVar.b();
    }
}
