package af;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class r {
    private n a;
    private int b;
    private int c;
    private Rect d;
    private int e = 1;
    private boolean f;

    public r(byte[] bArr, int i, int i2, int i3, int i4) {
        this.a = new n(bArr, i, i2);
        this.c = i4;
        this.b = i3;
        if (i * i2 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i + "x" + i2 + " > " + bArr.length);
    }

    public com.google.zxing.h a() {
        n a = this.a.h(this.c).a(this.d, this.e);
        return new com.google.zxing.h(a.b(), a.d(), a.c(), 0, 0, a.d(), a.c(), false);
    }

    public Bitmap b(Rect rect, int i) {
        if (rect == null) {
            rect = new Rect(0, 0, this.a.d(), this.a.c());
        } else if (c()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.a.b(), this.b, this.a.d(), this.a.c(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.c == 0) {
            return decodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.c);
        return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
    }

    public boolean c() {
        return this.c % 180 != 0;
    }

    public void d(Rect rect) {
        this.d = rect;
    }

    public void e(boolean z) {
        this.f = z;
    }

    public com.google.zxing.k f(com.google.zxing.k kVar) {
        float c = (kVar.c() * this.e) + this.d.left;
        float d = (kVar.d() * this.e) + this.d.top;
        if (this.f) {
            c = this.a.d() - c;
        }
        return new com.google.zxing.k(c, d);
    }
}
