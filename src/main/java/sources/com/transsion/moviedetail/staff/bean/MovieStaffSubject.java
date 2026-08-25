package com.transsion.moviedetail.staff.bean;

import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.flow.bean.LayoutStyle;
import com.transsion.flow.bean.PlayUrl;
import com.transsion.flow.bean.SubjectGameInfo;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectDl;
import com.transsion.moviedetailapi.bean.Trailer;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p6.a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/transsion/moviedetail/staff/bean/MovieStaffSubject;", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lp6/a;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "itemType", "<init>", "(I)V", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "component1", "copy", "(I)Lcom/transsion/moviedetail/staff/bean/MovieStaffSubject;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "I", "getItemType", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MovieStaffSubject extends Subject implements a, Serializable {
    private final int itemType;

    public MovieStaffSubject() {
        this(0, 1, null);
    }

    public MovieStaffSubject(int i) {
        super((String) null, (Integer) null, (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -1, 67108863, (DefaultConstructorMarker) null);
        this.itemType = i;
    }

    public /* synthetic */ MovieStaffSubject(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i);
    }

    public static /* synthetic */ MovieStaffSubject copy$default(MovieStaffSubject movieStaffSubject, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = movieStaffSubject.itemType;
        }
        return movieStaffSubject.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    public final MovieStaffSubject copy(int itemType) {
        return new MovieStaffSubject(itemType);
    }

    public boolean equals(Object other) {
        String subjectId;
        return (other instanceof MovieStaffSubject) && Intrinsics.c(((MovieStaffSubject) other).getSubjectId(), getSubjectId()) && (subjectId = getSubjectId()) != null && subjectId.length() != 0;
    }

    public int getItemType() {
        return this.itemType;
    }

    public int hashCode() {
        String subjectId = getSubjectId();
        return subjectId != null ? subjectId.hashCode() : super.hashCode();
    }

    public String toString() {
        return "MovieStaffSubject(itemType=" + this.itemType + ")";
    }
}
