package com.transsion.push.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\bJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006%"}, d2 = {"Lcom/transsion/push/bean/PagerConfig;", "Landroid/os/Parcelable;", "hasMore", BuildConfig.FLAVOR, "nextPage", BuildConfig.FLAVOR, "page", "perPage", BuildConfig.FLAVOR, "totalCount", "<init>", "(ZLjava/lang/String;Ljava/lang/String;II)V", "getHasMore", "()Z", "getNextPage", "()Ljava/lang/String;", "getPage", "getPerPage", "()I", "getTotalCount", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class PagerConfig implements Parcelable {
    public static final Parcelable.Creator<PagerConfig> CREATOR = new Creator();
    private final boolean hasMore;
    private final String nextPage;
    private final String page;
    private final int perPage;
    private final int totalCount;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PagerConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PagerConfig createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new PagerConfig(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PagerConfig[] newArray(int i) {
            return new PagerConfig[i];
        }
    }

    public PagerConfig(boolean z, String str, String str2, int i, int i2) {
        this.hasMore = z;
        this.nextPage = str;
        this.page = str2;
        this.perPage = i;
        this.totalCount = i2;
    }

    public /* synthetic */ PagerConfig(boolean z, String str, String str2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    public static /* synthetic */ PagerConfig copy$default(PagerConfig pagerConfig, boolean z, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = pagerConfig.hasMore;
        }
        if ((i3 & 2) != 0) {
            str = pagerConfig.nextPage;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = pagerConfig.page;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i = pagerConfig.perPage;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = pagerConfig.totalCount;
        }
        return pagerConfig.copy(z, str3, str4, i4, i2);
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

    public final PagerConfig copy(boolean hasMore, String nextPage, String page, int perPage, int totalCount) {
        return new PagerConfig(hasMore, nextPage, page, perPage, totalCount);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagerConfig)) {
            return false;
        }
        PagerConfig pagerConfig = (PagerConfig) other;
        return this.hasMore == pagerConfig.hasMore && Intrinsics.c(this.nextPage, pagerConfig.nextPage) && Intrinsics.c(this.page, pagerConfig.page) && this.perPage == pagerConfig.perPage && this.totalCount == pagerConfig.totalCount;
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
        int a = e.a(this.hasMore) * 31;
        String str = this.nextPage;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.page;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.perPage) * 31) + this.totalCount;
    }

    public String toString() {
        return "PagerConfig(hasMore=" + this.hasMore + ", nextPage=" + this.nextPage + ", page=" + this.page + ", perPage=" + this.perPage + ", totalCount=" + this.totalCount + ")";
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
