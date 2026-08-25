package com.transsion.compressor.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b {
    private final File a;
    private final d b;
    private int c;
    private int d;
    private final boolean e;

    b(d dVar, File file, boolean z) {
        this.a = file;
        this.b = dVar;
        this.e = z;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(dVar.open(), null, options);
        this.c = options.outWidth;
        this.d = options.outHeight;
    }

    private int b() {
        int i = this.c;
        if (i % 2 == 1) {
            i++;
        }
        this.c = i;
        int i2 = this.d;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.d = i2;
        int max = Math.max(i, i2);
        float min = Math.min(this.c, this.d) / max;
        if (min > 1.0f || min <= 0.5625d) {
            double d = min;
            if (d > 0.5625d || d <= 0.5d) {
                return (int) Math.ceil(max / (1280.0d / d));
            }
            int i3 = max / 1280;
            if (i3 == 0) {
                return 1;
            }
            return i3;
        }
        if (max < 1664) {
            return 1;
        }
        if (max < 4990) {
            return 2;
        }
        if (max <= 4990 || max >= 10240) {
            return max / 1280;
        }
        return 4;
    }

    private Bitmap c(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    File a() {
        Throwable th2;
        FileOutputStream fileOutputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b();
        Bitmap decodeStream = BitmapFactory.decodeStream(this.b.open(), null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Checker checker = Checker.SINGLE;
        if (checker.isJpg(this.b.open())) {
            decodeStream = c(decodeStream, checker.getOrientation(this.b.open()));
        }
        decodeStream.compress(Bitmap.CompressFormat.WEBP, 70, byteArrayOutputStream);
        decodeStream.recycle();
        try {
            fileOutputStream = new FileOutputStream(this.a);
            try {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                byteArrayOutputStream.close();
                return this.a;
            } catch (Throwable th3) {
                th2 = th3;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                byteArrayOutputStream.close();
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            fileOutputStream = null;
        }
    }
}
