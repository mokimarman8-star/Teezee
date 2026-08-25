package com.cloud.tmc.integration.performance;

import androidx.collection.s;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.model.BaseBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/cloud/tmc/integration/performance/InnerWarmupSettingData;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "renderWaitTime", "", "workerWaitTime", "(JJ)V", "getRenderWaitTime", "()J", "getWorkerWaitTime", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class InnerWarmupSettingData extends BaseBean {
    private final long renderWaitTime;
    private final long workerWaitTime;

    public InnerWarmupSettingData() {
        this(0L, 0L, 3, null);
    }

    public InnerWarmupSettingData(long j, long j2) {
        this.renderWaitTime = j;
        this.workerWaitTime = j2;
    }

    public /* synthetic */ InnerWarmupSettingData(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }

    public static /* synthetic */ InnerWarmupSettingData copy$default(InnerWarmupSettingData innerWarmupSettingData, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = innerWarmupSettingData.renderWaitTime;
        }
        if ((i & 2) != 0) {
            j2 = innerWarmupSettingData.workerWaitTime;
        }
        return innerWarmupSettingData.copy(j, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRenderWaitTime() {
        return this.renderWaitTime;
    }

    /* renamed from: component2, reason: from getter */
    public final long getWorkerWaitTime() {
        return this.workerWaitTime;
    }

    public final InnerWarmupSettingData copy(long renderWaitTime, long workerWaitTime) {
        return new InnerWarmupSettingData(renderWaitTime, workerWaitTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InnerWarmupSettingData)) {
            return false;
        }
        InnerWarmupSettingData innerWarmupSettingData = (InnerWarmupSettingData) other;
        return this.renderWaitTime == innerWarmupSettingData.renderWaitTime && this.workerWaitTime == innerWarmupSettingData.workerWaitTime;
    }

    public final long getRenderWaitTime() {
        return this.renderWaitTime;
    }

    public final long getWorkerWaitTime() {
        return this.workerWaitTime;
    }

    public int hashCode() {
        return (s.a(this.renderWaitTime) * 31) + s.a(this.workerWaitTime);
    }

    public String toString() {
        return "InnerWarmupSettingData(renderWaitTime=" + this.renderWaitTime + ", workerWaitTime=" + this.workerWaitTime + ")";
    }
}
