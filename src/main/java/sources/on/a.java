package on;

import com.transsion.player.mediasession.MediaBrowserCompatHelper;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements com.transsion.player.orplayer.e {
    private long b;
    private CopyOnWriteArrayList a = new CopyOnWriteArrayList();
    private final int c = 3000;

    private final String b() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final String c(long j) {
        SimpleDateFormat simpleDateFormat = j >= 3600000 ? new SimpleDateFormat("H:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public final void a(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        if (this.a.contains(eVar)) {
            return;
        }
        this.a.add(eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        Intrinsics.h(dVar, "dashVideoTracksGroup");
        e.a.a(this, z, i, i2, dVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).canNonSubscriberPlay(z, i, i2, dVar);
        }
    }

    public final void d(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        this.a.remove(eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).initPlayer();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onAliyunDecodeErrorChangeSoftwareDecoder(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onBufferedPosition(j, eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e eVar) {
        e.a.e(this, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onCompletion(eVar);
        }
        com.transsion.player.mediasession.i.a.a(b() + " --> onCompletion() --> 刷新通知栏");
        MediaBrowserCompatHelper.h.a().r(eVar != null ? eVar.h() : null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onFocusChange(z);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onIsPlayingChanged(z);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e eVar) {
        e.a.i(this, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingBegin(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e eVar) {
        e.a.k(this, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingEnd(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoadingProgress(i, f, eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.o(this);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onLoopingStart();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onMediaItemTransition(str);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, gn.e eVar) {
        Intrinsics.h(playError, "errorInfo");
        e.a.q(this, playError, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayError(playError, eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayerRelease(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPlayerReset();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e eVar) {
        e.a.w(this, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onPrepare(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j, gn.e eVar) {
        MediaItem h;
        MediaItem h2;
        e.a.y(this, j, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onProgress(j, eVar);
        }
        if (System.currentTimeMillis() - this.b > this.c) {
            this.b = System.currentTimeMillis();
            if (eVar != null && (h2 = eVar.h()) != null) {
                com.transsion.player.orplayer.f e = e0.a.e();
                h2.setDuration(e != null ? Long.valueOf(e.getDuration()) : null);
            }
            if (eVar != null && (h = eVar.h()) != null) {
                h.setPosition(Long.valueOf(j));
            }
            MediaBrowserCompatHelper.h.a().t(eVar != null ? eVar.h() : null);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.A(this);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onRenderFirstFrame();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onSetDataSource();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        e.a.C(this, i);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksAudioBitrateChange(i);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        Intrinsics.h(cVar, "tracks");
        e.a.D(this, cVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksChange(cVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        e.a.E(this, i);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onTracksVideoBitrateChange(i);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e eVar) {
        MediaItem h;
        MediaItem h2;
        MediaItem h3;
        MediaItem h4;
        Long position;
        e.a.F(this, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoPause(eVar);
        }
        com.transsion.player.mediasession.i.a.a(b() + " --> onVideoPause() --> 刷新通知栏 --> position = " + c((eVar == null || (h4 = eVar.h()) == null || (position = h4.getPosition()) == null) ? 0L : position.longValue()) + " --> position = " + ((eVar == null || (h3 = eVar.h()) == null) ? null : h3.getPosition()));
        if (eVar != null && (h2 = eVar.h()) != null) {
            com.transsion.player.orplayer.f e = e0.a.e();
            h2.setDuration(e != null ? Long.valueOf(e.getDuration()) : null);
        }
        if (eVar != null && (h = eVar.h()) != null) {
            com.transsion.player.orplayer.f e2 = e0.a.e();
            h.setPosition(e2 != null ? Long.valueOf(e2.getCurrentPosition()) : null);
        }
        MediaBrowserCompatHelper.h.a().r(eVar != null ? eVar.h() : null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoSizeChanged(i, i2);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e eVar) {
        MediaItem h;
        MediaItem h2;
        MediaItem h3;
        MediaItem h4;
        Long position;
        e.a.I(this, eVar);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoStart(eVar);
        }
        com.transsion.player.mediasession.i.a.a(b() + " --> onVideoStart() --> 刷新通知栏 --> position = " + c((eVar == null || (h4 = eVar.h()) == null || (position = h4.getPosition()) == null) ? 0L : position.longValue()) + " --> position = " + ((eVar == null || (h3 = eVar.h()) == null) ? null : h3.getPosition()));
        if (eVar != null && (h2 = eVar.h()) != null) {
            com.transsion.player.orplayer.f e = e0.a.e();
            h2.setDuration(e != null ? Long.valueOf(e.getDuration()) : null);
        }
        if (eVar != null && (h = eVar.h()) != null) {
            com.transsion.player.orplayer.f e2 = e0.a.e();
            h.setPosition(e2 != null ? Long.valueOf(e2.getCurrentPosition()) : null);
        }
        MediaBrowserCompatHelper.h.a().t(eVar != null ? eVar.h() : null);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        Long position;
        gn.e currentMediaSource;
        e.a.K(this);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).setOnSeekCompleteListener();
        }
        e0 e0Var = e0.a;
        com.transsion.player.orplayer.f e = e0Var.e();
        MediaItem h = (e == null || (currentMediaSource = e.currentMediaSource()) == null) ? null : currentMediaSource.h();
        if (h != null) {
            com.transsion.player.orplayer.f e2 = e0Var.e();
            h.setDuration(e2 != null ? Long.valueOf(e2.getDuration()) : null);
        }
        if (h != null) {
            com.transsion.player.orplayer.f e3 = e0Var.e();
            h.setPosition(e3 != null ? Long.valueOf(e3.getCurrentPosition()) : null);
        }
        com.transsion.player.mediasession.i.a.a(b() + " --> setOnSeekCompleteListener() --> 刷新通知栏 --> position = " + c((h == null || (position = h.getPosition()) == null) ? 0L : position.longValue()) + " --> position = " + (h != null ? h.getPosition() : null));
        MediaBrowserCompatHelper.h.a().t(h);
    }
}
