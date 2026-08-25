package com.transsion.memberapi;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/transsion/memberapi/PointInfo;", "Ljava/io/Serializable;", "point", BuildConfig.FLAVOR, "<init>", "(I)V", "getPoint", "()I", "setPoint", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class PointInfo implements Serializable {
    private int point;

    public PointInfo(int i) {
        this.point = i;
    }

    public static /* synthetic */ PointInfo copy$default(PointInfo pointInfo, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pointInfo.point;
        }
        return pointInfo.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPoint() {
        return this.point;
    }

    public final PointInfo copy(int point) {
        return new PointInfo(point);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PointInfo) && this.point == ((PointInfo) other).point;
    }

    public final int getPoint() {
        return this.point;
    }

    public int hashCode() {
        return this.point;
    }

    public final void setPoint(int i) {
        this.point = i;
    }

    public String toString() {
        return "PointInfo(point=" + this.point + ")";
    }
}
