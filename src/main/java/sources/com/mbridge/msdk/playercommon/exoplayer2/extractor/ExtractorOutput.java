package com.mbridge.msdk.playercommon.exoplayer2.extractor;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface ExtractorOutput {
    void endTracks();

    void seekMap(SeekMap seekMap);

    TrackOutput track(int i, int i2);
}
