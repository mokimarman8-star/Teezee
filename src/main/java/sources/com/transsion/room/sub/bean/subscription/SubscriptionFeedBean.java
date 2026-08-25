package com.transsion.room.sub.bean.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Lcom/transsion/room/sub/bean/subscription/SubscriptionFeedBean;", "Landroid/os/Parcelable;", "nextCursor", BuildConfig.FLAVOR, "feedItems", BuildConfig.FLAVOR, "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "hasMore", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "getNextCursor", "()Ljava/lang/String;", "setNextCursor", "(Ljava/lang/String;)V", "getFeedItems", "()Ljava/util/List;", "setFeedItems", "(Ljava/util/List;)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "component1", "component2", "component3", "copy", "describeContents", BuildConfig.FLAVOR, "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class SubscriptionFeedBean implements Parcelable {
    public static final Parcelable.Creator<SubscriptionFeedBean> CREATOR = new a();
    private List<UGCVideo> feedItems;
    private boolean hasMore;
    private String nextCursor;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SubscriptionFeedBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.h(parcel, "parcel");
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(parcel.readSerializable());
                }
                arrayList = arrayList2;
            }
            return new SubscriptionFeedBean(readString, arrayList, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SubscriptionFeedBean[] newArray(int i) {
            return new SubscriptionFeedBean[i];
        }
    }

    public SubscriptionFeedBean(String str, List<UGCVideo> list, boolean z) {
        this.nextCursor = str;
        this.feedItems = list;
        this.hasMore = z;
    }

    public /* synthetic */ SubscriptionFeedBean(String str, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, list, (i & 4) != 0 ? false : z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubscriptionFeedBean copy$default(SubscriptionFeedBean subscriptionFeedBean, String str, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriptionFeedBean.nextCursor;
        }
        if ((i & 2) != 0) {
            list = subscriptionFeedBean.feedItems;
        }
        if ((i & 4) != 0) {
            z = subscriptionFeedBean.hasMore;
        }
        return subscriptionFeedBean.copy(str, list, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNextCursor() {
        return this.nextCursor;
    }

    public final List<UGCVideo> component2() {
        return this.feedItems;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final SubscriptionFeedBean copy(String nextCursor, List<UGCVideo> feedItems, boolean hasMore) {
        return new SubscriptionFeedBean(nextCursor, feedItems, hasMore);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionFeedBean)) {
            return false;
        }
        SubscriptionFeedBean subscriptionFeedBean = (SubscriptionFeedBean) other;
        return Intrinsics.c(this.nextCursor, subscriptionFeedBean.nextCursor) && Intrinsics.c(this.feedItems, subscriptionFeedBean.feedItems) && this.hasMore == subscriptionFeedBean.hasMore;
    }

    public final List<UGCVideo> getFeedItems() {
        return this.feedItems;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextCursor() {
        return this.nextCursor;
    }

    public int hashCode() {
        String str = this.nextCursor;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<UGCVideo> list = this.feedItems;
        return ((hashCode + (list != null ? list.hashCode() : 0)) * 31) + e.a(this.hasMore);
    }

    public final void setFeedItems(List<UGCVideo> list) {
        this.feedItems = list;
    }

    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public final void setNextCursor(String str) {
        this.nextCursor = str;
    }

    public String toString() {
        return "SubscriptionFeedBean(nextCursor=" + this.nextCursor + ", feedItems=" + this.feedItems + ", hasMore=" + this.hasMore + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.nextCursor);
        List<UGCVideo> list = this.feedItems;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<UGCVideo> it = list.iterator();
            while (it.hasNext()) {
                dest.writeSerializable((Serializable) it.next());
            }
        }
        dest.writeInt(this.hasMore ? 1 : 0);
    }
}
