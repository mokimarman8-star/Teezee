package com.transsnet.downloader.core.thread;

import com.transsion.baselib.db.download.DownloadException;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB'\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bB\u001d\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\f¨\u0006\r"}, d2 = {"Lcom/transsnet/downloader/core/thread/DownloadPathException;", "Lcom/transsion/baselib/db/download/DownloadException;", "code", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "(I)V", "message", HttpUrl.FRAGMENT_ENCODE_SET, "(ILjava/lang/String;)V", "cause", HttpUrl.FRAGMENT_ENCODE_SET, "(ILjava/lang/String;Ljava/lang/Throwable;)V", "(ILjava/lang/Throwable;)V", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadPathException extends DownloadException {
    public DownloadPathException(int i) {
        super(i);
    }

    public DownloadPathException(int i, String str) {
        super(i, str);
    }

    public DownloadPathException(int i, String str, Throwable th) {
        super(i, str, th);
    }

    public DownloadPathException(int i, Throwable th) {
        super(i, th);
    }
}
