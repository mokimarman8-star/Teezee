package com.transsion.version.update;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.collection.s;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okio.internal.Buffer;

@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u008d\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0006\u00104\u001a\u000205J\u0013\u00106\u001a\u00020\u00032\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u000205HÖ\u0001J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u000205R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006@"}, d2 = {"Lcom/transsion/version/update/RemoteVersionInfo;", "Landroid/os/Parcelable;", "hasUpdate", HttpUrl.FRAGMENT_ENCODE_SET, "forceUpdate", "patchUrl", HttpUrl.FRAGMENT_ENCODE_SET, "patchMd5", "patchSize", HttpUrl.FRAGMENT_ENCODE_SET, "installPkgUrl", "installPkgVersionCode", "installPkgMd5", "installPkgSize", "updateType", "appStoreUrl", "webDownloadUrl", "noticeConfig", "Lcom/transsion/version/update/NoticeConfig;", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/version/update/NoticeConfig;)V", "getHasUpdate", "()Z", "getForceUpdate", "getPatchUrl", "()Ljava/lang/String;", "getPatchMd5", "getPatchSize", "()J", "getInstallPkgUrl", "getInstallPkgVersionCode", "getInstallPkgMd5", "getInstallPkgSize", "getUpdateType", "getAppStoreUrl", "getWebDownloadUrl", "getNoticeConfig", "()Lcom/transsion/version/update/NoticeConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "describeContents", HttpUrl.FRAGMENT_ENCODE_SET, "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "toString", "writeToParcel", HttpUrl.FRAGMENT_ENCODE_SET, "dest", "Landroid/os/Parcel;", "flags", "Update_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class RemoteVersionInfo implements Parcelable {
    public static final Parcelable.Creator<RemoteVersionInfo> CREATOR = new a();
    private final String appStoreUrl;
    private final boolean forceUpdate;
    private final boolean hasUpdate;
    private final String installPkgMd5;
    private final long installPkgSize;
    private final String installPkgUrl;
    private final long installPkgVersionCode;
    private final NoticeConfig noticeConfig;
    private final String patchMd5;
    private final long patchSize;
    private final String patchUrl;
    private final String updateType;
    private final String webDownloadUrl;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RemoteVersionInfo createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new RemoteVersionInfo(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : NoticeConfig.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RemoteVersionInfo[] newArray(int i) {
            return new RemoteVersionInfo[i];
        }
    }

    public RemoteVersionInfo(boolean z, boolean z2, String patchUrl, String patchMd5, long j, String installPkgUrl, long j2, String installPkgMd5, long j3, String updateType, String appStoreUrl, String webDownloadUrl, NoticeConfig noticeConfig) {
        Intrinsics.h(patchUrl, "patchUrl");
        Intrinsics.h(patchMd5, "patchMd5");
        Intrinsics.h(installPkgUrl, "installPkgUrl");
        Intrinsics.h(installPkgMd5, "installPkgMd5");
        Intrinsics.h(updateType, "updateType");
        Intrinsics.h(appStoreUrl, "appStoreUrl");
        Intrinsics.h(webDownloadUrl, "webDownloadUrl");
        this.hasUpdate = z;
        this.forceUpdate = z2;
        this.patchUrl = patchUrl;
        this.patchMd5 = patchMd5;
        this.patchSize = j;
        this.installPkgUrl = installPkgUrl;
        this.installPkgVersionCode = j2;
        this.installPkgMd5 = installPkgMd5;
        this.installPkgSize = j3;
        this.updateType = updateType;
        this.appStoreUrl = appStoreUrl;
        this.webDownloadUrl = webDownloadUrl;
        this.noticeConfig = noticeConfig;
    }

    public /* synthetic */ RemoteVersionInfo(boolean z, boolean z2, String str, String str2, long j, String str3, long j2, String str4, long j3, String str5, String str6, String str7, NoticeConfig noticeConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, str, str2, j, str3, j2, str4, j3, (i & 512) != 0 ? b.a() : str5, (i & 1024) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str6, (i & 2048) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str7, (i & Buffer.SEGMENTING_THRESHOLD) != 0 ? null : noticeConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUpdateType() {
        return this.updateType;
    }

    /* renamed from: component11, reason: from getter */
    public final String getAppStoreUrl() {
        return this.appStoreUrl;
    }

    /* renamed from: component12, reason: from getter */
    public final String getWebDownloadUrl() {
        return this.webDownloadUrl;
    }

    /* renamed from: component13, reason: from getter */
    public final NoticeConfig getNoticeConfig() {
        return this.noticeConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPatchUrl() {
        return this.patchUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPatchMd5() {
        return this.patchMd5;
    }

    /* renamed from: component5, reason: from getter */
    public final long getPatchSize() {
        return this.patchSize;
    }

    /* renamed from: component6, reason: from getter */
    public final String getInstallPkgUrl() {
        return this.installPkgUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final long getInstallPkgVersionCode() {
        return this.installPkgVersionCode;
    }

    /* renamed from: component8, reason: from getter */
    public final String getInstallPkgMd5() {
        return this.installPkgMd5;
    }

    /* renamed from: component9, reason: from getter */
    public final long getInstallPkgSize() {
        return this.installPkgSize;
    }

    public final RemoteVersionInfo copy(boolean hasUpdate, boolean forceUpdate, String patchUrl, String patchMd5, long patchSize, String installPkgUrl, long installPkgVersionCode, String installPkgMd5, long installPkgSize, String updateType, String appStoreUrl, String webDownloadUrl, NoticeConfig noticeConfig) {
        Intrinsics.h(patchUrl, "patchUrl");
        Intrinsics.h(patchMd5, "patchMd5");
        Intrinsics.h(installPkgUrl, "installPkgUrl");
        Intrinsics.h(installPkgMd5, "installPkgMd5");
        Intrinsics.h(updateType, "updateType");
        Intrinsics.h(appStoreUrl, "appStoreUrl");
        Intrinsics.h(webDownloadUrl, "webDownloadUrl");
        return new RemoteVersionInfo(hasUpdate, forceUpdate, patchUrl, patchMd5, patchSize, installPkgUrl, installPkgVersionCode, installPkgMd5, installPkgSize, updateType, appStoreUrl, webDownloadUrl, noticeConfig);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteVersionInfo)) {
            return false;
        }
        RemoteVersionInfo remoteVersionInfo = (RemoteVersionInfo) other;
        return this.hasUpdate == remoteVersionInfo.hasUpdate && this.forceUpdate == remoteVersionInfo.forceUpdate && Intrinsics.c(this.patchUrl, remoteVersionInfo.patchUrl) && Intrinsics.c(this.patchMd5, remoteVersionInfo.patchMd5) && this.patchSize == remoteVersionInfo.patchSize && Intrinsics.c(this.installPkgUrl, remoteVersionInfo.installPkgUrl) && this.installPkgVersionCode == remoteVersionInfo.installPkgVersionCode && Intrinsics.c(this.installPkgMd5, remoteVersionInfo.installPkgMd5) && this.installPkgSize == remoteVersionInfo.installPkgSize && Intrinsics.c(this.updateType, remoteVersionInfo.updateType) && Intrinsics.c(this.appStoreUrl, remoteVersionInfo.appStoreUrl) && Intrinsics.c(this.webDownloadUrl, remoteVersionInfo.webDownloadUrl) && Intrinsics.c(this.noticeConfig, remoteVersionInfo.noticeConfig);
    }

    public final String getAppStoreUrl() {
        return this.appStoreUrl;
    }

    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    public final String getInstallPkgMd5() {
        return this.installPkgMd5;
    }

    public final long getInstallPkgSize() {
        return this.installPkgSize;
    }

    public final String getInstallPkgUrl() {
        return this.installPkgUrl;
    }

    public final long getInstallPkgVersionCode() {
        return this.installPkgVersionCode;
    }

    public final NoticeConfig getNoticeConfig() {
        return this.noticeConfig;
    }

    public final String getPatchMd5() {
        return this.patchMd5;
    }

    public final long getPatchSize() {
        return this.patchSize;
    }

    public final String getPatchUrl() {
        return this.patchUrl;
    }

    public final String getUpdateType() {
        return this.updateType;
    }

    public final String getWebDownloadUrl() {
        return this.webDownloadUrl;
    }

    public int hashCode() {
        int a2 = ((((((((((((((((((((((androidx.compose.foundation.e.a(this.hasUpdate) * 31) + androidx.compose.foundation.e.a(this.forceUpdate)) * 31) + this.patchUrl.hashCode()) * 31) + this.patchMd5.hashCode()) * 31) + s.a(this.patchSize)) * 31) + this.installPkgUrl.hashCode()) * 31) + s.a(this.installPkgVersionCode)) * 31) + this.installPkgMd5.hashCode()) * 31) + s.a(this.installPkgSize)) * 31) + this.updateType.hashCode()) * 31) + this.appStoreUrl.hashCode()) * 31) + this.webDownloadUrl.hashCode()) * 31;
        NoticeConfig noticeConfig = this.noticeConfig;
        return a2 + (noticeConfig == null ? 0 : noticeConfig.hashCode());
    }

    public String toString() {
        return "RemoteVersionInfo(hasUpdate=" + this.hasUpdate + ", forceUpdate=" + this.forceUpdate + ", patchUrl=" + this.patchUrl + ", patchMd5=" + this.patchMd5 + ", patchSize=" + this.patchSize + ", installPkgUrl=" + this.installPkgUrl + ", installPkgVersionCode=" + this.installPkgVersionCode + ", installPkgMd5=" + this.installPkgMd5 + ", installPkgSize=" + this.installPkgSize + ", updateType=" + this.updateType + ", appStoreUrl=" + this.appStoreUrl + ", webDownloadUrl=" + this.webDownloadUrl + ", noticeConfig=" + this.noticeConfig + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.hasUpdate ? 1 : 0);
        dest.writeInt(this.forceUpdate ? 1 : 0);
        dest.writeString(this.patchUrl);
        dest.writeString(this.patchMd5);
        dest.writeLong(this.patchSize);
        dest.writeString(this.installPkgUrl);
        dest.writeLong(this.installPkgVersionCode);
        dest.writeString(this.installPkgMd5);
        dest.writeLong(this.installPkgSize);
        dest.writeString(this.updateType);
        dest.writeString(this.appStoreUrl);
        dest.writeString(this.webDownloadUrl);
        NoticeConfig noticeConfig = this.noticeConfig;
        if (noticeConfig == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            noticeConfig.writeToParcel(dest, flags);
        }
    }
}
