package com.transsion.room.sub.bean.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J:\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0003J\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0005\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006+"}, d2 = {"Lcom/transsion/room/sub/bean/subscription/SubscriptionStatsBean;", "Landroid/os/Parcelable;", "followerCount", BuildConfig.FLAVOR, "followingCount", "isSubscribed", BuildConfig.FLAVOR, "publishCount", "<init>", "(ILjava/lang/Integer;Ljava/lang/Boolean;I)V", "getFollowerCount", "()I", "setFollowerCount", "(I)V", "getFollowingCount", "()Ljava/lang/Integer;", "setFollowingCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "setSubscribed", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPublishCount", "setPublishCount", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/Integer;Ljava/lang/Boolean;I)Lcom/transsion/room/sub/bean/subscription/SubscriptionStatsBean;", "describeContents", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class SubscriptionStatsBean implements Parcelable {
    public static final Parcelable.Creator<SubscriptionStatsBean> CREATOR = new a();
    private int followerCount;
    private Integer followingCount;
    private Boolean isSubscribed;
    private int publishCount;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SubscriptionStatsBean createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            int readInt = parcel.readInt();
            Boolean bool = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new SubscriptionStatsBean(readInt, valueOf, bool, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SubscriptionStatsBean[] newArray(int i) {
            return new SubscriptionStatsBean[i];
        }
    }

    public SubscriptionStatsBean() {
        this(0, null, null, 0, 15, null);
    }

    public SubscriptionStatsBean(int i, Integer num, Boolean bool, int i2) {
        this.followerCount = i;
        this.followingCount = num;
        this.isSubscribed = bool;
        this.publishCount = i2;
    }

    public /* synthetic */ SubscriptionStatsBean(int i, Integer num, Boolean bool, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : num, (i3 & 4) != 0 ? Boolean.FALSE : bool, (i3 & 8) != 0 ? 0 : i2);
    }

    public static /* synthetic */ SubscriptionStatsBean copy$default(SubscriptionStatsBean subscriptionStatsBean, int i, Integer num, Boolean bool, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = subscriptionStatsBean.followerCount;
        }
        if ((i3 & 2) != 0) {
            num = subscriptionStatsBean.followingCount;
        }
        if ((i3 & 4) != 0) {
            bool = subscriptionStatsBean.isSubscribed;
        }
        if ((i3 & 8) != 0) {
            i2 = subscriptionStatsBean.publishCount;
        }
        return subscriptionStatsBean.copy(i, num, bool, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFollowerCount() {
        return this.followerCount;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getFollowingCount() {
        return this.followingCount;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getIsSubscribed() {
        return this.isSubscribed;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPublishCount() {
        return this.publishCount;
    }

    public final SubscriptionStatsBean copy(int followerCount, Integer followingCount, Boolean isSubscribed, int publishCount) {
        return new SubscriptionStatsBean(followerCount, followingCount, isSubscribed, publishCount);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionStatsBean)) {
            return false;
        }
        SubscriptionStatsBean subscriptionStatsBean = (SubscriptionStatsBean) other;
        return this.followerCount == subscriptionStatsBean.followerCount && Intrinsics.c(this.followingCount, subscriptionStatsBean.followingCount) && Intrinsics.c(this.isSubscribed, subscriptionStatsBean.isSubscribed) && this.publishCount == subscriptionStatsBean.publishCount;
    }

    public final int getFollowerCount() {
        return this.followerCount;
    }

    public final Integer getFollowingCount() {
        return this.followingCount;
    }

    public final int getPublishCount() {
        return this.publishCount;
    }

    public int hashCode() {
        int i = this.followerCount * 31;
        Integer num = this.followingCount;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isSubscribed;
        return ((hashCode + (bool != null ? bool.hashCode() : 0)) * 31) + this.publishCount;
    }

    public final Boolean isSubscribed() {
        return this.isSubscribed;
    }

    public final void setFollowerCount(int i) {
        this.followerCount = i;
    }

    public final void setFollowingCount(Integer num) {
        this.followingCount = num;
    }

    public final void setPublishCount(int i) {
        this.publishCount = i;
    }

    public final void setSubscribed(Boolean bool) {
        this.isSubscribed = bool;
    }

    public String toString() {
        return "SubscriptionStatsBean(followerCount=" + this.followerCount + ", followingCount=" + this.followingCount + ", isSubscribed=" + this.isSubscribed + ", publishCount=" + this.publishCount + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.followerCount);
        Integer num = this.followingCount;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Boolean bool = this.isSubscribed;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeInt(this.publishCount);
    }
}
