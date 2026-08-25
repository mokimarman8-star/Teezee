package com.transsion.player.orplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.AliPlayerGlobalSettings;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorCode;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.nativeclass.CacheConfig;
import com.aliyun.player.nativeclass.MediaInfo;
import com.aliyun.player.nativeclass.PlayerConfig;
import com.aliyun.player.nativeclass.TrackInfo;
import com.aliyun.player.source.UrlSource;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.q;
import com.transsion.player.p003enum.ScaleMode;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import sn.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q implements f {
    private final String a;
    private AliPlayer b;
    private com.transsion.player.orplayer.c c;
    private com.transsion.player.orplayer.e d;
    private String e;
    private gn.e f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private CopyOnWriteArrayList l;
    private Context m;
    private long n;
    private int o;
    private int p;
    private boolean q;
    private volatile boolean r;
    private Handler s;
    private final d t;
    private TextureView u;
    private SurfaceView v;
    private final e w;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[TrackInfo.Type.values().length];
            try {
                iArr[TrackInfo.Type.TYPE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrackInfo.Type.TYPE_AUDIO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[ScaleMode.values().length];
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ScaleMode.SCALE_TO_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    public static final class b implements com.transsion.player.orplayer.d {
        b() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            AliPlayer aliPlayer = q.this.b;
            if (aliPlayer != null) {
                return aliPlayer.isMute();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            AliPlayer aliPlayer = q.this.b;
            if (aliPlayer != null) {
                aliPlayer.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            AliPlayer aliPlayer = q.this.b;
            if (aliPlayer != null) {
                aliPlayer.start();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f) {
            AliPlayer aliPlayer = q.this.b;
            if (aliPlayer != null) {
                aliPlayer.setVolume(f);
            }
        }
    }

    public static final class c implements IPlayer.OnLoadingStatusListener {
        c() {
        }

        public void onLoadingBegin() {
            if (q.this.r) {
                return;
            }
            String unused = q.this.a;
            q.this.h = true;
            com.transsion.player.orplayer.e eVar = q.this.d;
            if (eVar != null) {
                eVar.onLoadingBegin(q.this.f);
            }
            CopyOnWriteArrayList copyOnWriteArrayList = q.this.l;
            q qVar = q.this;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onLoadingBegin(qVar.f);
            }
        }

        public void onLoadingEnd() {
            if (q.this.r) {
                return;
            }
            String unused = q.this.a;
            q.this.h = false;
            com.transsion.player.orplayer.e eVar = q.this.d;
            if (eVar != null) {
                eVar.onLoadingEnd(q.this.f);
            }
            CopyOnWriteArrayList copyOnWriteArrayList = q.this.l;
            q qVar = q.this;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onLoadingEnd(qVar.f);
            }
        }

        public void onLoadingProgress(int i, float f) {
            String unused = q.this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("onLoadingProgress percent:");
            sb.append(i);
            sb.append(",netSpeed:");
            sb.append(f);
        }
    }

    public static final class d implements SurfaceHolder.Callback {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(q qVar) {
            AliPlayer aliPlayer = qVar.b;
            if (aliPlayer != null) {
                aliPlayer.surfaceChanged();
            }
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(SurfaceHolder surfaceHolder, q qVar) {
            AliPlayer aliPlayer;
            Surface surface = surfaceHolder.getSurface();
            if (!surface.isValid() || (aliPlayer = qVar.b) == null) {
                return;
            }
            aliPlayer.setSurface(surface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(q qVar) {
            AliPlayer aliPlayer = qVar.b;
            if (aliPlayer != null) {
                aliPlayer.setSurface((Surface) null);
            }
            return Unit.a;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Intrinsics.h(surfaceHolder, "holder");
            final q qVar = q.this;
            qVar.H(new Function0() { // from class: com.transsion.player.orplayer.t
                public final Object invoke() {
                    Unit d;
                    d = q.d.d(q.this);
                    return d;
                }
            });
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(final SurfaceHolder surfaceHolder) {
            Intrinsics.h(surfaceHolder, "holder");
            Handler handler = q.this.s;
            if (handler != null) {
                final q qVar = q.this;
                handler.post(new Runnable() { // from class: com.transsion.player.orplayer.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.d.e(surfaceHolder, qVar);
                    }
                });
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Intrinsics.h(surfaceHolder, "holder");
            final q qVar = q.this;
            qVar.H(new Function0() { // from class: com.transsion.player.orplayer.s
                public final Object invoke() {
                    Unit f;
                    f = q.d.f(q.this);
                    return f;
                }
            });
        }
    }

    public static final class e implements TextureView.SurfaceTextureListener {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(SurfaceTexture surfaceTexture, q qVar) {
            AliPlayer aliPlayer;
            Surface surface = new Surface(surfaceTexture);
            if (surface.isValid() && (aliPlayer = qVar.b) != null) {
                aliPlayer.setSurface(surface);
            }
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(q qVar) {
            AliPlayer aliPlayer = qVar.b;
            if (aliPlayer != null) {
                aliPlayer.setSurface((Surface) null);
            }
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(q qVar) {
            AliPlayer aliPlayer = qVar.b;
            if (aliPlayer != null) {
                aliPlayer.surfaceChanged();
            }
            return Unit.a;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, int i, int i2) {
            Intrinsics.h(surfaceTexture, "surfaceTexture");
            final q qVar = q.this;
            qVar.H(new Function0() { // from class: com.transsion.player.orplayer.v
                public final Object invoke() {
                    Unit d;
                    d = q.e.d(surfaceTexture, qVar);
                    return d;
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Intrinsics.h(surfaceTexture, "surface");
            final q qVar = q.this;
            qVar.H(new Function0() { // from class: com.transsion.player.orplayer.w
                public final Object invoke() {
                    Unit e;
                    e = q.e.e(q.this);
                    return e;
                }
            });
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Intrinsics.h(surfaceTexture, "surface");
            final q qVar = q.this;
            qVar.H(new Function0() { // from class: com.transsion.player.orplayer.u
                public final Object invoke() {
                    Unit f;
                    f = q.e.f(q.this);
                    return f;
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Intrinsics.h(surfaceTexture, "surface");
        }
    }

    public q(Context context, hn.d dVar) {
        Intrinsics.h(context, "context");
        this.a = "ORPlayerImpl";
        this.e = BuildConfig.FLAVOR;
        this.l = new CopyOnWriteArrayList();
        this.t = new d();
        this.w = new e();
        this.m = context;
        AliPlayer createAliPlayer = AliPlayerFactory.createAliPlayer(context);
        createAliPlayer.setTraceId(dVar != null ? dVar.o() : null);
        createAliPlayer.enableHardwareDecoder(dVar != null ? dVar.e() : true);
        this.b = createAliPlayer;
        if (dVar == null || dVar.i()) {
            x();
        }
        setPlayerConfig(dVar == null ? hn.b.a.a() : dVar);
        z(dVar != null ? dVar.j() : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(q qVar, ErrorInfo errorInfo) {
        if (qVar.r) {
            return;
        }
        ErrorCode code = errorInfo.getCode();
        String msg = errorInfo.getMsg();
        StringBuilder sb = new StringBuilder();
        sb.append("onError code:");
        sb.append(code);
        sb.append(",msg:");
        sb.append(msg);
        PlayError playError = new PlayError(Integer.valueOf(errorInfo.getCode().getValue()), errorInfo.getMsg());
        if (qVar.w(playError)) {
            return;
        }
        com.transsion.player.orplayer.e eVar = qVar.d;
        if (eVar != null) {
            eVar.onPlayError(playError, qVar.f);
        }
        Iterator it = qVar.l.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayError(playError, qVar.f);
        }
        if (errorInfo.getCode() == ErrorCode.ERROR_DECODE_AUDIO) {
            qVar.prepare();
            qVar.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(q qVar) {
        if (qVar.r) {
            return;
        }
        qVar.k = true;
        if (qVar.q && qVar.n > 0) {
            sn.e.a.a(qVar.a, "aliyun onPrepare 内部的解码切换，已有播放进度，直接播放", true);
            qVar.seekTo(qVar.n);
            qVar.play();
        } else {
            com.transsion.player.orplayer.e eVar = qVar.d;
            if (eVar != null) {
                eVar.onPrepare(qVar.f);
            }
            Iterator it = qVar.l.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onPrepare(qVar.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(q qVar, InfoBean infoBean) {
        if (qVar.r) {
            return;
        }
        long extraValue = infoBean.getExtraValue();
        if (infoBean.getCode() == InfoCode.CurrentPosition) {
            qVar.n = extraValue;
            com.transsion.player.orplayer.e eVar = qVar.d;
            if (eVar != null) {
                eVar.onProgress(extraValue, qVar.f);
            }
            Iterator it = qVar.l.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onProgress(extraValue, qVar.f);
            }
        }
        if (infoBean.getCode() == InfoCode.LoopingStart) {
            com.transsion.player.orplayer.e eVar2 = qVar.d;
            if (eVar2 != null) {
                eVar2.onLoopingStart();
            }
            Iterator it2 = qVar.l.iterator();
            while (it2.hasNext()) {
                ((com.transsion.player.orplayer.e) it2.next()).onLoopingStart();
            }
        }
        if (infoBean.getCode() == InfoCode.BufferedPosition) {
            com.transsion.player.orplayer.e eVar3 = qVar.d;
            if (eVar3 != null) {
                eVar3.onBufferedPosition(extraValue, qVar.f);
            }
            Iterator it3 = qVar.l.iterator();
            while (it3.hasNext()) {
                ((com.transsion.player.orplayer.e) it3.next()).onBufferedPosition(extraValue, qVar.f);
            }
        }
        if (infoBean.getCode() == InfoCode.SwitchToSoftwareVideoDecoder) {
            sn.e.a.e(qVar.a, "aliyun 硬解失败，自动切换到软件", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(q qVar, int i) {
        if (qVar.r) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("setOnStateChangedListener status:");
        sb.append(i);
        boolean z = i == 3;
        qVar.g = z;
        com.transsion.player.orplayer.e eVar = qVar.d;
        if (eVar != null) {
            eVar.onIsPlayingChanged(z);
        }
        Iterator it = qVar.l.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onIsPlayingChanged(qVar.g);
        }
        qVar.j = i == 6;
        com.transsion.player.orplayer.c cVar = qVar.c;
        if (cVar != null) {
            cVar.f(qVar.g);
        }
        if (i == 3) {
            com.transsion.player.orplayer.e eVar2 = qVar.d;
            if (eVar2 != null) {
                eVar2.onVideoStart(qVar.f);
            }
            Iterator it2 = qVar.l.iterator();
            while (it2.hasNext()) {
                ((com.transsion.player.orplayer.e) it2.next()).onVideoStart(qVar.f);
            }
            return;
        }
        if (i == 4) {
            com.transsion.player.orplayer.e eVar3 = qVar.d;
            if (eVar3 != null) {
                eVar3.onVideoPause(qVar.f);
            }
            Iterator it3 = qVar.l.iterator();
            while (it3.hasNext()) {
                ((com.transsion.player.orplayer.e) it3.next()).onVideoPause(qVar.f);
            }
            return;
        }
        if (i != 6) {
            return;
        }
        com.transsion.player.orplayer.e eVar4 = qVar.d;
        if (eVar4 != null) {
            eVar4.onCompletion(qVar.f);
        }
        Iterator it4 = qVar.l.iterator();
        while (it4.hasNext()) {
            ((com.transsion.player.orplayer.e) it4.next()).onCompletion(qVar.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(q qVar) {
        if (qVar.r) {
            return;
        }
        com.transsion.player.orplayer.e eVar = qVar.d;
        if (eVar != null) {
            eVar.setOnSeekCompleteListener();
        }
        Iterator it = qVar.l.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).setOnSeekCompleteListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(q qVar) {
        MediaInfo mediaInfo;
        List<TrackInfo> trackInfos;
        if (qVar.r) {
            return;
        }
        AliPlayer aliPlayer = qVar.b;
        if (aliPlayer != null && (mediaInfo = aliPlayer.getMediaInfo()) != null && (trackInfos = mediaInfo.getTrackInfos()) != null) {
            for (TrackInfo trackInfo : trackInfos) {
                sn.e.a.a(qVar.a, "setOnInfoListener onRenderFirstFrame " + com.blankj.utilcode.util.o.j(trackInfo), true);
                TrackInfo.Type type = trackInfo.mType;
                int i = type == null ? -1 : a.a[type.ordinal()];
                if (i == 1) {
                    int i2 = trackInfo.videoBitrate;
                    qVar.o = i2;
                    com.transsion.player.orplayer.e eVar = qVar.d;
                    if (eVar != null) {
                        eVar.onTracksVideoBitrateChange(i2);
                    }
                    Iterator it = qVar.l.iterator();
                    while (it.hasNext()) {
                        ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(qVar.o);
                    }
                } else if (i == 2) {
                    int i3 = trackInfo.videoBitrate;
                    qVar.p = i3;
                    com.transsion.player.orplayer.e eVar2 = qVar.d;
                    if (eVar2 != null) {
                        eVar2.onTracksAudioBitrateChange(i3);
                    }
                    Iterator it2 = qVar.l.iterator();
                    while (it2.hasNext()) {
                        ((com.transsion.player.orplayer.e) it2.next()).onTracksAudioBitrateChange(qVar.p);
                    }
                }
            }
        }
        int i4 = qVar.o;
        int i5 = qVar.p;
        StringBuilder sb = new StringBuilder();
        sb.append("setOnInfoListener onRenderFirstFrame，videoBitrate:");
        sb.append(i4);
        sb.append(", audioBitrate:");
        sb.append(i5);
        com.transsion.player.orplayer.e eVar3 = qVar.d;
        if (eVar3 != null) {
            eVar3.onRenderFirstFrame();
        }
        Iterator it3 = qVar.l.iterator();
        while (it3.hasNext()) {
            ((com.transsion.player.orplayer.e) it3.next()).onRenderFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(q qVar, int i, int i2) {
        if (qVar.r) {
            return;
        }
        com.transsion.player.orplayer.e eVar = qVar.d;
        if (eVar != null) {
            eVar.onVideoSizeChanged(i, i2);
        }
        Iterator it = qVar.l.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoSizeChanged(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(final Function0 function0) {
        Handler handler = this.s;
        if (handler == null || Intrinsics.c(Thread.currentThread(), handler.getLooper().getThread())) {
            function0.invoke();
        } else {
            handler.post(new Runnable() { // from class: com.transsion.player.orplayer.p
                @Override // java.lang.Runnable
                public final void run() {
                    q.I(function0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function0 function0) {
        function0.invoke();
    }

    private final void J(hn.d dVar, boolean z) {
        CacheConfig cacheConfig = new CacheConfig();
        cacheConfig.mEnable = z;
        cacheConfig.mMaxDurationS = 120L;
        File externalCacheDir = this.m.getExternalCacheDir();
        String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
        String str = absolutePath + File.separator + "video_cache";
        cacheConfig.mDir = str;
        cacheConfig.mMaxSizeMB = dVar.a();
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setCacheConfig(cacheConfig);
        }
        try {
            Result.Companion companion = Result.Companion;
            AliPlayerGlobalSettings.enableLocalCache(z, 0, str);
            AliPlayerGlobalSettings.setCacheUrlHashCallback(new AliPlayerGlobalSettings.OnGetUrlHashCallback() { // from class: com.transsion.player.orplayer.o
                public final String getUrlHashCallback(String str2) {
                    String K;
                    K = q.K(str2);
                    return K;
                }
            });
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String K(String str) {
        try {
            URI uri = new URI(str);
            d.a aVar = sn.d.a;
            String uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
            Intrinsics.g(uri2, "toString(...)");
            return aVar.a(uri2);
        } catch (Exception unused) {
            d.a aVar2 = sn.d.a;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            return aVar2.a(str);
        }
    }

    private final void v() {
        SurfaceHolder holder;
        SurfaceView surfaceView = this.v;
        if (surfaceView != null && (holder = surfaceView.getHolder()) != null) {
            holder.removeCallback(this.t);
        }
        this.v = null;
        TextureView textureView = this.u;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.u = null;
    }

    private final boolean w(PlayError playError) {
        Integer errorCode;
        Integer errorCode2 = playError.getErrorCode();
        if ((errorCode2 == null || errorCode2.intValue() != 537133057) && ((errorCode = playError.getErrorCode()) == null || errorCode.intValue() != 537133058)) {
            return false;
        }
        if (this.q) {
            sn.e.a.a(this.a, "aliyun 已经切过软解，还是出错不再处理", true);
            return false;
        }
        sn.e.a.c(this.a, "aliyun onError -- 解码失败，强制切到软解", true);
        com.transsion.player.orplayer.e eVar = this.d;
        if (eVar != null) {
            eVar.onAliyunDecodeErrorChangeSoftwareDecoder(this.f);
        }
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onAliyunDecodeErrorChangeSoftwareDecoder(this.f);
        }
        stop();
        reset();
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.enableHardwareDecoder(false);
        }
        gn.e eVar2 = this.f;
        if (eVar2 != null) {
            setDataSource(eVar2);
            prepare();
        }
        this.q = true;
        return true;
    }

    private final void x() {
        this.c = new com.transsion.player.orplayer.c(new b(), new Function1() { // from class: com.transsion.player.orplayer.g
            public final Object invoke(Object obj) {
                Unit y;
                y = q.y(q.this, ((Boolean) obj).booleanValue());
                return y;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(q qVar, boolean z) {
        com.transsion.player.orplayer.e eVar = qVar.d;
        if (eVar != null) {
            eVar.onFocusChange(z);
        }
        Iterator it = qVar.l.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onFocusChange(z);
        }
        return Unit.a;
    }

    private final void z(boolean z) {
        hn.b bVar = hn.b.a;
        J(bVar.a(), bVar.c() && z);
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setOnRenderingStartListener(new IPlayer.OnRenderingStartListener() { // from class: com.transsion.player.orplayer.h
                public final void onRenderingStart() {
                    q.F(q.this);
                }
            });
        }
        AliPlayer aliPlayer2 = this.b;
        if (aliPlayer2 != null) {
            aliPlayer2.setOnVideoSizeChangedListener(new IPlayer.OnVideoSizeChangedListener() { // from class: com.transsion.player.orplayer.i
                public final void onVideoSizeChanged(int i, int i2) {
                    q.G(q.this, i, i2);
                }
            });
        }
        AliPlayer aliPlayer3 = this.b;
        if (aliPlayer3 != null) {
            aliPlayer3.setOnErrorListener(new IPlayer.OnErrorListener() { // from class: com.transsion.player.orplayer.j
                public final void onError(ErrorInfo errorInfo) {
                    q.A(q.this, errorInfo);
                }
            });
        }
        AliPlayer aliPlayer4 = this.b;
        if (aliPlayer4 != null) {
            aliPlayer4.setOnLoadingStatusListener(new c());
        }
        AliPlayer aliPlayer5 = this.b;
        if (aliPlayer5 != null) {
            aliPlayer5.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.transsion.player.orplayer.k
                public final void onPrepared() {
                    q.B(q.this);
                }
            });
        }
        AliPlayer aliPlayer6 = this.b;
        if (aliPlayer6 != null) {
            aliPlayer6.setOnInfoListener(new IPlayer.OnInfoListener() { // from class: com.transsion.player.orplayer.l
                public final void onInfo(InfoBean infoBean) {
                    q.C(q.this, infoBean);
                }
            });
        }
        AliPlayer aliPlayer7 = this.b;
        if (aliPlayer7 != null) {
            aliPlayer7.setOnStateChangedListener(new IPlayer.OnStateChangedListener() { // from class: com.transsion.player.orplayer.m
                public final void onStateChanged(int i) {
                    q.D(q.this, i);
                }
            });
        }
        AliPlayer aliPlayer8 = this.b;
        if (aliPlayer8 != null) {
            aliPlayer8.setOnSeekCompleteListener(new IPlayer.OnSeekCompleteListener() { // from class: com.transsion.player.orplayer.n
                public final void onSeekComplete() {
                    q.E(q.this);
                }
            });
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(gn.e eVar) {
        return f.b.a(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        if (this.l.contains(eVar)) {
            return;
        }
        this.l.add(eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(qn.d dVar, int i) {
        f.b.c(this, dVar, i);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.clearScreen();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        SurfaceTexture surfaceTexture;
        SurfaceHolder holder;
        Surface surface;
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setSurface((Surface) null);
        }
        SurfaceView surfaceView = this.v;
        if (surfaceView != null && (holder = surfaceView.getHolder()) != null && (surface = holder.getSurface()) != null) {
            surface.release();
        }
        TextureView textureView = this.u;
        if (textureView != null && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
            surfaceTexture.release();
        }
        v();
    }

    @Override // com.transsion.player.orplayer.f
    public gn.e currentMediaSource() {
        return this.f;
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
        return new Pair(Integer.valueOf(this.o), Integer.valueOf(this.p));
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        return this.n;
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
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            return aliPlayer.getOption(IPlayer.Option.DownloadBitrate);
        }
        return null;
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
        AliPlayer aliPlayer = this.b;
        return aliPlayer != null ? aliPlayer.getVideoHeight() : f.b.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        AliPlayer aliPlayer = this.b;
        return aliPlayer != null ? aliPlayer.getVideoWidth() : f.b.l(this);
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
        return this.j;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        return this.h;
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
        return this.g;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        return this.k;
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        com.transsion.player.orplayer.c cVar = this.c;
        if (cVar != null) {
            cVar.g(true);
        }
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.pause();
        }
        com.transsion.player.orplayer.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        com.transsion.player.orplayer.e eVar = this.d;
        if (eVar != null) {
            eVar.initPlayer();
        }
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).initPlayer();
        }
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
        com.transsion.player.orplayer.c cVar = this.c;
        if (cVar != null) {
            cVar.g(false);
        }
        com.transsion.player.orplayer.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.e();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.prepare();
        }
        this.i = false;
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        if (this.r) {
            return;
        }
        this.r = true;
        com.transsion.player.orplayer.e eVar = this.d;
        ArrayList arrayList = new ArrayList(this.l);
        this.d = null;
        this.l.clear();
        this.e = BuildConfig.FLAVOR;
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setOnRenderingStartListener((IPlayer.OnRenderingStartListener) null);
        }
        AliPlayer aliPlayer2 = this.b;
        if (aliPlayer2 != null) {
            aliPlayer2.setOnVideoSizeChangedListener((IPlayer.OnVideoSizeChangedListener) null);
        }
        AliPlayer aliPlayer3 = this.b;
        if (aliPlayer3 != null) {
            aliPlayer3.setOnErrorListener((IPlayer.OnErrorListener) null);
        }
        AliPlayer aliPlayer4 = this.b;
        if (aliPlayer4 != null) {
            aliPlayer4.setOnLoadingStatusListener((IPlayer.OnLoadingStatusListener) null);
        }
        AliPlayer aliPlayer5 = this.b;
        if (aliPlayer5 != null) {
            aliPlayer5.setOnPreparedListener((IPlayer.OnPreparedListener) null);
        }
        AliPlayer aliPlayer6 = this.b;
        if (aliPlayer6 != null) {
            aliPlayer6.setOnInfoListener((IPlayer.OnInfoListener) null);
        }
        AliPlayer aliPlayer7 = this.b;
        if (aliPlayer7 != null) {
            aliPlayer7.setOnStateChangedListener((IPlayer.OnStateChangedListener) null);
        }
        AliPlayer aliPlayer8 = this.b;
        if (aliPlayer8 != null) {
            aliPlayer8.setOnSeekCompleteListener((IPlayer.OnSeekCompleteListener) null);
        }
        AliPlayer aliPlayer9 = this.b;
        if (aliPlayer9 != null) {
            aliPlayer9.release();
        }
        this.b = null;
        if (eVar != null) {
            e.a.u(eVar, null, 1, null);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            e.a.u((com.transsion.player.orplayer.e) it.next(), null, 1, null);
        }
        com.transsion.player.orplayer.c cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
        v();
        this.k = false;
        this.q = false;
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
        this.l.remove(eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return f.b.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
        AliPlayer aliPlayer2 = this.b;
        if (aliPlayer2 != null) {
            aliPlayer2.reset();
        }
        AliPlayer aliPlayer3 = this.b;
        if (aliPlayer3 != null) {
            aliPlayer3.clearScreen();
        }
        com.transsion.player.orplayer.c cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
        if (!this.i) {
            com.transsion.player.orplayer.e eVar = this.d;
            if (eVar != null) {
                eVar.onPlayerReset();
            }
            Iterator it = this.l.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onPlayerReset();
            }
        }
        this.i = true;
        this.k = false;
        this.q = false;
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
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(gn.e eVar) {
        Intrinsics.h(eVar, "mediaSource");
        UrlSource urlSource = new UrlSource();
        String j = eVar.j();
        this.e = j;
        this.f = eVar;
        urlSource.setUri(j);
        com.transsion.player.orplayer.e eVar2 = this.d;
        if (eVar2 != null) {
            eVar2.onSetDataSource();
        }
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onSetDataSource();
        }
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setDataSource(urlSource);
        }
        this.k = false;
        this.q = false;
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
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setMute(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(hn.d dVar) {
        Intrinsics.h(dVar, "vodConfig");
        AliPlayer aliPlayer = this.b;
        PlayerConfig config = aliPlayer != null ? aliPlayer.getConfig() : null;
        Intrinsics.f(config, "null cannot be cast to non-null type com.aliyun.player.nativeclass.PlayerConfig");
        config.mClearFrameWhenStop = dVar.b();
        config.mEnableLocalCache = dVar.j();
        config.mPositionTimerIntervalMs = dVar.k();
        config.mMaxBufferDuration = dVar.g();
        config.mHighBufferDuration = dVar.f();
        config.mStartBufferDuration = dVar.n();
        config.mNetworkRetryCount = dVar.m();
        config.mNetworkTimeout = dVar.h();
        config.mDisableAudio = dVar.c();
        config.mDisableVideo = dVar.d();
        AliPlayer aliPlayer2 = this.b;
        if (aliPlayer2 != null) {
            aliPlayer2.setConfig(config);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        this.d = eVar;
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.h(scaleMode, "scaleMode");
        int i = a.b[scaleMode.ordinal()];
        if (i == 1) {
            AliPlayer aliPlayer = this.b;
            if (aliPlayer != null) {
                aliPlayer.setScaleMode(IPlayer.ScaleMode.SCALE_ASPECT_FILL);
                return;
            }
            return;
        }
        if (i == 2) {
            AliPlayer aliPlayer2 = this.b;
            if (aliPlayer2 != null) {
                aliPlayer2.setScaleMode(IPlayer.ScaleMode.SCALE_TO_FILL);
                return;
            }
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        AliPlayer aliPlayer3 = this.b;
        if (aliPlayer3 != null) {
            aliPlayer3.setScaleMode(IPlayer.ScaleMode.SCALE_ASPECT_FIT);
        }
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
        SurfaceHolder holder;
        Surface surface;
        AliPlayer aliPlayer;
        SurfaceHolder holder2;
        v();
        this.v = surfaceView;
        Thread currentThread = Thread.currentThread();
        if (surfaceView != null) {
            this.s = currentThread instanceof HandlerThread ? new Handler(((HandlerThread) currentThread).getLooper()) : new Handler(Looper.getMainLooper());
        }
        if (surfaceView != null && (holder2 = surfaceView.getHolder()) != null) {
            holder2.addCallback(this.t);
        }
        if (surfaceView == null || (holder = surfaceView.getHolder()) == null || (surface = holder.getSurface()) == null || !surface.isValid() || (aliPlayer = this.b) == null) {
            return;
        }
        aliPlayer.setSurface(surface);
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        AliPlayer aliPlayer;
        v();
        this.u = textureView;
        Thread currentThread = Thread.currentThread();
        if (this.v != null) {
            this.s = currentThread instanceof HandlerThread ? new Handler(((HandlerThread) currentThread).getLooper()) : new Handler(Looper.getMainLooper());
        }
        if (textureView != null) {
            textureView.setSurfaceTextureListener(this.w);
        }
        if (textureView == null || (surfaceTexture = textureView.getSurfaceTexture()) == null) {
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        if (!surface.isValid() || (aliPlayer = this.b) == null) {
            return;
        }
        aliPlayer.setSurface(surface);
    }

    @Override // com.transsion.player.orplayer.f
    public void setVipResolution(boolean z, int i) {
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("setVolume   volume:");
        sb.append(f);
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.setVolume(RangesKt.k(f, 0.0f, 2.0f));
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        this.e = BuildConfig.FLAVOR;
        com.transsion.player.orplayer.c cVar = this.c;
        if (cVar != null) {
            cVar.g(true);
        }
        AliPlayer aliPlayer = this.b;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
        com.transsion.player.orplayer.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.b();
        }
        this.q = false;
    }
}
