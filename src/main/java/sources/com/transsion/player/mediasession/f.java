package com.transsion.player.mediasession;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import on.e0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends MediaSessionCompat.b {
    public static final a i = new a(null);
    private final MediaSessionCompat f;
    private final MediaService g;
    private MediaItem h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(MediaSessionCompat mediaSessionCompat, MediaService mediaService) {
        Intrinsics.h(mediaService, "mediaService");
        this.f = mediaSessionCompat;
        this.g = mediaService;
    }

    private final void E(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat != null) {
            h.a.o(this.g, this.h, Integer.valueOf(playbackStateCompat.getState()), this.f);
        }
    }

    private final String F() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final PlaybackStateCompat G(int i2) {
        Long position;
        MediaItem mediaItem = this.h;
        PlaybackStateCompat a2 = new PlaybackStateCompat.d().b(775L).c(i2, (mediaItem == null || (position = mediaItem.getPosition()) == null) ? 0L : position.longValue(), 1.0f).a();
        MediaSessionCompat mediaSessionCompat = this.f;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.i(a2);
        }
        Intrinsics.e(a2);
        return a2;
    }

    public void A() {
        super.A();
        i.a.a(F() + " --> mediaSessionCallback --> onSkipToPrevious() -- 暂不处理该事件");
    }

    public void C() {
        super.C();
        i.a.a(F() + " --> mediaSessionCallback --> onStop()");
        G(1);
        com.transsion.player.orplayer.f e = e0.a.e();
        if (e != null) {
            e.release();
        }
    }

    public void e(String str, Bundle bundle) {
        Long duration;
        super.e(str, bundle);
        this.h = bundle != null ? (MediaItem) bundle.getParcelable("MediaItem") : null;
        if (Intrinsics.c(str, "transsion_play")) {
            MediaSessionCompat mediaSessionCompat = this.f;
            if (mediaSessionCompat != null) {
                MediaMetadataCompat.b bVar = new MediaMetadataCompat.b();
                MediaItem mediaItem = this.h;
                MediaMetadataCompat.b c = bVar.c("android.media.metadata.MEDIA_ID", mediaItem != null ? mediaItem.getMediaId() : null);
                MediaItem mediaItem2 = this.h;
                mediaSessionCompat.h(c.b("android.media.metadata.DURATION", (mediaItem2 == null || (duration = mediaItem2.getDuration()) == null) ? 0L : duration.longValue()).a());
            }
            r0 = G(3);
        } else if (Intrinsics.c(str, "transsion_pause")) {
            r0 = G(2);
        }
        E(r0);
    }

    public void h() {
        super.h();
        i.a.a(F() + " --> mediaSessionCallback --> onPause()");
        E(G(2));
        com.transsion.player.orplayer.f e = e0.a.e();
        if (e != null) {
            e.pause();
        }
    }

    public void i() {
        super.i();
        i.a.a(F() + " --> mediaSessionCallback --> onPlay()");
        E(G(3));
        com.transsion.player.orplayer.f e = e0.a.e();
        if (e != null) {
            e.play();
        }
    }

    public void s(long j) {
        super.s(j);
        MediaItem mediaItem = this.h;
        if (mediaItem != null) {
            mediaItem.setPosition(Long.valueOf(j));
        }
        i.a.a(F() + " --> mediaSessionCallback --> onSeekTo() --> mediaItem = " + this.h);
        com.transsion.player.orplayer.f e = e0.a.e();
        if (e != null) {
            e.seekTo(j);
        }
    }

    public void z() {
        super.z();
        i.a.a(F() + " --> mediaSessionCallback --> onSkipToNext() -- 暂不处理该事件");
    }
}
