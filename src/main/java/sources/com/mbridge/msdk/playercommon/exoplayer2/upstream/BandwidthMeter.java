package com.mbridge.msdk.playercommon.exoplayer2.upstream;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface BandwidthMeter {

    public interface EventListener {
        void onBandwidthSample(int i, long j, long j2);
    }

    long getBitrateEstimate();
}
