package com.cloud.tmc.integration.model;

import androidx.collection.s;
import com.cloud.tmc.integration.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/cloud/tmc/integration/model/StartTime;", "", "startTime", "", "(J)V", "getStartTime", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class StartTime {
    private final long startTime;

    public StartTime() {
        this(0L, 1, null);
    }

    public StartTime(long j) {
        this.startTime = j;
    }

    public /* synthetic */ StartTime(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j);
    }

    public static /* synthetic */ StartTime copy$default(StartTime startTime, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = startTime.startTime;
        }
        return startTime.copy(j);
    }

    /* renamed from: component1, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public final StartTime copy(long startTime) {
        return new StartTime(startTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StartTime) && this.startTime == ((StartTime) other).startTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return s.a(this.startTime);
    }

    public String toString() {
        return "StartTime(startTime=" + this.startTime + ")";
    }
}
