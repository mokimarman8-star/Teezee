package com.transsion.search.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Staff;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jt\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\fHÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/transsion/search/bean/SearchWorkEntity;", "Ljava/io/Serializable;", "items", BuildConfig.FLAVOR, "Lcom/transsion/search/bean/SearchSubject;", "pager", "Lcom/transsion/search/bean/Pager;", "verticalRanks", "Lcom/transsion/search/bean/VerticalRank;", "counts", "Lcom/transsion/search/bean/Count;", "subjectType", BuildConfig.FLAVOR, "staffs", "Lcom/transsion/moviedetailapi/bean/Staff;", "accurateSubject", "Lcom/transsion/search/bean/AccurateSubject;", "<init>", "(Ljava/util/List;Lcom/transsion/search/bean/Pager;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/transsion/search/bean/AccurateSubject;)V", "getItems", "()Ljava/util/List;", "getPager", "()Lcom/transsion/search/bean/Pager;", "getVerticalRanks", "getCounts", "getSubjectType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStaffs", "getAccurateSubject", "()Lcom/transsion/search/bean/AccurateSubject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Lcom/transsion/search/bean/Pager;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/transsion/search/bean/AccurateSubject;)Lcom/transsion/search/bean/SearchWorkEntity;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class SearchWorkEntity implements Serializable {

    @SerializedName("accurate")
    private final AccurateSubject accurateSubject;

    @SerializedName("counts")
    private final List<Count> counts;

    @SerializedName("items")
    private final List<SearchSubject> items;

    @SerializedName("pager")
    private final Pager pager;

    @SerializedName("staffs")
    private final List<Staff> staffs;

    @SerializedName("subjectType")
    private final Integer subjectType;

    @SerializedName("verticalRanks")
    private final List<VerticalRank> verticalRanks;

    public SearchWorkEntity(List<SearchSubject> list, Pager pager, List<VerticalRank> list2, List<Count> list3, Integer num, List<? extends Staff> list4, AccurateSubject accurateSubject) {
        Intrinsics.h(list, "items");
        Intrinsics.h(pager, "pager");
        Intrinsics.h(list3, "counts");
        this.items = list;
        this.pager = pager;
        this.verticalRanks = list2;
        this.counts = list3;
        this.subjectType = num;
        this.staffs = list4;
        this.accurateSubject = accurateSubject;
    }

    public static /* synthetic */ SearchWorkEntity copy$default(SearchWorkEntity searchWorkEntity, List list, Pager pager, List list2, List list3, Integer num, List list4, AccurateSubject accurateSubject, int i, Object obj) {
        if ((i & 1) != 0) {
            list = searchWorkEntity.items;
        }
        if ((i & 2) != 0) {
            pager = searchWorkEntity.pager;
        }
        Pager pager2 = pager;
        if ((i & 4) != 0) {
            list2 = searchWorkEntity.verticalRanks;
        }
        List list5 = list2;
        if ((i & 8) != 0) {
            list3 = searchWorkEntity.counts;
        }
        List list6 = list3;
        if ((i & 16) != 0) {
            num = searchWorkEntity.subjectType;
        }
        Integer num2 = num;
        if ((i & 32) != 0) {
            list4 = searchWorkEntity.staffs;
        }
        List list7 = list4;
        if ((i & 64) != 0) {
            accurateSubject = searchWorkEntity.accurateSubject;
        }
        return searchWorkEntity.copy(list, pager2, list5, list6, num2, list7, accurateSubject);
    }

    public final List<SearchSubject> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final Pager getPager() {
        return this.pager;
    }

    public final List<VerticalRank> component3() {
        return this.verticalRanks;
    }

    public final List<Count> component4() {
        return this.counts;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final List<Staff> component6() {
        return this.staffs;
    }

    /* renamed from: component7, reason: from getter */
    public final AccurateSubject getAccurateSubject() {
        return this.accurateSubject;
    }

    public final SearchWorkEntity copy(List<SearchSubject> items, Pager pager, List<VerticalRank> verticalRanks, List<Count> counts, Integer subjectType, List<? extends Staff> staffs, AccurateSubject accurateSubject) {
        Intrinsics.h(items, "items");
        Intrinsics.h(pager, "pager");
        Intrinsics.h(counts, "counts");
        return new SearchWorkEntity(items, pager, verticalRanks, counts, subjectType, staffs, accurateSubject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchWorkEntity)) {
            return false;
        }
        SearchWorkEntity searchWorkEntity = (SearchWorkEntity) other;
        return Intrinsics.c(this.items, searchWorkEntity.items) && Intrinsics.c(this.pager, searchWorkEntity.pager) && Intrinsics.c(this.verticalRanks, searchWorkEntity.verticalRanks) && Intrinsics.c(this.counts, searchWorkEntity.counts) && Intrinsics.c(this.subjectType, searchWorkEntity.subjectType) && Intrinsics.c(this.staffs, searchWorkEntity.staffs) && Intrinsics.c(this.accurateSubject, searchWorkEntity.accurateSubject);
    }

    public final AccurateSubject getAccurateSubject() {
        return this.accurateSubject;
    }

    public final List<Count> getCounts() {
        return this.counts;
    }

    public final List<SearchSubject> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public final List<Staff> getStaffs() {
        return this.staffs;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final List<VerticalRank> getVerticalRanks() {
        return this.verticalRanks;
    }

    public int hashCode() {
        int hashCode = ((this.items.hashCode() * 31) + this.pager.hashCode()) * 31;
        List<VerticalRank> list = this.verticalRanks;
        int hashCode2 = (((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.counts.hashCode()) * 31;
        Integer num = this.subjectType;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<Staff> list2 = this.staffs;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        AccurateSubject accurateSubject = this.accurateSubject;
        return hashCode4 + (accurateSubject != null ? accurateSubject.hashCode() : 0);
    }

    public String toString() {
        return "SearchWorkEntity(items=" + this.items + ", pager=" + this.pager + ", verticalRanks=" + this.verticalRanks + ", counts=" + this.counts + ", subjectType=" + this.subjectType + ", staffs=" + this.staffs + ", accurateSubject=" + this.accurateSubject + ")";
    }
}
