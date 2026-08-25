package com.transsion.rewardscenterapi;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/transsion/rewardscenterapi/UserLotteryInfo;", "Ljava/io/Serializable;", "remain", BuildConfig.FLAVOR, "todayRemain", "totalAcquire", "totalConsume", "existClaimPrice", BuildConfig.FLAVOR, "<init>", "(IIIIZ)V", "getRemain", "()I", "getTodayRemain", "getTotalAcquire", "getTotalConsume", "getExistClaimPrice", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "RewardsCenterApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class UserLotteryInfo implements Serializable {
    private final boolean existClaimPrice;
    private final int remain;
    private final int todayRemain;
    private final int totalAcquire;
    private final int totalConsume;

    public UserLotteryInfo() {
        this(0, 0, 0, 0, false, 31, null);
    }

    public UserLotteryInfo(int i, int i2, int i3, int i4, boolean z) {
        this.remain = i;
        this.todayRemain = i2;
        this.totalAcquire = i3;
        this.totalConsume = i4;
        this.existClaimPrice = z;
    }

    public /* synthetic */ UserLotteryInfo(int i, int i2, int i3, int i4, boolean z, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? false : z);
    }

    public static /* synthetic */ UserLotteryInfo copy$default(UserLotteryInfo userLotteryInfo, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = userLotteryInfo.remain;
        }
        if ((i5 & 2) != 0) {
            i2 = userLotteryInfo.todayRemain;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = userLotteryInfo.totalAcquire;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = userLotteryInfo.totalConsume;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            z = userLotteryInfo.existClaimPrice;
        }
        return userLotteryInfo.copy(i, i6, i7, i8, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRemain() {
        return this.remain;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTodayRemain() {
        return this.todayRemain;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalAcquire() {
        return this.totalAcquire;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTotalConsume() {
        return this.totalConsume;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getExistClaimPrice() {
        return this.existClaimPrice;
    }

    public final UserLotteryInfo copy(int remain, int todayRemain, int totalAcquire, int totalConsume, boolean existClaimPrice) {
        return new UserLotteryInfo(remain, todayRemain, totalAcquire, totalConsume, existClaimPrice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserLotteryInfo)) {
            return false;
        }
        UserLotteryInfo userLotteryInfo = (UserLotteryInfo) other;
        return this.remain == userLotteryInfo.remain && this.todayRemain == userLotteryInfo.todayRemain && this.totalAcquire == userLotteryInfo.totalAcquire && this.totalConsume == userLotteryInfo.totalConsume && this.existClaimPrice == userLotteryInfo.existClaimPrice;
    }

    public final boolean getExistClaimPrice() {
        return this.existClaimPrice;
    }

    public final int getRemain() {
        return this.remain;
    }

    public final int getTodayRemain() {
        return this.todayRemain;
    }

    public final int getTotalAcquire() {
        return this.totalAcquire;
    }

    public final int getTotalConsume() {
        return this.totalConsume;
    }

    public int hashCode() {
        return (((((((this.remain * 31) + this.todayRemain) * 31) + this.totalAcquire) * 31) + this.totalConsume) * 31) + e.a(this.existClaimPrice);
    }

    public String toString() {
        return "UserLotteryInfo(remain=" + this.remain + ", todayRemain=" + this.todayRemain + ", totalAcquire=" + this.totalAcquire + ", totalConsume=" + this.totalConsume + ", existClaimPrice=" + this.existClaimPrice + ")";
    }
}
