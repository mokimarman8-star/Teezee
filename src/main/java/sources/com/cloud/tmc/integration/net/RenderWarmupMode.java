package com.cloud.tmc.integration.net;

import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.model.BaseBean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/cloud/tmc/integration/net/RenderWarmupMode;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "open", "", "cacheSize", "", "(ZI)V", "getCacheSize", "()I", "getOpen", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class RenderWarmupMode extends BaseBean {
    private final int cacheSize;
    private final boolean open;

    public RenderWarmupMode(boolean z, int i) {
        this.open = z;
        this.cacheSize = i;
    }

    public static /* synthetic */ RenderWarmupMode copy$default(RenderWarmupMode renderWarmupMode, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = renderWarmupMode.open;
        }
        if ((i2 & 2) != 0) {
            i = renderWarmupMode.cacheSize;
        }
        return renderWarmupMode.copy(z, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOpen() {
        return this.open;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final RenderWarmupMode copy(boolean open, int cacheSize) {
        return new RenderWarmupMode(open, cacheSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenderWarmupMode)) {
            return false;
        }
        RenderWarmupMode renderWarmupMode = (RenderWarmupMode) other;
        return this.open == renderWarmupMode.open && this.cacheSize == renderWarmupMode.cacheSize;
    }

    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final boolean getOpen() {
        return this.open;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.open;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.cacheSize;
    }

    public String toString() {
        return "RenderWarmupMode(open=" + this.open + ", cacheSize=" + this.cacheSize + ")";
    }
}
