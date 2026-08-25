package com.mbridge.msdk.playercommon.exoplayer2.upstream;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface TransferListener<S> {
    void onBytesTransferred(S s, int i);

    void onTransferEnd(S s);

    void onTransferStart(S s, DataSpec dataSpec);
}
