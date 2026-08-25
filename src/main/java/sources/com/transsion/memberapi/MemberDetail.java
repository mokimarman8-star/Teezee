package com.transsion.memberapi;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003JI\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00061"}, d2 = {"Lcom/transsion/memberapi/MemberDetail;", "Ljava/io/Serializable;", "memberInfo", "Lcom/transsion/memberapi/MemberInfo;", "memberRights", BuildConfig.FLAVOR, "Lcom/transsion/memberapi/MemberRight;", "rewardInfo", "Lcom/transsion/memberapi/RewardInfo;", "userInfo", "Lcom/transsnet/loginapi/bean/UserInfo;", "pointInfo", "Lcom/transsion/memberapi/PointInfo;", "<init>", "(Lcom/transsion/memberapi/MemberInfo;Ljava/util/List;Lcom/transsion/memberapi/RewardInfo;Lcom/transsnet/loginapi/bean/UserInfo;Lcom/transsion/memberapi/PointInfo;)V", "getMemberInfo", "()Lcom/transsion/memberapi/MemberInfo;", "setMemberInfo", "(Lcom/transsion/memberapi/MemberInfo;)V", "getMemberRights", "()Ljava/util/List;", "setMemberRights", "(Ljava/util/List;)V", "getRewardInfo", "()Lcom/transsion/memberapi/RewardInfo;", "setRewardInfo", "(Lcom/transsion/memberapi/RewardInfo;)V", "getUserInfo", "()Lcom/transsnet/loginapi/bean/UserInfo;", "setUserInfo", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "getPointInfo", "()Lcom/transsion/memberapi/PointInfo;", "setPointInfo", "(Lcom/transsion/memberapi/PointInfo;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MemberDetail implements Serializable {
    private MemberInfo memberInfo;
    private List<MemberRight> memberRights;
    private PointInfo pointInfo;
    private RewardInfo rewardInfo;
    private UserInfo userInfo;

    public MemberDetail(MemberInfo memberInfo, List<MemberRight> list, RewardInfo rewardInfo, UserInfo userInfo, PointInfo pointInfo) {
        Intrinsics.h(rewardInfo, "rewardInfo");
        this.memberInfo = memberInfo;
        this.memberRights = list;
        this.rewardInfo = rewardInfo;
        this.userInfo = userInfo;
        this.pointInfo = pointInfo;
    }

    public static /* synthetic */ MemberDetail copy$default(MemberDetail memberDetail, MemberInfo memberInfo, List list, RewardInfo rewardInfo, UserInfo userInfo, PointInfo pointInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            memberInfo = memberDetail.memberInfo;
        }
        if ((i & 2) != 0) {
            list = memberDetail.memberRights;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            rewardInfo = memberDetail.rewardInfo;
        }
        RewardInfo rewardInfo2 = rewardInfo;
        if ((i & 8) != 0) {
            userInfo = memberDetail.userInfo;
        }
        UserInfo userInfo2 = userInfo;
        if ((i & 16) != 0) {
            pointInfo = memberDetail.pointInfo;
        }
        return memberDetail.copy(memberInfo, list2, rewardInfo2, userInfo2, pointInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final MemberInfo getMemberInfo() {
        return this.memberInfo;
    }

    public final List<MemberRight> component2() {
        return this.memberRights;
    }

    /* renamed from: component3, reason: from getter */
    public final RewardInfo getRewardInfo() {
        return this.rewardInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final PointInfo getPointInfo() {
        return this.pointInfo;
    }

    public final MemberDetail copy(MemberInfo memberInfo, List<MemberRight> memberRights, RewardInfo rewardInfo, UserInfo userInfo, PointInfo pointInfo) {
        Intrinsics.h(rewardInfo, "rewardInfo");
        return new MemberDetail(memberInfo, memberRights, rewardInfo, userInfo, pointInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberDetail)) {
            return false;
        }
        MemberDetail memberDetail = (MemberDetail) other;
        return Intrinsics.c(this.memberInfo, memberDetail.memberInfo) && Intrinsics.c(this.memberRights, memberDetail.memberRights) && Intrinsics.c(this.rewardInfo, memberDetail.rewardInfo) && Intrinsics.c(this.userInfo, memberDetail.userInfo) && Intrinsics.c(this.pointInfo, memberDetail.pointInfo);
    }

    public final MemberInfo getMemberInfo() {
        return this.memberInfo;
    }

    public final List<MemberRight> getMemberRights() {
        return this.memberRights;
    }

    public final PointInfo getPointInfo() {
        return this.pointInfo;
    }

    public final RewardInfo getRewardInfo() {
        return this.rewardInfo;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        MemberInfo memberInfo = this.memberInfo;
        int hashCode = (memberInfo == null ? 0 : memberInfo.hashCode()) * 31;
        List<MemberRight> list = this.memberRights;
        int hashCode2 = (((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.rewardInfo.hashCode()) * 31;
        UserInfo userInfo = this.userInfo;
        int hashCode3 = (hashCode2 + (userInfo == null ? 0 : userInfo.hashCode())) * 31;
        PointInfo pointInfo = this.pointInfo;
        return hashCode3 + (pointInfo != null ? pointInfo.hashCode() : 0);
    }

    public final void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public final void setMemberRights(List<MemberRight> list) {
        this.memberRights = list;
    }

    public final void setPointInfo(PointInfo pointInfo) {
        this.pointInfo = pointInfo;
    }

    public final void setRewardInfo(RewardInfo rewardInfo) {
        Intrinsics.h(rewardInfo, "<set-?>");
        this.rewardInfo = rewardInfo;
    }

    public final void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String toString() {
        return "MemberDetail(memberInfo=" + this.memberInfo + ", memberRights=" + this.memberRights + ", rewardInfo=" + this.rewardInfo + ", userInfo=" + this.userInfo + ", pointInfo=" + this.pointInfo + ")";
    }
}
