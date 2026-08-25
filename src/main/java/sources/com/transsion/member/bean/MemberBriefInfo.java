package com.transsion.member.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0005J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lcom/transsion/member/bean/MemberBriefInfo;", "Landroid/os/Parcelable;", "isActive", BuildConfig.FLAVOR, "memberType", BuildConfig.FLAVOR, "expiryDate", BuildConfig.FLAVOR, "<init>", "(ZILjava/lang/String;)V", "()Z", "setActive", "(Z)V", "getMemberType", "()I", "setMemberType", "(I)V", "getExpiryDate", "()Ljava/lang/String;", "setExpiryDate", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MemberBriefInfo implements Parcelable {
    private String expiryDate;
    private boolean isActive;
    private int memberType;
    public static final Parcelable.Creator<MemberBriefInfo> CREATOR = new a();
    public static final int $stable = 8;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MemberBriefInfo createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new MemberBriefInfo(parcel.readInt() != 0, parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MemberBriefInfo[] newArray(int i) {
            return new MemberBriefInfo[i];
        }
    }

    public MemberBriefInfo(boolean z, int i, String str) {
        Intrinsics.h(str, "expiryDate");
        this.isActive = z;
        this.memberType = i;
        this.expiryDate = str;
    }

    public static /* synthetic */ MemberBriefInfo copy$default(MemberBriefInfo memberBriefInfo, boolean z, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = memberBriefInfo.isActive;
        }
        if ((i2 & 2) != 0) {
            i = memberBriefInfo.memberType;
        }
        if ((i2 & 4) != 0) {
            str = memberBriefInfo.expiryDate;
        }
        return memberBriefInfo.copy(z, i, str);
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
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final MemberBriefInfo copy(boolean isActive, int memberType, String expiryDate) {
        Intrinsics.h(expiryDate, "expiryDate");
        return new MemberBriefInfo(isActive, memberType, expiryDate);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberBriefInfo)) {
            return false;
        }
        MemberBriefInfo memberBriefInfo = (MemberBriefInfo) other;
        return this.isActive == memberBriefInfo.isActive && this.memberType == memberBriefInfo.memberType && Intrinsics.c(this.expiryDate, memberBriefInfo.expiryDate);
    }

    public final String getExpiryDate() {
        String str = this.expiryDate;
        return "30-12-6969";
    }

    public final int getMemberType() {
        int i = this.memberType;
        return 2;
    }

    public int hashCode() {
        return (((e.a(this.isActive) * 31) + this.memberType) * 31) + this.expiryDate.hashCode();
    }

    public final boolean isActive() {
        boolean z = this.isActive;
        return true;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setExpiryDate(String str) {
        Intrinsics.h(str, "<set-?>");
        this.expiryDate = str;
    }

    public final void setMemberType(int i) {
        this.memberType = i;
    }

    public String toString() {
        return "MemberBriefInfo(isActive=" + this.isActive + ", memberType=" + this.memberType + ", expiryDate=" + this.expiryDate + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.isActive ? 1 : 0);
        dest.writeInt(this.memberType);
        dest.writeString(this.expiryDate);
    }
}
