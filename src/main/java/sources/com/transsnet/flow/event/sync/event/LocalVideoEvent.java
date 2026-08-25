package com.transsnet.flow.event.sync.event;

import androidx.collection.s;
import androidx.compose.foundation.e;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/transsnet/flow/event/sync/event/LocalVideoEvent;", "Ljava/io/Serializable;", "resourceId", HttpUrl.FRAGMENT_ENCODE_SET, "readProgress", HttpUrl.FRAGMENT_ENCODE_SET, "duration", "isSeries", HttpUrl.FRAGMENT_ENCODE_SET, "refreshItemAll", "<init>", "(Ljava/lang/String;JJZZ)V", "getResourceId", "()Ljava/lang/String;", "getReadProgress", "()J", "getDuration", "()Z", "getRefreshItemAll", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "FlowEvent_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class LocalVideoEvent implements Serializable {
    private final long duration;
    private final boolean isSeries;
    private final long readProgress;
    private final boolean refreshItemAll;
    private final String resourceId;

    public LocalVideoEvent(String resourceId, long j, long j2, boolean z, boolean z2) {
        Intrinsics.h(resourceId, "resourceId");
        this.resourceId = resourceId;
        this.readProgress = j;
        this.duration = j2;
        this.isSeries = z;
        this.refreshItemAll = z2;
    }

    public /* synthetic */ LocalVideoEvent(String str, long j, long j2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? -1L : j, (i & 4) == 0 ? j2 : -1L, (i & 8) != 0 ? false : z, (i & 16) == 0 ? z2 : false);
    }

    public static /* synthetic */ LocalVideoEvent copy$default(LocalVideoEvent localVideoEvent, String str, long j, long j2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = localVideoEvent.resourceId;
        }
        if ((i & 2) != 0) {
            j = localVideoEvent.readProgress;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = localVideoEvent.duration;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            z = localVideoEvent.isSeries;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = localVideoEvent.refreshItemAll;
        }
        return localVideoEvent.copy(str, j3, j4, z3, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getReadProgress() {
        return this.readProgress;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsSeries() {
        return this.isSeries;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getRefreshItemAll() {
        return this.refreshItemAll;
    }

    public final LocalVideoEvent copy(String resourceId, long readProgress, long duration, boolean isSeries, boolean refreshItemAll) {
        Intrinsics.h(resourceId, "resourceId");
        return new LocalVideoEvent(resourceId, readProgress, duration, isSeries, refreshItemAll);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalVideoEvent)) {
            return false;
        }
        LocalVideoEvent localVideoEvent = (LocalVideoEvent) other;
        return Intrinsics.c(this.resourceId, localVideoEvent.resourceId) && this.readProgress == localVideoEvent.readProgress && this.duration == localVideoEvent.duration && this.isSeries == localVideoEvent.isSeries && this.refreshItemAll == localVideoEvent.refreshItemAll;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getReadProgress() {
        return this.readProgress;
    }

    public final boolean getRefreshItemAll() {
        return this.refreshItemAll;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return (((((((this.resourceId.hashCode() * 31) + s.a(this.readProgress)) * 31) + s.a(this.duration)) * 31) + e.a(this.isSeries)) * 31) + e.a(this.refreshItemAll);
    }

    public final boolean isSeries() {
        return this.isSeries;
    }

    public String toString() {
        return "LocalVideoEvent(resourceId=" + this.resourceId + ", readProgress=" + this.readProgress + ", duration=" + this.duration + ", isSeries=" + this.isSeries + ", refreshItemAll=" + this.refreshItemAll + ")";
    }
}
