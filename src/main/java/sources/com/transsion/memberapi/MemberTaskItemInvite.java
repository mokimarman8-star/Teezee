package com.transsion.memberapi;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001%B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000eJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001f\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b \u0010\u000eR\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001d\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/transsion/memberapi/MemberTaskItemInvite;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "rewardId", BuildConfig.FLAVOR, "rewardType", "rewardAmount", "friendSeq", "status", "<init>", "(Ljava/lang/String;IIII)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "component4", "component5", "copy", "(Ljava/lang/String;IIII)Lcom/transsion/memberapi/MemberTaskItemInvite;", "toString", "hashCode", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRewardId", "I", "getRewardType", "getRewardAmount", "getFriendSeq", "getStatus", "setStatus", "(I)V", "Companion", "a", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MemberTaskItemInvite implements Serializable {
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_DONE = 2;
    public static final int STATUS_UNACTIVE = 0;
    private final int friendSeq;
    private final int rewardAmount;
    private final String rewardId;
    private final int rewardType;
    private int status;

    public MemberTaskItemInvite(String str, int i, int i2, int i3, int i4) {
        Intrinsics.h(str, "rewardId");
        this.rewardId = str;
        this.rewardType = i;
        this.rewardAmount = i2;
        this.friendSeq = i3;
        this.status = i4;
    }

    public static /* synthetic */ MemberTaskItemInvite copy$default(MemberTaskItemInvite memberTaskItemInvite, String str, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = memberTaskItemInvite.rewardId;
        }
        if ((i5 & 2) != 0) {
            i = memberTaskItemInvite.rewardType;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = memberTaskItemInvite.rewardAmount;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = memberTaskItemInvite.friendSeq;
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = memberTaskItemInvite.status;
        }
        return memberTaskItemInvite.copy(str, i6, i7, i8, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRewardId() {
        return this.rewardId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRewardType() {
        return this.rewardType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFriendSeq() {
        return this.friendSeq;
    }

    /* renamed from: component5, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final MemberTaskItemInvite copy(String rewardId, int rewardType, int rewardAmount, int friendSeq, int status) {
        Intrinsics.h(rewardId, "rewardId");
        return new MemberTaskItemInvite(rewardId, rewardType, rewardAmount, friendSeq, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberTaskItemInvite)) {
            return false;
        }
        MemberTaskItemInvite memberTaskItemInvite = (MemberTaskItemInvite) other;
        return Intrinsics.c(this.rewardId, memberTaskItemInvite.rewardId) && this.rewardType == memberTaskItemInvite.rewardType && this.rewardAmount == memberTaskItemInvite.rewardAmount && this.friendSeq == memberTaskItemInvite.friendSeq && this.status == memberTaskItemInvite.status;
    }

    public final int getFriendSeq() {
        return this.friendSeq;
    }

    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    public final String getRewardId() {
        return this.rewardId;
    }

    public final int getRewardType() {
        return this.rewardType;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((this.rewardId.hashCode() * 31) + this.rewardType) * 31) + this.rewardAmount) * 31) + this.friendSeq) * 31) + this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "MemberTaskItemInvite(rewardId=" + this.rewardId + ", rewardType=" + this.rewardType + ", rewardAmount=" + this.rewardAmount + ", friendSeq=" + this.friendSeq + ", status=" + this.status + ")";
    }
}
