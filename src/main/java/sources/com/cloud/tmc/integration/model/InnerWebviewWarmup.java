package com.cloud.tmc.integration.model;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.model.BaseBean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/cloud/tmc/integration/model/InnerWebviewWarmup;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "innerWarmUpWebviewEnable", "", "webviewMaxWarmupSize", "", "(ZI)V", "getInnerWarmUpWebviewEnable", "()Z", "setInnerWarmUpWebviewEnable", "(Z)V", "getWebviewMaxWarmupSize", "()I", "setWebviewMaxWarmupSize", "(I)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class InnerWebviewWarmup extends BaseBean {
    private boolean innerWarmUpWebviewEnable;
    private int webviewMaxWarmupSize;

    public InnerWebviewWarmup(boolean z, int i) {
        this.innerWarmUpWebviewEnable = z;
        this.webviewMaxWarmupSize = i;
    }

    public static /* synthetic */ InnerWebviewWarmup copy$default(InnerWebviewWarmup innerWebviewWarmup, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = innerWebviewWarmup.innerWarmUpWebviewEnable;
        }
        if ((i2 & 2) != 0) {
            i = innerWebviewWarmup.webviewMaxWarmupSize;
        }
        return innerWebviewWarmup.copy(z, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getInnerWarmUpWebviewEnable() {
        return this.innerWarmUpWebviewEnable;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWebviewMaxWarmupSize() {
        return this.webviewMaxWarmupSize;
    }

    public final InnerWebviewWarmup copy(boolean innerWarmUpWebviewEnable, int webviewMaxWarmupSize) {
        return new InnerWebviewWarmup(innerWarmUpWebviewEnable, webviewMaxWarmupSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InnerWebviewWarmup)) {
            return false;
        }
        InnerWebviewWarmup innerWebviewWarmup = (InnerWebviewWarmup) other;
        return this.innerWarmUpWebviewEnable == innerWebviewWarmup.innerWarmUpWebviewEnable && this.webviewMaxWarmupSize == innerWebviewWarmup.webviewMaxWarmupSize;
    }

    public final boolean getInnerWarmUpWebviewEnable() {
        return this.innerWarmUpWebviewEnable;
    }

    public final int getWebviewMaxWarmupSize() {
        return this.webviewMaxWarmupSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.innerWarmUpWebviewEnable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.webviewMaxWarmupSize;
    }

    public final void setInnerWarmUpWebviewEnable(boolean z) {
        this.innerWarmUpWebviewEnable = z;
    }

    public final void setWebviewMaxWarmupSize(int i) {
        this.webviewMaxWarmupSize = i;
    }

    public String toString() {
        return "InnerWebviewWarmup(innerWarmUpWebviewEnable=" + this.innerWarmUpWebviewEnable + ", webviewMaxWarmupSize=" + this.webviewMaxWarmupSize + ")";
    }
}
