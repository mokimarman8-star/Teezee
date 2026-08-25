package com.mbridge.msdk.playercommon.exoplayer2.source;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void onContinueLoadingRequested(T t);
    }

    boolean continueLoading(long j);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    void reevaluateBuffer(long j);
}
