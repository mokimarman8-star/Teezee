package com.cloud.tmc.integration.model;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.model.BaseBean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/cloud/tmc/integration/model/WorkerWarmup;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "open", "", "lazyLoad", "cacheSize", "", "(ZZI)V", "getCacheSize", "()I", "setCacheSize", "(I)V", "getLazyLoad", "()Z", "setLazyLoad", "(Z)V", "getOpen", "setOpen", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class WorkerWarmup extends BaseBean {
    private int cacheSize;
    private boolean lazyLoad;
    private boolean open;

    public WorkerWarmup(boolean z, boolean z2, int i) {
        this.open = z;
        this.lazyLoad = z2;
        this.cacheSize = i;
    }

    public static /* synthetic */ WorkerWarmup copy$default(WorkerWarmup workerWarmup, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = workerWarmup.open;
        }
        if ((i2 & 2) != 0) {
            z2 = workerWarmup.lazyLoad;
        }
        if ((i2 & 4) != 0) {
            i = workerWarmup.cacheSize;
        }
        return workerWarmup.copy(z, z2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOpen() {
        return this.open;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getLazyLoad() {
        return this.lazyLoad;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final WorkerWarmup copy(boolean open, boolean lazyLoad, int cacheSize) {
        return new WorkerWarmup(open, lazyLoad, cacheSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkerWarmup)) {
            return false;
        }
        WorkerWarmup workerWarmup = (WorkerWarmup) other;
        return this.open == workerWarmup.open && this.lazyLoad == workerWarmup.lazyLoad && this.cacheSize == workerWarmup.cacheSize;
    }

    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final boolean getLazyLoad() {
        return this.lazyLoad;
    }

    public final boolean getOpen() {
        return this.open;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.open;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.lazyLoad;
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.cacheSize;
    }

    public final void setCacheSize(int i) {
        this.cacheSize = i;
    }

    public final void setLazyLoad(boolean z) {
        this.lazyLoad = z;
    }

    public final void setOpen(boolean z) {
        this.open = z;
    }

    public String toString() {
        return "WorkerWarmup(open=" + this.open + ", lazyLoad=" + this.lazyLoad + ", cacheSize=" + this.cacheSize + ")";
    }
}
