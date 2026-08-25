package com.transsion.member.bean;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J5\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/transsion/member/bean/Pager;", "Ljava/io/Serializable;", "hasMore", BuildConfig.FLAVOR, "nextPage", BuildConfig.FLAVOR, "page", "perPage", BuildConfig.FLAVOR, "<init>", "(ZLjava/lang/String;Ljava/lang/String;I)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "getNextPage", "()Ljava/lang/String;", "setNextPage", "(Ljava/lang/String;)V", "getPage", "setPage", "getPerPage", "()I", "setPerPage", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class Pager implements Serializable {
    public static final int $stable = 8;

    @SerializedName("hasMore")
    private boolean hasMore;

    @SerializedName("nextPage")
    private String nextPage;

    @SerializedName("page")
    private String page;

    @SerializedName("perPage")
    private int perPage;

    public Pager(boolean z, String str, String str2, int i) {
        this.hasMore = z;
        this.nextPage = str;
        this.page = str2;
        this.perPage = i;
    }

    public /* synthetic */ Pager(boolean z, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i2 & 4) != 0 ? null : str2, i);
    }

    public static /* synthetic */ Pager copy$default(Pager pager, boolean z, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = pager.hasMore;
        }
        if ((i2 & 2) != 0) {
            str = pager.nextPage;
        }
        if ((i2 & 4) != 0) {
            str2 = pager.page;
        }
        if ((i2 & 8) != 0) {
            i = pager.perPage;
        }
        return pager.copy(z, str, str2, i);
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

    public final Pager copy(boolean hasMore, String nextPage, String page, int perPage) {
        return new Pager(hasMore, nextPage, page, perPage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Pager)) {
            return false;
        }
        Pager pager = (Pager) other;
        return this.hasMore == pager.hasMore && Intrinsics.c(this.nextPage, pager.nextPage) && Intrinsics.c(this.page, pager.page) && this.perPage == pager.perPage;
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

    public int hashCode() {
        int a = e.a(this.hasMore) * 31;
        String str = this.nextPage;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.page;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.perPage;
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

    public String toString() {
        return "Pager(hasMore=" + this.hasMore + ", nextPage=" + this.nextPage + ", page=" + this.page + ", perPage=" + this.perPage + ")";
    }
}
