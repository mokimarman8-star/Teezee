package com.transsion.subtitle.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/transsion/subtitle/bean/OpenSubtitleDownloadInfo;", HttpUrl.FRAGMENT_ENCODE_SET, "link", HttpUrl.FRAGMENT_ENCODE_SET, "fileName", "remaining", HttpUrl.FRAGMENT_ENCODE_SET, "resetTimeUtc", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getFileName", "getRemaining", "()I", "getResetTimeUtc", "component1", "component2", "component3", "component4", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", "toString", "VideoSubtitle_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class OpenSubtitleDownloadInfo {

    @SerializedName("file_name")
    private final String fileName;
    private final String link;
    private final int remaining;

    @SerializedName("reset_time_utc")
    private final String resetTimeUtc;

    public OpenSubtitleDownloadInfo(String link, String fileName, int i, String resetTimeUtc) {
        Intrinsics.h(link, "link");
        Intrinsics.h(fileName, "fileName");
        Intrinsics.h(resetTimeUtc, "resetTimeUtc");
        this.link = link;
        this.fileName = fileName;
        this.remaining = i;
        this.resetTimeUtc = resetTimeUtc;
    }

    public static /* synthetic */ OpenSubtitleDownloadInfo copy$default(OpenSubtitleDownloadInfo openSubtitleDownloadInfo, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = openSubtitleDownloadInfo.link;
        }
        if ((i2 & 2) != 0) {
            str2 = openSubtitleDownloadInfo.fileName;
        }
        if ((i2 & 4) != 0) {
            i = openSubtitleDownloadInfo.remaining;
        }
        if ((i2 & 8) != 0) {
            str3 = openSubtitleDownloadInfo.resetTimeUtc;
        }
        return openSubtitleDownloadInfo.copy(str, str2, i, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRemaining() {
        return this.remaining;
    }

    /* renamed from: component4, reason: from getter */
    public final String getResetTimeUtc() {
        return this.resetTimeUtc;
    }

    public final OpenSubtitleDownloadInfo copy(String link, String fileName, int remaining, String resetTimeUtc) {
        Intrinsics.h(link, "link");
        Intrinsics.h(fileName, "fileName");
        Intrinsics.h(resetTimeUtc, "resetTimeUtc");
        return new OpenSubtitleDownloadInfo(link, fileName, remaining, resetTimeUtc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenSubtitleDownloadInfo)) {
            return false;
        }
        OpenSubtitleDownloadInfo openSubtitleDownloadInfo = (OpenSubtitleDownloadInfo) other;
        return Intrinsics.c(this.link, openSubtitleDownloadInfo.link) && Intrinsics.c(this.fileName, openSubtitleDownloadInfo.fileName) && this.remaining == openSubtitleDownloadInfo.remaining && Intrinsics.c(this.resetTimeUtc, openSubtitleDownloadInfo.resetTimeUtc);
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getRemaining() {
        return this.remaining;
    }

    public final String getResetTimeUtc() {
        return this.resetTimeUtc;
    }

    public int hashCode() {
        return (((((this.link.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.remaining) * 31) + this.resetTimeUtc.hashCode();
    }

    public String toString() {
        return "OpenSubtitleDownloadInfo(link=" + this.link + ", fileName=" + this.fileName + ", remaining=" + this.remaining + ", resetTimeUtc=" + this.resetTimeUtc + ")";
    }
}
