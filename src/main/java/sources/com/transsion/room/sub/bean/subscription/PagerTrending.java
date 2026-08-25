package com.transsion.room.sub.bean.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J?\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0006\u0010\"\u001a\u00020\bJ\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006-"}, d2 = {"Lcom/transsion/room/sub/bean/subscription/PagerTrending;", "Landroid/os/Parcelable;", "hasMore", BuildConfig.FLAVOR, "nextPage", BuildConfig.FLAVOR, "page", "perPage", BuildConfig.FLAVOR, "totalCount", "<init>", "(ZLjava/lang/String;Ljava/lang/String;II)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getNextPage", "()Ljava/lang/String;", "setNextPage", "(Ljava/lang/String;)V", "getPage", "setPage", "getPerPage", "()I", "setPerPage", "(I)V", "getTotalCount", "setTotalCount", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class PagerTrending implements Parcelable {
    public static final Parcelable.Creator<PagerTrending> CREATOR = new a();
    private boolean hasMore;
    private String nextPage;
    private String page;
    private int perPage;
    private int totalCount;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PagerTrending createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new PagerTrending(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PagerTrending[] newArray(int i) {
            return new PagerTrending[i];
        }
    }

    public PagerTrending() {
        this(false, null, null, 0, 0, 31, null);
    }

    public PagerTrending(boolean z, String str, String str2, int i, int i2) {
        this.hasMore = z;
        this.nextPage = str;
        this.page = str2;
        this.perPage = i;
        this.totalCount = i2;
    }

    public /* synthetic */ PagerTrending(boolean z, String str, String str2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? null : str, (i3 & 4) == 0 ? str2 : null, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    public static /* synthetic */ PagerTrending copy$default(PagerTrending pagerTrending, boolean z, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = pagerTrending.hasMore;
        }
        if ((i3 & 2) != 0) {
            str = pagerTrending.nextPage;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = pagerTrending.page;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i = pagerTrending.perPage;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = pagerTrending.totalCount;
        }
        return pagerTrending.copy(z, str3, str4, i4, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNextPage() {
        return this.nextPage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPage() {
        return this.page;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPerPage() {
        return this.perPage;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public final PagerTrending copy(boolean hasMore, String nextPage, String page, int perPage, int totalCount) {
        return new PagerTrending(hasMore, nextPage, page, perPage, totalCount);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagerTrending)) {
            return false;
        }
        PagerTrending pagerTrending = (PagerTrending) other;
        return this.hasMore == pagerTrending.hasMore && Intrinsics.c(this.nextPage, pagerTrending.nextPage) && Intrinsics.c(this.page, pagerTrending.page) && this.perPage == pagerTrending.perPage && this.totalCount == pagerTrending.totalCount;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextPage() {
        return this.nextPage;
    }

    public final String getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        int a2 = e.a(this.hasMore) * 31;
        String str = this.nextPage;
        int hashCode = (a2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.page;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.perPage) * 31) + this.totalCount;
    }

    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public final void setNextPage(String str) {
        this.nextPage = str;
    }

    public final void setPage(String str) {
        this.page = str;
    }

    public final void setPerPage(int i) {
        this.perPage = i;
    }

    public final void setTotalCount(int i) {
        this.totalCount = i;
    }

    public String toString() {
        return "PagerTrending(hasMore=" + this.hasMore + ", nextPage=" + this.nextPage + ", page=" + this.page + ", perPage=" + this.perPage + ", totalCount=" + this.totalCount + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.hasMore ? 1 : 0);
        dest.writeString(this.nextPage);
        dest.writeString(this.page);
        dest.writeInt(this.perPage);
        dest.writeInt(this.totalCount);
    }
}
