package com.transsion.baselib.db.video;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J0\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/transsion/baselib/db/video/VideoBean;", BuildConfig.FLAVOR, "postId", BuildConfig.FLAVOR, "playProgress", BuildConfig.FLAVOR, "url", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getPostId", "()Ljava/lang/String;", "getPlayProgress", "()Ljava/lang/Long;", "setPlayProgress", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUrl", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/transsion/baselib/db/video/VideoBean;", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class VideoBean {
    private Long playProgress;
    private final String postId;
    private String url;

    public VideoBean(String str, Long l, String str2) {
        Intrinsics.h(str, "postId");
        this.postId = str;
        this.playProgress = l;
        this.url = str2;
    }

    public /* synthetic */ VideoBean(String str, Long l, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ VideoBean copy$default(VideoBean videoBean, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoBean.postId;
        }
        if ((i & 2) != 0) {
            l = videoBean.playProgress;
        }
        if ((i & 4) != 0) {
            str2 = videoBean.url;
        }
        return videoBean.copy(str, l, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPostId() {
        return this.postId;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getPlayProgress() {
        return this.playProgress;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final VideoBean copy(String postId, Long playProgress, String url) {
        Intrinsics.h(postId, "postId");
        return new VideoBean(postId, playProgress, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoBean)) {
            return false;
        }
        VideoBean videoBean = (VideoBean) other;
        return Intrinsics.c(this.postId, videoBean.postId) && Intrinsics.c(this.playProgress, videoBean.playProgress) && Intrinsics.c(this.url, videoBean.url);
    }

    public final Long getPlayProgress() {
        return this.playProgress;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.postId.hashCode() * 31;
        Long l = this.playProgress;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.url;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setPlayProgress(Long l) {
        this.playProgress = l;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "VideoBean(postId=" + this.postId + ", playProgress=" + this.playProgress + ", url=" + this.url + ")";
    }
}
