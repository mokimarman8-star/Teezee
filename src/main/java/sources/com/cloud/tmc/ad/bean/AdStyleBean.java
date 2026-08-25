package com.cloud.tmc.ad.bean;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/cloud/tmc/ad/bean/AdStyleBean;", "Ljava/io/Serializable;", "showTitle", "", "showDescript", "showLogo", "showButton", "(ZZZZ)V", "getShowButton", "()Z", "getShowDescript", "getShowLogo", "getShowTitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.cloud.tmc.miniad"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class AdStyleBean implements Serializable {
    private final boolean showButton;
    private final boolean showDescript;
    private final boolean showLogo;
    private final boolean showTitle;

    public AdStyleBean(boolean z, boolean z2, boolean z3, boolean z4) {
        this.showTitle = z;
        this.showDescript = z2;
        this.showLogo = z3;
        this.showButton = z4;
    }

    public static /* synthetic */ AdStyleBean copy$default(AdStyleBean adStyleBean, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adStyleBean.showTitle;
        }
        if ((i & 2) != 0) {
            z2 = adStyleBean.showDescript;
        }
        if ((i & 4) != 0) {
            z3 = adStyleBean.showLogo;
        }
        if ((i & 8) != 0) {
            z4 = adStyleBean.showButton;
        }
        return adStyleBean.copy(z, z2, z3, z4);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShowTitle() {
        return this.showTitle;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShowDescript() {
        return this.showDescript;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getShowLogo() {
        return this.showLogo;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShowButton() {
        return this.showButton;
    }

    public final AdStyleBean copy(boolean showTitle, boolean showDescript, boolean showLogo, boolean showButton) {
        return new AdStyleBean(showTitle, showDescript, showLogo, showButton);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdStyleBean)) {
            return false;
        }
        AdStyleBean adStyleBean = (AdStyleBean) other;
        return this.showTitle == adStyleBean.showTitle && this.showDescript == adStyleBean.showDescript && this.showLogo == adStyleBean.showLogo && this.showButton == adStyleBean.showButton;
    }

    public final boolean getShowButton() {
        return this.showButton;
    }

    public final boolean getShowDescript() {
        return this.showDescript;
    }

    public final boolean getShowLogo() {
        return this.showLogo;
    }

    public final boolean getShowTitle() {
        return this.showTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        boolean z = this.showTitle;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.showDescript;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.showLogo;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i8 = (i3 + i4) * 31;
        boolean z2 = this.showButton;
        return i8 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "AdStyleBean(showTitle=" + this.showTitle + ", showDescript=" + this.showDescript + ", showLogo=" + this.showLogo + ", showButton=" + this.showButton + ")";
    }
}
