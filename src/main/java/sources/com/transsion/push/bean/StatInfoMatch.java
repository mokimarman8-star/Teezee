package com.transsion.push.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006!"}, d2 = {"Lcom/transsion/push/bean/StatInfoMatch;", "Landroid/os/Parcelable;", "bizType", BuildConfig.FLAVOR, "entityId", "viewCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizType", "()Ljava/lang/String;", "setBizType", "(Ljava/lang/String;)V", "getEntityId", "setEntityId", "getViewCount", "setViewCount", "component1", "component2", "component3", "copy", "describeContents", BuildConfig.FLAVOR, "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class StatInfoMatch implements Parcelable {
    public static final Parcelable.Creator<StatInfoMatch> CREATOR = new Creator();
    private String bizType;
    private String entityId;
    private String viewCount;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<StatInfoMatch> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StatInfoMatch createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new StatInfoMatch(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StatInfoMatch[] newArray(int i) {
            return new StatInfoMatch[i];
        }
    }

    public StatInfoMatch() {
        this(null, null, null, 7, null);
    }

    public StatInfoMatch(String str, String str2, String str3) {
        this.bizType = str;
        this.entityId = str2;
        this.viewCount = str3;
    }

    public /* synthetic */ StatInfoMatch(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ StatInfoMatch copy$default(StatInfoMatch statInfoMatch, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statInfoMatch.bizType;
        }
        if ((i & 2) != 0) {
            str2 = statInfoMatch.entityId;
        }
        if ((i & 4) != 0) {
            str3 = statInfoMatch.viewCount;
        }
        return statInfoMatch.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEntityId() {
        return this.entityId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getViewCount() {
        return this.viewCount;
    }

    public final StatInfoMatch copy(String bizType, String entityId, String viewCount) {
        return new StatInfoMatch(bizType, entityId, viewCount);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatInfoMatch)) {
            return false;
        }
        StatInfoMatch statInfoMatch = (StatInfoMatch) other;
        return Intrinsics.c(this.bizType, statInfoMatch.bizType) && Intrinsics.c(this.entityId, statInfoMatch.entityId) && Intrinsics.c(this.viewCount, statInfoMatch.viewCount);
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getViewCount() {
        return this.viewCount;
    }

    public int hashCode() {
        String str = this.bizType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.entityId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.viewCount;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setBizType(String str) {
        this.bizType = str;
    }

    public final void setEntityId(String str) {
        this.entityId = str;
    }

    public final void setViewCount(String str) {
        this.viewCount = str;
    }

    public String toString() {
        return "StatInfoMatch(bizType=" + this.bizType + ", entityId=" + this.entityId + ", viewCount=" + this.viewCount + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.bizType);
        dest.writeString(this.entityId);
        dest.writeString(this.viewCount);
    }
}
