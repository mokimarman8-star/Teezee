package com.cloud.tmc.ad.bean;

import com.cloud.tmc.kernel.model.BaseBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006)"}, d2 = {"Lcom/cloud/tmc/ad/bean/DownUpPointBean;", "Lcom/cloud/tmc/kernel/model/BaseBean;", "downX", "", "downY", "upX", "upY", "imageH", "", "imageW", "(FFFFII)V", "getDownX", "()F", "setDownX", "(F)V", "getDownY", "setDownY", "getImageH", "()I", "setImageH", "(I)V", "getImageW", "setImageW", "getUpX", "setUpX", "getUpY", "setUpY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com.cloud.tmc.miniad"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class DownUpPointBean extends BaseBean {
    private float downX;
    private float downY;
    private int imageH;
    private int imageW;
    private float upX;
    private float upY;

    public DownUpPointBean() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 63, null);
    }

    public DownUpPointBean(float f, float f2, float f3, float f4, int i, int i2) {
        this.downX = f;
        this.downY = f2;
        this.upX = f3;
        this.upY = f4;
        this.imageH = i;
        this.imageW = i2;
    }

    public /* synthetic */ DownUpPointBean(float f, float f2, float f3, float f4, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f, (i3 & 2) != 0 ? 0.0f : f2, (i3 & 4) != 0 ? 0.0f : f3, (i3 & 8) == 0 ? f4 : 0.0f, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0 : i2);
    }

    public static /* synthetic */ DownUpPointBean copy$default(DownUpPointBean downUpPointBean, float f, float f2, float f3, float f4, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f = downUpPointBean.downX;
        }
        if ((i3 & 2) != 0) {
            f2 = downUpPointBean.downY;
        }
        float f8 = f2;
        if ((i3 & 4) != 0) {
            f3 = downUpPointBean.upX;
        }
        float f9 = f3;
        if ((i3 & 8) != 0) {
            f4 = downUpPointBean.upY;
        }
        float f10 = f4;
        if ((i3 & 16) != 0) {
            i = downUpPointBean.imageH;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = downUpPointBean.imageW;
        }
        return downUpPointBean.copy(f, f8, f9, f10, i4, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getDownX() {
        return this.downX;
    }

    /* renamed from: component2, reason: from getter */
    public final float getDownY() {
        return this.downY;
    }

    /* renamed from: component3, reason: from getter */
    public final float getUpX() {
        return this.upX;
    }

    /* renamed from: component4, reason: from getter */
    public final float getUpY() {
        return this.upY;
    }

    /* renamed from: component5, reason: from getter */
    public final int getImageH() {
        return this.imageH;
    }

    /* renamed from: component6, reason: from getter */
    public final int getImageW() {
        return this.imageW;
    }

    public final DownUpPointBean copy(float downX, float downY, float upX, float upY, int imageH, int imageW) {
        return new DownUpPointBean(downX, downY, upX, upY, imageH, imageW);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownUpPointBean)) {
            return false;
        }
        DownUpPointBean downUpPointBean = (DownUpPointBean) other;
        return Float.compare(this.downX, downUpPointBean.downX) == 0 && Float.compare(this.downY, downUpPointBean.downY) == 0 && Float.compare(this.upX, downUpPointBean.upX) == 0 && Float.compare(this.upY, downUpPointBean.upY) == 0 && this.imageH == downUpPointBean.imageH && this.imageW == downUpPointBean.imageW;
    }

    public final float getDownX() {
        return this.downX;
    }

    public final float getDownY() {
        return this.downY;
    }

    public final int getImageH() {
        return this.imageH;
    }

    public final int getImageW() {
        return this.imageW;
    }

    public final float getUpX() {
        return this.upX;
    }

    public final float getUpY() {
        return this.upY;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.downX) * 31) + Float.floatToIntBits(this.downY)) * 31) + Float.floatToIntBits(this.upX)) * 31) + Float.floatToIntBits(this.upY)) * 31) + this.imageH) * 31) + this.imageW;
    }

    public final void setDownX(float f) {
        this.downX = f;
    }

    public final void setDownY(float f) {
        this.downY = f;
    }

    public final void setImageH(int i) {
        this.imageH = i;
    }

    public final void setImageW(int i) {
        this.imageW = i;
    }

    public final void setUpX(float f) {
        this.upX = f;
    }

    public final void setUpY(float f) {
        this.upY = f;
    }

    public String toString() {
        return "DownUpPointBean(downX=" + this.downX + ", downY=" + this.downY + ", upX=" + this.upX + ", upY=" + this.upY + ", imageH=" + this.imageH + ", imageW=" + this.imageW + ")";
    }
}
