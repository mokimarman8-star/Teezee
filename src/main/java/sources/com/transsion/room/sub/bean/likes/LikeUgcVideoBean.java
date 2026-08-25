package com.transsion.room.sub.bean.likes;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u0005J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/transsion/room/sub/bean/likes/LikeUgcVideoBean;", "Landroid/os/Parcelable;", "isAffected", BuildConfig.FLAVOR, "likes", BuildConfig.FLAVOR, "<init>", "(ZI)V", "()Z", "getLikes", "()I", "component1", "component2", "copy", "describeContents", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class LikeUgcVideoBean implements Parcelable {
    public static final Parcelable.Creator<LikeUgcVideoBean> CREATOR = new a();
    private final boolean isAffected;
    private final int likes;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LikeUgcVideoBean createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new LikeUgcVideoBean(parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final LikeUgcVideoBean[] newArray(int i) {
            return new LikeUgcVideoBean[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LikeUgcVideoBean() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public LikeUgcVideoBean(boolean z, int i) {
        this.isAffected = z;
        this.likes = i;
    }

    public /* synthetic */ LikeUgcVideoBean(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
    }

    public static /* synthetic */ LikeUgcVideoBean copy$default(LikeUgcVideoBean likeUgcVideoBean, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = likeUgcVideoBean.isAffected;
        }
        if ((i2 & 2) != 0) {
            i = likeUgcVideoBean.likes;
        }
        return likeUgcVideoBean.copy(z, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsAffected() {
        return this.isAffected;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLikes() {
        return this.likes;
    }

    public final LikeUgcVideoBean copy(boolean isAffected, int likes) {
        return new LikeUgcVideoBean(isAffected, likes);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeUgcVideoBean)) {
            return false;
        }
        LikeUgcVideoBean likeUgcVideoBean = (LikeUgcVideoBean) other;
        return this.isAffected == likeUgcVideoBean.isAffected && this.likes == likeUgcVideoBean.likes;
    }

    public final int getLikes() {
        return this.likes;
    }

    public int hashCode() {
        return (e.a(this.isAffected) * 31) + this.likes;
    }

    public final boolean isAffected() {
        return this.isAffected;
    }

    public String toString() {
        return "LikeUgcVideoBean(isAffected=" + this.isAffected + ", likes=" + this.likes + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.isAffected ? 1 : 0);
        dest.writeInt(this.likes);
    }
}
