package com.transsion.ad.db.pslink;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\bC\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J´\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010NJ\u0006\u0010O\u001a\u00020\u0003J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SHÖ\u0003J\t\u0010T\u001a\u00020\u0003HÖ\u0001J\t\u0010U\u001a\u00020\u0005HÖ\u0001J\u0016\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001d¨\u0006["}, d2 = {"Lcom/transsion/ad/db/pslink/PsLinkAdPlan;", "Landroid/os/Parcelable;", "id", BuildConfig.FLAVOR, "nonId", BuildConfig.FLAVOR, "adSource", "extAdSlot", "rank", "psPlanId", "psLinkAdInfoStr", "psInfoJson", "updateTimestamp", BuildConfig.FLAVOR, "showMax", "clickMax", "showHours", "showedTimes", "clickedTimes", "showDate", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getNonId", "()Ljava/lang/String;", "setNonId", "(Ljava/lang/String;)V", "getAdSource", "setAdSource", "getExtAdSlot", "setExtAdSlot", "getRank", "setRank", "getPsPlanId", "setPsPlanId", "getPsLinkAdInfoStr", "setPsLinkAdInfoStr", "getPsInfoJson", "setPsInfoJson", "getUpdateTimestamp", "()Ljava/lang/Long;", "setUpdateTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getShowMax", "()Ljava/lang/Integer;", "setShowMax", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClickMax", "setClickMax", "getShowHours", "setShowHours", "getShowedTimes", "setShowedTimes", "getClickedTimes", "setClickedTimes", "getShowDate", "setShowDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;IILjava/lang/String;)Lcom/transsion/ad/db/pslink/PsLinkAdPlan;", "describeContents", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class PsLinkAdPlan implements Parcelable {
    public static final Parcelable.Creator<PsLinkAdPlan> CREATOR = new a();
    private String adSource;
    private Integer clickMax;
    private int clickedTimes;
    private String extAdSlot;
    private int id;
    private String nonId;
    private String psInfoJson;
    private String psLinkAdInfoStr;
    private String psPlanId;
    private int rank;
    private String showDate;
    private String showHours;
    private Integer showMax;
    private int showedTimes;
    private Long updateTimestamp;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PsLinkAdPlan createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new PsLinkAdPlan(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PsLinkAdPlan[] newArray(int i) {
            return new PsLinkAdPlan[i];
        }
    }

    public PsLinkAdPlan(int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, Long l, Integer num, Integer num2, String str7, int i3, int i4, String str8) {
        Intrinsics.h(str, "nonId");
        Intrinsics.h(str2, "adSource");
        Intrinsics.h(str3, "extAdSlot");
        this.id = i;
        this.nonId = str;
        this.adSource = str2;
        this.extAdSlot = str3;
        this.rank = i2;
        this.psPlanId = str4;
        this.psLinkAdInfoStr = str5;
        this.psInfoJson = str6;
        this.updateTimestamp = l;
        this.showMax = num;
        this.clickMax = num2;
        this.showHours = str7;
        this.showedTimes = i3;
        this.clickedTimes = i4;
        this.showDate = str8;
    }

    public /* synthetic */ PsLinkAdPlan(int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, Long l, Integer num, Integer num2, String str7, int i3, int i4, String str8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, str3, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) != 0 ? null : str4, (i5 & 64) != 0 ? null : str5, (i5 & 128) != 0 ? null : str6, (i5 & 256) != 0 ? null : l, (i5 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? null : num, (i5 & 1024) != 0 ? null : num2, (i5 & 2048) != 0 ? null : str7, (i5 & 4096) != 0 ? 0 : i3, (i5 & 8192) != 0 ? 0 : i4, (i5 & 16384) != 0 ? null : str8);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getShowMax() {
        return this.showMax;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getClickMax() {
        return this.clickMax;
    }

    /* renamed from: component12, reason: from getter */
    public final String getShowHours() {
        return this.showHours;
    }

    /* renamed from: component13, reason: from getter */
    public final int getShowedTimes() {
        return this.showedTimes;
    }

    /* renamed from: component14, reason: from getter */
    public final int getClickedTimes() {
        return this.clickedTimes;
    }

    /* renamed from: component15, reason: from getter */
    public final String getShowDate() {
        return this.showDate;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNonId() {
        return this.nonId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAdSource() {
        return this.adSource;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExtAdSlot() {
        return this.extAdSlot;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPsPlanId() {
        return this.psPlanId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPsLinkAdInfoStr() {
        return this.psLinkAdInfoStr;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPsInfoJson() {
        return this.psInfoJson;
    }

    /* renamed from: component9, reason: from getter */
    public final Long getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public final PsLinkAdPlan copy(int id, String nonId, String adSource, String extAdSlot, int rank, String psPlanId, String psLinkAdInfoStr, String psInfoJson, Long updateTimestamp, Integer showMax, Integer clickMax, String showHours, int showedTimes, int clickedTimes, String showDate) {
        Intrinsics.h(nonId, "nonId");
        Intrinsics.h(adSource, "adSource");
        Intrinsics.h(extAdSlot, "extAdSlot");
        return new PsLinkAdPlan(id, nonId, adSource, extAdSlot, rank, psPlanId, psLinkAdInfoStr, psInfoJson, updateTimestamp, showMax, clickMax, showHours, showedTimes, clickedTimes, showDate);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PsLinkAdPlan)) {
            return false;
        }
        PsLinkAdPlan psLinkAdPlan = (PsLinkAdPlan) other;
        return this.id == psLinkAdPlan.id && Intrinsics.c(this.nonId, psLinkAdPlan.nonId) && Intrinsics.c(this.adSource, psLinkAdPlan.adSource) && Intrinsics.c(this.extAdSlot, psLinkAdPlan.extAdSlot) && this.rank == psLinkAdPlan.rank && Intrinsics.c(this.psPlanId, psLinkAdPlan.psPlanId) && Intrinsics.c(this.psLinkAdInfoStr, psLinkAdPlan.psLinkAdInfoStr) && Intrinsics.c(this.psInfoJson, psLinkAdPlan.psInfoJson) && Intrinsics.c(this.updateTimestamp, psLinkAdPlan.updateTimestamp) && Intrinsics.c(this.showMax, psLinkAdPlan.showMax) && Intrinsics.c(this.clickMax, psLinkAdPlan.clickMax) && Intrinsics.c(this.showHours, psLinkAdPlan.showHours) && this.showedTimes == psLinkAdPlan.showedTimes && this.clickedTimes == psLinkAdPlan.clickedTimes && Intrinsics.c(this.showDate, psLinkAdPlan.showDate);
    }

    public final String getAdSource() {
        return this.adSource;
    }

    public final Integer getClickMax() {
        return this.clickMax;
    }

    public final int getClickedTimes() {
        return this.clickedTimes;
    }

    public final String getExtAdSlot() {
        return this.extAdSlot;
    }

    public final int getId() {
        return this.id;
    }

    public final String getNonId() {
        return this.nonId;
    }

    public final String getPsInfoJson() {
        return this.psInfoJson;
    }

    public final String getPsLinkAdInfoStr() {
        return this.psLinkAdInfoStr;
    }

    public final String getPsPlanId() {
        return this.psPlanId;
    }

    public final int getRank() {
        return this.rank;
    }

    public final String getShowDate() {
        return this.showDate;
    }

    public final String getShowHours() {
        return this.showHours;
    }

    public final Integer getShowMax() {
        return this.showMax;
    }

    public final int getShowedTimes() {
        return this.showedTimes;
    }

    public final Long getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public int hashCode() {
        int hashCode = ((((((((this.id * 31) + this.nonId.hashCode()) * 31) + this.adSource.hashCode()) * 31) + this.extAdSlot.hashCode()) * 31) + this.rank) * 31;
        String str = this.psPlanId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.psLinkAdInfoStr;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.psInfoJson;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.updateTimestamp;
        int hashCode5 = (hashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.showMax;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.clickMax;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.showHours;
        int hashCode8 = (((((hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.showedTimes) * 31) + this.clickedTimes) * 31;
        String str5 = this.showDate;
        return hashCode8 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setAdSource(String str) {
        Intrinsics.h(str, "<set-?>");
        this.adSource = str;
    }

    public final void setClickMax(Integer num) {
        this.clickMax = num;
    }

    public final void setClickedTimes(int i) {
        this.clickedTimes = i;
    }

    public final void setExtAdSlot(String str) {
        Intrinsics.h(str, "<set-?>");
        this.extAdSlot = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setNonId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.nonId = str;
    }

    public final void setPsInfoJson(String str) {
        this.psInfoJson = str;
    }

    public final void setPsLinkAdInfoStr(String str) {
        this.psLinkAdInfoStr = str;
    }

    public final void setPsPlanId(String str) {
        this.psPlanId = str;
    }

    public final void setRank(int i) {
        this.rank = i;
    }

    public final void setShowDate(String str) {
        this.showDate = str;
    }

    public final void setShowHours(String str) {
        this.showHours = str;
    }

    public final void setShowMax(Integer num) {
        this.showMax = num;
    }

    public final void setShowedTimes(int i) {
        this.showedTimes = i;
    }

    public final void setUpdateTimestamp(Long l) {
        this.updateTimestamp = l;
    }

    public String toString() {
        return "PsLinkAdPlan(id=" + this.id + ", nonId=" + this.nonId + ", adSource=" + this.adSource + ", extAdSlot=" + this.extAdSlot + ", rank=" + this.rank + ", psPlanId=" + this.psPlanId + ", psLinkAdInfoStr=" + this.psLinkAdInfoStr + ", psInfoJson=" + this.psInfoJson + ", updateTimestamp=" + this.updateTimestamp + ", showMax=" + this.showMax + ", clickMax=" + this.clickMax + ", showHours=" + this.showHours + ", showedTimes=" + this.showedTimes + ", clickedTimes=" + this.clickedTimes + ", showDate=" + this.showDate + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.id);
        dest.writeString(this.nonId);
        dest.writeString(this.adSource);
        dest.writeString(this.extAdSlot);
        dest.writeInt(this.rank);
        dest.writeString(this.psPlanId);
        dest.writeString(this.psLinkAdInfoStr);
        dest.writeString(this.psInfoJson);
        Long l = this.updateTimestamp;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Integer num = this.showMax;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.clickMax;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.showHours);
        dest.writeInt(this.showedTimes);
        dest.writeInt(this.clickedTimes);
        dest.writeString(this.showDate);
    }
}
