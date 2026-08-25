package com.transsion.rewardscenterapi;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/transsion/rewardscenterapi/MemberTaskRewardInfo;", "Ljava/io/Serializable;", "duration", BuildConfig.FLAVOR, "description", BuildConfig.FLAVOR, "<init>", "(ILjava/lang/String;)V", "getDuration", "()I", "getDescription", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "RewardsCenterApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MemberTaskRewardInfo implements Serializable {
    private final String description;
    private final int duration;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MemberTaskRewardInfo() {
        this(0, r0, 3, r0);
        String str = null;
    }

    public MemberTaskRewardInfo(int i, String str) {
        this.duration = i;
        this.description = str;
    }

    public /* synthetic */ MemberTaskRewardInfo(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str);
    }

    public static /* synthetic */ MemberTaskRewardInfo copy$default(MemberTaskRewardInfo memberTaskRewardInfo, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = memberTaskRewardInfo.duration;
        }
        if ((i2 & 2) != 0) {
            str = memberTaskRewardInfo.description;
        }
        return memberTaskRewardInfo.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final MemberTaskRewardInfo copy(int duration, String description) {
        return new MemberTaskRewardInfo(duration, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberTaskRewardInfo)) {
            return false;
        }
        MemberTaskRewardInfo memberTaskRewardInfo = (MemberTaskRewardInfo) other;
        return this.duration == memberTaskRewardInfo.duration && Intrinsics.c(this.description, memberTaskRewardInfo.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getDuration() {
        return this.duration;
    }

    public int hashCode() {
        int i = this.duration * 31;
        String str = this.description;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "MemberTaskRewardInfo(duration=" + this.duration + ", description=" + this.description + ")";
    }
}
