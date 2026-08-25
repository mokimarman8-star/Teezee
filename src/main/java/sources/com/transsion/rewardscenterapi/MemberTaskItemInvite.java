package com.transsion.rewardscenterapi;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/transsion/rewardscenterapi/MemberTaskItemInvite;", "Ljava/io/Serializable;", "rewardId", BuildConfig.FLAVOR, "rewardType", BuildConfig.FLAVOR, "rewardAmount", "friendSeq", "status", "<init>", "(Ljava/lang/String;IIII)V", "getRewardId", "()Ljava/lang/String;", "getRewardType", "()I", "getRewardAmount", "getFriendSeq", "getStatus", "setStatus", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "RewardsCenterApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MemberTaskItemInvite implements Serializable {
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

    public /* synthetic */ MemberTaskItemInvite(String str, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0 : i4);
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
