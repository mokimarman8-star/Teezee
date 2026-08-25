package com.transsion.baselib.db.place;

import androidx.annotation.Keep;
import androidx.compose.animation.core.r;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006%"}, d2 = {"Lcom/transsion/baselib/db/place/PlaceDBBean;", BuildConfig.FLAVOR, "latitude", BuildConfig.FLAVOR, "longitude", "name", BuildConfig.FLAVOR, "address", "distance", "<init>", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLatitude", "()D", "setLatitude", "(D)V", "getLongitude", "setLongitude", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getAddress", "setAddress", "getDistance", "setDistance", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class PlaceDBBean {
    private String address;
    private String distance;
    private double latitude;
    private double longitude;
    private String name;

    public PlaceDBBean() {
        this(0.0d, 0.0d, null, null, null, 31, null);
    }

    public PlaceDBBean(double d, double d2, String str, String str2, String str3) {
        this.latitude = d;
        this.longitude = d2;
        this.name = str;
        this.address = str2;
        this.distance = str3;
    }

    public /* synthetic */ PlaceDBBean(double d, double d2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1.0d : d, (i & 2) == 0 ? d2 : -1.0d, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }

    /* renamed from: component1, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component2, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDistance() {
        return this.distance;
    }

    public final PlaceDBBean copy(double latitude, double longitude, String name, String address, String distance) {
        return new PlaceDBBean(latitude, longitude, name, address, distance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaceDBBean)) {
            return false;
        }
        PlaceDBBean placeDBBean = (PlaceDBBean) other;
        return Double.compare(this.latitude, placeDBBean.latitude) == 0 && Double.compare(this.longitude, placeDBBean.longitude) == 0 && Intrinsics.c(this.name, placeDBBean.name) && Intrinsics.c(this.address, placeDBBean.address) && Intrinsics.c(this.distance, placeDBBean.distance);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int a = ((r.a(this.latitude) * 31) + r.a(this.longitude)) * 31;
        String str = this.name;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.address;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.distance;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setDistance(String str) {
        this.distance = str;
    }

    public final void setLatitude(double d) {
        this.latitude = d;
    }

    public final void setLongitude(double d) {
        this.longitude = d;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "PlaceDBBean(latitude=" + this.latitude + ", longitude=" + this.longitude + ", name=" + this.name + ", address=" + this.address + ", distance=" + this.distance + ")";
    }
}
