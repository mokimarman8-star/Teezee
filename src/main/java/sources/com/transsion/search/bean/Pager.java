package com.transsion.search.bean;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/transsion/search/bean/Pager;", "Ljava/io/Serializable;", "hasMore", BuildConfig.FLAVOR, "nextPage", BuildConfig.FLAVOR, "page", "perPage", "totalCount", "<init>", "(ZIIII)V", "getHasMore", "()Z", "getNextPage", "()I", "getPage", "getPerPage", "getTotalCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class Pager implements Serializable {

    @SerializedName("hasMore")
    private final boolean hasMore;

    @SerializedName("nextPage")
    private final int nextPage;

    @SerializedName("page")
    private final int page;

    @SerializedName("perPage")
    private final int perPage;

    @SerializedName("totalCount")
    private final int totalCount;

    public Pager(boolean z, int i, int i2, int i3, int i4) {
        this.hasMore = z;
        this.nextPage = i;
        this.page = i2;
        this.perPage = i3;
        this.totalCount = i4;
    }

    public static /* synthetic */ Pager copy$default(Pager pager, boolean z, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z = pager.hasMore;
        }
        if ((i5 & 2) != 0) {
            i = pager.nextPage;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = pager.page;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = pager.perPage;
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = pager.totalCount;
        }
        return pager.copy(z, i6, i7, i8, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: component2, reason: from getter */
    public final int getNextPage() {
        return this.nextPage;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPage() {
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

    public final Pager copy(boolean hasMore, int nextPage, int page, int perPage, int totalCount) {
        return new Pager(hasMore, nextPage, page, perPage, totalCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Pager)) {
            return false;
        }
        Pager pager = (Pager) other;
        return this.hasMore == pager.hasMore && this.nextPage == pager.nextPage && this.page == pager.page && this.perPage == pager.perPage && this.totalCount == pager.totalCount;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final int getNextPage() {
        return this.nextPage;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        return (((((((e.a(this.hasMore) * 31) + this.nextPage) * 31) + this.page) * 31) + this.perPage) * 31) + this.totalCount;
    }

    public String toString() {
        return "Pager(hasMore=" + this.hasMore + ", nextPage=" + this.nextPage + ", page=" + this.page + ", perPage=" + this.perPage + ", totalCount=" + this.totalCount + ")";
    }
}
