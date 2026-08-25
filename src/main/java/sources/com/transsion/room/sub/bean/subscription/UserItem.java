package com.transsion.room.sub.bean.subscription;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0095\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0006\u00103\u001a\u00020\u0005J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0005HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u0006?"}, d2 = {"Lcom/transsion/room/sub/bean/subscription/UserItem;", "Landroid/os/Parcelable;", "userId", BuildConfig.FLAVOR, "userType", BuildConfig.FLAVOR, "username", "nickname", "avatar", "gender", "birthday", "age", "country", "province", "city", "cc", "phone", "mail", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getUserType", "()I", "getUsername", "getNickname", "getAvatar", "getGender", "getBirthday", "getAge", "getCountry", "getProvince", "getCity", "getCc", "getPhone", "getMail", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "describeContents", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class UserItem implements Parcelable {
    public static final Parcelable.Creator<UserItem> CREATOR = new a();
    private final int age;
    private final String avatar;
    private final String birthday;
    private final String cc;
    private final String city;
    private final String country;
    private final int gender;
    private final String mail;
    private final String nickname;
    private final String phone;
    private final String province;
    private final String userId;
    private final int userType;
    private final String username;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserItem createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new UserItem(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final UserItem[] newArray(int i) {
            return new UserItem[i];
        }
    }

    public UserItem() {
        this(null, 0, null, null, null, 0, null, 0, null, null, null, null, null, null, 16383, null);
    }

    public UserItem(String str, int i, String str2, String str3, String str4, int i2, String str5, int i3, String str6, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.h(str, "userId");
        Intrinsics.h(str2, "username");
        Intrinsics.h(str3, "nickname");
        Intrinsics.h(str4, "avatar");
        Intrinsics.h(str5, "birthday");
        Intrinsics.h(str6, "country");
        Intrinsics.h(str7, "province");
        Intrinsics.h(str8, "city");
        Intrinsics.h(str9, "cc");
        Intrinsics.h(str10, "phone");
        Intrinsics.h(str11, "mail");
        this.userId = str;
        this.userType = i;
        this.username = str2;
        this.nickname = str3;
        this.avatar = str4;
        this.gender = i2;
        this.birthday = str5;
        this.age = i3;
        this.country = str6;
        this.province = str7;
        this.city = str8;
        this.cc = str9;
        this.phone = str10;
        this.mail = str11;
    }

    public /* synthetic */ UserItem(String str, int i, String str2, String str3, String str4, int i2, String str5, int i3, String str6, String str7, String str8, String str9, String str10, String str11, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? BuildConfig.FLAVOR : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? BuildConfig.FLAVOR : str2, (i4 & 8) != 0 ? BuildConfig.FLAVOR : str3, (i4 & 16) != 0 ? BuildConfig.FLAVOR : str4, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) != 0 ? BuildConfig.FLAVOR : str5, (i4 & 128) == 0 ? i3 : 0, (i4 & 256) != 0 ? BuildConfig.FLAVOR : str6, (i4 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? BuildConfig.FLAVOR : str7, (i4 & 1024) != 0 ? BuildConfig.FLAVOR : str8, (i4 & 2048) != 0 ? BuildConfig.FLAVOR : str9, (i4 & 4096) != 0 ? BuildConfig.FLAVOR : str10, (i4 & 8192) == 0 ? str11 : BuildConfig.FLAVOR);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: component12, reason: from getter */
    public final String getCc() {
        return this.cc;
    }

    /* renamed from: component13, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component14, reason: from getter */
    public final String getMail() {
        return this.mail;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component6, reason: from getter */
    public final int getGender() {
        return this.gender;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBirthday() {
        return this.birthday;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAge() {
        return this.age;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    public final UserItem copy(String userId, int userType, String username, String nickname, String avatar, int gender, String birthday, int age, String country, String province, String city, String cc, String phone, String mail) {
        Intrinsics.h(userId, "userId");
        Intrinsics.h(username, "username");
        Intrinsics.h(nickname, "nickname");
        Intrinsics.h(avatar, "avatar");
        Intrinsics.h(birthday, "birthday");
        Intrinsics.h(country, "country");
        Intrinsics.h(province, "province");
        Intrinsics.h(city, "city");
        Intrinsics.h(cc, "cc");
        Intrinsics.h(phone, "phone");
        Intrinsics.h(mail, "mail");
        return new UserItem(userId, userType, username, nickname, avatar, gender, birthday, age, country, province, city, cc, phone, mail);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserItem)) {
            return false;
        }
        UserItem userItem = (UserItem) other;
        return Intrinsics.c(this.userId, userItem.userId) && this.userType == userItem.userType && Intrinsics.c(this.username, userItem.username) && Intrinsics.c(this.nickname, userItem.nickname) && Intrinsics.c(this.avatar, userItem.avatar) && this.gender == userItem.gender && Intrinsics.c(this.birthday, userItem.birthday) && this.age == userItem.age && Intrinsics.c(this.country, userItem.country) && Intrinsics.c(this.province, userItem.province) && Intrinsics.c(this.city, userItem.city) && Intrinsics.c(this.cc, userItem.cc) && Intrinsics.c(this.phone, userItem.phone) && Intrinsics.c(this.mail, userItem.mail);
    }

    public final int getAge() {
        return this.age;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getCc() {
        return this.cc;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final int getGender() {
        return this.gender;
    }

    public final String getMail() {
        return this.mail;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.userId.hashCode() * 31) + this.userType) * 31) + this.username.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.gender) * 31) + this.birthday.hashCode()) * 31) + this.age) * 31) + this.country.hashCode()) * 31) + this.province.hashCode()) * 31) + this.city.hashCode()) * 31) + this.cc.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.mail.hashCode();
    }

    public String toString() {
        return "UserItem(userId=" + this.userId + ", userType=" + this.userType + ", username=" + this.username + ", nickname=" + this.nickname + ", avatar=" + this.avatar + ", gender=" + this.gender + ", birthday=" + this.birthday + ", age=" + this.age + ", country=" + this.country + ", province=" + this.province + ", city=" + this.city + ", cc=" + this.cc + ", phone=" + this.phone + ", mail=" + this.mail + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.userId);
        dest.writeInt(this.userType);
        dest.writeString(this.username);
        dest.writeString(this.nickname);
        dest.writeString(this.avatar);
        dest.writeInt(this.gender);
        dest.writeString(this.birthday);
        dest.writeInt(this.age);
        dest.writeString(this.country);
        dest.writeString(this.province);
        dest.writeString(this.city);
        dest.writeString(this.cc);
        dest.writeString(this.phone);
        dest.writeString(this.mail);
    }
}
