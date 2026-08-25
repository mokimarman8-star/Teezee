package com.transsion.upgradesdk.bean;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/transsion/upgradesdk/bean/UpgradeInfo;", "Ljava/io/Serializable;", "isNewVersion", HttpUrl.FRAGMENT_ENCODE_SET, "showUpgradeDialog", "isForceUpgrade", "versionName", HttpUrl.FRAGMENT_ENCODE_SET, "(ZZZLjava/lang/String;)V", "()Z", "getShowUpgradeDialog", "getVersionName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "upgradesdk_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class UpgradeInfo implements Serializable {
    private final boolean isForceUpgrade;
    private final boolean isNewVersion;
    private final boolean showUpgradeDialog;
    private final String versionName;

    public UpgradeInfo(boolean z, boolean z2, boolean z3, String str) {
        this.isNewVersion = z;
        this.showUpgradeDialog = z2;
        this.isForceUpgrade = z3;
        this.versionName = str;
    }

    public static /* synthetic */ UpgradeInfo copy$default(UpgradeInfo upgradeInfo, boolean z, boolean z2, boolean z3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = upgradeInfo.isNewVersion;
        }
        if ((i & 2) != 0) {
            z2 = upgradeInfo.showUpgradeDialog;
        }
        if ((i & 4) != 0) {
            z3 = upgradeInfo.isForceUpgrade;
        }
        if ((i & 8) != 0) {
            str = upgradeInfo.versionName;
        }
        return upgradeInfo.copy(z, z2, z3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsNewVersion() {
        return this.isNewVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShowUpgradeDialog() {
        return this.showUpgradeDialog;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsForceUpgrade() {
        return this.isForceUpgrade;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    public final UpgradeInfo copy(boolean isNewVersion, boolean showUpgradeDialog, boolean isForceUpgrade, String versionName) {
        return new UpgradeInfo(isNewVersion, showUpgradeDialog, isForceUpgrade, versionName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpgradeInfo)) {
            return false;
        }
        UpgradeInfo upgradeInfo = (UpgradeInfo) other;
        return this.isNewVersion == upgradeInfo.isNewVersion && this.showUpgradeDialog == upgradeInfo.showUpgradeDialog && this.isForceUpgrade == upgradeInfo.isForceUpgrade && Intrinsics.c(this.versionName, upgradeInfo.versionName);
    }

    public final boolean getShowUpgradeDialog() {
        return this.showUpgradeDialog;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.isNewVersion;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.showUpgradeDialog;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z2 = this.isForceUpgrade;
        int i4 = (i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        String str = this.versionName;
        return i4 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isForceUpgrade() {
        return this.isForceUpgrade;
    }

    public final boolean isNewVersion() {
        return this.isNewVersion;
    }

    public String toString() {
        return "UpgradeInfo(isNewVersion=" + this.isNewVersion + ", showUpgradeDialog=" + this.showUpgradeDialog + ", isForceUpgrade=" + this.isForceUpgrade + ", versionName=" + this.versionName + ')';
    }
}
