package com.transsion.audio.player;

import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AudioPlayer {
    public static final a i = new a(null);
    private static final Lazy j = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.audio.player.b
        public final Object invoke() {
            AudioPlayer x;
            x = AudioPlayer.x();
            return x;
        }
    });
    private com.transsion.player.orplayer.f b;
    private com.transsion.audio.player.a c;
    private long d;
    private AudioBean e;
    private AudioBean f;
    private long a = 1;
    private List g = new ArrayList();
    private String h = BuildConfig.FLAVOR;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AudioPlayer a() {
            return (AudioPlayer) AudioPlayer.j.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(boolean z) {
        for (com.transsion.player.orplayer.e eVar : this.g) {
            if (eVar != null) {
                eVar.onIsPlayingChanged(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(gn.e eVar) {
        for (com.transsion.player.orplayer.e eVar2 : this.g) {
            if (eVar2 != null) {
                eVar2.onLoadingBegin(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(gn.e eVar) {
        for (com.transsion.player.orplayer.e eVar2 : this.g) {
            if (eVar2 != null) {
                eVar2.onLoadingEnd(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.c;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int i2, float f, gn.e eVar) {
        for (com.transsion.player.orplayer.e eVar2 : this.g) {
            if (eVar2 != null) {
                eVar2.onLoadingProgress(i2, f, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(gn.e eVar) {
        AudioBean audioBean = this.e;
        if (audioBean == null || audioBean.getStatus() != 6) {
            com.transsion.audio.view.d.k().q(4);
            n(4);
            for (com.transsion.player.orplayer.e eVar2 : this.g) {
                if (eVar2 != null) {
                    eVar2.onVideoPause(eVar);
                }
            }
            com.transsion.audio.player.a aVar = this.c;
            if (aVar != null) {
                aVar.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(gn.e eVar) {
        com.transsion.audio.view.d.k().q(3);
        n(3);
        for (com.transsion.player.orplayer.e eVar2 : this.g) {
            if (eVar2 != null) {
                eVar2.onVideoStart(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.c;
        if (aVar != null) {
            aVar.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(PlayError playError, gn.e eVar) {
        n(7);
        for (com.transsion.player.orplayer.e eVar2 : this.g) {
            if (eVar2 != null) {
                eVar2.onPlayError(playError, eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.c;
        if (aVar != null) {
            aVar.e(playError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(gn.e eVar) {
        n(0);
        com.transsion.audio.view.d.k().q(0);
        for (com.transsion.player.orplayer.e eVar2 : this.g) {
            if (eVar2 != null) {
                eVar2.onPlayerRelease(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(long j2, gn.e eVar) {
        com.transsion.audio.view.d.k().p(Long.valueOf(j2), Long.valueOf(this.a));
        AudioBean audioBean = this.e;
        if (audioBean != null) {
            audioBean.setReadProcess(Long.valueOf(j2));
        }
        if (System.currentTimeMillis() - this.d > 1000) {
            for (com.transsion.player.orplayer.e eVar2 : this.g) {
                if (eVar2 != null) {
                    eVar2.onProgress(j2, eVar);
                }
            }
            AudioBean audioBean2 = this.e;
            if (audioBean2 != null) {
                HistoryListManager.e.b().w(audioBean2);
            }
            this.d = System.currentTimeMillis();
            String str = this.h;
            AudioBean audioBean3 = this.e;
            if (!TextUtils.equals(str, audioBean3 != null ? audioBean3.getAudioUrl() : null)) {
                AudioBean audioBean4 = this.e;
                this.h = audioBean4 != null ? audioBean4.getAudioUrl() : null;
            }
        }
        com.transsion.audio.player.a aVar = this.c;
        if (aVar != null) {
            aVar.f(j2);
        }
    }

    private final void n(int i2) {
        AudioBean audioBean = this.e;
        int status = audioBean != null ? audioBean.getStatus() : 1;
        switch (i2) {
            case 2:
            case 3:
                status = 3;
                break;
            case 4:
            case 5:
                status = 4;
                break;
            case 6:
                status = 6;
                break;
            case 7:
                status = 7;
                break;
        }
        AudioBean audioBean2 = this.e;
        if (audioBean2 == null || audioBean2.getStatus() != 6 || status < 4) {
            AudioBean audioBean3 = this.e;
            if (audioBean3 != null) {
                audioBean3.setStatus(status);
            }
            AudioBean audioBean4 = this.e;
            if (audioBean4 != null) {
                HistoryListManager.e.b().k(audioBean4);
            }
            a.a aVar = wf.a.a;
            AudioBean audioBean5 = this.e;
            Integer valueOf = audioBean5 != null ? Integer.valueOf(audioBean5.getStatus()) : null;
            AudioBean audioBean6 = this.e;
            a.a.f(aVar, "audio_log", "onStateChanged " + valueOf + " ..title.. " + (audioBean6 != null ? audioBean6.getTitle() : null), false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(gn.e eVar) {
        n(6);
        com.transsion.audio.view.d.k().q(6);
        for (com.transsion.player.orplayer.e eVar2 : this.g) {
            if (eVar2 != null) {
                eVar2.onCompletion(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        this.c = null;
    }

    private final void w() {
        l lVar = new l(Utils.a());
        this.b = lVar;
        lVar.setPlayerListener(new com.transsion.player.orplayer.e() { // from class: com.transsion.audio.player.AudioPlayer$initPlayer$1
            @Override // com.transsion.player.orplayer.e
            public void canNonSubscriberPlay(boolean z, int i2, int i3, qn.d dVar) {
                e.a.a(this, z, i2, i3, dVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void initPlayer() {
                e.a.b(this);
                a.a.f(wf.a.a, "audio_log", "AudioPlayer --> initPlayer --> initPlayer ...", false, 4, (Object) null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onAliyunDecodeErrorChangeSoftwareDecoder(gn.e eVar) {
                e.a.c(this, eVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onBufferedPosition(long j2, gn.e eVar) {
                e.a.d(this, j2, eVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onCompletion(gn.e eVar) {
                e.a.e(this, eVar);
                AudioPlayer.this.o(eVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onFocusChange(boolean z) {
                e.a.g(this, z);
            }

            @Override // com.transsion.player.orplayer.e
            public void onIsPlayingChanged(boolean z) {
                AudioPlayer.this.A(z);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingBegin(gn.e eVar) {
                e.a.i(this, eVar);
                AudioPlayer.this.B(eVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingEnd(gn.e eVar) {
                e.a.k(this, eVar);
                AudioPlayer.this.C(eVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onLoadingProgress(int i2, float f, gn.e eVar) {
                e.a.m(this, i2, f, eVar);
                AudioPlayer.this.D(i2, f, eVar);
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
                AudioPlayer.this.H(playError, eVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayerRelease(gn.e eVar) {
                e.a.t(this, eVar);
                AudioPlayer.this.I(eVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPlayerReset() {
                e.a.v(this);
            }

            @Override // com.transsion.player.orplayer.e
            public void onPrepare(gn.e eVar) {
                e.a.w(this, eVar);
                a.a.f(wf.a.a, "audio_log", "AudioPlayer --> initPlayer -->onPrepare ...", false, 4, (Object) null);
                AudioPlayer audioPlayer = AudioPlayer.this;
                com.transsion.player.orplayer.f v = audioPlayer.v();
                audioPlayer.Q(v != null ? v.getDuration() : 1L);
                AudioBean u = AudioPlayer.this.u();
                if (u != null) {
                    u.setDuration(Long.valueOf(AudioPlayer.this.s()));
                }
                AudioPlayer audioPlayer2 = AudioPlayer.this;
                audioPlayer2.R(audioPlayer2.u());
                if (AudioPlayer.this.t() == null) {
                    com.transsion.player.orplayer.f v2 = AudioPlayer.this.v();
                    if (v2 != null) {
                        v2.play();
                        return;
                    }
                    return;
                }
                kotlinx.coroutines.i.d(o0.a(y0.a()), (CoroutineContext) null, (CoroutineStart) null, new AudioPlayer$initPlayer$1$onPrepare$1(AudioPlayer.this, null), 3, (Object) null);
                com.transsion.player.orplayer.f v3 = AudioPlayer.this.v();
                if (v3 != null) {
                    v3.play();
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onProgress(long j2, gn.e eVar) {
                e.a.y(this, j2, eVar);
                AudioPlayer.this.M(j2, eVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onRenderFirstFrame() {
                e.a.A(this);
                a r = AudioPlayer.this.r();
                if (r != null) {
                    r.g();
                }
            }

            @Override // com.transsion.player.orplayer.e
            public void onSetDataSource() {
                e.a.B(this);
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksAudioBitrateChange(int i2) {
                e.a.C(this, i2);
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksChange(qn.c cVar) {
                e.a.D(this, cVar);
            }

            @Override // com.transsion.player.orplayer.e
            public void onTracksVideoBitrateChange(int i2) {
                e.a.E(this, i2);
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoPause(gn.e eVar) {
                e.a.F(this, eVar);
                AudioPlayer.this.E(eVar);
                a.a.f(wf.a.a, "player", "AudioPlayer --> initPlayer --> onStateChanged 4 ...", false, 4, (Object) null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoSizeChanged(int i2, int i3) {
                e.a.H(this, i2, i3);
                a.a.f(wf.a.a, "audio_log", "AudioPlayer --> initPlayer --> onVideoSizeChanged ...", false, 4, (Object) null);
            }

            @Override // com.transsion.player.orplayer.e
            public void onVideoStart(gn.e eVar) {
                e.a.I(this, eVar);
                AudioPlayer.this.F(eVar);
                a.a.f(wf.a.a, "player", "onStateChanged 3 ...", false, 4, (Object) null);
            }

            @Override // com.transsion.player.orplayer.e
            public void setOnSeekCompleteListener() {
                e.a.K(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioPlayer x() {
        return new AudioPlayer();
    }

    public final void G() {
        com.transsion.player.orplayer.f fVar = this.b;
        if (fVar != null) {
            fVar.pause();
        }
    }

    public final boolean J() {
        com.transsion.player.orplayer.f fVar = this.b;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    public final void K() {
        com.transsion.player.orplayer.f fVar = this.b;
        if (fVar != null) {
            fVar.prepare();
        }
    }

    public final void L(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audio");
        if (this.b == null) {
            w();
        }
        a.a.f(wf.a.a, "audio_log", "AudioPlayer --> prepare --> " + audioBean, false, 4, (Object) null);
        this.f = audioBean;
        com.transsion.audio.player.a aVar = this.c;
        if (aVar != null) {
            if (aVar != null) {
                aVar.b();
            }
            this.c = null;
        }
        this.c = new com.transsion.audio.player.a(audioBean);
        String url = audioBean.getUrl();
        if (url != null) {
            com.transsion.player.orplayer.f fVar = this.b;
            if (fVar != null) {
                fVar.stop();
            }
            com.transsion.player.orplayer.f fVar2 = this.b;
            if (fVar2 != null) {
                fVar2.setDataSource(new gn.e(url, url, 0, null, null, 28, null));
            }
            com.transsion.player.orplayer.f fVar3 = this.b;
            if (fVar3 != null) {
                fVar3.prepare();
            }
        }
        for (com.transsion.player.orplayer.e eVar : this.g) {
            if (eVar != null) {
                eVar.onPrepare(new gn.e(audioBean.getAudioUrl(), audioBean.getAudioUrl(), 0, null, null, 28, null));
            }
        }
    }

    public final void N() {
        com.transsion.player.orplayer.f fVar = this.b;
        if (fVar != null) {
            fVar.release();
        }
        this.b = null;
        this.e = null;
        com.transsion.audio.player.a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        this.c = null;
    }

    public final void O(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        this.g.remove(eVar);
    }

    public final void P(long j2) {
        com.transsion.player.orplayer.f fVar = this.b;
        if (fVar != null) {
            fVar.seekTo(j2);
        }
    }

    public final void Q(long j2) {
        this.a = j2;
    }

    public final void R(AudioBean audioBean) {
        this.e = audioBean;
    }

    public final void S() {
        com.transsion.player.orplayer.f fVar = this.b;
        if (fVar != null) {
            fVar.play();
        }
    }

    public final void T() {
        com.transsion.player.orplayer.f fVar = this.b;
        if (fVar != null) {
            fVar.stop();
        }
    }

    public final void m(com.transsion.player.orplayer.e eVar) {
        Intrinsics.h(eVar, "listener");
        this.g.add(eVar);
    }

    public final boolean p() {
        return this.b == null;
    }

    public final void q() {
        com.transsion.player.orplayer.f fVar = this.b;
        if (fVar != null) {
            fVar.stop();
        }
        N();
    }

    public final com.transsion.audio.player.a r() {
        return this.c;
    }

    public final long s() {
        return this.a;
    }

    public final AudioBean t() {
        return this.e;
    }

    public final AudioBean u() {
        return this.f;
    }

    public final com.transsion.player.orplayer.f v() {
        return this.b;
    }

    public final boolean y(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audio");
        String audioUrl = audioBean.getAudioUrl();
        AudioBean audioBean2 = this.e;
        return TextUtils.equals(audioUrl, audioBean2 != null ? audioBean2.getAudioUrl() : null);
    }

    public final boolean z(String str) {
        Intrinsics.h(str, "audioUrl");
        AudioBean audioBean = this.e;
        return TextUtils.equals(str, audioBean != null ? audioBean.getAudioUrl() : null);
    }
}
