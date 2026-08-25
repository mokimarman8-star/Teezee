package com.transsion.push.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u001f\u001a\u00020\u0003J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006+"}, d2 = {"Lcom/transsion/push/bean/PermanentItemBean;", "Landroid/os/Parcelable;", "id", BuildConfig.FLAVOR, "deeplink", BuildConfig.FLAVOR, "subjectId", "image", "title", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getDeeplink", "()Ljava/lang/String;", "setDeeplink", "(Ljava/lang/String;)V", "getSubjectId", "setSubjectId", "getImage", "setImage", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class PermanentItemBean implements Parcelable {
    public static final Parcelable.Creator<PermanentItemBean> CREATOR = new Creator();
    private String deeplink;
    private int id;
    private String image;
    private String subjectId;
    private String title;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PermanentItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentItemBean createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new PermanentItemBean(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermanentItemBean[] newArray(int i) {
            return new PermanentItemBean[i];
        }
    }

    public PermanentItemBean(int i, String str, String str2, String str3, String str4) {
        this.id = i;
        this.deeplink = str;
        this.subjectId = str2;
        this.image = str3;
        this.title = str4;
    }

    public /* synthetic */ PermanentItemBean(int i, String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str, str2, str3, str4);
    }

    public static /* synthetic */ PermanentItemBean copy$default(PermanentItemBean permanentItemBean, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = permanentItemBean.id;
        }
        if ((i2 & 2) != 0) {
            str = permanentItemBean.deeplink;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = permanentItemBean.subjectId;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = permanentItemBean.image;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = permanentItemBean.title;
        }
        return permanentItemBean.copy(i, str5, str6, str7, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeeplink() {
        return this.deeplink;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final PermanentItemBean copy(int id, String deeplink, String subjectId, String image, String title) {
        return new PermanentItemBean(id, deeplink, subjectId, image, title);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermanentItemBean)) {
            return false;
        }
        PermanentItemBean permanentItemBean = (PermanentItemBean) other;
        return this.id == permanentItemBean.id && Intrinsics.c(this.deeplink, permanentItemBean.deeplink) && Intrinsics.c(this.subjectId, permanentItemBean.subjectId) && Intrinsics.c(this.image, permanentItemBean.image) && Intrinsics.c(this.title, permanentItemBean.title);
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.deeplink;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subjectId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.image;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "PermanentItemBean(id=" + this.id + ", deeplink=" + this.deeplink + ", subjectId=" + this.subjectId + ", image=" + this.image + ", title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.id);
        dest.writeString(this.deeplink);
        dest.writeString(this.subjectId);
        dest.writeString(this.image);
        dest.writeString(this.title);
    }
}
