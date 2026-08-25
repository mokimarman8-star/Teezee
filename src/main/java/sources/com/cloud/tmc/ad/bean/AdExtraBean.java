package com.cloud.tmc.ad.bean;

import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/cloud/tmc/ad/bean/AdExtraBean;", "Ljava/io/Serializable;", "appId", "", "testMode", "", MiniAppIpcConfig.ABILITY_SDK_VERSION, "(Ljava/lang/String;ZLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getSdkVersion", "setSdkVersion", "getTestMode", "()Z", "setTestMode", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "com.cloud.tmc.miniad"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class AdExtraBean implements Serializable {
    private String appId;
    private String sdkVersion;
    private boolean testMode;

    public AdExtraBean(String str, boolean z, String str2) {
        Intrinsics.h(str, "appId");
        Intrinsics.h(str2, MiniAppIpcConfig.ABILITY_SDK_VERSION);
        this.appId = str;
        this.testMode = z;
        this.sdkVersion = str2;
    }

    public static /* synthetic */ AdExtraBean copy$default(AdExtraBean adExtraBean, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adExtraBean.appId;
        }
        if ((i & 2) != 0) {
            z = adExtraBean.testMode;
        }
        if ((i & 4) != 0) {
            str2 = adExtraBean.sdkVersion;
        }
        return adExtraBean.copy(str, z, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getTestMode() {
        return this.testMode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final AdExtraBean copy(String appId, boolean testMode, String sdkVersion) {
        Intrinsics.h(appId, "appId");
        Intrinsics.h(sdkVersion, MiniAppIpcConfig.ABILITY_SDK_VERSION);
        return new AdExtraBean(appId, testMode, sdkVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdExtraBean)) {
            return false;
        }
        AdExtraBean adExtraBean = (AdExtraBean) other;
        return Intrinsics.c(this.appId, adExtraBean.appId) && this.testMode == adExtraBean.testMode && Intrinsics.c(this.sdkVersion, adExtraBean.sdkVersion);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final boolean getTestMode() {
        return this.testMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.appId.hashCode() * 31;
        boolean z = this.testMode;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.sdkVersion.hashCode();
    }

    public final void setAppId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.appId = str;
    }

    public final void setSdkVersion(String str) {
        Intrinsics.h(str, "<set-?>");
        this.sdkVersion = str;
    }

    public final void setTestMode(boolean z) {
        this.testMode = z;
    }

    public String toString() {
        return "AdExtraBean(appId=" + this.appId + ", testMode=" + this.testMode + ", sdkVersion=" + this.sdkVersion + ")";
    }
}
