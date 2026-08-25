package com.transsion.search_pugc.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/transsion/search_pugc/bean/SearchTab;", "Landroid/os/Parcelable;", "tabId", BuildConfig.FLAVOR, "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTabId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", BuildConfig.FLAVOR, "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class SearchTab implements Parcelable {
    public static final Parcelable.Creator<SearchTab> CREATOR = new a();

    @SerializedName("name")
    private final String name;

    @SerializedName("tabId")
    private final String tabId;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SearchTab createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new SearchTab(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SearchTab[] newArray(int i) {
            return new SearchTab[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchTab() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    public SearchTab(String str, String str2) {
        Intrinsics.h(str, "tabId");
        Intrinsics.h(str2, "name");
        this.tabId = str;
        this.name = str2;
    }

    public /* synthetic */ SearchTab(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BuildConfig.FLAVOR : str, (i & 2) != 0 ? BuildConfig.FLAVOR : str2);
    }

    public static /* synthetic */ SearchTab copy$default(SearchTab searchTab, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchTab.tabId;
        }
        if ((i & 2) != 0) {
            str2 = searchTab.name;
        }
        return searchTab.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTabId() {
        return this.tabId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final SearchTab copy(String tabId, String name) {
        Intrinsics.h(tabId, "tabId");
        Intrinsics.h(name, "name");
        return new SearchTab(tabId, name);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchTab)) {
            return false;
        }
        SearchTab searchTab = (SearchTab) other;
        return Intrinsics.c(this.tabId, searchTab.tabId) && Intrinsics.c(this.name, searchTab.name);
    }

    public final String getName() {
        return this.name;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public int hashCode() {
        return (this.tabId.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "SearchTab(tabId=" + this.tabId + ", name=" + this.name + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.tabId);
        dest.writeString(this.name);
    }
}
