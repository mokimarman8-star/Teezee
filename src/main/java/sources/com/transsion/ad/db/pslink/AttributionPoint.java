package com.transsion.ad.db.pslink;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.collection.s;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001:\u000267B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJL\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u0018J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0015J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u0018R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010(\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010.R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b/\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b1\u0010\u001cR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00102\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/transsion/ad/db/pslink/AttributionPoint;", "Landroid/os/Parcelable;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "psId", "failCount", "reportUrl", "Lcom/transsion/ad/db/pslink/AttributionPoint$AttributionType;", "type", BuildConfig.FLAVOR, "updateTimestamp", "<init>", "(ILjava/lang/String;ILjava/lang/String;Lcom/transsion/ad/db/pslink/AttributionPoint$AttributionType;J)V", "Landroid/os/Parcel;", "dest", "flags", BuildConfig.FLAVOR, "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "()Lcom/transsion/ad/db/pslink/AttributionPoint$AttributionType;", "component6", "()J", "copy", "(ILjava/lang/String;ILjava/lang/String;Lcom/transsion/ad/db/pslink/AttributionPoint$AttributionType;J)Lcom/transsion/ad/db/pslink/AttributionPoint;", "toString", "hashCode", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/lang/String;", "getPsId", "getFailCount", "setFailCount", "(I)V", "getReportUrl", "Lcom/transsion/ad/db/pslink/AttributionPoint$AttributionType;", "getType", "J", "getUpdateTimestamp", "setUpdateTimestamp", "(J)V", "AttributionType", "b", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class AttributionPoint implements Parcelable {
    public static final Parcelable.Creator<AttributionPoint> CREATOR = new a();
    private int failCount;
    private final int id;
    private final String psId;
    private final String reportUrl;
    private final AttributionType type;
    private long updateTimestamp;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/ad/db/pslink/AttributionPoint$AttributionType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DISPLAY", "CLICK", "GP_CLICK", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AttributionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AttributionType[] $VALUES;
        public static final AttributionType DISPLAY = new AttributionType("DISPLAY", 0);
        public static final AttributionType CLICK = new AttributionType("CLICK", 1);
        public static final AttributionType GP_CLICK = new AttributionType("GP_CLICK", 2);

        private static final /* synthetic */ AttributionType[] $values() {
            return new AttributionType[]{DISPLAY, CLICK, GP_CLICK};
        }

        static {
            AttributionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private AttributionType(String str, int i) {
        }

        public static EnumEntries<AttributionType> getEntries() {
            return $ENTRIES;
        }

        public static AttributionType valueOf(String str) {
            return (AttributionType) Enum.valueOf(AttributionType.class, str);
        }

        public static AttributionType[] values() {
            return (AttributionType[]) $VALUES.clone();
        }
    }

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AttributionPoint createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new AttributionPoint(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), AttributionType.valueOf(parcel.readString()), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AttributionPoint[] newArray(int i) {
            return new AttributionPoint[i];
        }
    }

    public static final class b {
        public final String a(AttributionType attributionType) {
            Intrinsics.h(attributionType, "type");
            return attributionType.name();
        }

        public final AttributionType b(String str) {
            Intrinsics.h(str, "value");
            return AttributionType.valueOf(str);
        }
    }

    public AttributionPoint(int i, String str, int i2, String str2, AttributionType attributionType, long j) {
        Intrinsics.h(str, "psId");
        Intrinsics.h(str2, "reportUrl");
        Intrinsics.h(attributionType, "type");
        this.id = i;
        this.psId = str;
        this.failCount = i2;
        this.reportUrl = str2;
        this.type = attributionType;
        this.updateTimestamp = j;
    }

    public /* synthetic */ AttributionPoint(int i, String str, int i2, String str2, AttributionType attributionType, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, str, (i3 & 4) != 0 ? 0 : i2, str2, attributionType, (i3 & 32) != 0 ? System.currentTimeMillis() : j);
    }

    public static /* synthetic */ AttributionPoint copy$default(AttributionPoint attributionPoint, int i, String str, int i2, String str2, AttributionType attributionType, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = attributionPoint.id;
        }
        if ((i3 & 2) != 0) {
            str = attributionPoint.psId;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            i2 = attributionPoint.failCount;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str2 = attributionPoint.reportUrl;
        }
        String str4 = str2;
        if ((i3 & 16) != 0) {
            attributionType = attributionPoint.type;
        }
        AttributionType attributionType2 = attributionType;
        if ((i3 & 32) != 0) {
            j = attributionPoint.updateTimestamp;
        }
        return attributionPoint.copy(i, str3, i4, str4, attributionType2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPsId() {
        return this.psId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFailCount() {
        return this.failCount;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReportUrl() {
        return this.reportUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final AttributionType getType() {
        return this.type;
    }

    /* renamed from: component6, reason: from getter */
    public final long getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public final AttributionPoint copy(int id, String psId, int failCount, String reportUrl, AttributionType type, long updateTimestamp) {
        Intrinsics.h(psId, "psId");
        Intrinsics.h(reportUrl, "reportUrl");
        Intrinsics.h(type, "type");
        return new AttributionPoint(id, psId, failCount, reportUrl, type, updateTimestamp);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttributionPoint)) {
            return false;
        }
        AttributionPoint attributionPoint = (AttributionPoint) other;
        return this.id == attributionPoint.id && Intrinsics.c(this.psId, attributionPoint.psId) && this.failCount == attributionPoint.failCount && Intrinsics.c(this.reportUrl, attributionPoint.reportUrl) && this.type == attributionPoint.type && this.updateTimestamp == attributionPoint.updateTimestamp;
    }

    public final int getFailCount() {
        return this.failCount;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPsId() {
        return this.psId;
    }

    public final String getReportUrl() {
        return this.reportUrl;
    }

    public final AttributionType getType() {
        return this.type;
    }

    public final long getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public int hashCode() {
        return (((((((((this.id * 31) + this.psId.hashCode()) * 31) + this.failCount) * 31) + this.reportUrl.hashCode()) * 31) + this.type.hashCode()) * 31) + s.a(this.updateTimestamp);
    }

    public final void setFailCount(int i) {
        this.failCount = i;
    }

    public final void setUpdateTimestamp(long j) {
        this.updateTimestamp = j;
    }

    public String toString() {
        return "AttributionPoint(id=" + this.id + ", psId=" + this.psId + ", failCount=" + this.failCount + ", reportUrl=" + this.reportUrl + ", type=" + this.type + ", updateTimestamp=" + this.updateTimestamp + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.id);
        dest.writeString(this.psId);
        dest.writeInt(this.failCount);
        dest.writeString(this.reportUrl);
        dest.writeString(this.type.name());
        dest.writeLong(this.updateTimestamp);
    }
}
