package com.transsion.room.api;

import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/transsion/room/api/RoomHomeRefreshCacheEvent;", "Ljava/io/Serializable;", "isRefresh", BuildConfig.FLAVOR, "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "RoomApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class RoomHomeRefreshCacheEvent implements Serializable {
    private final boolean isRefresh;

    public RoomHomeRefreshCacheEvent(boolean z) {
        this.isRefresh = z;
    }

    public static /* synthetic */ RoomHomeRefreshCacheEvent copy$default(RoomHomeRefreshCacheEvent roomHomeRefreshCacheEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = roomHomeRefreshCacheEvent.isRefresh;
        }
        return roomHomeRefreshCacheEvent.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    public final RoomHomeRefreshCacheEvent copy(boolean isRefresh) {
        return new RoomHomeRefreshCacheEvent(isRefresh);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RoomHomeRefreshCacheEvent) && this.isRefresh == ((RoomHomeRefreshCacheEvent) other).isRefresh;
    }

    public int hashCode() {
        return e.a(this.isRefresh);
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public String toString() {
        return "RoomHomeRefreshCacheEvent(isRefresh=" + this.isRefresh + ")";
    }
}
