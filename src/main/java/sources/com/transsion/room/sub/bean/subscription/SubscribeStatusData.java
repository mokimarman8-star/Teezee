package com.transsion.room.sub.bean.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\fHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/transsion/room/sub/bean/subscription/SubscribeStatusData;", "Landroid/os/Parcelable;", "isSubscribed", BuildConfig.FLAVOR, "isMutual", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "describeContents", BuildConfig.FLAVOR, "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class SubscribeStatusData implements Parcelable {
    public static final Parcelable.Creator<SubscribeStatusData> CREATOR = new a();
    private final boolean isMutual;
    private final boolean isSubscribed;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SubscribeStatusData createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new SubscribeStatusData(parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SubscribeStatusData[] newArray(int i) {
            return new SubscribeStatusData[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SubscribeStatusData() {
        this(r2, r2, 3, null);
        boolean z = false;
    }

    public SubscribeStatusData(boolean z, boolean z2) {
        this.isSubscribed = z;
        this.isMutual = z2;
    }

    public /* synthetic */ SubscribeStatusData(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public static /* synthetic */ SubscribeStatusData copy$default(SubscribeStatusData subscribeStatusData, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = subscribeStatusData.isSubscribed;
        }
        if ((i & 2) != 0) {
            z2 = subscribeStatusData.isMutual;
        }
        return subscribeStatusData.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSubscribed() {
        return this.isSubscribed;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMutual() {
        return this.isMutual;
    }

    public final SubscribeStatusData copy(boolean isSubscribed, boolean isMutual) {
        return new SubscribeStatusData(isSubscribed, isMutual);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscribeStatusData)) {
            return false;
        }
        SubscribeStatusData subscribeStatusData = (SubscribeStatusData) other;
        return this.isSubscribed == subscribeStatusData.isSubscribed && this.isMutual == subscribeStatusData.isMutual;
    }

    public int hashCode() {
        return (e.a(this.isSubscribed) * 31) + e.a(this.isMutual);
    }

    public final boolean isMutual() {
        return this.isMutual;
    }

    public final boolean isSubscribed() {
        return this.isSubscribed;
    }

    public String toString() {
        return "SubscribeStatusData(isSubscribed=" + this.isSubscribed + ", isMutual=" + this.isMutual + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.isSubscribed ? 1 : 0);
        dest.writeInt(this.isMutual ? 1 : 0);
    }
}
