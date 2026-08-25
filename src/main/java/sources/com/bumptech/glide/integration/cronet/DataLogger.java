package com.bumptech.glide.integration.cronet;

import androidx.annotation.Nullable;
import org.chromium.net.UrlResponseInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface DataLogger {
    void logNetworkData(@Nullable UrlResponseInfo urlResponseInfo, long j, long j2, long j3);
}
