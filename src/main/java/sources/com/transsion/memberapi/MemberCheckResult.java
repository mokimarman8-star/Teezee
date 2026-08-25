package com.transsion.memberapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010B\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0015HÆ\u0003J¶\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010IJ\u0006\u0010J\u001a\u00020\u000eJ\u0013\u0010K\u001a\u00020\u00032\b\u0010L\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020\u000eHÖ\u0001J\t\u0010O\u001a\u00020\u0005HÖ\u0001J\u0016\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u000eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0002\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001d\"\u0004\b6\u0010\u001fR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010%\"\u0004\b8\u0010'R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006U"}, d2 = {"Lcom/transsion/memberapi/MemberCheckResult;", "Landroid/os/Parcelable;", "isPassed", "", "interceptType", "", "memberPrice", "currency", "memberRights", "", "Lcom/transsion/memberapi/MemberRights;", "vipEnable", "vipPayEnable", "multiDownloadLimit", "", "inviteRewardDays", "inviteH5Url", "pointUrl", "vipAdScenes", "", "threeInOnePopup", "Lcom/transsion/memberapi/ThreeInOnePopup;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/transsion/memberapi/ThreeInOnePopup;)V", "()Ljava/lang/Boolean;", "setPassed", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getInterceptType", "()Ljava/lang/String;", "setInterceptType", "(Ljava/lang/String;)V", "getMemberPrice", "setMemberPrice", "getCurrency", "setCurrency", "getMemberRights", "()Ljava/util/List;", "setMemberRights", "(Ljava/util/List;)V", "getVipEnable", "setVipEnable", "getVipPayEnable", "setVipPayEnable", "getMultiDownloadLimit", "()Ljava/lang/Integer;", "setMultiDownloadLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getInviteRewardDays", "setInviteRewardDays", "getInviteH5Url", "setInviteH5Url", "getPointUrl", "setPointUrl", "getVipAdScenes", "setVipAdScenes", "getThreeInOnePopup", "()Lcom/transsion/memberapi/ThreeInOnePopup;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/transsion/memberapi/ThreeInOnePopup;)Lcom/transsion/memberapi/MemberCheckResult;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final /* data */ class MemberCheckResult implements Parcelable {
    public static final Parcelable.Creator<MemberCheckResult> CREATOR = new a();
    private String currency;
    private String interceptType;
    private String inviteH5Url;
    private String inviteRewardDays;
    private Boolean isPassed;
    private String memberPrice;
    private List<MemberRights> memberRights;
    private Integer multiDownloadLimit;
    private String pointUrl;
    private final ThreeInOnePopup threeInOnePopup;
    private List<String> vipAdScenes;
    private Boolean vipEnable;
    private Boolean vipPayEnable;

    public MemberCheckResult(Boolean bool, String str, String str2, String str3, List<MemberRights> list, Boolean bool2, Boolean bool3, Integer num, String str4, String str5, String str6, List<String> list2, ThreeInOnePopup threeInOnePopup) {
        this.isPassed = bool;
        this.interceptType = str;
        this.memberPrice = str2;
        this.currency = str3;
        this.memberRights = list;
        this.vipEnable = bool2;
        this.vipPayEnable = bool3;
        this.multiDownloadLimit = num;
        this.inviteRewardDays = str4;
        this.inviteH5Url = str5;
        this.pointUrl = str6;
        this.vipAdScenes = list2;
        this.threeInOnePopup = threeInOnePopup;
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsPassed() {
        return this.isPassed;
    }

    /* renamed from: component10, reason: from getter */
    public final String getInviteH5Url() {
        return this.inviteH5Url;
    }

    /* renamed from: component11, reason: from getter */
    public final String getPointUrl() {
        return this.pointUrl;
    }

    public final List<String> component12() {
        return this.vipAdScenes;
    }

    /* renamed from: component13, reason: from getter */
    public final ThreeInOnePopup getThreeInOnePopup() {
        return this.threeInOnePopup;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInterceptType() {
        return this.interceptType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMemberPrice() {
        return this.memberPrice;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final List<MemberRights> component5() {
        return this.memberRights;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getVipEnable() {
        return this.vipEnable;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getVipPayEnable() {
        return this.vipPayEnable;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getMultiDownloadLimit() {
        return this.multiDownloadLimit;
    }

    /* renamed from: component9, reason: from getter */
    public final String getInviteRewardDays() {
        return this.inviteRewardDays;
    }

    public final MemberCheckResult copy(Boolean isPassed, String interceptType, String memberPrice, String currency, List<MemberRights> memberRights, Boolean vipEnable, Boolean vipPayEnable, Integer multiDownloadLimit, String inviteRewardDays, String inviteH5Url, String pointUrl, List<String> vipAdScenes, ThreeInOnePopup threeInOnePopup) {
        return new MemberCheckResult(isPassed, interceptType, memberPrice, currency, memberRights, vipEnable, vipPayEnable, multiDownloadLimit, inviteRewardDays, inviteH5Url, pointUrl, vipAdScenes, threeInOnePopup);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberCheckResult)) {
            return false;
        }
        MemberCheckResult memberCheckResult = (MemberCheckResult) other;
        return Intrinsics.c(this.isPassed, memberCheckResult.isPassed) && Intrinsics.c(this.interceptType, memberCheckResult.interceptType) && Intrinsics.c(this.memberPrice, memberCheckResult.memberPrice) && Intrinsics.c(this.currency, memberCheckResult.currency) && Intrinsics.c(this.memberRights, memberCheckResult.memberRights) && Intrinsics.c(this.vipEnable, memberCheckResult.vipEnable) && Intrinsics.c(this.vipPayEnable, memberCheckResult.vipPayEnable) && Intrinsics.c(this.multiDownloadLimit, memberCheckResult.multiDownloadLimit) && Intrinsics.c(this.inviteRewardDays, memberCheckResult.inviteRewardDays) && Intrinsics.c(this.inviteH5Url, memberCheckResult.inviteH5Url) && Intrinsics.c(this.pointUrl, memberCheckResult.pointUrl) && Intrinsics.c(this.vipAdScenes, memberCheckResult.vipAdScenes) && Intrinsics.c(this.threeInOnePopup, memberCheckResult.threeInOnePopup);
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getInterceptType() {
        return this.interceptType;
    }

    public final String getInviteH5Url() {
        return this.inviteH5Url;
    }

    public final String getInviteRewardDays() {
        return this.inviteRewardDays;
    }

    public final String getMemberPrice() {
        return this.memberPrice;
    }

    public final List<MemberRights> getMemberRights() {
        return this.memberRights;
    }

    public final Integer getMultiDownloadLimit() {
        return this.multiDownloadLimit;
    }

    public final String getPointUrl() {
        return this.pointUrl;
    }

    public final ThreeInOnePopup getThreeInOnePopup() {
        return this.threeInOnePopup;
    }

    public final List<String> getVipAdScenes() {
        return this.vipAdScenes;
    }

    public final Boolean getVipEnable() {
        Boolean bool = this.vipEnable;
        return Boolean.TRUE;
    }

    public final Boolean getVipPayEnable() {
        Boolean bool = this.vipPayEnable;
        return Boolean.TRUE;
    }

    public int hashCode() {
        Boolean bool = this.isPassed;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.interceptType;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.memberPrice;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.currency;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<MemberRights> list = this.memberRights;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool2 = this.vipEnable;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.vipPayEnable;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num = this.multiDownloadLimit;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.inviteRewardDays;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.inviteH5Url;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.pointUrl;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<String> list2 = this.vipAdScenes;
        int hashCode12 = (hashCode11 + (list2 == null ? 0 : list2.hashCode())) * 31;
        ThreeInOnePopup threeInOnePopup = this.threeInOnePopup;
        return hashCode12 + (threeInOnePopup != null ? threeInOnePopup.hashCode() : 0);
    }

    public final Boolean isPassed() {
        Boolean bool = this.isPassed;
        return Boolean.TRUE;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setInterceptType(String str) {
        this.interceptType = str;
    }

    public final void setInviteH5Url(String str) {
        this.inviteH5Url = str;
    }

    public final void setInviteRewardDays(String str) {
        this.inviteRewardDays = str;
    }

    public final void setMemberPrice(String str) {
        this.memberPrice = str;
    }

    public final void setMemberRights(List<MemberRights> list) {
        this.memberRights = list;
    }

    public final void setMultiDownloadLimit(Integer num) {
        this.multiDownloadLimit = num;
    }

    public final void setPassed(Boolean bool) {
        this.isPassed = bool;
    }

    public final void setPointUrl(String str) {
        this.pointUrl = str;
    }

    public final void setVipAdScenes(List<String> list) {
        this.vipAdScenes = list;
    }

    public final void setVipEnable(Boolean bool) {
        this.vipEnable = bool;
    }

    public final void setVipPayEnable(Boolean bool) {
        this.vipPayEnable = bool;
    }

    public String toString() {
        return "MemberCheckResult(isPassed=" + this.isPassed + ", interceptType=" + this.interceptType + ", memberPrice=" + this.memberPrice + ", currency=" + this.currency + ", memberRights=" + this.memberRights + ", vipEnable=" + this.vipEnable + ", vipPayEnable=" + this.vipPayEnable + ", multiDownloadLimit=" + this.multiDownloadLimit + ", inviteRewardDays=" + this.inviteRewardDays + ", inviteH5Url=" + this.inviteH5Url + ", pointUrl=" + this.pointUrl + ", vipAdScenes=" + this.vipAdScenes + ", threeInOnePopup=" + this.threeInOnePopup + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        Boolean bool = this.isPassed;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.interceptType);
        dest.writeString(this.memberPrice);
        dest.writeString(this.currency);
        List<MemberRights> list = this.memberRights;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<MemberRights> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        Boolean bool2 = this.vipEnable;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.vipPayEnable;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Integer num = this.multiDownloadLimit;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.inviteRewardDays);
        dest.writeString(this.inviteH5Url);
        dest.writeString(this.pointUrl);
        dest.writeStringList(this.vipAdScenes);
        ThreeInOnePopup threeInOnePopup = this.threeInOnePopup;
        if (threeInOnePopup == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            threeInOnePopup.writeToParcel(dest, flags);
        }
    }
}
