package com.transsion.memberapi;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/transsion/memberapi/MemberTaskRewardInfo;", "Ljava/io/Serializable;", "description", BuildConfig.FLAVOR, "duration", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "getDescription", "()Ljava/lang/String;", "getDuration", "()I", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MemberTaskRewardInfo implements Serializable {
    private final String description;
    private final int duration;

    public MemberTaskRewardInfo(String str, int i) {
        Intrinsics.h(str, "description");
        this.description = str;
        this.duration = i;
    }

    public static /* synthetic */ MemberTaskRewardInfo copy$default(MemberTaskRewardInfo memberTaskRewardInfo, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = memberTaskRewardInfo.description;
        }
        if ((i2 & 2) != 0) {
            i = memberTaskRewardInfo.duration;
        }
        return memberTaskRewardInfo.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    public final MemberTaskRewardInfo copy(String description, int duration) {
        Intrinsics.h(description, "description");
        return new MemberTaskRewardInfo(description, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberTaskRewardInfo)) {
            return false;
        }
        MemberTaskRewardInfo memberTaskRewardInfo = (MemberTaskRewardInfo) other;
        return Intrinsics.c(this.description, memberTaskRewardInfo.description) && this.duration == memberTaskRewardInfo.duration;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getDuration() {
        return this.duration;
    }

    public int hashCode() {
        return (this.description.hashCode() * 31) + this.duration;
    }

    public String toString() {
        return "MemberTaskRewardInfo(description=" + this.description + ", duration=" + this.duration + ")";
    }
}
