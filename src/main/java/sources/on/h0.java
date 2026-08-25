package on;

import android.view.SurfaceView;
import android.view.TextureView;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.f;
import com.transsion.player.p003enum.ScaleMode;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h0 implements com.transsion.player.orplayer.f {
    public static final a o = new a(null);
    private volatile com.transsion.player.orplayer.f a;
    private volatile gn.e b;
    private SurfaceView c;
    private TextureView d;
    private com.transsion.player.orplayer.e e;
    private Float g;
    private boolean h;
    private boolean i;
    private hn.d j;
    private boolean k;
    private CopyOnWriteArrayList f = new CopyOnWriteArrayList();
    private boolean l = true;
    private float m = 1.0f;
    private ScaleMode n = ScaleMode.SCALE_ASPECT_FIT;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(h0 h0Var) {
        com.transsion.player.orplayer.f fVar = h0Var.a;
        if (fVar != null) {
            fVar.stop();
            fVar.reset();
            fVar.enableHardwareDecoder(h0Var.l);
            hn.d dVar = h0Var.j;
            if (dVar != null) {
                fVar.setPlayerConfig(dVar);
            }
            fVar.setMute(h0Var.k);
            Float f = h0Var.g;
            if (f != null) {
                fVar.setVolume(f.floatValue());
            }
            fVar.setSpeed(h0Var.m);
            fVar.setLooping(h0Var.i);
            fVar.setAutoPlay(h0Var.h);
            SurfaceView surfaceView = h0Var.c;
            if (surfaceView != null) {
                fVar.setSurfaceView(surfaceView);
            }
            TextureView textureView = h0Var.d;
            if (textureView != null) {
                fVar.setTextureView(textureView);
            }
            com.transsion.player.orplayer.e eVar = h0Var.e;
            if (eVar != null) {
                fVar.setPlayerListener(eVar);
            }
            for (com.transsion.player.orplayer.e eVar2 : h0Var.f) {
                Intrinsics.e(eVar2);
                fVar.addPlayerListener(eVar2);
            }
            fVar.setScaleMode(h0Var.n);
            gn.e eVar3 = h0Var.b;
            if (eVar3 != null) {
                fVar.setDataSource(eVar3);
            }
        }
        return Unit.a;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(gn.e eVar) {
        return f.b.a(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        if (this.f.contains(eVar)) {
            return;
        }
        this.f.add(eVar);
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.addPlayerListener(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(qn.d dVar, int i) {
        Intrinsics.h(dVar, "mediaTrackGroup");
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.changeTrackSelection(dVar, i);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.clearScreen();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.clearSurfaceOnly();
        }
        this.c = null;
        this.d = null;
    }

    @Override // com.transsion.player.orplayer.f
    public gn.e currentMediaSource() {
        return this.b;
    }

    public final void d(boolean z) {
        com.transsion.player.orplayer.e eVar = this.e;
        if (eVar != null) {
            eVar.onFocusChange(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z) {
        this.l = z;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.enableHardwareDecoder(z);
        }
    }

    public final void f(com.transsion.player.orplayer.f fVar) {
        this.a = fVar;
    }

    @Override // com.transsion.player.orplayer.f
    public Pair getBitrate() {
        Pair bitrate;
        com.transsion.player.orplayer.f fVar = this.a;
        return (fVar == null || (bitrate = fVar.getBitrate()) == null) ? new Pair(0, 0) : bitrate;
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            return fVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public qn.c getCurrentTracks() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            return fVar.getCurrentTracks();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public qn.b getCurrentVideoFormat() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            return fVar.getCurrentVideoFormat();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            return fVar.getDownloadBitrate();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            return fVar.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        com.transsion.player.orplayer.f fVar = this.a;
        return fVar != null ? fVar.getVideoHeight() : f.b.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        com.transsion.player.orplayer.f fVar = this.a;
        return fVar != null ? fVar.getVideoWidth() : f.b.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            return fVar.getVolume();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            return fVar.isComplete();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        com.transsion.player.orplayer.f fVar = this.a;
        return fVar != null ? fVar.isLoading() : f.b.m(this);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            return fVar.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        com.transsion.player.orplayer.f fVar = this.a;
        return fVar != null ? fVar.isPrepared() : f.b.n(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        e0.a.o(this, this.b);
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.pause();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        e0 e0Var = e0.a;
        e0Var.p(this, this.b);
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            e0Var.t(fVar, MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        com.transsion.player.orplayer.f fVar2 = this.a;
        if (fVar2 != null) {
            fVar2.play();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.release();
        }
        this.a = null;
        this.e = null;
        this.c = null;
        this.d = null;
        e0.a.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void release(String str) {
        if (str != null && str.length() != 0) {
            gn.e eVar = this.b;
            if (!Intrinsics.c(eVar != null ? eVar.e() : null, str)) {
                return;
            }
        }
        release();
    }

    @Override // com.transsion.player.orplayer.f
    public boolean removeDataSource(gn.e eVar) {
        return f.b.p(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void removePlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        this.f.remove(eVar);
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.removePlayerListener(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        if (this.a != null) {
            return false;
        }
        e0.a.u(this);
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar == null) {
            return true;
        }
        Function0 function0 = new Function0() { // from class: on.g0
            public final Object invoke() {
                Unit e;
                e = h0.e(h0.this);
                return e;
            }
        };
        if (fVar instanceof y) {
            ((y) fVar).M(function0);
            return true;
        }
        function0.invoke();
        return true;
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.reset();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j) {
        MediaItem h;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.seekTo(j);
        }
        gn.e eVar = this.b;
        if (eVar != null && (h = eVar.h()) != null) {
            h.setPosition(Long.valueOf(j));
        }
        e0.a.v(this, this.b);
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String str, long j) {
        Intrinsics.h(str, "uuid");
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.seekTo(str, j);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z) {
        this.h = z;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setAutoPlay(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(gn.e eVar) {
        com.transsion.player.orplayer.f fVar;
        Intrinsics.h(eVar, "mediaSource");
        this.b = eVar;
        com.transsion.player.orplayer.f fVar2 = this.a;
        if (fVar2 != null) {
            e0.a.t(fVar2, "setDataSource");
        }
        if (requestForce() || (fVar = this.a) == null) {
            return;
        }
        fVar.setDataSource(eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z) {
        this.i = z;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setLooping(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z) {
        this.k = z;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setMute(z);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(hn.d dVar) {
        Intrinsics.h(dVar, "vodConfig");
        this.j = dVar;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setPlayerConfig(dVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        this.e = eVar;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setPlayerListener(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.h(scaleMode, "scaleMode");
        this.n = scaleMode;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setScaleMode(scaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f) {
        this.m = f;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setSpeed(f);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
        this.d = null;
        this.c = surfaceView;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        this.c = null;
        this.d = textureView;
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setVipResolution(boolean z, int i) {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setVipResolution(z, i);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f) {
        this.g = Float.valueOf(f);
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.setVolume(f);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        com.transsion.player.orplayer.f fVar = this.a;
        if (fVar != null) {
            fVar.stop();
        }
    }
}
