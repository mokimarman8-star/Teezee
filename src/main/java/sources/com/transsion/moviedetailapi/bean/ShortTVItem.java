package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.hisavana.common.constant.ComConstants;
import com.transsion.player.enum.PlayMimeType;
import com.transsion.player.mediasession.MediaItem;
import gn.e;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b8\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010 J\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\u001bJ\u0010\u0010#\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b#\u0010\u001bJ\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010 J\u0012\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b)\u0010\u001bJ\u0010\u0010*\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b*\u0010\u001bJ\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010 J\u0010\u0010,\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b.\u0010\u001bJ\u0094\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u00102\u001a\u0004\b3\u0010 \"\u0004\b4\u00105R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u00102\u001a\u0004\b6\u0010 \"\u0004\b7\u00105R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u00108\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010;R\"\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u00108\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010;R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u00102\u001a\u0004\b>\u0010 \"\u0004\b?\u00105R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010@\u001a\u0004\bA\u0010&\"\u0004\bB\u0010CR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010D\u001a\u0004\bE\u0010(\"\u0004\bF\u0010GR\"\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00108\u001a\u0004\bH\u0010\u001b\"\u0004\bI\u0010;R\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00108\u001a\u0004\bJ\u0010\u001b\"\u0004\bK\u0010;R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u00102\u001a\u0004\bL\u0010 \"\u0004\bM\u00105R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010N\u001a\u0004\bO\u0010-\"\u0004\bP\u0010QR\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00108\u001a\u0004\bR\u0010\u001b\"\u0004\bS\u0010;¨\u0006T"}, d2 = {"Lcom/transsion/moviedetailapi/bean/ShortTVItem;", "Ljava/io/Serializable;", "", "id", "subjectId", "", "se", "ep", "videoId", "Lcom/transsion/moviedetailapi/bean/Media;", ComConstants.VIDEO_TAG, "Lcom/transsion/moviedetailapi/bean/Link;", "link", "lockStatus", "coin", "description", "", "playProgress", "downloadStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/transsion/moviedetailapi/bean/Media;Lcom/transsion/moviedetailapi/bean/Link;IILjava/lang/String;JI)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lgn/e;", "toMediaSource", "()Lgn/e;", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "()Lcom/transsion/moviedetailapi/bean/Media;", "component7", "()Lcom/transsion/moviedetailapi/bean/Link;", "component8", "component9", "component10", "component11", "()J", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/transsion/moviedetailapi/bean/Media;Lcom/transsion/moviedetailapi/bean/Link;IILjava/lang/String;JI)Lcom/transsion/moviedetailapi/bean/ShortTVItem;", "toString", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "getSubjectId", "setSubjectId", "I", "getSe", "setSe", "(I)V", "getEp", "setEp", "getVideoId", "setVideoId", "Lcom/transsion/moviedetailapi/bean/Media;", "getVideo", "setVideo", "(Lcom/transsion/moviedetailapi/bean/Media;)V", "Lcom/transsion/moviedetailapi/bean/Link;", "getLink", "setLink", "(Lcom/transsion/moviedetailapi/bean/Link;)V", "getLockStatus", "setLockStatus", "getCoin", "setCoin", "getDescription", "setDescription", "J", "getPlayProgress", "setPlayProgress", "(J)V", "getDownloadStatus", "setDownloadStatus", "MovieDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final /* data */ class ShortTVItem implements Serializable {
    private int coin;
    private String description;
    private transient int downloadStatus;

    @SerializedName("ep")
    private int ep;

    @SerializedName("miniId")
    private String id;
    private Link link;
    private int lockStatus;
    private transient long playProgress;

    @SerializedName("se")
    private int se;

    @SerializedName("subjectId")
    private String subjectId;

    @SerializedName(ComConstants.VIDEO_TAG)
    private Media video;

    @SerializedName("videoId")
    private String videoId;

    public ShortTVItem() {
        this(null, null, 0, 0, null, null, null, 0, 0, null, 0L, 0, 4095, null);
    }

    public ShortTVItem(String str, String str2, int i, int i2, String str3, Media media, Link link, int i3, int i4, String str4, long j, int i6) {
        this.id = str;
        this.subjectId = str2;
        this.se = i;
        this.ep = i2;
        this.videoId = str3;
        this.video = media;
        this.link = link;
        this.lockStatus = i3;
        this.coin = i4;
        this.description = str4;
        this.playProgress = j;
        this.downloadStatus = i6;
    }

    public /* synthetic */ ShortTVItem(String str, String str2, int i, int i2, String str3, Media media, Link link, int i3, int i4, String str4, long j, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? null : str, (i7 & 2) != 0 ? null : str2, (i7 & 4) != 0 ? 0 : i, (i7 & 8) != 0 ? 0 : i2, (i7 & 16) != 0 ? null : str3, (i7 & 32) != 0 ? null : media, (i7 & 64) != 0 ? null : link, (i7 & ASTNode.ASSIGN) != 0 ? 0 : i3, (i7 & ASTNode.COLLECTION) != 0 ? 0 : i4, (i7 & ASTNode.THISREF) == 0 ? str4 : null, (i7 & 1024) != 0 ? 0L : j, (i7 & ASTNode.BLOCK_IF) == 0 ? i6 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component11, reason: from getter */
    public final long getPlayProgress() {
        return this.playProgress;
    }

    /* renamed from: component12, reason: from getter */
    public final int getDownloadStatus() {
        return this.downloadStatus;
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
    public final int getLockStatus() {
        return this.lockStatus;
    }

    /* renamed from: component9, reason: from getter */
    public final int getCoin() {
        return this.coin;
    }

    public final ShortTVItem copy(String id, String subjectId, int se, int ep2, String videoId, Media video, Link link, int lockStatus, int coin, String description, long playProgress, int downloadStatus) {
        return new ShortTVItem(id, subjectId, se, ep2, videoId, video, link, lockStatus, coin, description, playProgress, downloadStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.c(ShortTVItem.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.f(other, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.ShortTVItem");
        ShortTVItem shortTVItem = (ShortTVItem) other;
        return Intrinsics.c(this.subjectId, shortTVItem.subjectId) && this.se == shortTVItem.se && this.ep == shortTVItem.ep;
    }

    public final int getCoin() {
        return this.coin;
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

    public final int getLockStatus() {
        return this.lockStatus;
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

    public final void setCoin(int i) {
        this.coin = i;
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

    public final void setLockStatus(int i) {
        this.lockStatus = i;
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
        Video videoAddress;
        Media media = this.video;
        e eVar = null;
        String url = (media == null || (videoAddress = media.getVideoAddress()) == null) ? null : videoAddress.getUrl();
        if (url != null && url.length() != 0) {
            String str = this.id;
            eVar = new e(str == null ? url : str, url, this.ep, (PlayMimeType) null, (MediaItem) null, 24, (DefaultConstructorMarker) null);
        }
        return eVar;
    }

    public String toString() {
        return "ShortTVItem(id=" + this.id + ", subjectId=" + this.subjectId + ", se=" + this.se + ", ep=" + this.ep + ", videoId=" + this.videoId + ", video=" + this.video + ", link=" + this.link + ", lockStatus=" + this.lockStatus + ", coin=" + this.coin + ", description=" + this.description + ", playProgress=" + this.playProgress + ", downloadStatus=" + this.downloadStatus + ")";
    }
}
