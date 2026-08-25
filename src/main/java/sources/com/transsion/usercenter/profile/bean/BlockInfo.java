package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/transsion/usercenter/profile/bean/BlockInfo;", "Ljava/io/Serializable;", "block", HttpUrl.FRAGMENT_ENCODE_SET, "blocked", "<init>", "(ZZ)V", "getBlock", "()Z", "setBlock", "(Z)V", "getBlocked", "setBlocked", "component1", "component2", "copy", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class BlockInfo implements Serializable {
    private boolean block;
    private boolean blocked;

    public BlockInfo(boolean z, boolean z2) {
        this.block = z;
        this.blocked = z2;
    }

    public static /* synthetic */ BlockInfo copy$default(BlockInfo blockInfo, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = blockInfo.block;
        }
        if ((i & 2) != 0) {
            z2 = blockInfo.blocked;
        }
        return blockInfo.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getBlock() {
        return this.block;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getBlocked() {
        return this.blocked;
    }

    public final BlockInfo copy(boolean block, boolean blocked) {
        return new BlockInfo(block, blocked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockInfo)) {
            return false;
        }
        BlockInfo blockInfo = (BlockInfo) other;
        return this.block == blockInfo.block && this.blocked == blockInfo.blocked;
    }

    public final boolean getBlock() {
        return this.block;
    }

    public final boolean getBlocked() {
        return this.blocked;
    }

    public int hashCode() {
        return (e.a(this.block) * 31) + e.a(this.blocked);
    }

    public final void setBlock(boolean z) {
        this.block = z;
    }

    public final void setBlocked(boolean z) {
        this.blocked = z;
    }

    public String toString() {
        return "BlockInfo(block=" + this.block + ", blocked=" + this.blocked + ")";
    }
}
