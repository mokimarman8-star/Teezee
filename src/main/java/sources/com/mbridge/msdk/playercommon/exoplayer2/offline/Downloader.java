package com.mbridge.msdk.playercommon.exoplayer2.offline;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface Downloader {
    void cancel();

    void download() throws InterruptedException, IOException;

    float getDownloadPercentage();

    long getDownloadedBytes();

    void remove() throws InterruptedException;
}
