package com.transsion.shorttv.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.utils.h;
import com.transsion.shorttv.utils.i;
import gn.e;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001fJ\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\u001aJ\u0010\u0010#\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b#\u0010\u001aJ\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001fJ\u0012\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u001fJ\u0010\u0010*\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b,\u0010\u001aJ\u0010\u0010-\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b-\u0010\u001aJ\u008a\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b0\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u00104R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u00101\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u00104R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u00107\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010:R\"\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u00107\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010:R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u00101\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u00104R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010?\u001a\u0004\b@\u0010&\"\u0004\bA\u0010BR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010C\u001a\u0004\bD\u0010(\"\u0004\bE\u0010FR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00101\u001a\u0004\bG\u0010\u001f\"\u0004\bH\u00104R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010I\u001a\u0004\bJ\u0010+\"\u0004\bK\u0010LR\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00107\u001a\u0004\bM\u0010\u001a\"\u0004\bN\u0010:R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u00107\u001a\u0004\bO\u0010\u001a\"\u0004\bP\u0010:¨\u0006Q"}, d2 = {"Lcom/transsion/shorttv/bean/ShortTVItem;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "id", "subjectId", BuildConfig.FLAVOR, "se", "ep", "videoId", "Lcom/transsion/shorttv/bean/Media;", "video", "Lcom/transsion/shorttv/bean/Link;", "link", "description", BuildConfig.FLAVOR, "playProgress", "downloadStatus", "needPaid", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/transsion/shorttv/bean/Media;Lcom/transsion/shorttv/bean/Link;Ljava/lang/String;JII)V", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lgn/e;", "toMediaSource", "()Lgn/e;", "toStringAboutLock", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "()Lcom/transsion/shorttv/bean/Media;", "component7", "()Lcom/transsion/shorttv/bean/Link;", "component8", "component9", "()J", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/transsion/shorttv/bean/Media;Lcom/transsion/shorttv/bean/Link;Ljava/lang/String;JII)Lcom/transsion/shorttv/bean/ShortTVItem;", "toString", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "getSubjectId", "setSubjectId", "I", "getSe", "setSe", "(I)V", "getEp", "setEp", "getVideoId", "setVideoId", "Lcom/transsion/shorttv/bean/Media;", "getVideo", "setVideo", "(Lcom/transsion/shorttv/bean/Media;)V", "Lcom/transsion/shorttv/bean/Link;", "getLink", "setLink", "(Lcom/transsion/shorttv/bean/Link;)V", "getDescription", "setDescription", "J", "getPlayProgress", "setPlayProgress", "(J)V", "getDownloadStatus", "setDownloadStatus", "getNeedPaid", "setNeedPaid", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class ShortTVItem implements Serializable {
    private String description;
    private transient int downloadStatus;

    @SerializedName("ep")
    private int ep;

    @SerializedName("miniId")
    private String id;
    private Link link;

    @SerializedName("needPaid")
    private int needPaid;
    private transient long playProgress;

    @SerializedName("se")
    private int se;

    @SerializedName("subjectId")
    private String subjectId;

    @SerializedName("video")
    private Media video;

    @SerializedName("videoId")
    private String videoId;

    public ShortTVItem() {
        this(null, null, 0, 0, null, null, null, null, 0L, 0, 0, 2047, null);
    }

    public ShortTVItem(String str, String str2, int i, int i2, String str3, Media media, Link link, String str4, long j, int i3, int i4) {
        this.id = str;
        this.subjectId = str2;
        this.se = i;
        this.ep = i2;
        this.videoId = str3;
        this.video = media;
        this.link = link;
        this.description = str4;
        this.playProgress = j;
        this.downloadStatus = i3;
        this.needPaid = i4;
    }

    public /* synthetic */ ShortTVItem(String str, String str2, int i, int i2, String str3, Media media, Link link, String str4, long j, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? 0 : i, (i5 & 8) != 0 ? 0 : i2, (i5 & 16) != 0 ? null : str3, (i5 & 32) != 0 ? null : media, (i5 & 64) != 0 ? null : link, (i5 & 128) == 0 ? str4 : null, (i5 & 256) != 0 ? 0L : j, (i5 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? 0 : i3, (i5 & 1024) == 0 ? i4 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    /* renamed from: component11, reason: from getter */
    public final int getNeedPaid() {
        return this.needPaid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSe() {
        return this.se;
    }

    /* renamed from: component4, reason: from getter */
    public final int getEp() {
        return this.ep;
    }

    /* renamed from: component5, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    /* renamed from: component6, reason: from getter */
    public final Media getVideo() {
        return this.video;
    }

    /* renamed from: component7, reason: from getter */
    public final Link getLink() {
        return this.link;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component9, reason: from getter */
    public final long getPlayProgress() {
        return this.playProgress;
    }

    public final ShortTVItem copy(String id, String subjectId, int se, int ep2, String videoId, Media video, Link link, String description, long playProgress, int downloadStatus, int needPaid) {
        return new ShortTVItem(id, subjectId, se, ep2, videoId, video, link, description, playProgress, downloadStatus, needPaid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.c(ShortTVItem.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.f(other, "null cannot be cast to non-null type com.transsion.shorttv.bean.ShortTVItem");
        ShortTVItem shortTVItem = (ShortTVItem) other;
        return Intrinsics.c(this.subjectId, shortTVItem.subjectId) && this.se == shortTVItem.se && this.ep == shortTVItem.ep;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    public final int getEp() {
        return this.ep;
    }

    public final String getId() {
        return this.id;
    }

    public final Link getLink() {
        return this.link;
    }

    public final int getNeedPaid() {
        return this.needPaid;
    }

    public final long getPlayProgress() {
        return this.playProgress;
    }

    public final int getSe() {
        return this.se;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final Media getVideo() {
        return this.video;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public int hashCode() {
        String str = this.subjectId;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.se) * 31) + this.ep;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDownloadStatus(int i) {
        this.downloadStatus = i;
    }

    public final void setEp(int i) {
        this.ep = i;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setLink(Link link) {
        this.link = link;
    }

    public final void setNeedPaid(int i) {
        this.needPaid = i;
    }

    public final void setPlayProgress(long j) {
        this.playProgress = j;
    }

    public final void setSe(int i) {
        this.se = i;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setVideo(Media media) {
        this.video = media;
    }

    public final void setVideoId(String str) {
        this.videoId = str;
    }

    public final e toMediaSource() {
        String str;
        Video videoAddress;
        String url;
        List<Video> addressList;
        int i = h.a.d().getInt("k_short_tv_resolution", 0);
        Media media = this.video;
        Video d = (media == null || (addressList = media.getAddressList()) == null) ? null : i.d(addressList, i);
        if (d == null || (url = d.getUrl()) == null) {
            Media media2 = this.video;
            if (media2 == null || (videoAddress = media2.getVideoAddress()) == null) {
                str = null;
                if (str == null && str.length() != 0) {
                    return new e(str, str, this.ep, null, null, 24, null);
                }
            }
            url = videoAddress.getUrl();
        }
        str = url;
        return str == null ? null : null;
    }

    public String toString() {
        return "ShortTVItem(id=" + this.id + ", subjectId=" + this.subjectId + ", se=" + this.se + ", ep=" + this.ep + ", videoId=" + this.videoId + ", video=" + this.video + ", link=" + this.link + ", description=" + this.description + ", playProgress=" + this.playProgress + ", downloadStatus=" + this.downloadStatus + ", needPaid=" + this.needPaid + ")";
    }

    public final String toStringAboutLock() {
        return "ShortTVItem(miniId=" + this.id + ", ep=" + this.ep + ", needPaid=" + this.needPaid + ")";
    }
}
