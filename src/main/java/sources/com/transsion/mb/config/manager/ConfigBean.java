package com.transsion.mb.config.manager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!¨\u0006&"}, d2 = {"Lcom/transsion/mb/config/manager/ConfigBean;", "Landroid/os/Parcelable;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "ops", "getOps", "setOps", "value", "getValue", "setValue", "", "hasUpdate", "Z", "getHasUpdate", "()Z", "setHasUpdate", "(Z)V", "isFirebase", "setFirebase", "CREATOR", "a", "config_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ConfigBean implements Parcelable {
    public static final a CREATOR = new a((DefaultConstructorMarker) null);
    private boolean hasUpdate;
    private boolean isFirebase;
    private String key;
    private String ops;
    private String value;

    public ConfigBean() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConfigBean(Parcel parcel) {
        this();
        Intrinsics.h(parcel, "parcel");
        this.key = parcel.readString();
        this.ops = parcel.readString();
        this.value = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getValue() {
        return this.value;
    }

    /* renamed from: isFirebase, reason: from getter */
    public final boolean getIsFirebase() {
        return this.isFirebase;
    }

    public final void setFirebase(boolean z) {
        this.isFirebase = z;
    }

    public final void setHasUpdate(boolean z) {
        this.hasUpdate = z;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.h(parcel, "parcel");
        parcel.writeString(this.key);
        parcel.writeString(this.ops);
        parcel.writeString(this.value);
    }
}
