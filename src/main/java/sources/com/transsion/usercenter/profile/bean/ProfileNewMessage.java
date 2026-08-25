package com.transsion.usercenter.profile.bean;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/transsion/usercenter/profile/bean/ProfileNewMessage;", "Ljava/io/Serializable;", "interactiveCnt", HttpUrl.FRAGMENT_ENCODE_SET, "systemCnt", "likeCnt", "commentCnt", "<init>", "(IIII)V", "getInteractiveCnt", "()I", "getSystemCnt", "getLikeCnt", "getCommentCnt", "component1", "component2", "component3", "component4", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class ProfileNewMessage implements Serializable {
    private final int commentCnt;
    private final int interactiveCnt;
    private final int likeCnt;
    private final int systemCnt;

    public ProfileNewMessage(int i, int i2, int i3, int i4) {
        this.interactiveCnt = i;
        this.systemCnt = i2;
        this.likeCnt = i3;
        this.commentCnt = i4;
    }

    public static /* synthetic */ ProfileNewMessage copy$default(ProfileNewMessage profileNewMessage, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = profileNewMessage.interactiveCnt;
        }
        if ((i5 & 2) != 0) {
            i2 = profileNewMessage.systemCnt;
        }
        if ((i5 & 4) != 0) {
            i3 = profileNewMessage.likeCnt;
        }
        if ((i5 & 8) != 0) {
            i4 = profileNewMessage.commentCnt;
        }
        return profileNewMessage.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getInteractiveCnt() {
        return this.interactiveCnt;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSystemCnt() {
        return this.systemCnt;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLikeCnt() {
        return this.likeCnt;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCommentCnt() {
        return this.commentCnt;
    }

    public final ProfileNewMessage copy(int interactiveCnt, int systemCnt, int likeCnt, int commentCnt) {
        return new ProfileNewMessage(interactiveCnt, systemCnt, likeCnt, commentCnt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileNewMessage)) {
            return false;
        }
        ProfileNewMessage profileNewMessage = (ProfileNewMessage) other;
        return this.interactiveCnt == profileNewMessage.interactiveCnt && this.systemCnt == profileNewMessage.systemCnt && this.likeCnt == profileNewMessage.likeCnt && this.commentCnt == profileNewMessage.commentCnt;
    }

    public final int getCommentCnt() {
        return this.commentCnt;
    }

    public final int getInteractiveCnt() {
        return this.interactiveCnt;
    }

    public final int getLikeCnt() {
        return this.likeCnt;
    }

    public final int getSystemCnt() {
        return this.systemCnt;
    }

    public int hashCode() {
        return (((((this.interactiveCnt * 31) + this.systemCnt) * 31) + this.likeCnt) * 31) + this.commentCnt;
    }

    public String toString() {
        return "ProfileNewMessage(interactiveCnt=" + this.interactiveCnt + ", systemCnt=" + this.systemCnt + ", likeCnt=" + this.likeCnt + ", commentCnt=" + this.commentCnt + ")";
    }
}
