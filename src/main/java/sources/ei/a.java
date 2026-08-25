package ei;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a extends BitmapTransformation {
    private final int a;
    private final int b;
    private boolean c;

    public a() {
        this(25, 1);
    }

    public a(int i) {
        this(i, 1);
    }

    public a(int i, int i2) {
        this.c = false;
        this.a = i;
        this.b = i2;
    }

    public a(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.a == this.a && aVar.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return 589067571 + (this.a * 1000) + (this.b * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.a + ", sampling=" + this.b + ")";
    }

    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.b;
        Bitmap bitmap2 = bitmapPool.get(width / i3, height / i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        int i4 = this.b;
        canvas.scale(1.0f / i4, 1.0f / i4);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return this.c ? b.a(bitmap2, this.a, true) : ImageUtils.a(bitmap2, 1.0f, this.a);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("BlurTransformation.1" + this.a + this.b).getBytes(Key.CHARSET));
    }
}
