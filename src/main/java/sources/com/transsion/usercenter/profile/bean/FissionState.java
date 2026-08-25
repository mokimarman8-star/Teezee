package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/transsion/usercenter/profile/bean/FissionState;", "Ljava/io/Serializable;", "isNew", HttpUrl.FRAGMENT_ENCODE_SET, "boundInviteCode", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "(ZLjava/lang/String;)V", "()Z", "setNew", "(Z)V", "getBoundInviteCode", "()Ljava/lang/String;", "setBoundInviteCode", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class FissionState implements Serializable {
    private String boundInviteCode;
    private boolean isNew;

    public FissionState(boolean z, String str) {
        this.isNew = z;
        this.boundInviteCode = str;
    }

    public /* synthetic */ FissionState(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, str);
    }

    public static /* synthetic */ FissionState copy$default(FissionState fissionState, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fissionState.isNew;
        }
        if ((i & 2) != 0) {
            str = fissionState.boundInviteCode;
        }
        return fissionState.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsNew() {
        return this.isNew;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBoundInviteCode() {
        return this.boundInviteCode;
    }

    public final FissionState copy(boolean isNew, String boundInviteCode) {
        return new FissionState(isNew, boundInviteCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FissionState)) {
            return false;
        }
        FissionState fissionState = (FissionState) other;
        return this.isNew == fissionState.isNew && Intrinsics.c(this.boundInviteCode, fissionState.boundInviteCode);
    }

    public final String getBoundInviteCode() {
        return this.boundInviteCode;
    }

    public int hashCode() {
        int a = e.a(this.isNew) * 31;
        String str = this.boundInviteCode;
        return a + (str == null ? 0 : str.hashCode());
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final void setBoundInviteCode(String str) {
        this.boundInviteCode = str;
    }

    public final void setNew(boolean z) {
        this.isNew = z;
    }

    public String toString() {
        return "FissionState(isNew=" + this.isNew + ", boundInviteCode=" + this.boundInviteCode + ")";
    }
}
