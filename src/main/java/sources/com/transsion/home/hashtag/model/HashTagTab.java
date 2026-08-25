package com.transsion.home.hashtag.model;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/transsion/home/hashtag/model/HashTagTab;", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "name", "selected", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getName", "getSelected", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class HashTagTab {
    public static final int $stable = 0;
    private final String id;
    private final String name;
    private final boolean selected;

    public HashTagTab(String str, String str2, boolean z) {
        Intrinsics.h(str, "id");
        Intrinsics.h(str2, "name");
        this.id = str;
        this.name = str2;
        this.selected = z;
    }

    public /* synthetic */ HashTagTab(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    public static /* synthetic */ HashTagTab copy$default(HashTagTab hashTagTab, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hashTagTab.id;
        }
        if ((i & 2) != 0) {
            str2 = hashTagTab.name;
        }
        if ((i & 4) != 0) {
            z = hashTagTab.selected;
        }
        return hashTagTab.copy(str, str2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final HashTagTab copy(String id, String name, boolean selected) {
        Intrinsics.h(id, "id");
        Intrinsics.h(name, "name");
        return new HashTagTab(id, name, selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HashTagTab)) {
            return false;
        }
        HashTagTab hashTagTab = (HashTagTab) other;
        return Intrinsics.c(this.id, hashTagTab.id) && Intrinsics.c(this.name, hashTagTab.name) && this.selected == hashTagTab.selected;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + e.a(this.selected);
    }

    public String toString() {
        return "HashTagTab(id=" + this.id + ", name=" + this.name + ", selected=" + this.selected + ")";
    }
}
