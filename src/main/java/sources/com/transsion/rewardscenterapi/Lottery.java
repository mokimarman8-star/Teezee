package com.transsion.rewardscenterapi;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/transsion/rewardscenterapi/Lottery;", "Ljava/io/Serializable;", "activityId", BuildConfig.FLAVOR, "prizeFlows", BuildConfig.FLAVOR, "Lcom/transsion/rewardscenterapi/PrizeFlow;", "banner", "Lcom/transsion/rewardscenterapi/Banner;", "userPrize", "Lcom/transsion/rewardscenterapi/UserPrize;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/transsion/rewardscenterapi/Banner;Lcom/transsion/rewardscenterapi/UserPrize;)V", "getActivityId", "()Ljava/lang/String;", "getPrizeFlows", "()Ljava/util/List;", "getBanner", "()Lcom/transsion/rewardscenterapi/Banner;", "getUserPrize", "()Lcom/transsion/rewardscenterapi/UserPrize;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "RewardsCenterApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class Lottery implements Serializable {
    private final String activityId;
    private final Banner banner;
    private final List<PrizeFlow> prizeFlows;
    private final UserPrize userPrize;

    public Lottery() {
        this(null, null, null, null, 15, null);
    }

    public Lottery(String str, List<PrizeFlow> list, Banner banner, UserPrize userPrize) {
        this.activityId = str;
        this.prizeFlows = list;
        this.banner = banner;
        this.userPrize = userPrize;
    }

    public /* synthetic */ Lottery(String str, List list, Banner banner, UserPrize userPrize, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : banner, (i & 8) != 0 ? null : userPrize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Lottery copy$default(Lottery lottery, String str, List list, Banner banner, UserPrize userPrize, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lottery.activityId;
        }
        if ((i & 2) != 0) {
            list = lottery.prizeFlows;
        }
        if ((i & 4) != 0) {
            banner = lottery.banner;
        }
        if ((i & 8) != 0) {
            userPrize = lottery.userPrize;
        }
        return lottery.copy(str, list, banner, userPrize);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    public final List<PrizeFlow> component2() {
        return this.prizeFlows;
    }

    /* renamed from: component3, reason: from getter */
    public final Banner getBanner() {
        return this.banner;
    }

    /* renamed from: component4, reason: from getter */
    public final UserPrize getUserPrize() {
        return this.userPrize;
    }

    public final Lottery copy(String activityId, List<PrizeFlow> prizeFlows, Banner banner, UserPrize userPrize) {
        return new Lottery(activityId, prizeFlows, banner, userPrize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Lottery)) {
            return false;
        }
        Lottery lottery = (Lottery) other;
        return Intrinsics.c(this.activityId, lottery.activityId) && Intrinsics.c(this.prizeFlows, lottery.prizeFlows) && Intrinsics.c(this.banner, lottery.banner) && Intrinsics.c(this.userPrize, lottery.userPrize);
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final Banner getBanner() {
        return this.banner;
    }

    public final List<PrizeFlow> getPrizeFlows() {
        return this.prizeFlows;
    }

    public final UserPrize getUserPrize() {
        return this.userPrize;
    }

    public int hashCode() {
        String str = this.activityId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<PrizeFlow> list = this.prizeFlows;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Banner banner = this.banner;
        int hashCode3 = (hashCode2 + (banner == null ? 0 : banner.hashCode())) * 31;
        UserPrize userPrize = this.userPrize;
        return hashCode3 + (userPrize != null ? userPrize.hashCode() : 0);
    }

    public String toString() {
        return "Lottery(activityId=" + this.activityId + ", prizeFlows=" + this.prizeFlows + ", banner=" + this.banner + ", userPrize=" + this.userPrize + ")";
    }
}
