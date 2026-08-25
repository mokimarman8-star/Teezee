package com.transsion.home.bean;

import androidx.annotation.Keep;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/transsion/home/bean/AppointSubject;", "Lcom/transsion/moviedetailapi/bean/Subject;", "appointmentDate", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getAppointmentDate", "()Ljava/lang/String;", "setAppointmentDate", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class AppointSubject extends Subject {
    public static final int $stable = 8;
    private String appointmentDate;

    public AppointSubject(String str) {
        super((String) null, (Integer) null, (String) null, (String) null, (Cover) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (List) null, (Long) null, (Boolean) null, (String) null, (SubjectDl) null, (List) null, (Cover) null, (Trailer) null, false, false, (BiddingNativeManager) null, (String) null, (Long) null, (String) null, (String) null, false, false, (ShortTVItem) null, (ShortTVFavInfo) null, 0, false, false, 0L, (String) null, (List) null, 0L, (List) null, 0, false, (Integer) null, 0, (SubjectGameInfo) null, (String) null, (List) null, (String) null, (String) null, 0, (Long) null, (Integer) null, (LayoutStyle) null, (PlayUrl) null, (Boolean) null, -1, 67108863, (DefaultConstructorMarker) null);
        this.appointmentDate = str;
    }

    public static /* synthetic */ AppointSubject copy$default(AppointSubject appointSubject, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appointSubject.appointmentDate;
        }
        return appointSubject.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppointmentDate() {
        return this.appointmentDate;
    }

    public final AppointSubject copy(String appointmentDate) {
        return new AppointSubject(appointmentDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AppointSubject) && Intrinsics.c(this.appointmentDate, ((AppointSubject) other).appointmentDate);
    }

    public final String getAppointmentDate() {
        return this.appointmentDate;
    }

    public int hashCode() {
        String str = this.appointmentDate;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setAppointmentDate(String str) {
        this.appointmentDate = str;
    }

    public String toString() {
        return "AppointSubject(appointmentDate=" + this.appointmentDate + ")";
    }
}
