package a1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {
    public static final Bitmap a(Drawable drawable, int i5, int i6, Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            }
            if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                return (i5 == bitmapDrawable.getBitmap().getWidth() && i6 == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i5, i6, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i7 = bounds.left;
        int i8 = bounds.top;
        int i9 = bounds.right;
        int i10 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i5, i6, config);
        drawable.setBounds(0, 0, i5, i6);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i7, i8, i9, i10);
        return createBitmap;
    }

    public static final Bitmap b(Drawable drawable, int i5, int i6, Bitmap.Config config) {
        if ((drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null) {
            return null;
        }
        return a(drawable, i5, i6, config);
    }

    public static /* synthetic */ Bitmap c(Drawable drawable, int i5, int i6, Bitmap.Config config, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = drawable.getIntrinsicWidth();
        }
        if ((i7 & 2) != 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        if ((i7 & 4) != 0) {
            config = null;
        }
        return b(drawable, i5, i6, config);
    }
}
