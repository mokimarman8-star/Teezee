package com.transsion.commercialization.aha;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/transsion/commercialization/aha/AhaGameQuery;", "Ljava/io/Serializable;", "pageNum", BuildConfig.FLAVOR, "pageSize", "<init>", "(II)V", "getPageNum", "()I", "setPageNum", "(I)V", "getPageSize", "setPageSize", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "Commercialization_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class AhaGameQuery implements Serializable {

    @SerializedName("pageNum")
    private int pageNum;

    @SerializedName("pageSize")
    private int pageSize;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AhaGameQuery() {
        this(r2, r2, 3, null);
        int i = 0;
    }

    public AhaGameQuery(int i, int i2) {
        this.pageNum = i;
        this.pageSize = i2;
    }

    public /* synthetic */ AhaGameQuery(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 10 : i2);
    }

    public static /* synthetic */ AhaGameQuery copy$default(AhaGameQuery ahaGameQuery, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ahaGameQuery.pageNum;
        }
        if ((i3 & 2) != 0) {
            i2 = ahaGameQuery.pageSize;
        }
        return ahaGameQuery.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final AhaGameQuery copy(int pageNum, int pageSize) {
        return new AhaGameQuery(pageNum, pageSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AhaGameQuery)) {
            return false;
        }
        AhaGameQuery ahaGameQuery = (AhaGameQuery) other;
        return this.pageNum == ahaGameQuery.pageNum && this.pageSize == ahaGameQuery.pageSize;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public int hashCode() {
        return (this.pageNum * 31) + this.pageSize;
    }

    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    public String toString() {
        return "AhaGameQuery(pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ")";
    }
}
