package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jk\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0007HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u00067"}, d2 = {"Lcom/transsion/usercenter/profile/bean/IconItemInfo;", "Ljava/io/Serializable;", "title", HttpUrl.FRAGMENT_ENCODE_SET, "des", "deepLink", "iconRes", HttpUrl.FRAGMENT_ENCODE_SET, "bgRes", "divider", HttpUrl.FRAGMENT_ENCODE_SET, "top", "checkLogin", "moduleName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZIZLjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getDes", "setDes", "getDeepLink", "setDeepLink", "getIconRes", "()I", "setIconRes", "(I)V", "getBgRes", "setBgRes", "getDivider", "()Z", "setDivider", "(Z)V", "getTop", "setTop", "getCheckLogin", "setCheckLogin", "getModuleName", "setModuleName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "toString", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class IconItemInfo implements Serializable {
    private int bgRes;
    private boolean checkLogin;
    private String deepLink;
    private String des;
    private boolean divider;
    private int iconRes;
    private String moduleName;
    private String title;
    private int top;

    public IconItemInfo(String str, String str2, String str3, int i, int i2, boolean z, int i3, boolean z2, String str4) {
        this.title = str;
        this.des = str2;
        this.deepLink = str3;
        this.iconRes = i;
        this.bgRes = i2;
        this.divider = z;
        this.top = i3;
        this.checkLogin = z2;
        this.moduleName = str4;
    }

    public /* synthetic */ IconItemInfo(String str, String str2, String str3, int i, int i2, boolean z, int i3, boolean z2, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? 0 : i3, (i4 & 128) != 0 ? false : z2, (i4 & 256) != 0 ? null : str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDes() {
        return this.des;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeepLink() {
        return this.deepLink;
    }

    /* renamed from: component4, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* renamed from: component5, reason: from getter */
    public final int getBgRes() {
        return this.bgRes;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getDivider() {
        return this.divider;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCheckLogin() {
        return this.checkLogin;
    }

    /* renamed from: component9, reason: from getter */
    public final String getModuleName() {
        return this.moduleName;
    }

    public final IconItemInfo copy(String title, String des, String deepLink, int iconRes, int bgRes, boolean divider, int top, boolean checkLogin, String moduleName) {
        return new IconItemInfo(title, des, deepLink, iconRes, bgRes, divider, top, checkLogin, moduleName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IconItemInfo)) {
            return false;
        }
        IconItemInfo iconItemInfo = (IconItemInfo) other;
        return Intrinsics.c(this.title, iconItemInfo.title) && Intrinsics.c(this.des, iconItemInfo.des) && Intrinsics.c(this.deepLink, iconItemInfo.deepLink) && this.iconRes == iconItemInfo.iconRes && this.bgRes == iconItemInfo.bgRes && this.divider == iconItemInfo.divider && this.top == iconItemInfo.top && this.checkLogin == iconItemInfo.checkLogin && Intrinsics.c(this.moduleName, iconItemInfo.moduleName);
    }

    public final int getBgRes() {
        return this.bgRes;
    }

    public final boolean getCheckLogin() {
        return this.checkLogin;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final String getDes() {
        return this.des;
    }

    public final boolean getDivider() {
        return this.divider;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTop() {
        return this.top;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.des;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deepLink;
        int hashCode3 = (((((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.iconRes) * 31) + this.bgRes) * 31) + e.a(this.divider)) * 31) + this.top) * 31) + e.a(this.checkLogin)) * 31;
        String str4 = this.moduleName;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setBgRes(int i) {
        this.bgRes = i;
    }

    public final void setCheckLogin(boolean z) {
        this.checkLogin = z;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final void setDes(String str) {
        this.des = str;
    }

    public final void setDivider(boolean z) {
        this.divider = z;
    }

    public final void setIconRes(int i) {
        this.iconRes = i;
    }

    public final void setModuleName(String str) {
        this.moduleName = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTop(int i) {
        this.top = i;
    }

    public String toString() {
        return "IconItemInfo(title=" + this.title + ", des=" + this.des + ", deepLink=" + this.deepLink + ", iconRes=" + this.iconRes + ", bgRes=" + this.bgRes + ", divider=" + this.divider + ", top=" + this.top + ", checkLogin=" + this.checkLogin + ", moduleName=" + this.moduleName + ")";
    }
}
