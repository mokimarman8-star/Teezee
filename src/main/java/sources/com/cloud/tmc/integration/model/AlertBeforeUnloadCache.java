package com.cloud.tmc.integration.model;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.kernel.model.BaseBean;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/cloud/tmc/integration/model/AlertBeforeUnloadCache;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "Ljava/io/Serializable;", "enabled", "", PglCryptUtils.KEY_MESSAGE, "", "(ZLjava/lang/String;)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class AlertBeforeUnloadCache extends BaseBean implements Serializable {
    private boolean enabled;
    private String message;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AlertBeforeUnloadCache() {
        this(false, r0, 3, r0);
        String str = null;
    }

    public AlertBeforeUnloadCache(boolean z, String str) {
        this.enabled = z;
        this.message = str;
    }

    public /* synthetic */ AlertBeforeUnloadCache(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str);
    }

    public static /* synthetic */ AlertBeforeUnloadCache copy$default(AlertBeforeUnloadCache alertBeforeUnloadCache, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = alertBeforeUnloadCache.enabled;
        }
        if ((i & 2) != 0) {
            str = alertBeforeUnloadCache.message;
        }
        return alertBeforeUnloadCache.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final AlertBeforeUnloadCache copy(boolean enabled, String message) {
        return new AlertBeforeUnloadCache(enabled, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlertBeforeUnloadCache)) {
            return false;
        }
        AlertBeforeUnloadCache alertBeforeUnloadCache = (AlertBeforeUnloadCache) other;
        return this.enabled == alertBeforeUnloadCache.enabled && Intrinsics.c(this.message, alertBeforeUnloadCache.message);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.enabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.message;
        return i + (str == null ? 0 : str.hashCode());
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "AlertBeforeUnloadCache(enabled=" + this.enabled + ", message=" + this.message + ")";
    }
}
