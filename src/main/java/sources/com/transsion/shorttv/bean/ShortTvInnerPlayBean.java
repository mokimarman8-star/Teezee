package com.transsion.shorttv.bean;

import androidx.annotation.Keep;
import androidx.collection.s;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J£\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0006HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006:"}, d2 = {"Lcom/transsion/shorttv/bean/ShortTvInnerPlayBean;", BuildConfig.FLAVOR, "subjectId", BuildConfig.FLAVOR, "id", "ep", BuildConfig.FLAVOR, "se", "totalEp", "progress", BuildConfig.FLAVOR, "title", "description", "coverUrl", "thumbnail", "videoId", "videoUrl", "timeStamp", "subtitleSelectId", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getSubjectId", "()Ljava/lang/String;", "getId", "getEp", "()I", "getSe", "getTotalEp", "getProgress", "()J", "getTitle", "getDescription", "getCoverUrl", "getThumbnail", "getVideoId", "getVideoUrl", "getTimeStamp", "getSubtitleSelectId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class ShortTvInnerPlayBean {
    private final String coverUrl;
    private final String description;
    private final int ep;
    private final String id;
    private final long progress;
    private final int se;
    private final String subjectId;
    private final String subtitleSelectId;
    private final String thumbnail;
    private final long timeStamp;
    private final String title;
    private final int totalEp;
    private final String videoId;
    private final String videoUrl;

    public ShortTvInnerPlayBean(String str, String str2, int i, int i2, int i3, long j, String str3, String str4, String str5, String str6, String str7, String str8, long j2, String str9) {
        Intrinsics.h(str, "subjectId");
        Intrinsics.h(str2, "id");
        this.subjectId = str;
        this.id = str2;
        this.ep = i;
        this.se = i2;
        this.totalEp = i3;
        this.progress = j;
        this.title = str3;
        this.description = str4;
        this.coverUrl = str5;
        this.thumbnail = str6;
        this.videoId = str7;
        this.videoUrl = str8;
        this.timeStamp = j2;
        this.subtitleSelectId = str9;
    }

    public /* synthetic */ ShortTvInnerPlayBean(String str, String str2, int i, int i2, int i3, long j, String str3, String str4, String str5, String str6, String str7, String str8, long j2, String str9, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? 0L : j, (i4 & 64) != 0 ? null : str3, (i4 & 128) != 0 ? null : str4, (i4 & 256) != 0 ? null : str5, (i4 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? null : str6, (i4 & 1024) != 0 ? null : str7, (i4 & 2048) != 0 ? null : str8, (i4 & 4096) != 0 ? 0L : j2, (i4 & 8192) != 0 ? null : str9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    /* renamed from: component11, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    /* renamed from: component12, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* renamed from: component13, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    /* renamed from: component14, reason: from getter */
    public final String getSubtitleSelectId() {
        return this.subtitleSelectId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final int getEp() {
        return this.ep;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSe() {
        return this.se;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTotalEp() {
        return this.totalEp;
    }

    /* renamed from: component6, reason: from getter */
    public final long getProgress() {
        return this.progress;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final ShortTvInnerPlayBean copy(String subjectId, String id, int ep2, int se, int totalEp, long progress, String title, String description, String coverUrl, String thumbnail, String videoId, String videoUrl, long timeStamp, String subtitleSelectId) {
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(id, "id");
        return new ShortTvInnerPlayBean(subjectId, id, ep2, se, totalEp, progress, title, description, coverUrl, thumbnail, videoId, videoUrl, timeStamp, subtitleSelectId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShortTvInnerPlayBean)) {
            return false;
        }
        ShortTvInnerPlayBean shortTvInnerPlayBean = (ShortTvInnerPlayBean) other;
        return Intrinsics.c(this.subjectId, shortTvInnerPlayBean.subjectId) && Intrinsics.c(this.id, shortTvInnerPlayBean.id) && this.ep == shortTvInnerPlayBean.ep && this.se == shortTvInnerPlayBean.se && this.totalEp == shortTvInnerPlayBean.totalEp && this.progress == shortTvInnerPlayBean.progress && Intrinsics.c(this.title, shortTvInnerPlayBean.title) && Intrinsics.c(this.description, shortTvInnerPlayBean.description) && Intrinsics.c(this.coverUrl, shortTvInnerPlayBean.coverUrl) && Intrinsics.c(this.thumbnail, shortTvInnerPlayBean.thumbnail) && Intrinsics.c(this.videoId, shortTvInnerPlayBean.videoId) && Intrinsics.c(this.videoUrl, shortTvInnerPlayBean.videoUrl) && this.timeStamp == shortTvInnerPlayBean.timeStamp && Intrinsics.c(this.subtitleSelectId, shortTvInnerPlayBean.subtitleSelectId);
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getEp() {
        return this.ep;
    }

    public final String getId() {
        return this.id;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final int getSe() {
        return this.se;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubtitleSelectId() {
        return this.subtitleSelectId;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTotalEp() {
        return this.totalEp;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.subjectId.hashCode() * 31) + this.id.hashCode()) * 31) + this.ep) * 31) + this.se) * 31) + this.totalEp) * 31) + s.a(this.progress)) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.coverUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.thumbnail;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.videoId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.videoUrl;
        int hashCode7 = (((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + s.a(this.timeStamp)) * 31;
        String str7 = this.subtitleSelectId;
        return hashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "ShortTvInnerPlayBean(subjectId=" + this.subjectId + ", id=" + this.id + ", ep=" + this.ep + ", se=" + this.se + ", totalEp=" + this.totalEp + ", progress=" + this.progress + ", title=" + this.title + ", description=" + this.description + ", coverUrl=" + this.coverUrl + ", thumbnail=" + this.thumbnail + ", videoId=" + this.videoId + ", videoUrl=" + this.videoUrl + ", timeStamp=" + this.timeStamp + ", subtitleSelectId=" + this.subtitleSelectId + ")";
    }
}
