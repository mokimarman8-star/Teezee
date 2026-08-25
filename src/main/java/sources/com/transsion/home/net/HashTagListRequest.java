package com.transsion.home.net;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006#"}, d2 = {"Lcom/transsion/home/net/HashTagListRequest;", BuildConfig.FLAVOR, "page", BuildConfig.FLAVOR, "perPage", "ugcVideoHasTags", BuildConfig.FLAVOR, "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoHashTag;", "ugcVideoId", BuildConfig.FLAVOR, "tabId", "sort", "<init>", "(IILjava/util/List;Ljava/lang/String;ILjava/lang/String;)V", "getPage", "()I", "getPerPage", "getUgcVideoHasTags", "()Ljava/util/List;", "getUgcVideoId", "()Ljava/lang/String;", "getTabId", "getSort", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class HashTagListRequest {
    public static final int $stable = 8;

    @SerializedName("page")
    private final int page;

    @SerializedName("perPage")
    private final int perPage;

    @SerializedName("sort")
    private final String sort;

    @SerializedName("tabId")
    private final int tabId;

    @SerializedName("hashTags")
    private final List<UGCVideoHashTag> ugcVideoHasTags;

    @SerializedName("ugcVideoId")
    private final String ugcVideoId;

    public HashTagListRequest(int i, int i2, List<UGCVideoHashTag> list, String str, int i3, String str2) {
        Intrinsics.h(str2, "sort");
        this.page = i;
        this.perPage = i2;
        this.ugcVideoHasTags = list;
        this.ugcVideoId = str;
        this.tabId = i3;
        this.sort = str2;
    }

    public /* synthetic */ HashTagListRequest(int i, int i2, List list, String str, int i3, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? null : list, (i4 & 8) != 0 ? null : str, (i4 & 16) != 0 ? 0 : i3, str2);
    }

    public static /* synthetic */ HashTagListRequest copy$default(HashTagListRequest hashTagListRequest, int i, int i2, List list, String str, int i3, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = hashTagListRequest.page;
        }
        if ((i4 & 2) != 0) {
            i2 = hashTagListRequest.perPage;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            list = hashTagListRequest.ugcVideoHasTags;
        }
        List list2 = list;
        if ((i4 & 8) != 0) {
            str = hashTagListRequest.ugcVideoId;
        }
        String str3 = str;
        if ((i4 & 16) != 0) {
            i3 = hashTagListRequest.tabId;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            str2 = hashTagListRequest.sort;
        }
        return hashTagListRequest.copy(i, i5, list2, str3, i6, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPerPage() {
        return this.perPage;
    }

    public final List<UGCVideoHashTag> component3() {
        return this.ugcVideoHasTags;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUgcVideoId() {
        return this.ugcVideoId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTabId() {
        return this.tabId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSort() {
        return this.sort;
    }

    public final HashTagListRequest copy(int page, int perPage, List<UGCVideoHashTag> ugcVideoHasTags, String ugcVideoId, int tabId, String sort) {
        Intrinsics.h(sort, "sort");
        return new HashTagListRequest(page, perPage, ugcVideoHasTags, ugcVideoId, tabId, sort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HashTagListRequest)) {
            return false;
        }
        HashTagListRequest hashTagListRequest = (HashTagListRequest) other;
        return this.page == hashTagListRequest.page && this.perPage == hashTagListRequest.perPage && Intrinsics.c(this.ugcVideoHasTags, hashTagListRequest.ugcVideoHasTags) && Intrinsics.c(this.ugcVideoId, hashTagListRequest.ugcVideoId) && this.tabId == hashTagListRequest.tabId && Intrinsics.c(this.sort, hashTagListRequest.sort);
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final String getSort() {
        return this.sort;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final List<UGCVideoHashTag> getUgcVideoHasTags() {
        return this.ugcVideoHasTags;
    }

    public final String getUgcVideoId() {
        return this.ugcVideoId;
    }

    public int hashCode() {
        int i = ((this.page * 31) + this.perPage) * 31;
        List<UGCVideoHashTag> list = this.ugcVideoHasTags;
        int hashCode = (i + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.ugcVideoId;
        return ((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.tabId) * 31) + this.sort.hashCode();
    }

    public String toString() {
        return "HashTagListRequest(page=" + this.page + ", perPage=" + this.perPage + ", ugcVideoHasTags=" + this.ugcVideoHasTags + ", ugcVideoId=" + this.ugcVideoId + ", tabId=" + this.tabId + ", sort=" + this.sort + ")";
    }
}
