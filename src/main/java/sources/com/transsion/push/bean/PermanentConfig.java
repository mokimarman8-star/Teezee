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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J)\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0007J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/transsion/push/bean/PermanentConfig;", "Landroid/os/Parcelable;", "enable", BuildConfig.FLAVOR, "startTime", BuildConfig.FLAVOR, "interval", BuildConfig.FLAVOR, "<init>", "(ZLjava/lang/String;I)V", "getEnable", "()Z", "setEnable", "(Z)V", "getStartTime", "()Ljava/lang/String;", "setStartTime", "(Ljava/lang/String;)V", "getInterval", "()I", "setInterval", "(I)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class PermanentConfig implements Parcelable {
    public static final Parcelable.Creator<PermanentConfig> CREATOR = new Creator();
    private boolean enable;
    private int interval;
    private String startTime;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PermanentConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentConfig createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new PermanentConfig(parcel.readInt() != 0, parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentConfig[] newArray(int i) {
            return new PermanentConfig[i];
        }
    }

    public PermanentConfig(boolean z, String str, int i) {
        this.enable = z;
        this.startTime = str;
        this.interval = i;
    }

    public /* synthetic */ PermanentConfig(boolean z, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, str, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ PermanentConfig copy$default(PermanentConfig permanentConfig, boolean z, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = permanentConfig.enable;
        }
        if ((i2 & 2) != 0) {
            str = permanentConfig.startTime;
        }
        if ((i2 & 4) != 0) {
            i = permanentConfig.interval;
        }
        return permanentConfig.copy(z, str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    public final PermanentConfig copy(boolean enable, String startTime, int interval) {
        return new PermanentConfig(enable, startTime, interval);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermanentConfig)) {
            return false;
        }
        PermanentConfig permanentConfig = (PermanentConfig) other;
        return this.enable == permanentConfig.enable && Intrinsics.c(this.startTime, permanentConfig.startTime) && this.interval == permanentConfig.interval;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        int a = e.a(this.enable) * 31;
        String str = this.startTime;
        return ((a + (str == null ? 0 : str.hashCode())) * 31) + this.interval;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public final void setInterval(int i) {
        this.interval = i;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public String toString() {
        return "PermanentConfig(enable=" + this.enable + ", startTime=" + this.startTime + ", interval=" + this.interval + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.enable ? 1 : 0);
        dest.writeString(this.startTime);
        dest.writeInt(this.interval);
    }
}
