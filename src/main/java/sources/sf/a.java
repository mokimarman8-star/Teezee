package sf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a extends BitmapTransformation {

    /* renamed from: a, reason: collision with root package name */
    private final int f17810a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17811b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17812c;

    public a() {
        this(25, 1);
    }

    public a(int i5, int i6) {
        this.f17812c = false;
        this.f17810a = i5;
        this.f17811b = i6;
    }

    public a(int i5, int i6, boolean z5) {
        this.f17810a = i5;
        this.f17811b = i6;
        this.f17812c = z5;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.f17810a == this.f17810a && aVar.f17811b == this.f17811b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return 589067571 + (this.f17810a * 1000) + (this.f17811b * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.f17810a + ", sampling=" + this.f17811b + ")";
    }

    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i5, int i6) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i7 = this.f17811b;
        Bitmap bitmap2 = bitmapPool.get(width / i7, height / i7, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        int i8 = this.f17811b;
        canvas.scale(1.0f / i8, 1.0f / i8);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return this.f17812c ? b.a(bitmap2, this.f17810a, true) : ImageUtils.a(bitmap2, 1.0f, this.f17810a);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("BlurTransformation.1" + this.f17810a + this.f17811b).getBytes(Key.CHARSET));
    }
}
