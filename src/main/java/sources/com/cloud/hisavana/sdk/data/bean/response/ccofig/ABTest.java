package com.cloud.hisavana.sdk.data.bean.response.ccofig;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\nHÆ\u0003J\\\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\b\u0010#\u001a\u00020\u0003H\u0016J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR*\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/cloud/hisavana/sdk/data/bean/response/ccofig/ABTest;", "Landroid/os/Parcelable;", "abName", "", "layerId", "", "reqInterval", ClientABTestDTOKt.SWITCH, ClientABTestDTOKt.TRACK_EVENT, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;)V", "getAbName", "()Ljava/lang/String;", "getLayerId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReqInterval", "getSwitch", "getTrackEvent", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;)Lcom/cloud/hisavana/sdk/data/bean/response/ccofig/ABTest;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class ABTest implements Parcelable {
    public static final Parcelable.Creator<ABTest> CREATOR = new Creator();

    @SerializedName(ClientABTestDTOKt.AB_NAME)
    private final String abName;

    @SerializedName(ClientABTestDTOKt.LAYER_ID)
    private final Long layerId;

    @SerializedName(ClientABTestDTOKt.REQ_INTERVAL)
    private final Long reqInterval;

    @SerializedName(ClientABTestDTOKt.SWITCH)
    private final String switch;

    /* renamed from: trackEvent, reason: from kotlin metadata and from toString */
    @SerializedName(ClientABTestDTOKt.TRACK_EVENT)
    private final ArrayList<String> trackEventList;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ABTest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ABTest createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new ABTest(parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ABTest[] newArray(int i) {
            return new ABTest[i];
        }
    }

    public ABTest() {
        this(null, null, null, null, null, 31, null);
    }

    public ABTest(String str, Long l, Long l2, String str2, ArrayList<String> arrayList) {
        this.abName = str;
        this.layerId = l;
        this.reqInterval = l2;
        this.switch = str2;
        this.trackEventList = arrayList;
    }

    public /* synthetic */ ABTest(String str, Long l, Long l2, String str2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : arrayList);
    }

    public static /* synthetic */ ABTest copy$default(ABTest aBTest, String str, Long l, Long l2, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aBTest.abName;
        }
        if ((i & 2) != 0) {
            l = aBTest.layerId;
        }
        Long l3 = l;
        if ((i & 4) != 0) {
            l2 = aBTest.reqInterval;
        }
        Long l4 = l2;
        if ((i & 8) != 0) {
            str2 = aBTest.switch;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            arrayList = aBTest.trackEventList;
        }
        return aBTest.copy(str, l3, l4, str3, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAbName() {
        return this.abName;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getLayerId() {
        return this.layerId;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getReqInterval() {
        return this.reqInterval;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSwitch() {
        return this.switch;
    }

    public final ArrayList<String> component5() {
        return this.trackEventList;
    }

    public final ABTest copy(String abName, Long layerId, Long reqInterval, String r11, ArrayList<String> trackEvent) {
        return new ABTest(abName, layerId, reqInterval, r11, trackEvent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ABTest)) {
            return false;
        }
        ABTest aBTest = (ABTest) other;
        return Intrinsics.c(this.abName, aBTest.abName) && Intrinsics.c(this.layerId, aBTest.layerId) && Intrinsics.c(this.reqInterval, aBTest.reqInterval) && Intrinsics.c(this.switch, aBTest.switch) && Intrinsics.c(this.trackEventList, aBTest.trackEventList);
    }

    public final String getAbName() {
        return this.abName;
    }

    public final Long getLayerId() {
        return this.layerId;
    }

    public final Long getReqInterval() {
        return this.reqInterval;
    }

    public final String getSwitch() {
        return this.switch;
    }

    public final ArrayList<String> getTrackEvent() {
        return this.trackEventList;
    }

    public int hashCode() {
        String str = this.abName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.layerId;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.reqInterval;
        int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.switch;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ArrayList<String> arrayList = this.trackEventList;
        return hashCode4 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public String toString() {
        return "ABTest(abName=" + this.abName + ", layerId=" + this.layerId + ", reqInterval=" + this.reqInterval + ", switch=" + this.switch + ", trackEventList=" + this.trackEventList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.h(parcel, "out");
        parcel.writeString(this.abName);
        Long l = this.layerId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        Long l2 = this.reqInterval;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        parcel.writeString(this.switch);
        parcel.writeStringList(this.trackEventList);
    }
}
