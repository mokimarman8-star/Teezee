package vm;

import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements e {
    public static final C0097a c = new C0097a(null);
    private wm.a a;
    private int b;

    /* renamed from: vm.a$a, reason: collision with other inner class name */
    public static final class C0097a {
        private C0097a() {
        }

        public /* synthetic */ C0097a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int a() {
        return this.b;
    }

    public final void b(wm.a aVar) {
        this.a = aVar;
    }

    @Override // com.transsion.player.orplayer.e
    public void canNonSubscriberPlay(boolean z, int i, int i2, qn.d dVar) {
        e.a.a(this, z, i, i2, dVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.b(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
        e.a.c(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j, gn.e eVar) {
        e.a.d(this, j, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(gn.e eVar) {
        e.a.e(this, eVar);
        a.a.f(wf.a.a, "GifPlayerListener", "onCompletion", false, 4, (Object) null);
        wm.a aVar = this.a;
        if (aVar != null) {
            aVar.q();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z) {
        e.a.g(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z) {
        e.a.h(this, z);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(gn.e eVar) {
        e.a.i(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(gn.e eVar) {
        e.a.k(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i, float f, gn.e eVar) {
        e.a.m(this, i, f, eVar);
        a.a.f(wf.a.a, "GifPlayerListener", "percent=" + i, false, 4, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.o(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, gn.e eVar) {
        Intrinsics.h(playError, "errorInfo");
        e.a.q(this, playError, eVar);
        a.a.f(wf.a.a, "GifPlayerListener", "errorInfo code=" + playError.getErrorCode() + " message=" + playError.getErrorMessage(), false, 4, (Object) null);
        Integer errorCode = playError.getErrorCode();
        this.b = errorCode != null ? errorCode.intValue() : 0;
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(gn.e eVar) {
        e.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.v(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(gn.e eVar) {
        e.a.w(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j, gn.e eVar) {
        e.a.y(this, j, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        a.a.f(wf.a.a, "GifPlayerListener", "onRenderFirstFrame", false, 4, (Object) null);
        wm.a aVar = this.a;
        if (aVar != null) {
            aVar.p();
        }
        this.b = 0;
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.B(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i) {
        e.a.C(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(qn.c cVar) {
        e.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i) {
        e.a.E(this, i);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(gn.e eVar) {
        e.a.F(this, eVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i, int i2) {
        e.a.H(this, i, i2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(gn.e eVar) {
        e.a.I(this, eVar);
        a.a.f(wf.a.a, "GifPlayerListener", "onVideoStart", false, 4, (Object) null);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.K(this);
    }
}
