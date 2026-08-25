package com.cloud.hisavana.sdk.common.tracking;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class DownUpPointBean implements Parcelable {
    public static final Parcelable.Creator<DownUpPointBean> CREATOR = new a();
    private float downX;
    private float downY;
    private int imageH;
    private int imageW;
    private float upX;
    private float upY;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownUpPointBean createFromParcel(Parcel parcel) {
            return new DownUpPointBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownUpPointBean[] newArray(int i) {
            return new DownUpPointBean[i];
        }
    }

    public DownUpPointBean() {
    }

    public DownUpPointBean(float f, float f2, float f3, float f4, int i, int i2) {
        this.downX = f;
        this.downY = f2;
        this.upX = f3;
        this.upY = f4;
        this.imageH = i;
        this.imageW = i2;
    }

    protected DownUpPointBean(Parcel parcel) {
        this.downX = parcel.readFloat();
        this.downY = parcel.readFloat();
        this.upX = parcel.readFloat();
        this.upY = parcel.readFloat();
        this.imageH = parcel.readInt();
        this.imageW = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDownX() {
        return this.downX;
    }

    public float getDownY() {
        return this.downY;
    }

    public int getImageH() {
        return this.imageH;
    }

    public int getImageW() {
        return this.imageW;
    }

    public float getUpX() {
        return this.upX;
    }

    public float getUpY() {
        return this.upY;
    }

    public void setDownX(float f) {
        this.downX = f;
    }

    public void setDownY(float f) {
        this.downY = f;
    }

    public void setImageH(int i) {
        this.imageH = i;
    }

    public void setImageW(int i) {
        this.imageW = i;
    }

    public void setUpX(float f) {
        this.upX = f;
    }

    public void setUpY(float f) {
        this.upY = f;
    }

    public String toString() {
        return "DownUpPointBean{downX=" + this.downX + ", downY=" + this.downY + ", upX=" + this.upX + ", upY=" + this.upY + ", imageH=" + this.imageH + ", imageW=" + this.imageW + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.downX);
        parcel.writeFloat(this.downY);
        parcel.writeFloat(this.upX);
        parcel.writeFloat(this.upY);
        parcel.writeInt(this.imageH);
        parcel.writeInt(this.imageW);
    }
}
