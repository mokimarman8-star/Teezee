package com.bytedance.sdk.component.HiB.TKC.sP;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    public static final ImageView.ScaleType Sj = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config sP = Bitmap.Config.ARGB_4444;
    private final ImageView.ScaleType Dq;
    private int EjP;
    private int HiB;
    private final int Jcg;
    private final Bitmap.Config TKC;
    private final int vS;
    private final int uA = 3840;
    private final int TEQ = 104857600;

    public Sj(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.TKC = config;
        this.EjP = i;
        this.HiB = i2;
        this.Dq = scaleType;
        this.vS = i3;
        this.Jcg = i4;
        Sj(i, i2);
    }

    static int Sj(int i, int i2, int i3, int i4, int i8, int i9) {
        double min = Math.min(i / i3, i2 / i4);
        if (i8 > 0 && i9 > 0) {
            min = Math.max(min, Math.min(Math.max(i, i2) / Math.max(i8, i9), Math.min(i, i2) / Math.min(i8, i9)));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int Sj(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (i3 * (i2 / i4));
        }
        if (i2 == 0) {
            return i;
        }
        double d = i4 / i3;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    private void Sj(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.EjP = 3840;
                this.HiB = (i2 * 3840) / i;
                return;
            } else {
                this.EjP = (i * 3840) / i2;
                this.HiB = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.EjP = 3840;
            this.HiB = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.EjP = (i * 3840) / i2;
            this.HiB = 3840;
        }
    }

    public Bitmap Sj(byte[] bArr) {
        Bitmap decodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.EjP == 0 && this.HiB == 0) {
            options.inPreferredConfig = this.TKC;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int Sj2 = Sj(this.EjP, this.HiB, i, i2, this.Dq);
            int Sj3 = Sj(this.HiB, this.EjP, i2, i, this.Dq);
            options.inJustDecodeBounds = false;
            options.inSampleSize = Sj(i, i2, Sj2, Sj3, this.vS, this.Jcg);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > Sj2 || decodeByteArray.getHeight() > Sj3)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, Sj2, Sj3, true);
                if (createScaledBitmap != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                decodeByteArray = createScaledBitmap;
            }
        }
        if (decodeByteArray != null && decodeByteArray.getByteCount() > 104857600) {
            int width = decodeByteArray.getWidth() / 2;
            int height = decodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeByteArray, width, height, true);
                if (createScaledBitmap2 != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                return createScaledBitmap2;
            }
        }
        return decodeByteArray;
    }
}
