package com.transsion.home.bean.ugc;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006 "}, d2 = {"Lcom/transsion/home/bean/ugc/UGCFilterResponse;", "Landroid/os/Parcelable;", "items", BuildConfig.FLAVOR, "Lcom/transsion/home/bean/ugc/UGCFilterItem;", "grades", "Lcom/transsion/home/bean/ugc/UGCFilterGrade;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getGrades", "setGrades", "component1", "component2", "copy", "describeContents", BuildConfig.FLAVOR, "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class UGCFilterResponse implements Parcelable {

    @SerializedName("grades")
    private List<UGCFilterGrade> grades;

    @SerializedName("items")
    private List<UGCFilterItem> items;
    public static final Parcelable.Creator<UGCFilterResponse> CREATOR = new a();
    public static final int $stable = 8;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UGCFilterResponse createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.h(parcel, "parcel");
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(UGCFilterItem.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList2.add(UGCFilterGrade.CREATOR.createFromParcel(parcel));
                }
            }
            return new UGCFilterResponse(arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final UGCFilterResponse[] newArray(int i) {
            return new UGCFilterResponse[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UGCFilterResponse() {
        this(r0, r0, 3, r0);
        List list = null;
    }

    public UGCFilterResponse(List<UGCFilterItem> list, List<UGCFilterGrade> list2) {
        this.items = list;
        this.grades = list2;
    }

    public /* synthetic */ UGCFilterResponse(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UGCFilterResponse copy$default(UGCFilterResponse uGCFilterResponse, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = uGCFilterResponse.items;
        }
        if ((i & 2) != 0) {
            list2 = uGCFilterResponse.grades;
        }
        return uGCFilterResponse.copy(list, list2);
    }

    public final List<UGCFilterItem> component1() {
        return this.items;
    }

    public final List<UGCFilterGrade> component2() {
        return this.grades;
    }

    public final UGCFilterResponse copy(List<UGCFilterItem> items, List<UGCFilterGrade> grades) {
        return new UGCFilterResponse(items, grades);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UGCFilterResponse)) {
            return false;
        }
        UGCFilterResponse uGCFilterResponse = (UGCFilterResponse) other;
        return Intrinsics.c(this.items, uGCFilterResponse.items) && Intrinsics.c(this.grades, uGCFilterResponse.grades);
    }

    public final List<UGCFilterGrade> getGrades() {
        return this.grades;
    }

    public final List<UGCFilterItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<UGCFilterItem> list = this.items;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<UGCFilterGrade> list2 = this.grades;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setGrades(List<UGCFilterGrade> list) {
        this.grades = list;
    }

    public final void setItems(List<UGCFilterItem> list) {
        this.items = list;
    }

    public String toString() {
        return "UGCFilterResponse(items=" + this.items + ", grades=" + this.grades + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        List<UGCFilterItem> list = this.items;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<UGCFilterItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        List<UGCFilterGrade> list2 = this.grades;
        if (list2 == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(list2.size());
        Iterator<UGCFilterGrade> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(dest, flags);
        }
    }
}
