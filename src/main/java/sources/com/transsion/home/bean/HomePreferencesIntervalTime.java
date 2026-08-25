package com.transsion.home.bean;

import androidx.annotation.Keep;
import androidx.collection.s;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/transsion/home/bean/HomePreferencesIntervalTime;", BuildConfig.FLAVOR, "showInterval", BuildConfig.FLAVOR, "closeInterval", "chooseInterval", "<init>", "(JJJ)V", "getShowInterval", "()J", "getCloseInterval", "getChooseInterval", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class HomePreferencesIntervalTime {
    public static final int $stable = 0;

    @SerializedName("chooseInterval")
    private final long chooseInterval;

    @SerializedName("closeInterval")
    private final long closeInterval;

    @SerializedName("showInterval")
    private final long showInterval;

    public HomePreferencesIntervalTime(long j, long j2, long j3) {
        this.showInterval = j;
        this.closeInterval = j2;
        this.chooseInterval = j3;
    }

    public static /* synthetic */ HomePreferencesIntervalTime copy$default(HomePreferencesIntervalTime homePreferencesIntervalTime, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = homePreferencesIntervalTime.showInterval;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = homePreferencesIntervalTime.closeInterval;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = homePreferencesIntervalTime.chooseInterval;
        }
        return homePreferencesIntervalTime.copy(j4, j5, j3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getShowInterval() {
        return this.showInterval;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCloseInterval() {
        return this.closeInterval;
    }

    /* renamed from: component3, reason: from getter */
    public final long getChooseInterval() {
        return this.chooseInterval;
    }

    public final HomePreferencesIntervalTime copy(long showInterval, long closeInterval, long chooseInterval) {
        return new HomePreferencesIntervalTime(showInterval, closeInterval, chooseInterval);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomePreferencesIntervalTime)) {
            return false;
        }
        HomePreferencesIntervalTime homePreferencesIntervalTime = (HomePreferencesIntervalTime) other;
        return this.showInterval == homePreferencesIntervalTime.showInterval && this.closeInterval == homePreferencesIntervalTime.closeInterval && this.chooseInterval == homePreferencesIntervalTime.chooseInterval;
    }

    public final long getChooseInterval() {
        return this.chooseInterval;
    }

    public final long getCloseInterval() {
        return this.closeInterval;
    }

    public final long getShowInterval() {
        return this.showInterval;
    }

    public int hashCode() {
        return (((s.a(this.showInterval) * 31) + s.a(this.closeInterval)) * 31) + s.a(this.chooseInterval);
    }

    public String toString() {
        return "HomePreferencesIntervalTime(showInterval=" + this.showInterval + ", closeInterval=" + this.closeInterval + ", chooseInterval=" + this.chooseInterval + ")";
    }
}
