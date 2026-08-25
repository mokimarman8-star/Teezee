package com.transsion.home.bean;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/transsion/home/bean/HomePreferencesContentItem;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "value", "isSelect", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getValue", "()Z", "setSelect", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class HomePreferencesContentItem {
    public static final int $stable = 8;

    @SerializedName("isSelect")
    private boolean isSelect;

    @SerializedName("name")
    private final String name;

    @SerializedName("value")
    private final String value;

    public HomePreferencesContentItem(String str, String str2, boolean z) {
        Intrinsics.h(str, "name");
        Intrinsics.h(str2, "value");
        this.name = str;
        this.value = str2;
        this.isSelect = z;
    }

    public /* synthetic */ HomePreferencesContentItem(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    public static /* synthetic */ HomePreferencesContentItem copy$default(HomePreferencesContentItem homePreferencesContentItem, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = homePreferencesContentItem.name;
        }
        if ((i & 2) != 0) {
            str2 = homePreferencesContentItem.value;
        }
        if ((i & 4) != 0) {
            z = homePreferencesContentItem.isSelect;
        }
        return homePreferencesContentItem.copy(str, str2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final HomePreferencesContentItem copy(String name, String value, boolean isSelect) {
        Intrinsics.h(name, "name");
        Intrinsics.h(value, "value");
        return new HomePreferencesContentItem(name, value, isSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomePreferencesContentItem)) {
            return false;
        }
        HomePreferencesContentItem homePreferencesContentItem = (HomePreferencesContentItem) other;
        return Intrinsics.c(this.name, homePreferencesContentItem.name) && Intrinsics.c(this.value, homePreferencesContentItem.value) && this.isSelect == homePreferencesContentItem.isSelect;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.value.hashCode()) * 31) + e.a(this.isSelect);
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public String toString() {
        return "HomePreferencesContentItem(name=" + this.name + ", value=" + this.value + ", isSelect=" + this.isSelect + ")";
    }
}
