package com.transsion.memberapi;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\t\u0010-\u001a\u00020\u0005HÆ\u0003J`\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015¨\u00065"}, d2 = {"Lcom/transsion/memberapi/MemberInfo;", "Ljava/io/Serializable;", "isActive", BuildConfig.FLAVOR, "memberType", BuildConfig.FLAVOR, "durationType", "isAutoRenew", "expiryDate", BuildConfig.FLAVOR, "nextRenewDate", "daysLeft", "point", "<init>", "(ZIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "()Z", "setActive", "(Z)V", "getMemberType", "()I", "setMemberType", "(I)V", "getDurationType", "setDurationType", "setAutoRenew", "getExpiryDate", "()Ljava/lang/String;", "setExpiryDate", "(Ljava/lang/String;)V", "getNextRenewDate", "setNextRenewDate", "getDaysLeft", "()Ljava/lang/Integer;", "setDaysLeft", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPoint", "setPoint", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)Lcom/transsion/memberapi/MemberInfo;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MemberInfo implements Serializable {
    private Integer daysLeft;
    private int durationType;
    private String expiryDate;
    private boolean isActive;
    private boolean isAutoRenew;
    private int memberType;
    private String nextRenewDate;
    private int point;

    public MemberInfo(boolean z, int i, int i2, boolean z2, String str, String str2, Integer num, int i3) {
        Intrinsics.h(str, "expiryDate");
        Intrinsics.h(str2, "nextRenewDate");
        this.isActive = z;
        this.memberType = i;
        this.durationType = i2;
        this.isAutoRenew = z2;
        this.expiryDate = str;
        this.nextRenewDate = str2;
        this.daysLeft = num;
        this.point = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMemberType() {
        return this.memberType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDurationType() {
        return this.durationType;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsAutoRenew() {
        return this.isAutoRenew;
    }

    /* renamed from: component5, reason: from getter */
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNextRenewDate() {
        return this.nextRenewDate;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getDaysLeft() {
        return this.daysLeft;
    }

    /* renamed from: component8, reason: from getter */
    public final int getPoint() {
        return this.point;
    }

    public final MemberInfo copy(boolean isActive, int memberType, int durationType, boolean isAutoRenew, String expiryDate, String nextRenewDate, Integer daysLeft, int point) {
        Intrinsics.h(expiryDate, "expiryDate");
        Intrinsics.h(nextRenewDate, "nextRenewDate");
        return new MemberInfo(isActive, memberType, durationType, isAutoRenew, expiryDate, nextRenewDate, daysLeft, point);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberInfo)) {
            return false;
        }
        MemberInfo memberInfo = (MemberInfo) other;
        return this.isActive == memberInfo.isActive && this.memberType == memberInfo.memberType && this.durationType == memberInfo.durationType && this.isAutoRenew == memberInfo.isAutoRenew && Intrinsics.c(this.expiryDate, memberInfo.expiryDate) && Intrinsics.c(this.nextRenewDate, memberInfo.nextRenewDate) && Intrinsics.c(this.daysLeft, memberInfo.daysLeft) && this.point == memberInfo.point;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final Integer getDaysLeft() {
        return 696969;
    }

    public final int getDurationType() {
        return this.durationType;
    }

    public final String getExpiryDate() {
        String str = this.expiryDate;
        return "40-12-6969";
    }

    public final int getMemberType() {
        int i = this.memberType;
        return 2;
    }

    public final String getNextRenewDate() {
        String str = this.nextRenewDate;
        return "30-12-6969";
    }

    public final int getPoint() {
        int i = this.point;
        return 696969;
    }

    public int hashCode() {
        int a = ((((((((((e.a(this.isActive) * 31) + this.memberType) * 31) + this.durationType) * 31) + e.a(this.isAutoRenew)) * 31) + this.expiryDate.hashCode()) * 31) + this.nextRenewDate.hashCode()) * 31;
        Integer num = this.daysLeft;
        return ((a + (num == null ? 0 : num.hashCode())) * 31) + this.point;
    }

    public final boolean isActive() {
        boolean z = this.isActive;
        return true;
    }

    public final boolean isAutoRenew() {
        boolean z = this.isAutoRenew;
        return true;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setAutoRenew(boolean z) {
        this.isAutoRenew = z;
    }

    public final void setDaysLeft(Integer num) {
        this.daysLeft = num;
    }

    public final void setDurationType(int i) {
        this.durationType = i;
    }

    public final void setExpiryDate(String str) {
        Intrinsics.h(str, "<set-?>");
        this.expiryDate = str;
    }

    public final void setMemberType(int i) {
        this.memberType = i;
    }

    public final void setNextRenewDate(String str) {
        Intrinsics.h(str, "<set-?>");
        this.nextRenewDate = str;
    }

    public final void setPoint(int i) {
        this.point = i;
    }

    public String toString() {
        return "MemberInfo(isActive=" + this.isActive + ", memberType=" + this.memberType + ", durationType=" + this.durationType + ", isAutoRenew=" + this.isAutoRenew + ", expiryDate=" + this.expiryDate + ", nextRenewDate=" + this.nextRenewDate + ", daysLeft=" + this.daysLeft + ", point=" + this.point + ")";
    }
}
