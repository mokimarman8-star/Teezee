package com.cloud.tmc.integration.model;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.model.BaseBean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/cloud/tmc/integration/model/InnerWarmup;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "innerWarmUpRenderEnable", "", "innerWarmUpWorkerEnable", "renderMaxWarmupSize", "", "workerMaxWarmupSize", "(ZZII)V", "getInnerWarmUpRenderEnable", "()Z", "setInnerWarmUpRenderEnable", "(Z)V", "getInnerWarmUpWorkerEnable", "setInnerWarmUpWorkerEnable", "getRenderMaxWarmupSize", "()I", "setRenderMaxWarmupSize", "(I)V", "getWorkerMaxWarmupSize", "setWorkerMaxWarmupSize", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class InnerWarmup extends BaseBean {
    private boolean innerWarmUpRenderEnable;
    private boolean innerWarmUpWorkerEnable;
    private int renderMaxWarmupSize;
    private int workerMaxWarmupSize;

    public InnerWarmup(boolean z, boolean z2, int i, int i2) {
        this.innerWarmUpRenderEnable = z;
        this.innerWarmUpWorkerEnable = z2;
        this.renderMaxWarmupSize = i;
        this.workerMaxWarmupSize = i2;
    }

    public static /* synthetic */ InnerWarmup copy$default(InnerWarmup innerWarmup, boolean z, boolean z2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = innerWarmup.innerWarmUpRenderEnable;
        }
        if ((i3 & 2) != 0) {
            z2 = innerWarmup.innerWarmUpWorkerEnable;
        }
        if ((i3 & 4) != 0) {
            i = innerWarmup.renderMaxWarmupSize;
        }
        if ((i3 & 8) != 0) {
            i2 = innerWarmup.workerMaxWarmupSize;
        }
        return innerWarmup.copy(z, z2, i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getInnerWarmUpRenderEnable() {
        return this.innerWarmUpRenderEnable;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getInnerWarmUpWorkerEnable() {
        return this.innerWarmUpWorkerEnable;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRenderMaxWarmupSize() {
        return this.renderMaxWarmupSize;
    }

    /* renamed from: component4, reason: from getter */
    public final int getWorkerMaxWarmupSize() {
        return this.workerMaxWarmupSize;
    }

    public final InnerWarmup copy(boolean innerWarmUpRenderEnable, boolean innerWarmUpWorkerEnable, int renderMaxWarmupSize, int workerMaxWarmupSize) {
        return new InnerWarmup(innerWarmUpRenderEnable, innerWarmUpWorkerEnable, renderMaxWarmupSize, workerMaxWarmupSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InnerWarmup)) {
            return false;
        }
        InnerWarmup innerWarmup = (InnerWarmup) other;
        return this.innerWarmUpRenderEnable == innerWarmup.innerWarmUpRenderEnable && this.innerWarmUpWorkerEnable == innerWarmup.innerWarmUpWorkerEnable && this.renderMaxWarmupSize == innerWarmup.renderMaxWarmupSize && this.workerMaxWarmupSize == innerWarmup.workerMaxWarmupSize;
    }

    public final boolean getInnerWarmUpRenderEnable() {
        return this.innerWarmUpRenderEnable;
    }

    public final boolean getInnerWarmUpWorkerEnable() {
        return this.innerWarmUpWorkerEnable;
    }

    public final int getRenderMaxWarmupSize() {
        return this.renderMaxWarmupSize;
    }

    public final int getWorkerMaxWarmupSize() {
        return this.workerMaxWarmupSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.innerWarmUpRenderEnable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.innerWarmUpWorkerEnable;
        return ((((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.renderMaxWarmupSize) * 31) + this.workerMaxWarmupSize;
    }

    public final void setInnerWarmUpRenderEnable(boolean z) {
        this.innerWarmUpRenderEnable = z;
    }

    public final void setInnerWarmUpWorkerEnable(boolean z) {
        this.innerWarmUpWorkerEnable = z;
    }

    public final void setRenderMaxWarmupSize(int i) {
        this.renderMaxWarmupSize = i;
    }

    public final void setWorkerMaxWarmupSize(int i) {
        this.workerMaxWarmupSize = i;
    }

    public String toString() {
        return "InnerWarmup(innerWarmUpRenderEnable=" + this.innerWarmUpRenderEnable + ", innerWarmUpWorkerEnable=" + this.innerWarmUpWorkerEnable + ", renderMaxWarmupSize=" + this.renderMaxWarmupSize + ", workerMaxWarmupSize=" + this.workerMaxWarmupSize + ")";
    }
}
