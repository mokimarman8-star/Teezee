package on;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import com.blankj.utilcode.util.Utils;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.p003enum.ScaleMode;
import java.lang.Thread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y implements com.transsion.player.orplayer.f, com.transsion.player.orplayer.e {
    public static final a j = new a(null);
    private static final Thread.UncaughtExceptionHandler k = new Thread.UncaughtExceptionHandler() { // from class: on.b
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th2) {
            y.F(thread, th2);
        }
    };
    private final HandlerThread a;
    private final Handler b;
    private com.transsion.player.orplayer.f c;
    private volatile long d;
    private volatile com.transsion.player.orplayer.e e;
    private CopyOnWriteArrayList f;
    private volatile gn.e g;
    private long h;
    private final AtomicBoolean i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final y a() {
            return new y(null);
        }
    }

    private y() {
        this.f = new CopyOnWriteArrayList();
        if (e0.a.g()) {
            HandlerThread handlerThread = new HandlerThread("TnPlayerThread", Build.VERSION.SDK_INT >= 28 ? -10 : -16);
            handlerThread.start();
            handlerThread.setUncaughtExceptionHandler(k);
            this.b = new Handler(handlerThread.getLooper());
            this.a = handlerThread;
        } else {
            this.a = null;
            this.b = new Handler(Looper.getMainLooper());
        }
        M(new Function0() { // from class: on.r
            public final Object invoke() {
                Unit z;
                z = y.z(y.this);
                return z;
            }
        });
        this.i = new AtomicBoolean(true);
    }

    public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(y yVar, com.transsion.player.orplayer.e eVar) {
        yVar.f.add(eVar);
        yVar.E("addPlayerListener:" + eVar);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(y yVar) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.clearScreen();
        }
        yVar.E("clearScreen  mediaSource:" + yVar.g);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(y yVar, boolean z) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.enableHardwareDecoder(z);
        }
        return Unit.a;
    }

    private final com.transsion.player.orplayer.f D() {
        return this.c;
    }

    private final void E(String str) {
        sn.e eVar = sn.e.a;
        int hashCode = hashCode();
        com.transsion.player.orplayer.f fVar = this.c;
        eVar.a("TnPlayer", "this@" + hashCode + "  player@" + (fVar != null ? fVar.hashCode() : 0) + "  " + str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Thread thread, Throwable th2) {
        sn.e.a.c("TnPlayer", "uncaughtException:" + th2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(y yVar) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.pause();
        }
        yVar.E("pause:" + yVar.g);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(y yVar) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.play();
        }
        yVar.E("play:" + yVar.g);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(y yVar) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.prepare();
        }
        yVar.E("prepare:" + yVar.g);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(y yVar) {
        yVar.h = 0L;
        yVar.i.set(true);
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.stop();
        }
        if (e0.a.i()) {
            if (f0.a.a(yVar)) {
                com.transsion.player.orplayer.f D2 = yVar.D();
                if (D2 != null) {
                    D2.release();
                }
                HandlerThread handlerThread = yVar.a;
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                }
                HandlerThread handlerThread2 = yVar.a;
                if (handlerThread2 != null) {
                    handlerThread2.setUncaughtExceptionHandler(null);
                }
                yVar.b.removeCallbacksAndMessages(null);
            } else {
                com.transsion.player.orplayer.f D3 = yVar.D();
                if (D3 != null) {
                    D3.reset();
                }
                com.transsion.player.orplayer.f D4 = yVar.D();
                if (D4 != null) {
                    D4.clearScreen();
                }
            }
            yVar.E(" release:" + yVar.g);
        } else {
            com.transsion.player.orplayer.f D5 = yVar.D();
            if (D5 != null) {
                D5.reset();
            }
            yVar.E(" reset:" + yVar.g);
        }
        yVar.e = null;
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(y yVar, com.transsion.player.orplayer.e eVar) {
        yVar.f.remove(eVar);
        yVar.E("removePlayerListener:" + eVar);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(y yVar) {
        yVar.E("reset:" + yVar.g);
        yVar.h = 0L;
        yVar.i.set(true);
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.clearScreen();
        }
        com.transsion.player.orplayer.f D2 = yVar.D();
        if (D2 != null) {
            D2.reset();
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(y yVar, long j2) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.seekTo(j2);
        }
        yVar.E(" seekTo:" + j2 + "  mediaSource:" + yVar.g);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(y yVar, boolean z) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.setAutoPlay(z);
        }
        yVar.E("setAutoPlay:" + z + "  mediaSource:" + yVar.g);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(y yVar, gn.e eVar) {
        yVar.g = eVar;
        yVar.d = 0L;
        yVar.h = 0L;
        yVar.i.set(true);
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.setDataSource(eVar);
        }
        yVar.E("setDataSource:" + eVar);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(y yVar, boolean z) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.setLooping(z);
        }
        yVar.E("setLooping:" + z + "  mediaSource:" + yVar.g);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(y yVar, hn.d dVar) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.setPlayerConfig(dVar);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(y yVar, com.transsion.player.orplayer.e eVar) {
        yVar.e = eVar;
        yVar.E("setPlayerListener:" + eVar);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(y yVar, float f) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.setSpeed(f);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(y yVar, SurfaceView surfaceView) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.setSurfaceView(surfaceView);
        }
        yVar.E("setSurfaceView:" + surfaceView);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(y yVar, TextureView textureView) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.setTextureView(textureView);
        }
        yVar.E("setTextureView:" + textureView);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(y yVar, float f) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.setVolume(f);
        }
        yVar.E("setVolume:" + f + "  mediaSource:" + yVar.g);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(y yVar) {
        com.transsion.player.orplayer.f D = yVar.D();
        if (D != null) {
            D.stop();
        }
        yVar.E("stop:" + yVar.g);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(y yVar) {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        com.transsion.player.orplayer.f a3 = new f.a(a2).b(new hn.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 126975, null)).a();
        a3.setLooping(false);
        a3.setAutoPlay(false);
        a3.setPlayerListener(yVar);
        yVar.c = a3;
        yVar.E("init player:" + a3);
        return Unit.a;
    }

    public final void M(final Function0 function0) {
        Intrinsics.h(function0, "action");
        if (Intrinsics.c(Thread.currentThread(), this.b.getLooper().getThread())) {
            function0.invoke();
            return;
        }
        HandlerThread handlerThread = this.a;
        if (handlerThread == null || !handlerThread.isAlive()) {
            E("runOnPlayerThread handlerThread.isAlive:false");
        } else {
            this.b.post(new Runnable() { // from class: on.p
                @Override // java.lang.Runnable
                public final void run() {
                    y.N(function0);
                }
            });
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(gn.e eVar) {
        Intrinsics.h(eVar, "mediaSource");
        setDataSource(eVar);
        return true;
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(final com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        if (this.f.contains(eVar)) {
            return;
        }
        M(new Function0() { // from class: on.e
            public final Object invoke() {
                Unit A;
                A = y.A(y.this, eVar);
                return A;
            }
        });
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(qn.d dVar, int i) {
        Intrinsics.h(dVar, "mediaTrackGroup");
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            D.changeTrackSelection(dVar, i);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        M(new Function0() { // from class: on.g
            public final Object invoke() {
                Unit B;
                B = y.B(y.this);
                return B;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            D.clearSurfaceOnly();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public gn.e currentMediaSource() {
        return f.b.f(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(final boolean z) {
        M(new Function0() { // from class: on.k
            public final Object invoke() {
                Unit C;
                C = y.C(y.this, z);
                return C;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public Pair getBitrate() {
        Pair bitrate;
        com.transsion.player.orplayer.f D = D();
        return (D == null || (bitrate = D.getBitrate()) == null) ? new Pair(0, 0) : bitrate;
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            return D.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public qn.c getCurrentTracks() {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            return D.getCurrentTracks();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public qn.b getCurrentVideoFormat() {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            return D.getCurrentVideoFormat();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            return D.getDownloadBitrate();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        return this.d;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        com.transsion.player.orplayer.f D = D();
        return D != null ? D.getVideoHeight() : f.b.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        com.transsion.player.orplayer.f D = D();
        return D != null ? D.getVideoWidth() : f.b.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            return D.getVolume();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.initPlayer();
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).initPlayer();
        }
        E("initPlayer  mediaSource:" + this.g);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            return D.isComplete();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        com.transsion.player.orplayer.f D = D();
        return D != null ? D.isLoading() : f.b.m(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            return D.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            return D.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        com.transsion.player.orplayer.f D = D();
        return D != null ? D.isPrepared() : f.b.n(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onAliyunDecodeErrorChangeSoftwareDecoder(eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onAliyunDecodeErrorChangeSoftwareDecoder(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j2, gn.e eVar) {
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onBufferedPosition(j2, eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onBufferedPosition(j2, eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e eVar) {
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onCompletion(eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onCompletion(eVar);
        }
        E("onCompletion  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onFocusChange(z);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onFocusChange(z);
        }
        E("onFocusChange mediaSource:" + this.g);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onIsPlayingChanged(z);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onIsPlayingChanged(z);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e eVar) {
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onLoadingBegin(eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingBegin(eVar);
        }
        E("onLoadingBegin  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e eVar) {
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onLoadingEnd(eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingEnd(eVar);
        }
        E("onLoadingEnd mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onLoadingProgress(i, f, eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingProgress(i, f, eVar);
        }
        E("onLoadingProgress percent:" + i + " netSpeed:" + f + " mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onLoopingStart();
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoopingStart();
        }
        E("onLoopingStart  mediaSource:" + this.g);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, gn.e eVar) {
        Intrinsics.h(playError, "errorInfo");
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onPlayError(playError, eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayError(playError, eVar);
        }
        this.i.set(true);
        E("onPlayError  errorInfo:" + playError + " mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onPlayerRelease(eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayerRelease(eVar);
        }
        E("onPlayerRelease  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onPlayerReset();
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayerReset();
        }
        E("onPlayerReset mediaSource:" + this.g);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e eVar) {
        com.transsion.player.orplayer.f D = D();
        this.d = D != null ? D.getDuration() : 0L;
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onPrepare(eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPrepare(eVar);
        }
        E("onPrepare  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j2, gn.e eVar) {
        if (this.i.get()) {
            com.transsion.player.orplayer.e eVar2 = this.e;
            if (eVar2 != null) {
                eVar2.onProgress(j2, eVar);
            }
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onProgress(j2, eVar);
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        E("onRenderFirstFrame  mediaSource:" + this.g);
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onRenderFirstFrame();
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onRenderFirstFrame();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onSetDataSource();
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onSetDataSource();
        }
        E("onSetDataSource  mediaSource:" + this.g);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onTracksAudioBitrateChange(i);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksAudioBitrateChange(i);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onTracksVideoBitrateChange(i);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(i);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e eVar) {
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onVideoPause(eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoPause(eVar);
        }
        E("onVideoPause  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onVideoSizeChanged(i, i2);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoSizeChanged(i, i2);
        }
        E("onVideoSizeChanged width:" + i + " height:" + i2 + " mediaSource:" + this.g);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e eVar) {
        com.transsion.player.orplayer.e eVar2 = this.e;
        if (eVar2 != null) {
            eVar2.onVideoStart(eVar);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoStart(eVar);
        }
        E("onVideoStart  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        M(new Function0() { // from class: on.t
            public final Object invoke() {
                Unit G;
                G = y.G(y.this);
                return G;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        M(new Function0() { // from class: on.m
            public final Object invoke() {
                Unit H;
                H = y.H(y.this);
                return H;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        M(new Function0() { // from class: on.q
            public final Object invoke() {
                Unit I;
                I = y.I(y.this);
                return I;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        this.d = 0L;
        M(new Function0() { // from class: on.u
            public final Object invoke() {
                Unit J;
                J = y.J(y.this);
                return J;
            }
        });
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
    public void removePlayerListener(final com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        M(new Function0() { // from class: on.h
            public final Object invoke() {
                Unit K;
                K = y.K(y.this, eVar);
                return K;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return f.b.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        M(new Function0() { // from class: on.f
            public final Object invoke() {
                Unit L;
                L = y.L(y.this);
                return L;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(final long j2) {
        if (this.i.compareAndSet(true, false)) {
            M(new Function0() { // from class: on.v
                public final Object invoke() {
                    Unit O;
                    O = y.O(y.this, j2);
                    return O;
                }
            });
            this.h = 0L;
            return;
        }
        this.h = j2;
        E("seekTo:" + j2 + "  waiting.... mediaSource:" + this.g);
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String str, long j2) {
        f.b.s(this, str, j2);
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(final boolean z) {
        M(new Function0() { // from class: on.l
            public final Object invoke() {
                Unit P;
                P = y.P(y.this, z);
                return P;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(final gn.e eVar) {
        Intrinsics.h(eVar, "mediaSource");
        M(new Function0() { // from class: on.o
            public final Object invoke() {
                Unit Q;
                Q = y.Q(y.this, eVar);
                return Q;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(final boolean z) {
        M(new Function0() { // from class: on.x
            public final Object invoke() {
                Unit R;
                R = y.R(y.this, z);
                return R;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z) {
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            D.setMute(z);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
        this.i.set(true);
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.setOnSeekCompleteListener();
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).setOnSeekCompleteListener();
        }
        E("setOnSeekCompleteListener nextSeekTo:" + this.h + " mediaSource:" + this.g);
        long j2 = this.h;
        if (j2 > 0) {
            seekTo(j2);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(final hn.d dVar) {
        Intrinsics.h(dVar, "vodConfig");
        M(new Function0() { // from class: on.c
            public final Object invoke() {
                Unit S;
                S = y.S(y.this, dVar);
                return S;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(final com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        M(new Function0() { // from class: on.i
            public final Object invoke() {
                Unit T;
                T = y.T(y.this, eVar);
                return T;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.h(scaleMode, "scaleMode");
        com.transsion.player.orplayer.f D = D();
        if (D != null) {
            D.setScaleMode(scaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(final float f) {
        M(new Function0() { // from class: on.n
            public final Object invoke() {
                Unit U;
                U = y.U(y.this, f);
                return U;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(final SurfaceView surfaceView) {
        M(new Function0() { // from class: on.w
            public final Object invoke() {
                Unit V;
                V = y.V(y.this, surfaceView);
                return V;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(final TextureView textureView) {
        M(new Function0() { // from class: on.s
            public final Object invoke() {
                Unit W;
                W = y.W(y.this, textureView);
                return W;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setVipResolution(boolean z, int i) {
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(final float f) {
        M(new Function0() { // from class: on.d
            public final Object invoke() {
                Unit X;
                X = y.X(y.this, f);
                return X;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        M(new Function0() { // from class: on.j
            public final Object invoke() {
                Unit Y;
                Y = y.Y(y.this);
                return Y;
            }
        });
    }
}
