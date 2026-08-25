package com.transsion.rewardscenterapi;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J5\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/transsion/rewardscenterapi/User;", "Ljava/io/Serializable;", "point", BuildConfig.FLAVOR, "nickname", BuildConfig.FLAVOR, "avatar", "isLogin", BuildConfig.FLAVOR, "<init>", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getPoint", "()I", "setPoint", "(I)V", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "getAvatar", "setAvatar", "()Z", "setLogin", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "RewardsCenterApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class User implements Serializable {
    private String avatar;
    private boolean isLogin;
    private String nickname;
    private int point;

    public User() {
        this(0, null, null, false, 15, null);
    }

    public User(int i, String str, String str2, boolean z) {
        this.point = i;
        this.nickname = str;
        this.avatar = str2;
        this.isLogin = z;
    }

    public /* synthetic */ User(int i, String str, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? false : z);
    }

    public static /* synthetic */ User copy$default(User user, int i, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = user.point;
        }
        if ((i2 & 2) != 0) {
            str = user.nickname;
        }
        if ((i2 & 4) != 0) {
            str2 = user.avatar;
        }
        if ((i2 & 8) != 0) {
            z = user.isLogin;
        }
        return user.copy(i, str, str2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPoint() {
        return this.point;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsLogin() {
        return this.isLogin;
    }

    public final User copy(int point, String nickname, String avatar, boolean isLogin) {
        return new User(point, nickname, avatar, isLogin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return this.point == user.point && Intrinsics.c(this.nickname, user.nickname) && Intrinsics.c(this.avatar, user.avatar) && this.isLogin == user.isLogin;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final int getPoint() {
        return this.point;
    }

    public int hashCode() {
        int i = this.point * 31;
        String str = this.nickname;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatar;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + e.a(this.isLogin);
    }

    public final boolean isLogin() {
        return this.isLogin;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setLogin(boolean z) {
        this.isLogin = z;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setPoint(int i) {
        this.point = i;
    }

    public String toString() {
        return "User(point=" + this.point + ", nickname=" + this.nickname + ", avatar=" + this.avatar + ", isLogin=" + this.isLogin + ")";
    }
}
