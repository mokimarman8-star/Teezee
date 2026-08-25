package com.transsion.push.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/transsion/push/bean/PushSimbaConfig;", "Landroid/os/Parcelable;", "requestHashEnable", BuildConfig.FLAVOR, "<init>", "(Z)V", "getRequestHashEnable", "()Z", "component1", "copy", "describeContents", BuildConfig.FLAVOR, "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class PushSimbaConfig implements Parcelable {
    public static final Parcelable.Creator<PushSimbaConfig> CREATOR = new Creator();
    private final boolean requestHashEnable;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PushSimbaConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PushSimbaConfig createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new PushSimbaConfig(parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PushSimbaConfig[] newArray(int i) {
            return new PushSimbaConfig[i];
        }
    }

    public PushSimbaConfig() {
        this(false, 1, null);
    }

    public PushSimbaConfig(boolean z) {
        this.requestHashEnable = z;
    }

    public /* synthetic */ PushSimbaConfig(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public static /* synthetic */ PushSimbaConfig copy$default(PushSimbaConfig pushSimbaConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pushSimbaConfig.requestHashEnable;
        }
        return pushSimbaConfig.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getRequestHashEnable() {
        return this.requestHashEnable;
    }

    public final PushSimbaConfig copy(boolean requestHashEnable) {
        return new PushSimbaConfig(requestHashEnable);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PushSimbaConfig) && this.requestHashEnable == ((PushSimbaConfig) other).requestHashEnable;
    }

    public final boolean getRequestHashEnable() {
        return this.requestHashEnable;
    }

    public int hashCode() {
        return e.a(this.requestHashEnable);
    }

    public String toString() {
        return "PushSimbaConfig(requestHashEnable=" + this.requestHashEnable + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.requestHashEnable ? 1 : 0);
    }
}
