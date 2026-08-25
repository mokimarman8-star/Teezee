package com.cloud.tmc.offline.download.model;

import androidx.collection.s;
import com.cloud.tmc.kernel.model.BaseBean;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/cloud/tmc/offline/download/model/ClearOfflineDownloadCacheData;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "clear", "", "intervalTime", "", "(ZJ)V", "getClear", "()Z", "getIntervalTime", "()J", "component1", "component2", "copy", "equals", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "", "toString", "", "com.cloud.tmc.offline_download"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final /* data */ class ClearOfflineDownloadCacheData extends BaseBean {
    private final boolean clear;
    private final long intervalTime;

    public ClearOfflineDownloadCacheData() {
        this(false, 0L, 3, null);
    }

    public ClearOfflineDownloadCacheData(boolean z, long j) {
        this.clear = z;
        this.intervalTime = j;
    }

    public /* synthetic */ ClearOfflineDownloadCacheData(boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0L : j);
    }

    public static /* synthetic */ ClearOfflineDownloadCacheData copy$default(ClearOfflineDownloadCacheData clearOfflineDownloadCacheData, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = clearOfflineDownloadCacheData.clear;
        }
        if ((i & 2) != 0) {
            j = clearOfflineDownloadCacheData.intervalTime;
        }
        return clearOfflineDownloadCacheData.copy(z, j);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getClear() {
        return this.clear;
    }

    /* renamed from: component2, reason: from getter */
    public final long getIntervalTime() {
        return this.intervalTime;
    }

    public final ClearOfflineDownloadCacheData copy(boolean clear, long intervalTime) {
        return new ClearOfflineDownloadCacheData(clear, intervalTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClearOfflineDownloadCacheData)) {
            return false;
        }
        ClearOfflineDownloadCacheData clearOfflineDownloadCacheData = (ClearOfflineDownloadCacheData) other;
        return this.clear == clearOfflineDownloadCacheData.clear && this.intervalTime == clearOfflineDownloadCacheData.intervalTime;
    }

    public final boolean getClear() {
        return this.clear;
    }

    public final long getIntervalTime() {
        return this.intervalTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.clear;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + s.a(this.intervalTime);
    }

    public String toString() {
        return "ClearOfflineDownloadCacheData(clear=" + this.clear + ", intervalTime=" + this.intervalTime + ")";
    }
}
