package com.cloud.hisavana.sdk;

import com.google.android.exoplayer2.PlaybackException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface j4 {
    void a();

    void b(long j, long j2, int i);

    void c(boolean z);

    void d();

    void e(boolean z);

    void onComplete();

    void onIsPlayingChanged(boolean z);

    void onPlayerError(PlaybackException playbackException);

    void onVideoSizeChanged(int i, int i2);

    void onVolumeChanged(float f);
}
